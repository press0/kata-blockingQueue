package message;

/**
 * Created by q on 1/7/14.
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Reader implements Runnable {

    private BlockingQueue<Message> queue;
    private int secondsTimeout;

    public Reader(BlockingQueue<Message> queue, int secondsTimeout) {
        this.queue = queue;
        this.secondsTimeout = secondsTimeout;
    }

    @Override
    public void run() {
        try {
            Message message;
            while (true) {
                message = queue.poll(secondsTimeout, TimeUnit.SECONDS);
                if (message == null) {
                    break;
                }
                System.out.println("READER:   " + message.toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}