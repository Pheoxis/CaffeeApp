import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PracujacyWlasciciel extends Wlasciciel implements IPracownik{
    PracownikSalonuGier pracownikSalonuGier;
    private int liczbaZmian;

    //lista
    List<Dyzur> nadzurPracownika=new ArrayList<>();
    static List<PracujacyWlasciciel> pracujacyWlascicielDataSet=new ArrayList<>();

    public PracujacyWlasciciel(int liczbaGodzinWBiurze, String adresMail, int telefon, String nazwaDzialanosci, int liczbaZmian,PracownikSalonuGier pracownikSalonuGier) {
        super(liczbaGodzinWBiurze, adresMail=pracownikSalonuGier.getAdresMail(), telefon, nazwaDzialanosci);
        this.pracownikSalonuGier=pracownikSalonuGier;
        this.liczbaZmian=liczbaZmian;

        pracujacyWlascicielDataSet.add(this);
    }

    //funkcje
    @Override
    public void addNewGame(Gra gra) {

        System.out.println(gra.getListaGier().toString());
    }

    @Override
    public void lookAtReservation(int index) {
        System.out.println("Wgląd na rezerwacje o indexie "+ index +" "+ pracownikSalonuGier.rezerwacjas.get(pracownikSalonuGier.rezerwacjas.size()-1).getRezerwacje().get(index).toString());
    }

    @Override
    public String toString() {
        return super.toString()+ " PracujacyWlasciciel{" +
                "liczbaZmian=" + liczbaZmian +
                '}';
    }

    public String toSave() {
        return super.saveInfo() +
                "l;" + liczbaZmian
                ;
    }

    //asocjacje
    public void addNadzur(Dyzur dyzur) throws Exception {
        // Check if we have the information already

        if (pracownikSalonuGier.getListadyzurPracownika().isEmpty()){
            throw new Exception("nie mozna utworzyc powiazania poniewaz nie ma wtedy dyzuru");
        }else {
            if (!nadzurPracownika.contains(dyzur)) {
                nadzurPracownika.add(dyzur);

                // Add the reverse connection
                dyzur.addNad(this);
            }
        }
    }

    //esktencja
    public static void showExtent() throws FileNotFoundException, Exception {
        PrintWriter writer=new PrintWriter(new File("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\PracujacyWlasciciel"));
        System.out.println("Extent of the class: " + Uwagi.class.getName());

        for (PracujacyWlasciciel pracujacyWlasciciel : pracujacyWlascicielDataSet) {
            System.out.println(pracujacyWlasciciel.toString());
            writer.write(pracujacyWlasciciel.toSave()+"\n");
        }
        writer.close();
    }


}
