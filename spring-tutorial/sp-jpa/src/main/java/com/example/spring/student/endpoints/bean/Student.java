package com.example.spring.student.endpoints.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="Student_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor

@NamedQuery(name = "Student.retrieveStudentsByMarks",query = "from Student s where s.mark =?1")
@NamedNativeQuery(name = "Student.retrieveStudentsByBloodGroup",
        query = "Select * from Student_Info where blood_group = ?1",
        resultClass = Student.class)
@NamedQueries({
        @NamedQuery(name = "",query = ""),
        @NamedQuery(name = "",query = "")
})

@NamedNativeQueries({
        @NamedNativeQuery(name = "",query = "",resultClass = Student.class),
        @NamedNativeQuery(name = "",query = "",resultClass = Student.class)
})

public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    private String studentName;
    private String studentBranch;
    private int mark;
    private String bloodGroup;

}
