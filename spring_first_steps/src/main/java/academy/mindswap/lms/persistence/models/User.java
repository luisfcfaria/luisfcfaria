package academy.mindswap.lms.persistence.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name= "users")
public class User {

    @Id
    private String name;
    @Column
    private String email;
    @Column
    private Integer Id;

}

