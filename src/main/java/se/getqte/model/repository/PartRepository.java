package se.getqte.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.getqte.model.Part;

public interface PartRepository extends JpaRepository<Part, Long> {
}
