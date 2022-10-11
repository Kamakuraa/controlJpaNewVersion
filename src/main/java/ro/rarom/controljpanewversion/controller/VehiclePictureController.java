package ro.rarom.controljpanewversion.controller;

import exceptions.RelationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.rarom.controljpanewversion.model.VehiclePicture;
import ro.rarom.controljpanewversion.service.VehiclePicturesService;

import java.util.List;

@RestController
@RequestMapping("pictures")
@RequiredArgsConstructor
public class VehiclePictureController {
  private final VehiclePicturesService service;

  @GetMapping
  List<VehiclePicture> getAll() {
    return service.getAll ();
  }

  @GetMapping("{id}")
  VehiclePicture getVehiclePictures(@PathVariable Long id) {
    return service.getVehiclePictures (id)
      .orElseThrow (() -> new RelationNotFoundException ("Could not found vehiclesPictures with exceptions " + id));
  }

  @PostMapping
  VehiclePicture replaceVehiclePictures(@RequestBody VehiclePicture entity) {
    return service.addVehiclePictures (entity);
  }

  @PutMapping("{picturesId}")
  VehiclePicture replaceVehiclePictures(@RequestBody VehiclePicture vehiclePicture, @PathVariable Long picturesId) {
    return service.replaceVehiclePictures (vehiclePicture, picturesId)
      .orElseThrow (() -> new RelationNotFoundException ("Could not found vehiclesPictures with exceptions " + picturesId));
  }
  @DeleteMapping("{vehiclesPicturesId}")
  VehiclePicture vehiclePictureDelete(@PathVariable Long vehiclesPicturesId){
    return service.vehiclePictureDelete(vehiclesPicturesId);
  }
}
