   
   /*
 
 * This program tests the classes Post and User
 */public class Tester {
        public static void main(String[] args) {
            User u1 = new User("Victor Gomez");
            Post p1 = new Post("Title", "Content", u1);
            Post c1 = new Post("Comment", p1, u1);
            User u2 = new User ("Joe Mamma");
            Post p2 = new Post ("Funny Meme", "meme", u2);
            Post c2 = new Post ("comment", p2, u1);

            System.out.println(u1);
            System.out.println(p1);
            System.out.println(c1);
            u1.addPost(p1);
            u1.addPost(c1);
            System.out.println(u1.getTopPost());
            System.out.println(u1.getTopComment());

            //Testing Post Class
            p2.getAuthor();
            p2.getTitle();
            p2.getUpvoteCount();
            c2.getReplyTo();
            p2.getDownvoteCount();
            p2.updateDownvoteCount(true);
            p1.updateUpvoteCount(true);
            c2.getThread();

            // Tetstting User Class
            u2.getKarma();
            u2.getPosts();
            u2.downvote(p1);
            u2.upvote(p1);
            u2.updateKarma();
        }         
    }
