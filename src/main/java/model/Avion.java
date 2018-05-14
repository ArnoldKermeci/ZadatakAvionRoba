package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "avion")

public class Avion {
    public static final String POLJE_OZNAKA = "oznaka";
    public static final String RASPON_KRILA = "raspon_krila";
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_OZNAKA)
    private String oznaka;
    @DatabaseField(columnName = RASPON_KRILA)
    private int rasponKrila;

    @ForeignCollectionField(foreignFieldName = "avion",eager=false,maxEagerLevel = 1)
    private ForeignCollection<Roba> roba;

    public Avion(){

    }
    public Avion (String oznaka, int rasponKrila){
        this.oznaka = oznaka;
        this.rasponKrila = rasponKrila;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public int getRasponKrila() {
        return rasponKrila;
    }

    public void setRasponKrila(int rasponKrila) {
        this.rasponKrila = rasponKrila;
    }
    @Override
    public String toString(){
        return "Avion {" + "id= " + id + ", oznaka='" + oznaka + '\'' +", raspon_krila= '" + rasponKrila + '\''+'}';
    }
}