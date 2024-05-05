import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private int id;

    @Column(name="author_name")
    private String name;

    @Column(name="author_birth_date")
    private LocalDate birthDate;

    @Column(name="author_country")
    private String country;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

}
