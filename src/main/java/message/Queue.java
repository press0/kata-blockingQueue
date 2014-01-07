package message;

/**
 * Created by q on 1/7/14.
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Queue {

    public static void main(String[] args) {
        final int COUNT = 50;
        final int SECONDS_TIMEOUT = 3;

        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(COUNT * 2);
        Generator generator = new Generator(queue, COUNT);
        Reader consumer = new Reader(queue, SECONDS_TIMEOUT);
        new Thread(generator).start();
        new Thread(consumer).start();
        generator = new Generator(queue, COUNT);
        new Thread(generator).start();
    }

}
