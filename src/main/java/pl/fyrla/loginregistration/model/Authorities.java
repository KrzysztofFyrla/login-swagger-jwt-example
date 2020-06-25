package pl.fyrla.loginregistration.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Authorities {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String username;
    private String authority;
}
