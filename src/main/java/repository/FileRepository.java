package repository;

import model.File;

import java.util.List;

public interface FileRepository {
    File save(File file);

    File getById(Integer id);

    void deleteById(Integer id);

    List<File> getAll();

    File update(File file);
}
