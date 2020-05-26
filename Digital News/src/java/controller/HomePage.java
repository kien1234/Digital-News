/*
* HomePage.java
*
* All Right Reserved
* Copyright (c) 2019 FPT University
 */
package controller;

import dao.ArticleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;

/**
 * Home.<br>
 *
 * <pre>
 * Class Homepage lấy dữ liệu từ database thông qua class ArticleDAO và đẩy dữ
 * liệu lên Home.jsp để hiển thị lên trình duyệt. Trong class này sẽ tiến hành
 * các xử lí dưới đây.
 *
 * . ProcessRequest.
 * . DoGet.
 * . DoPost.
 *
 *
 * </pre>
 *
 * @author FU Kiennthe130540
 * @version 1.0
 */
public class HomePage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Lấy ra 1 bài báo theo id gần đây lấy ra top 5 bài báo gần đây
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ArticleDAO articleDAO = new ArticleDAO();
            String idString = request.getParameter("id");
            int id;
            if (idString == null) {
                // Lấy ra id của bài báo mới nhất 
                id = articleDAO.getTop1ID();
            } else {
                id = Integer.parseInt(idString);
            }
            //Gọi phương thức getPostById để lấy ra bài báo theo id
            Article postById = articleDAO.getPostById(id);
            //Gọi phương thức getTop5OfArticle để lấy ra top 5 bài báo gần đây
            List<Article> top5OfArticle = articleDAO.getTop5OfArticle();
            request.setAttribute("postById", postById);
            request.setAttribute("top5OfArticle", top5OfArticle);
            //Đẩy dữ liệu lên HomePage.jsp
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } catch (Exception e) {
            //Bắt lỗi, đẩy sang trang error.jsp
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
