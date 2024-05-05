import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book_borrowing")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowing_id")
    private int id;

    @Column(name = "borrower_name")
    private String name;

    @Column(name = "borrowing_date")
    private LocalDate borrowDate;

    @Column(name = "return_date", nullable = true)
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "borrowed_book_id", referencedColumnName = "book_id")
    private Book book;

    public BookBorrowing() {
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

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookBorrowing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", book=" + book +
                '}';
    }
}
