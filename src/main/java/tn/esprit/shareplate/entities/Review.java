package tn.esprit.shareplate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public int rating;
    public String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    public User user;
    @ManyToOne(cascade = CascadeType.ALL)
    public Donation donation;
}
