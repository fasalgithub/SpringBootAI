package com.example.junit.mockito.junit.mockito.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MockitoJob
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mockitoId;
    private String mockitoName;
    private String mockitoCourse;
}
