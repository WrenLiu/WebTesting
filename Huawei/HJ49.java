
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class HJ49 {

    private static Semaphore signalAtoB = null;
    private static Semaphore signalBtoC = null;
    private static Semaphore signalCtoD = null;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int num = scanner.nextInt();
            signalAtoB = new Semaphore(0);
            signalBtoC = new Semaphore(0);
            signalCtoD = new Semaphore(0);

            Thread threadA = new Thread(() -> {
                System.out.print('A');
                signalAtoB.release();
            });

            Thread threadB = new Thread(() -> {
                try {
                    signalAtoB.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print('B');
                signalBtoC.release();
            });

            Thread threadC = new Thread(() -> {
                try {
                    signalBtoC.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print('C');
                signalCtoD.release();
            });
            Thread threadD = new Thread(() -> {
                try {
                    signalCtoD.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print('D');
            });



            for (int i = 0; i < num; i++) {

                threadA.run();
                threadB.run();
                threadC.run();
                threadD.run();


            }

            System.out.println();





        }


    }



}
