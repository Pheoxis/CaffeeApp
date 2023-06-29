import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        //Wlasciciel
        Wlasciciel wlasciciel = new Wlasciciel(6,"WlascicielToJa@gmail.com",253467215,"ITstandard");
        //Pracownik
        PracownikSalonuGier Seba=new PracownikSalonuGier(1,LocalDateTime.of(2008, 05, 25, 12, 45),30,"Tymon@gmail.copm",536137953);
        PracownikSalonuGier Andrzej=new PracownikSalonuGier(8,LocalDateTime.of(2001, 05, 25, 12, 45),30,"Andri@gmail.copm",457904367);
        PracownikSalonuGier Stefan=new PracownikSalonuGier(12,LocalDateTime.of(2004, 05, 25, 12, 45),30,"Aneta@gmail.copm",352345729);
        //Umiejetnosc
        Umiejetnosci gotowanie=new Umiejetnosci("gotowanie","potrafi gotowac",Andrzej);
        //Klient
        KlientPrywatny Kamil = new KlientPrywatny(18, List.of("Kamilccc2001@gmail.com", "teleskop@gmail.com"), 535444555,true);//Atrybut powtarzalny i opcjonalny
        KlientPrywatny Antek = new KlientPrywatny(21, List.of("Trener@gmail.com"),453435215,4);// przeciążenie metody
        KlientFirma Partyzant = new KlientFirma(44,List.of("trer@asfa.com","asfasf@gmail.com"),123456789,2,"Partyzant",323423435);
        //Stanowisko
        Stanowisko numer1=new Stanowisko(2,8,50 );
        //Komputer
        Komputer pc= new Komputer(2,"nvidia","RTX","Intel");
        //VR
        VR vr=new VR("applePro",LocalDateTime.of(20023, 8, 25, 12, 45),2);
        //Gra
        Gra pantera=new Gra("Pantera",12,"krotka fajna i przyjemna",pc);
        Gra komiks=new Gra("komiks",2,"krotka fajna i przyjemna",pc);
        Gra gizmo=new Gra("gizmo",3,"krotka fajna i przyjemna",pc);
        //Rezerwacje
        Rezerwacja AntekRezerwacja = new Rezerwacja(LocalDateTime.of(2023, 01, 23, 12, 45),//Atrybut złożony
                LocalDateTime.of(2023, 07, 23, 16, 00),
                5, 6, "Karta",numer1,List.of(pantera,komiks));
        Rezerwacja niezapowiedziana=new Rezerwacja(LocalDateTime.of(2023, 06, 15, 12, 45),
                LocalDateTime.of(2024, 8, 14, 15, 00),
                5, 6, "Karta",numer1,List.of(pantera,komiks));
        Rezerwacja KamilRezerwacja = new Rezerwacja(LocalDateTime.of(2023, 01, 23, 12, 45),
                LocalDateTime.of(2022, 02, 23, 12, 00),
                4, 6, "Karta",numer1,List.of(pantera,gizmo));
        //Uwagi
        Uwagi uwaga =new Uwagi("bardzo slabe zachowanie",KamilRezerwacja,Kamil);
        //Dyzur
        Dyzur dyzur1=new Dyzur("rano",5);
        Dyzur dyzur2=new Dyzur("rano",6);
        //PracującyWlasciciel
        PracujacyWlasciciel Tymon=new PracujacyWlasciciel(5,"manekin@gmail.com",234233456,"Gastronomia",4,Stefan);

        //asocjacje
        Seba.addRezerwacja(KamilRezerwacja);
        Seba.addRezerwacja(niezapowiedziana);

        Andrzej.addRezerwacja(niezapowiedziana);
        Andrzej.addRezerwacja(AntekRezerwacja);

        Stefan.addRezerwacja(KamilRezerwacja);

//MP1
        {
            //Ekstensja
//            Klient.showExtent();
            //trwałość
//            Klient.saveExtent();
            //Atr.pochodny
//            AntekRezerwacja.getCena();
        }
