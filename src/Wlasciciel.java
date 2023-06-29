import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wlasciciel{

    private String nazwaDzialanosci;
    private int liczbaGodzinWBiurze;
    private String adresMail;
    private int telefon;

    //listy
    private static List<Wlasciciel> wlascicielDataset=new ArrayList<>();

    public Wlasciciel(int liczbaGodzinWBiurze, String adresMail, int telefon,String nazwaDzialanosci) {
        this.liczbaGodzinWBiurze=liczbaGodzinWBiurze;
        this.adresMail=adresMail;
        this.telefon=telefon;
        this.nazwaDzialanosci=nazwaDzialanosci;
        wlascicielDataset.add(this);
    }

    //gettery i settery
    public String getNazwaDzialanosci() {
        return nazwaDzialanosci;
    }

    public int getLiczbaGodzinWBiurze() {
        return liczbaGodzinWBiurze;
    }

    public String getAdresMail() {
        return adresMail;
    }

    public int getTelefon() {
        return telefon;
    }

    @Override
    public String toString() {
        return "Wlasciciel{" +
                "nazwaDzialanosci='" + nazwaDzialanosci + '\'' +
                ", liczbaGodzinWBiurze=" + liczbaGodzinWBiurze +
                ", adresMail='" + adresMail + '\'' +
                ", telefon=" + telefon +
                '}';
    }

    //funkcjonalnsci
    public void setZmienStawkeZaHPracy(PracownikSalonuGier pracownikSalonuGier,int kwota){
        pracownikSalonuGier.setStawkaZaH(kwota);
    }
    public void showListOfGames(){
        System.out.println(Gra.listaGier);
    }

    public void LookAtClientData(Klient klient){
        System.out.println(klient);
    }

    //ekstensja
    public String saveInfo() {
        return  liczbaGodzinWBiurze +
                ";" + adresMail  +
                ";" + telefon+
                ";" + nazwaDzialanosci
                ;
    }

    public static void showExtent() throws FileNotFoundException, Exception {
        PrintWriter writer=new PrintWriter(new File("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Wlasciciel"));
        System.out.println("Extent of the class: " + Wlasciciel.class.getName());

        for (Wlasciciel wlasciciel : wlascicielDataset) {
            System.out.println(wlasciciel.toString());
            writer.write(wlasciciel.saveInfo()+"\n");
        }
        writer.close();
    }
    public static void saveExtent() throws FileNotFoundException, Exception {
        FileReader fileReader=new FileReader("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Wlasciciel");
        Scanner scanner=new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            String[] valuesOfWlasciciel= line.split(";");

            int exist=0;

            for (int i = 0; i <wlascicielDataset.size() ; i++) {
                if (wlascicielDataset.get(i).getLiczbaGodzinWBiurze()==Integer.parseInt(valuesOfWlasciciel[0]) && wlascicielDataset.get(i).getAdresMail().equals(valuesOfWlasciciel[1]) && wlascicielDataset.get(i).getTelefon()==Integer.parseInt(valuesOfWlasciciel[2]) && wlascicielDataset.get(i).getNazwaDzialanosci().equals(valuesOfWlasciciel[3])){
                    System.out.println("juz istnieje");
                    exist+=1;
                }
            }
            if (exist==0){
                new Wlasciciel(Integer.parseInt(valuesOfWlasciciel[0]),valuesOfWlasciciel[1],Integer.parseInt(valuesOfWlasciciel[2]),valuesOfWlasciciel[3]);
            }
        }
        System.out.println(wlascicielDataset);
    }
}
