package com.crud.task.exposition.out;

import com.crud.task.domain.enumeration.ProductCategoryEnum;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductOut {

    protected Long id;

    private String name;

    private BigDecimal price;

    private Integer quantity;

    private ProductCategoryEnum category;

    private LocalDateTime creationDate;
}
