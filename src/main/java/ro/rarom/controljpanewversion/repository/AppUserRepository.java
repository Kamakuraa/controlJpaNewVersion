package ro.rarom.controljpanewversion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rarom.controljpanewversion.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
