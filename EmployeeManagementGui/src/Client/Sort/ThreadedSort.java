package Client.Sort;


import Client.Sort.Threaded.ThreadedIDSort;
import Client.Sort.Threaded.ThreadedNameSort;
import Client.Sort.Threaded.ThreadedSalarySort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedSort{
   public ThreadedSort(){
       ThreadedIDSort idSort=new ThreadedIDSort();
       ThreadedNameSort nameSort=new ThreadedNameSort();
       ThreadedSalarySort salarySort=new ThreadedSalarySort();

        ExecutorService threadExecutor=Executors.newCachedThreadPool();
        threadExecutor.execute(idSort);
        threadExecutor.execute(nameSort);
        threadExecutor.execute(salarySort);

   }
}

