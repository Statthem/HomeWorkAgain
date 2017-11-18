package Main.Entities;

public class Skill {

    private int id;

    private String skill;

    Skill(){}

    Skill(String skill){
        this.skill = skill;

    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skill='" + skill + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    Skill(int id, String skill){
        this.id = id;

    }

}
