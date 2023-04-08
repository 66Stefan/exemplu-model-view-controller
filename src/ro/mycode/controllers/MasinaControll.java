package ro.mycode.controllers;
import  ro.mycode.models.Masina;
import java.util.ArrayList;
public class MasinaControll {

    private ArrayList<Masina> masini;


    public MasinaControll() {
        this.masini = new ArrayList<>();

        this.load();

    }


    public void load() {

        Masina masina = new Masina("Audi", "A8", 1985, "Rosu", false);
        Masina masina1 = new Masina("BMW", "M6", 2023, "Negru", true);
        Masina masina2 = new Masina("Dcia", "Logan", 2022, "Rosu", true);
        Masina masina3 = new Masina("Peugeot", "2008", 2022, "Rosu", false);


        this.masini.add(masina1);
        this.masini.add(masina);
        this.masini.add(masina2);
        this.masini.add(masina3);

    }

    //todo: afisare

    public void afisareMasina() {

        for (int i = 0; i < masini.size(); i++) {
            System.out.println(masini.get(i).afisareMasina());
        }
    }

    //todo:functie ce returneaza masina cea mai noua:)pahare

    public Masina masinaCeaMaiNoua() {

        //presupunem ca prima masina este cea mai noua

        Masina noua = masini.get(0);
        for (int i = 0; i < masini.size(); i++) {

            if (masini.get(i).getAnFabricatie() > noua.getAnFabricatie()) {

                noua = masini.get(i);
            }
        }

        return noua;
    }

    public ArrayList<Masina> findAllCarsByColor(String color) {

        ArrayList<Masina> filter = new ArrayList<>();

        for (int i = 0; i < masini.size(); i++) {
            if (masini.get(i).getCuloare().equals(color)) {
                filter.add(masini.get(i));

            }

        }

        return filter;
    }

    //todo: metoda ce returneaza masinile dupa un anumit an

    public ArrayList<Masina> findAllCarsAftherYer(int year) {
        ArrayList<Masina> filter = new ArrayList<>();
        for (int i = 0; i < masini.size(); i++) {
            if ((masini.get(i).getAnFabricatie()) == year) {
                filter.add(masini.get(i));
            }
        }
        return filter;
    }

    //todo: adauga o masina


    public void addCar(Masina masina) {


        this.masini.add(masina);

    }

    //todo:functie ce primeste ca parametru marca si modelul unei masini  si returneaza o masina daca nu gaseste masina sa returneze null

    public Masina findCarByMarcaAndModel(String marca, String model) {

        for (int i = 0; i < masini.size(); i++) {

            if (masini.get(i).getModel().equals(model) && masini.get(i).getMarca().equals(marca)) {

                return masini.get(i);
            }
        }
        return null;
    }


    public void eraseCar(Masina masina) {


        this.masini.remove(masina);
    }



    //todo:functie ce editeaza anul unei masini
    public Boolean editareAnul(String marca,String model, int anul) {
        Masina carByMarcaAndModel = this.findCarByMarcaAndModel(marca, model);
        if(carByMarcaAndModel!=null){
            carByMarcaAndModel.setAnFabricatie(anul);
            return true;
        }
        return false;
    }
    //todo:functie ce editeaza culoarea

    public Boolean editareCuloare(String  marca, String model, String culoare){
        Masina carByMarcaAndModel = this.findCarByMarcaAndModel(marca, model);
        if(carByMarcaAndModel!=null){
            carByMarcaAndModel.setCuloare(culoare);
            return  true;
        }
        return  false;
    }

    //todo:functie ce editeaza starea (rezervata)
    public Boolean editareRezervare(String  marca, String model, Boolean rezervare){
        Masina carByMarcaAndModel = this.findCarByMarcaAndModel(marca, model);
        if(carByMarcaAndModel!=null){
            carByMarcaAndModel.setRezervare(rezervare);
            return  true;
        }
        return  false;
    }







}
