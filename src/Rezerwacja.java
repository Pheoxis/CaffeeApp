import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;

public class Rezerwacja {
    private LocalDateTime dataZlozenia;
    private LocalDateTime dataRozpoczecia;
    private int liczbaOsob;
    private int liczbaGodzin;
    private String sposobPlatnosci;

    private int numerRezerwacji;
    public Stanowisko stanowisko;

    private static int maxLiczbaOsob=6;
    private static int numerRezerwacji_=1;


    //listy
    private List<Gra> gry;
    private Map<Integer, Stanowisko> stanowiskoQualif=new TreeMap<>();
    private List<Rezerwacja> rezerwacje= new ArrayList<Rezerwacja>();
    private static List<Rezerwacja> rezerwacjeDataSet= new ArrayList<Rezerwacja>();
    public ArrayList<Uwagi> uwagi;
    public List<PracownikSalonuGier> pracownikSalonuGiers= new ArrayList<PracownikSalonuGier>();


    public Rezerwacja(LocalDateTime dataZlozenia, LocalDateTime dataRozpoczecia, int liczbaOsob, int liczbaGodzin, String sposobPlatnosci,Stanowisko stanowisko,List<Gra> gry) throws Exception {
        this.dataZlozenia = dataZlozenia;
        this.dataRozpoczecia = dataRozpoczecia;
        this.liczbaOsob = liczbaOsob;
        this.liczbaGodzin = liczbaGodzin;
        this.sposobPlatnosci = sposobPlatnosci;
        this.stanowisko=stanowisko;
//        this.asocPakiet=new ArrayList<>();
        this.uwagi=new ArrayList<>();
        rezerwacje.add(this);
        rezerwacjeDataSet.add(this);
        this.gry=gry;
        if (gry.size()>2){
            throw new Exception("Za dużo gier, prosze wybrać maksymalnie dwie");
        }
        this.numerRezerwacji=numerRezerwacji_;
        numerRezerwacji_++;
    }
    public Rezerwacja(LocalDateTime dataZlozenia, LocalDateTime dataRozpoczecia, int liczbaOsob, int liczbaGodzin, String sposobPlatnosci,List<Gra> gry) throws Exception {
        this.dataZlozenia = dataZlozenia;
        this.dataRozpoczecia = dataRozpoczecia;
        this.liczbaOsob = liczbaOsob;
        this.liczbaGodzin = liczbaGodzin;
        this.sposobPlatnosci = sposobPlatnosci;
        this.gry=gry;
        if (gry.size()>2){
            throw new Exception("Za dużo gier, prosze wybrać maksymalnie dwie");
        }
//        this.asocPakiet=new ArrayList<>();
        this.uwagi=new ArrayList<>();
        rezerwacje.add(this);
    }

    //gettery i settery


    public int getCena() {
        return liczbaGodzin*50 + liczbaOsob*30;
    }

    public int getCena(int a) {
        return (liczbaGodzin*50 + liczbaOsob*30)*(100-a)/100;
    }

    public LocalDateTime getDataZlozenia() {
        return dataZlozenia;
    }

    public LocalDateTime getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public static List<Rezerwacja> getRezerwacjeDataSet() {
        return rezerwacjeDataSet;
    }

    public List<PracownikSalonuGier> getPracownikSalonuGiers() {
        return pracownikSalonuGiers;
    }

    public List<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public int getNumerRezerwacji() {
        return numerRezerwacji;
    }

    public List<Gra> getGry() {
        return gry;
    }

    @Override
    public String toString() {
        return "Rezerwacja{" +
                "dataZlozenia=" + dataZlozenia +
                ", dataRozpoczecia=" + dataRozpoczecia +
                ", liczbaOsob=" + liczbaOsob +
                ", liczbaGodzin=" + liczbaGodzin +
                "sposobPlatnosci='" + sposobPlatnosci +
                " lista geir = " + getGry() +
                '}';
    }

