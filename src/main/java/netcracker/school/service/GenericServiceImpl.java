package netcracker.school.service;

import netcracker.school.dao.GenericDao;
import netcracker.school.models.ModelsForDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GenericServiceImpl<T extends ModelsForDAO> implements GenericService<T> {

    @Autowired
    GenericDao DAO;

    @Transactional
    public T create(T object) {
        DAO.create(object);
        return object;
    }

    @Transactional
    public void update(T object) {
        DAO.update(object);
    }

    @Transactional
    public List<T> getAll() {
        return DAO.getAll();
    }
}
