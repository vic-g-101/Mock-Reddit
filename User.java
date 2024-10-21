/*
 * Name: Victor Gomez
 * Email: vig002@ucsd.edu
 * PID: A17390106
 * This program will create a user and will
 * show how much karma a user might have
 * and the original posts they have liked
 */
import java.util.ArrayList;
public class User {
    private int karma;
    private String username;
    private ArrayList<Post> posts;
    private ArrayList<Post> upvoted;
    private ArrayList<Post> downvoted;
    private static final String TO_USER_FORMAT = "u/%s Karma: %d";
    // this method initializes user
    public User(String username){
        karma = 0;
        this.username = username;
        posts = new ArrayList <>();
        upvoted =new ArrayList <>();
        downvoted = new ArrayList <>();

    }
    // this method adds post into posts array and updates karma
    public void addPost(Post post){
        if (posts != null){
            posts.add(post);
            updateKarma();
        }

    }
    // This method updates the users karma
    public void updateKarma(){
        int upvote = 0;
        int downvote = 0;
        for (int i=0; i < posts.size(); i++){
        upvote += posts.get(i).getUpvoteCount();
        downvote += posts.get(i).getDownvoteCount();
        }
        karma = upvote - downvote;
    }
    //This method returns user karma
    public int getKarma(){
        return karma;
    }
    //This method upovtes a post and updates the list of posts you've upvoted
    public void upvote(Post post){
        if (post == null){
            return;
        }
        else if (post.getAuthor().toString() == username || upvoted.contains(post) == true){
            return;
        }
        else if(downvoted.contains(post) == true){
            downvoted.remove(post);
            post.updateDownvoteCount(false);
        }
        upvoted.add(post);
        post.updateUpvoteCount(true);
        post.getAuthor().updateKarma();
    
    }
     //This method downovtes a post and updates the list of posts you've downvoted
    public void downvote(Post post){
        if (post == null){
            return;
        }
        else if (post.getAuthor().toString() == username || downvoted.contains(post) == true){
            return;
        }
        else if(upvoted.contains(post) == true){
            upvoted.remove(post);
            post.updateUpvoteCount(false);
        }
            downvoted.add(post);
            post.updateDownvoteCount(true);
            post.getAuthor().updateKarma();
    }
    // this gets the top post of the user
    public Post getTopPost(){
        int count = 0;
        Post toppost = null;
        for(int i =0; i < posts.size();i++){
            if(posts.get(i).getTitle() != null){
                int upvote = posts.get(i).getUpvoteCount();
                int downvote = posts.get(i).getDownvoteCount();
                int diff = upvote - downvote;
                if (count < diff){
                    count =diff;
                    toppost = posts.get(i);
                }
        }
    }
    return toppost;
}
    //this post has to get top comment of user
    public Post getTopComment(){
        int count = 0;
        Post topcomment = null;
        for(int i =0; i < posts.size();i++){
            if(posts.get(i).getTitle() == null){
                int upvote = posts.get(i).getUpvoteCount();
                int downvote = posts.get(i).getDownvoteCount();
                int diff = upvote - downvote;
                if (count < diff){
                    count =diff;
                    topcomment = posts.get(i);
                }
        }
    }
    return topcomment;
}
    // this method gets all the posts a user has made
    public ArrayList<Post> getPosts(){
        return posts;
    }
    // returns a string form of user
    public String toString(){
        String user = String.format(TO_USER_FORMAT, username, karma);
        return user;
    }
}
