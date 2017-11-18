package Main;

import Main.CRUD.Create;

import java.io.IOException;
import java.sql.*;


public class Storage {

        private String connectionURL = "jdbc:mysql://localhost/homeworkagain";
        private String user = "root";
        private String pass = "root";

        private Connection connection;
        private Statement statement;



    public Storage() {
            try{
                   // Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(connectionURL, user, pass);
                statement = connection.createStatement();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) throws SQLException {
        Storage storage = new Storage();
        Create createOb = new Create();
     //   createOb.createDeveloper(storage.statement);
     //   createOb.createSkill(storage.statement);
        createOb.createProject(storage.statement);


      /*  try {
         //   storage.executeSqlFile("C:\\Users\\Alex\\IdeaProjects\\HomeWorkAgain\\src\\main\\resources\\dropAllTables.sql");
            //Создать все таблицы
            storage.executeSqlFile("C:\\Users\\Alex\\IdeaProjects\\HomeWorkAgain\\src\\main\\resources\\initDataBase.sql");
            //Заполнить все таблицы
            storage.executeSqlFile("C:\\Users\\Alex\\IdeaProjects\\HomeWorkAgain\\src\\main\\resources\\populateDataBase.sql");


        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        storage.connection.close();
        storage.statement.close();

    }



    public void executeSqlFile(String path) throws IOException, SQLException {

        String sql =  Utils.readFile(path);
        System.out.println(sql);

        String[] sqls = sql.split(";");
        for(int i = 0;i<sqls.length;i++){
            statement.addBatch(sqls[i]);
        }
        statement.executeBatch();
    }




}
