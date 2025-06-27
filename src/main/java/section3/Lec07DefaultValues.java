package section3;

import com.vytran.models.sec03.Composition;
import com.vytran.models.sec03.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec07DefaultValues {


    private static final Logger log = LoggerFactory.getLogger(Lec07DefaultValues.class);

    public static void main(String[] args) {
        var school = Composition.School.newBuilder().build();

        log.info("{}",school.getId());

        var lib = Library.newBuilder().build();

        log.info("{}",lib.getBooksList());

    }
}
