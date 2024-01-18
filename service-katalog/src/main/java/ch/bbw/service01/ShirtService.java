package ch.bbw.service01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShirtService {

    private final CustomShirtRepository customShirtRepository1;


    @Autowired
    public ShirtService(CustomShirtRepository customShirtRepository) {
        this.customShirtRepository1 = customShirtRepository;
    }

    public List<Shirt> getAllShirts() {
        return customShirtRepository1.findAll();
    }

    public Shirt getShirtById(Integer id) {
        return customShirtRepository1.findById(Long.valueOf(id)).orElse(null);
    }

    public Shirt saveShirt(Shirt shirt) {
        customShirtRepository1.save(shirt);
        return shirt;
    }

    public void deleteShirt(Integer id) {
        customShirtRepository1.deleteById(Long.valueOf(id));
    }
}
