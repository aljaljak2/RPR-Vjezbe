package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GlavnaAplikacijaTest {

    @Test
    public void Test1() throws IOException, ClassNotFoundException{
        LaptopDaoSerializableFile lS=new LaptopDaoSerializableFile();
        ArrayList<Laptop> lap1=new ArrayList<>();
        for(int i=0;i<5;i++){
            lap1.add(new Laptop("Lenovo","Yoga"+""+(i+1),500, 8,0,512,"AMD Ryzen 5", "Radeon graphics",15));
        }
        lS.napuniListu(lap1);
        NeogovarajuciProcesorException baceno=assertThrows(NeogovarajuciProcesorException.class, ()->{lS.getLaptop("Intel i5");});
        assertTrue(baceno.getMessage().contains("procesorom"));

        lS.dodajLaptopUFile(new Laptop("HP","Pavilion",750, 16, 0, 1024, "AMD Ryzen 7","Radeon graphics", 15.6 ));
        lS.dodajLaptopUFile(new Laptop ("Acer", "Aspire3", 600, 8, 0, 256, "Intel i3", "Intel HD graphics", 15.6));
        ArrayList<Laptop> lap2=new ArrayList<>();
        lap2=lS.VratiPodatkeIzDatoteke();
        String ocekivaniIzlaz="{Laptop:  HP Pavilion, cijena: 750.0, hdd: 0, ssd: 1024, procesor: AMD Ryzen 7, grafickaKartica: Radeon graphics, velicina ekrana: 15.6}";
        assertEquals(lap2.get(5).toString(), ocekivaniIzlaz);
    }

    @Test
    public void Test2() throws IOException, ClassNotFoundException{
        LaptopDaoJSONFile lJsn=new LaptopDaoJSONFile();
        ArrayList<Laptop> lap1=new ArrayList<>();
        for(int i=0;i<5;i++){
            lap1.add(new Laptop("Lenovo","Yoga"+""+(i+1),500, 8,0,512,"AMD Ryzen 5", "Radeon graphics",15));
        }
        lJsn.napuniListu(lap1);
        assertThrows(NeogovarajuciProcesorException.class, ()->{lJsn.getLaptop("Intel i5");});

        lJsn.dodajLaptopUFile(new Laptop("HP","Pavilion",750, 16, 0, 1024, "AMD Ryzen 7","Radeon graphics", 15.6 ));
        lJsn.dodajLaptopUFile(new Laptop ("Acer", "Aspire3", 600, 8, 0, 256, "Intel i3", "Intel HD graphics", 15.6));
        ArrayList<Laptop> lap2=new ArrayList<>();
        lap2=lJsn.VratiPodatkeIzDatoteke();
        String ocekivaniIzlaz="{Laptop:  HP Pavilion, cijena: 750.0, hdd: 0, ssd: 1024, procesor: AMD Ryzen 7, grafickaKartica: Radeon graphics, velicina ekrana: 15.6}";
        assertEquals(lap2.get(5).toString(), ocekivaniIzlaz);
    }
 @Test
    public void Test3() throws IOException, ClassNotFoundException{
        LaptopDaoXMLFile lXml=new LaptopDaoXMLFile();
     ArrayList<Laptop> lap1=new ArrayList<>();
     for(int i=0;i<5;i++){
         lap1.add(new Laptop("Lenovo","Yoga"+""+(i+1),500, 8,0,512,"AMD Ryzen 5", "Radeon graphics",15));
     }
     lXml.napuniListu(lap1);
     assertThrows(NeogovarajuciProcesorException.class, ()->{lXml.getLaptop("Intel i5");});

     lXml.dodajLaptopUFile(new Laptop("HP","Pavilion",750, 16, 0, 1024, "AMD Ryzen 7","Radeon graphics", 15.6 ));
     lXml.dodajLaptopUFile(new Laptop ("Acer", "Aspire3", 600, 8, 0, 256, "Intel i3", "Intel HD graphics", 15.6));
     ArrayList<Laptop> lap2=new ArrayList<>();
     lap2=lXml.VratiPodatkeIzDatoteke();
     String ocekivaniIzlaz="{Laptop:  HP Pavilion, cijena: 750.0, hdd: 0, ssd: 1024, procesor: AMD Ryzen 7, grafickaKartica: Radeon graphics, velicina ekrana: 15.6}";
     assertEquals(lap2.get(5).toString(), ocekivaniIzlaz);
    }
@Test
    public void Test4() throws IOException{
        Laptop l1=new Laptop("HP","Pavilion",750, 16, 0, 1024, "AMD Ryzen 7","Radeon graphics", 15.6 );
        Laptop l2=new Laptop ("Acer", "Aspire3", 600, 8, 0, 256, "Intel i3", "Intel HD graphics", 15.6);

        LaptopDaoJSONFile lJson=Mockito.mock(LaptopDaoJSONFile.class);

        ArrayList<Laptop> lap=new ArrayList<>();
        lap.add(l1);
        lap.add(l2);
        /*Ovdje je upotrijebljen mockig iz razloga sto je interesantno vidjeti
        * kako ce metoda VratiPodatkeIzDatoteke() vratiti listu iako nismo prethodno iskoristili
        * metodu dodajLaptopUFile() da upisemo podatke u JSON file u ovom slucaju*/
        Mockito.when(lJson.VratiPodatkeIzDatoteke()).thenReturn(lap);

        assertEquals("HP", lJson.VratiPodatkeIzDatoteke().get(0).getBrend());
        assertEquals("Intel i3", lJson.VratiPodatkeIzDatoteke().get(1).getProcesor());
        assertEquals(750, lJson.VratiPodatkeIzDatoteke().get(0).getCijena());

    }

    @Test
    public void Test5() throws IOException{
        Laptop l1=new Laptop("HP","Pavilion",750, 16, 0, 1024, "AMD Ryzen 7","Radeon graphics", 15.6 );
        Laptop l2=new Laptop ("Acer", "Aspire3", 600, 8, 0, 256, "Intel i3", "Intel HD graphics", 15.6);

        LaptopDaoXMLFile lXml=Mockito.mock(LaptopDaoXMLFile.class);
        ArrayList<Laptop> lap=new ArrayList<>();
        lap.add(l1);
        lap.add(l2);
        Mockito.when(lXml.VratiPodatkeIzDatoteke()).thenReturn(lap);
        assertEquals("HP", lXml.VratiPodatkeIzDatoteke().get(0).getBrend());
        assertEquals("Intel i3", lXml.VratiPodatkeIzDatoteke().get(1).getProcesor());
        assertEquals(750, lXml.VratiPodatkeIzDatoteke().get(0).getCijena());
    }
    @Test
    public void Test6() throws IOException, ClassNotFoundException{
        Laptop l1=new Laptop("HP","Pavilion",750, 16, 0, 1024, "AMD Ryzen 7","Radeon graphics", 15.6 );
        Laptop l2=new Laptop ("Acer", "Aspire3", 600, 8, 0, 256, "Intel i3", "Intel HD graphics", 15.6);

        LaptopDaoSerializableFile lS=Mockito.mock(LaptopDaoSerializableFile.class);
        ArrayList<Laptop> lap=new ArrayList<>();
        lap.add(l1);
        lap.add(l2);
        Mockito.when(lS.VratiPodatkeIzDatoteke()).thenReturn(lap);
        assertEquals("HP", lS.VratiPodatkeIzDatoteke().get(0).getBrend());
        assertEquals("Intel i3", lS.VratiPodatkeIzDatoteke().get(1).getProcesor());
        assertEquals(750, lS.VratiPodatkeIzDatoteke().get(0).getCijena());
    }



}