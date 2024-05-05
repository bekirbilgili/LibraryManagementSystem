import jakarta.persistence.*;

import java.time.LocalDate;

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
}
