package section3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.vytran.models.sec03.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Lec03PerformanceTest {


    private static final Logger log = LoggerFactory.getLogger(Lec03PerformanceTest.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        PersonOuterClass.Person person1 = PersonOuterClass.Person
                .newBuilder()
                .setLastName("TranNguyenVy")
                .setEmail("trannguyenvy@gmail.com")
                .setEmployed(true)
                .setSalary(100000)
                .setBankAccountNumber(3123124124124l)
                .setBalance(-10000)
                .build();


        var jsonPerson = new JsonPerson("TranNguyenVy","vytran@gmail.com",true,100.00,1313131313l,-10000);


        for(int i = 0; i < 10; i++){
            runTest("test proto " + (i + 1),() -> proto(person1));
            runTest("test json " + (i + 1),() -> json(jsonPerson));
        }

    }

    private static void proto(PersonOuterClass.Person person){

        try{

            var byteArray = person.toByteArray();
            PersonOuterClass.Person.parseFrom(byteArray);

        }catch (InvalidProtocolBufferException e){
            throw new RuntimeException(e);
        }

    }

    private static void json(JsonPerson person)  {
        try {
           var byteArray =  objectMapper.writeValueAsBytes(person);
            objectMapper.readValue(byteArray,JsonPerson.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static void runTest(String testName, Runnable runnable){
        var start = System.currentTimeMillis();

        for(int i = 0; i < 100; i++){
            runnable.run();
        }

        var end = System.currentTimeMillis();
        log.info("time take {} for {} -> {}",testName,start,end);

    }

}
