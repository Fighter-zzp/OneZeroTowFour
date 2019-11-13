import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class m1 {
    static final String classname="com.mysql.cj.jdbc.Driver";
    static final String url="jdbc:mysql://localhost:3306/mybatis?useSSL=false&serverTimezone=UTC";
    static final String u="root";
    static final  String p="root";

    public static void main(String[] args) throws SQLException, IOException {
        FileInputStream fileInputStream = new FileInputStream("db.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String property = properties.getProperty("");
        System.out.println(property);
    /*    HikariConfig hikariConfig = new HikariConfig("db.properties");
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        Connection connection1 = hikariDataSource.getConnection();
        System.out.println(connection1);*/
    }
}
