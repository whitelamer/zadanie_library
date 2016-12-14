package netcracker.school.models;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Parameter;
import javax.persistence.Table;

/**
 * Created by user on 09.12.16.
 */
@Entity
@Table(name = "READERPASSPORTS")
public class ReaderPassport{

    @GenericGenerator(
            name = "passportSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "passport_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "passportSequenceGenerator")
    @Column(name = "ID", unique=true, nullable=false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

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
                ", user=" + user +
                ", user_id=" + user_id +
                ", role='" + role + '\'' +
                ", state=" + state +
                ']';
    }
}
