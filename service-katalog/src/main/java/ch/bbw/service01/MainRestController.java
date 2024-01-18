package ch.bbw.service01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000
public class MainRestController {

    @Autowired
    private ShirtService shirtService;

    @GetMapping("/shirts")
    public List<Shirt> getShirts() {
        return shirtService.getAllShirts();
    }

    @GetMapping("/shirts/{id}")
    public Shirt getShirtById(@PathVariable int id) {
        return shirtService.getShirtById(id);
    }

    @PostMapping("/shirts")
    public Shirt addShirt(@RequestBody Shirt shirt) {
        return shirtService.saveShirt(shirt);
    }

    @PutMapping("/shirts/{id}")
    public Shirt updateShirt(@PathVariable int id, @RequestBody Shirt shirtDetails) {
        Shirt shirt = shirtService.getShirtById(id);
        if (shirt != null) {
            shirt.setBrand(shirtDetails.getBrand());
            shirt.setSquad(shirtDetails.getSquad());
            shirt.setYear(shirtDetails.getYear());
            shirt.setPrice(shirtDetails.getPrice());
            shirt.setSize(shirtDetails.getSize());
            shirt.setDetails(shirtDetails.getDetails());
            return shirtService.saveShirt(shirt);
        }
        return null;
    }

    @DeleteMapping("/shirts/{id}")
    public void deleteShirt(@PathVariable int id) {
        shirtService.deleteShirt(id);
    }
}
