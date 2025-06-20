package com.crud.task.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Table(name = "Product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String name;

    private BigDecimal price;

    private Integer quantity;

    private String createdBy;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;
}
