package patterns.builder;

/**
 * Created by Razvan on 27.12.2016.
 */
public class Book {
    private String title;
    private String author;
    private String type;

    private Book(Builder b) {
        this.title = b.title;
        this.author = b.author;
        this.type = b.type;
    }

    public static class Builder {
        private String title;
        private String author;
        private String type;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Book build() { return new Book(this); }
    }

    @Override
    public String toString() {
        return this.title + ":" + this.author + ":" + this.type;
    }
}
