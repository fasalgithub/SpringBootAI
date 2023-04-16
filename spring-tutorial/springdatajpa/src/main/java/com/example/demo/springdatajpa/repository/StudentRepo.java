package com.example.demo.springdatajpa.repository;

import com.example.demo.springdatajpa.dao.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>
{
}
