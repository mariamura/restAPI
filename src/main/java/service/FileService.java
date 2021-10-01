package service;

import model.File;
import repository.Impl.FileRepositoryImpl;

import java.util.List;

public class FileService {
    private final FileRepositoryImpl fileRepository;

    public FileService(FileRepositoryImpl fileRepository) {
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
}
