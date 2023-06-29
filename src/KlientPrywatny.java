import java.io.FileNotFoundException;
import java.util.List;

public class KlientPrywatny extends Klient {

    public KlientPrywatny(int wiek, List<String> adresMail, int telefon, int liczbaWizyt) throws Exception {
        super(wiek, adresMail, telefon,liczbaWizyt);

    }
    public KlientPrywatny(int wiek, List<String> adresMail, int telefon,boolean pierwszeWejscie) throws FileNotFoundException {
        super(wiek, adresMail, telefon,pierwszeWejscie);

    }
    public KlientPrywatny(Klient klient) throws Exception {
        super(klient.getWiek(),klient.getAdresMail(),klient.getTelefon(),klient.getLiczbaWizyt());

    }
    public KlientPrywatny(Klient klient,boolean tf) throws Exception {
        super(klient.getWiek(),klient.getAdresMail(),klient.getTelefon(),klient.isPierwszeWejscie());

    }
}
