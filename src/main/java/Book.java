import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_name", nullable = false)
    private String name;

    @Column(name = "book_publication_year")
    private String publicationYear;

    @Column(name = "book_stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "book_author_id", referencedColumnName = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "book2category",
            joinColumns = {@JoinColumn(name = "book2category_book_id")},
            inverseJoinColumns = {@JoinColumn(name = "book2category_category_id")}
    )
    private List<Category> categoryList;

    @OneToMany(mappedBy = "book")
    private List<BookBorrowing> borrowingList;

}
