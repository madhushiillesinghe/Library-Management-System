package lk.ijse.library.dto;

import lk.ijse.library.entity.Admin;
import lk.ijse.library.entity.Book;

public class BookDto {
    private int id;
    private String title;
    private String genre;
    private String author;



    private String status;
   private Admin admin;

    public BookDto(int id, String title, String genre, String author, String status,Admin admin) {

        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.status = status;
        this.admin=admin;

    }


    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }



    public BookDto() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Book toEntity(){
        Book bookDto=new Book();
        bookDto.setId(this.id);
        bookDto.setAuthor(this.author);
        bookDto.setGenre(this.status);
        bookDto.setTitle(this.title);
        bookDto.setGenre(this.genre);
        bookDto.setAdmin(this.admin);
        return bookDto;
    }


    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", count=" + status +
                '}';
    }
}
