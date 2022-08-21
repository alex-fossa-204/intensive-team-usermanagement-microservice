package dev.alexfossa.usermanagementmicroservice.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "credential")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"id"})
public class Credential implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "last_login_date")
    private LocalDate lastLoginDate;

    @Column(name = "is_non_locked")
    private Boolean inNonLocked;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_credential_non_expired")
    private Boolean isCredentialNonExpired;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private IntensiveUser intensiveUser;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "credential_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

}
