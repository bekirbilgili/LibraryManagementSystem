import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "category_description", nullable = true)
    private String description;

    @ManyToMany(mappedBy = "categoryList")
    private List<Book> bookList;
}
