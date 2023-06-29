import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;

public abstract class Klient {

    private int wiek;
    private List<String> adresMail;
    private int telefon;
    private static int minWiek= 18;

    private int punkty=0;

    //pomocniczne
    private int idAdd;
    static int id=0;

    //wielodziedziczenie
    private int liczbaWizyt=0;
    private boolean pierwszeWejscie=false;

    //listy
    private ArrayList<Uwagi> uwagi;
    private static Set<Klient> extend= new HashSet<Klient>();

    //konstruktory
    public Klient(int wiek, List<String> adresMail, int telefon,int liczbaWizyt) throws Exception {
        if (wiek<this.minWiek){
            throw new Exception("niepoprawny wiek, osoba zbyt młoda");
        }
        this.wiek = wiek;
        this.adresMail = adresMail;
        this.telefon = telefon;
        this.uwagi=new ArrayList<>();
        this.liczbaWizyt=liczbaWizyt;
        this.idAdd= id++;
        if (liczbaWizyt==0){
            setPierwszeWejscie(true);
        }
        extend.add(this);


    }

    public Klient(int wiek, List<String> adresMail, int telefon, boolean pierwszeWejscie) throws FileNotFoundException {
        this.wiek = wiek;
        this.adresMail = adresMail;
        this.uwagi=new ArrayList<>();
        this.telefon = telefon;
        this.pierwszeWejscie=pierwszeWejscie;
        this.idAdd= id++;
        extend.add(this);

    }

    //getery i setery

    public int getPunkty () {
        return punkty;
    }

    public void setPunkty ( int punkty){
        this.punkty = punkty;
    }

    public int getWiek () {
        return wiek;
    }

    public void setWiek ( int wiek){
        this.wiek = wiek;
    }

    public void setPierwszeWejscie(boolean pierwszeWejscie) {
        this.pierwszeWejscie = pierwszeWejscie;
    }

    public int getLiczbaWizyt() {
        return liczbaWizyt;
    }

    public boolean isPierwszeWejscie() {
        return pierwszeWejscie;
    }

    public List<String> getAdresMail () {
        return adresMail;
    }

    public void setAdresMail (List <String> adres) {
        this.adresMail = adres;
    }

    public int getTelefon () {
        return telefon;
    }

    public static Set<Klient> getExtend() {
        return extend;
    }

    public ArrayList<Uwagi> getUwagi() {
        return uwagi;
    }


    //asocjacje
    public void addUwagi(Uwagi uwaga) throws Exception {
        this.uwagi.add(uwaga);
        if (uwagi.size() > 3) {
            throw new Exception("zbyt duzu uwag, nalezy poprawic blad");
        }


    }