//MP2
        {
            //Zwykla
//           KamilRezerwacja.addPracownik(Stefan);
            //atrybutem
//           Uwagi uwagaDlaRez=new Uwagi("nie udało się opłacić rezerwacjci",niezapowiedziana,Antek);
 //           System.out.println(KamilRezerwacja.getUwagi().toString());
 //           System.out.println(Kamil.getUwagi().toString());

            //aggravated
//            KamilRezerwacja.addRezQualif(numer1);
//            KamilRezerwacja.findStanQualif(2);
//            System.out.println(KamilRezerwacja.getStanowiskoQualif().toString());

            //kompozycja
//            Umiejetnosci liczenie = new Umiejetnosci("liczenie","liczenie za pomocą Excela",Seba);
//            Seba.dodajUmiejetnosc(liczenie);
        }

//MP3
        {
            //polimorficzne wołanie metod
//            Kamil.updateKlient("wiek","22");
            //Wielodziedziczenie
            KlientPrywatny smakosz=new KlientPrywatny(18, List.of("smakosz@gmail.com"), 355226745,true);
            KlientPrywatny smakosz2=new KlientPrywatny(33, List.of("smakosz2@gmail.com"), 355226745,56);
            //Wieloaspektowe
//                Tymon.showListOfGames();
//               System.out.println(Tymon.getNazwaDzialanosci());
            //Dynamiczne
//            Klient k1=new KlientPrywatny(23,List.of("fernando@gmai.com"),344333221,true);
//            System.out.println(k1);
//            k1=new KlientFirma(k1,"Nemesis22",23);
//            System.out.println(k1);
        }

//MP4
        {
            //atrybut
//           Klient Kornel = new KlientPrywatny(18, List.of("malyStefan@gmail.com"), 336677889, true);
            //unique
//          PracownikSalonuGier Aneta2=new PracownikSalonuGier(12,LocalDateTime.of(2001, 05, 25, 12, 45),30,"Antek@gmail.copm",535434333);
            //subset
            //       Aneta.addDyzur(dyzur1);

//        System.out.println(Aneta.getDyzurPracownika());
//        System.out.println(Tymon.getDyzurPracownika().toString());
//        System.out.println(dyzur1.getPracuje().toString());
//        //System.out.println(dyzur1.getPracuje().isEmpty());
            //Tymon.addNadzur(dyzur2);
            //ordered
            //    Aneta.addDyzur(dyzur2);
            //bag
//        Uwagi uwaga1=new Uwagi("blad wczytywania",KamilRezerwacja,Kamil);
//        Uwagi uwaga2=new Uwagi("nie poprawne parametry",KamilRezerwacja,Kamil);

            //wlasne
//       Uwagi uwaga4=new Uwagi("bledy zapisu",KamilRezerwacja,Kamil);

            //XOR
            //       numer1.addPC(pc);
//        numer1.addVR(vr);
        }



        int help=0;
        GUILogin frame = new GUILogin();
        frame.setVisible(true);
//        while(true) {
//            synchronized (frame) {
//                System.out.println("wait a minute");
//                try {
//                    frame.wait(30000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println(GUILiczbaOsob.getLiczbaOsob().get(GUILiczbaOsob.getLiczbaOsob().size() - 1));
//
//            AntekRezerwacja.getRezerwacje().add( new Rezerwacja(LocalDateTime.now(), GUITerminy.getTime().get(GUITerminy.getTime().size() - 1), GUILiczbaOsob.getLiczbaOsob().get(GUILiczbaOsob.getLiczbaOsob().size() - 1), GUITerminy.getHowLong().get(GUITerminy.getHowLong().size() - 1), "Gotowka", numer1, GUIDostepneGry.getGameList()));
//
//            uwaga.getListaUwag().add( new Uwagi(GUIZnizka.getUwagi().get(GUIZnizka.getUwagi().size() - 1), AntekRezerwacja.getRezerwacje().get(AntekRezerwacja.getRezerwacje().size() - 1), GUILogin.getKlientsList().get(GUILogin.getKlientsList().size() - 1)));
//            AntekRezerwacja.getRezerwacje().get(AntekRezerwacja.getRezerwacje().size() - 1).addRezQualif(numer1);
//
//
//            System.out.println(uwaga.getListaUwag().get(uwaga.getListaUwag().size() - 1));
//
//        }

    }
}
