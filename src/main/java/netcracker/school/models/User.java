package netcracker.school.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "USERS")
@NamedQueries({
        @NamedQuery(name = User.NamedQuery.USER_FIND_BY_EMAIL, query = "from User where email = :email")
})
public class User {

    @GenericGenerator(
            name = "userSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "users_user_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "userSequenceGenerator")
    @Column(name = "USER_ID", unique=true, nullable=false)
    private Long id;

    @Column(name = "FIRSTNAME", nullable=false)
    private String firstname;

    @Column(name = "LASTNAME", nullable=false)
    private String lastname;

    @Column(name = "EMAIL", unique=true, nullable=false)
    private String email;


    @Column(name = "PASSWORD", nullable=false)
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user_role_id", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SELECT)
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<UserRole>();

    @OneToMany(mappedBy = "user_p_id", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SELECT)
    @JsonIgnore
    private Set<ReaderPassport> readerPassports = new HashSet<ReaderPassport>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<ReaderPassport> getReaderPassports() {
        return readerPassports;
    }

    public void setReaderPassports(Set<ReaderPassport> readerPassports) {
        this.readerPassports = readerPassports;
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
