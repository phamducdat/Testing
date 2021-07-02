import OpenViduSession from "openvidu-react";
import React, { Component } from "react";

export default class Session extends Component {
  constructor(props) {
    super(props);

    this.state = {
      mySessionId: "SessionA",
      myUserName: "OpenVidu_User_" + Math.floor(Math.random() * 100),
      token: undefined,
    };

    this.handlerJoinSessionEvent = this.handlerJoinSessionEvent.bind(this);
    this.handlerLeaveSessionEvent = this.handlerLeaveSessionEvent.bind(this);
    this.handlerErrorEvent = this.handlerErrorEvent.bind(this);
    this.handleChangeSessionId = this.handleChangeSessionId.bind(this);
    this.handleChangeUserName = this.handleChangeUserName.bind(this);
    // this.joinSession = this.joinSession.bind(this);
  }

  // componentDidMount() {
  //   UserService.getSession(this.state.myUserName, this.state.myUserName).then(
  //     (response) => {
  //       console.log("token in componentDidMount = " + response.data.token);
  //       this.setState({
  //         token: response.data.token,
  //         session: true,
  //       });
  //     },
  //     (error) => {
  //       this.setState({
  //         content:
  //           (error.response &&
  //             error.response.data &&
  //             error.response.data.message) ||
  //           error.message ||
  //           error.toString(),
  //       });
  //     }
  //   );
  // }
  handlerJoinSessionEvent() {
    console.log("Join session");
  }

  handlerLeaveSessionEvent() {
    console.log("Leave session");
    this.setState({
      session: undefined,
    });
  }

  handlerErrorEvent() {
    console.log("Leave session");
  }

  handleChangeSessionId(e) {
    this.setState({
      mySessionId: e.target.value,
    });
  }

  handleChangeUserName(e) {
    this.setState({
      myUserName: e.target.value,
    });
  }

  // joinSession(e) {
  //   this.setState({
  //     session: true,
  //   });
  //   UserService.getSession(this.state.myUserName, this.state.mySessionId).then(
  //     (response) => {
  //       console.log("token in componentDidMount = " + response.data.token);
  //       this.setState({
  //         token: response.data.token,
  //         session: true,
  //       });
  //     },
  //     (error) => {
  //       this.setState({
  //         content:
  //           (error.response &&
  //             error.response.data &&
  //             error.response.data.message) ||
  //           error.message ||
  //           error.toString(),
  //       });
  //     }
  //   );
  // }

  render() {
    const mySessionId = this.state.mySessionId;
    const myUserName = this.state.myUserName;
    const token = this.state.token;
    // console.log("token in getToken = " + this.joinSession);
    console.log("token = " + token);
    console.log("mySessionId = " + mySessionId);
    console.log("myUserName = " + myUserName);
    console.log("session = " + this.state.session);
    return (
      <div>
        {this.state.mySessionId === undefined ? (
          <div id="join">
            <div id="join-dialog">
              <h1> Join a video session </h1>
              <form onSubmit={this.joinSession}>
                <p>
                  <label>Participant: </label>
                  <input
                    type="text"
                    id="userName"
                    value={myUserName}
                    onChange={this.handleChangeUserName}
                    required
                  />
                </p>
                <p>
                  <label> Session: </label>
                  <input
                    type="text"
                    id="sessionId"
                    value={mySessionId}
                    onChange={this.handleChangeSessionId}
                    required
                  />
                </p>
                <p>
                  <input name="commit" type="submit" value="JOIN" />
                </p>
              </form>
            </div>
          </div>
        ) : (
          <div id="session">
            <OpenViduSession
              id="opv-session"
              sessionName={mySessionId}
              user={myUserName}
              token={token}
              joinSession={this.handlerJoinSessionEvent}
              leaveSession={this.handlerLeaveSessionEvent}
              error={this.handlerErrorEvent}
            />
          </div>
        )}
      </div>
    );
  }

  // getToken() {
  //   UserService.getSession(this.state.myUserName, this.state.myUserName).then(
  //     (response) => {
  //       console.log("token in componentDidMount = " + response.data.token);
  //       return response.data.token;
  //     },
  //     (error) => {
  //       this.setState({
  //         content:
  //           (error.response &&
  //             error.response.data &&
  //             error.response.data.message) ||
  //           error.message ||
  //           error.toString(),
  //       });
  //     }
  //   );
  // }
}
