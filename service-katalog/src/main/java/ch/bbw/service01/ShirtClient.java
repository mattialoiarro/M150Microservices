package ch.bbw.service01;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "shirt-service", url = "http://localhost:8081") // URL des Shirt-Services
public interface ShirtClient {

    @GetMapping("/shirts")
    List<Shirt> getShirts();

    @GetMapping("/shirts/{id}")
    Shirt getShirtById(@PathVariable("id") int id);

    @PostMapping("/shirts")
    Shirt addShirt(@RequestBody Shirt shirt);

    @PutMapping("/shirts/{id}")
    Shirt updateShirt(@PathVariable("id") int id, @RequestBody Shirt shirt);

    @DeleteMapping("/shirts/{id}")
    void deleteShirt(@PathVariable("id") int id);
}
