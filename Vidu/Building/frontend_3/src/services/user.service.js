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
    return axios.post(API_URL + "session", { data: "2", sessionName: "24" });
  }

  getAdminBoard() {
    return axios.get(API_URL + "admin", { headers: authHeader() });
  }
}

export default new UserService();
