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
    private int companyId;
    private int customerId;


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
            //Добавить вызов метода addToDevelopers_Projects();

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

    private void AddToCompanies_Projects(Statement statement, int companyId, int projectId) {

        String sql = "Insert into companies_projects Values('" + companyId + "','" + projectId + "')";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void AddToCustomers_Projects(Statement statement, int customerId, int projectId) {

        String sql = "Insert into customers_projects Values('" + customerId + "','" + projectId + "')";
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


    public  void  createCompany(Statement statement){

        String company_name;
        String project_description;

        System.out.println("Введите имя компании");
        company_name = Utils.consoleReader();


        companyId = Utils.Select.getId(statement,"id","companies","companie_name",company_name);

        if (companyId == 0) {
            String insertQuery =
                    "insert into companies(companie_name)" + "Values('" + company_name + "')";
            try {
                statement.executeUpdate(insertQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            companyId = Utils.Select.getId(statement,"id","companies","companie_name",company_name);
        }

        if (b) {

            String answer = null;
            System.out.println("Хотите ли вы добавить проэкт (Yes/No) ");

            answer = Utils.consoleReaderEmpty();

            switch (answer) {
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

        }

        b = true;

    }

    public  void  createCustomer(Statement statement){

        String customer_name;


        System.out.println("Введите имя клиента");
        customer_name = Utils.consoleReader();


        customerId = Utils.Select.getId(statement,"id","customers","customer_name",customer_name);

        if (companyId == 0) {
            String insertQuery =
                    "insert into customers(customer_name)" + "Values('" + customer_name + "')";
            try {
                statement.executeUpdate(insertQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            customerId = Utils.Select.getId(statement,"id","customers","customer_name",customer_name);
        }
/*

        if (b) {

            String answer = null;
            System.out.println("Хотите ли вы добавить проэкт (Yes/No) ");

            answer = Utils.consoleReaderEmpty();

            switch (answer) {
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

        }
*/

        b = true;

    }




}
