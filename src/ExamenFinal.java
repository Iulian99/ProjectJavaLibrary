import java.util.*;

public class ExamenFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CarteIndisponibilaException, NumeDejaExistentException {
        Scanner sc = new Scanner(System.in);
        new AfisareNrCarti().start(); //bonus 1
        while (true){
            System.out.println("Comanda: ");
            String cmd=sc.nextLine();
            String [] cuv = cmd.split(" ");

            switch(cuv[0]){
                case "exit":    System.out.println("Aplicatia se inchide"); //18
                    System.exit(0);
                case "adaugaStudent":{ //1
                    Student stud=new Student();
                    stud.setCod(Integer.parseInt(cuv[1]));
                    stud.setNume(cuv[2]);
                    stud.setNrCarti(Integer.parseInt(cuv[3]));
                    stud.setDataRetur(cuv[4]);
                    stud.setFacultate(cuv[5]);
                    stud.setAnStudiu(cuv[6]);
                    Biblioteca.getInstance().adaugaClient(stud);
                    System.out.println("A fost adaugat studentul");
                }break;
                case "adaugaProfesor":{ //2
                    Profesor prof=new Profesor();
                    prof.setCod(Integer.parseInt(cuv[1]));
                    prof.setNume(cuv[2]);
                    prof.setNrCarti(Integer.parseInt(cuv[3]));
                    prof.setDataRetur(cuv[4]);
                    prof.setMateriePredata(cuv[5]);
                    Biblioteca.getInstance().adaugaClient(prof);
                    System.out.println("A fost adaugat profesorul");
                }break;
                case "afiseazaClienti":{//3
                    Biblioteca.getInstance().afiseazaClienti();
                }break;
                case "afiseazaStudenti":{//4
                    Biblioteca.getInstance().afiseazaStudenti();
                }break;
                case "adaugaCarte":{ //5
                    Carte carte=new Carte();
                    carte.setCodUnic(Integer.parseInt(cuv[1]));
                    carte.setTitlu(cuv[2]);
                    carte.setAutor(cuv[3]);
                    carte.setGen(cuv[4]);
                    carte.setNrPagini(Integer.parseInt(cuv[5]));
                    carte.setDisponibilitate(cuv.length > 6 ? cuv[6] : "");
                    Biblioteca.getInstance().adaugaCarte(carte);
                    System.out.println("A fost adaugat cartea");
                }break;
                case "afiseazaCarti":{ //6
                    Biblioteca.getInstance().afiseazaCarti();
                }break;
                case "afiseazaCartiDisponibile":{ //7
                    Biblioteca.getInstance().afiseazaCartiDisponibile();
                }break;
                case "cautaCarte":{ //8
                    String titlu = cuv[1];
                    Biblioteca.getInstance().afiseazaCarteDupaTitlu(titlu);
                }break;
                case "filtreazaCartiDupaGen":{ //9
                    String gen = cuv[1];
                    Biblioteca.getInstance().afiseazaCarteDupaGen(gen);
                }break;
                case "sorteazaCarti":{ //10
                    Biblioteca.getInstance().sorteazaCarti();
                }break;
                case "sorteazaClienti":{ //11
                    Biblioteca.getInstance().sorteazaClienti();
                }break;
                case "celMaiFidelCititor":{ //12

                    System.out.println("Cel mai fidel cititor este: " + Biblioteca.getInstance().fidelCititor());
                }break;
                case "stergeCarte":{ //15
                    boolean res=Biblioteca.getInstance().stergeCarte(cuv[1]);
                    if(res){
                        System.out.println("A fost stearsa cartea: "+ cuv[1]);
                    }else{
                        System.out.println("Cartea " +cuv[1]+ " nu exista" );
                    }
                }break;
                case "stergeClient":{ //16
                    boolean res=Biblioteca.getInstance().stergeClient(cuv[1]);
                    if(res){
                        System.out.println("A fost sters clientul: "+ cuv[1]);
                    }else{
                        System.out.println("Clientul " +cuv[1]+ " nu exista" );
                    }
                }break;
                case "arePenalitati":{ //17
                    boolean res=Biblioteca.getInstance().arePenalitati(cuv[1]);
                    if(res){
                        System.out.println("Clientul " +cuv[1]+ " are penalitati");
                    }else{
                        System.out.println("Clientul " +cuv[1]+ " nu are penalitati" );
                    }
                }break;
                case "imprumutaCarte":{ //13
                    String res=Biblioteca.getInstance().imprumutaCarte(Integer.parseInt(cuv[1]));
                    if(res.trim().length() > 0){
                        System.out.println("Clientul " + res + " a imprumutat cartea");
                    }else{
                        System.out.println("Nu a putut fii imprumutata cartea" );
                    }
                }break;
                case "returneazaCarte":{
                    String res=Biblioteca.getInstance().returneazaCarte(Integer.parseInt(cuv[1]));
                    if(res.trim().length() > 0){
                        System.out.println("Cartea " + res + " a fost returnata");
                    }
                }break;
                case "verificareIstoricCarte":{ //bonus 2
                    int res=Biblioteca.getInstance().verificareIstoricCarte(cuv[1]);
                    System.out.println("Cartea " + cuv[1] + " a fost imprumutata de " + res + " ori");
                }break;
                default:
                    System.out.println("Nu exista acea comanda");


            }
        }
    }

}
