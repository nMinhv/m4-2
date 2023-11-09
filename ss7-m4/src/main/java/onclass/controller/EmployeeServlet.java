package onclass.controller;

import onclass.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EmployeeServlet", value = "/nhan-vien")
public class EmployeeServlet extends HttpServlet {
    private final List<Employee> list = new ArrayList<>();

    @Override
    public void init() {
        list.add(new Employee("NV01", "Tien bip", 18, 1000));
        list.add(new Employee("NV02", "Tien bip", 20, 1500));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // kiem tra action
        String action = request.getParameter("action");
        if (action == null) {
            getList(request, response);
            return;
        }
        switch (action) {
            case "edit":
                // day ve view sua
                String eId = request.getParameter("id");
                Employee employee = findById(eId);
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("views/EEmployee.jsp").forward(request, response);
                break;
            case "delete":
                break;
            default:

                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeId = req.getParameter("employeeCode");
        String fullName = req.getParameter("fullName");
        int age = Integer.parseInt(req.getParameter("age"));
        double salary = Double.parseDouble(req.getParameter("salary"));
        String action = req.getParameter("action");
        if (action == null) {
            list.add(new Employee(employeeId, fullName, age, salary));
        }else {
          Employee employee = findById(employeeId);
          employee.setFullName(fullName);
          employee.setAge(age);
          employee.setSalary(salary);
        }
        getList(req, resp);
    }

    @Override
    public void destroy() {
    }

    // tao phuong thuc getList()
    public void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", list);
        request.getRequestDispatcher("views/employee.jsp").forward(request, response);
    }

    public Employee findById(String eId) {
        for (Employee employee : list) {
            if (employee.getEmployeeId().equals(eId)) {
                return employee;
            }
        }
        return null;
    }
}