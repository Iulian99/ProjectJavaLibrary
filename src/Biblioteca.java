import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Biblioteca {
    private static Biblioteca instance;
    private List<Carte> carti = new ArrayList<>();
    private List<Client> clienti = new ArrayList<>();
    private List<String> proprietariCarte = new ArrayList<>();
    private Biblioteca(){

    }

    public static synchronized Biblioteca getInstance(){
        if(instance == null){
            instance = new Biblioteca();
        }
        return instance;
    }

    public void adaugaClient(Client c) throws NumeDejaExistentException{
        for(int i=0; i<clienti.size(); i++){
            if(clienti.get(i).getNume().equals(c.getNume())){
                throw new NumeDejaExistentException("Numele clientului exista deja!");
            }
        }
        clienti.add(c);
    }

    public void adaugaCarte(Carte c){
        if(c.getDisponibilitate().trim().length() > 0) proprietariCarte.add(c.getDisponibilitate());
        carti.add(c);
    }

    public void afiseazaClienti(){
        clienti.forEach(System.out::println);
    }

    public void afiseazaCarti(){
        carti.forEach(System.out::println);
    }

    public void afiseazaStudenti(){
        clienti.stream().filter(c -> c instanceof Student).forEach(System.out::println);
    }

    public void afiseazaCarteDupaTitlu(String titlu){
        carti.stream().filter(c -> c.getTitlu().equals(titlu)).forEach(System.out::println);
    }

    public void afiseazaCarteDupaGen(String gen){
        carti.stream().filter(c -> c.getGen().equals(gen)).forEach(x -> System.out.println(x.getTitlu()));
    }

    public void sorteazaCarti(){
        Collections.sort(carti, Comparator.comparingInt(p -> p.getNrPagini()));
        carti.forEach(System.out::println);

    }

    public String fidelCititor(){
        Client c = Collections.max(clienti, Comparator.comparingInt(p -> p.getNrCarti()));
        return c.getNume();

    }

    public void sorteazaClienti(){
        Collections.sort(clienti, (Client h1, Client h2) -> h1.getNume().compareTo(h2.getNume()));
        clienti.forEach(System.out::println);

    }

    public void afiseazaCartiDisponibile(){
        carti.stream().filter(c -> c.getDisponibilitate().trim().length()==0).forEach(System.out::println);
    }

    public int numaraCarti(){
        return carti.size();
    }

    public int verificareIstoricCarte(String titlu){
        return proprietariCarte.size();
    }

    public boolean stergeCarte(String titlu){
        for(int i=0;i<carti.size();i++){
            if(carti.get(i).getTitlu().equals(titlu)){
                carti.remove(i);
                return true;
            }

        }
        return false;
    }

    public boolean stergeClient(String nume){
        for(int i=0;i<clienti.size();i++){
            if(clienti.get(i).getNume().equals(nume)){
                clienti.remove(i);
                return true;
            }

        }
        return false;
    }

    public boolean arePenalitati(String nume) {
        LocalDate ld = LocalDate.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd/MM/yyyy");
        return clienti.stream().anyMatch(c -> c.getNume().equals(nume) && LocalDate.parse(c.getDataRetur(), f).isBefore(ld));

    }

    public String imprumutaCarte(int cod) throws CarteIndisponibilaException {
        int nrap = 0;
        String numeClient = "";
        for(int i = 0; i < carti.size(); i++){
            if(carti.get(i).getCodUnic() == (cod)){


                if(carti.get(i).getDisponibilitate().trim().length() > 0) throw new CarteIndisponibilaException("Cartea nu este disponibila!");
                nrap ++;

            }
        }

        if(nrap > 0) {
            String codClient = "";
            LocalDate localDate = LocalDate.now();//For reference
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String formattedString = localDate.format(formatter);
            for(int i=0; i<clienti.size();i++){
                if(clienti.get(i).getDataRetur().trim().length() == 0 ){
                    clienti.get(i).setDataRetur(formattedString);
                    numeClient = clienti.get(i).getNume();
                    codClient = String.valueOf(clienti.get(i).getCod());
                }
            }

            for(int i = 0; i < carti.size(); i++){
                if(carti.get(i).getCodUnic() == (cod)){
                    carti.get(i).setDisponibilitate(codClient);

                }
            }
            return numeClient;
        } else {
            throw new CarteIndisponibilaException("Cartea nu exista!");
        }

    }

    public String returneazaCarte(int cod) throws CarteIndisponibilaException {
        int nrap = 0;
        String numeCarte = "";

        for(int i = 0; i < carti.size(); i++){
            if(carti.get(i).getCodUnic() == (cod)){
                numeCarte = carti.get(i).getTitlu();
                carti.get(i).setDisponibilitate("");

            }
        }
        return numeCarte;


    }
}