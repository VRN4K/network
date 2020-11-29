package it.polytech.repository;

import com.google.gson.Gson;
import it.polytech.model.Computer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerRepository {
    private static Database database = new Database();

    public static List<Computer> getComputersList() throws SQLException {
        Gson gson = new Gson();
        List<Computer> list = database.getList();
//        for (Computer computer: list) {
//            Map<String,String> map = new HashMap<>();
//            map.put("pc_id", computer.getPc_id());
//            map.put("pc_name", computer.getPc_name());
//            map.put("pc_price",computer.getPc_price());
//            map.put("cpu_family",computer.getCpu_family());
//            map.put("form_factor",computer.getForm_factor());
//            map.put("ssd_size",computer.getSsd_size());
//            map.put("pc_os",computer.getPc_os());
//            map.put("gpu_fabricator", computer.getGpu_fabricator());
//            map.put("core_amount", computer.getCore_amount());
//            map.put("pc_fabricator",computer.getPc_fabricator());
//            map.put("purpose",computer.getPurpose());
//            map.put("ram_size",computer.getRam_size());
//            mapList.add(map);
//        }
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
    public static void findComputers(Computer computer) throws SQLException {
        List<Computer> list = getComputersList();
        List<Computer> resultList = new ArrayList<Computer>();


        for (Computer item: list) {
            if(computer.getCpu_family().equals(item.getCpu_family()) ||
                    computer.getCpu_family().equals("none")){
                if (computer.getForm_factor().equals("none") ||
                        computer.getForm_factor().equals(item.getForm_factor())){
                    if(computer.getPc_os().equals(item.getPc_os()) ||
                            computer.getPc_os().equals("none")){
                        if(computer.getGpu_fabricator().equals(item.getGpu_fabricator()) ||
                                computer.getGpu_fabricator().equals("none")){
                            if(computer.getCore_amount().equals(item.getCore_amount()) ||
                                    computer.getCore_amount().equals("none")){
                                if(computer.getPc_fabricator().equals(item.getPc_fabricator()) ||
                                        computer.getPc_fabricator().equals("none")){
                                    if(computer.getPurpose().equals(item.getPurpose()) ||
                                            item.getPurpose().equals("none")){
                                        if(computer.getRam_size().equals(item.getRam_size()) ||
                                                item.getRam_size().equals("none")){
                                            System.out.println(item.getPc_name());
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
