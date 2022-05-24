package hello.core.singleton;

public class SingletonService {

    // 자기 자신 선언
    // private static 으로 하면, class 레벨로 올라가기 때문에 딱 한개만 존재
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // private 생성자를 만듦으로써 외부에서 new로 호출하지 못하게 제한
    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    public static void main(String[] args) {
        SingletonService singletonService1 = new SingletonService();
        SingletonService singletonService2 = new SingletonService();
    }
}
