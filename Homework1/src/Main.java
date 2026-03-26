public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(1_000);
                System.out.println(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2_000);
                System.out.println(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(3_000);
                System.out.println(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}