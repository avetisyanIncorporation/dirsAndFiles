package com.dirs.files.dirsAndFiles.Model;

import com.dirs.files.dirsAndFiles.Utils.MyFileUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class MyFile {
    @Id
    @GeneratedValue(generator = "fileIdSequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "fileIdSequence", sequenceName = "FILE_ID_SEQ", allocationSize = 1)
    private long id;
    @Column(name = "file_size")
    private Long size;
    @Column(name = "file_name")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "directory_id")
    private Directory directory;

    public MyFile() {
    }

    public MyFile(Long size, String name, Directory directory) {
        this.size = size;
        this.name = name;
        this.directory = directory;
    }

    public MyFile(Long size, String name) {
        this.size = size;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    @JsonIgnore
    public String getClearSize() {
        return MyFileUtil.getClearFileSize(this.size);
    }
}
