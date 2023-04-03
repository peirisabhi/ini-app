import React from "react";
import "./Footer.css";
import FCEBOOKIMG from "../Components/images/facebook.png";
import TWITTERIMG from "../Components/images/twitter.png";
import INSTAGRAMIMG from "../Components/images/instagram.png";
import LINKEDINIMG from "../Components/images/linkedin.png";

function Footer() {
  return (
    <div className="footer__container">
      <div className="footeritems">
        <p>About Us</p>
        <p>Contact Us</p>
        <p>Privacy & Terms</p>
      </div>
      
      <div className="footer__socialmedia">
        <img
          src={FCEBOOKIMG}
          alt=""
          width="30"
          height="30"
          style={{
            marginRight: "4px",
            cursor: "pointer",
          }}
        />
        <img
          src={TWITTERIMG}
          alt=""
          width="30"
          height="30"
          style={{
            marginRight: "4px",
            cursor: "pointer",
          }}
        />
        <img
          src={INSTAGRAMIMG}
          alt=""
          width="30"
          height="30"
          style={{
            marginRight: "4px",
            cursor: "pointer",
          }}
        />
        <img
          src={LINKEDINIMG}
          alt=""
          width="30"
          height="30"
          style={{
            cursor: "pointer",
          }}
        />
      </div>
      <div className="footer__copyright">
        <p>Copyright 2023 BUMBLEBEE All Rights Reserved</p>
      </div>
    </div>
  );
}

export default Footer;