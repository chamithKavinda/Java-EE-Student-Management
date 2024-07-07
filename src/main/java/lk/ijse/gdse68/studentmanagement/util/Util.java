package lk.ijse.gdse68.studentmanagement.util;

import java.util.UUID;

public class Util {
    public static String idGenerate(){
        return UUID.randomUUID().toString();
    }
}
