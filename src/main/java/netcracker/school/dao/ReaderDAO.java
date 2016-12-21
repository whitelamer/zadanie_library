package netcracker.school.dao;

import netcracker.school.models.ReaderPassport;
import netcracker.school.models.User;

import java.util.List;

public interface ReaderDAO extends AbstractDao<ReaderPassport> {
    List<ReaderPassport> getActive(User user);

    List<ReaderPassport> getByUser(User user);
}
