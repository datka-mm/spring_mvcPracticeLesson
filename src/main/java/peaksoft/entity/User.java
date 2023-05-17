package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(
            generator = "user_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "user_gen",
            sequenceName = "user_seq",
            allocationSize = 1)
    private Long id;
    private String fullName;
    private String email;
    private String photo;
    private int age;

    @OneToMany(cascade = {MERGE, DETACH, REFRESH})
    private List<House> houses;
}
