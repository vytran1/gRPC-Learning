package section5;

import com.google.protobuf.InvalidProtocolBufferException;
import com.vytran.models.sec05.v3.Television;
import com.vytran.models.sec05.v3.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import section5.parser.V1Parser;
import section5.parser.V2Parser;
import section5.parser.V3Parser;

public class V3VersionCompatibility {


    private static final Logger log = LoggerFactory.getLogger(V3VersionCompatibility.class);

    public static void main(String[] args) throws InvalidProtocolBufferException {

        var tv = Television.newBuilder()
                .setBrand("Panasonic")
                .setType(Type.HD)
                .build();

        V1Parser.parse(tv.toByteArray());
        V2Parser.parse(tv.toByteArray());
        V3Parser.parse(tv.toByteArray());


    }

}
