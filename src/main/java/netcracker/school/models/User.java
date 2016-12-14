package netcracker.school.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 01.12.16.
 * @Table(name = "USERS")
 */
//@NamedQueries({
//        @NamedQuery(name = User.NamedQuery.USER_FIND_ALL, query = "from User"),
//        @NamedQuery(name = User.NamedQuery.USER_FIND_BY_ID, query = "from User where id = :id") })
@NamedNativeQueries({
        @NamedNativeQuery(name = User.NamedQuery.USER_FIND_BY_EMAIL, query = "select * from users where EMAIL =:email", resultClass = User.class) })

@Entity
@Table(name = "USERS")
public class User {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", unique=true, nullable=false)
    private Integer id;

    @Column(name = "FIRSTNAME", nullable=false)
    private String firstname;

    @Column(name = "LASTNAME", nullable=false)
    private String lastname;

    @Column(name = "EMAIL", unique=true, nullable=false)
    private String email;

    @Column(name = "PASSWORD", nullable=false)
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SELECT)
    @MapKey(name = "user_id")
//    @JoinTable(name = "READERPASSPORTS",
//            joinColumns = { @JoinColumn(name = "ID") },
//            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<ReaderPassport> userPassports = new HashSet<ReaderPassport>();



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ReaderPassport> getUserPassports() {
        return userPassports;
    }

    public void setUserPassports(Set<ReaderPassport> userPassports) {
        this.userPassports = userPassports;
    }

    public static class NamedQuery {
//        public static final String USER_FIND_ALL = "User.findAll";
//        public static final String USER_FIND_BY_ID = "User.findById";
        public static final String USER_FIND_BY_EMAIL = "User.findByEmail";
    }

    @Override
    public String toString() {
        return "User [" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!getId().equals(user.getId())) return false;
        if (!getFirstname().equals(user.getFirstname())) return false;
        if (!getLastname().equals(user.getLastname())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        return getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getFirstname().hashCode();
        result = 31 * result + getLastname().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }


}
