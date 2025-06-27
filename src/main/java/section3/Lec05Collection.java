package section3;

import com.vytran.models.sec03.Book;
import com.vytran.models.sec03.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

public class Lec05Collection {


    private static final Logger log = LoggerFactory.getLogger(Lec05Collection.class);

    public static void main(String[] args) {
        var book1 = Book.newBuilder()
                .setTitle("HarryPorter Part1")
                .setAuthor("JK Rowling")
                .setPublicationYear(2025)
                .build();

        var book2 = Book.newBuilder()
                .setTitle("HarryPorter Part2")
                .setAuthor("JK Rowling")
                .setPublicationYear(2026)
                .build();

        var book3 = Book.newBuilder()
                .setTitle("HarryPorter Part3")
                .setAuthor("JK Rowling")
                .setPublicationYear(2027)
                .build();


        var library1 = Library.newBuilder().setName("Fantasy Library")
//                .addBooks(book1)
//                .addBooks(book2)
//                .addBooks(book3)
//                .addAllBooks(List.of(book1,book2,book3))
                .addAllBooks(Set.of(book1,book2,book3))
                .build();


        log.info("{}",library1);


    }
}
