package se.getqte.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.getqte.model.TimeEntry;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

}
