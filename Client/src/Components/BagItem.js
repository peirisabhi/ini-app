import React from "react";
import "./BagItem.css";
import { AiOutlineClose } from "react-icons/ai";

function BagItem(props) {
  const { item, addToBag, removeFromBag, removeEntireItem } = props;
  return (
    <div className="bag row" key={item.id}>
      <img src={item.image} alt="jewelry" className="bag img" />
      <div className="bag details">
        <div>
          <div className="wrapper">
            <div className="prod name">{item.name}</div>
            <button className="close" onClick={() => removeEntireItem(item)}>
              <AiOutlineClose />
            </button>
          </div>
          <div className="prod material">{item.material}</div>
        </div>
        <div className="edit">
          <div className="edit-qty">
            <button className="btn" onClick={() => removeFromBag(item)}>
              -
            </button>
            <div className="qty">{item.qty}</div>
            <button className="btn" onClick={() => addToBag(item)}>
              +
            </button>
          </div>
          <div className="prod price">LKR {item.price * item.qty}</div>
        </div>
      </div>
    </div>
  );
}

export default BagItem;
