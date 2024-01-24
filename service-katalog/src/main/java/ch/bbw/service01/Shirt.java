package ch.bbw.service01;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Shirt")  // Ensure this matches your table name in the database
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Shirt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "squad")
    private String squad;

    @Column(name = "year")
    private int year;

    @Column(name = "price")
    private double price;

    @Column(name = "size")
    private String size;

    @Column(name = "details")
    private String details;

    public Shirt(String brand, String squad, int year, double price, String size, String details) {
        this.brand = brand;
        this.squad = squad;
        this.year = year;
        this.price = price;
        this.size = size;
        this.details = details;
    }

    // If you need to define any business logic or non-standard behavior,
    // you can add methods here.

    // The Lombok annotations will automatically generate standard setters,
    // getters, and other utility methods.
}
