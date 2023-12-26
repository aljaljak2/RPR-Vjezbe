package ba.unsa.etf.rpr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;

public class GeografijaDAO {
    private static GeografijaDAO instance=null;
    private Connection conn;
    private PreparedStatement dajGradove, dajGlavniGrad, brisanjeDrzave, dodavanjeGrada, dajNoviIdGrad, dodavanjeDrzave, dajNoviIdDrzava, promjenaGrada, pretragaDrzave, gradoviSDrzavama;

    public GeografijaDAO()  {

        String url="jdbc:sqlite:" + System.getProperty("user.home") +
                "/.geoapp/baza.db";
        try {
            conn= DriverManager.getConnection(url);
            dajGradove=conn.prepareStatement("SELECT * FROM grad ORDER BY broj_stanovnika DESC");
            dajGlavniGrad=conn.prepareStatement("SELECT g.id,g.naziv, g.broj_stanovnika, g.drzava FROM GRAD g, DRZAVA d WHERE d.glavni_grad=g.id AND d.naziv=?");
            brisanjeDrzave=conn.prepareStatement("DELETE FROM drzava WHERE naziv=?");
            dodavanjeGrada=conn.prepareStatement("INSERT INTO grad VALUES(?,?,?,?)");
            dajNoviIdGrad = conn.prepareStatement("SELECT MAX(id)+1 FROM grad");
            dajNoviIdDrzava=conn.prepareStatement("SELECT MAX(id)+1 FROM drzava");
            dodavanjeDrzave=conn.prepareStatement("INSERT INTO drzava VALUES(?, ?, ?)");
            promjenaGrada=conn.prepareStatement("UPDATE grad SET naziv=?, broj_stanovnika=?, drzava=? WHERE id=?");
            pretragaDrzave=conn.prepareStatement("SELECT * FROM drzava WHERE naziv=?");
            gradoviSDrzavama=conn.prepareStatement("SELECT * FROM grad g, drzava d WHERE g.drzava=d.id ORDER BY g.broj_stanovnika DESC");
        } catch (SQLException e) {
            KreirajBazu();
            try {
                dajGradove=conn.prepareStatement("SELECT * FROM grad ORDER BY broj_stanovnika DESC");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void KreirajBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.sql"));
            String sqlUpit = "";
            while (ulaz.hasNext()) {
                sqlUpit += ulaz.nextLine();
                if (sqlUpit.length() > 1 && sqlUpit.charAt(sqlUpit.length() - 1) == ';') {
                    try {
                        Statement stmt = conn.createStatement();
                        stmt.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

                ulaz.close();
            } catch(FileNotFoundException e){
                System.out.println("Ne postoji SQL datoteka... nastavljam sa praznom bazom");
            }

    }

    public static  GeografijaDAO getInstance(){
        if(instance==null) instance= new GeografijaDAO();
        return instance;
        }


    public static void removeInstance() {
        if (instance != null) {
            try {
                instance.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        instance = null;
    }

    public ArrayList<Grad> gradovi(){
        ArrayList<Grad> sviGradovi=new ArrayList<>();
        try {

            ResultSet rezultat=dajGradove.executeQuery();
         while(rezultat.next()){
             Grad g=new Grad(rezultat.getInt(1), rezultat.getString(2), rezultat.getInt(3), rezultat.getInt(4));
             sviGradovi.add(g);
         }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sviGradovi;
    }

    public Grad glavniGrad(String drzava){
       Grad povratni=null;

        try {
            dajGlavniGrad.setString(1,drzava);
            ResultSet rezultat=dajGlavniGrad.executeQuery();
           while(rezultat.next()) {
               povratni = (new Grad(rezultat.getInt(1), rezultat.getString(2), rezultat.getInt(3), rezultat.getInt(4)));
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return povratni;


    }
    public void obrisiDrzavu(String drzava){
        try {
            brisanjeDrzave.setString(1, drzava);
            brisanjeDrzave.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public void dodajGrad(Grad grad){
       try {
           int novi_id;
            ResultSet rs=dajNoviIdGrad.executeQuery();
            if(rs.next()){
                grad.setId(rs.getInt(1));
            }
            else {
                grad.setId(1);
            }
           dodavanjeGrada.setString(2,grad.getNaziv());
           dodavanjeGrada.setInt(3, grad.getBroj_stanovnika());
           dodavanjeGrada.setInt(4, grad.getDrzava());

           dodavanjeGrada.execute();
       } catch (SQLException e) {
           e.printStackTrace();
       }


    }

    public void dodajDrzavu(Drzava drzava){
        try {
            ResultSet rs=dajNoviIdDrzava.executeQuery();
            int novi_id;
            if(rs.next()){
                drzava.setId(rs.getInt(1));
            }
            else{
                drzava.setId(1);
            }
            dodavanjeGrada.setString(2,drzava.getNaziv());
            dodavanjeGrada.setInt(3, drzava.getGlavni_grad());
          dodavanjeGrada.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public void izmijeniGrad(Grad grad){
       try {
           promjenaGrada.setString(1, grad.getNaziv());
           promjenaGrada.setInt(2, grad.getBroj_stanovnika());
           promjenaGrada.setInt(3, grad.getDrzava());
           promjenaGrada.setInt(4, grad.getId());

           promjenaGrada.execute();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   public Drzava nadjiDrzavu(String drzava){
       Drzava rezultat=null;
       try {
           pretragaDrzave.setString(1,drzava);
           ResultSet rs=pretragaDrzave.executeQuery();
           while(rs.next()) {
               rezultat = (new Drzava(rs.getInt(1), rs.getString(2), rs.getInt(3)));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return rezultat;
   }
   public Map<Grad, Drzava> gradoviDrzave(){
        Map<Grad,Drzava> mapa=new LinkedHashMap<>();

       try {
           ResultSet rs=gradoviSDrzavama.executeQuery();
           while(rs.next()){
               Grad g=new Grad(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4));
               Drzava d=new Drzava(rs.getInt(5), rs.getString(6), rs.getInt(7) );
               mapa.put(g,d);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
         return mapa;
   }
}
