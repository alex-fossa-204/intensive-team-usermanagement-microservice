package dev.alexfossa.usermanagementmicroservice.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "privilege")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id", "roles"})
@ToString(exclude = {"id", "roles"})
public class Privilege implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "privilege_name")
    private String privilegeName;

    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles;

}
