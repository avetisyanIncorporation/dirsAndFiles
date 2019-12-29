package com.dirs.files.dirsAndFiles.DAO;

import com.dirs.files.dirsAndFiles.Model.Directory;

import java.util.List;

public interface DirectoryDAO {
    List<Directory> getAllDirectories();
    Long saveDirectory(Directory directory);
    Directory getDirectoryById(long directoryId);
}
