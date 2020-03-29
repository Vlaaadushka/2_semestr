package seminar_2

import org.junit.Test

import java.util.concurrent.ConcurrentSkipListSet
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executor
import java.util.concurrent.Executors

import static org.junit.Assert.assertEquals

public class SingeltoneTest {

    @Test
    public void getSingleTon()  {
        int Flow = 100000;

        ConcurrentSkipListSet<Integer> listSet = new ConcurrentSkipListSet<>();
        CountDownLatch startCdl = new CountDownLatch(Flow);
        CountDownLatch endCdl = new CountDownLatch(Flow);
        Executor executor = Executors.newFixedThreadPool(Flow);

        for (int i = 0; i < Flow; i++) {
            executor.execute(() -> {
                startCdl.countDown();
                try {
                    startCdl.await();
                } catch (InterruptedException e) {
                }
                Singeltone singleton = Singeltone.getSingleTon();
                listSet.add(singleton.getId());
                endCdl.countDown();
            });
        }
        try {
            endCdl.await();
        } catch (InterruptedException e) {
        }

        assertEquals(1, listSet.size());
    }
}
    
