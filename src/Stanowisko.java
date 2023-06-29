import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Stanowisko {

    private int numerStanowiska;
    private int maksLiczbaNaStanowsiku;
    private int cenaWynajęciaZaH;

    //listy
    public static List<Stanowisko> extent = new ArrayList<Stanowisko>();
    public static List<Stanowisko> stanowiskoDataset = new ArrayList<Stanowisko>();
    public static List<VR> listaVR = new ArrayList<VR>();
    public static List<Komputer> listaKomputerow = new ArrayList<Komputer>();
    public List<Rezerwacja> rezerwacjas=new ArrayList<>();


    public Stanowisko(int numerStanowiska, int maksLiczbaNaStanowsiku, int cenaWynajęciaZaH) {
        this.numerStanowiska = numerStanowiska;
        this.maksLiczbaNaStanowsiku = maksLiczbaNaStanowsiku;
        this.cenaWynajęciaZaH = cenaWynajęciaZaH;
        extent.add(this);
        stanowiskoDataset.add(this);
    }

    //gettery i settery
    public int getNumerStanowiska() {
        return numerStanowiska;
    }


    //asocjacje
    public static Stanowisko findStanowisko(int id) throws Exception {
        for(Stanowisko stanowisko : extent) {
            if(stanowisko.numerStanowiska == id) {
                return stanowisko;
            }
        }

        throw new Exception("Unable to find a Stanowisko with the id = " + id);
    }

    public void addStanQualif(Rezerwacja newStan) {
        // Check if we already have the info
        if (!rezerwacjas.contains(newStan)) {
            rezerwacjas.add(newStan);

            // Add the reverse connection
            newStan.addRezQualif(this);
        }
    }

    public void addVR(VR vr) throws Exception {
        if (listaKomputerow.size()>0){
            throw new Exception("estencja wystepuje juz gzie indziej");
        }
        if (!listaVR.contains(vr)) {
            listaVR.add(vr);

            // Add the reverse connection
            vr.addStanowisko(this);
        }
    }

    public void addPC(Komputer pc) throws Exception {
        // Check if we have the information already
        if (listaVR.size()>0){
            throw new Exception("estencja wystepuje juz gzie indziej");
        }
        if (!listaKomputerow.contains(pc)) {
            listaKomputerow.add(pc);

            // Add the reverse connection
            pc.addStanowisko(this);
        }
    }
    @Override
    public String toString() {
        return "Stanowisko{" +
                "numerStanowiska=" + numerStanowiska +
                ", maksLiczbaNaStanowsiku=" + maksLiczbaNaStanowsiku +
                ", cenaWynajęciaZaH=" + cenaWynajęciaZaH +
//                ", KomputerIds=" + Arrays.toString(KomputerIds) +
                ", rezerwacjas=" + rezerwacjas +
                '}';
    }
    //ekstensja
    public String saveinfo() {
        return  numerStanowiska +
                ";" + maksLiczbaNaStanowsiku +
                ";" + cenaWynajęciaZaH ;

    }

    public static void showExtent() throws FileNotFoundException, Exception {
        PrintWriter writer=new PrintWriter(new File("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Stanowisko"));
        System.out.println("Extent of the class: " + Stanowisko.class.getName());

        for (Stanowisko stanowisko : stanowiskoDataset) {
            System.out.println(stanowisko.toString());
            writer.write(stanowisko.saveinfo()+"\n");
        }
        writer.close();
    }

    public static void saveExtent() throws FileNotFoundException, Exception {
        FileReader fileReader=new FileReader("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Stanowisko");
        Scanner scanner=new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            String[] valuesOfStanowusko= line.split(";");

            int exist=0;

            for (int i = 0; i <stanowiskoDataset.size() ; i++) {
                if (stanowiskoDataset.get(i).getNumerStanowiska() == Integer.parseInt(valuesOfStanowusko[0])) {
                    System.out.println("juz istnieje");
                    exist += 1;
                }
            }
            if (exist == 0) {
                new Stanowisko(Integer.parseInt(valuesOfStanowusko[0]), Integer.parseInt(valuesOfStanowusko[1]), Integer.parseInt(valuesOfStanowusko[2]));
            }
        }
        System.out.println(extent);
    }
}
