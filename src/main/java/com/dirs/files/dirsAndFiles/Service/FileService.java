package com.dirs.files.dirsAndFiles.Service;

import com.dirs.files.dirsAndFiles.Model.MyFile;

import java.util.List;

public interface FileService {
    Long saveFile(MyFile file);
    List<MyFile> getFilesByDirectoryId(long directoryId);
}
