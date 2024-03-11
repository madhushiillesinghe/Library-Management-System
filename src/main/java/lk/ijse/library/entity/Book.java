package lk.ijse.library.entity;
import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int  id;
    @Column(name = "book_title")
    private String title;
    @Column(name = "book_genre")
    private String genre;
    @Column(name = "book_author")
    private String author;
    @Column(name = "book_count")
    private int count;
    @ManyToOne
    @JoinColumn(name ="admin_Id" )
    private Admin admin;

    public Book(int id, String title, String genre, String author, int count,Admin admin) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.count = count;
        this.admin=admin;
    }




    public Book() {
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




    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", count=" + count +
                '}';
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
