package com.example.spring.student.endpoints.dao;


import com.example.spring.student.endpoints.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>
{

}
