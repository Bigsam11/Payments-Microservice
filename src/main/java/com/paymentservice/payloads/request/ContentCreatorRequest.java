package com.paymentservice.payloads.request;


import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ContentCreatorRequest {

    @NotEmpty(message="FirstName cannot be empty")
    @NotBlank
    private String firstName;

    @NotEmpty(message="LastName cannot be empty")
    @NotBlank
    private String lastName;

    @NotEmpty(message="Email cannot be empty")
    @NotBlank
    private String email;

    @NotEmpty(message="PhoneNumber cannot be empty")
    @NotBlank
    private String phoneNumber;

}
