package com.example.springbeanlifecycle.springbootjpa.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_TABLE")
@AllArgsConstructor
@NoArgsConstructor
@Data

@NamedQuery(name="Student.retrieveMySurNameByMyName",
          query = " from Student s where s.studentName = ?1")
@NamedNativeQuery(name="Student.getStudentByMarkInBetween",query = "Select * from STUDENT_TABLE where STUDENT_MARK Between ?1 and ?2",resultClass = Student.class)
/*@NamedQueries({
        @NamedQuery(name="",query = ""),
        @NamedQuery(name="",query = "")
})
@NamedNativeQuery(name="",query = "",resultClass = Student.class)
@NamedNativeQueries({
        @NamedNativeQuery(name="",query = "",resultClass = Student.class),
        @NamedNativeQuery(name="",query = "",resultClass = Student.class)
})*/
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_ID",length = 30)
    private int studentId;
    @Column(name = "STUDENT_NAME",unique = true)
    private String studentName;
    @Column(name = "STUDENT_SURNAME",unique = true)
    private String studentSurName;
    @Column(name = "STUDENT_BATCH",unique = true)
    private String studentBatch;
    @Column(name="STUDENT_MARK",length = 255)
    private Integer studentMark;

}
