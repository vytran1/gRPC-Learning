package section5;

import com.google.protobuf.InvalidProtocolBufferException;
import com.vytran.models.sec05.v2.Television;
import com.vytran.models.sec05.v2.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import section5.parser.V1Parser;
import section5.parser.V2Parser;

public class V2VersionCompatibility {


    private static final Logger log = LoggerFactory.getLogger(V2VersionCompatibility.class);

    public static void main(String[] args) throws InvalidProtocolBufferException {

        var tv = Television.newBuilder()
                .setBrand("Panasonic")
                .setModel(2003)
                .setType(Type.HD)
                .build();

        V1Parser.parse(tv.toByteArray());
        V2Parser.parse(tv.toByteArray());


    }

}
