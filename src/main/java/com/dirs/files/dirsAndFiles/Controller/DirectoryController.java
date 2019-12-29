package com.dirs.files.dirsAndFiles.Controller;

import com.dirs.files.dirsAndFiles.DTO.DirectoryDTO;
import com.dirs.files.dirsAndFiles.Model.Directory;
import com.dirs.files.dirsAndFiles.Model.MyFile;
import com.dirs.files.dirsAndFiles.Service.DirectoryService;
import com.dirs.files.dirsAndFiles.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class DirectoryController {
    @Autowired
    private DirectoryService directoryService;
    @Autowired
    private FileService fileService;

    @GetMapping("/directories")
    public String getAllDirectories(Model model) {
        model.addAttribute("directories", directoryService.getAllDirectories());
        return "directories";
    }

    @GetMapping("/directory/{directoryId}")
    public String getDirectoryFiles(@PathVariable long directoryId, Model model) {
        model.addAttribute("files", fileService.getFilesByDirectoryId(directoryId));
        return "files :: table-fragment";
    }

    @ResponseBody
    @GetMapping("/add-directory")
    public DirectoryDTO addDirectory(@RequestParam String path) {
        File dirFiles[] = new File(path).listFiles();
        if (dirFiles == null) {
            throw new NullPointerException();
        }
        List<File> filesList = Arrays.asList(dirFiles);
        Directory directory = new Directory(path);
        directory.setId(directoryService.saveDirectory(directory));

        List<MyFile> directoryFiles = new ArrayList<>();
        for (File file : filesList) {
            MyFile myFile = new MyFile(file.isDirectory() ? null : file.length(), file.getName(), directory);
            myFile.setId(fileService.saveFile(myFile));
            directoryFiles.add(myFile);
        }
        directory.setFiles(directoryFiles);
        return directoryService.createDirectoryDTO(directory);
    }
}