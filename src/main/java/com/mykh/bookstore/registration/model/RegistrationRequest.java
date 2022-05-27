package com.mykh.bookstore.registration.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class RegistrationRequest implements Request{

    @NotNull
    @NotEmpty
    private String firstName;
    
    private String lastName;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull    
    @NotEmpty
    private String password;

}
