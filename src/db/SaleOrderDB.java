package db;


import java.util.Date;
import controller.DataAccessException;
import model.SaleOrder;
import model.OrderLine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleOrderDB {

    public static boolean saveOrder(SaleOrder order) throws DataAccessException {
        Connection con = DBConnection.getInstance().getDBcon();
        PreparedStatement insertSaleOrderPS = null;
        PreparedStatement insertOrderLinePS = null;
        Date orderDate = new Date();

        try {
            con.setAutoCommit(false);

            String insertSaleOrderQuery = "INSERT INTO SaleOrder (DeliveryStatus, DeliveryDate, CustomerID) VALUES (?, ?, ?)";
            insertSaleOrderPS = con.prepareStatement(insertSaleOrderQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            insertSaleOrderPS.setBoolean(1, order.getDeliveryStatus());
            insertSaleOrderPS.setString(2, order.getDeliveryDate());
            insertSaleOrderPS.setInt(3, order.getCustomer().getCustomerID()); 
            int affectedRows = insertSaleOrderPS.executeUpdate();

            if (affectedRows == 0) {
                con.rollback();  
                return false;
            }

//            ResultSet generatedKeys = insertSaleOrderPS.getGeneratedKeys();
//            int saleOrderID = -1;
//            if (generatedKeys.next()) {
//                saleOrderID = generatedKeys.getInt(1);
//            } else {
//                con.rollback();
//                return false;
//            }
//
//            String insertOrderLineQuery = "INSERT INTO OrderLine (Quantity, SaleOrderID, ProductID) VALUES (?, ?, ?)";
//            insertOrderLinePS = con.prepareStatement(insertOrderLineQuery);
//            for (OrderLine orderLine : order.getOrderLines()) {
//                insertOrderLinePS.setInt(1, orderLine.getQuantity());
//                insertOrderLinePS.setInt(2, saleOrderID);
//                insertOrderLinePS.setInt(3, orderLine.getProduct().getProductID());
//                insertOrderLinePS.addBatch();
//            }
//
//            int[] orderLineAffectedRows = insertOrderLinePS.executeBatch();
//            for (int rowsAffected : orderLineAffectedRows) {
//                if (rowsAffected <= 0) {
//                    con.rollback(); 
//                    return false;
//                }
//            }

            con.commit();
            return true;
        } catch (SQLException e) {
        	System.out.println("62" + e.getMessage());
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException rollbackException) {
                throw new DataAccessException(DBMessages.COULD_NOT_ROLLBACK, rollbackException);
            }
            throw new DataAccessException(DBMessages.COULD_NOT_INSERT, e);
        } finally {
            try {
                if (insertSaleOrderPS != null) {
                    insertSaleOrderPS.close();
                }
                con.setAutoCommit(true);
            } catch (SQLException e) {
                throw new DataAccessException(DBMessages.COULD_NOT_CLOSE_STATEMENT, e);
            }
        }
    }
}