package section3;

import com.vytran.models.sec03.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec02Serialization {


    private static final Logger log = LoggerFactory.getLogger(Lec02Serialization.class);
    private static final Path PATH = Path.of("param.out");

    public static void main(String[] args) throws IOException {
        PersonOuterClass.Person person1 = PersonOuterClass.Person
                .newBuilder()
                .setLastName("TranNguyenVy")
                .setEmail("trannguyenvy@gmail.com")
                .setEmployed(true)
                .setSalary(100000)
                .setBankAccountNumber(3123124124124l)
                .setBalance(-10000)
                .build();

        serialize(person1);
        PersonOuterClass.Person person2 = deserialize();

        log.info("{}",person2);




    }


    public static void serialize(PersonOuterClass.Person person) throws IOException {
        person.writeTo(Files.newOutputStream(PATH));
    }

    public static PersonOuterClass.Person deserialize() throws IOException {
        return PersonOuterClass.Person.parseFrom(Files.newInputStream(PATH));
    }


}
