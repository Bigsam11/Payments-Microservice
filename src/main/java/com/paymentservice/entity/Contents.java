package com.paymentservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "contents")
public class Contents extends  AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="contentId",nullable = false)
    private Long id;

    @Column(name="title",nullable = false)
    public String title;

    @Column(name="description",nullable = false)
    public String description;

    @Column(name="content",nullable = false)
    public String content;

    @Column(name="contentAmount",nullable = false)
    public Double contentAmount;

    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "content_creator_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public  ContentCreator contentCreator;

}
