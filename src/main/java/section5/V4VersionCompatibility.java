package section5;


import com.google.protobuf.InvalidProtocolBufferException;
import com.vytran.models.sec05.v4.Television;
import com.vytran.models.sec05.v4.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import section5.parser.V1Parser;
import section5.parser.V2Parser;
import section5.parser.V3Parser;
import section5.parser.V4Parser;

public class V4VersionCompatibility {


    private static final Logger log = LoggerFactory.getLogger(V4VersionCompatibility.class);

    public static void main(String[] args) throws InvalidProtocolBufferException {


        var tv = Television.newBuilder()
                .setBrand("Panasonic")
                .setType(Type.HD)
                .setPrice(2000)
                .build();

        V1Parser.parse(tv.toByteArray());
        V2Parser.parse(tv.toByteArray());
        V3Parser.parse(tv.toByteArray());
        V4Parser.parse(tv.toByteArray());
    }
}
