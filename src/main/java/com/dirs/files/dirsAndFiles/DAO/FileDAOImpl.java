package com.dirs.files.dirsAndFiles.DAO;

import com.dirs.files.dirsAndFiles.Model.Directory;
import com.dirs.files.dirsAndFiles.Model.MyFile;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class FileDAOImpl implements FileDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Long saveFile(MyFile file) {
        Session session = entityManager.unwrap(Session.class);
        return (Long) session.save(file);
    }

    @Override
    public List<MyFile> getFilesByDirectory(Directory directory) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from MyFile f where f.directory = :directory", MyFile.class);
        query.setParameter("directory", directory);
        return query.getResultList();
    }
}
