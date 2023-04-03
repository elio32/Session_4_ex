package repository.impl;

import mapper.CustomersMapper;
import model.entity.Customers;
import util.JdbcConnection;
import util.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository extends BaseRepository<Customers, Integer> {

    public CustomerRepository() {
        super(new CustomersMapper());
    }

    @Override
    public List<Customers> findAll() {
        List<Customers> customers = new ArrayList<>();
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_ALL_CUSTOMERS)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Customers customer = getMapper().map(result);
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return customers;
    }

    @Override
    public Customers findById(Integer id) {
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_CUSTOMER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return getMapper().map(result);
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return null;
    }

    @Override
    public Boolean exists(Integer id) {
        // TODO: Implement a method which checks if an employee with the given id exists in the employees table
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_CUSTOMER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return false;
    }

    @Override
    public Boolean save(Customers customers) {
        /*
         * TODO: Implement a method which adds an employee to the employees table
         *  If the employee exists then the method should instead update the employee
         */
        try (Connection connection = JdbcConnection.connect()) {
            if (exists(customers.getId())) {
                PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_CUSTOMER_BY_ID);

                statement.setInt(1, customers.getId());
                statement.setString(2, customers.getFirstName());
                statement.setString(3, customers.getLastName());
                statement.setString(4, customers.getPhoneNumber());
                statement.setString(5, customers.getAddress());
                statement.setString(6, customers.getAddress());
                statement.setString(7, customers.getPostalCode());
                return statement.executeUpdate() > 0;
            } else {
                PreparedStatement statement = connection.prepareStatement(Queries.INSERT_CUSTOMER);
                statement.setInt(1, customers.getId());
                statement.setString(2, customers.getFirstName());
                statement.setString(3, customers.getLastName());
                statement.setString(4, customers.getPhoneNumber());
                statement.setString(5, customers.getAddress());
                statement.setString(6, customers.getAddress());
                statement.setString(7, customers.getPostalCode());
                return statement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return false;
    }

    @Override
    public Integer update(Customers customers) {
        /*
         * TODO: Implement a method which updates an employee with the given Employee instance
         *  The method should then return the number of updated records
         */
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_EMPLOYEE_BY_ID)) {
            statement.setInt(1, customers.getId());
            statement.setString(2, customers.getFirstName());
            statement.setString(3, customers.getLastName());
            statement.setString(4, customers.getPhoneNumber());
            statement.setString(5, customers.getAddress());
            statement.setString(6, customers.getCity());
            statement.setString(7, customers.getPostalCode());
            return statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            System.err.println("Error");
        }
        return 0;
    }
}

