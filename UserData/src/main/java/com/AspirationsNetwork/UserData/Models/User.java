package com.AspirationsNetwork.UserData.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    String uid;
    String accountType;
    String affiliation;
    String [] badges;
    String [] socials;
    String firstName;
    String lastName;
    String email;
    String avatar;
    String role;
}
