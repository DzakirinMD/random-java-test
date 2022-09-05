package questions.oopconcept;

/**
 * An interface in Java is a blueprint of a class. It has static constants and abstract methods.
 *
 * There are mainly three reasons to use interface:
 *      It is used to achieve abstraction.
 *      By interface, we can support the functionality of multiple inheritance.
 *      It can be used to achieve loose coupling.
 *
 * Abstraction is a process of hiding the implementation details and showing only functionality to the user.
 */
interface SampleInterface {
    public void call();
}

//@Repository
//public interface CompanyRepository extends JpaRepository<Company, Long> {
//}

class AndroidPhone implements SampleInterface {

    @Override
    public void call() {
        System.out.println("Calling 911");
    }
}

class GuavaPhone implements SampleInterface {

    @Override
    public void call() {
        System.out.println("Calling Ambulance !");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {

        AndroidPhone androidPhone = new AndroidPhone();
        GuavaPhone guavaPhone = new GuavaPhone();

        androidPhone.call();
        guavaPhone.call();
    }
}

