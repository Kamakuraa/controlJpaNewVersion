package ro.rarom.controljpanewversion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.rarom.controljpanewversion.model.AppUser;
import ro.rarom.controljpanewversion.model.VehiclePicture;
import ro.rarom.controljpanewversion.model.Vehicles;
import ro.rarom.controljpanewversion.repository.AppUserRepository;
import ro.rarom.controljpanewversion.repository.ControlAppRepository;
import ro.rarom.controljpanewversion.repository.VehiclePictureRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ControlJpaNewVersionApplication {

  public static void main(String[] args) {
    SpringApplication.run (ControlJpaNewVersionApplication.class, args);
  }

  @Bean
  CommandLineRunner atStartUp(ControlAppRepository repository) {
    return args -> {
      repository.saveAll (List.of (
        new Vehicles ("a123", "B22ASD",
          LocalDate.now (), "Alex",
          "obs", "in progress")
      ));
    };

  }

  @Bean
  CommandLineRunner atStartUpPicture(VehiclePictureRepository repo) {
    return args -> {
      repo.saveAll (List.of (
        new VehiclePicture ("Alex", 1),
        new VehiclePicture ("Cristi", 2),
        new VehiclePicture ("Octavian", 3),
        new VehiclePicture ("Alex", 4)
      ));
    };

  }

  @Bean
  CommandLineRunner atStartUpUser(AppUserRepository repo) {
    return args -> {
      repo.saveAll (List.of (
        new AppUser ("Alex", "xX1234"),
        new AppUser ("Cristi", "xX1234")
      ));
    };
  }
}
