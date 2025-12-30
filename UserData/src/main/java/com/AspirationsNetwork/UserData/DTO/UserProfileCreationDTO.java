package com.AspirationsNetwork.UserData.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileCreationDTO {
    String uid;
    String firstName;
    String lastName;
    String email;
    String accountType;
    String role;
}
