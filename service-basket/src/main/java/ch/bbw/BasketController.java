package ch.bbw;

import ch.bbw.service01.Shirt;
import ch.bbw.service01.KatalogClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class BasketController {
    private final Cart cart = new Cart();

    @Autowired
    private KatalogClient katalogClient;

    @PostMapping
    public Cart addItemToCart(@RequestBody CartItem item) {
        Shirt shirt = katalogClient.getShirtById(item.getProductId());
        if (shirt != null && shirt.getId() == (item.getProductId())) {
            // Logik zur Überprüfung und Aktualisierung der Artikelmenge
            cart.addItem(item);
        }
        return cart;
    }

    @DeleteMapping("/{productId}")
    public Cart removeItemFromCart(@PathVariable int productId) {
        cart.removeItem(productId);
        return cart;
    }

    @GetMapping
    public Cart getCart() {
        return cart;
    }
}
