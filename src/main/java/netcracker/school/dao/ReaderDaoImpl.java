package netcracker.school.dao;

import netcracker.school.models.ReaderPassport;
import netcracker.school.models.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository("ReaderDAO")
public class ReaderDaoImpl extends AbstractDaoImpl<ReaderPassport> implements ReaderDAO {
    @Override
    public List<ReaderPassport> getActive(User user) {
        if(user==null)return null;
        List<ReaderPassport> results =
                entityManager.createNamedQuery(ReaderPassport.NamedQuery.FIND_BY_ACTIVE, ReaderPassport.class)
                        .setParameter("user_id", user.getId())
                        .getResultList();
        return results;
    }

    @Override
    public List<ReaderPassport> getByUser(User user) {
        if(user==null)return null;
        List<ReaderPassport> results =
                entityManager.createNamedQuery(ReaderPassport.NamedQuery.FIND_BY_USER, ReaderPassport.class)
                        .setParameter("user_id", user.getId())
                        .getResultList();
        return results;
    }
}
