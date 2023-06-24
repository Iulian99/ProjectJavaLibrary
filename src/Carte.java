public class Carte {
    private int codUnic;
    private String titlu;
    private String autor;
    private String gen;
    private int nrPagini;
    private String disponibilitate;

    public int getCodUnic() {
        return codUnic;
    }

    public void setCodUnic(int codUnic) {
        this.codUnic = codUnic;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getNrPagini() {
        return nrPagini;
    }

    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDisponibilitate() {
        return disponibilitate;
    }

    public void setDisponibilitate(String disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    @Override
    public String toString() {
        return "Carte{" + "codUnic=" + codUnic + ", titlu=" + titlu + ", autor=" + autor + ", gen=" + gen + ", nrPagini=" + nrPagini + ", disponibilitate=" + disponibilitate + '}';
    }


}