package ueg.estrutura_de_dados.bimestre2.threads;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rootcg on 19/06/15.
 */
public class Main {
    public static void main(String[] args) {

        PrintTask print1 = new PrintTask("print1");
        PrintTask print2 = new PrintTask("print2");
        PrintTask print3 = new PrintTask("print3");


        // create ExecutorService to manage threads
        ExecutorService threadExecutor = Executors.newCachedThreadPool();


        // start threads and place in
        threadExecutor.execute(print1);
        threadExecutor.execute(print2);
        threadExecutor.execute(print3);
        threadExecutor.shutdown();

    }
}

