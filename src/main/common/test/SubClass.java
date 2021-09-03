package common.test;

public class SubClass extends ParentClass {
    static {
        System.out.println("2.sub static");
    }

    {
        System.out.println("5.sub non static");
    }

    public SubClass() {
        System.out.println("6.sub construct");

    }
}
