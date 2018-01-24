package suppressWarnings;

import java.util.Arrays;
import java.util.List;

public class Blog {
    public static List<Post> getLatestPosts(int numPosts) {
        return Arrays.asList(
                new Post("title", "Subtitle")
        );
    }
}
