package ma.exemple.emsiCasablanca03.service;

import java.io.File;
import java.io.IOException;

import ma.exemple.emsiCasablanca03.repositories.FileRepository;
import ma.exemple.emsiCasablanca03.entities.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    private final String FILE_PATH = "E:\\projects\\images\\storage\\";

    public String storeFile(MultipartFile file) throws IOException {
        Files files = Files.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .fileData(file.getBytes())
                .build();

        files = fileRepository.save(files);

        if (files.getId() != null) {
            return files.getName(); // Return the file name for successful upload
        }

        return null;
    }

    public byte[] getFiles(String fileName) {
        return fileRepository.findByName(fileName).getFileData();
    }

    public String storeDataIntoFileSystem(MultipartFile file) throws IOException {
        String filePath = FILE_PATH + file.getOriginalFilename();

        Files files = Files.builder()
                .name(file.getOriginalFilename())
                .path(filePath)
                .type(file.getContentType())
                .fileData(file.getBytes())
                .build();

        files = fileRepository.save(files);

        file.transferTo(new File(filePath));

        if (files.getId() != null) {
            return files.getName(); // Return the file name for successful upload
        }

        return null;
    }

    public byte[] downloadFilesFromFileSystem(String fileName) throws IOException {
        String path = fileRepository.findByName(fileName).getPath();
        return java.nio.file.Files.readAllBytes(new File(path).toPath());
    }
}
