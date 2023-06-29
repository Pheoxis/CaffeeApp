import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;

public class PracownikSalonuGier implements IPracownik{

    private int numerIdentyfikacyjny;
    private LocalDateTime dataUrodzenia;
    private int stawkaZaH;
    private String adresMail;
    private int telefon;



    //listy
    static List<Dyzur> ListadyzurPracownika=new ArrayList<>();
    List<Dyzur> dyzurPracownika=new ArrayList<>();
    List<Rezerwacja> rezerwacjas=new ArrayList<>();
     private List<Umiejetnosci> umie=new ArrayList<>();
    private static List<Integer> Identyfikatory=new ArrayList<>();
    private static List<PracownikSalonuGier> pracownikSalonuGierDataBase=new ArrayList<>();

    public List<Dyzur> getDyzurPracownika() {
        return dyzurPracownika;
    }

    public PracownikSalonuGier(int numerIdentyfikacyjny,LocalDateTime dataUrodzenia, int stawkaZaH, String adresMail, int telefon) throws Exception {
        this.numerIdentyfikacyjny=numerIdentyfikacyjny;
        this.dataUrodzenia = dataUrodzenia;
        this.stawkaZaH = stawkaZaH;
        this.adresMail = adresMail;
        this.telefon = telefon;
        this.umie=new ArrayList<>();
        for (int x:
                Identyfikatory) {
            if(x==numerIdentyfikacyjny){
                throw new Exception("dany identyfikator jest juz zajety");
            }
        }
        Identyfikatory.add(numerIdentyfikacyjny);
        pracownikSalonuGierDataBase.add(this);
    }

    //gettery i settery
    public void setStawkaZaH(int stawkaZaH) {
        this.stawkaZaH = stawkaZaH;
    }

    public String getAdresMail() {
        return adresMail;
    }

    public int getTelefon() {
        return telefon;
    }

    public int getNumerIdentyfikacyjny() {
        return numerIdentyfikacyjny;
    }

    public static List<PracownikSalonuGier> getPracownikSalonuGierDataBase() {
        return pracownikSalonuGierDataBase;
    }

    public List<Rezerwacja> getRezerwacjas() {
        return rezerwacjas;
    }

    public static List<Dyzur> getListadyzurPracownika() {
        return ListadyzurPracownika;
    }

    //asocjacje
    public void dodajGre(Gra gra){
        List<Gra> listaG=new ArrayList<Gra>();
        for (int i = 0; i <gra.getListaGier().size() ; i++) {
            listaG.add(gra.getListaGier().get(i));
        }
        listaG.add(gra);
        gra.setListaGier(listaG);
    }
    public void dodajUmiejetnosc(Umiejetnosci umieje) {
        if(!umie.contains(umieje)) {
            umie.add(umieje);

        }
    }
    public void addRezerwacja(Rezerwacja rezerwacja) {
        // Check if we have the information already
        if(!rezerwacjas.contains(rezerwacja)) {
            rezerwacjas.add(rezerwacja);

            // Add the reverse connection
            rezerwacja.addPracownik(this);
        }
    }

    public void addDyzur(Dyzur dyzur) {
        // Check if we have the information already
        if (!dyzurPracownika.contains(dyzur)) {
            dyzurPracownika.add(dyzur);
            ListadyzurPracownika.add(dyzur);

            // Add the reverse connection
            dyzur.addPrac(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PracownikSalonuGier)) return false;
        PracownikSalonuGier that = (PracownikSalonuGier) o;
        return numerIdentyfikacyjny == that.numerIdentyfikacyjny && stawkaZaH == that.stawkaZaH && telefon == that.telefon && dataUrodzenia.equals(that.dataUrodzenia) && adresMail.equals(that.adresMail);
    }


    @Override
    public String toString() {

        return "PracownikSalonuGier{" +
                "numerIdentyfikacyjny=" + numerIdentyfikacyjny+
                ", dataUrodzenia=" + dataUrodzenia +
                ", stawkaZaH=" + stawkaZaH +
                ", adresMail='" + adresMail + '\'' +
                ", telefon=" + telefon +
                ///  ", umie=" + umie +

                '}';

    }

    //funkcjonalności
    @Override
    public void addNewGame(Gra gra) {
        System.out.println("lista gier po dodaniu "+ gra + " : "+ gra.getListaGier().toString());
    }

    @Override
    public void lookAtReservation(int index) {
        System.out.println("Wgląd na rezerwacje o indexie "+ index +" "+ rezerwacjas.get(rezerwacjas.size()-1).getRezerwacje().get(index).toString());
    }
    public void lookAtAllReservations() {
        System.out.println(getRezerwacjas().get(getRezerwacjas().size()-1).getRezerwacjeDataSet());

    }
    public List<Integer> getIdentyfikatory() {
        return Identyfikatory;
    }

    public void checkPayment(){
        System.out.println(getRezerwacjas().get(getRezerwacjas().size()-1).getSposobPlatnosci());
    }
    public void getIndexOfRezerwation(Klient klient){
        System.out.println("numer rezeracji klienta to : " + klient.getUwagi().get(klient.getUwagi().size()-1).getRezerwacja().getNumerRezerwacji());
    }
    public void showListOfGames(){
        System.out.println(Gra.listaGier);
    }

    public void sendSmsOrMail(Klient klient, String mail){
        System.out.println("hi " + klient.getAdresMail() + " we are writing to you because " + mail);
    }
    public void addPoints(Klient klient,int points){
        klient.setPunkty(klient.getPunkty() + points);
    }

    public void seePickedGames(Klient klient){
        System.out.println(klient.getUwagi().get(klient.getUwagi().size()-1).getRezerwacja().getGry().size());
    }


    //ekstenjsa
    public String saveInfo() {

        return  numerIdentyfikacyjny+
                ";"+ dataUrodzenia +
                ";" + stawkaZaH +
                ";" + adresMail + '\'' +
                ";" + telefon
                ;

    }
    public static void showExtent() throws FileNotFoundException, Exception {
        PrintWriter writer=new PrintWriter(new File("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\PracownikSalonuGier.txt"));
        System.out.println("Extent of the class: " + PracownikSalonuGier.class.getName());

        for (PracownikSalonuGier pracownikSalonuGier : pracownikSalonuGierDataBase) {
            System.out.println(pracownikSalonuGier.toString());
            writer.write(pracownikSalonuGier.saveInfo()+"\n");
        }
        writer.close();
    }

    public static void saveExtent() throws FileNotFoundException, Exception {
        FileReader fileReader=new FileReader("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\PracownikSalonuGier.txt");
        Scanner scanner=new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            String[] valuesOfPracownik= line.split(";");

            int exist=0;

            for (int i = 0; i <pracownikSalonuGierDataBase.size() ; i++) {
                if (pracownikSalonuGierDataBase.get(i).getNumerIdentyfikacyjny() == Integer.parseInt(valuesOfPracownik[0])) {
                    System.out.println("juz istnieje");
                    exist += 1;
                }
            }
            if (exist == 0) {
                new PracownikSalonuGier(Integer.parseInt(valuesOfPracownik[0]), LocalDateTime.parse(valuesOfPracownik[1]), Integer.parseInt(valuesOfPracownik[2]), valuesOfPracownik[3], Integer.parseInt(valuesOfPracownik[4]));
            }
        }
        System.out.println(pracownikSalonuGierDataBase);
    }
}
