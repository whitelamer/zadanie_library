package netcracker.school.service;

import netcracker.school.dao.CategoryDAO;
import netcracker.school.dao.StateDAO;
import netcracker.school.models.Category;
import netcracker.school.models.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("StateService")
public class StateServiceImpl implements StateService{
    @Autowired
    @Qualifier("StateDAO")
    private StateDAO DAO;
    @Transactional
    public State create(State object) {
        DAO.create(object);
        return object;
    }

    @Transactional
    public void update(State object) {
        DAO.update(object);
    }

    @Transactional
    public List<State> getAll() {
        return DAO.getAll();
    }
}
