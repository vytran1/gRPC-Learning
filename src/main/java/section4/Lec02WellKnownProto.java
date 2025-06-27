package section4;

import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.vytran.models.sec04.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public class Lec02WellKnownProto {


    private static final Logger log = LoggerFactory.getLogger(Lec02WellKnownProto.class);

    public static void main(String[] args) {
            var sample = Sample.newBuilder()
                    .setAge(Int32Value.of(21))
                    .setLoginTime(Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond()).build())
                    .build();




    }
}
