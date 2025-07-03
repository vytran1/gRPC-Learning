package section5.parser;

import com.google.protobuf.InvalidProtocolBufferException;
import com.vytran.models.sec05.v1.Television;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V1Parser {


    private static final Logger log = LoggerFactory.getLogger(V1Parser.class);

    public static void main(String[] args) {

    }

    public static void parse(byte[] byteArray) throws InvalidProtocolBufferException {
        var tv = Television.parseFrom(byteArray);

        log.info("brand {}",tv.getBrand());
        log.info("year {}",tv.getYear());

    }
}
