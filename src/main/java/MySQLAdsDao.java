import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    Connection connection = null;

    // 1. Create a database connection (once)
    // 1. Use that connection to create and execute statements (queries)

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error establishing database connection!", e);
        }
    }

    // return the first ad in the database
    public Ad first() {
        String query = "SELECT * FROM ads LIMIT 1";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                // transform results into a list of Ads
                return new Ad(
                        rs.getLong("id"),
                        1,
                        rs.getString("title"),
                        rs.getString("description")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all ads!", e);
        }
    }

    @Override
    public List<Ad> all() {
        String query = "SELECT * FROM ads";
        try {
            List<Ad> ads = new ArrayList<>();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // transform results into a list of Ads
                ads.add(new Ad(
                        rs.getLong("id"),
                        1,
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
            return ads;
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all ads!", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        String query = "INSERT INTO ads(user_id, title, description) VALUES(";
        query += "1, ";
        query += "'" + ad.getTitle() + "', ";
        query += "'" + ad.getDescription() + "'";
        query += ")";
        System.out.println("[DEBUG]: Running SQL... " + query);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                throw new RuntimeException("No id found after inserting an ad!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting an ad!", e);
        }
    }
}
