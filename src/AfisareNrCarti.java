public class AfisareNrCarti extends Thread{

    @Override
    public void run(){
        try{
            while(true){
                int nrCarti=Biblioteca.getInstance().numaraCarti();
                System.out.println("Numarul de carti din biblioteca: " + nrCarti);
                Thread.sleep(50000);
            }
        }catch (InterruptedException e){
            System.out.println("Thread intrerupt");
        }
    }
}