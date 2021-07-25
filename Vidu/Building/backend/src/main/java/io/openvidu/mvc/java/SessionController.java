package io.openvidu.mvc.java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.google.gson.JsonObject;
import io.openvidu.java.client.*;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class SessionController {
	// docker run -p 4443:4443 --rm -e OPENVIDU_SECRET=MY_SECRET openvidu/openvidu-server-kms:2.17.0
	// docker run -d -p 80:80 docker/getting-started

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

//	@RequestMapping(value = "/session", method = RequestMethod.POST)
//	public ResponseEntity<?> joinSession(@Valid @RequestBody SessionInput sessionInput) {
//
////		ModelDAO modelDAO = new ModelDAO("24", "wss://localhost:4443?sessionId=ses_TKrgSWOrjI&token=tok_ReBSJWvuXzqZNXXO",
////				"2", "publisher1");
////		return ResponseEntity.ok(modelDAO);
//		System.out.println();
//		System.out.println("Get in joinSession");
////		System.out.println("Id of httpSession = " + httpSession.getId());
//		String clientData = sessionInput.getData();
//		String sessionName = sessionInput.getSessionName();
//		System.out.println("clientData = " + clientData);
//		System.out.println("sessionName = " + sessionName);
//
//		System.out.println("Getting sessionId and token | {sessionName}=" +
//				"{" + sessionName + "}");
//
//
//		String attribute = "publisher1";
//
//		OpenViduRole role = LoginController.users.get(attribute).role;
//
//		String serverData = "{\"serverData\": \"" +
//				attribute + "\"}";
//		ConnectionProperties connectionProperties = new ConnectionProperties
//				.Builder().type(ConnectionType.WEBRTC)
//				.role(role).data(serverData).build();
//
//		if (this.mapSessions.get(sessionName) != null) {
//			System.out.println("Existing session " + sessionName);
//			try {
//				System.out.println("get in try");
//				String token = this.mapSessions.get(sessionName).createConnection(connectionProperties)
//						.getToken();
//				System.out.println("get out + " + token);
//				this.mapSessionNamesTokens.get(sessionName).put(token, role);
//				System.out.println("token = " + token);
//				ModelDAO modelDAO = new ModelDAO(sessionName, token, clientData, attribute
//				,null, null, null, "con_LCqpy3ZypO"
//				, "1626534264126","con_LCqpy3ZypO",null, null
//				,null, "connection",null, null
//				,null, true, "PUBLISHER", null, "",
//						"SessionA","pending",null,"WEBRTC");
//
//				System.out.println("this.mapSessions.get(sessionName) != null " + modelDAO.toString());
//				return ResponseEntity.ok(modelDAO);
////				return ResponseEntity.ok("Okkkkkkkkkkkkkk");
//			} catch (Exception e) {
//				e.printStackTrace();
//				return ResponseEntity.ok("Failed in join session");
//			}
//		} else {
//			System.out.println("New session " + sessionName);
//			try {
//				Session session = this.openVidu.createSession();
//				String token = session.createConnection(connectionProperties).getToken();
//
//				this.mapSessions.put(sessionName, session);
//				this.mapSessionNamesTokens.put(sessionName, new ConcurrentHashMap<>());
//				this.mapSessionNamesTokens.get(sessionName).put(token, role);
//				System.out.println("token = " + token);
//				ModelDAO modelDAO = new ModelDAO(sessionName, token, clientData, attribute
//						,null, null, null, "con_LCqpy3ZypO"
//						, "1626534264126","con_LCqpy3ZypO",null, null
//						,null, "connection",null, null
//						,null, true, "PUBLISHER", null, "",
//						"SessionA","pending",null,"WEBRTC");
//				System.out.println("this.mapSessions.get(sessionName) == null " + modelDAO.toString());
//				return ResponseEntity.ok(modelDAO);
////				return ResponseEntity.ok("Okkkkkkkkkkkkkk_2");
//
//			} catch (Exception e) {
//				return ResponseEntity.ok("Failed in create new session");
//			}
//		}
//	}

	@RequestMapping(value = "get-sessionId", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getSessionId(@RequestBody String sessionNameParam) throws ParseException {
		System.out.println("Getting a token from OpenVidu Server | {sessionName}=" + sessionNameParam);

		JSONObject sessionJSON = (JSONObject) new JSONParser().parse(sessionNameParam);

		String sessionName = (String) sessionJSON.get("sessionName");

		String attribute = "publisher1";

		OpenViduRole role = LoginController.users.get(attribute).role;

		String serverData = "{\"serverData\": \"" + attribute + "\"}";

		ConnectionProperties connectionProperties = new ConnectionProperties.Builder().type(ConnectionType.WEBRTC).data(serverData).role(role).build();

		JSONObject responseJson = new JSONObject();

		if (this.mapSessions.get(sessionName) != null) {
			// Session already exists
			System.out.println("Existing session " + sessionName);
			String sessionId = this.mapSessions.get(sessionName).getSessionId();
			responseJson.put("token", sessionId);
			System.out.println("sessionId = " + sessionId);


			// Return the response to the client
			return new ResponseEntity<>(responseJson, HttpStatus.OK);
		}

		// New session
		System.out.println("New session " + sessionName);
		try {

			// Create a new OpenVidu Session
			Session session = this.openVidu.createSession();
			// Generate a new Connection with the recently created connectionProperties
			String token = session.createConnection(connectionProperties).getToken();

			// Store the session and the token in our collections
			this.mapSessions.put(sessionName, session);
			this.mapSessionNamesTokens.put(sessionName, new ConcurrentHashMap<>());
			this.mapSessionNamesTokens.get(sessionName).put(token, role);

			// Prepare the response with the token
			responseJson.put("token", token);
			System.out.println("sessionId = " + session.getSessionId());

			// Return the response to the client
			return new ResponseEntity<>(responseJson, HttpStatus.OK);

		} catch (Exception e) {
			// If error generate an error message and return it to client
			return getErrorResponse(e);
		}

	}

//	@CrossOrigin
//	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "get-token", method = RequestMethod.POST)
	public ResponseEntity<?> getToken(@RequestBody String sessionNameParam) throws ParseException {
		System.out.println("Get in");
		System.out.println("Getting a token from OpenVidu Server | {sessionName}=" + sessionNameParam);

		JSONObject sessionJSON = (JSONObject) new JSONParser().parse(sessionNameParam);

		String sessionName = (String) sessionJSON.get("sessionName");

		String attribute = "publisher1";

		OpenViduRole role = LoginController.users.get(attribute).role;

		String serverData = "{\"serverData\": \"" + attribute + "\"}";

		ConnectionProperties connectionProperties = new ConnectionProperties.Builder().type(ConnectionType.WEBRTC).data(serverData).role(role).build();

		JSONObject responseJson = new JSONObject();

		if (this.mapSessions.get(sessionName) != null) {
			// Session already exists
			System.out.println("Existing session " + sessionName);
			try {

				// Generate a new Connection with the recently created connectionProperties
				String token = this.mapSessions.get(sessionName).createConnection(connectionProperties).getToken();

				// Update our collection storing the new token
				this.mapSessionNamesTokens.get(sessionName).put(token, role);

				// Prepare the response with the token
				responseJson.put("token", token);
//				System.out.println("sessionId = " + this.mapSessions.get(sessionName).getSessionId());
//				JsonObject jsonObject = connectionProperties.toJson(this.mapSessions.get(sessionName).getSessionId());
//				jsonObject.addProperty("tok");
//				jsonObject.addProperty("token", token);

//				System.out.println(connectionProperties.toJson(this.mapSessions.get(sessionName).getSessionId()));

				// Return the response to the client
				return new ResponseEntity<>(responseJson, HttpStatus.OK);
//				return new ResponseEntity<>(connectionProperties.toJson(this.mapSessions.get(sessionName).getSessionId()).toString(), HttpStatus.OK);
			} catch (OpenViduJavaClientException e1) {
				// If internal error generate an error message and return it to client
				return getErrorResponse(e1);
			} catch (OpenViduHttpException e2) {
				if (404 == e2.getStatus()) {
					// Invalid sessionId (user left unexpectedly). Session object is not valid
					// anymore. Clean collections and continue as new session
					this.mapSessions.remove(sessionName);
					this.mapSessionNamesTokens.remove(sessionName);
				}
			}
		}

		// New session
		System.out.println("New session " + sessionName);
		try {

			// Create a new OpenVidu Session
			Session session = this.openVidu.createSession();
			// Generate a new Connection with the recently created connectionProperties
			String token = session.createConnection(connectionProperties).getToken();

			// Store the session and the token in our collections
			this.mapSessions.put(sessionName, session);
			this.mapSessionNamesTokens.put(sessionName, new ConcurrentHashMap<>());
			this.mapSessionNamesTokens.get(sessionName).put(token, role);

			// Prepare the response with the token
			responseJson.put("token", token);
//			responseJson.put("clientData","dat");
//			System.out.println("sessionId = " + session.getSessionId());
//			JsonObject jsonObject = connectionProperties.toJson(this.mapSessions.get(sessionName).getSessionId());
//				jsonObject.addProperty("tok");
//			jsonObject.addProperty("token", token);
//			System.out.println(connectionProperties.toJson(this.mapSessions.get(sessionName).getSessionId()));

			// Return the response to the client
			return new ResponseEntity<>(responseJson, HttpStatus.OK);
//			return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);

		} catch (Exception e) {
			// If error generate an error message and return it to client
			return getErrorResponse(e);
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

	private ResponseEntity<JSONObject> getErrorResponse(Exception e) {
		JSONObject json = new JSONObject();
		json.put("cause", e.getCause());
		json.put("error", e.getMessage());
		json.put("exception", e.getClass());
		return new ResponseEntity<>(json, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
