import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person {
    Person(){}
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    private String name;
    private int age;

    public String get_name(){
        return this.name;
    }
    public int get_age(){
        return this.age;
    }
}
public class Cmp_to_person_28 {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("tom", 20));
        persons.add(new Person("jack", 10));
        persons.add(new Person("lucy", 30));
        persons.add(new Person("david", 25));
        System.out.println("排序前：");
        for(Person per: persons){
            System.out.println("姓名：" + per.get_name() + " 年龄：" + per.get_age());
        }
        persons.sort(Comparator.comparing(Person::get_age));
        System.out.println("排序后：");
        for(Person per: persons){
            System.out.println("姓名：" + per.get_name() + " 年龄：" + per.get_age());
        }
    }
}
