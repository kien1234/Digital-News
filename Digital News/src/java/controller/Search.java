/*
* Search.java
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
 * Search.<br>
 *
 * <pre>
 * Class thực hiện việc tìm kiếm bài báo theo tiêu đề
 * Trong class này sẽ tiến hành các xử lí dưới đây.
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
public class Search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Lấy tiêu đề đã nhầm vào ô tìm kiếm, sau đó tìm kiếm và phân
     * trang, nếu không điền gì cào ô search thì báo lỗi.
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
            String search = request.getParameter("search");
            //Kiểm tra xem search có rỗng hay không.
            if (search.equalsIgnoreCase("")) {
                search = null;
            }
            String index = request.getParameter("index");
            //Gọi phương thức getTop5OfArticle để lấy ra top 5 bài báo gần đây
            List<Article> top5OfArticle = articleDAO.getTop5OfArticle();
            //Kiểm tra xem index có null hay không.
            if (index == null) {
                index = "1";
            }
            int pageIndex = Integer.parseInt(index);
            int pageSize = 3;
            //Đếm số kết quả search được
            int count = articleDAO.count(search);
            int numberPage = (count % pageSize == 0) ? count / pageSize : count / pageSize + 1;
            //Search trong database rồi trả về 1 list các bài báo
            List<Article> listSearch = articleDAO.searchArticle(search, pageIndex, pageSize);
            request.setAttribute("numberPage", numberPage);
            request.setAttribute("listSearch", listSearch);
            request.setAttribute("search", search);
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("top5OfArticle", top5OfArticle);
            //Đẩy dữ liệu lên Search.jsp
            request.getRequestDispatcher("Search.jsp").forward(request, response);
        }catch(Exception e){
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
