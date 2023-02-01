package com.redolf.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@Builder
@Transactional
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_students")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="student_id")
    private int studentId;

    @Column(name="st_reference",nullable=false)
    private String student_reference;
    @Column(name="firstname",nullable=false)
    private String firstName;

    @Column(name="last_name",nullable=false)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="parent_id")
    private Parent parent;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
    private List<Course> course;
}
