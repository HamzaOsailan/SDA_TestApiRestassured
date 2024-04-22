package requests;

import java.util.HashMap;
import java.util.Map;

public class Dummy {

    public static void main(String[] args){
        Map<Object,Object> map01=new HashMap<>();
        map01.put("number1",15);
        map01.put("number2",20);

        System.out.println((int)map01.get("number1") + (int) map01.get("number2"));


        Object number="Hello";
        System.out.println(((String) number).charAt(0));


    }
}
