public class Main {
    public static void main(String[] args) {
        // initialize thread 1
        Thread t1 = new Thread(() -> {
            countUp(0);
        });
        t1.start();
        try {
            t1.join(); // t1 completes before t2 begins
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // initialize thread 2
        Thread t2 = new Thread(() -> {
            countDown(20);
        });
        t2.start();
        try {
            t2.join(); // wait for t2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // function 1
    public static void countUp(int n) {
        for (; n < 20; n++) {
            System.out.println(n); // print each integer going up
        }
        System.out.println(n + " -- Counting up complete");
    }   // correct implementation of the first counting function (up to 20)

    // function 2
    public static void countDown(int n) {
        for (; n > 0; n--) {
            System.out.println(n); // print each integer going down
        }
        System.out.println(n + " -- Count-down complete");
    }   // correct implementation of function 2 (down to 0)
}
