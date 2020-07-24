package daoTest;

import model.ChickClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ChickDaoImp implements ChickDao {
    public DaoFactory daoFactory;

    ChickDaoImp(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    @Override
    public List<ChickClass> chickList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Poussin;");
            // then continue ...
            //connection.commit();
        } catch (SQLException e) {
            try{
                 if(connection != null){
                     connection.rollback();
                     }
               } catch(SQLException ex){
               }
               System.out.println("can not communicate with the database");

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void addChick(ChickClass chick) {

    }
}
