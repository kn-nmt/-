package swingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDelete {

	private static final String URL = "jdbc:mysql://localhost/swingapp?useSSL=false&serverTimezone=Asia/Tokyo";
	private static final String USERNAME = "root"; // ユーザ名 ：環境に合わせ設定
	private static final String PASSWORD = "password"; // パスワード：環境に合わせ設定

	public void Data(int del) {
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Statement statement = connection.createStatement();) {
			String sql = "delete from data where num = " + del + ";";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
