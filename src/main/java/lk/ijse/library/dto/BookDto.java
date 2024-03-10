package lk.ijse.library.dto;

import lk.ijse.library.entity.Admin;
import lk.ijse.library.entity.Book;

public class BookDto {
    private int id;
    private String title;
    private String genre;
    private String author;
    private int count;
   private Admin admin;

    public BookDto(int id, String title, String genre, String author, int count,Admin admin) {

        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public Book toEntity(){
        Book bookDto=new Book();
        bookDto.setId(this.id);
        bookDto.setAuthor(this.author);
        bookDto.setCount(this.count);
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
                ", count=" + count +
                '}';
    }
}
