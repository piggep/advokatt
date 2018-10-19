package se.getqte.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import se.getqte.model.Client;

/** Repository manager for Person. */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
