package repository.impl;

import mapper.OfficesMapper;
import model.entity.Offices;
import util.JdbcConnection;
import util.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfficesRepository extends BaseRepository<Offices, String> {

    public OfficesRepository() {
        super(new OfficesMapper());
    }

    @Override
    public List<Offices> findAll() {
        List<Offices> offices = new ArrayList<>();
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_ALL_OFFICES)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Offices office = getMapper().map(result);
                offices.add(office);
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return offices;
    }

    @Override
    public Offices findById(String officeCode) {
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_OFFICES_BY_OFFICECODE)) {
            statement.setString(1, officeCode);
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
    public Boolean exists(String officeCode) {
        // TODO: Implement a method which checks if an employee with the given id exists in the employees table
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_OFFICES_BY_OFFICECODE)) {
            statement.setString(1, officeCode);
            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return false;
    }

    @Override
    public Boolean save(Offices offices) {
        /*
         * TODO: Implement a method which adds an employee to the employees table
         *  If the employee exists then the method should instead update the employee
         */
        try (Connection connection = JdbcConnection.connect()) {
            if (exists(offices.getOfficeCode())) {
                PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_OFFICE_BY_OFFICECODE);

                statement.setString(1, offices.getOfficeCode());
                statement.setString(2, offices.getCity());
                statement.setString(3, offices.getPhoneNumber());
                statement.setString(4, offices.getAddress());
                statement.setString(5, offices.getPostalCode());
                return statement.executeUpdate() > 0;
            } else {
                PreparedStatement statement = connection.prepareStatement(Queries.INSERT_OFFICE);
                statement.setString(1, offices.getOfficeCode());
                statement.setString(2, offices.getCity());
                statement.setString(3, offices.getPhoneNumber());
                statement.setString(4, offices.getAddress());
                statement.setString(5, offices.getPostalCode());
                return statement.executeUpdate() > 0;
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println("Error");
        }
        return false;
    }

    @Override
    public Integer update(Offices offices) {
        /*
         * TODO: Implement a method which updates an employee with the given Employee instance
         *  The method should then return the number of updated records
         */
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_EMPLOYEE_BY_ID)) {
            statement.setString(1, offices.getOfficeCode());
            statement.setString(2, offices.getCity());
            statement.setString(3, offices.getPhoneNumber());
            statement.setString(4, offices.getAddress());
            statement.setString(5, offices.getPostalCode());
            return statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            System.err.println("Error");
        }
        return 0;
    }

}
