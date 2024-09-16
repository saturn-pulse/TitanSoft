package com.saturnPulse.SaturnPulse.Dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Component
public class AdminDTO {

    @NotNull(message = "please add name")
    @Pattern(regexp = "^[a-zA-Z\\s]+$",
            message = "The field must contain only letters and whitespace")
    private String name;


    @Pattern(regexp = "^[a-zA-Z0-9]+$",
            message = "The field must contain only letters and numbers")
    private String adminId;


    @Email(message = "please enter a valid email")
    private String email;


    @Size(min = 8, message = "should be 8 letters")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).*$",
            message = "Password must contain at least one letter and one special character")
    private String password;
}

