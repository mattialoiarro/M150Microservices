package ch.bbw.service01;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-katalog")
public interface KatalogClient {
    @GetMapping("/shirts/{id}")
    Shirt getShirtById(@PathVariable("id") int id);
}
