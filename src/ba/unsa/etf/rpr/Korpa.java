package ba.unsa.etf.rpr;

public class Korpa {
    private Artikl[] artikli = new Artikl[50];
    private int brojac = 0;

    public boolean dodajArtikl(Artikl a){
        if(brojac < 50){
            artikli[brojac] = new Artikl(a.getNaziv(), a.getCijena(), a.getKod());
            brojac++;
            return true;
        }
        return false;
    }

    public Artikl izbaciArtiklSaKodom(String kod){
        for(int i = 0; i<brojac; i++){
            if(artikli[i].getKod().equals(kod)){
                Artikl novi = new Artikl(artikli[i].getNaziv(), artikli[i].getCijena(), artikli[i].getKod());
                artikli[i] = null;
                pomjeriSve(i);
                return novi;
            }
        }
        return null;
    }

    private void pomjeriSve(int pozicija){
        for(int i = pozicija; i<brojac; i++){
            artikli[i]=artikli[i+1];
        }
        artikli[brojac] = null;
        brojac--;
    }

    public int dajUkupnuCijenuArtikala(){
        int cijena = 0;
        for(int i = 0; i<brojac; i++){
            cijena = cijena + artikli[i].getCijena();
        }
        return cijena;
    }

    public Artikl[] getArtikli(){
        return artikli;
    }
}
