package suppressWarnings;

import java.util.Date;
import java.util.List;

public class Post {
    private String title;
    private String subtitle;
    private String content;
    private Date dateCreated;
    private Date datePublished;
    private List<Comment> comments;

    public Post(String title, String subtitle){
        this.title = title;
        this.subtitle = subtitle;
        dateCreated = new Date();
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", content='" + content + '\'' +
                ", dateCreated=" + dateCreated +
                ", datePublished=" + datePublished +
                ", comments=" + comments +
                '}';
    }
}
