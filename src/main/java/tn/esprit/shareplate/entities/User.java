package tn.esprit.shareplate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public String nom;
    public String prenom;
    @Temporal(TemporalType.DATE)
    public Date dateNaissance;
    public String mail;

    @Enumerated(EnumType.STRING)
    public role role;

    @Enumerated(EnumType.STRING)
    public typeDonor typeDonor;

    public int tel;
    public String password;
    public int CIN;

    @Enumerated(EnumType.STRING)
    public gouvTun gouvTun;

    @OneToMany(mappedBy = "receiver")
    @JsonIgnore
    public List<Receipt> receipts;

    @OneToMany(mappedBy = "donor")
            @JsonIgnore
    List<Donation> donations;

}
