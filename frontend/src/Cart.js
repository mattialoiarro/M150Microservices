import React, { useState } from "react";
import "./Cart.css";

const Cart = ({
  cartItems,
  removeFromCart,
  removeAllFromCart,
  isOrderSuccessModalOpen,
  setIsOrderSuccessModalOpen,
}) => {
  const [isOrderConfirmationOpen, setIsOrderConfirmationOpen] = useState(false);

  const openOrderConfirmation = () => {
    setIsOrderConfirmationOpen(true);
  };

  const closeOrderConfirmation = () => {
    setIsOrderConfirmationOpen(false);
  };

  const placeOrder = () => {
    setIsOrderConfirmationOpen(false);
    setIsOrderSuccessModalOpen(true);
  };

  const closeOrderSuccessModal = () => {
    setIsOrderSuccessModalOpen(false);
    removeAllFromCart();
  };

  const calculateTotal = (cartItems) => {
    return cartItems.reduce(
      (total, item) => total + (item.price || 0) * item.quantity,
      0
    );
  };

  return (
    <div className="cart">
      <h2>Shopping Cart</h2>
      <ul className="cart-list">
        {Array.isArray(cartItems) &&
          cartItems.map((item) => (
            <li key={item.id} className="cart-item">
              <div className="cart-item-details">
                <span className="cart-item-name">{item.brand}</span>
                <span className="cart-item-price">
                  ${item.price.toFixed(2)} x {item.quantity}
                </span>
              </div>
              <button
                className="cart-button"
                onClick={() => removeFromCart(item.id)}
              >
                Remove
              </button>
            </li>
          ))}
      </ul>
      <h3>Total: ${calculateTotal(cartItems).toFixed(2)}</h3>
      <button onClick={openOrderConfirmation} className="cart-button">
        Checkout
      </button>

      {/* Order Confirmation Modal */}
      {isOrderConfirmationOpen && (
        <div className="modal">
          <div className="modal-content confirmation-modal">
            <span className="close" onClick={closeOrderConfirmation}>
              &times;
            </span>
            <h2>Order Confirmation</h2>
            <ul>
              {cartItems.map((item) => (
                <li key={item.id}>
                  {item.brand} - ${item.price.toFixed(2)} x {item.quantity}
                </li>
              ))}
            </ul>
            <h3>Total: ${calculateTotal(cartItems).toFixed(2)}</h3>
            <button className="cart-button" onClick={placeOrder}>
              Order Now
            </button>
          </div>
        </div>
      )}

      {/* Order Success Modal */}
      {isOrderSuccessModalOpen && (
        <div className="modal">
          <div className="modal-content success-modal">
            <span className="close" onClick={closeOrderSuccessModal}>
              &times;
            </span>
            <h2>Order Placed Successfully</h2>
            <p>Your order has been successfully placed!</p>
          </div>
        </div>
      )}
    </div>
  );
};

export default Cart;
