package hello.core.singleton;

public class SingletonService {
    private static SingletonService singletonService;

    private SingletonService() {}

    public static SingletonService getInstance() {
        if (singletonService == null) {
            singletonService = new SingletonService();
        }
        return singletonService;
    }

    public void logic() {
        System.out.println("싱글톤 로직을 수행함");
    }
}

