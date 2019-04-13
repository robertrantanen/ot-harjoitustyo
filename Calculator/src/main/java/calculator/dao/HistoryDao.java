package calculator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HistoryDao {

    public List<String> listAll() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:h2:./database", "", "");

        PreparedStatement stmt = connection.prepareStatement("SELECT item FROM History ORDER BY id DESC LIMIT 10");
        ResultSet rs = stmt.executeQuery();

        List<String> items = new ArrayList<>();

        while (rs.next()) {
            String item = rs.getString("item");
            items.add(item);
        }

        stmt.close();
        rs.close();

        connection.close();

        return items;

    }

    public void addItem(String item) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:h2:./database", "", "");

        PreparedStatement stmt
                = connection.prepareStatement("INSERT INTO History (item) VALUES (?)");
        stmt.setString(1, item);

        stmt.executeUpdate();

        stmt.close();
        connection.close();

    }

    public void deleteAll() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:h2:./database", "", "");

        PreparedStatement stmt
                = connection.prepareStatement("DELETE FROM History");

        stmt.executeUpdate();

        stmt.close();
        connection.close();

    }

}
