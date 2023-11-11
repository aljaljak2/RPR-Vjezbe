package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao{
    private File file;
    ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile() {
        this.file = new File("src/resources/laptopi.json");
        this.laptopi=new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
     this.laptopi.add(laptop);
    }

    @Override
    public Laptop dodajLaptopUFile(Laptop laptop) throws IOException {
        laptopi.add(laptop);
        JsonMapper jm=new JsonMapper();
        String upis=jm.writeValueAsString(laptopi);
        FileOutputStream fOut=new FileOutputStream(file);
        fOut.write(upis.getBytes());
        fOut.close();
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
      ObjectMapper om=new ObjectMapper();
      return om.readValue(file, new TypeReference<ArrayList<Laptop>>(){});
    }
}
