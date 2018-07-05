package logos.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Builder
@Table(name = "product", indexes = @Index(columnList = "name"))
@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class Product extends BaseEntity{

    private String name;

    private String description;

    private BigDecimal price;

    private String imageUrl;

    private int rating;
}
