package com.redolf.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_parents")
public class Parent {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="parent_id")
    private int parentId;
    @Column(name="firstname",nullable=false)
    private String firstName;

    @Column(name="last_name",nullable=false)
    private String lastName;
    
}
