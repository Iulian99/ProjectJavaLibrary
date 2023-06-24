public class Student extends Client{
    private String facultate;
    private String anStudiu;

    public String getFacultate() {
        return facultate;
    }

    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }

    public String getAnStudiu() {
        return anStudiu;
    }

    public void setAnStudiu(String anStudiu) {
        this.anStudiu = anStudiu;
    }

    @Override
    public String toString() {
        return "Student{" + "facultate=" + facultate + ", anStudiu=" + anStudiu + ", nume=" + super.getNume() + ",dataRetur=" + super.getDataRetur() + "}";
    }

}