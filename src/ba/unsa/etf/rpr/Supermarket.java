package ba.unsa.etf.rpr;

public class Supermarket {
    private int brojac = 0;
    private Artikl[] artikli = new Artikl[1000];

    public boolean dodajArtikl(Artikl a){
        if(brojac < 1000){
            artikli[brojac] = new Artikl(a.getNaziv(), a.getCijena(), a.getKod());
            brojac++;
            return true;
        }
        return false;
    }

    public Artikl izbaciArtiklSaKodom(String kod) {
        for(int i = 0; i < brojac; i++){
            if(artikli[i].getKod().equals(kod)){
                Artikl novi = new Artikl(artikli[i].getNaziv(), artikli[i].getCijena(), artikli[i].getKod());
                artikli[i] = null;
                pomjeriSve(i);
                return novi;
            }
        }
        return null;
    }

    public Artikl[] getArtikli() {
        return artikli;
    }

    private void pomjeriSve(int pozicija){
        for( int i = 0; i < brojac; i++){
            artikli[i] = artikli[i+1];
        }
        artikli[brojac] = null;
        brojac--;
    }
}
