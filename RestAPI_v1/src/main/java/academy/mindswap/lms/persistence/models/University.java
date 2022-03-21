package academy.mindswap.lms.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Universities")
@JsonIgnoreProperties(ignoreUnknown = true)

public class University {
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    @Column
    private Integer ID;
//    @Column (nullable = false)
    @Column
    private String Country;
    @Column
    private String name;
    @Column
    private String[] domains;
}
