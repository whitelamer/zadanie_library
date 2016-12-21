package netcracker.school.models;

import netcracker.school.models.Library;
import netcracker.school.models.ReaderPassport;
import netcracker.school.models.User;

import java.util.HashMap;
import java.util.List;

public class UserDetails {
    private User user;
    private List<ReaderPassport> activePreaderPassports;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ReaderPassport> getActivePreaderPassports() {
        return activePreaderPassports;
    }

    public void setActivePreaderPassports(List<ReaderPassport> activePreaderPassports) {
        this.activePreaderPassports = activePreaderPassports;
    }
}
