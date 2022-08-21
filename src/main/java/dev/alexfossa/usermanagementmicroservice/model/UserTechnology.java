package dev.alexfossa.usermanagementmicroservice.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "user_technologies")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id", "intensiveUsers"})
@ToString(exclude = {"id", "intensiveUsers"})
public class UserTechnology implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "technology_id")
    private Technology technologies;

    @Column(name = "technology_aprovement_date")
    private LocalDate technologyAprovementDate;

    @Column(name = "technology_level")
    private String technologyLevel;

    @ManyToMany(mappedBy = "userTechnologies")
    private Collection<IntensiveUser> intensiveUsers;


}
