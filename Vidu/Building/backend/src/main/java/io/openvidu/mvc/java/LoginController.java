package io.openvidu.mvc.java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import io.openvidu.java.client.OpenViduRole;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

	public class MyUser {

		String name;
		String pass;
		OpenViduRole role;

		public MyUser(String name, String pass, OpenViduRole role) {
			this.name = name;
			this.pass = pass;
			this.role = role;
		}
	}

	public static Map<String, MyUser> users = new ConcurrentHashMap<>();

	public LoginController() {
		users.put("publisher1", new MyUser("publisher1", "pass", OpenViduRole.PUBLISHER));
		users.put("publisher2", new MyUser("publisher2", "pass", OpenViduRole.PUBLISHER));
		users.put("subscriber", new MyUser("subscriber", "pass", OpenViduRole.SUBSCRIBER));
	}

	@RequestMapping(value = "/")
	public String logout(HttpSession httpSession) {
		System.out.println(httpSession.getAttribute("email"));
//		System.out.println("Get in");
		if (checkUserLogged(httpSession)) {
//			System.out.println("If");
			return "redirect:/dashboard";
		} else {
//			System.out.println("else");
			httpSession.invalidate();
			return "index";
		}
	}



//	@RequestMapping(value = "/dashboard", method = { RequestMethod.GET, RequestMethod.POST })
	@PostMapping("/dashboard")
	public ResponseEntity login(@Valid @RequestBody LoginRequest loginRequest, Model model,
								HttpSession httpSession) {
		System.out.println("Get in dashboard");
		System.out.println("Ip of httpSession = " + httpSession.getId());
		String user = loginRequest.getUsername();
		String pass = loginRequest.getPassword();
		System.out.println("user = " + user);
		String userName = (String) httpSession.getAttribute("loggedUser");
		if (userName != null) {
			return ResponseEntity.ok("go to dashboard");
		}
		if (login(user, pass)) {
			httpSession.setAttribute("loggedUser", user);
			System.out.println(httpSession.getAttribute("loggedUser"));
			return ResponseEntity.ok("You has logged");

		} else {
			httpSession.invalidate();
			return ResponseEntity.ok("Failed to login by username or password");
		}
//		return ResponseEntity.ok(httpSession);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity logout(Model model, HttpSession httpSession) {
		httpSession.invalidate();
		System.out.println("Get in Logout");
		return ResponseEntity.ok("You logout");
	}

	private boolean login(String user, String pass) {
		return (user != null
				&& pass != null
				&& users.containsKey(user)
				&& users.get(user).pass.equals(pass));
	}

	private boolean checkUserLogged(HttpSession httpSession) {
		return !(httpSession == null
				|| httpSession.getAttribute("loggedUser") == null);
	}
}