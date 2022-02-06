package oracle.hiding;

/**
 * @Author Heli
 */
public class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The static method in oracle.hiding.Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in oracle.hiding.Cat");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
    }
}
