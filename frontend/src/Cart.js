import React from 'react';

const Cart = ({ cartItems }) => {
  const calculateTotal = (cartItems) => {
    return cartItems.reduce((total, item) => total + item.price, 0);
  };

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
      <button>Checkout</button>
    </div>
  );
};

export default Cart;
