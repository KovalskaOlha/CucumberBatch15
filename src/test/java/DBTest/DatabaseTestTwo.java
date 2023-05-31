package DBTest;

import java.sql.*;

public class DatabaseTestTwo {
    public static void main(String[] args) {
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password = "syntaxhrm123";
        try {
            Connection conn= DriverManager.getConnection(url,username,password);
            System.out.println("Connection is created for batch 15");
            Statement statement = conn.createStatement();
            ResultSet rset= statement.executeQuery("select firstname, lastname, age, city " +
                    "from person where city is not null;");
            ResultSetMetaData metaData =rset.getMetaData();
            // print all the columns header value
            for(int i=1; i<=metaData.getColumnCount(); i++){
                String columnName= metaData.getColumnName(i);
                System.out.println(columnName);
            }
            //we want to loop every column and every row
            while (rset.next()){
                for (int i=1; i<=metaData.getColumnCount(); i++){
                    String value =  rset.getString(metaData.getColumnName(i));
                    System.out.println(value + " ");
                }
                //just to change the line statement added below
                System.out.println();
            }
            // result set metadata - object that contains about the result
            //info such as how many columns are there, rows, name of rows
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
