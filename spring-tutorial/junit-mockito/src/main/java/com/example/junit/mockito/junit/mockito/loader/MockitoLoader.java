package com.example.junit.mockito.junit.mockito.loader;

import com.example.junit.mockito.junit.mockito.dao.MockitoJob;
import com.example.junit.mockito.junit.mockito.repository.MockitoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class MockitoLoader
{
    @Autowired
    private MockitoRepository mockitoRepository;

    @PostConstruct
    public void loadMockito(){
        List<MockitoJob> mocks =  Stream.of(new MockitoJob(1,"mockito-Junit","Junit")
                ,new MockitoJob(2,"mockito-selenium","Selenium")
                ,new MockitoJob(3,"mockito-unit","Unit"))
                .collect(Collectors.toList());

        mockitoRepository.saveAll(mocks);
    }

}
