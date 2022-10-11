package ro.rarom.controljpanewversion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.rarom.controljpanewversion.model.VehiclePicture;
import ro.rarom.controljpanewversion.repository.VehiclePictureRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiclePicturesService {
  private final VehiclePictureRepository repository;


  public List<VehiclePicture> getAll() {
    return repository.findAll ();
  }

  public Optional<VehiclePicture> getVehiclePictures(Long id) {
    return repository.findById (id);
  }

  public VehiclePicture addVehiclePictures(VehiclePicture entity) {
    return repository.save (entity);
  }

  public Optional<VehiclePicture> replaceVehiclePictures(VehiclePicture vehiclePicture, Long picturesId) {
    return repository.findById (picturesId)
      .map (dbVehiclesPictures -> patchVehicles(dbVehiclesPictures, vehiclePicture))
      .map (repository::save);
  }

  private VehiclePicture patchVehicles(VehiclePicture dbVehiclesPictures, VehiclePicture vehiclePicture) {
    dbVehiclesPictures.setContent (vehiclePicture.getContent ());
    dbVehiclesPictures.setIdVehicul (vehiclePicture.getIdVehicul ());
    dbVehiclesPictures.setDataIntroducere (vehiclePicture.getDataIntroducere ());
    dbVehiclesPictures.setUser_introducere (vehiclePicture.getUser_introducere ());

    return dbVehiclesPictures;
  }

  public VehiclePicture vehiclePictureDelete(Long vehiclesPicturesId) {
    Optional<VehiclePicture> vehiclePicture = repository.findById (vehiclesPicturesId);
    vehiclePicture.ifPresent (repository::delete);
    return vehiclePicture.orElse (null);
  }
}
