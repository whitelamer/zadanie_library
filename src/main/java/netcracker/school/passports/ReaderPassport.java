package netcracker.school.passports;

import org.hibernate.annotations.*;

import javax.persistence.*;
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
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "PASSPORT_SEQUENCE"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "passportSequenceGenerator")
    @Column(name = "ID")
    private Long id;

//    @Autowired
//    private User user;
}
