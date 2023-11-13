package com.ra.bt.product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductServiceImp();

    @Override
    public void init() throws ServletException {
        // Khởi tạo một số sản phẩm mẫu và thêm chúng vào danh sách sản phẩm
        Product product1 = new Product(1, "Laptop", 1200.0, "description1", "Manufacturer A");
        Product product2 = new Product(2, "Smartphone", 800.0, "description2", "Manufacturer B");
        Product product3 = new Product(3, "Headphones", 150.0, "description3", "Manufacturer C");

        // Thêm vào danh sách sản phẩm
        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listProducts(request, response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                searchProducts(request, response);
                break;
            default:
                listProducts(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            addProduct(request, response);
        } else if ("update".equals(action)) {
            updateProduct(request, response);
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = productService.getAllProducts();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/product-list.jsp");
        dispatcher.forward(request, response);
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProductById(productId);

        if (product != null) {
            request.setAttribute("product", product);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/product-view.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("error", "Sản phẩm không tồn tại");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/product-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProductById(productId);

        if (product != null) {
            request.setAttribute("product", product);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/product-form.jsp");
            dispatcher.forward(request, response);
        } else {
            // Xử lý sản phẩm không tồn tại
            request.setAttribute("error", "Sản phẩm không tồn tại");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(productId);
        listProducts(request, response);
    }

    private void searchProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName = request.getParameter("name");
        List<Product> products = productService.searchProductsByName(productName);
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/product-list.jsp");
        dispatcher.forward(request, response);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String priceString = request.getParameter("price");
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");

        try {
            double price = Double.parseDouble(priceString);
            Product newProduct = new Product(0, name, price, description, manufacturer);
            productService.addProduct(newProduct);

            listProducts(request, response);
        } catch (NumberFormatException e) {
            // Xử lý lỗi kiểu dữ liệu không hợp lệ
            request.setAttribute("error", "Giá sản phẩm không hợp lệ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        String name = request.getParameter("name");
        String priceString = request.getParameter("price");
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");

        try {
            int productId = Integer.parseInt(idString);
            double price = Double.parseDouble(priceString);
            Product updatedProduct = new Product(productId, name, price, description, manufacturer);
            productService.updateProduct(updatedProduct);

            listProducts(request, response);
        } catch (IllegalArgumentException e) {
            // Xử lý lỗi kiểu dữ liệu không hợp lệ hoặc sản phẩm không tồn tại
            request.setAttribute("error", "Dữ liệu không hợp lệ hoặc sản phẩm không tồn tại");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }
}