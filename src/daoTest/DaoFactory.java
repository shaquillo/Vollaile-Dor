package daoTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public DaoFactory getInstance() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return new DaoFactory("jdbc:mysql://localhost:3306/fermeVollaileDor?useTimezone=true&serverTimezone=UTC","shaq","Shaquillo@18");
    }

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url,username,password);
        connection.setAutoCommit(false);
        return connection;
    }

    public ChickDao getChickDao(){
        return new ChickDaoImp(this);
    }
}
