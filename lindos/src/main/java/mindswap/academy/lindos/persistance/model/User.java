package mindswap.academy.lindos.persistance.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String name;
    private String email;
    private Integer Id;

}
