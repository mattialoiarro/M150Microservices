package ch.bbw.service01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainRestController {

    @Autowired
    private ShirtClient shirtClient;

    @GetMapping("/shirts")
    public List<Shirt> getShirts() {
        return shirtClient.getShirts();
    }

    @GetMapping("/shirts/{id}")
    public Shirt getShirtById(@PathVariable int id) {
        return shirtClient.getShirtById(id);
    }

    @PostMapping("/shirts")
    public Shirt addShirt(@RequestBody Shirt shirt) {
        return shirtClient.addShirt(shirt);
    }

    @PutMapping("/shirts/{id}")
    public Shirt updateShirt(@PathVariable int id, @RequestBody Shirt shirtDetails) {
        Shirt shirt = shirtClient.getShirtById(id);
        if (shirt != null) {
            shirt.setBrand(shirtDetails.getBrand());
            shirt.setSquad(shirtDetails.getSquad());
            shirt.setYear(shirtDetails.getYear());
            shirt.setPrice(shirtDetails.getPrice());
            shirt.setSize(shirtDetails.getSize());
            shirt.setDetails(shirtDetails.getDetails());
            return shirtClient.addShirt(shirt);
        }
        return null;
    }

    @DeleteMapping("/shirts/{id}")
    public void deleteShirt(@PathVariable int id) {
        shirtClient.deleteShirt(id);
    }
}
