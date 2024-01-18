package ch.bbw;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class BasketController {
    private final Cart cart = new Cart();

    private ShirtClient shirtClient;

    public BasketController(ShirtClient shirtClient) {
        this.shirtClient = shirtClient;
    }

    @PostMapping
    public Cart addItemToCart(@RequestBody CartItem item) {
        try {
            Shirt shirt = shirtClient.getShirtById(item.getProductId());
            if (shirt != null && shirt.getId().equals(item.getProductId())) {
                cart.addItem(item);
            }
        } catch (Exception e) {
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
