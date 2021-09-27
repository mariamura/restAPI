package controller;

import model.File;
import repository.Impl.FileRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class FileController {

    private final FileRepositoryImpl fileRepository;

    public FileController(FileRepositoryImpl fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<File> getAll(){
        return fileRepository.getAll();
    }

    public File getById(Integer id){
        return fileRepository.getById(id);
    }

    public File save(File file){
        return fileRepository.save(file);
    }

    public File update(File file){
        return fileRepository.update(file);
    }

    public void deleteById(Integer id){
        fileRepository.deleteById(id);
    }

    public void printAll() {
        fileRepository.getAll().
                stream().
                forEach(n -> System.out.println(n.getId() + ": " + n.getName()));
    }
}
