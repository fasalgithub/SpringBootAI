package com.example.junit.mockito.junit.mockito.controller;

import com.example.junit.mockito.junit.mockito.dao.MockitoJob;
import com.example.junit.mockito.junit.mockito.repository.MockitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mockito")
public class MockitoController {

    @Autowired
    private MockitoRepository mockitoRepository;

    @GetMapping("/get-mock-id/{id}")
    public Optional<MockitoJob> getMyMockitoById(@PathVariable("id") Integer id) {
        return mockitoRepository.findById(id);
    }

    @GetMapping("/get-mocks")
    public List<MockitoJob> getMyAllMockitoById() {
        return mockitoRepository.findAll();
    }

    @PostMapping("/post-mock-id")
    public MockitoJob postMyMockito(@RequestBody MockitoJob mockito) {
        mockitoRepository.save(mockito);
        return mockito;
    }


}
