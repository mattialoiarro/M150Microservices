import React, { useState, useEffect } from "react";
import ShirtItem from "./ShirtItem.js";

const ShirtList = ({ addToCart }) => {
  const [shirts, setShirts] = useState([]);

  useEffect(() => {
    // Replace with API-call
    const shirtsData = [
      {
        id: 1,
        brand: "Brand 1",
        squad: "Squad 1",
        year: 2022,
        price: 10.99,
        size: "M",
        details: "Details 1",
      },
      {
        id: 2,
        brand: "Brand 2",
        squad: "Squad 2",
        year: 2023,
        price: 15.99,
        size: "L",
        details: "Details 2",
      },
      {
        id: 3,
        brand: "Brand 3",
        squad: "Squad 3",
        year: 2021,
        price: 12.49,
        size: "S",
        details: "Details 3",
      },
    ];
    setShirts(shirtsData);
  }, []);

  return (
    <div>
      <h1>Available Shirts</h1>
      <div className="shirt-list">
        {shirts.map((shirt) => (
          <ShirtItem key={shirt.id} shirt={shirt} addToCart={addToCart} />
        ))}
      </div>
    </div>
  );
};

export default ShirtList;
