package com.example.spring.student.endpoints.dao;

import com.example.spring.student.endpoints.bean.Student;
import com.example.spring.student.endpoints.dbservice.CollectBranchCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentPagingAndSorting extends JpaRepository<Student,Integer>
{
    Page<Student> findAll(Pageable pageable);
    List<Student> findByMarkBetween(int startMark,int endMark,Pageable pageable);
    List<Student> findByStudentName(String studentName, Sort sort);


     @Query(value = "select s.studentBranch as studentBranchName, count(s) as branchCount from Student s group by s.studentBranch")
     List<CollectBranchCount> collectBranchCountByBranch();

     @Modifying
     @Transactional
     @Query(value = "update Student s set s.studentName = :studentName where s.studentId = :studentId")
     int updateStudent(@Param("studentId") int id, @Param("studentName") String name);




}
