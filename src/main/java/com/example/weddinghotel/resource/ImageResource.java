package com.example.weddinghotel.resource;

import com.example.weddinghotel.dto.Image;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/images")
@CrossOrigin("*")
public class ImageResource {

    @Value("${image.baseUrl}")
    private String baseUrl;

    @Value("${image.location}")
    private String location;

    public ResponseEntity<Image> upload(@RequestParam MultipartFile file) throws IOException{
        String name = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"))
                .concat(file.getOriginalFilename());
        String imagePath = baseUrl.concat(name);

        file.transferTo(Paths.get(location).resolve(name));

        Image image = new Image(name, imagePath);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(image);
        }
    }

