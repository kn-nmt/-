package swingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DBInsert {

	private static final String URL = "jdbc:mysql://localhost/swingapp?useSSL=false&serverTimezone=Asia/Tokyo";
	private static final String USERNAME = "root"; // ユーザ名 ：環境に合わせ設定
	private static final String PASSWORD = "password"; // パスワード：環境に合わせ設定

	public void Data(String name, String age, String address) {
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Statement statement = connection.createStatement();) {
			String sql = "INSERT INTO data (name, age, address)" + "VALUES ('" + name + "','" + age + "','" + address
					+ "');";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}