

public class HiloCallback extends Thread{

    // hemos de crear la llamada al callback fuera del metodo run

    Main.Callback callback;
    public HiloCallback(Main.Callback callback) {this.callback = callback;
    }


    @Override
    public void run() {
        /*
         desde la linea 17 hasta la linea 29 es un copy paste  de Hilo
        */
        for (int i = 0; i < 10; i++){
            // vamos a hacer una variable para que tenga un tiempo de sleep
            double tiempoDeDormir = Math.random()*1000;
            ProcessHandle proceso = ProcessHandle.current(); // tiempo de proceso

            System.out.println("Soy la variable HiloCallback, con PID "+ proceso.pid()+" con un ID de:"+getId());
            // al meter el sleep es necesario un try catch
            try {
                sleep((int) tiempoDeDormir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*
        La gran diferencia de esta clase es el callback.
         */
        double resultado = Math.random();
        callback.executeCallback(resultado);

    }
}
