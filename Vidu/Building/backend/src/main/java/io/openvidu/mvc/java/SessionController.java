package io.openvidu.mvc.java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import io.openvidu.java.client.ConnectionProperties;
import io.openvidu.java.client.ConnectionType;
import io.openvidu.java.client.OpenVidu;
import io.openvidu.java.client.OpenViduRole;
import io.openvidu.java.client.Session;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class SessionController {

	// OpenVidu object as entrypoint of the SDK
	private OpenVidu openVidu;

	// Collection to pair session names and OpenVidu Session objects
	private Map<String, Session> mapSessions = new ConcurrentHashMap<>();
	// Collection to pair session names and tokens (the inner Map pairs tokens and
	// role associated)
	private Map<String, Map<String, OpenViduRole>> mapSessionNamesTokens = new ConcurrentHashMap<>();

	// URL where our OpenVidu server is listening
	private String OPENVIDU_URL;
	// Secret shared with our OpenVidu server
	private String SECRET;

	public SessionController(@Value("${openvidu.secret}") String secret,
							 @Value("${openvidu.url}") String openviduUrl) {
		this.SECRET = secret;
		this.OPENVIDU_URL = openviduUrl;
		this.openVidu = new OpenVidu(OPENVIDU_URL, SECRET);
	}

	@RequestMapping(value = "/session", method = RequestMethod.POST)
	public String joinSession(@Valid @RequestBody SessionInput sessionInput,
							  Model model, HttpSession httpSession) {

		System.out.println("Get in joinSession");
		System.out.println("Id of httpSession = " + httpSession.getId());
		String clientData = sessionInput.getData();
		String sessionName = sessionInput.getSessionName();
		System.out.println("clientData = " + clientData);
		System.out.println("sessionName = " + sessionName);
		try {
			checkUserLogged(httpSession);
		} catch (Exception e) {
			return "index";
		}
		System.out.println("Getting sessionId and token | {sessionName}=" +
				"{" + sessionName + "}");


		OpenViduRole role =
				LoginController.users.get(httpSession.getAttribute("loggedUser")).role;

		String serverData = "{\"serverData\": \"" +
				httpSession.getAttribute("loggedUser") + "\"}";

		// Build connectionProperties object with the serverData and the role
		ConnectionProperties connectionProperties = new ConnectionProperties
				.Builder().type(ConnectionType.WEBRTC)
				.role(role).data(serverData).build();

		if (this.mapSessions.get(sessionName) != null) {
			// Session already exists
			System.out.println("Existing session " + sessionName);
			try {

				// Generate a new token with the recently created connectionProperties
				String token = this.mapSessions.get(sessionName).createConnection(connectionProperties)
						.getToken();


				this.mapSessionNamesTokens.get(sessionName).put(token, role);

				model.addAttribute("sessionName", sessionName);
				model.addAttribute("token", token);
				model.addAttribute("nickName", clientData);
				model.addAttribute("userName", httpSession.getAttribute("loggedUser"));
				System.out.println("this.mapSessions.get(sessionName) != null " + model.toString());

				return "session";

			} catch (Exception e) {
				return "dashboard";
			}
		} else {

			System.out.println("New session " + sessionName);
			try {

				Session session = this.openVidu.createSession();
				String token = session.createConnection(connectionProperties).getToken();


				this.mapSessions.put(sessionName, session);
				this.mapSessionNamesTokens.put(sessionName, new ConcurrentHashMap<>());
				this.mapSessionNamesTokens.get(sessionName).put(token, role);

				model.addAttribute("sessionName", sessionName);
				model.addAttribute("token", token);
				model.addAttribute("nickName", clientData);
				model.addAttribute("userName", httpSession.getAttribute("loggedUser"));
				System.out.println("this.mapSessions.get(sessionName) == null " + model.toString());
				return "session";

			} catch (Exception e) {
				return "dashboard";
			}
		}
	}

	@RequestMapping(value = "/leave-session", method = RequestMethod.POST)
	public String removeUser(@RequestParam(name = "session-name") String sessionName,
			@RequestParam(name = "token") String token, Model model, HttpSession httpSession) throws Exception {

		try {
			checkUserLogged(httpSession);
		} catch (Exception e) {
			return "index";
		}
		System.out.println("Removing user | sessioName=" + sessionName + ", token=" + token);

		// If the session exists ("TUTORIAL" in this case)
		if (this.mapSessions.get(sessionName) != null &&
				this.mapSessionNamesTokens.get(sessionName) != null) {

			// If the token exists
			if (this.mapSessionNamesTokens.get(sessionName).remove(token) != null) {
				// User left the session
				if (this.mapSessionNamesTokens.get(sessionName).isEmpty()) {
					// Last user left: session must be removed
					this.mapSessions.remove(sessionName);
				}
				return "redirect:/dashboard";

			} else {
				// The TOKEN wasn't valid
				System.out.println("Problems in the app server: the TOKEN wasn't valid");
				return "redirect:/dashboard";
			}

		} else {
			// The SESSION does not exist
			System.out.println("Problems in the app server: the SESSION does not exist");
			return "redirect:/dashboard";
		}
	}

	private void checkUserLogged(HttpSession httpSession) throws Exception {
		if (httpSession == null || httpSession.getAttribute("loggedUser") == null) {
			throw new Exception("User not logged");
		}
	}

}