    public void  updateKlient(  String nazwa,String dana) throws Exception {
        List<String> ok=new ArrayList<String>();
        for (int i = 0; i <adresMail.size() ; i++) {
            ok.add(getAdresMail().get(i));
        }
        if (nazwa.equals("wiek")) {
            setWiek(Integer.parseInt(dana));

        }else if (nazwa.equals("dodaj mail")) {
            ok.add(dana);
            setAdresMail(ok);
        }else if (nazwa.equals("usuń mail")) {

            ok.remove(Integer.parseInt(dana));
            setAdresMail(ok);
        }else {
            System.out.println("nieprawidłowa dana");
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Klient)) return false;
        Klient klient = (Klient) o;
        return wiek == klient.wiek && telefon == klient.telefon && punkty == klient.punkty && Objects.equals(adresMail, klient.adresMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wiek, adresMail, telefon, punkty);
    }

    public void lookAtReservation() {
        System.out.println(uwagi.get(uwagi.size()-1).getRezerwacja());
    }

    public void askToDeleteData(){
        extend.remove(this);
    }

    public void askForAccess(){
        System.out.println(this);
    }

    public void deleteAccountIf(){
        int year=uwagi.get(uwagi.size()-1).getRezerwacja().getDataRozpoczecia().getYear();
        int monthValue=uwagi.get(uwagi.size()-1).getRezerwacja().getDataRozpoczecia().getMonthValue();
        int day=uwagi.get(uwagi.size()-1).getRezerwacja().getDataRozpoczecia().getDayOfMonth();
        if(year+3== LocalDateTime.now().getYear() && monthValue == LocalDateTime.now().getMonthValue() &&  LocalDateTime.now().getDayOfMonth()<day){
            askToDeleteData();
        }
    }
    public int useMemberDiscount() throws Exception {
        if (liczbaWizyt>0 && liczbaWizyt<6){
            return getUwagi().get(getUwagi().size()-1).getRezerwacja().getCena(1);
        }
        else if (liczbaWizyt>5){
            return getUwagi().get(getUwagi().size()-1).getRezerwacja().getCena(10);
        }else if(liczbaWizyt>15){
            return  getUwagi().get(getUwagi().size()-1).getRezerwacja().getCena(20);
        }else if (liczbaWizyt>25){
            return   getUwagi().get(getUwagi().size()-1).getRezerwacja().getCena(25);
        }else {
            throw new Exception("nie masz członowstwa stałego klienta");
        }
    }

    public void useFirstVisitDiscount() throws Exception {
        if (isPierwszeWejscie()){
            getUwagi().get(getUwagi().size()-1).getRezerwacja().getCena(15);
        }else{
            throw new Exception("Wykorzystałeś już ta znizke");
        }
        setPierwszeWejscie(false);
    }

    public void showListOfGames(){
        System.out.println(Gra.listaGier);
    }

    @Override
    public String toString() {
        if (pierwszeWejscie == false) {
            return "Klient{" +
                    "wiek=" + wiek +
                    ", adresMail=" + adresMail +
                    ", telefon=" + telefon +
                    ", liczbaWizyt= " + liczbaWizyt +
                    '}';
        }else {
            return "Klient{" +
                    "wiek=" + wiek +
                    ", adresMail= " + adresMail +
                    ", telefon= " + telefon +
                    ", pierwszeWejscie= " + pierwszeWejscie +
                    '}';
        }
    }

    //ekstensja

    public String toSave() {
        if (pierwszeWejscie == false){
            return  wiek +
                    ";" + adresMail +
                    ";" + telefon +
                    ";" + liczbaWizyt
                    ;
        }else {
            return  wiek +
                    ";" + adresMail +
                    ";" + telefon +
                    ";" + pierwszeWejscie
                    ;
        }

    }

    public static void showExtent() throws FileNotFoundException, Exception {
        PrintWriter writer=new PrintWriter(new File("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\KlientDB"));
        System.out.println("Extent of the class: " + Klient.class.getName());

        for (Klient klient : extend) {
            System.out.println(klient.toString());
            writer.write(klient.toSave()+"\n");
        }
        writer.close();
    }
    public static void saveExtent() throws FileNotFoundException, Exception {
        FileReader fileReader=new FileReader("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\KlientDB");
        Scanner scanner=new Scanner(fileReader);
        extend.clear();
        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            String[] valuesOfKlient= line.split(";");
            String kk=valuesOfKlient[1].replace('[',' ').replace(']',' ').trim();
            if (valuesOfKlient.length>4){
                if (valuesOfKlient[3].equals("true")) {
                    new KlientFirma(Integer.parseInt(valuesOfKlient[0]), List.of(kk), Integer.parseInt(valuesOfKlient[2]), Boolean.valueOf(valuesOfKlient[3]), valuesOfKlient[4], Integer.parseInt(valuesOfKlient[5]));
                }else {
                    new KlientFirma(Integer.parseInt(valuesOfKlient[0]), List.of(kk), Integer.parseInt(valuesOfKlient[2]), Integer.parseInt(valuesOfKlient[3]), valuesOfKlient[4], Integer.parseInt(valuesOfKlient[5]));
                }
            }else {
                if (valuesOfKlient[3].equals("true")) {
                    new KlientPrywatny(Integer.parseInt(valuesOfKlient[0]), List.of(valuesOfKlient[1]), Integer.parseInt(valuesOfKlient[2]), Boolean.valueOf(valuesOfKlient[3]));
                }else{
                    new KlientPrywatny(Integer.parseInt(valuesOfKlient[0]), List.of(valuesOfKlient[1]), Integer.parseInt(valuesOfKlient[2]), Integer.parseInt(valuesOfKlient[3]));
                }
            }
        }
        System.out.println(extend);
    }
}


