package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "roba")

public class Roba {
    public static final String POLJE_NAZIV = "naziv";
    public static final String POLJE_OPIS = "opis";
    public static final String POLJE_TEZINA = "tezina";
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_NAZIV)
    private String naziv;
    @DatabaseField(columnName = POLJE_OPIS)
    private String opis;
    @DatabaseField(columnName = POLJE_TEZINA)
    private double tezina;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, canBeNull = false)
    private Avion avion;



    public Roba(){

    }

    public Roba(String naziv, String opis, double tezina){
        this.naziv=naziv;
        this.opis=opis;
        this.tezina=tezina;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    @Override
    public String toString() {
        return "Roba{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", tezina=" + tezina +
                '}';
    }
}