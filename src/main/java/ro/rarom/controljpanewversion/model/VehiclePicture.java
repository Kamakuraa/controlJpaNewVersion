package ro.rarom.controljpanewversion.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiclePicture {
  @Id
  @GeneratedValue
  private Long id;

  @Lob
  private byte[] content;

  private Date dataIntroducere;
  private String user_introducere;
  private int idVehicul;

  public VehiclePicture(String user_introducere, int idVehicul) {
    this.user_introducere = user_introducere;
    this.idVehicul = idVehicul;
  }
}
