/**
 * @Author Heli
 */
public class SingletonJava {

    private SingletonJava INSTANCE;

    private SingletonJava() {

    }

    public synchronized SingletonJava getInstance() {
        // ..
        return INSTANCE;
    }

    public SingletonJava getInstanceV2() {
        if (INSTANCE == null) {
            synchronized (INSTANCE) {
                INSTANCE = new SingletonJava();
            }
        }
        return INSTANCE;
    }
}
