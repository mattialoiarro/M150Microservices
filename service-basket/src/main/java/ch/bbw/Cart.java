package ch.bbw;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<Integer, CartItem> items = new HashMap<>();

    public void addItem(CartItem newItem) {
        CartItem existingItem = items.get(newItem.getProductId());
        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + newItem.getQuantity());
        } else {
            items.put(newItem.getProductId(), newItem);
        }
    }

    public void removeItem(int productId) {
        items.remove(productId);
    }

    public void clearCart() {
        items.clear();
    }

    public Map<Integer, CartItem> getItems() {
        return new HashMap<>(items);
    }
}
