package pl.fyrla.loginregistration.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Krzysztof
 * @project login-registration
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private boolean enabled;

    /*@OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "usersId", updatable =  false, insertable = false)
    private List<Authorities> authorities;*/
}
