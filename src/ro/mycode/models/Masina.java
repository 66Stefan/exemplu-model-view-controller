package ro.mycode.models;


import java.sql.SQLOutput;

public class Masina {

    private String marca;

    private String model;

    private int anFabricatie;

    private String culoare;

    private Boolean rezervata;

    public String afisareMasina() {

        String text = "";
        text += "Marca masina: " + this.marca + "\n";
        text += "Denumire model " + this.marca + " : " + this.model + "\n";
        text += "Anul fabricatiei : " + this.anFabricatie + "\n";
        text += "Culoare : " + this.culoare + "\n";
        text += "masina este rezervata :" + this.rezervata + "\n";


        return text;

    }

    //constructorii

    public Masina(){

        System.out.println("Stefan ce mai faci");
    }

    public Masina(String ex){

        System.out.println("Eu sunt constructorul "+ex);
    }

    public Masina(String marca,String model,int anFabricatie, String culoare, Boolean rezervata){
        this.marca=marca;
        this.model=model;
        this.culoare=culoare;
        this.rezervata=rezervata;
        this.anFabricatie=anFabricatie;
    }





    //accesorii get and set

    public void setMarca(String marca) {
        if (marca.equals("VW")) {
            System.out.print("varza");
            System.out.println("Cumparati un peugeot");
            this.marca = "undefined";
        } else {
            this.marca = marca;
        }
    }


    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        if (model.equals("B6")) {
            System.out.println("nu mai este pe stoc!");
            this.model = "lipsa stoc";
        } else {
            this.model = model;
        }
    }

    public int getAnFabricatie() {
        return this.anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        if (anFabricatie > 2023) {
            System.out.println("Suntem inca in anul 2023!");
            this.anFabricatie = 0;
        } else {

            this.anFabricatie = anFabricatie;
        }
    }


    public String getCuloare() {
        return this.culoare;
    }

    public void setCuloare(String culoare) {
        if (culoare == "Roz") {
            System.out.println("Culoarea nu este pe stoc");
            this.culoare = "Alege alta culoare!";
        } else {
            this.culoare = culoare;
        }

    }

    public Boolean setRezervare() {
        return this.rezervata;
    }

    public void getRezervare(Boolean rezervare) {
        if (rezervare == true) {
            System.out.println("Nu se poate rezerva!");

        }else {
            this.rezervata = rezervare;
        }
    }


    public String getMarca() {
        return this.marca;
    }
}



