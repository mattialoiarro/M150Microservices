import React, { useState } from "react";
import "./Checkout.css";

const Checkout = ({ cartItems, onCheckoutComplete }) => {
  const [orderCompleted, setOrderCompleted] = useState(false);

  const calculateTotal = (cartItems) => {
    return cartItems.reduce((total, item) => total + item.price, 0);
  };

  const handleCompleteOrder = () => {
    setOrderCompleted(true);
  };

  return (
    <div className="checkout-container">
      <h2>Complete Order</h2>
      <div className="checkout-items">
        {cartItems.map((item, index) => (
          <div key={index} className="checkout-item">
            <span>Brand: {item.brand}, </span>
            <span>Size: {item.size}, </span>
            <span>Price: ${item.price.toFixed(2)}</span>
          </div>
        ))}
      </div>
      <div className="checkout-total">
        <h3>Total: ${calculateTotal(cartItems).toFixed(2)}</h3>
      </div>
      <button onClick={handleCompleteOrder} className="checkout-button">
        Complete Order
      </button>

      {orderCompleted && (
        <div className="backdrop">
          <div className="order-success-message">
            Order completed successfully!
          </div>
        </div>
      )}
    </div>
  );
};

export default Checkout;
