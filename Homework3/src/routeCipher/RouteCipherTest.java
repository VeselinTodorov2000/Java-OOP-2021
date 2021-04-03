package routeCipher;

public class RouteCipherTest {
    public static void main(String[] args) {
        RouteCipher r = new RouteCipher(-3);
        String hello = "VESOPISHENULI";
        System.out.println(r.encrypt(hello));
        System.out.println(r.decrypt("VOSNIXXLEISEPHU"));
        System.out.println(r.decrypt("XLEISEVOSNIXUHP"));
    }
}
