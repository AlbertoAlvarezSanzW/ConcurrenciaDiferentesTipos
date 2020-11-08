import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        concurrenciaConHilo();
        concurrenciaConRunnable();
        concurrenciaConRunnableDouble();
        concurrenciaConCallback();
    }


    interface Callback {
        void executeCallback(Double result);
    }

    private static void concurrenciaConHilo(){
        Hilo t1 = new Hilo();
        t1.start();
        Hilo t2 = new Hilo();
        t2.start();
    }

    private static void concurrenciaConRunnable(){
        Runnable runnable = () -> {
            for(int i=0; i<10; i++) {
                double sleepingTime = Math.random() * 1000;
                ProcessHandle processHandle = ProcessHandle.current();

                System.out.println("Soy la variable concurrenciaConRunnable con PID: " + processHandle.pid() + ", mi id es " + Thread.currentThread().getId() + ". mi iteración es:" + i + " y dormiré " + sleepingTime + " segundos");
                try {
                    sleep((int) sleepingTime);
                } catch(Exception exception) {
                    exception.printStackTrace();
                }
            }
        };
        runnable.run();
        runnable.run();
    }
    // este se ejecurata despues de concurrenciaConRunnable
    private static void concurrenciaConRunnableDouble(){
        Runnable runnable = () -> {
            for(int i=0; i<10; i++) {
                double sleepingTime = Math.random() * 1000;
                ProcessHandle processHandle = ProcessHandle.current();

                System.out.println("Soy la variable concurrenciaConRunnableDouble con PID: " + processHandle.pid() + ", mi id es " + Thread.currentThread().getId() + ". mi iteración es:" + i + " y dormiré " + sleepingTime + " segundos");
                try {
                    sleep((int) sleepingTime);
                } catch(Exception exception) {
                    exception.printStackTrace();
                }
            }
        };
        runnable.run();
        runnable.run();
    }
    // este se ejecuta al final de todo.
    private static void concurrenciaConCallback() {
        Callback callback1 = result -> System.out.println("Ejecutándose el callback1, de ThreadCustomCallback t1 con resultado = " + result);
        Callback callback2 = result -> System.out.println("Ejecutándose el callback2, de ThreadCustomCallback t2 con resultado = " + result);

        Thread t1 = new HiloCallback(callback1);
        t1.start();
        Thread t2 = new HiloCallback(callback2);
        t2.start();
    }

}
