package dev.alexfossa.usermanagementmicroservice.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "contact")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"id", "intensiveUsers"})
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "skype_login")
    private String skypeLogin;

    @Column(name = "email")
    private String email;

    @Column(name = "telegram_login")
    private String telegramLogin;

    @Column(name = "github_profile")
    private String githubProfile;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private IntensiveUser intensiveUserContact;

}
