package Main;

import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Utils {

    private static Scanner scanner = new Scanner(System.in);

    public static String readFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Файла нет");
            return null;
        }



        StringBuilder sb = new StringBuilder();

//Вытягиваем всё!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Files.lines(Paths.get(path), StandardCharsets.UTF_8).forEach(sb::append);

        return sb.toString();
    }

    public static String consoleReader() {
        String str = null;

        boolean b = true;

        while (b) {
            str = scanner.nextLine();
            if (str.trim().length() != 0) {
                b = false;
            }
        }
        return str;
    }

    public static String consoleReaderEmpty(){
       String    str = scanner.nextLine();
       return  str;
    }

    static public class Select{
        public static int getId(Statement statement, String what, String from, String Where1, String Where2, String compareTo1, String compareTo2) {
            ResultSet rs = doSelect(statement, what, from, Where1, Where2, compareTo1, compareTo2);
            int id = 0;
            try {
                if (rs.first()) {
                    id = rs.getInt("id");
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
            return id;
        }

        public static int getId(Statement statement, String what, String from, String Where, String compareTo) {
            ResultSet rs = doSelect(statement, what, from, Where, compareTo);
            int id = 0;
            try {
                if (rs.first()) {
                    id = rs.getInt("id");
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
            return id;
        }

        public static ResultSet doSelect(Statement statement, String what, String from, String Where, String compareTo) {
            ResultSet resultSet = null;
            String getSomethig =
                    "Select " + what + " from " + from + " Where " + Where + " = '" + compareTo + "'";
            try {
                resultSet = statement.executeQuery(getSomethig);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }

        public static ResultSet doSelect(Statement statement, String what, String from, String Where1, String Where2, String compareTo1, String compareTo2) {
            ResultSet resultSet = null;
            String getSomethig =
                    "Select " + what + " from " + from + " Where " + Where1 + " = " + " '" + compareTo1 + "' and " + Where2 + " =  '" + compareTo2 + "'";
            try {
                resultSet = statement.executeQuery(getSomethig);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;

        }

    }


}
