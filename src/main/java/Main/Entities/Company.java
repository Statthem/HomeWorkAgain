package Main.Entities;

public class Company {

    private int id;

    private String companie_name;

    Company(){}

    Company(String companie_name) {
        this.companie_name = companie_name;
    }
    Company(int id,String companie_name){
        this.id = id;
        this.companie_name = companie_name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companie_name='" + companie_name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanie_name() {
        return companie_name;
    }

    public void setCompanie_name(String companie_name) {
        this.companie_name = companie_name;
    }


}
