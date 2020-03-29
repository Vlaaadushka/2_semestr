package seminar_2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Singeltone {

    private static AtomicReference<Singeltone> INSTANCE = new AtomicReference<>();
    final int id;
    private static final AtomicInteger counter = new AtomicInteger(0);

    private Singeltone(int id) {
        this.id = id;
    }

    public static Singeltone getSingleTon(){
        INSTANCE.compareAndSet(null, new Singeltone(counter.getAndIncrement()));
        return INSTANCE.get();
    }

    public int getId() {
        return id;
    }
}
