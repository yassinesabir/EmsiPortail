package ma.exemple.emsiCasablanca03.controller;

import java.io.IOException;

import ma.exemple.emsiCasablanca03.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class FilesController {

    @Autowired
    private FileService filesService;

    @PostMapping("/uploadFilesIntoDB")
    public ResponseEntity<String> storeFilesIntoDB(@RequestParam("file") MultipartFile file) throws IOException {
        String response = filesService.storeFile(file);
        return ResponseEntity.status(HttpStatus.OK).body(file.getOriginalFilename());
    }

    @GetMapping("/getFileByName/{fileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
        byte[] fileData = filesService.getFiles(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_OCTET_STREAM).body(fileData);
    }
}

