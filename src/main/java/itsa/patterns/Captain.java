package itsa.patterns;

public class Captain {
    private static final Captain INSTANCE = new Captain();

    // Use this static method as skeleton for modifications

    public Captain() {

    }

    public static Captain getCaptain() {
        return Captain.INSTANCE;
    }

    public static void main(String[] args) {

        System.out.println("Trying to make a captain for your team:");
        Captain captain1 = Captain.getCaptain();
        System.out.println(captain1);

        System.out.println("Trying to make another captain for your team:");
        Captain captain2 = Captain.getCaptain();
        System.out.println(captain2);

        if (captain1.equals(captain2)) {
            System.out.println("captain1 and captain2 are same instance.");
        } else {
            System.out.println("captain1 and captain2 are not the same instance.");
        }
    }
}
