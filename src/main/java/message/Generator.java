package message;

/**
 * Created by q on 1/7/14.
 */

import java.util.concurrent.BlockingQueue;

public class Generator implements Runnable {

    private BlockingQueue<Message> queue;
    private int count;

    public Generator(BlockingQueue<Message> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            Message message = new Message();
            try {
                queue.put(message);
                System.out.println("GENERATOR:" + message.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}