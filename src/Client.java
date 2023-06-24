public class Client {
    private int cod;
    private String nume;
    private int nrCarti;
    private String dataRetur;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getNrCarti() {
        return nrCarti;
    }

    public void setNrCarti(int nrCarti) {
        this.nrCarti = nrCarti;
    }

    public String getDataRetur() {
        return dataRetur;
    }

    public void setDataRetur(String dataRetur) {
        this.dataRetur = dataRetur;
    }

    @Override
    public String toString() {
        return "Client{" + "cod=" + cod + ", nume=" + nume + ", nrCarti=" + nrCarti + ", dataRetur=" + dataRetur + '}';
    }

}