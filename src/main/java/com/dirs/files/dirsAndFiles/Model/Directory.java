package com.dirs.files.dirsAndFiles.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "directory")
public class Directory {
    @Id
    @GeneratedValue(generator = "directoryIdSequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "directoryIdSequence", sequenceName = "DIRECTORY_ID_SEQ", allocationSize = 1)
    private long id;
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Column(name = "directory_path")
    private String path;
    @OneToMany(mappedBy = "directory")
    private List<MyFile> files;

    public Directory() {
    }

    public Directory(String path) {
        this.createdDate = new Timestamp(new java.util.Date().getTime());
        this.path = path;
        this.files = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<MyFile> getFiles() {
        return files;
    }

    public void setFiles(List<MyFile> files) {
        this.files = files;
    }
}
