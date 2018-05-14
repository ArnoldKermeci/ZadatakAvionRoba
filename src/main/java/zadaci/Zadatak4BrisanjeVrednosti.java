package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Roba;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Zadatak4BrisanjeVrednosti {
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");
            Dao<Roba, Integer> daoRoba = DaoManager.createDao(connectionSource,Roba.class);
            List<Roba> pomocnalista2 = daoRoba.queryForAll();
            for (Roba r:pomocnalista2) {
                System.out.println(r);
            }
            List<Roba> roba= daoRoba.queryForEq(Roba.POLJE_NAZIV, "Voda");
            Roba roba0= roba.get(0);
            daoRoba.delete(roba0);
            List<Roba> pomocnalista5 = daoRoba.queryForAll();
            for (Roba r:pomocnalista5) {
                System.out.println(r);
            }
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
    }
}
