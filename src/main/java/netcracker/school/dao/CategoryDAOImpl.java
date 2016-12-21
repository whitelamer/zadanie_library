package netcracker.school.dao;

import netcracker.school.models.Category;
import org.springframework.stereotype.Repository;

@Repository("CategoryDAO")
public class CategoryDAOImpl extends AbstractDaoImpl<Category> implements CategoryDAO {
}
