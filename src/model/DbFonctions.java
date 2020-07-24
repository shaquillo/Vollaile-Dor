package model;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DbFonctions {

    public static Connection ConnectToDb(String dbUsername, String dbPassword) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fermeVollaileDor?useTimezone=true&serverTimezone=UTC",dbUsername,dbPassword);
        return connection;
    }

    public static String seller = "";

    public static String connectUser(String userName, String password, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT nom,prenom,user,password,type FROM Employe;");
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            if((resultSet.getString("user")).equals(userName) && (resultSet.getString("password")).equals(password)){
                seller = resultSet.getString("prenom") + resultSet.getString("nom");
                return resultSet.getString("type");
            }
        }
        resultSet.close();
        return "notInDb";
    }

    public static String addAlimentSQL = "INSERT INTO Aliment(nom,prix,description) VALUES (?,?,?);";

    public static void addAliment(Connection connection, String nom, double prix, String description) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(addAlimentSQL);
        statement.setString(1,nom);
        statement.setDouble(2,prix);
        statement.setString(3,description);
        statement.executeUpdate();
        statement.close();
    }

    public static ObservableList<AlimentClass> loadAliment(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Aliment");
        ResultSet resultSet = statement.executeQuery();
        ObservableList<AlimentClass> alimentList = FXCollections.observableArrayList();
        int num = 1;
        while(resultSet.next()){
            alimentList.add(new AlimentClass(num,resultSet.getString("nom"),resultSet.getDouble("prix"),resultSet.getString("description")));
            num++;
        }
        return alimentList;
    }

    public static void deleteAliment(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Aliment WHERE nom = \"" + name + "\"");
        statement.executeUpdate();
        statement.close();
    }

    public static String addBuildingSQL = "INSERT INTO Batiment(nom, surface) VALUES (?, ?) ;";

    public static void addBatiment(Connection connection, String nom, double surface) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(addBuildingSQL);
        statement.setString(1,nom);
        statement.setDouble(2,surface);
        statement.executeUpdate();
        statement.close();
    }

    public static ObservableList<BuildingClass> loadBuilding(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Batiment");
        ResultSet resultSet = statement.executeQuery();
        ObservableList<BuildingClass> buildingList = FXCollections.observableArrayList();
        int num = 1;
        while(resultSet.next()){
            buildingList.add(new BuildingClass(num,resultSet.getString("nom"),resultSet.getDouble("surface")));
            num++;
        }
        return buildingList;
    }

    public static void deleteBuilding(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Batiment WHERE nom = \"" + name + "\"");
        statement.executeUpdate();
        statement.close();
    }

    public static String addSicknessSQL = "INSERT INTO Maladie(nom, descriptionMaladie, descriptionTraitement, duree) VALUES (?, ?, ?, ?) ;";

    public static void addSickness(Connection connection, String name, String sicknessDescription, String treatmentDescription,int treatmentDuration) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(addSicknessSQL);
        statement.setString(1,name);
        statement.setString(2,sicknessDescription);
        statement.setString(3,treatmentDescription);
        statement.setInt(4,treatmentDuration);
        statement.executeUpdate();
        statement.close();
    }

    public static ObservableList<SicknessClass> loadSickness(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Maladie");
        ResultSet resultSet = statement.executeQuery();
        ObservableList<SicknessClass> sicknessList = FXCollections.observableArrayList();
        int num = 1;
        while(resultSet.next()){
            sicknessList.add(new SicknessClass(num,resultSet.getString("nom"),resultSet.getString("descriptionMaladie"),resultSet.getString("descriptionTraitement"),Integer.parseInt(resultSet.getString("duree"))));
            num++;
        }
        return sicknessList;
    }

    public static void deleteSickness(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Maladie WHERE nom = \"" + name + "\"");
        statement.executeUpdate();
        statement.close();
    }

    public static String addRaceSQL = "INSERT INTO Race(nom, description) VALUES (?, ?) ;";

    public static void addRace(Connection connection, String name, String description) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(addRaceSQL);
        statement.setString(1,name);
        statement.setString(2,description);
        statement.executeUpdate();
        statement.close();
    }

    public static ObservableList<RaceClass> loadRace(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Race");
        ResultSet resultSet = statement.executeQuery();
        ObservableList<RaceClass> raceList = FXCollections.observableArrayList();
        int num = 1;
        while(resultSet.next()){
            raceList.add(new RaceClass(num,resultSet.getString("nom"),resultSet.getString("description")));
            num++;
        }
        return raceList;
    }

    public static void deleteRace(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Race WHERE nom = \"" + name + "\"");
        statement.executeUpdate();
        statement.close();
    }

    public static String addSupplierSQL = "INSERT INTO Fournisseur(nom, address, tel, email, siteWeb, type) VALUES (?, ?, ?, ?, ?, ?) ;";

    public static void addSupplier(Connection connection, String name, String address, String tel, String email, String siteWeb, String type) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(addSupplierSQL);
        statement.setString(1,name);
        statement.setString(2,address);
        statement.setString(3,tel);
        statement.setString(4,email);
        statement.setString(5,siteWeb);
        statement.setString(6,type);
        statement.executeUpdate();
        statement.close();
    }

    public static ObservableList<SuppliersClass> loadSupplier(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Fournisseur");
        ResultSet resultSet = statement.executeQuery();
        ObservableList<SuppliersClass> supplierList = FXCollections.observableArrayList();
        int num = 1;
        while(resultSet.next()){
            supplierList.add(new SuppliersClass(num,resultSet.getString("nom"),resultSet.getString("address"),resultSet.getString("tel"),resultSet.getString("email"),resultSet.getString("siteWeb"),resultSet.getString("type")));
            num++;
        }
        return supplierList;
    }

    public static void deleteSupplier(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Fournisseur WHERE nom = \"" + name + "\"");
        statement.executeUpdate();
        statement.close();
    }

    public static String addTypeEggSQL = "INSERT INTO TypeOeuf(nom, price) VALUES (?, ?) ;";

    public static void addTypeEgg(Connection connection, String name, double price) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(addTypeEggSQL);
        statement.setString(1,name);
        statement.setDouble(2,price);
        statement.executeUpdate();
        statement.close();
    }

    public static ObservableList<EggTypeClass> loadTypeEgg(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM TypeOeuf");
        ResultSet resultSet = statement.executeQuery();
        ObservableList<EggTypeClass> typeEggList = FXCollections.observableArrayList();
        int num = 1;
        while(resultSet.next()){
            typeEggList.add(new EggTypeClass(num,resultSet.getString("nom"),resultSet.getDouble("price")));
            num++;
        }
        return typeEggList;
    }

    public static void deleteTypeEgg(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM TypeOeuf WHERE nom = \"" + name + "\"");
        statement.executeUpdate();
        statement.close();
    }

    public static String addVaccinSQL = "INSERT INTO Vaccin(nom, period, duration, qtyVaccin, qtyFoul, prix, description) VALUES (?, ?, ?, ?, ?, ?, ?) ;";

    public static void addVaccin(Connection connection, String name, Date period, int duration, String qtyVaccin, int qtyFoul, double price, String description) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(addVaccinSQL);
        statement.setString(1,name);
        statement.setDate(2, period);
        statement.setInt(3,duration);
        statement.setString(4,qtyVaccin);
        statement.setInt(5,qtyFoul);
        statement.setDouble(6,price);
        statement.setString(7,description);
        statement.executeUpdate();
        statement.close();
    }

    public static ObservableList<VaccinClass> loadVaccin(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Vaccin");
        ResultSet resultSet = statement.executeQuery();
        ObservableList<VaccinClass> vaccinList = FXCollections.observableArrayList();
        int num = 1;
        while(resultSet.next()){
            vaccinList.add(new VaccinClass(num,resultSet.getString("nom"),resultSet.getDate("period"),resultSet.getInt("duration"),resultSet.getString("qtyVaccin"),resultSet.getInt("qtyFoul"),resultSet.getDouble("prix"),resultSet.getString("description")));
            num++;
        }
        return vaccinList;
    }

    public static void deleteVaccin(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Vaccin WHERE nom = \"" + name + "\"");
        statement.executeUpdate();
        statement.close();
    }

    public static String addStaffSQL = "INSERT INTO Employe(nom, prenom, type, user, password, sexe) VALUES (?, ?, ?, ?, ?, ?) ;";

    public static void addStaff(Connection connection, String name, String surname, String type, String user, String password, String sexe) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(addStaffSQL);
        statement.setString(1,name);
        statement.setString(2, surname);
        statement.setString(3,type);
        statement.setString(4,user);
        statement.setString(5,password);
        statement.setString(6,sexe);
        statement.executeUpdate();
        statement.close();
    }

    public static ObservableList<EmployeeClass> loadStaff(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Employe");
        ResultSet resultSet = statement.executeQuery();
        ObservableList<EmployeeClass> staffList = FXCollections.observableArrayList();
        int num = 1;
        while(resultSet.next()){
            staffList.add(new EmployeeClass(num,resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("type"),resultSet.getString("user"),resultSet.getString("password"),resultSet.getString("sexe")));
            num++;
        }
        return staffList;
    }

    public static void deleteStaff(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Employe WHERE nom = \"" + name + "\"");
        statement.executeUpdate();
        statement.close();
    }

    public static String addCustomerSQL = "INSERT INTO Client(nom, addresse, tel) VALUES (?, ?, ?) ;";

    public static void addCustomer(Connection connection, String name, String addresse, String tel) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(addCustomerSQL);
        statement.setString(1,name);
        statement.setString(2, addresse);
        statement.setString(3,tel);
        statement.executeUpdate();
        statement.close();
    }

    public static ObservableList<CustomerClass> loadCustomer(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Client");
        ResultSet resultSet = statement.executeQuery();
        ObservableList<CustomerClass> customerList = FXCollections.observableArrayList();
        int num = 1;
        while(resultSet.next()){
            customerList.add(new CustomerClass(num,resultSet.getString("nom"),resultSet.getString("addresse"),resultSet.getString("tel")));
            num++;
        }
        return customerList;
    }

    public static void deleteCustomer(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Client WHERE nom = \"" + name + "\"");
        statement.executeUpdate();
        statement.close();
    }

    public static ObservableList<String> loadBatchNames(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT nom FROM Bande;");
        ObservableList<String> batches = FXCollections.observableArrayList();
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            batches.add(resultSet.getString("nom"));
        }
        return batches;
    }

    public static String addBatchSQL = "INSERT INTO Bande(nom, idRace, quantite, prixAchat, prixVente, date,idBatiment, idFournisseur, age,idBande) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ;";//set age later
    public static int idBande = 0;

    public static void addBatch(Connection connection, String name, String race, int qty, double buyingPrice, Date startDate, String building, String supplier) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(addBatchSQL);

        PreparedStatement raceIdStatememt = connection.prepareStatement("SELECT idRace FROM Race WHERE nom = \"" + race + "\";");
        PreparedStatement batimentIdStatement = connection.prepareStatement("SELECT idBatiment FROM Batiment WHERE nom = \"" + building + "\";");
        PreparedStatement fournissuerIdStatement = connection.prepareStatement("SELECT idFournisseur FROM Fournisseur WHERE nom = \"" + supplier + "\";");

        ResultSet raceIdResultSet = raceIdStatememt.executeQuery();
        ResultSet batimentIdResultSet = batimentIdStatement.executeQuery();
        ResultSet fournisseurIdResultSet = fournissuerIdStatement.executeQuery();

        int raceId = 0, supplierId = 0 , buildingId = 0;

        if(raceIdResultSet.next() && fournisseurIdResultSet.next() && batimentIdResultSet.next()){
            raceId = raceIdResultSet.getInt("idRace");
            supplierId = fournisseurIdResultSet.getInt("idFournisseur");
            buildingId = batimentIdResultSet.getInt("idBatiment");
        }

        statement.setString(1,name);
        statement.setInt(2, raceId);
        statement.setInt(3,qty);
        statement.setDouble(4,buyingPrice);
        statement.setString(5,"-");
        statement.setDate(6,startDate);
        statement.setInt(7,buildingId);
        statement.setInt(8,supplierId);
        statement.setInt(9, 100);
        statement.setInt(10, ++idBande);
        statement.executeUpdate();
        statement.close();
    }

    public static ObservableList<BatchClass> loadBatch(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Bande");
        ResultSet resultSet = statement.executeQuery();
        ObservableList<BatchClass> batchList = FXCollections.observableArrayList();
        int num = 1;
        while(resultSet.next()){
            PreparedStatement raceNameStatement = connection.prepareStatement("SELECT nom FROM Race WHERE idRace = " + resultSet.getInt("idRace") + ";");
            PreparedStatement fournisseurNameStatement = connection.prepareStatement("SELECT nom FROM Fournisseur WHERE idFournisseur = " + resultSet.getInt("idFournisseur") + ";");
            PreparedStatement batimentNameStatement = connection.prepareStatement("SELECT nom FROM Batiment WHERE idBatiment = "+ resultSet.getInt("idBatiment")+";");

            ResultSet raceNameResultSet = raceNameStatement.executeQuery();
            ResultSet fournisseurNameResultSet = fournisseurNameStatement.executeQuery();
            ResultSet batimentNameResultset = batimentNameStatement.executeQuery();

            batchList.add(new BatchClass(num,resultSet.getString("nom"),raceNameResultSet.getString("nom"),resultSet.getInt("quantite"),resultSet.getDouble("prixAchat"),resultSet.getDate("date"),batimentNameResultset.getString("nom"),fournisseurNameResultSet.getString("nom")));
            num++;
        }
        return batchList;
    }

    public static void deleteBatch(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Bande WHERE nom = \"" + name + "\"");
        statement.executeUpdate();
        statement.close();
    }

    // add Batches controller
    public static ObservableList<String> loadRaceName(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT nom FROM Race;");
        ObservableList<String> races = FXCollections.observableArrayList();
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            races.add(resultSet.getString("nom"));
        }
        return races;
    }

    public static ObservableList<String> loadBuildingName(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT nom FROM Batiment;");
        ObservableList<String> buildings = FXCollections.observableArrayList();
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            buildings.add(resultSet.getString("nom"));
        }
        return buildings;
    }

    public static ObservableList<String> loadSupplierName(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT nom FROM Fournisseur;");
        ObservableList<String> suppliers = FXCollections.observableArrayList();
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            suppliers.add(resultSet.getString("nom"));
        }
        return suppliers;
    }

    /* public static String addSaleSQL = "INSERT INTO Vente(produit, idBande, typeProduit,quantite, total, date, idClient,idVendeur) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ;";

    public static void addsale(Connection connection, String produit, String batch, String tel) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(addSaleSQL);
        statement.setString(1);
        statement.setString(2, addresse);
        statement.setString(3,tel);
        statement.executeUpdate();
        statement.close();
    }

    public static ObservableList<CustomerClass> loadSale(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Client");
        ResultSet resultSet = statement.executeQuery();
        ObservableList<CustomerClass> customerList = FXCollections.observableArrayList();
        int num = 1;
        while(resultSet.next()){
            customerList.add(new CustomerClass(num,resultSet.getString("nom"),resultSet.getString("addresse"),resultSet.getString("tel")));
            num++;
        }
        return customerList;
    }*/

    public static ObservableList<String> loadAlimentName(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT nom FROM Aliment;");
        ObservableList<String> aliments = FXCollections.observableArrayList();
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            aliments.add(resultSet.getString("nom"));
        }
        return aliments;
    }

    public static String addFeedSQL = "INSERT INTO Ration(idAliment, idBande, date, quantite, eau) VALUES (?, ?, ?, ?, ?) ;";

    public static void addFeed(Connection connection, String aliment, Date date, String batch, int qtyAliment, int qtyWater) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(addFeedSQL);

        PreparedStatement idAlimentStatement = connection.prepareStatement("SELECT idAliment FROM Aliment WHERE nom = \"" + aliment + "\";");
        PreparedStatement idBandeStatement = connection.prepareStatement("SELECT idBande FROM Bande WHERE nom = \"" + batch + "\";");

        ResultSet idAlimentResultSet = idAlimentStatement.executeQuery();
        ResultSet idBandeResultSet = idBandeStatement.executeQuery();

        int alimentId = 0, batchId = 0;
        if(idAlimentResultSet.next() && idBandeResultSet.next()){
            alimentId = idAlimentResultSet.getInt("idAliment");
            batchId = idBandeResultSet.getInt("idBande");
        }

        statement.setInt(1,alimentId);
        statement.setInt(2, batchId);
        statement.setDate(3,date);
        statement.setInt(4, qtyAliment);
        statement.setInt(5, qtyWater);
        statement.executeUpdate();
        statement.close();
    }

    public static ObservableList<FeedClass> loadFeed(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Ration;");
        ResultSet resultSet = statement.executeQuery();
        ObservableList<FeedClass> feedList = FXCollections.observableArrayList();
        int num = 1;
        while(resultSet.next()){
            PreparedStatement alimentNameStatement = connection.prepareStatement("SELECT nom FROM Aliment WHERE idAliment = \"" + resultSet.getInt("idAliment") + "\";");
            PreparedStatement batchNameStatement = connection.prepareStatement("SELECT nom FROM Bande WHERE idBande = \"" + resultSet.getInt("idBande") + "\";");

            ResultSet alimentNameResultSet = alimentNameStatement.executeQuery();
            ResultSet batchNameResultSet = batchNameStatement.executeQuery();

            feedList.add(new FeedClass(num,alimentNameResultSet.getString("nom"), resultSet.getDate("date"), batchNameResultSet.getString("nom"),resultSet.getInt("quantite"), resultSet.getInt("eau")));
            num++;
        }
        return feedList;
    }

    public static void deleteFeed(Connection connection, int idAliment, int idBande) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Ration WHERE idAliment = \"" + idAliment + "\" and idBande = \"" + idBande + "\";");
        statement.executeUpdate();
        statement.close();
    }

    public static int getIdFromString(Connection connection,String tableName, String idName, String column1Name,String column1Value,String column2Name, String column2Value) throws SQLException {
        PreparedStatement idStatement;
        if (column2Name.equals("")) {
            idStatement = connection.prepareStatement("SELECT " + idName + " FROM " + tableName + " WHERE " + column1Name + " = \"" + column1Value + "\";");
        } else {
            idStatement = connection.prepareStatement("SELECT " + idName + " FROM " + tableName + " WHERE " + column1Name + " = \"" + column1Value + "\" and " + column2Name + " = \"" + column2Value + "\";");
        }
        ResultSet idResultSet = idStatement.executeQuery();

        int idVal = 0;
        if (idResultSet.next()) {
            idVal = idResultSet.getInt(idName);
        }
        return idVal;
    }
}
