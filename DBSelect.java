package swingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class DBSelect {

	private static final String URL = "jdbc:mysql://localhost/swingapp?useSSL=false&serverTimezone=Asia/Tokyo";
	private static final String USERNAME = "root"; // ユーザ名 ：環境に合わせ設定
	private static final String PASSWORD = "password"; // パスワード：環境に合わせ設定

	public ArrayList<List> selectAll() {
		ArrayList<List> list = new ArrayList<>();
		String sql = "SELECT * FROM data";
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);) {
			while (result.next()) {
				list.add(new List(result.getInt("num"), result.getString("name"),
						result.getString("age"), result.getString("address")));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return list;
	}

}
