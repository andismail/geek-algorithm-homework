package common.test;

public class ParentClass {
    static {
        System.out.println("1.parent static");
    }

    {
        System.out.println("3.parent non static");
    }

    public ParentClass() {
        System.out.println("4.parent construct");

    }
}
