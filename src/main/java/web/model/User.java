package web.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Size(min = 3, max = 30, message = "Minimum 3 characters")
    @NotBlank
    @Column(name = "name")
    private String name;
    @Size(min = 3, max = 30, message = "Minimum 3 characters")
    @NotBlank
    @Column(name = "surname")
    private String surname;

    @Max(value = 180)
    @Min(value = 1, message = "Age begins at 1 year")
    @Column(name = "age")
    private int age;


    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
