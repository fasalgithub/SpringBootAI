package com.example.junit.mockito.junit.mockito.repository;

import com.example.junit.mockito.junit.mockito.dao.MockitoJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockitoRepository extends JpaRepository<MockitoJob,Integer> {
}
