package tn.esprit.shareplate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DonationDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Enumerated(EnumType.STRING)
    public donationType donationType;
    public int quantity;
    public String unit;
    @Temporal(TemporalType.DATE)
    public Date availability;
    public String pickupLocation;
    public String description;
    public String name;
}
