package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class AplikacijaJson {
    public static void main(String[] args){
        LaptopDaoJSONFile sf= new LaptopDaoJSONFile();
        ArrayList<Laptop> lap=new ArrayList<>();
        for(int i=0;i<5;i++){
            lap.add(new Laptop("Lenovo","Yoga"+""+(i+1),500, 8,0,512,"Ryzen 5", "Radeon graphics",15));
        }
        sf.napuniListu(lap);
        try{
            Laptop l1=sf.getLaptop("moj procesor");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            sf.dodajLaptopUFile(lap.get(2));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try {
            ArrayList<Laptop> zaIspis = sf.VratiPodatkeIzDatoteke();
            for(Laptop l:zaIspis){
                System.out.println(l.toString());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
