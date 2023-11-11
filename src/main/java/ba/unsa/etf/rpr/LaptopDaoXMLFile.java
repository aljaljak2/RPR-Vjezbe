package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao{
    private File file;
    ArrayList<Laptop> laptopi;

    public LaptopDaoXMLFile() {
        this.file = new File("src/main/resources/laptopi.xml");
        this.laptopi = new ArrayList<>();
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        this.laptopi.add(laptop);
    }

    @Override
    public Laptop dodajLaptopUFile(Laptop laptop) throws IOException {
        laptopi.add(laptop);
        XmlMapper xm=new XmlMapper();
        String upis=xm.writeValueAsString(laptopi);
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
    public ArrayList<Laptop> VratiPodatkeIzDatoteke() throws IOException {
        XmlMapper xm=new XmlMapper();
        return xm.readValue(file,new TypeReference<ArrayList<Laptop>>(){});
    }
}
