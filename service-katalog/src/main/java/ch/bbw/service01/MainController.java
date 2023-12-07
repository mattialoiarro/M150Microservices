package ch.bbw.service01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ShirtClient shirtClient;

    @GetMapping("/shirts")
    public List<String> getShirts() {
        return shirtClient.getShirt().stream()
                .map(shirt -> String.format("%s (%s)", shirt.getId(), shirt.getSquad(), shirt.getBrand(), shirt.getYear(), shirt.getPrice(), shirt.getSize(), shirt.getDetails()))
                .toList();
    }
}
