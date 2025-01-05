package com.hmmk.melkite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String email;
    private boolean enabled;
    private String firstName;
    private String lastName;
    private String credentials;
    private List<String> groups;
    private List<String> realmRoles;
}
