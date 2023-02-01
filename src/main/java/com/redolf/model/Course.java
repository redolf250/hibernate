package com.redolf.model;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_courses")
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="course_id")
    private int courseId; 
    @Column(name="course_name", nullable=false)
    private String courseName;
    @Column(name="course_code", nullable=false)
    private String courseCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private Student student;
    
}
