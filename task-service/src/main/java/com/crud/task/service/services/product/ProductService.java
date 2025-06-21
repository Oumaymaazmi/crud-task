package com.crud.task.service.services.product;

import com.crud.task.domain.exception.FunctionalException;
import com.crud.task.domain.pojo.Product;
import com.crud.task.domain.port.IProductRepository;
import com.crud.task.service.config.MessageResolver;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ProductService {
    private static final String ERROR_PRODUCT_NOT_FOUND = "error.product.notFound";
    private static final String ERROR_NAME_REQUIRED = "error.product.nameRequired";
    private static final String ERROR_PRICE_REQUIRED = "error.product.priceRequired";
    private static final String ERROR_PRICE_INVALID = "error.product.priceInvalid";

    private final IProductRepository productRepository;
    private final MessageResolver messageResolver;

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new FunctionalException(messageResolver.get(ERROR_PRODUCT_NOT_FOUND, id)));
    }

    public void create(Product product) {
        validateProduct(product);
        setDefaultValues(product);
        productRepository.save(product);
    }

    public void update(Long id, Product product) {
        validateProduct(product);

        Product productFromDb = findById(id);
        productFromDb.setName(product.getName());
        productFromDb.setPrice(product.getPrice());
        productFromDb.setCategory(product.getCategory());
        productFromDb.setQuantity(product.getQuantity());

        setDefaultValues(productFromDb);

        productRepository.save(productFromDb);
    }

    private void setDefaultValues(Product product) {
        if (product.getQuantity() == null) {
            product.setQuantity(1);
        }
    }

    private void validateProduct(Product product) {
        if (product.getName() == null || product.getName().isBlank()) {
            throw new FunctionalException(messageResolver.get(ERROR_NAME_REQUIRED));
        }
        if (product.getPrice() == null) {
            throw new FunctionalException(messageResolver.get(ERROR_PRICE_REQUIRED));
        }
        if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new FunctionalException(messageResolver.get(ERROR_PRICE_INVALID));
        }
    }

    public void delete(Long id) {
        findById(id);
        productRepository.deleteById(id);
    }

    public Page<Product> findAllPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("creationDate").descending());
        return productRepository.findAll(pageable);
    }
}
