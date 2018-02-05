package person.cznno.commonpoi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cznno
 * Date: 18-2-5
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = args[0];
        String dbUser = args[1];
        String dbPassword = args[2];

        List<String> commentList = new ArrayList<>();
        List<String> columnList = new ArrayList<>();
        List<List<String>> dataList = new ArrayList<>();
        int maxLen = 0;

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword)) {

            Statement stmt = conn.createStatement();

            ResultSet rs1 = stmt.executeQuery("SHOW FULL COLUMNS FROM sys_user");
            while (rs1.next()) {
                String comment = rs1.getString("Comment");
                if (comment.length() > maxLen)
                    maxLen = comment.length();
                columnList.add(rs1.getString("Field"));
                commentList.add(comment);
            }

            ResultSet rs2 = stmt.executeQuery("SELECT * FROM sys_user");
            while (rs2.next()) {
                List<String> row = new ArrayList<>();
                for (String column : columnList) {
                    String data = rs2.getString(column);
                    if (null != data && data.length() > maxLen)
                        maxLen = data.length();
                    row.add(data);
                }
                dataList.add(row);
            }
            rs1.close();
            rs2.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
