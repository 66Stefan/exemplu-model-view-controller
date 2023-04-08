package ro.mycode.view;

import ro.mycode.controllers.MasinaControll;
import ro.mycode.models.Masina;

import java.util.ArrayList;
import java.util.Scanner;

public class View {



    private MasinaControll masinaControll;
    private Scanner scanner;


    public View(){
        masinaControll= new MasinaControll();
        scanner= new Scanner(System.in);//

    }


    public void meniu(){
        System.out.println("Apasati tasta 1 pentru a afisa toate masinile");
        System.out.println("Apasati tasta 2 pentru a afisa masinile dupa  culoarea rosie");
        System.out.println("Apasati tasta 4 pentru a afisa masinile dupa Am");
        System.out.println("Apasa tasta 3 sa iesi!");
        System.out.println("Apasa tasta 5 pentru a adauga  o masina");
        //todo:szterg
        System.out.println("Apasa tasta 6 pentru a sterge o masina");
        System.out.println("Apasa tasta 7 pentru a edita o masina");


    }


    public void play(){
        boolean runnnig=true;
        while (runnnig){
            meniu();
            int alegere=Integer.parseInt(scanner.nextLine());//citesti un int de la tastatura
            switch (alegere){
                case 1: masinaControll.afisareMasina();
                break;
                case 2:showCarsByColor();
                break;
                case 3: runnnig= false;
                break;
                case 4: showCarsByYear();
                break;
                case 5: addNewcar();
                    break;
                case 6: deletedCarByYear();
                    break;
                case 7: updateMasina();
                    break;
                default:
                    System.out.println("nu a-ti introdus o valoare corecta");
            }


        }



    }


    public void showCarsByColor(){


        System.out.println("Introduceti culoarea ");

        String color=scanner.nextLine();//citeste un string


        ArrayList<Masina> masinas=masinaControll.findAllCarsByColor(color);


        for(int i=0;i<masinas.size();i++){

            System.out.println(masinas.get(i).afisareMasina());
        }

    }

    public void showCarsByYear(){

        System.out.println("Introduce-ti un an");

        int year=Integer.parseInt(scanner.nextLine());//citeste un int

        ArrayList<Masina> masina = masinaControll.findAllCarsAftherYer(year);
        for(int i=0;i<masina.size();i++){
            System.out.println(masina.get(i).afisareMasina());
        }
    }

    public  void addNewcar(){


        //todo:add conditions
        System.out.println("Introduce-ti un an");
        int anFabricatie=Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti culoarea ");
        String culoare=scanner.nextLine();

        System.out.println("Introduceti model ");
        String model=scanner.nextLine();

        System.out.println("Introduceti maca ");
        String marca=scanner.nextLine();

        System.out.println("Introduceti daca este rezervat(true sau false ");
        Boolean rezervat=Boolean.parseBoolean(scanner.nextLine());


        Masina masina= new Masina(marca,model,anFabricatie,culoare,rezervat);


        masinaControll.addCar(masina);
        System.out.println("Masina s-a adaugat cu succes!!!!!!!!!!!!!!!f");






    }

    public void deletedCarByYear(){
        //ArrayList<Masina> deleted = new ArrayList<>();
        System.out.println("Introduce-ti marca masinii pe care vreti sa o stergeti");
        String marca = scanner.nextLine();
        System.out.println("Introduce-ti modelul masinii pe care vreti sa  o stergeti");
        String model = scanner.nextLine();


        Masina carByMarcaAndModel = masinaControll.findCarByMarcaAndModel(marca, model);


        if(carByMarcaAndModel==null){

            System.out.println("Masina introdusa nu exista");
        }else{


            this.masinaControll.eraseCar(carByMarcaAndModel);


            System.out.println("Masina a fost stearsa cu  success!!");



        }
    }

    public void updateMasina(){
        System.out.println("Introduce-ti marca masinii pe care vreti sa o modificati");
        String marca = scanner.nextLine();
        System.out.println("Introduce-ti modelul masinii pe care vreti sa  o modificati");
        String model = scanner.nextLine();

        Masina carByMarcaAndModel = masinaControll.findCarByMarcaAndModel(marca, model);
        if(carByMarcaAndModel!=null){
            System.out.println("Introduce-ti ce vreti sa modificati:an,culoare,rezervata");
            String modific = scanner.nextLine();
            String[]deModificat=modific.split(",");


            for(int i=0;i<deModificat.length;i++){


                switch (deModificat[i]){
                    case "an":
                        System.out.println("Introduceti noul an");
                        int an = Integer.parseInt(scanner.nextLine());
                        this.masinaControll.editareAnul(marca, model, an);
                        break;
                    case "culoare":
                        System.out.println("introduce-ti culoarea:");
                        String culoare = scanner.nextLine();
                        this.masinaControll.editareCuloare(marca, model, culoare);
                        break;
                    case "rezervare":
                        System.out.println("Introduce-ti rezervarea");
                        Boolean rezervare = Boolean.parseBoolean(scanner.nextLine());
                        this.masinaControll.editareRezervare(marca,model,rezervare);
                        break;
                    default:
                        System.out.println("nu ati introdus  o obtiune corecta");

                }
            }




        }
    }



}
