import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int id;

    @Column(name="publisher_name")
    private String name;

    @Column(name="publisher_est_year")
    private String establishmentYear;

    @Column(name="publisher_address")
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<Book> bookList;
}
