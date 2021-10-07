import React, { Component } from "react";
import { NavLink } from "react-router-dom";

export default class ListHtmlBook extends Component {
  constructor(props) {
    super(props);

    this.state = {
      id: props.id,
      src: props.src,
    };
  }

  render() {
    const id = this.state.id;
    const src = this.state.src;
    return (
      <div>
        <NavLink to={`/html/book/${id}`} exact>
          <div className="image">
            <img src={src} alt="images" />
            <div class="image__overlay">
              <div class="image__text">Detail</div>
            </div>
          </div>
        </NavLink>
      </div>
    );
  }
}
