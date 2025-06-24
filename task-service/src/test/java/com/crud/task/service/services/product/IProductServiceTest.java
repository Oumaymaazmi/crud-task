package com.crud.task.service.services.product;

import com.crud.task.domain.exception.FunctionalException;
import com.crud.task.domain.pojo.Product;
import com.crud.task.domain.port.IProductRepository;
import com.crud.task.service.config.MessageResolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IProductServiceTest {

    private static final String ERROR_PRICE_REQUIRED = "error.product.priceRequired";

    @Mock
    private IProductRepository productRepository;

    @Mock
    private MessageResolver messageResolver;

    @InjectMocks
    private ProductServiceImpl IProductService;

    @Test
    void shouldSaveProduct() {
        Product product = buildDefaultProduct();
        IProductService.create(product);
        verify(productRepository).save(product);
    }

    @Test
    void shouldThrowExceptionWhenPriceNull() {
        Product product = buildDefaultProduct();
        product.setPrice(null);
        when(messageResolver.get(ERROR_PRICE_REQUIRED)).thenReturn("Product price is required");

        FunctionalException exception = assertThrows(FunctionalException.class, () -> IProductService.create(product));
        assertEquals("Product price is required", exception.getMessage());
    }

    @Test
    void shouldReturnProduct() {
        Long id = 1L;
        Product expected = buildDefaultProduct();
        expected.setId(id);
        when(productRepository.findById(id)).thenReturn(Optional.of(expected));

        Product result = IProductService.findById(id);

        assertNotNull(result);
        assertEquals(result, expected);
    }

    Product buildDefaultProduct() {
        return Product.builder()
                .name("Laptop")
                .price(BigDecimal.valueOf(1200))
                .build();
    }
}
