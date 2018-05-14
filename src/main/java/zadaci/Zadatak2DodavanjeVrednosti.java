package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Zadatak2DodavanjeVrednosti {
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");
            Avion avion1= new Avion("Avion1", 34);
            Avion avion2 = new Avion("Avion2", 21);

            Roba roba1 = new Roba("Patike", "Duboke patike", 1, avion1);
            Roba roba2 = new Roba("Kosulja", "Na duge rukave", 0.4, avion1);
            Roba roba3 = new Roba("Voda", "Voda za pice", 1.4   , avion1);
            Roba roba4 = new Roba("Ploce", "Drvene ploce", 3.4, avion2);
            Roba roba5 = new Roba("Stolica", "Plasticna stolica", 2.4, avion2);

            Dao<Avion, Integer> daoAvion = DaoManager.createDao(connectionSource,Avion.class);
            Dao<Roba, Integer> daoRoba = DaoManager.createDao(connectionSource,Roba.class);

            daoAvion.create(avion1);
            daoAvion.create(avion2);

            daoRoba.create(roba1);
            daoRoba.create(roba2);
            daoRoba.create(roba3);
            daoRoba.create(roba4);
            daoRoba.create(roba5);

            List<Avion> pomocnalista1 = daoAvion.queryForAll();
            for (Avion a:pomocnalista1){
                System.out.println(a);
            }
            List<Roba> pomocnalista2 = daoRoba.queryForAll();
            for (Roba r:pomocnalista2) {
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
