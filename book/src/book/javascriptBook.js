import axios from "axios";
import React, { Component } from "react";
import Footer from "../pages/footer";
import Header from "../pages/header";
const URL = "http://localhost:3000/javascript/";

export default class JavascriptBook extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoaded: false,
      title: null,
      author: null,
      description: null,
      src: null,
    };
    console.log(props);
  }

  componentDidMount = () => {
    const { id } = this.props.match.params;
    axios.get(URL + id).then((response) => {
      const javascript = response.data;
      console.log(javascript);
      this.setState({
        title: javascript.title,
        author: javascript.author,
        description: javascript.description,
        src: javascript.src,
        isLoaded: true,
      });
    });
  };

  render() {
    const title = this.state.title;
    const author = this.state.author;
    const description = this.state.description;
    const src = this.state.src;
    return (
      <div>
        <Header />
        {this.state.isLoaded && (
          <div className="detail">
            <h2>{title}</h2>

            <img src={src} className="detail_image" alt="" />
            <div className="detail_text">
              <i>By: {author}</i>
              <p>{description}</p>
            </div>
          </div>
        )}
        <Footer />
      </div>
    );
  }
}
