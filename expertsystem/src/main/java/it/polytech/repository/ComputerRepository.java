package it.polytech.repository;

import com.google.gson.Gson;
import it.polytech.model.Computer;
import it.polytech.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerRepository {
    private static Database database = new Database();

    public static List<Computer> getComputersList() throws SQLException {
        Gson gson = new Gson();
        List<Computer> list = database.getList();
        return list;
    }

    public static void createComputer(String line) throws SQLException {
        Computer computer = new Gson().fromJson(line, Computer.class);
        database.add(computer);
    }

    public static void deleteComputer(String id) {
        try {
            database.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateComputer(String line) {
        try {
            Computer computer = new Gson().fromJson(line, Computer.class);
            database.update(computer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String findComputers(Computer computer) throws SQLException {
        List<Computer> list = getComputersList();
        List<Integer> priceList = utils.math(computer.getPc_price());
        List<Integer> ssdList = utils.math(computer.getSsd_size());
        ArrayList<Computer> resultList = new ArrayList();


        for (Computer item : list) {
            if (Integer.parseInt(item.getPc_price()) >= priceList.get(0)  &&
                    Integer.parseInt(item.getPc_price()) <= priceList.get(1)) {
                if (computer.getCpu_family().equals(item.getCpu_family()) ||
                        computer.getCpu_family().equals("none")) {
                    if (computer.getForm_factor().equals("none") ||
                            computer.getForm_factor().equals(item.getForm_factor())) {
                        if(Integer.parseInt(item.getSsd_size()) >= ssdList.get(0) &&
                                Integer.parseInt(item.getSsd_size()) <= ssdList.get(1) ){
                            if (computer.getPc_os().equals(item.getPc_os()) ||
                                    computer.getPc_os().equals("none")) {
                                if (computer.getGpu_fabricator().equals(item.getGpu_fabricator()) ||
                                        computer.getGpu_fabricator().equals("none")) {
                                    if (computer.getCore_amount().equals(item.getCore_amount()) ||
                                            computer.getCore_amount().equals("none")) {
                                        if (computer.getPc_fabricator().equals(item.getPc_fabricator()) ||
                                                computer.getPc_fabricator().equals("none")) {
                                            if (computer.getPurpose().equals(item.getPurpose()) ||
                                                    computer.getPurpose().equals("none")) {
                                                if (computer.getRam_size().equals(item.getRam_size()) ||
                                                        computer.getRam_size().equals("none")) {
                                                    System.out.println(item.getPc_name());
                                                    resultList.add(item);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
       }
    return utils.listToJson(resultList);
    }
}
