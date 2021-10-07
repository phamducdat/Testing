import axios from "axios";
import React, { Component } from "react";
import Footer from "./footer";
import Header from "./header";
import ListCssBook from "./listCssBooks";

const URL = "http://localhost:3000/css/";

class CSS extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: [],
      src: [],
      isLoaded: false,
    };
  }

  componentDidMount() {
    axios.get(URL).then((response) => {
      const css = response.data;
      for (let i = 0; i < css.length; ++i) {
        this.state.id.push(css[i].id);
        this.state.src.push(css[i].src);
        this.setState({
          id: this.state.id,
          src: this.state.src,
          isLoaded: true,
        });
      }
    });
  }

  render() {
    const id = this.state.id;
    const src = this.state.src;
    console.log("Id = " + id);
    let result = [];

    for (let i = 0; i < id.length; ++i) {
      result.push(
        <span key={i}>
          <ListCssBook id={`${id[i]}`} src={`${src[i]}`} />
        </span>
      );
    }

    console.log("result = " + result);
    return (
      <div>
        <Header />
        <h1 style={{ marginLeft: 75 }}>CSS</h1>
        <div className="container">{result}</div>
        <Footer />
      </div>
    );
  }
}

export default CSS;
