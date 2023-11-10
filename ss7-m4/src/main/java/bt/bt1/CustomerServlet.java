package bt.bt1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CustomerServlet", value = "/customer_servlet")
public class CustomerServlet extends HttpServlet {
    private  final List<Customer> customerList = new ArrayList<>();


    @Override
    public void init() {
        customerList.add(new Customer("Hồ Tiến", "1990-01-01", "Hà Nội", "anh1.jpg"));
        customerList.add(new Customer("Tiến Hồ", "1995-05-15", "Thanh hóa", "anh2.jpg"));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("vào do get");

        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
