package netcracker.school.whitelamer.library;

import org.springframework.stereotype.Component;


@Component
public class User {

    private ReaderPassport readPassport;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}