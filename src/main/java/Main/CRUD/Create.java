package Main.CRUD;


import Main.Entities.Developer;
import Main.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

    private boolean b = true;

    private int DeveloperId;
    private int skillId;
    private int projectId;

    public void createDeveloper(Statement statement) {
        String first_name;

        String second_name;

        System.out.println("Введите имя");
        first_name = Utils.consoleReader();

        System.out.println("Введите фамилию");
        second_name = Utils.consoleReader();

         DeveloperId = Utils.Select.getId(statement, "id", "developers", "FIRST_NAME", "SECOND_NAME", first_name, second_name);

        if (DeveloperId == 0) {
            String insertQuery =
                    "insert into developers(FIRST_NAME,SECOND_NAME)" + "Values('" + first_name + "', '" + second_name + "')";

            try {
                statement.executeUpdate(insertQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DeveloperId = Utils.Select.getId(statement, "id", "developers", "FIRST_NAME", "SECOND_NAME", first_name, second_name);
        }
        if (b) {

            String answerSkill = null;
            System.out.println("Хотите ли вы добавить скилл  (Yes/No) ");

            answerSkill = Utils.consoleReaderEmpty();

            switch (answerSkill) {
                case "Yes":
                    b = false;
                    createSkill(statement);
                    break;
                case "yes":
                    b = false;
                    createSkill(statement);
                    break;

            }

            String answerProject = null;
            System.out.println("Хотите ли вы добавить Проэкт  (Yes/No) ");

            answerProject = Utils.consoleReaderEmpty();

            switch (answerProject) {
                case "Yes":
                    b = false;
                    createProject(statement);
                    break;
                case "yes":
                    b = false;
                    createProject(statement);
                    break;

            }

        } else {
            AddToDeveloper_Skill(statement,DeveloperId,skillId);
        }

        b = true;
    }


    public void createSkill(Statement statement) {

        String skill;

        System.out.println("Введите скилл");
        skill = Utils.consoleReader();

         skillId = Utils.Select.getId(statement, "id", "skills", "skill", skill);

        if (skillId == 0) {
            String insertQuery =
                    "insert into skills(skill)" + "Values('" + skill + "')";
            try {
                statement.executeUpdate(insertQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            skillId = Utils.Select.getId(statement, "id", "skills", "skill", skill);

        }

        if (b) {

            String answer = null;
            System.out.println("Хотите ли вы добавить разработчика (Yes/No) ");

            answer = Utils.consoleReaderEmpty();

            switch (answer) {
                case "Yes":
                    b = false;
                    createDeveloper(statement);
                    break;
                case "yes":
                    b = false;
                    createDeveloper(statement);
                    break;

            }

        }
    else {
            AddToDeveloper_Skill(statement,DeveloperId,skillId);
    }

        b = true;


    }


    private void AddToDeveloper_Skill(Statement statement, int DeveloperId, int SkillId) {

        String sql = "Insert into developers_skills Values('" + DeveloperId + "','" + SkillId + "')";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void AddToDevelopers_Projects(Statement statement, int DeveloperId, int ProjectId) {

        String sql = "Insert into developers_projects Values('" + DeveloperId + "','" + ProjectId + "')";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public  void  createProject(Statement statement){

        String project_name;
        String project_description;

        System.out.println("Введите название проэкта");
        project_name = Utils.consoleReader();

        System.out.println("Введите описание");
        project_description = Utils.consoleReader();

        projectId = Utils.Select.getId(statement,"id","projects","project_name","project_description",project_name,project_description);

        if (projectId == 0) {
            String insertQuery =
                    "insert into projects(project_name,project_description)" + "Values('" + project_name + "', '" + project_description + "')";
            try {
                statement.executeUpdate(insertQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            projectId = Utils.Select.getId(statement, "id", "projects", "project_name", "project_description", project_name, project_description);
        }

        if (b) {

            String answer = null;
            System.out.println("Хотите ли вы добавить разраюотчика (Yes/No) ");

            answer = Utils.consoleReaderEmpty();

            switch (answer) {
                case "Yes":
                    b = false;
                    createDeveloper(statement);
                    break;
                case "yes":
                    b = false;
                    createDeveloper(statement);
                    break;

            }

        } else {
            AddToDeveloper_Skill(statement,DeveloperId,projectId);
        }

        b = true;

    }







}
