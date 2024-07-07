package lk.ijse.gdse68.studentmanagement.Controller;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
@WebServlet(urlPatterns = "/student")
public class Student extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        //process the JSON
        JsonReader reader = Json.createReader(req.getReader());
//        JsonObject jsonObject = reader.readObject();
//        String email = jsonObject.getString("email");
//        System.out.println(email);
//
        //Optimal JSON array processing
        JsonArray jsonArray = reader.readArray();
        for (int i=0; i< jsonArray.size();i++){
            var jsonObject = jsonArray.getJsonObject(i);
            System.out.println(jsonObject.getString("name"));
            System.out.println(jsonObject.getString("email"));
        }

         //send data to the client
//        var writer = resp.getWriter();
//        writer.write(email);



    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
