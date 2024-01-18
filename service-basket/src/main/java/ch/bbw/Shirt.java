package ch.bbw;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Shirt {
    private Integer id;

    private String brand;
    private String squad;
    private int year;
    private double price;
    private String size;
    private String details;
}
