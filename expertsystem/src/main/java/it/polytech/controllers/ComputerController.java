package it.polytech.controllers;

import com.google.gson.Gson;
import it.polytech.model.Computer;
import it.polytech.repository.ComputerRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ComputerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = req.getReader().readLine();
        Computer computer = new Gson().fromJson(json, Computer.class);
        System.out.println(json);
        try {
            ComputerRepository.findComputers(computer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
