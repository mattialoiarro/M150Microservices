import React, { useState, useEffect } from "react";
import ShirtItem from "./ShirtItem.js";

import shirt1 from "./juve.jpeg";
import shirt2 from "./roma.jpeg";
import shirt3 from "./acmilan.jpeg";

const ShirtList = ({ addToCart }) => {
  const [shirts, setShirts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/shirts")
      .then((response) => response.json())
      .then((data) => setShirts(data))
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  const shirtImages = [shirt1, shirt2, shirt3];

  return (
    <div>
      <h1>Available Shirts</h1>
      <div className="shirt-list">
        {shirts.map((shirt, index) => (
          <ShirtItem
            key={shirt.id}
            shirt={shirt}
            addToCart={addToCart}
            imageUrl={shirtImages[index]}
          />
        ))}
      </div>
    </div>
  );
};

export default ShirtList;
