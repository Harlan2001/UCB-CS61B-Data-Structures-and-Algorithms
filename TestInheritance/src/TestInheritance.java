class Parent {
    private int secret;

    public Parent(int secret){
        this.secret = secret;
    }
    private void privateMethod() {
        System.out.println("Parent's privateMethod");
    }

    public int getSecret() {
        System.out.println("Parent getSecret called");
        return secret;
    }
}

class Child extends Parent {
    private int secret;

    public Child(int secret){
        super(secret);
        this.secret = secret * 2;
    }

    @Override
    public int getSecret() {
        System.out.println("Child getSecret called");
        // 调用父类的 getSecret()
        int parentSecret = super.getSecret();
        System.out.println("Parent secret from Child: " + parentSecret);
        return secret;
    }

    // 子类没有重写 getSecret()
    void test() {
        // System.out.println(secret); // 编译错误，不能访问 private 变量
        // privateMethod();            // 编译错误，不能访问 private 方法

        System.out.println("Calling getSecret() from Child.test(): " + getSecret());
    }
}

class ChildOverride extends Parent {
    private int secret = 99;

    public ChildOverride(int secret) {
        super(secret);
    }

    @Override
    public int getSecret() {
        System.out.println("ChildOverride getSecret called");
        return secret;
    }
}

public class TestInheritance {
    public static void main(String[] args) {
        Parent p = new Parent(40);
        System.out.println("Parent getSecret(): " + p.getSecret());

        Child c = new Child(20);
        System.out.println("Child getSecret(): " + c.getSecret());
        System.out.println("Parent getSecret(): " + p.getSecret());
        c.test();

        ChildOverride co = new ChildOverride(60);
        System.out.println("ChildOverride getSecret(): " + co.getSecret());
    }
}
