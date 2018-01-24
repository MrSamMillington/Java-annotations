package suppressWarnings;

import java.io.Console;
import java.util.List;

@SuppressWarnings("AccessStaticViaInstance")
public class Main {

    public static void main(String[] args) {
        Console console = System.console();

        int numPosts = Integer.parseInt(console.readLine("How many posts? "));

        Blog b = new Blog();

        List<Post> posts = b.getLatestPosts(numPosts);

        switch(numPosts){
            case 0:
                System.out.println("No posts");
                break;
            case 1:
                System.out.println(posts.get(0));
                break;
            default:
                for(Post post: posts){
                    System.out.println(post);
                }
                break;
        }
    }
}
