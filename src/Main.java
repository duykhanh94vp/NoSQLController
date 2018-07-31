import com.popeye.kvdb.base.Config;
import com.popeye.kvdb.base.IDataController;
import com.popeye.kvdb.base.RedisController;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        IDataController dataController = null;
        if(Config.getInstance().get("DB_TYPE").equals("redis")){
            dataController = new RedisController();
        }

        dataController.init();
        //dataController.set("name1", "không biết");
        System.out.println(dataController.get("name1"));
        System.out.println(dataController.get("name2"));

        System.out.println(System.getProperty("user.dir"));
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"khanh\",\"age\":100,\"subject\":{\"id\":1,\"name\":\"toan\"}}";

        //map json to student
        try {
            Student student = mapper.readValue(jsonString, Student.class);

            System.out.println(student);

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);

            System.out.println(jsonString);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Student {
    private String name;
    private int age;
    private Subject subject;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String toString() {
        return "Student [ name: " + name + ", age: " + age + " ]";
    }
}

class Subject {
    public int id;
    public String name;
}
