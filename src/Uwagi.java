import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uwagi {

    private String uwagi;
    private Rezerwacja rezerwacja;
    private  Klient klient;

    //listy
    List<Uwagi> listaUwag=new ArrayList<>();
    static List<Uwagi> listaUwagDataSet=new ArrayList<>();

    public Uwagi(String uwagi, Rezerwacja rezerwacja, Klient klient) throws Exception {

        if (uwagi.length()>500){
            throw new Exception("przekroczono limit liter");
        }
        this.uwagi = uwagi;
        this.rezerwacja = rezerwacja;
        this.klient = klient;
        addUwaga();
        listaUwag.add(this);
        listaUwagDataSet.add(this);
    }
    private void addUwaga() throws Exception {
        this.rezerwacja.addUwagi(this);
        this.klient.addUwagi(this);
    }

    //gettery i settery
    public String getUwagi() {
        return uwagi;
    }

    public Rezerwacja getRezerwacja() {
        return rezerwacja;
    }

    public List<Uwagi> getListaUwag() {
        return listaUwag;
    }

    public Klient getKlient() {
        return klient;
    }

    @Override
    public String toString() {
        return "Uwagi{" +
                "uwagi='" + uwagi + '\'' +
                ", rezerwacja=" + rezerwacja +
                ", klient=" + klient +
                '}';
    }

    //ekstensja
    public String toSave() {
        return  uwagi  +
                ";" + rezerwacja +
                ";" + klient;
    }

    public static void showExtent() throws FileNotFoundException, Exception {
        PrintWriter writer=new PrintWriter(new File("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Uwagi"));
        System.out.println("Extent of the class: " + Uwagi.class.getName());

        for (Uwagi uwaga : listaUwagDataSet) {
            System.out.println(uwaga.toString());
            writer.write(uwaga.toSave()+"\n");
        }
        writer.close();
    }
    public static void saveExtent() throws FileNotFoundException, Exception {
        FileReader fileReader=new FileReader("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Uwagi");
        Scanner scanner=new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            String[] valuesOfUwagi= line.split(";");

            int exist=0;

            for (int i = 0; i <listaUwagDataSet.size() ; i++) {
                if (listaUwagDataSet.get(i).getUwagi().equals(valuesOfUwagi[0])) {
                    System.out.println("juz istnieje");
                    exist += 1;
                }
            }
            if (exist == 0) {
                new Uwagi(valuesOfUwagi[0],getRez(valuesOfUwagi[0]), getKli(valuesOfUwagi[0]));
            }
        }
        System.out.println(listaUwagDataSet);
    }

    public static Rezerwacja getRez(String details){
        Rezerwacja help=null;
        for (int i = 0; i < listaUwagDataSet.size(); i++) {
            if (listaUwagDataSet.get(i).getUwagi().equals(details)){
                help=listaUwagDataSet.get(i).getRezerwacja();
            }
        }
        return help;
    }

    public static Klient getKli(String details){
        Klient help=null;
        for (int i = 0; i < listaUwagDataSet.size(); i++) {
            if (listaUwagDataSet.get(i).getUwagi().equals(details)){
                help=listaUwagDataSet.get(i).getKlient();
            }
        }
        return help;
    }
}
