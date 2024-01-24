import React, { useState, useEffect } from "react";
import ShirtList from "./ShirtList";
import Cart from "./Cart";

import "./App.css";

const App = () => {
  const [cartItems, setCartItems] = useState([]);
  const [isOrderSuccessModalOpen, setIsOrderSuccessModalOpen] = useState(false);

  const fetchCart = () => {
    fetch("http://localhost:8082/api/cart")
      .then((response) => response.json())
      .then((data) => {
        const fetchProductDetails = async (productId) => {
          try {
            const response = await fetch(
              `http://localhost:8081/shirts/${productId}`
            );
            const productDetails = await response.json();
            return {
              id: productId,
              quantity: data.items[productId].quantity,
              brand: productDetails.brand,
              price: productDetails.price,
            };
          } catch (error) {
            console.error("Error fetching product details:", error);
            return null;
          }
        };

        const fetchDetailsPromises = Object.keys(data.items).map((key) =>
          fetchProductDetails(key)
        );

        Promise.all(fetchDetailsPromises).then((itemsArray) => {
          const filteredItemsArray = itemsArray.filter((item) => item !== null);
          setCartItems(filteredItemsArray);
        });
      })
      .catch((error) => console.error("Error fetching cart:", error));
  };

  useEffect(() => {
    fetchCart();
  }, []);

  const addToCart = (shirt) => {
    const cartItem = { productId: shirt.id, quantity: 1 };
    fetch("http://localhost:8082/api/cart", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(cartItem),
    })
      .then(() => fetchCart())
      .catch((error) => console.error("Error adding item to cart:", error));
  };

  const removeFromCart = (productId) => {
    fetch(`http://localhost:8082/api/cart/${productId}`, { method: "DELETE" })
      .then(() => fetchCart())
      .catch((error) => console.error("Error removing item from cart:", error));
  };

  const removeAllFromCart = () => {
    fetch("http://localhost:8082/api/cart/clear", { method: "DELETE" })
      .then(() => fetchCart())
      .catch((error) => console.error("Error clearing the cart:", error));
  };

  const handleCheckoutComplete = () => {
    setIsOrderSuccessModalOpen(true);

    clearCartOnServer();
  };

  const clearCartOnServer = () => {
    fetch("http://localhost:8082/api/cart/clear", {
      method: "DELETE",
    })
      .then((response) => {
        if (response.ok) {
          setCartItems([]);
        } else {
          console.error("Failed to clear the cart.");
        }
      })
      .catch((error) => {
        console.error("Error clearing the cart:", error);
      });
  };

  return (
    <div className="app-container">
      <ShirtList addToCart={addToCart} />
      <Cart
        cartItems={cartItems}
        onCheckout={handleCheckoutComplete}
        removeFromCart={removeFromCart}
        isOrderSuccessModalOpen={isOrderSuccessModalOpen}
        setIsOrderSuccessModalOpen={setIsOrderSuccessModalOpen}
        removeAllFromCart={removeAllFromCart}
      />
    </div>
  );
};

export default App;
