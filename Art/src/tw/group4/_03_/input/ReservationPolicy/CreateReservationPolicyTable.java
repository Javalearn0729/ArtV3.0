package tw.group4._03_.input.ReservationPolicy;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class CreateReservationPolicyTable {

	private DataSource dataSource;

	public DataSource getDataSource() {// 只需get因為只要用不希望被改

		// lazy init，能有多晚用到就多晚產生，放constructor會先產出佔用記憶體
		if (dataSource == null) { // 不希望重複產生，
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("oracle.jdbc.OracleDriver");
			ds.setUrl("jdbc:oracle:thin:@//localhost:1521/xepdb1");
			ds.setUsername("group4");
			ds.setPassword("oracle");
			ds.setMaxTotal(50);
			ds.setMaxIdle(50);

			dataSource = ds; // 把BasicDataSource放在屬性上
		}
		return dataSource;
	}
	
	public void dropReservationPolicyTable() {
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "DROP TABLE CS_RESERVATION_POLICY_TABLE CASCADE CONSTRAINTS";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("預約規格表格已刪除");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createReservationPolicyTable(){
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
		     
//			String sql = "CREATE TABLE CS_RESERVATION_POLICY_TABLE "
//					+ "(shopId NUMBER PRIMARY KEY NOT NULL REFERENCES CS_CREATIVE_SHOPS_TABLE(SHOP_ID),  "
//					+ "shopName VARCHAR2(1000 BYTE), "
//					+ "maximum NUMBER(8,0), "
//					+ "duration  NUMBER(8,0), "
//					+ "overlap  NUMBER(8,0))";
			
			String sql = "CREATE TABLE CS_RESERVATION_POLICY_TABLE "
					+ "(shopId NUMBER NOT NULL, "
					+ "shopName VARCHAR2(1000 BYTE), "
					+ "maximum NUMBER(8,0), "
					+ "duration  NUMBER(8,0), "
					+ "overlap  NUMBER(8,0), "
					+ "CONSTRAINT PK_POLICY_TABLE PRIMARY KEY(shopId), "
					+ "CONSTRAINT FK_SHOPID FOREIGN KEY (shopId) REFERENCES CS_CREATIVE_SHOPS_TABLE(SHOP_ID) ON DELETE CASCADE "
					+ ")";
		    
		    stmt.executeUpdate(sql);
		    System.out.println("預約規格表格已建立");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
