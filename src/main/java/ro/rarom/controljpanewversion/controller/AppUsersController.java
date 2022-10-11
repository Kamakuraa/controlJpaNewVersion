package ro.rarom.controljpanewversion.controller;

import exceptions.RelationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.rarom.controljpanewversion.model.AppUser;
import ro.rarom.controljpanewversion.service.AppUsersService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class AppUsersController {
  private final AppUsersService service;

  @GetMapping
  List<AppUser> getAll(){
    return service.getAll();
  }
  @GetMapping("{id}")
  AppUser getAppUser(@PathVariable Long id){
    return service.getAppUser(id)
      .orElseThrow(() -> new RelationNotFoundException ("Could not found vehicles with exceptions " + id));
  }
  @PostMapping
  AppUser addAppUser(@RequestBody AppUser entity){
    return service.addAppUser(entity);
  }
  @PutMapping("{usersId}")
  AppUser replaceAppUser(@RequestBody AppUser user, @PathVariable Long usersId){
    return service.replaceAppUser(user, usersId)
      .orElseThrow(() -> new RelationNotFoundException ("Could not found vehicles with exceptions " + usersId));
  }
  @DeleteMapping("{appUserId}")
  AppUser appUserDelete(@PathVariable Long appUserId){
    return service.appUserDelete(appUserId);
  }
}
