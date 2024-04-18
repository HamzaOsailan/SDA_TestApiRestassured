package test_data;

import java.util.HashMap;
import java.util.Map;

public class Homework_08_test_data {

    public static Map<String,Object> expectedDataMap(Integer id,String job,String name,String createdAt){
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("id",id);
        expectedData.put("job",job);
        expectedData.put("name",name);
        expectedData.put("createdAt",createdAt);
        return expectedData;
    }
}
