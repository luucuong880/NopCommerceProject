package pageObjects.wordpress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import pageUI.wordpress.AdminUserPageUI;
import utilities.MySQLConnUtils;

public class AdminUserPO extends BasePage {
	WebDriver driver;

	public AdminUserPO(WebDriver driver) {
		this.driver = driver;
	}

	public int getUserNumberAtUI() {
		waitForAllElementVisible(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
		String totalNumber = getElementText(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
		return Integer.parseInt(totalNumber.split("")[0]);
	}

	public int getUserNumberAtDB() {
		Connection conn = MySQLConnUtils.getMySQLConnection();
		Statement statement;
		List<Integer> totalUsers = new ArrayList<>();
		try {
			statement = conn.createStatement();
			String sql = "SELECT * FROM wp_users";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				totalUsers.add(rs.getInt(1));

				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return totalUsers.size();
	}

	public boolean checkTotalRecordMemorySizeFromDB(String categoryID, String memorySize, String role) {
		// waitForControl(driver, Agentool.DesktopsPage.MEMORY_SIZE_DROPDOWN, timeWait);
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql = "";
		if (role.equals("roleAdmin")) {
			sql = "SELECT DISTINCT COUNT(attribute15) as memorySize FROM estore_inventory WHERE category_id = ? AND attribute15 = ? ORDER BY attribute15";
		} else {
			sql = "SELECT DISTINCT COUNT(attribute15) as memorySize FROM estore_inventory WHERE category_id = ? AND attribute15 = ? AND status = 'AGENT-STORE-AVAILABLE' ORDER BY attribute15";
		}
		int i = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, categoryID);
			statement.setString(2, memorySize);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				i = rs.getInt("memorySize");
			}
			if (i == 3) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

}
