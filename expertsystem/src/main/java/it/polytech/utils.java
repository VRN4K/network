package it.polytech;

import com.google.gson.Gson;
import it.polytech.model.Computer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class utils {

    public static List<Integer> math(String str) {
        List<Integer> list = new ArrayList();
        String start = "";
        String end = "";
        int tire = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '-' && str.charAt(i) != ' ') {
                start += str.charAt(i);
                }else{
                tire = i;
                break;
            }
            }
        System.out.println(start);

        for (int i = tire +1; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                end += str.charAt(i);
            }
        }
        System.out.println(end);

        if(start.length() < 1){
            list.add(0);
        }else {
            list.add(Integer.parseInt(start));
        }

        if(end.length() > 2){
            list.add(Integer.parseInt(end));
        }else{
            list.add(0);
        }
        return list;
    }


    public static String listToJson(List<Computer> list){
        Gson gson = new Gson();
        List<Map<String, String>> mapList = new ArrayList<>();
        for (Computer computer: list) {
            Map<String,String> map = new HashMap<>();
            map.put("pc_id", computer.getPc_id());
            map.put("pc_name",computer.getPc_name());
            map.put("pc_price",computer.getPc_price());
            map.put("cpu_family",computer.getCpu_family());
            map.put("form_factor",computer.getForm_factor());
            map.put("ssd_size", computer.getSsd_size());
            map.put("pc_os", computer.getPc_os());
            map.put("gpu_fabricator", computer.getGpu_fabricator());
            map.put("core_amount",computer.getCore_amount());
            map.put("pc_fabricator",computer.getPc_fabricator());
            map.put("purpose",computer.getPurpose());
            map.put("ram_size", computer.getRam_size());
            mapList.add(map);
        }
        return gson.toJson(mapList);
    }

}

