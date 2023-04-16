package com.example.springbeanlifecycle.springbootjpa.dao;

import com.example.springbeanlifecycle.springbootjpa.StudentCountByMarks;
import com.example.springbeanlifecycle.springbootjpa.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>
{
    List<Student> findByStudentName(String studentName);
    List<Student> findByStudentMark(int mark);

    List<Student> findByStudentMarkBetween(int mark1,int mark2);
    List<Student> findByStudentMarkLessThan(int mark1);
    List<Student> findByStudentMarkLessThanEqual(int mark1);
    List<Student> findByStudentMarkGreaterThan(int mark1);
    List<Student> findByStudentMarkGreaterThanEqual(int mark1);

    List<Student> findByStudentSurNameNull();
    List<Student> findByStudentSurNameNotNull();

    List<Student> findByStudentNameLike(String studentName);
    List<Student> findByStudentNameNotLike(String studentName);


    List<Student> findByStudentNameStartingWith(String studentName);
    List<Student> findByStudentNameEndingWith(String studentName);

    List<Student> findByStudentMarkIn(Collection<Integer> marks);
    List<Student> findByStudentMarkNotIn(Collection<Integer> marks);

    List<Student> findByStudentNameIgnoreCase(String name);


    List<Student> retrieveMySurNameByMyName(String name);
    List<Student> getStudentByMarkInBetween(int mark1,int mark2);


    @Query(value = " from Student s where s.studentBatch = ?1")
    List<Student> getStudentByBranch(String batch);

    @Query(value = " select * from STUDENT_TABLE where STUDENT_BATCH = ?1",nativeQuery = true)
    List<Student> getStudentByBatchWithNative(String batch);

    @Query(value = " from Student s where s.studentBatch = :studentBatch")
    List<Student> getStudentByBranchNamedParameter(@Param("studentBatch") String branch);



    @Query(value = "select s.studentName,count(s.studentName) from Student s group by s.studentName")
    List<StudentCountByMarks> listOfStudentsCountByMark();









}
