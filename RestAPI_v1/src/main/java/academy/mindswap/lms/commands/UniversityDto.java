package academy.mindswap.lms.commands;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UniversityDto {

    @NotBlank (message = "Country must not be empty")
    private String country;
    private String name;
    private String[] domains;
}
