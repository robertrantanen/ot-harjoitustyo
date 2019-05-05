package calculator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Luokka vastaa tietokantaoperaatioista.
 */
public class HistoryDao {
    
    private String db;

    public HistoryDao(String db) {
        this.db = db;
    }
    

    /**
     * Metodi ottaa yhteyden tietokantaan ja luo listan tietokantakyselyn
     * tuloksesta.
     *
     * @return History-taulun 10 viimeisintä riviä listana.
     * @throws java.lang.Exception e
     */
    public List<String> listAll() throws Exception {
        Connection connection = DriverManager.getConnection(db, "", "");

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

    /**
     * Metodi ottaa yhteyden tietokantaan ja lisää History-tauluun uuden rivin.
     *
     * @param item Calculus-luokan calculate-metodin antama merkkijono
     * laskutoimituksesta.
     * @throws java.lang.Exception e
     */
    public void addItem(String item) throws Exception {
        Connection connection = DriverManager.getConnection(db, "", "");

        PreparedStatement stmt = connection.prepareStatement("INSERT INTO History (item) VALUES (?)");
        stmt.setString(1, item);

        stmt.executeUpdate();

        stmt.close();
        connection.close();

    }

    /**
     * Metodi poistaa kaikki rivit History-taulusta.
     *
     * @throws java.lang.Exception e
     */
    public void deleteAll() throws Exception {
        Connection connection = DriverManager.getConnection(db, "", "");

        PreparedStatement stmt = connection.prepareStatement("DELETE FROM History");

        stmt.executeUpdate();

        stmt.close();
        connection.close();

    }

    
    /**
     * Metodi luo History-taulun jos sitä ei ole olemassa.
     *
     * @throws java.lang.Exception e
     */
    public void createTables() throws Exception {
        Connection connection = DriverManager.getConnection(db, "", "");

        PreparedStatement stmt = connection.prepareStatement("CREATE TABLE IF NOT EXISTS History"
                + "(id INTEGER PRIMARY KEY AUTO_INCREMENT, item VARCHAR(255))");

        stmt.executeUpdate();

        stmt.close();
        connection.close();

    }

}
