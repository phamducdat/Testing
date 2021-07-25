import axios from "axios";

const API_URL = "https://localhost:8080/";

class UserService {
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
