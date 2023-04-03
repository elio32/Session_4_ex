package mapper;

import model.entity.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersMapper extends Mapper<Orders>{

    @Override
    public Orders map(ResultSet result) throws SQLException {
        Orders orders = new Orders();
        orders.setId(result.getInt("orderNumber"));
        orders.setStatus(result.getString("status"));
        orders.setComments(result.getString("comments"));

        return orders;
    }
}
