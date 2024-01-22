import React, { useState, useEffect } from "react";
import ShirtItem from "./ShirtItem.js";

const ShirtList = ({ addToCart }) => {
  const [shirts, setShirts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/shirts")
        .then((response) => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then((data) => {
            setShirts(data);
        })
        .catch((error) => {
            console.error("Error fetching data:", error);
            // Handle the error (e.g., set an error state, display a message)
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
