import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VR {

    private String model;
    private LocalDateTime data;
    private int liczbaKontrolerow;

    //listy
    List<Stanowisko> listaStanowisk=new ArrayList<>();
    static List<VR> vrDataSet=new ArrayList<>();
    List<Gra> gameList=new ArrayList<>();

    //gettery i settery
    public String getModel() {
        return model;
    }

    public LocalDateTime getData() {
        return data;
    }

    public int getLiczbaKontrolerow() {
        return liczbaKontrolerow;
    }


    public VR(String model, LocalDateTime data, int liczbaKontrolerow) {
        this.model = model;
        this.data = data;
        this.liczbaKontrolerow = liczbaKontrolerow;
        vrDataSet.add(this);
    }

    //asocjacja
    public void addStanowisko(Stanowisko stan) throws Exception {
        // Check if we have the information already
        if (!listaStanowisk.contains(stan)) {
            listaStanowisk.add(stan);

            // Add the reverse connection
            stan.addVR(this);
        }
    }
    public void addGame(Gra gra) {
        // Check if we have the information already
        if(!gameList.contains(gra)) {
            gameList.add(gra);

            // Add the reverse connection
            gra.addVr(this);
        }
    }

    @Override
    public String toString() {
        return "VR{" +
                "model='" + model + '\'' +
                ", data=" + data +
                ", liczbaKontrolerow=" + liczbaKontrolerow +
                '}';
    }

    //ekstensja
    public String saveInfo() {
        return  model +
                ";" + data +
                ";" + liczbaKontrolerow ;
    }

    public static void showExtent() throws FileNotFoundException, Exception {
        PrintWriter writer=new PrintWriter(new File("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\VR"));
        System.out.println("Extent of the class: " + VR.class.getName());

        for (VR vr : vrDataSet) {
            System.out.println(vr.toString());
            writer.write(vr.saveInfo()+"\n");
        }
        writer.close();
    }

    public static void saveExtent() throws FileNotFoundException, Exception {
        FileReader fileReader=new FileReader("C:\\Users\\Kamil\\Desktop\\PROGRAMMING\\Rok3\\2_semestr\\MAS\\s22370_MasPro\\src\\Dataset\\VR");
        Scanner scanner=new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            String[] valuesOfVR= line.split(";");


            int exist=0;

            for (int i = 0; i <vrDataSet.size() ; i++) {
                if (vrDataSet.get(i).getModel().equals(valuesOfVR[0]) && String.valueOf(vrDataSet.get(i).getData()).equals(valuesOfVR[1]) && vrDataSet.get(i).getLiczbaKontrolerow()==Integer.parseInt(valuesOfVR[2])){
                    System.out.println("juz istnieje");
                    exist+=1;
                }
            }
            if (exist==0){
                new VR(valuesOfVR[0],LocalDateTime.parse(valuesOfVR[1]),Integer.parseInt(valuesOfVR[2]));
            }
        }
        System.out.println(vrDataSet);
    }
}
