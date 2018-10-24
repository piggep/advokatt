package se.getqte.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import se.getqte.model.Client;
import se.getqte.model.Errand;

import java.util.Set;

public interface ErrandRepository extends JpaRepository<Errand, Long> {
    Set<Errand> findAllByClient(Client id);
}
