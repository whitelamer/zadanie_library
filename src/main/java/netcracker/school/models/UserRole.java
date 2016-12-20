package netcracker.school.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "USERROLE")
public class UserRole {

    @GenericGenerator(
            name = "roleSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "userrole_role_id_seq"),
                    @Parameter(name = "initial_value", value = "0"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "roleSequenceGenerator")
    @Column(name = "ROLE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonIgnore
    private User user_role_id;

    public User getUser() {
        return user_role_id;
    }
    public void setUser(User user) {
        this.user_role_id = user;
    }

    @Column(name = "USER_ID", nullable=false, insertable = false, updatable = false)
    private Long user_id;

    @Column(name = "ROLE", length=30, unique=true, nullable=false)
    private String role = UserReaderPassportType.USER.getUserReaderPassportType();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
