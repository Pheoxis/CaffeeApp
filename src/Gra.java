import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Gra {

    private String nazwa;
    private int minWiekGrajacego;
    private String opisGry;
    private Komputer komputer;
    //listy
    public static List<Gra> listaGier=new ArrayList<Gra>();
    public static List<Gra> listaGierGui=new ArrayList<Gra>();
    private  List<Komputer> belongsTo=new ArrayList<Komputer>();
    private  List<VR> appliedTo=new ArrayList<VR>();

    public Gra(String nazwa, int minWiekGrajacego, String opisGry,Komputer komputer) throws Exception {
        if (opisGry.length()>=1000){
            throw new Exception("opis gry zbyt dlugi nikt nie bedzie czytac");
        }
        this.nazwa = nazwa;
        this.minWiekGrajacego = minWiekGrajacego;
        this.opisGry = opisGry;
        this.komputer=komputer;

        listaGier.add(this);
        listaGierGui.add(this);
    }

    //gettery settery
    public String getNazwa() {
        return nazwa;
    }

    public List<Gra> getListaGier() {
        return listaGier;
    }

    public void setListaGier(List<Gra> listaGier) {
        this.listaGier = listaGier;
    }

    public static List<Gra> getListaGierGui() {
        return listaGierGui;
    }

    @Override
    public String toString() {
        return "Gra{" +
                "nazwa='" + nazwa + '\'' +
                ", minWiekGrajacego=" + minWiekGrajacego +
                ", opisGry='" + opisGry + '\'' +
                '}';
    }

    //asocjacje
    public void addPc(Komputer pc) {
        // Check if we have the information already
        if(!belongsTo.contains(pc)) {
            belongsTo.add(pc);

            // Add the reverse connection
            pc.addGame(this);
        }
    }
    public void addVr(VR vr) {
        // Check if we have the information already
        if(!appliedTo.contains(vr)) {
            appliedTo.add(vr);

            // Add the reverse connection
            vr.addGame(this);
        }
    }



    public void showListOfGames(){
        System.out.println(listaGier);
    }

   //ekstensje
    public String saveInfo() {
        return
                nazwa  +
                        ";" + minWiekGrajacego +
                        ";" + opisGry +
                        ";" + komputer;
    }

    public static void showExtent() throws FileNotFoundException, Exception {
        PrintWriter writer=new PrintWriter(new File("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Gry"));
        System.out.println("Extent of the class: " + Gra.class.getName());

        for (Gra gra : listaGierGui) {
            System.out.println(gra.toString());
            writer.write(gra.saveInfo()+"\n");
        }
        writer.close();
    }

    public static void saveExtent() throws FileNotFoundException, Exception {
        FileReader fileReader=new FileReader("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Gry");
        Scanner scanner=new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            String[] valuesOfGra= line.split(";");
            valuesOfGra[3]=valuesOfGra[3].replace('{',' ').trim();
            String[]valuesOfPc=valuesOfGra[3].split(",");
            String[]valueOfId=valuesOfPc[0].split("=");

            int exist=0;

            for (int i = 0; i <listaGier.size() ; i++) {
                if (listaGier.get(i).getNazwa().equals(valuesOfGra[0])) {
                    System.out.println("juz istnieje");
                    exist += 1;
                }
            }
            if (exist == 0) {
                new Gra(valuesOfGra[0],Integer.parseInt(valuesOfGra[1]), valuesOfGra[2],getTheRightOne(Integer.parseInt(valueOfId[1])));
            }
        }
        System.out.println(listaGier);
    }
    public static Komputer getTheRightOne(int numerIn){
        Komputer help = null;
        for (int i = 0; i < Komputer.extent.size(); i++) {
            if (Komputer.extent.get(i).getId()==numerIn){
                help=Komputer.extent.get(i);
            }
        }
        return help;
    }
}
