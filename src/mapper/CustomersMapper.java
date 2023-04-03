package mapper;

import model.entity.Customers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersMapper extends Mapper<Customers>{
    @Override
    public Customers map(ResultSet result) throws SQLException {
        Customers customers = new Customers();
        customers.setId(result.getInt("customerNumber"));
        customers.setFirstName(result.getString("firstName"));
        customers.setLastName(result.getString("lastName"));
        customers.setPhoneNumber(result.getString("phoneNumber"));
        customers.setAddress(result.getString("address"));
        customers.setCity(result.getString("city"));
        customers.setPostalCode(result.getString("postalCode"));
        return customers;
    }
}
