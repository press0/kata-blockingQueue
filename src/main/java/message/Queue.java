package message;

/**
 * Created by q on 1/7/14.
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Queue {

    public static void main(String[] args) {
        final int COUNT = 5;
        final int SECONDS_TIMEOUT = 3;

        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(COUNT * 2);
        new Thread(new Generator(queue, COUNT)).start();
        new Thread(new Reader(queue, SECONDS_TIMEOUT)).start();
        new Thread(new Generator(queue, COUNT)).start();
    }

}
