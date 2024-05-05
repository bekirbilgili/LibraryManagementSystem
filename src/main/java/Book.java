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

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "book_author_id", referencedColumnName = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(name = "book2category",
            joinColumns = {@JoinColumn(name = "book2category_book_id")},
            inverseJoinColumns = {@JoinColumn(name = "book2category_category_id")}
    )
    private List<Category> categoryList;

    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<BookBorrowing> borrowingList;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<BookBorrowing> getBorrowingList() {
        return borrowingList;
    }

    public void setBorrowingList(List<BookBorrowing> borrowingList) {
        this.borrowingList = borrowingList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "categoryList=" + categoryList +
                ", publisher=" + publisher +
                ", author=" + author +
                ", stock=" + stock +
                ", publicationYear='" + publicationYear + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
