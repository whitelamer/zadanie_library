package netcracker.school.service;

import netcracker.school.dao.CategoryDAO;
import netcracker.school.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    @Qualifier("CategoryDAO")
    private CategoryDAO DAO;
    @Transactional
    public Category create(Category object) {
        DAO.create(object);
        return object;
    }

    @Transactional
    public void update(Category object) {
        DAO.update(object);
    }

    @Transactional
    public List<Category> getAll() {
        return DAO.getAll();
    }
}
