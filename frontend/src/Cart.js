import React, { useState } from 'react';
import Checkout from './Checkout';

const Cart = ({ cartItems }) => {
  const [isCheckingOut, setIsCheckingOut] = useState(false);

  const handleCheckout = () => {
    setIsCheckingOut(true);
  };

  const handleCheckoutComplete = () => {
    setIsCheckingOut(false);
    // Further actions after checkout (e.g., clear cart)
  };

  const calculateTotal = (cartItems) => {
    return cartItems.reduce((total, item) => total + item.price, 0);
  };

  if (isCheckingOut) {
    return <Checkout cartItems={cartItems} onCheckoutComplete={handleCheckoutComplete} />;
  }

  return (
    <div className="cart">
      <h2>Shopping Cart</h2>
      <ul>
        {cartItems.map((item) => (
          <li key={item.id}>
            {item.name} - ${item.price.toFixed(2)}
          </li>
        ))}
      </ul>
      <h3>Total: ${calculateTotal(cartItems).toFixed(2)}</h3>
      <button onClick={handleCheckout}>Checkout</button>
    </div>
  );
};

export default Cart;
