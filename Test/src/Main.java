import java.util.*;

class Quote { //구조체
    public String quote;
    public String author;
    public int id;

    public Quote(String quote, String author, int id) {
        this.quote = quote;
        this.author = author;
        this.id = id;
    }
}

public class Main {
    static void main(String[] args) {
        App app = new App();
        app.run();
    }
}