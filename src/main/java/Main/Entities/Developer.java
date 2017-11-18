package Main.Entities;

public class Developer {

    private int id;

    private  String first_Name;

  private String second_Name;

    Developer(){}

   public Developer(String first_Name, String second_Name){
        this.first_Name = first_Name;
        this.second_Name = second_Name;

    }

   public Developer(int id,String first_Name,String second_Name){
        this.id = id;
        this.first_Name = first_Name;
        this.second_Name = second_Name;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", first_Name='" + first_Name + '\'' +
                ", second_Name='" + second_Name + '\'' +
                '}' + "/n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getSecond_Name() {
        return second_Name;
    }

    public void setSecond_Name(String second_Name) {
        this.second_Name = second_Name;
    }

}
