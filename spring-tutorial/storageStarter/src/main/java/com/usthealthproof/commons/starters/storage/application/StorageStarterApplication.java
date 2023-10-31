package com.usthealthproof.commons.starters.storage.application;

import com.usthealthproof.commons.starters.storage.api.StorageReader;
import com.usthealthproof.commons.starters.storage.api.StorageWriter;
import com.usthealthproof.commons.starters.storage.core.validation.helper.FileReaderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.usthealthproof"})
public class StorageStarterApplication{

    @Value("${listen.root.path}")
    String listenRootPath;

    @Autowired
    StorageReader storageReader;

    @Autowired
    StorageWriter storageWriter;

    public static void main(String[] args) {
        SpringApplication.run(StorageStarterApplication.class, args);
    }



}