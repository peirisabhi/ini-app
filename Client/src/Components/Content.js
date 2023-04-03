import React from "react";
import "./Content.css";
import HOMEBODYIMG from "../Components/images/content.png";

function Content() {
  return (
    <div className="header__container">
      <div className="header__text">
      <h1>BUMBLEBEE</h1>
        <br />
        <h2>"Buy First And Pay Later"</h2>
      </div>
      <div className="header__image">
        <img src={HOMEBODYIMG} alt="" />{" "}
      </div>
    </div>
  );
}

export default Content;
