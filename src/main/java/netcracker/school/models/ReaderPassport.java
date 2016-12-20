package netcracker.school.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by user on 09.12.16.
 */
@Entity
@Table(name = "READERPASSPORT")
public class ReaderPassport{

    @GenericGenerator(
            name = "passportSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "readerpassport_passport_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "passportSequenceGenerator")
    @Column(name = "passport_id", unique=true, nullable=false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonIgnore
    private User user_p_id;

    public User getUser() {
        return user_p_id;
    }
    public void setUser(User user) {
        this.user_p_id = user;
    }
    //    @ManyToOne
//    @JoinColumn(name = "USER_ID")


    @Column(name = "USER_ID", nullable=false, insertable = false, updatable = false)
    private Long user_id;

    @Column(name="ROLE", length=30, unique=true, nullable=false)
    private String role = UserReaderPassportType.USER.getUserReaderPassportType();

    @Column(name = "STATE", nullable=false)
    private Long state;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ReaderPassport [" +
                "id=" + id +
                ", user=" + user_p_id +
                ", user_id=" + user_id +
                ", role='" + role + '\'' +
                ", state=" + state +
                ']';
    }
}
