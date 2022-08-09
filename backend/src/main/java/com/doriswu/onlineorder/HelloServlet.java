package com.doriswu.onlineorder;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.doriswu.onlineorder.entity.Customer;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json"); // data format

        ObjectMapper mapper = new ObjectMapper();
        Customer customer = new Customer();
        customer.setEmail("sun@laioffer.com");
        customer.setPassword("123456");
        customer.setFirstName("rick");
        customer.setLastName("sun");
        customer.setEnabled(true);
        response.getWriter().print(mapper.writeValueAsString(customer));


//        String username = request.getParameter("username");
        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + "hello" + username + "</h1>");
//        out.println("</body></html>");

//        JSONObject user = new JSONObject();
//        user.put("username", "Vincent");
//        user.put("email", "XXXX@YYY");
//        response.getWriter().print(user);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String lastName = jsonRequest.getString("last_name");
        String firstName = jsonRequest.getString("first_name");
        response.setContentType("application/json"); // data format

        PrintWriter out = response.getWriter();
        JSONObject obj = new JSONObject();
        obj.put("last name", "get last name successfully:" + lastName);
        obj.put("first name", "get first name successfully" + firstName);
        obj.put("status" , "ok");
        out.println(obj);


    }

    public void destroy() {
    }
}