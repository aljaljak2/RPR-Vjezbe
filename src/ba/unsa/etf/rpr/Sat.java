package ba.unsa.etf.rpr;

public class Sat {
private int sati, minute, sekunde;
public Sat(int sati, int minute, int sekunde){
    Postavi(sati, minute, sekunde);
}
public void Postavi(int sati, int minute, int sekunde){
    this.sati=sati;
    this.minute=minute;
    this.sekunde=sekunde;

}
public void Sljedeci(){
    sekunde=sekunde+1;
    if(sekunde==60) {sekunde=0; minute=minute+1;}
    if(minute==60) {minute=0; sati=sati+1;}
    if(sati==24) sati=0;
}
public void Prethodni(){
    sekunde=sekunde-1;
    if(sekunde==-1) {sekunde=59; minute=minute-1;}
    if(minute==-1) {minute=59; sati=sati-1;}
    if(sati==-1) sati=23;
}
void PomjeriZa(int pomak){
    if(pomak>0) for (int i=0; i<pomak;i++) this.Sljedeci();
    else for(int i=0; i<-pomak;i++) this.Prethodni();
}
public int DajSate(){
    return this.sati;
}
public int DajMinute(){
    return this.minute;
}
public int DajSekunde(){
    return this.sekunde;
}
public StringBuilder Ispisi(){
    return new StringBuilder().append(this.sati).append(":").append(this.minute).append(":").append(this.sekunde);
   // return this.sati+":"+this.minute+":"+this.sekunde;
}
    public static void main(String[] args) {
	Sat s= new Sat(15,30,45);
        System.out.println(s.Ispisi());
	s.Sljedeci();
        System.out.println(s.Ispisi());
	s.PomjeriZa(-48);
        System.out.println(s.Ispisi());
	s.Postavi(0,0,0);
        System.out.println(s.Ispisi());


    }
}
