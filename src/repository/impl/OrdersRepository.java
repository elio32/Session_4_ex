package repository.impl;

import mapper.OrdersMapper;
import model.entity.Orders;
import util.JdbcConnection;
import util.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersRepository extends BaseRepository<Orders,Integer>{

    public OrdersRepository() {
        super(new OrdersMapper());
    }
    @Override
    public List<Orders> findAll() {
        List<Orders> orders = new ArrayList<>();
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_ALL_ORDERS)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Orders order = getMapper().map(result);
                orders.add(order);
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return orders;
    }

    @Override
    public Orders findById(Integer id) {
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_ORDER_BY_ID)) {
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
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_ORDER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return false;
    }

    @Override
    public Boolean save(Orders orders) {
        /*
         * TODO: Implement a method which adds an employee to the employees table
         *  If the employee exists then the method should instead update the employee
         */
        try (Connection connection = JdbcConnection.connect()) {
            if (exists(orders.getId())) {
                PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ORDER_BY_ID);

                statement.setInt(1, orders.getId());
                statement.setString(2, orders.getStatus());
                statement.setString(3, orders.getComments());
                return statement.executeUpdate() > 0;
            } else {
                PreparedStatement statement = connection.prepareStatement(Queries.INSERT_ORDER);
                statement.setInt(1, orders.getId());
                statement.setString(2, orders.getStatus());
                statement.setString(3, orders.getComments());
                return statement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return false;
    }

    @Override
    public Integer update(Orders orders) {
        /*
         * TODO: Implement a method which updates an employee with the given Employee instance
         *  The method should then return the number of updated records
         */
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_EMPLOYEE_BY_ID)) {
            statement.setInt(1, orders.getId());
            statement.setString(2, orders.getStatus());
            statement.setString(3, orders.getComments());
            return statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return 0;
    }
}
