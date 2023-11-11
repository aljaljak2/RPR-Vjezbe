package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao{
    private File file;
    ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile() {
        this.file = new File("src/main/resources/laptopi.txt");
        this.laptopi = new ArrayList<>();
    }


    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public Laptop dodajLaptopUFile(Laptop laptop)  throws IOException {
        FileOutputStream fOut=new FileOutputStream(file);
        ObjectOutputStream oOut= new ObjectOutputStream(fOut);
        laptopi.add(laptop);
        oOut.writeObject(laptopi);
        fOut.close();
        oOut.close();
        return laptop;
    }

    @Override
    public Laptop getLaptop(String procesor) {
        for(Laptop l:laptopi){
            if(l.getProcesor().equals(procesor))
                return l;
        }
        throw new NeogovarajuciProcesorException("Laptop s tim procesorom ne postoji u listi");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi.addAll(laptopi);
    }

    @Override
    public ArrayList<Laptop> VratiPodatkeIzDatoteke() throws IOException, ClassNotFoundException {
        ArrayList<Laptop> povratna=new ArrayList<>();
        FileInputStream fIn=new FileInputStream(file);
        ObjectInputStream oIn=new ObjectInputStream(fIn);
        povratna= (ArrayList<Laptop>) oIn.readObject();
        return povratna;
    }
}