    public void addRezQualif(Stanowisko newStan) {
        // Check if we already have the info
        if (!stanowiskoQualif.containsKey(newStan.getNumerStanowiska())) {
            stanowiskoQualif.put(newStan.getNumerStanowiska(), newStan);

            // Add the reverse connection
            newStan.addStanQualif(this);
        }
    }
    public Stanowisko findStanQualif(int nmr) throws Exception {
        // Check if we have the info
        if(!stanowiskoQualif.containsKey(nmr)) {
            throw new Exception("Unable to find a movie: " + nmr);
        }

        return stanowiskoQualif.get(nmr);
    }

    public ArrayList<Uwagi> getUwagi() {
        return uwagi;
    }

    public void addUwagi(Uwagi uwaga) throws Exception {
        this.uwagi.add(uwaga);
        if (uwagi.size() > 3) {
            throw new Exception("zbyt duzu uwag, nalezy poprawic blad");
        }

    }
    public String getSposobPlatnosci() {
        return sposobPlatnosci;
    }

    public void addPracownik(PracownikSalonuGier pracownikSalonuGier) {
        // Check if we have the information already
        if(!pracownikSalonuGiers.contains(pracownikSalonuGier)) {
            pracownikSalonuGiers.add(pracownikSalonuGier);

            // Add the reverse connection
            pracownikSalonuGier.addRezerwacja(this);
        }
    }




    //funkcjonalności
    public void sendMailSms(){
        System.out.println("Dzień dobry, \n" +
                "chcielibyśmy potiwerdzić zlozenie rezerwacji \n" +
                "numer rezerwacji to : " + this.numerRezerwacji +"\n"+
                "pozdrawiamy");
    }
    public void rateUs(){
        int year=dataRozpoczecia.getYear();
        int monthValue=dataRozpoczecia.getMonthValue();
        int day=dataRozpoczecia.getDayOfMonth();
        if (year== LocalDateTime.now().getYear() && monthValue == LocalDateTime.now().getMonthValue() &&  LocalDateTime.now().getDayOfMonth()>day)
            System.out.println("Dzień dobry, \n" +
                    "chcielibyśmy prosić o dania opini na naszej stronie \n" +
                    "link : " + "www.VRcaffee.com" +"\n"+
                    "pozdrawiamy");
    }

    //ekstensja
    public String toSave() {
        return   dataZlozenia +
                ";" + dataRozpoczecia +
                ";" + liczbaOsob +
                ";" + liczbaGodzin +
                ";" + sposobPlatnosci;
    }

    public static void showExtent() throws FileNotFoundException, Exception {
        PrintWriter writer=new PrintWriter(new File("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Rezerwacje"));
        System.out.println("Extent of the class: " + Rezerwacja.class.getName());

        for (Rezerwacja rezerwacja : rezerwacjeDataSet) {
            System.out.println(rezerwacja.toString());
            writer.write(rezerwacja.toSave()+"\n");
        }
        writer.close();
    }
    public static void saveExtent() throws FileNotFoundException, Exception {
        FileReader fileReader=new FileReader("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Rezerwacje");
        Scanner scanner=new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            String[] valuesOfRezerwacja= line.split(";");

           new Rezerwacja(LocalDateTime.parse(valuesOfRezerwacja[0]),LocalDateTime.parse(valuesOfRezerwacja[1]),Integer.parseInt(valuesOfRezerwacja[2]),Integer.parseInt(valuesOfRezerwacja[3]),valuesOfRezerwacja[4],getGames(valuesOfRezerwacja[0],valuesOfRezerwacja[1]));
        }
        System.out.println(rezerwacjeDataSet);
    }

    public static List<Gra> getGames(String reserve, String begin){
        List<Gra> help=null;
        for (int i = 0; i <rezerwacjeDataSet.size() ; i++) {
            if (String.valueOf( rezerwacjeDataSet.get(i).getDataZlozenia()).equals(reserve) && String.valueOf( rezerwacjeDataSet.get(i).getDataRozpoczecia()).equals(begin)){

                help= (List<Gra>) rezerwacjeDataSet.get(i).getGry();
                System.out.println(help);
            }
        }
        return help;
    }
}
