package ch.bbw.service01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomShirtRepository extends JpaRepository<Shirt, Long> {
}
