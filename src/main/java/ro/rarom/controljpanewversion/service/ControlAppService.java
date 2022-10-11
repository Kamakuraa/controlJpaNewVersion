package ro.rarom.controljpanewversion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.rarom.controljpanewversion.model.Vehicles;
import ro.rarom.controljpanewversion.repository.ControlAppRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ControlAppService {
  private final ControlAppRepository repository;


  public List<Vehicles> getAll() {
    return repository.findAll ();
  }

  public Optional<Vehicles> getVehicles(Long controlAppId) {
    return repository.findById (controlAppId);
  }

  public Vehicles addVehicles(Vehicles entity) {
    return repository.save (entity);
  }

  public Optional<Vehicles> replaceVehicle(Vehicles vehicles, Long apisId) {
    return repository.findById (apisId)
        .map (dbVehicles -> patchVehicles (dbVehicles, vehicles))
      .map (repository::save);
  }

  private Vehicles patchVehicles(Vehicles dbVehicles, Vehicles vehicles) {
    dbVehicles.setVin (vehicles.getVin ());
    dbVehicles.setNrInmatr (vehicles.getNrInmatr ());
    dbVehicles.setUserIntroducere (vehicles.getUserIntroducere ());
    dbVehicles.setObservatii (vehicles.getObservatii ());
    dbVehicles.setAvertizare (vehicles.getAvertizare ());

    return dbVehicles;
  }

  public Vehicles vehiclesDelete(Long vehiclesId) {
    Optional<Vehicles> vehicles = repository.findById (vehiclesId);
    vehicles.ifPresent (repository::delete);
    return vehicles.orElse (null);
  }
}
