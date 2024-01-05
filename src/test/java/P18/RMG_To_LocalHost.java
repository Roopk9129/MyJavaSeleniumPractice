package P18;

import java.sql.*;
import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;

public class RMG_To_LocalHost {
	@Test
	public void rMG_To_LocalHost() throws Throwable {
		Driver drive = new Driver();
		DriverManager.registerDriver(drive);
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		ResultSet query = state.executeQuery("select * from project;");

		while (query.next()) {
			String product_Id = query.getString(1);
			String created_By = query.getString(2);
			String created_On = query.getString(3);
			String project_Name = query.getString(4);
			String status = query.getString(5);
			int team_Size = query.getInt(6);

			System.out.println(product_Id + " " + created_By + " " + created_On + " " + project_Name + " " + status
					+ " " + team_Size);
			String updateQuery = "INSERT INTO RMGDATA_TABLE (product_Id, created_By, created_On, project_Name, status,team_Size)"
					+ "VALUES('" + product_Id + "', " + "'" + created_By + "', " + "'" + created_On + "', " + "'"
					+ project_Name + "', " + "'" + status + "', " + team_Size + ");";
			System.out.println(updateQuery);
			try {
				Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmgtolocalhost", "root",
						"root");
				Statement state1 = con1.createStatement();
				state1.executeUpdate(updateQuery);
			} catch (Exception e) {
			}

		}
	}

}
