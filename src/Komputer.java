import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Komputer {

    private int id;
    private String modelProcesora;
    private String modelKarty;
    private String modelPlyty;

    //pomocnicze
    private static int next;

    //listy
    private List<Gra> listaGier ;
    private List<Gra> secondDatasetListaGier ;
    public static List<Komputer> extent = new ArrayList<Komputer>();
    List<Stanowisko> listaStanowisk=new ArrayList<>();

    public Komputer(int id, String modelProcesora, String modelKarty, String modelPlyty) {
        extent.add(this);
        this.id = id;
        this.modelProcesora = modelProcesora;
        this.modelKarty = modelKarty;
        this.modelPlyty = modelPlyty;

    }



    public Gra createGame(String nazwa, int minWiekGrajacego, String opisGry, Komputer komputer) throws Exception {

        secondDatasetListaGier.add(new Gra(nazwa,minWiekGrajacego,opisGry,komputer));

        return secondDatasetListaGier.get(next++);
    }

    //gettery i settery
    public int getId() {
        return id;
    }


    //asocjacje
    public void addStanowisko(Stanowisko stan) throws Exception {
        // Check if we have the information already
        if (!listaStanowisk.contains(stan)) {
            listaStanowisk.add(stan);

            // Add the reverse connection
            stan.addPC(this);
        }
    }
    public void addGame(Gra game) {
        // Check if we have the information already
        if(!listaGier.contains(game)) {
            listaGier.add(game);

            // Add the reverse connection
            game.addPc(this);
        }
    }

    @Override
    public String toString() {
        return "Komputer{" +
                "id=" + id +
                ", modelProcesora='" + modelProcesora + '\'' +
                ", modelKarty='" + modelKarty + '\'' +
                ", modelPlyty='" + modelPlyty + '\'' +
                ", listaGier=" + listaGier +
                '}';
    }

    //ekstensja
    public String saveInfo() {
        return   id +
                ";" + modelProcesora  +
                ";" + modelKarty  +
                ";" + modelPlyty
                ;
    }
    public static void showExtent() throws FileNotFoundException, Exception {
        PrintWriter writer=new PrintWriter(new File("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Komputer"));
        System.out.println("Extent of the class: " + Komputer.class.getName());

        for (Komputer komputer : extent) {
            System.out.println(komputer.toString());
            writer.write(komputer.saveInfo()+"\n");
        }
        writer.close();
    }
    public static void saveExtent() throws FileNotFoundException, Exception {
        FileReader fileReader=new FileReader("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\Komputer");
        Scanner scanner=new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            String[] valuesOfKomputer= line.split(";");

            int exist=0;

            for (int i = 0; i <extent.size() ; i++) {
                if (extent.get(i).getId() == Integer.parseInt(valuesOfKomputer[0])) {
                    System.out.println("juz istnieje");
                    exist += 1;
                }
            }
            if (exist == 0) {
                new Komputer(Integer.parseInt(valuesOfKomputer[0]), valuesOfKomputer[1], valuesOfKomputer[2], valuesOfKomputer[3]);
            }
        }
        System.out.println(extent);
    }
}
