package academy.mindswap.lms.commands;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Integer id;
    @NotBlank (message= "name can't be empty")
    private String name;
    @Email (message = "insert a valid email")
    private String email;
}
