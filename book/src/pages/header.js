import React from "react";
import { NavLink } from "react-router-dom";
import logo from "../logo.png";
const Header = (props) => {
  return (
    <nav>
      <div className="header_text">
        <NavLink to="/javascript/book" exact>
          Javascript
        </NavLink>
        <NavLink to="/css/book" exact>
          CSS
        </NavLink>
        <NavLink to="/html/book" exact>
          HTML
        </NavLink>
      </div>
      <img src={logo} className="logo" alt="logo" />
    </nav>
  );
};

export default Header;
