import axios from "axios";

const API_URL = "https://localhost:8080/";

class AuthService {
  login(username, password) {
    console.log("user = " + username + " pass =" + password);
    return axios
      .post(API_URL + "dashboard", {
        username,
        password,
      })
      .then((response) => {
        if (response.data.accessToken) {
          localStorage.setItem("user", JSON.stringify(response.data));
          console.log("response = " + JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  logout() {
    return axios.post(API_URL + "/logout");
  }

  register(username, email, password) {
    return axios.post(API_URL + "signup", {
      username,
      email,
      password,
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem("user"));
  }
}

export default new AuthService();
