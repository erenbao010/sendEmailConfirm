package com.example.CTGTDL.chapter7;

public class TestDrive {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        A a1 = new C();
        D d = new D();
        A a3 = new D();
        a.m1();
        b.m1();
        c.m2();
        a1.m3();
        A a2 = new B();
        a2.m1();
    }

}
 class A {
    int num = 7;
    void m1() {
        System.out.println("A m1");
    }
    void m2() {
        System.out.println("A m2");
    }
    void m3() {
        System.out.println("A m3");
    }
}
class B extends A {
    @Override
    void m1() {
        System.out.println("Bs m1");
    }
}
class C extends B{
    @Override
    void m3() {
        System.out.println("C m3");
    }
}
class D extends C {
    void m3() {
        System.out.println("D m3");
    }
}
