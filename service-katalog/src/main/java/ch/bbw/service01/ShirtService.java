package ch.bbw.service01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShirtService {

    private static final Logger logger = LoggerFactory.getLogger(ShirtService.class);
    private final CustomShirtRepository customShirtRepository;

    @Autowired
    public ShirtService(CustomShirtRepository customShirtRepository) {
        this.customShirtRepository = customShirtRepository;
    }

    public List<Shirt> getAllShirts() {
        List<Shirt> shirts = customShirtRepository.findAll();
        logger.info("Retrieved shirts from database: {}", shirts);
        return shirts;
    }

    public Shirt getShirtById(Long id) {
        return customShirtRepository.findById(Long.valueOf(id)).orElse(null);
    }

    public Shirt saveShirt(Shirt shirt) {
        customShirtRepository.save(shirt);
        return shirt;
    }

    public void deleteShirt(Long id) {
        customShirtRepository.deleteById(Long.valueOf(id));
    }
}
