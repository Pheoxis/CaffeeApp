import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dyzur {

    private String porannaNocna;
    private int liczbaGodzin;

    //listy
    static List<Dyzur> DyzurDataSet = new ArrayList<>();
    List<PracownikSalonuGier> pracuje=new ArrayList<>();
    List<PracujacyWlasciciel> nadzoruje=new ArrayList<>();

    public Dyzur(String porannaNocna, int liczbaGodzin) {
        this.porannaNocna = porannaNocna;
        this.liczbaGodzin = liczbaGodzin;
        DyzurDataSet.add(this);
    }

    //asocjacje
    public void addPrac(PracownikSalonuGier pracWla) {
        if (!pracuje.contains(pracWla)) {
            pracuje.add(pracWla);

            pracWla.addDyzur(this);
        }
    }

    public void addNad(PracujacyWlasciciel pracWla) throws Exception {

        if (!pracuje.isEmpty()){
            throw new Exception("nie mozna utworzyc powiazania poniewaz nie ma wtedy dyzuru");
        }else {
            if (!nadzoruje.contains(pracWla)) {
                nadzoruje.add(pracWla);

                pracWla.addNadzur(this);
            }
        }
    }

    //gettery i settery
    public List<PracownikSalonuGier> getPracuje() {
        return pracuje;
    }

    public List<PracujacyWlasciciel> getNadzoruje() {
        return nadzoruje;
    }

    public String getPorannaNocna() {
        return porannaNocna;
    }

    public int getLiczbaGodzin() {
        return liczbaGodzin;
    }

    @Override
    public String toString() {
        return "Dyzur{" +
                "porannaNocna='" + porannaNocna + '\'' +
                ", liczbaGodzin=" + liczbaGodzin +
                '}';
    }

    //ekstensja
    public String toSave() {
        return
                porannaNocna  +
                ";" + liczbaGodzin ;
    }

    public static void showExtent() throws FileNotFoundException, Exception {
        PrintWriter writer=new PrintWriter(new File("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Dyzur"));
        System.out.println("Extent of the class: " + Uwagi.class.getName());

        for (Dyzur dyzur : DyzurDataSet) {
            System.out.println(dyzur.toString());
            writer.write(dyzur.toSave()+"\n");
        }
        writer.close();
    }

    public static void saveExtent() throws FileNotFoundException, Exception {
        FileReader fileReader=new FileReader("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Dyzur");
        Scanner scanner=new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            String[] valuesOfDyzur= line.split(";");


            int exist=0;

            for (int i = 0; i <DyzurDataSet.size() ; i++) {
                if (DyzurDataSet.get(i).getPorannaNocna().equals(valuesOfDyzur[0]) && DyzurDataSet.get(i).getLiczbaGodzin()== Integer.parseInt(valuesOfDyzur[1])){
                    System.out.println("juz istnieje");
                    exist+=1;
                }
            }
            if (exist==0){
                new Dyzur(valuesOfDyzur[0],Integer.parseInt(valuesOfDyzur[1]));
            }
        }
        System.out.println(DyzurDataSet);
    }
}
