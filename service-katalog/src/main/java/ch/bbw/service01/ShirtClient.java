package ch.bbw.service01;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("service-basket")
public interface ShirtClient {
    @GetMapping("shirts")
    List<Shirt> getShirt();
}
