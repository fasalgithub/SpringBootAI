package com.example.file.starter;

import com.example.file.starter.bean.EventThreadExecutorService;
import com.example.file.starter.service.MyEventListener;
import com.example.file.starter.service.MyFirstTikka;
import com.example.file.starter.service.MyFirstUnivocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class FileStarterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FileStarterApplication.class, args);
    }

    @Autowired
    private MyFirstTikka myFirstTikka;
    @Autowired
    private MyFirstUnivocity myFirstUnivocity;
    @Autowired
    private MyEventListener myEventListener;
    @Autowired
    private EventThreadExecutorService eventThreadExecutorService;


    @Override
    public void run(String... args) throws Exception
    {
        File fileReadPath = new File("C:\\playground\\Qtree\\file hadling");
        List<String> listOfContent = myEventListener.process(fileReadPath);
        listOfContent.forEach(System.out::println);

//      eventThreadExecutorService.process();


    }
}
