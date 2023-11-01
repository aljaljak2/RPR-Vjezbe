package ba.unsa.etf.rpr;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj {
    Grad grad;
    String broj;
     FiksniBroj(Grad grad, String broj){
        if(grad==null) {
            throw new IlegalanBrojException("Broj telefona nije korektan!");
        }
        this.grad=grad;
        this.broj=broj;
    }
    @Override
    public String ispisi(){
        if(grad==null || broj==null) {
            return null;
        }
         return grad.getBrojTelefona()+"/"+broj;
    }
    @Override
    public int hashCode(){
        return Objects.hash(grad,broj);
    }
    public Grad getGrad(){
         return this.grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getBroj(){
         return this.broj;
    }

}
