import React, { useState } from "react";
import ShirtList from "./ShirtList";
import Cart from "./Cart";
import "./App.css"; // Import your CSS file for styling

const App = () => {
  const [cartItems, setCartItems] = useState([]);

  const addToCart = (shirt) => {
    setCartItems([...cartItems, shirt]);
  };

  return (
    <div className="app-container">
      <ShirtList addToCart={addToCart} />
      <Cart cartItems={cartItems} className="cart" />
    </div>
  );
};

export default App;
