package com.dirs.files.dirsAndFiles.Service;

import com.dirs.files.dirsAndFiles.DAO.DirectoryDAO;
import com.dirs.files.dirsAndFiles.DTO.DirectoryDTO;
import com.dirs.files.dirsAndFiles.Model.Directory;
import com.dirs.files.dirsAndFiles.Model.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectoryServiceImpl implements DirectoryService {
    @Autowired
    private DirectoryDAO directoryDAO;

    @Override
    public List<DirectoryDTO> getAllDirectories() {
        return directoryDAO.getAllDirectories().stream()
                .map(directory -> createDirectoryDTO(directory))
                .collect(Collectors.toList());
    }

    @Override
    public Long saveDirectory(Directory directory) {
        return directoryDAO.saveDirectory(directory);
    }

    @Override
    public DirectoryDTO createDirectoryDTO(Directory directory) {
        List<MyFile> files = directory.getFiles();
        long filesCount = files.stream()
                .filter(file -> file.getSize() != null)
                .count();
        long directoriesCount = files.size() - filesCount;
        long filesSizeCount = files.stream()
                .filter(file -> file.getSize() != null)
                .mapToLong(file -> file.getSize())
                .sum();

        return new DirectoryDTO(
                directory.getId(),
                directory.getCreatedDate(),
                directory.getPath(),
                directoriesCount,
                filesCount,
                filesSizeCount
        );
    }
}
