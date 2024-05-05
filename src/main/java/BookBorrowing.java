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

    @ManyToOne
    @JoinColumn(name = "borrowed_book_id", referencedColumnName = "book_id")
    private Book book;

}
