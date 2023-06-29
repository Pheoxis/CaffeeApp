import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Umiejetnosci {

    private PracownikSalonuGier pracownik;
    private String nazwaUmiejetnosci;
    private String opis;

    //listy
    private List<PracownikSalonuGier> pracownicy =new ArrayList<>();
    private static List<Umiejetnosci> umiejetnosciDataSet=new ArrayList<>() ;

    public Umiejetnosci(String nazwaUmiejetnosci, String opis,PracownikSalonuGier pracownik) throws Exception {
        if (opis.length()>500){
            throw new Exception("przekroczono limit liter");
        }
        this.nazwaUmiejetnosci = nazwaUmiejetnosci;
        this.opis = opis;
        this.pracownik=pracownik;
        umiejetnosciDataSet.add(this);
    }

    //gettery i settery
    public String getNazwaUmiejetnosci() {
        return nazwaUmiejetnosci;
    }

    public String getOpis() {
        return opis;
    }

    public PracownikSalonuGier getPracownik() {
        return pracownik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Umiejetnosci)) return false;
        Umiejetnosci that = (Umiejetnosci) o;
        return pracownik.equals(that.pracownik) && nazwaUmiejetnosci.equals(that.nazwaUmiejetnosci) && opis.equals(that.opis);
    }

    @Override
    public String toString() {
        return "Umiejetnosci{" +
                "pracownik=" + pracownik +
                ", nazwaUmiejetnosci='" + nazwaUmiejetnosci + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }


    //ekstensja
    public String saveInfo() {
        return
                nazwaUmiejetnosci  +
                        ";" + opis +
                        ";"+ pracownik;
    }

    public static void showExtent() throws FileNotFoundException, Exception {
    PrintWriter writer=new PrintWriter(new File("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Umiejetnosci"));
    System.out.println("Extent of the class: " + Umiejetnosci.class.getName());

    for (Umiejetnosci umiejetnosci : umiejetnosciDataSet) {
        System.out.println(umiejetnosci.toString());
        writer.write(umiejetnosci.saveInfo()+"\n");
    }
    writer.close();
}



    public static void saveExtent() throws FileNotFoundException, Exception {
        FileReader fileReader=new FileReader("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Umiejetnosci");
        Scanner scanner=new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            String[] valuesOfUmiejetnosci= line.split(";");
            valuesOfUmiejetnosci[2]=valuesOfUmiejetnosci[2].replace('}',' ').trim();
            String[] valuesofPracownik=valuesOfUmiejetnosci[2].split("=");

            int exist=0;

            for (int i = 0; i <umiejetnosciDataSet.size() ; i++) {
                if (umiejetnosciDataSet.get(i).getNazwaUmiejetnosci().equals(valuesOfUmiejetnosci[0]) && umiejetnosciDataSet.get(i).getOpis().equals(valuesOfUmiejetnosci[1]) && umiejetnosciDataSet.get(i).getPracownik().equals(getTheRightOne(Integer.parseInt(valuesofPracownik[valuesofPracownik.length-1])))){
                    System.out.println("juz istnieje");
                    exist+=1;
                    }
                }
                if (exist==0){
                new Umiejetnosci(valuesOfUmiejetnosci[0],valuesOfUmiejetnosci[1],getTheRightOne(Integer.parseInt(valuesofPracownik[valuesofPracownik.length-1])));
            }
        }
        System.out.println(umiejetnosciDataSet);
    }

    public static PracownikSalonuGier getTheRightOne(int numerIn){
        PracownikSalonuGier help = null;
        for (int i = 0; i < PracownikSalonuGier.getPracownikSalonuGierDataBase().size(); i++) {
            if (PracownikSalonuGier.getPracownikSalonuGierDataBase().get(i).getTelefon()==numerIn){
                help=PracownikSalonuGier.getPracownikSalonuGierDataBase().get(i);
            }
        }
        return help;
    }
}
