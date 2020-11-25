package it.polytech.repository;

import it.polytech.model.Computer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        statement.execute("INSERT INTO computers (pc_id, purpose, cpu_family, ram_size, pc_os, gpu_fabricator, pc_price," +
                "cpu_fabricator, core_amount, ssd_size, pc_fabricator) " +
                "VALUES ("+ "'" + computer.getPc_id() + "'," +
                "'" + computer.getPurpose()+ "'," +
                "'" + computer.getCpu_family() + "'," +
                "'" + computer.getRam_size() + "'," +
                "'" + computer.getPc_os() + "'," +
                "'" + computer.getGpu_fabricator() + "'," +
                "'" + computer.getPc_price() + "'," +
                "'" + computer.getCpu_fabricator() + "'," +
                "'" + computer.getCore_amount() + "'," +
                "'" + computer.getSsd_size() + "'" +
                ")");
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
                    resultSet.getString(11)
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
