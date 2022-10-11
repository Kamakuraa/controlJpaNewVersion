package ro.rarom.controljpanewversion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rarom.controljpanewversion.model.Vehicles;

public interface ControlAppRepository extends JpaRepository<Vehicles, Long> {
}
