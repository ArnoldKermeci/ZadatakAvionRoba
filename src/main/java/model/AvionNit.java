package model;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class AvionNit extends Thread {
    static Boolean dozvoljenosletanje = true;

    Avion avion;

    public AvionNit(Avion avion) {
        this.avion = avion;
    }

    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");
            Dao<Avion, Integer> daoAvion = DaoManager.createDao(connectionSource, Avion.class);
            List<Avion> pomocnalista1 = daoAvion.queryForAll();
            for (Avion a : pomocnalista1) {
                AvionNit nit = new AvionNit(a);
                nit.start();
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Svi su poleteli.");

    }

    @Override
    public void run() {
        System.out.println("Počinju provere za avion <id_aviona>" + avion.getOznaka());
        try {
            sleep((long) (Math.random()*2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (dozvoljenosletanje) {
            System.out.println("Avion <id_aviona> je spreman za poletanje i čeka dozvolu za poletanje" + avion.getOznaka());
            System.out.println("Avion <id_aviona> izlazi na pistu i poleće" + avion.getOznaka());
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Avion <id_aviona> je poleteo" + avion.getOznaka());
        }

    }
}
