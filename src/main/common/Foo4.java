package common;

import java.util.*;
import java.util.stream.Collectors;

public class Foo4 {

    public static Integer x;

    public static void main(String[] args) {
        Integer i1 = -128, i2 = -128;
        System.out.println("i1 == i2\t" + (i1 == i2));
        Integer i5 = new Integer(-128);
        System.out.println("i1 == i5\t" + (i1 == i5));

        Integer i3 = 127, i4 = 127;
        System.out.println("i3 == i4\t" + (i3 == i4));
        Integer i6 = new Integer(127);
        System.out.println("i3 == i6\t" + (i3 == i6));

        Integer i7 = -129, ii7 = -129;
        System.out.println("i7 == ii7\t" + (i7 == ii7));
        Integer i8 = 128, ii8 = 128;
        System.out.println("i8 == ii8\t" + (i8 == ii8));

        Short s = 1;
        Integer i = 1;
        System.out.println(s.equals(i));

        String s1 = "a", s2 = "a", s3 = new String("a");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        User user = new User();
        Coo coo = new Coo();
        System.out.println("a \t" + user.equals(coo));
        System.out.println(i.equals(user));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        for (int j = 0; j < 10; j++) {
            list.remove(0);
        }

        list.add(1);

        int[] f = new int[]{1, 2, 3, 4};
        int[] ints = Arrays.copyOf(f, 5);
        System.out.println(ints.length);
    }

}

/**
 * name="aa", type=1, age=23
 * name="ab", type=2, age=33
 * name="b", type=1, age=32
 * 按type分组，按人数倒序输出最大age的人和人数
 * name="ab", type=2, age=33, size=2
 * name="b", type=1, age=32, size=1
 */
class User {
    private String name;

    private Integer type;

    private Integer age;

    public User() {
    }

    public User(String name, Integer type, Integer age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", age=" + age +
                '}';
    }
}

class Coo {

}