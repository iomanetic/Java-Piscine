package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {

    final private DataSource dataSource;

    public ProductsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        final String SQL_QUERY = "SELECT * FROM products";
        List<Product> products = null;
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        connect = dataSource.getConnection();
        statement = connect.prepareStatement(SQL_QUERY);
        result = statement.executeQuery();
        products = new ArrayList<>();
        while(result.next()) {
            products.add(new Product((long)result.getInt(1),
                        result.getString(2),
                        result.getInt(3)));
            }
        connect.close();
        statement.close();
        return (products);
    }

    @Override
    public Optional<Product> findById(Long id) throws SQLException {
        final String SQL_QUERY = "SELECT * FROM products " +
                                 "WHERE identifier = ?";
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Optional<Product> product = null;

        connect = dataSource.getConnection();
        statement = connect.prepareStatement(SQL_QUERY);
        statement.setLong(1, id);
        result = statement.executeQuery();
        result.next();
        product = Optional.of(new Product(result.getLong(1),
                             result.getString(2),
                             result.getInt(3)));
        return (product);
    }

    @Override
    public void update(Product product) throws SQLException {
        final String SQL_QUERY = "UPDATE products SET " +
                                 "name = ?, " +
                                 "price = ? " +
                                 "WHERE identifier = ?;";
        Connection connect = null;
        PreparedStatement statement = null;

        connect = dataSource.getConnection();
        statement = connect.prepareStatement(SQL_QUERY);
        statement.setString(1, product.getName());
        statement.setInt(2, product.getPrice());
        statement.setLong(3, product.getIdentifier());
        statement.execute();
    }

    @Override
    public void save(Product product) throws SQLException {
        final String SQL_QUERY = "INSERT INTO products(name, price) VALUES" +
                                 "(?, ?)";
        Connection connect = null;
        PreparedStatement statement = null;

        connect = dataSource.getConnection();
        statement = connect.prepareStatement(SQL_QUERY);
        statement.setString(1, product.getName());
        statement.setInt(2, product.getPrice());
        statement.execute();
    }

    @Override
    public void delete(Long id) throws SQLException {
        final String SQL_QUERY = "DELETE FROM products " +
                                 "WHERE id = ?;";
        Connection connect = null;
        PreparedStatement statement = null;

        connect = dataSource.getConnection();
        statement = connect.prepareStatement(SQL_QUERY);
        statement.setLong(1, id);
    }

}
