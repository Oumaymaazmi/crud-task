package com.crud.task.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class Product {

    protected Long id;

    private String name;

    private BigDecimal price;

    private Integer quantity;

    private String createdBy;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;
}
