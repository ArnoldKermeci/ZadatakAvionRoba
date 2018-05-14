package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;

import java.io.IOException;
import java.sql.SQLException;

public class Zadaci1KreiranjeTabela {


    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            TableUtils.dropTable(connectionSource, Roba.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            TableUtils.dropTable(connectionSource, Avion.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            TableUtils.createTable(connectionSource, Roba.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            TableUtils.createTable(connectionSource, Avion.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
