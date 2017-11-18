package Main.Entities;

public class Project {
    private int id;

    private String project_name;

    private String project_description;

    Project(){}

    public Project(int id, String project_name, String project_description) {
        this.id = id;
        this.project_name = project_name;
        this.project_description = project_description;
    }

    public Project(String project_name, String project_description) {

        this.project_name = project_name;
        this.project_description = project_description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", project_name='" + project_name + '\'' +
                ", project_description='" + project_description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }
}
