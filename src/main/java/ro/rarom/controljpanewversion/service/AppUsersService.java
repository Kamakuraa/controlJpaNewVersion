package ro.rarom.controljpanewversion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.rarom.controljpanewversion.model.AppUser;
import ro.rarom.controljpanewversion.repository.AppUserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUsersService {
  private final AppUserRepository repo;

  public List<AppUser> getAll() {
    return repo.findAll ();
  }

  public Optional<AppUser> getAppUser(Long id) {
    return repo.findById (id);
  }

  public AppUser addAppUser(AppUser entity) {
    return repo.save (entity);
  }

  public Optional<AppUser> replaceAppUser(AppUser user, Long usersId) {
    return repo.findById (usersId)
      .map (dbAppUsers -> patchUsers (dbAppUsers, user))
      .map (repo::save);
  }

  private AppUser patchUsers(AppUser dbAppUsers, AppUser user) {
    dbAppUsers.setUserName (user.getUserName ());
    dbAppUsers.setName (user.getName ());
    dbAppUsers.setPassword (user.getPassword ());
    dbAppUsers.setApiKey (user.getApiKey ());
    dbAppUsers.setDisplayName (user.getDisplayName ());

    return dbAppUsers;
  }

  public AppUser appUserDelete(Long appUserId) {
    Optional<AppUser> appUser = repo.findById (appUserId);
    appUser.ifPresent (repo::delete);
    return appUser.orElse (null);
  }
}
