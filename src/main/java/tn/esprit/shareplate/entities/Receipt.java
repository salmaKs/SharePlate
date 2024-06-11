package tn.esprit.shareplate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Receipt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    @Temporal(TemporalType.DATE)
    public Date dateReceived;
    public int quantity;
    public String unit;

    @ManyToOne
    public User receiver;
    @ManyToOne(cascade = CascadeType.ALL)
    public Donation donation;

}
