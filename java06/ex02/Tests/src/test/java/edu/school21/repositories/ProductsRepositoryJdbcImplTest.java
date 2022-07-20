package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImplTest {

    private EmbeddedDatabase dataSource;
    private ProductsRepositoryJdbcImpl productsRepositoryJdbc;
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(2L, "Soup", 5);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(3L, "Brad", 1);
    final private List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(0L, "Milk", 2),
            new Product(1L, "Cake", 3),
            new Product(2L, "Soup", 5),
            new Product(3L, "Dishes", 10),
            new Product(4L, "Pasta", 3)
    );

    @BeforeEach
    void getPullCon() {
        dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        productsRepositoryJdbc = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    void findAllTest() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS,
                            productsRepositoryJdbc.findAll());
    }

    @Test
    void findByIdTest() throws SQLException {
        Optional<Product> product = null;

        product = productsRepositoryJdbc.findById(EXPECTED_FIND_BY_ID_PRODUCT.getIdentifier());
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, product.get());
    }

    @Test
    void updateTest() throws SQLException {
        Optional<Product> product = null;

        productsRepositoryJdbc.update(EXPECTED_UPDATED_PRODUCT);
        product = productsRepositoryJdbc.findById(EXPECTED_UPDATED_PRODUCT.getIdentifier());
        Assertions.assertEquals(EXPECTED_UPDATED_PRODUCT, product.get());
    }

    @Test
    void saveTest() throws SQLException {
        Product product = null;
        Optional<Product> newProduct = null;

        product = new Product(5L, "Ticket", 2);
        productsRepositoryJdbc.save(product);
        newProduct = productsRepositoryJdbc.findById(product.getIdentifier());
        Assertions.assertEquals(product, newProduct.get());
    }

    @Test
    void deleteTest() throws SQLException {
        List<Product> products = null;
        int expectedSize = 0;

        productsRepositoryJdbc.delete(0L);
        products = productsRepositoryJdbc.findAll();
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS.size(), products.size());
    }

    @AfterEach
    void close() {
        dataSource.shutdown();
    }
}
