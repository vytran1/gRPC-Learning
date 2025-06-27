package section3;

import com.vytran.models.sec03.Composition;

public class Lec04Composition {

    public static void main(String[] args) {

        //create student
        var address = Composition.Address.newBuilder()
                .setStreet("99/9 khu phố 1 ")
                .setCity("TP Bien Hoa")
                .setState("Dong Nai")
                .build();

        var student = Composition.Student
                .newBuilder()
                .setAddress(address)
                .setName("TranNguyeVy")
                .build();

        var school = Composition.School
                .newBuilder()
                .setId(123)
                .setAddress(address)
                .setName("Nguyen Trai")
                .build();


    }

}
