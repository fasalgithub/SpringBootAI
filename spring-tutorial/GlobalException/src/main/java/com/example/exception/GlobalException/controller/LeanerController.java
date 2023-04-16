package com.example.exception.GlobalException.controller;

import com.example.exception.GlobalException.customexception.InvalidDateException;
import com.example.exception.GlobalException.customexception.NoSuchElementFoundException;
import com.example.exception.GlobalException.model.Leaner;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("leaners")
public class LeanerController {
    List<Leaner> list = new ArrayList<>();

    @PostConstruct
    public void AddMyLeaners() {
        list.add(new Leaner("1", "sathya", "Java"));
        list.add(new Leaner("2", "abi", "Django"));
        list.add(new Leaner("3", "ram", "Python"));
        list.add(new Leaner("4", "prem", "Spring boot"));
    }

    @PreDestroy
    public void destroy() {
        list.clear();
    }

    @GetMapping("/get-leanername/{no}")
    public String getMyLeanerName(@PathVariable("no") String no) {
        Leaner myLeaner = list.stream()
                .filter(leaner -> leaner.getLeanerNo().equalsIgnoreCase(no))
                .findFirst().orElse(null);

        return myLeaner.getLeanerName();
    }

    @GetMapping("/get/{no}")
    public ResponseEntity<?> getMyLeaner(@PathVariable("no") String no) throws NoSuchElementFoundException {

        Leaner myLeaner = list.stream()
                .filter(leaner -> leaner.getLeanerNo().equalsIgnoreCase(no))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementFoundException("leaner is not available"));

        return new ResponseEntity<>(myLeaner, HttpStatus.OK);

    }

    @PostMapping("/post")
    public ResponseEntity<?> getMyLeaner(@RequestBody Leaner leaner) throws InvalidDateException {
        if (StringUtils.isBlank(leaner.getLeanerNo()) || StringUtils.isBlank(leaner.getLeanerName()))
            throw new InvalidDateException("invalid leaner must give valid leaner number, leaner name");

        list.add(leaner);
        return new ResponseEntity<>(leaner, HttpStatus.OK);

    }

}
