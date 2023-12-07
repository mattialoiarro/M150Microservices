package ch.bbw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @GetMapping("api")
    public MyData getData() {
        return new MyData("Hello World from Service 02");
    }


}