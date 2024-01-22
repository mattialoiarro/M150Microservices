package ch.bbw.service01;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableJpaRepositories
@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000
public class MainRestController {

    @Autowired
    private ShirtService shirtService;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/shirts")
    public List<Shirt> getShirts() {
        return shirtService.getAllShirts();
    }

    @GetMapping("/shirts/{id}")
    public Shirt getShirtById(@PathVariable Long id) {
        return shirtService.getShirtById(id);
    }

    @PostMapping("/shirts")
    public Shirt addShirt(@RequestBody Shirt shirt) {
        return shirtService.saveShirt(shirt);
    }

    @PutMapping("/shirts/{id}")
    public Shirt updateShirt(@PathVariable Long id, @RequestBody Shirt shirtDetails) {
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
    public void deleteShirt(@PathVariable Long id) {
        shirtService.deleteShirt(id);
    }

    @GetMapping("/dbCheck")
    public String databaseConnectionCheck() {
        try {
            long count = (long) entityManager.createQuery("SELECT COUNT(s) FROM Shirt s").getSingleResult();
            return "Database connection successful. Shirt count: " + count;
        } catch (Exception e) {
            return "Database connection failed: " + e.getMessage();
        }
    }

    @Transactional
    @PostMapping("/addTestData")
    public ResponseEntity<String> addTestData() {
        try {
            // Create and persist test data
            Shirt shirt1 = new Shirt("Adidas", "Home", 2020, 49.99, "M", "Red shirt with white stripes");
            Shirt shirt2 = new Shirt("Nike", "Away", 2021, 59.99, "L", "Blue shirt with logo");
            // Add more test data as needed

            entityManager.persist(shirt1);
            entityManager.persist(shirt2);
            // Persist more test data as needed

            return ResponseEntity.status(HttpStatus.CREATED).body("Test data added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add test data: " + e.getMessage());
        }
    }
}
