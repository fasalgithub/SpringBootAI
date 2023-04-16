package com.example.microservice.studentInfo.controller;

import com.example.microservice.studentInfo.model.Student;
import com.example.microservice.studentInfo.model.TrainerInfo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    @Value("${spring.application.name}")
    private String myAppName;

    private static final String STUDENT_DB = "http://student-info:8002/students/info";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/info/{trainerId}")
    public TrainerInfo trainer(@PathVariable("trainerId") String trainerId) {

        List<Student> students = new ArrayList<>();
        students = dbReplica(STUDENT_DB);


        /*
                 Student[] studentsCollection = webClientBuilder.build()
                .get()
                .uri("http://localhost:8002/students/info")
                .retrieve()
                .bodyToMono(Student[].class)
                .block();


          */

        if(Objects.isNull(students) || students.isEmpty()) students = new ArrayList<>();

        List<TrainerInfo> trainers = List.of(
                new TrainerInfo("1", "Sharma",
                        students.stream().filter(student -> {
                                    return student.getTrainerName().equalsIgnoreCase("Sharma");
                                })
                                .collect(Collectors.toList())),
                new TrainerInfo("2", "Fasal",
                        students.stream().filter(student -> {
                                    return student.getTrainerName().equalsIgnoreCase("Fasal");
                                })
                                .collect(Collectors.toList())),
                new TrainerInfo("3", "Ganesh",
                        students.stream().filter(student -> {
                                    return student.getTrainerName().equalsIgnoreCase("Ganesh");
                                })
                                .collect(Collectors.toList())),
                new TrainerInfo("4", "Sharvesh",
                        students.stream().filter(student -> {
                                    return student.getTrainerName().equalsIgnoreCase("Sharvesh");
                                })
                                .collect(Collectors.toList()))
        );

        return trainers.stream().filter(Objects::nonNull)
                .filter(trainer -> trainer.getTrainerId().equalsIgnoreCase(trainerId))
                .findFirst()
                .orElse(new TrainerInfo());

    }



    @CircuitBreaker(name = "myAppName",fallbackMethod = "defaultStudentsInfo")
    public List<Student> dbReplica(String api)
    {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(STUDENT_DB, Student[].class)));
    }


    public List<Student> defaultStudentsInfo(){
        return List.of(
                new Student("Sathya", "Java Course", "Fasal", Boolean.TRUE),
                new Student("Abi", "Java Course", "Fasal", Boolean.TRUE),
                new Student("Riya", "Python Course", "Sharma", Boolean.FALSE),
                new Student("Kiruba", "Java Script Course", "Ganesh", Boolean.FALSE),
                new Student("Anu", "Java Course", "Sharvesh", Boolean.TRUE)
        );
    }
}
