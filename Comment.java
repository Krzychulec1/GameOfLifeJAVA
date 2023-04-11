package pl.edu.pg.eti.project2;

public class Comment {
    private static String text = "";

    public static void addComment(String newComment) {
        text += newComment + "\n";
    }

    public static String getText() {
        return text;
    }

    public static void ResetComment() {
        text = "";
    }

}