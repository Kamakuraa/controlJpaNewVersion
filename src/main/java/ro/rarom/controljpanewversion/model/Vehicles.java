package ro.rarom.controljpanewversion.model;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dot_cereri_clienti")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicles {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;

  private String vin;

  private String nrInmatr;

  private LocalDate dataIntroducere;
  private String userIntroducere;

  private String observatii;
  private String avertizare;

  public Vehicles(String vin, String nrInmatr, LocalDate dataIntroducere, String userIntroducere, String observatii, String avertizare) {
    this.vin = vin;
    this.nrInmatr = nrInmatr;
    this.dataIntroducere = dataIntroducere;
    this.userIntroducere = userIntroducere;
    this.observatii = observatii;
    this.avertizare = avertizare;
  }
}
