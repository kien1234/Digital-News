/*
* ArticalDAO.java
*
* All Right Reserved
* Copyright (c) 2019 FPT University
 */
package dao;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Article;

/**
 * ArticalDAO.<br>
 *
 * <pre>
 * Class dùng các câu query để lấy dữ liệu từ database
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * . getTop1ID
 * . getTop5OfArticle
 * . getPostById
 * . count
 * . searchArticle
 *
 *
 * </pre>
 *
 * @author FU Kiennthe130540
 * @version 1.0
 */
public class ArticleDAO {

    /**
     * getTop1ID.<br>
     * lấy id của bài báo mới nhất của bảng Article
     *
     * @return 1 Integer number
     * @throws java.sql.SQLException
     */
    public int getTop1ID() throws SQLException {
        int id = 0;
        DBContext db = new DBContext();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT TOP 1 [id]\n");
        sql.append("FROM [dbo].[Articles]\n");
        sql.append("ORDER BY [date] DESC");
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
                return id;
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return id;
    }

    /**
     * getTop5OfArticle.<br>
     * lấy 5 bài báo mới nhất của bảng Article
     *
     * @return a list article
     * @throws java.sql.SQLException
     */
    public List<Article> getTop5OfArticle() throws SQLException {
        List<Article> articles = new ArrayList<>();
        DBContext db = new DBContext();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT TOP 5 [id]\n");
        sql.append(",[title]\n");
        sql.append(",[image]\n");
        sql.append(",[content]\n");
        sql.append(",[date]\n");
        sql.append(",[author]\n");
        sql.append("FROM [dbo].[Articles]\n");
        sql.append("ORDER BY [date] DESC");
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setImage(rs.getString("image"));
                article.setContent(rs.getString("content"));
                article.setDate(rs.getDate("date"));
                article.setAuthor(rs.getString("author"));
                articles.add(article);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return articles;
    }

    /**
     * getPostById.<br>
     * Truyền vào id và lấy ra bài báo có id trùng với id truyền vào.
     *
     * @param articleID
     * @return a Article
     * @throws java.sql.SQLException
     */
    public Article getPostById(int articleID) throws SQLException {
        Article article = null;
        DBContext db = new DBContext();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT [id]\n");
        sql.append(",[title]\n");
        sql.append(",[image]\n");
        sql.append(",[content]\n");
        sql.append(",[date]\n");
        sql.append(",[author]\n");
        sql.append("FROM [dbo].[Articles]\n");
        sql.append("where id= ?");
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql.toString());
            ps.setString(1, String.valueOf(articleID));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setImage(rs.getString("image"));
                article.setContent(rs.getString("content"));
                article.setDate(rs.getDate("date"));
                article.setAuthor(rs.getString("author"));
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return article;
    }

    /**
     * count.<br>
     * Truyền vào 1 string và đếm xem có bao nhiêu article chứa nó.
     *
     * @param searchString
     * @return Integer number
     * @throws java.sql.SQLException
     */
    public int count(String searchString) throws SQLException {
        int count = 0;
        DBContext db = new DBContext();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(*) AS COUNT FROM Articles\n");
        sql.append("WHERE title LIKE ?");
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql.toString());
            ps.setString(1, "%" + searchString + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("COUNT");
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return count;
    }

    /**
     * searchArticle.<br>
     * Truyền vào 1 string, 1 số Integer là index của page, 1 số Integer là size
     * và tìm các bài báo thỏa mãn.
     *
     * @param searchString
     * @param pageIndex
     * @param pageSize
     * @return Integer number
     * @throws java.sql.SQLException
     */
    public List<Article> searchArticle(String searchString, int pageIndex, int pageSize) throws SQLException{
        List<Article> articles = new ArrayList<>();
        DBContext db = new DBContext();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM (\n");
        sql.append("SELECT *, ROW_NUMBER() OVER (ORDER BY ID ASC) AS row_num FROM Articles WHERE title LIKE ?)\n");
        sql.append("AS k WHERE row_num BETWEEN (? - 1)*? +1 AND ?*?");
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql.toString());
            ps.setString(1, "%" + searchString + "%");
            ps.setInt(2, pageIndex);
            ps.setInt(3, pageSize);
            ps.setInt(4, pageIndex);
            ps.setInt(5, pageSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setImage(rs.getString("image"));
                article.setContent(rs.getString("content"));
                article.setDate(rs.getDate("date"));
                article.setAuthor(rs.getString("author"));
                articles.add(article);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return articles;
    }
}
