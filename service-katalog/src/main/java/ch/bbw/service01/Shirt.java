package ch.bbw.service01;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Shirt {
    private int id;
    private String brand;
    private String squad;
    private int year;
    private double price;
    private String size;
    private String details;
}
