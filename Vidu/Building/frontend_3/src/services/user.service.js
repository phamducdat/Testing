import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "https://localhost:8080/";

class UserService {
  getPublicContent() {
    return axios.get(API_URL + "admin", { headers: authHeader() });
  }

  getUserBoard(data, sessionName) {
    return axios.get(API_URL + "admin", { headers: authHeader() });
  }
  getModeratorBoard() {
    return axios.get(API_URL + "admin", { headers: authHeader() });
  }

  getAdminBoard() {
    return axios.get(API_URL + "admin", { headers: authHeader() });
  }

  // getSession(data, sessionName) {
  //   console.log("data = " + data, "session = " + sessionName);
  //   return axios.post(API_URL + "session", {
  //     data: data,
  //     sessionName: sessionName,
  //   });
  // }

  getSession(sessionName) {
    console.log("session = " + sessionName);
    return axios.post(API_URL + "get-token", {
      // data: data,
      sessionName: sessionName,
    });
  }
}

export default new UserService();
