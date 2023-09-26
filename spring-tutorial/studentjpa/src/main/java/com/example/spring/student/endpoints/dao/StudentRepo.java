/*
package com.example.spring.student.endpoints.dao;


import com.example.spring.student.endpoints.bean.Student;
import com.example.spring.student.endpoints.dbservice.CollectBloodGroupCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


//Repository -> Marker Interface
//CrudRepository -> Iterable
//JpaRepository
//PagingAndSortingRepository
@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>
{
    //Method param

    //Named Query
    //Query Method




    List<Student> findStudentByStudentBranch(String branch);

    List<Student> findByStudentBranchAndMark(String branch,int mark);
    List<Student> findByStudentBranchOrMark(String branch,int mark);

    List<Student> findByMarkBetween(int mark1,int marks);
    List<Student> findByMarkGreaterThan(int mark1);
    List<Student> findByMarkGreaterThanEqual(int mark1);

    List<Student> findByBloodGroupNull();

    List<Student> findByStudentNameContaining(String student);
    List<Student> findByStudentNameStartingWith(String student);

    //NamedQuery
    List<Student> retrieveStudentsByBloodGroup(String bloodGroup);
    List<Student> retrieveStudentsByMarks(int mark);
    @Query("from Student s where s.mark = ?1")
    List<Student> getMyStudentByMarks(int mark);

    @Query(value = "Select * from student_info where mark = ?1 ",nativeQuery = true)
    List<Student> getMyStudentByMarksNative(int mark);
    @Query("from Student s where s.studentName = :studentName and s.studentBranch = :studentBranch")
    List<Student> getMyStudentByStudentNameAndStudentBranch(@Param("studentName") String name,@Param("studentBranch") String branch);

    //select perticular column
    @Query("select s.bloodGroup as bloodGroup, count(s.bloodGroup) as bloodCount from Student s group by s.bloodGroup")
    List<CollectBloodGroupCount> getBloodGroup();

    //modified
    @Transactional
    @Modifying
    @Query("update Student s set s.studentName = :studentName where s.studentId = :id")
    int updateStudentCount(@Param("studentName") String name,@Param("id") Integer id);


    @Override
    Page<Student> findAll(Pageable pageable);
//    List<Student> findByStudentBranch(Sort sort);




}
*/
