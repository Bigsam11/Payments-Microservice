package com.paymentservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "contentCreator")
public class ContentCreator extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="contentCreatorId",nullable = false)
    private Long id;

    @Column(name="firstName",nullable = false)
    private String firstName;

    @Column(name="lastName",nullable = false)
    private String lastName;

    @Column(name="email",nullable = true)
    @Email
    private String email;

    private Boolean isActive;

    @Column(name="phoneNumber",nullable = false)
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,mappedBy ="contentCreator")
    private Set<Contents> contents = new HashSet<>();

}
