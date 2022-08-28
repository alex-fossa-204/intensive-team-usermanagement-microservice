package dev.alexfossa.usermanagementmicroservice.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "intensive_user")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"id", "intensiveUserCredentials"})
@Builder
public class IntensiveUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "location")
    private String location;

    @Column(name = "user_uuid")
    private UUID userUuid;

    @OneToMany(mappedBy = "intensiveUserEntity",cascade = { CascadeType.ALL })
    @Fetch(FetchMode.JOIN)
    private Collection<IntensiveUserCredential> intensiveUserCredentials;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_technologies",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id", referencedColumnName = "id")
    )
    private Set<UserTechnology> userTechnologies;

}
