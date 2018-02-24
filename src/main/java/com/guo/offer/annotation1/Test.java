package com.guo.offer.annotation1;
import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Person person = new Person();
        person.name = "123456";
        person.phone = "chsidhiu";
        BaseResquest<Person> baseResquest = new BaseResquest<Person>();
        baseResquest.body = person;
        Class<?> cls = Person.class;
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            String value = (String)f.get(baseResquest.body);
            if (f.isAnnotationPresent(Encrypt.class)) {
                value += "654321";
                f.set(baseResquest.body, value);
                System.out.println("****************  "+f.get(baseResquest.body));
            }
            System.out.println(f.get(baseResquest.body));
            System.out.println(f);
            System.out.println(f.getName());
        }
    }

}
