public class Profesor extends Client{
    private String materiePredata;

    public String getMateriePredata() {
        return materiePredata;
    }

    public void setMateriePredata(String materiePredata) {
        this.materiePredata = materiePredata;
    }

    @Override
    public String toString() {
        return "Profesor{" + "materiePredata=" + materiePredata + ", nume=" + super.getNume() + ",dataRetur=" + super.getDataRetur() + '}';
    }

}