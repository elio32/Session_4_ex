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
    public Boolean save(Customers customer) {
        if (this.exists(customer.getId())) {
            update(customer);
            return true;
        } else {
            int rows = 0;
            try (Connection connection = JdbcConnection.connect();
                 PreparedStatement statement = connection.prepareStatement(Queries.ADD_CUSTOMER)) {
                if (customer.getId() > this.getMaxId())
                    statement.setInt(1, customer.getId());
                else
                    statement.setInt(1, this.getMaxId() + 1);
                statement.setString(3, customer.getFirstName());
                statement.setString(4, customer.getLastName());
                statement.setString(5, customer.getPhoneNumber());
                statement.setString(6, customer.getAddress());
                statement.setString(8, customer.getCity());
                statement.setString(10, customer.getPostalCode());
                EmployeeRepository employees = new EmployeeRepository();

                if (employees.exists(customer.getId())) {
                    statement.setInt(12, customer.getId());
                } else {
                    System.out.println("Couldn't add customer. Invalid employee");
                    return null;
                }
                statement.setDouble(13, customer.getCreditLimit());
                rows = statement.executeUpdate();
                if (rows == 1) {
                    System.out.println("New customer added to the customers table");
                }
                System.out.println("Rows updated: " + rows);
            } catch (SQLException e) {
                System.err.println("ErrorAdd");
            }
            return rows >= 1;
        }
    }

    @Override
    public Integer update(Customers customer) {
        Integer rows = 0;
        if (this.exists(customer.getId())) {
            try (Connection connection = JdbcConnection.connect();
                 PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_CUSTOMER)) {
                statement.setInt(1, customer.getId());
                statement.setString(3, customer.getFirstName());
                statement.setString(4, customer.getLastName());
                statement.setString(5, customer.getPhoneNumber());
                statement.setString(6, customer.getAddress());
                statement.setString(8, customer.getCity());
                statement.setString(10, customer.getPostalCode());
                EmployeeRepository employees = new EmployeeRepository();
                if (employees.exists(customer.getId())) {
                    statement.setInt(11, customer.getId());
                } else {
                    System.out.println("Couldn't update customer. Invalid employee");
                    return null;
                }
                statement.setDouble(12, customer.getCreditLimit());
                statement.setInt(13, customer.getId());
                rows = statement.executeUpdate();
                if (rows == 1) {
                    System.out.println("Customer with ID: " + customer.getId() + " is updated");
                }
                System.out.println("Rows updated: " + rows);
            } catch (SQLException e) {
                System.err.println("ErrorUpdate");
            }
        } else {
            System.out.println("Couldn't update. Customer not found\nRows affected: " + rows);
        }
        return rows;
    }

    public Integer getMaxId() {
        Integer maxId = 2001;
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.ID_MAX_C)) {
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                maxId = result.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("ErrorMaxID");
        }
        return maxId;
    }
}

