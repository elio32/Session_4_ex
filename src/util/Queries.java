package util;

public final class Queries {

    private Queries() {}

    public static final String FIND_ALL_EMPLOYEES = "SELECT * FROM employees;";

    public static final String FIND_EMPLOYEE_BY_ID = "SELECT * FROM employees WHERE employeeNumber = ?;";

    public static final String UPDATE_EMPLOYEE_BY_ID = "UPDATE employees SET firstName = ?, lastName = ?, jobTitle = ?, email = ?,officeCode = ? WHERE employeeNumber = ?";

    public static final String INSERT_EMPLOYEE = "INSERT INTO employees (employeeNumber, firstName, lastName, jobTitle, email, officeCode, reportsTo) VALUES (?, ?, ?, ?, ?, ?, ?)";
    //-----------------------------------------------------------------------------------------------------
    public static final String FIND_ALL_OFFICES = "SELECT * FROM offices;";
    public static final String FIND_OFFICES_BY_OFFICECODE = "SELECT * FROM office WHERE officeCode = ?;";
    public static final String UPDATE_OFFICE_BY_OFFICECODE = "UPDATE offices SET city = ?, phoneNumber = ?, address = ?, postalCode = ? WHERE officeCode = ?";
    public static final String INSERT_OFFICE = "INSERT INTO offices (officeCode, city, phoneNumber, address, postalCode) VALUES (?, ?, ?, ?, ?)";
//==========================================================================================

    public static final String FIND_ALL_CUSTOMERS = "SELECT * FROM customers;";

    public static final String FIND_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE customerNumber = ?;";

    public static final String UPDATE_CUSTOMER_BY_ID = "UPDATE customers SET firstName = ?, lastName = ?, phoneNumber = ?, address = ?, city = ?, postalCode = ? WHERE employeeNumber = ?";

    public static final String INSERT_CUSTOMER = "INSERT INTO customers (customerNumber, firstName, lastName, phoneNumber, address, city, postalCode) VALUES (?, ?, ?, ?, ?, ?, ?)";

    //=========================================================================================================
    public static final String FIND_ALL_ORDERS = "SELECT * FROM orders;";

    public static final String FIND_ORDER_BY_ID = "SELECT * FROM orders WHERE orderNumber = ?;";

    public static final String UPDATE_ORDER_BY_ID = "UPDATE orders SET status = ?, comments = ? WHERE orderNumber = ?";

    public static final String INSERT_ORDER = "INSERT INTO orders (orderNumber, status, comments) VALUES (?, ?, ?)";





}
