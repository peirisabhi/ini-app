import React from "react";
import "./BodySection.css";
import IMG1 from "../Components/images/accept the request.png";
import IMG2 from "../Components/images/pickup client.png";
import IMG3 from "../Components/images/drive to destination.png";

function BodySection() {
  return (
    <div className="bodypartthree__container">
   
      <h2>How BumbleBee Works</h2>
      <div className="bodypartthreeIcon__container">
       
        <div className="bodypartthreeIcon">
          <p>1. Accept the request</p>
          <img
            src={IMG1}
            alt=""
            width="350"
            height="350"
            style={{
              marginTop: "7px",
              borderRadius: "175px",
            }}
          />
        </div>
        <div className="bodypartthreeIcon">
          <p>2. Pickup the client</p>
          <img
            src={IMG2}
            alt=""
            width="350"
            height="350"
            style={{
              paddingTop: "5px",
              borderRadius: "175px",
            }}
          />
        </div>
        <div className="bodypartthreeIcon">
          <p>3. Drive to destination</p>
          <img
            src={IMG3}
            alt=""
            width="350"
            height="350"
            style={{
              marginTop: "7px",
              borderRadius: "175px",
            }}
          />
        </div>
      </div>
    </div>
  );
}

export default BodySection;