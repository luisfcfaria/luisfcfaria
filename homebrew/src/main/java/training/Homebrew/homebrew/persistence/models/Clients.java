package training.Homebrew.homebrew.persistence.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class Clients {

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true, updatable = false)
    private Long NIF;
    @Column (nullable = false)
    private String name;
    @Column (nullable = false)
    private String email;
    @Column (nullable = false)
    private String password;

}
