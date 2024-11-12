package com.fashionstore.respone;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponeDTO {

    private Long customerId;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String phoneNumber;
    private String address;
}
