package com.fashionstore.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long customerId;
    @NotBlank(message = "Username_not_blank")
    private String username;
    @NotBlank(message = "Password_not_blank")
    private String password;
    @NotBlank(message = "Fullname_not_blank")
    private String fullname;
    @NotBlank(message = "Email_not_blank")
    private String email;
    @NotBlank(message = "PhoneNumber_not_blank")
    private String phoneNumber;
    @NotBlank(message = "Address_not_blank")
    private String address;
}
