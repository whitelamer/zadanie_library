package netcracker.school.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user on 09.12.16.
 */
@javax.persistence.Entity
@Table(name = "READERPASSPORT")
@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(name = ReaderPassport.NamedQuery.FIND_BY_ACTIVE, query = "from ReaderPassport where state = 0 and user_id = :user_id"),
        @org.hibernate.annotations.NamedQuery(name = ReaderPassport.NamedQuery.FIND_BY_USER, query = "from ReaderPassport where user_id = :user_id")
})
public class ReaderPassport implements LibraryEntity {
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

    @OneToMany(mappedBy = "readerPassports", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Library> getedBooks;

    @Column(name = "USER_ID", nullable=false, insertable = false, updatable = false)
    private Long user_id;


    @Column(name = "STATE", nullable=false)
    private Long state;

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
                ", state=" + state +
                ']';
    }

    public List<Library> getGetedBooks() {
        return getedBooks;
    }

    public void setGetedBooks(List<Library> getedBooks) {
        this.getedBooks = getedBooks;
    }

    public static class NamedQuery {
        public static final String FIND_BY_ACTIVE = "ReaderPassport.findActiveByUserId";
        public static final String FIND_BY_USER = "ReaderPassport.findByUserId";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReaderPassport that = (ReaderPassport) o;

        if (!getId().equals(that.getId())) return false;
        if (getUser_id() != null ? !getUser_id().equals(that.getUser_id()) : that.getUser_id() != null) return false;
        return getState().equals(that.getState());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getUser_id() != null ? getUser_id().hashCode() : 0);
        result = 31 * result + getState().hashCode();
        return result;
    }
}
