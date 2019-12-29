package com.dirs.files.dirsAndFiles.DAO;

import com.dirs.files.dirsAndFiles.Model.Directory;
import com.dirs.files.dirsAndFiles.Model.MyFile;

import java.util.List;

public interface FileDAO {
    Long saveFile(MyFile file);
    List<MyFile> getFilesByDirectory(Directory directory);
}
