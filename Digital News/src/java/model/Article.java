/*
* Article.java
*
* All Right Reserved
* Copyright (c) 2019 FPT University
*/
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Article.<br>
 * 
 * <pre>
Class mô tả đối tượng Article
Trong class này sẽ tiến hành các xử lí dưới đây
 
 . GetId.
 . SetId.
 . GetTitle.
 . SetTile.
 . GetImage.
 . SetDate.
 . GetContent.
 . SetContent.
 . GetDate.
 . SetDate.
 . GetAuthor.
 . SetAuthor.
 . ToString.
 . getDateFormat
 . getSortContent
 
 </pre>
 * 
 * @author FU Kiennthe130540
 * @version 1.0
 */
public class Article {
    /**Store id.*/
    private int id;
    /**Store title.*/
    private String title;
    /**Store image.*/
    private String image;
    /**Store content.*/
    private String content;
    /**Store date.*/
    private Date date;
    /**Store author.*/
    private String author;

    /**
     * Constructor no parameter.<br>
     */
    public Article() {
    }

    /**
     * Constructor full parameter<br>
     * @param id
     * @param title
     * @param image
     * @param content
     * @param date
     * @param author
     */
    public Article(int id, String title, String image, String content, Date date, String author) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.date = date;
        this.author = author;
    }

    /**
     * Get id.<br>
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    /**
     * Set id.<br>
     * 
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get title.<br>
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title.<br>
     * 
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get image.<br>
     * 
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Set image.<br>
     * 
     * @param image the image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get content.<br>
     * 
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set content.<br>
     * 
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get date.<br>
     * 
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set date.<br>
     * 
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get author.<br>
     * 
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set author.<br>
     * 
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get date format.<br>
     * 
     * @return the date format by "MMMM dd yyy '-' HH:mmaaa".
     */
    public String getDateFormat(){
        return new SimpleDateFormat("MMMM dd yyy '-' HH:mmaaa").format(this.date).toLowerCase();
    }
    
    /**
     * getSortName.<br>
     * 
     * @return nội dung của bài báo với số lượng 180 từ.
     */
    public String getSortContent(){
        if(content.length() <= 180)
            return content;
        return content.substring(0, 180)+"...";
    }
}
