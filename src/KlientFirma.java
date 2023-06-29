import java.util.ArrayList;
import java.util.List;

public class KlientFirma extends Klient {
    private String nazwaFirmy;
    private int NIP;


    public KlientFirma(int wiek, List<String> adresMail, int telefon,int liczbawejsc,String nazwaFirmy,int NIP) throws Exception {
        super(wiek, adresMail, telefon,liczbawejsc);
        this.nazwaFirmy=nazwaFirmy;
        this.NIP=NIP;

    }
    public KlientFirma(int wiek, List<String> adresMail, int telefon,boolean pierwszeWejscie,String nazwaFirmy,int NIP) throws Exception {
        super(wiek, adresMail, telefon,pierwszeWejscie);
        this.nazwaFirmy=nazwaFirmy;
        this.NIP=NIP;

    }

    public KlientFirma(Klient klient,String nazwaFirmy, int NIP) throws Exception {
            super(klient.getWiek(), klient.getAdresMail(), klient.getTelefon(), klient.getLiczbaWizyt());

        this.nazwaFirmy=nazwaFirmy;
        this.NIP=NIP;

    }
    public KlientFirma(Klient klient,String nazwaFirmy, int NIP,boolean pierwszewejscie) throws Exception {
        super(klient.getWiek(), klient.getAdresMail(), klient.getTelefon(), klient.isPierwszeWejscie());

        this.nazwaFirmy=nazwaFirmy;
        this.NIP=NIP;

    }
    //getter i setter
    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    //funkcjonalnosci
    public void updateKlient(String nazwa,String dana){
        List<String> ok=new ArrayList<String>();
        for (int i = 0; i <getAdresMail().size() ; i++) {
            ok.add(getAdresMail().get(i));
        }

        switch (nazwa){
            case "wiek": setWiek(Integer.parseInt(dana));
            case "dodaj mail": {
                ok.add(dana);
                setAdresMail(ok);
                break;
            }
            case "usuń mail": {
                ok.remove(Integer.parseInt(dana));
                setAdresMail(ok);
                break;
            }
            case "nazwa firmy":setNazwaFirmy(dana);
            case "NIP":setNIP(Integer.parseInt(dana));

        }
    }

    @Override
    public String toString() {

        return super.toString()+ "KlientFirma{" +
                "nazwaFirmy='" + nazwaFirmy + '\'' +
                ", NIP=" + NIP +
                '}';
    }
    public String toSave() {

        return super.toSave()+
                ";" + nazwaFirmy  +
                ";" + NIP ;
    }

}
