package com.dirs.files.dirsAndFiles.Service;

import com.dirs.files.dirsAndFiles.DAO.DirectoryDAO;
import com.dirs.files.dirsAndFiles.DAO.FileDAO;
import com.dirs.files.dirsAndFiles.Model.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDAO fileDAO;
    @Autowired
    private DirectoryDAO directoryDAO;

    @Override
    public Long saveFile(MyFile file) {
        return fileDAO.saveFile(file);
    }

    @Override
    public List<MyFile> getFilesByDirectoryId(long directoryId) {
        List<MyFile> allFiles = fileDAO.getFilesByDirectory(directoryDAO.getDirectoryById(directoryId));
        List<MyFile> directories = allFiles.stream()
                .filter(file -> file.getSize() == null)
                .sorted(Comparator.comparing(file -> file.getName().toLowerCase()))
                .collect(Collectors.toList());
        List<MyFile> files = allFiles.stream()
                .filter(file -> file.getSize() != null)
                .sorted(Comparator.comparing(file -> file.getName().toLowerCase()))
                .collect(Collectors.toList());

        List<MyFile> allSortedFiles = new ArrayList<>(directories);
        allSortedFiles.addAll(files);
        return allSortedFiles;
    }
}
