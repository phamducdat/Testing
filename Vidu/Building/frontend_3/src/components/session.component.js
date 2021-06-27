import OpenViduSession from "openvidu-react";
import React, { Component } from "react";
import UserService from "../services/user.service";

export default class Session extends Component {
  constructor(props) {
    super(props);

    this.state = {
      mySessionId: "SessionA",
      myUserName: "OpenVidu_User_24",
      token: undefined,
    };
  }

  componentDidMount() {
    UserService.getSession(this.state.myUserName, this.state.myUserName).then(
      (response) => {
        console.log("token in componentDidMount = " + response.data.token);
        this.setState({
          token: response.data.token,
        });
      },
      (error) => {
        this.setState({
          content:
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString(),
        });
      }
    );
  }

  render() {
    const mySessionId = this.state.mySessionId;
    const myUserName = this.state.myUserName;
    const token = this.state.token;
    // console.log("token in getToken = " + this.joinSession);
    console.log("token = " + token);
    console.log("mySessionId = " + mySessionId);
    console.log("myUserName = " + myUserName);
    return (
      <div id="session">
        <OpenViduSession
          id="opv-session"
          sessionName={mySessionId}
          user={myUserName}
          token={token}
          joinSession={this.handlerJoinSessionEvent}
          // leaveSession={this.handlerLeaveSessionEvent}
          //   error={this.handlerErrorEvent}
        />
      </div>
    );
  }

  getToken() {
    UserService.getSession(this.state.myUserName, this.state.mySessionId).then(
      (response) => {
        return response.data.token;
      }
    );
  }
}
