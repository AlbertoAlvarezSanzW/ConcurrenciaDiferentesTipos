

public class Hilo extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            // vamos a hacer una variable para que tenga un tiempo de sleep
            double tiempoDeDormir = Math.random()*1000;
            ProcessHandle proceso = ProcessHandle.current(); // tiempo de proceso

            System.out.println("Soy la variable Hilo, con PID "+ proceso.pid()+" con un ID de:"+getId());
            // al meter el sleep es necesario un try catch
            try {
                sleep((int) tiempoDeDormir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
