import React from "react";
import "./ShirtItem.css";

const ShirtItem = ({ shirt, addToCart, imageUrl }) => {
  const handleAddToCart = () => {
    addToCart(shirt);
  };

  return (
    <div className="shirt-item">
      <div className="image">
        <img src={imageUrl} alt={shirt.name} />
      </div>
      <div className="details">
        <h2>{shirt.brand}</h2>
        <p>Squad: {shirt.squad}</p>
        <p>Year: {shirt.year}</p>
        <p>Size: {shirt.size}</p>
        <p>Details: {shirt.details}</p>
        <p>Price: ${shirt.price.toFixed(2)}</p>
        <button onClick={handleAddToCart}>Add to Cart</button>
      </div>
    </div>
  );
};

export default ShirtItem;
