package com.crud.task.exposition.in;

import com.crud.task.domain.enumeration.ProductCategoryEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class ProductIn {

    @NotNull(message = "Product name is required")
    private String name;

    @NotNull(message = "Product price is required")
    @DecimalMin(value = "0.01", inclusive = true, message = "Price must be greater than 0")
    private BigDecimal price;

    private Integer quantity;

    private ProductCategoryEnum category;

}
