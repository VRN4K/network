package it.polytech.repository;

import it.polytech.model.Computer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Database {

    private static Connection dbConnection;
    private static Boolean status = false;

    private static Connection getDbConnection() {
        System.out.println("getDbConnection");
        if (!status) {
            String connectionString = "jdbc:postgresql://localhost:5432/expertsystem";

            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                dbConnection = DriverManager.getConnection(connectionString, "vrnk", "1561");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            status = true;
        }
        return dbConnection;
    }

    public static void add(Computer computer) throws SQLException {
        Statement statement = getDbConnection().createStatement();
        statement.execute("INSERT INTO computers (pc_id,  pc_name,  pc_price,  cpu_family,  form_factor,  ssd_size,  pc_os," +
                "gpu_fabricator,  core_amount,  pc_fabricator,  purpose,  ram_size) VALUES ("+
                "'" +  UUID.randomUUID().toString() + "'," +
                "'" + computer.getPc_name() + "'," +
                "'" + computer.getPc_price() + "'," +
                "'" + computer.getCpu_family() + "'," +
                "'" + computer.getForm_factor() + "'," +
                "'" + computer.getSsd_size() + "'," +
                "'" + computer.getPc_os() + "'," +
                "'" + computer.getGpu_fabricator() + "'," +
                "'" + computer.getCore_amount() + "'," +
                "'" + computer.getPc_fabricator() + "'," +
                "'" + computer.getPurpose()+ "'," +
                "'" + computer.getRam_size() + "')");
    }

    public static void update(Computer computer) throws SQLException {
        Statement statement = getDbConnection().createStatement();
//        statement.execute("UPDATE book SET title='" + computer.getTitle() + "'," +
//                " author='" + computer.getAuthor() +
//                "', pages='" + computer.getPages() + "'," +
//                " genre='" + computer.getGenre() + "'," +
//                " year ='" + computer.getYear() +
//                "' WHERE id='" + computer.getId() + "'");
    }

    public static List<Computer> getList() throws SQLException {
        List<Computer> list = new ArrayList<>();
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM computers");
        while (resultSet.next()) {
            list.add(new Computer(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11),
                    resultSet.getString(12)
            ));
        }
        return list;
    }

    public static void delete(String id) throws SQLException {
        System.out.println(id);
        Statement statement = getDbConnection().createStatement();
        statement.execute("DELETE FROM computers WHERE pc_id = '" + id + "'");
    }
}
