package tn.esprit.shareplate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Donation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Enumerated(EnumType.STRING)
    public donationType donationType;
    public int quality;
    public String unit;
    @Temporal(TemporalType.DATE)
    public Date availability;
    public String pickupLocation;
    public String description;

    @ManyToOne
    public User donor;


    @OneToMany
    @JsonIgnore
    public List<Receipt> receipt;

}
