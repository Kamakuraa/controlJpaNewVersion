package ro.rarom.controljpanewversion.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUser {
  @Id
  @GeneratedValue
  private Long id;
  private String userName;
  private String password;

  private String displayName;
  private String name;

  private String apiKey;

//  private List<Integer> roles;
//  private List<Integer> errors;

  public AppUser(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }
}
