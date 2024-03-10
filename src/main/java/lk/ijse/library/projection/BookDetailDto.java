package lk.ijse.library.projection;

public class BookDetailDto {
    private int  id;
    private String title;
    private String genre;
    private int count;
    private String availability;

    public BookDetailDto(int id, String title, String genre, int count, String availability) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.count = count;
        this.availability = availability;
    }

    public BookDetailDto() {
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "BookProjection{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", count=" + count +
                ", availability='" + availability + '\'' +
                '}';
    }
}
