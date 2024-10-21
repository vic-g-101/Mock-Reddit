/*
 * Name: Victor Gomez
 * Email: vig002@ucsd.edu
 * PID: A17390106
 * This program will either make an orignial post 
 * or comment
 */
import java.util.ArrayList;
public class Post {
    private String title;
    private String content;
    private Post replyTo;
    private User author;
    private int upvoteCount;
    private int downvoteCount;
    private static final String TO_STRING_POST_FORMAT = "[%d|%d]\t%s\n\t%s";
    private static final String TO_STRING_COMMENT_FORMAT = "[%d|%d]\t%s";
    // this is the method that initializes everything for Original post
    public Post(String title, String content, User author){
        upvoteCount = 1;
        downvoteCount = 0;
        this.title = title;
        this.content = content;
        this.author = author;
    }
    // this is mehtod that initializes everything for a comment post
    public Post(String content, Post replyTo, User author){
        upvoteCount = 1;
        downvoteCount = 0;
        this.content = content;
        this.replyTo = replyTo;
        this.author = author;
    }
    // this method gets the title for an original post
    public String getTitle(){
        return this.title;
    }
    // this method gets the replyto post
    public Post getReplyTo(){
        return this.replyTo;
    }
    //this method gets the author of the post
    public User getAuthor(){
        return this.author;
    }
    // this method will get how many upvotes the post has
    public int getUpvoteCount(){
        return this.upvoteCount;
    }
    // this method will get how many upvotes the post has
    public int getDownvoteCount(){
        return this.downvoteCount;
    }
    // this method will increase the amount of upvote
    public void updateUpvoteCount(boolean isIncrement){
        if (isIncrement == true){
            upvoteCount+=1;
        }
        else{
            upvoteCount-=1;
        }
    }
    // this method will increase the amount of downvote
    public void updateDownvoteCount(boolean isIncrement){
        if (isIncrement == true){
            downvoteCount+=1;
        }
        else{
            downvoteCount-=1;
        }
    }
    // this method gets the current thread of an orignal post
    public ArrayList<Post> getThread(){
        ArrayList<Post> post = new ArrayList<>();
        if (replyTo != null){
        post = replyTo.getThread();
        post.add(this);
        return post;
        }
        else{
            post.add(this);
            return post;
        }
    }
    // this method returns a string represnetation for the post
    public String toString(){
        if(replyTo == null){
            String OGPost = String.format(TO_STRING_POST_FORMAT, upvoteCount,
             downvoteCount, title, content);
            return OGPost;
        }
        else{
            String comment = String.format(TO_STRING_COMMENT_FORMAT,upvoteCount, 
            downvoteCount, content);
            return comment;
        }
    }
}