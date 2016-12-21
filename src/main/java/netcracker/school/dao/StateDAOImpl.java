package netcracker.school.dao;

import netcracker.school.models.Category;
import netcracker.school.models.State;
import org.springframework.stereotype.Repository;

@Repository("StateDAO")
public class StateDAOImpl extends AbstractDaoImpl<State> implements StateDAO {
}
