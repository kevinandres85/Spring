package com.kluna.store.product;

import com.kluna.store.product.entity.Category;
import com.kluna.store.product.entity.Product;
import com.kluna.store.product.repository.ProductRepository;
import com.kluna.store.product.service.ProductService;
import com.kluna.store.product.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {
    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product computer = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240"))
                .status("created")
                .createdAt(new Date()).build();

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(computer));
        Mockito.when(productRepository.save(computer)).thenReturn(computer);
    }

    @Test
    public void whenValidGetID_ThenReturnProduct(){
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        Product productNewStock = productService.updateStock(1L, Double.parseDouble("8"));
        Assertions.assertThat(productNewStock.getStock()).isEqualTo(18);
    }
}
