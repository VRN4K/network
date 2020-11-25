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

    public static String getComputersList() throws SQLException {
        Gson gson = new Gson();
        List<Computer> list = database.getList();
        List<Map<String, String>> mapList = new ArrayList<>();
        for (Computer computer: list) {
            Map<String,String> map = new HashMap<>();
            map.put("pc_id", computer.getPc_id());
            map.put("purpose",computer.getPurpose());
            map.put("cpu_family",computer.getCpu_family());
            map.put("ram_size",computer.getRam_size());
            map.put("pc_os",computer.getPc_os());
            map.put("gpu_fabricator", computer.getGpu_fabricator());
            map.put("pc_price",computer.getPc_price());
            map.put("cpu_fabricator",computer.getCpu_fabricator());
            map.put("core_amount", computer.getCore_amount());
            map.put("ssd_size",computer.getSsd_size());
            map.put("pc_fabricator",computer.getPc_fabricator());
            mapList.add(map);
        }
        return gson.toJson(mapList);
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


}
