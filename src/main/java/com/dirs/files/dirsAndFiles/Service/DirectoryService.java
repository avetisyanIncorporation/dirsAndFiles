package com.dirs.files.dirsAndFiles.Service;

import com.dirs.files.dirsAndFiles.DTO.DirectoryDTO;
import com.dirs.files.dirsAndFiles.Model.Directory;

import java.util.List;

public interface DirectoryService {
    List<DirectoryDTO> getAllDirectories();
    Long saveDirectory(Directory directory);
    DirectoryDTO createDirectoryDTO(Directory directory);
}
