package netcracker.school.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Timestamp;

@javax.persistence.Entity
@Table(name = "LIBRARY")
@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(name = Library.NamedQuery.FIND_BY_PASSPORT, query = "from Library where passport_id = :passport_id"),
        @org.hibernate.annotations.NamedQuery(name = Library.NamedQuery.FIND_BY_BOOK, query = "from Library where book_id = :book_id"),
        @org.hibernate.annotations.NamedQuery(name = Library.NamedQuery.FIND_BY_PASSPORT_STATE, query = "from Library where state=0 and passport_id = :passport_id"),
        @org.hibernate.annotations.NamedQuery(name = Library.NamedQuery.FIND_BY_BOOK_STATE, query = "from Library where state=0 and book_id = :book_id")
})
public class Library implements LibraryEntity {

    @GenericGenerator(
            name = "librarySequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "library_id_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "librarySequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "passport_id")
    private Long passport_id;

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    @JsonIgnore
    private Book book;

    @Column(name = "book_id")
    private Long book_id;

    @Column(name = "state")
    private Integer state;

    @Column(name = "take_date")
    private Timestamp take_date;

    public Library() {
        super();
    }
    public Library(Long passport_id,Long book_id) {
        super();
        setBook_id(book_id);
        setPassport_id(passport_id);
        setState(0);
        setTake_date(new Timestamp(System.currentTimeMillis()));
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPassport_id() {
        return passport_id;
    }

    public void setPassport_id(Long passport_id) {
        this.passport_id = passport_id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Timestamp getTake_date() {
        return take_date;
    }

    public void setTake_date(Timestamp take_date) {
        this.take_date = take_date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public static class NamedQuery {
        public static final String FIND_BY_PASSPORT = "Library.findByPassport";
        public static final String FIND_BY_BOOK = "Library.findByBook";
        public static final String FIND_BY_PASSPORT_STATE = "Library.findByPassportState";
        public static final String FIND_BY_BOOK_STATE = "Library.findByBookState";
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "passport_id", insertable = false, updatable = false)
    private ReaderPassport readerPassports;

    public ReaderPassport getReaderPassports() {
        return readerPassports;
    }

    public void setReaderPassports(ReaderPassport readerPassports) {
        this.readerPassports = readerPassports;
    }
}
