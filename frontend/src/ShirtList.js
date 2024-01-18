import React, { useState, useEffect } from "react";
import ShirtItem from "./ShirtItem.js";

const ShirtList = ({ addToCart }) => {
  const [shirts, setShirts] = useState([]);

  useEffect(() => {
    // Fetch data from API
    fetch("/service-01/api/shirts") // Update the URL
      .then((response) => response.json())
      .then((data) => {
        setShirts(data); // Update state
      })
      .catch((error) => {
        console.error("Error fetching data from the backend:", error);
      });
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
