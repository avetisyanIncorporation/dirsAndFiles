package com.dirs.files.dirsAndFiles.DTO;


import com.dirs.files.dirsAndFiles.Utils.MyFileUtil;

import java.sql.Timestamp;

public class DirectoryDTO {
    private long id;
    private Timestamp createdDate;
    private String path;
    private long directoriesCount;
    private long filesCount;
    private long filesSizeCount;

    public DirectoryDTO(long id, Timestamp createdDate, String path, long directoriesCount, long filesCount, long filesSize) {
        this.id = id;
        this.createdDate = createdDate;
        this.path = path;
        this.directoriesCount = directoriesCount;
        this.filesCount = filesCount;
        this.filesSizeCount = filesSize;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getFilesCount() {
        return filesCount;
    }

    public void setFilesCount(long filesCount) {
        this.filesCount = filesCount;
    }

    public long getFilesSizeCount() {
        return filesSizeCount;
    }

    public void setFilesSizeCount(long filesSizeCount) {
        this.filesSizeCount = filesSizeCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDirectoriesCount() {
        return directoriesCount;
    }

    public void setDirectoriesCount(long directoriesCount) {
        this.directoriesCount = directoriesCount;
    }

    public String getClearSize() {
        return MyFileUtil.getClearFileSize(this.filesSizeCount);
    }
}
