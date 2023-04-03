package mapper;

import model.entity.Offices;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfficesMapper extends Mapper<Offices> {

    @Override
    public Offices map(ResultSet result) throws SQLException {
        Offices offices = new Offices();
        offices.setOfficeCode(result.getString("officeCode"));
        offices.setCity(result.getString("city"));
        offices.setPhoneNumber(result.getString("phoneNumber"));
        offices.setAddress(result.getString("address"));
        offices.setPostalCode(result.getString("postalCode"));
        return offices;
    }
}
