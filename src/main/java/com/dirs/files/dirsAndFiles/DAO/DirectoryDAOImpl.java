package com.dirs.files.dirsAndFiles.DAO;

import com.dirs.files.dirsAndFiles.Model.Directory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DirectoryDAOImpl implements DirectoryDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Directory> getAllDirectories() {
        return entityManager.createQuery("From Directory", Directory.class).getResultList();
    }

    @Transactional
    @Override
    public Long saveDirectory(Directory directory) {
        Session session = entityManager.unwrap(Session.class);
        return (Long) session.save(directory);
    }

    @Override
    public Directory getDirectoryById(long directoryId) {
        Session session = entityManager.unwrap(Session.class);
        return session.load(Directory.class, directoryId);
    }
}
