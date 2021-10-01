package controller;

import model.File;
import repository.Impl.FileRepositoryImpl;
import service.FileService;

import java.util.List;

public class FileController {

    private final service.FileService FileService;

    public FileController(FileService FileService) {
        this.FileService = FileService;
    }

    public List<File> getAll(){
        return FileService.getAll();
    }

    public File getById(Integer id){
        return FileService.getById(id);
    }

    public File save(File file){
        return FileService.save(file);
    }

    public File update(File file){
        return FileService.update(file);
    }

    public void deleteById(Integer id){
        FileService.deleteById(id);
    }

}
