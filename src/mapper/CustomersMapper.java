package mapper;

import model.entity.Customers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersMapper extends Mapper<Customers>{
    @Override
    public Customers map(ResultSet result) throws SQLException {
        Customers customers = new Customers();
        customers.setId(result.getInt("customerNumber"));
        customers.setFirstName(result.getString("customerName"));
        customers.setLastName(result.getString("contactLastName"));
        customers.setPhoneNumber(result.getString("phone"));
        customers.setAddress(result.getString("addressLine1"));
        customers.setCity(result.getString("city"));
        customers.setPostalCode(result.getString("postalCode"));
        customers.setCreditLimit(result.getDouble("creditLimit"));
        return customers;
    }
}
