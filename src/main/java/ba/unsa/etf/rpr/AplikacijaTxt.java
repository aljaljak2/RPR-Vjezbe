package ba.unsa.etf.rpr;

import java.util.ArrayList;


public class AplikacijaTxt {
    public static void main(String[] args){
        LaptopDaoSerializableFile sf=new LaptopDaoSerializableFile();
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
        try {
            System.out.println("\n--------------------------------------------------------------------------------------------");
            sf.dodajLaptopUFile(new Laptop("HP", "Pavilion", 750, 16, 0, 1024, "AMD Ryzen 7", "Radeon graphics", 15.6));
            ArrayList<Laptop> a=sf.VratiPodatkeIzDatoteke();
            System.out.println(a.get(6).toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
