package se.getqte.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import se.getqte.model.ClientType;

public interface ClientTypeRepository extends JpaRepository<ClientType, Long> {
}
