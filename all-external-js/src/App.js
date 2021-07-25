import React, { Component } from "react";
import "./App.css";

class App extends Component {
  // componentDidMount() {
  //   window.test();
  // }

  // componentDidMount() {
  //   const script = document.createElement("script");
  //   script.async = true;
  //   script.src = "https://some-scripturl.js";
  //   this.div.appendChild(script);
  // }

  howItWorks = () => {
    // console.log("hello dat");
    window.name = "kkkkkkkkkkkkk";
    window.test();
  };
  render() {
    console.log("Get in render");
    return (
      <div className="App">
        <button onClick={this.howItWorks} type="button" className="btn">
          How it Works
        </button>
      </div>
    );

    // return (
    //   <div className="App" ref={(el) => (this.div = el)}>
    //     {" "}
    //     <h1>Hello react</h1>
    //     {
    //     alert("Function from index.html")
    //     }
    //   </div>
    // );
  }
}

export default App;
