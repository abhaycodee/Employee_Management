package com.example.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    private static final String UPLOAD_DIR = "uploads"; // Explicit folder name

    @PostConstruct
    public void init() {
        // Create the uploads directory dynamically at runtime if it does not exist
        File directory = new File(UPLOAD_DIR);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Uploads directory created at: " + directory.getAbsolutePath());
            } else {
                System.out.println("Failed to create uploads directory at: " + directory.getAbsolutePath());
            }
        }
    }

    // Method to store a file
    public String storeFile(MultipartFile file) throws IOException {
        // Dynamically handle the file storage path
        Path filePath = Paths.get(UPLOAD_DIR).resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath); // Copy file to the uploads folder
        return file.getOriginalFilename(); // Return the file name
    }

    // Method to load a file for downloading
    public Path loadFile(String filename) {
        return Paths.get(UPLOAD_DIR).resolve(filename);
    }

    // Method to check if a file exists
    public boolean fileExists(String filename) {
        return Files.exists(loadFile(filename));
    }
}
