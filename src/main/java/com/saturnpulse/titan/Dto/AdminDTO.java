package com.saturnpulse.titan.Dto;
;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;


@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class AdminDTO {

    @NotNull(message = "name should be added and must  not be blank")
    private String name;


    @Pattern(regexp = "^(?=.*[a-zA-Z].*[a-zA-Z].*[a-zA-Z])(?=.*\\d).*$",
            message = "Admin ID must contain at least 3 letters and at least one digit")
    @Size(min = 6)
    private String username;


    @Email(message = "please enter a valid email")
    private String email;


    @Size(min = 8, message = "should be 8 letters")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).*$",
            message = "Password must contain at least one letter and one special character")
    private String password;
}

