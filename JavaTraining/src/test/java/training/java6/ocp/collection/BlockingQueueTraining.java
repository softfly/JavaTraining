package training.java6.ocp.collection;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;
import training.patterns.producer_consumer.ConsumerThread;
import training.patterns.producer_consumer.ProducerThread;

public class BlockingQueueTraining {

    protected static class BlockingProducerThread extends ProducerThread<BlockingQueue<Object>> {

        public BlockingProducerThread(BlockingQueue<Object> out) throws IOException {
            super(out);
        }

        protected static int count = 0;

        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    int count = count();
                    print(count);
                    out.offer(count, 10, TimeUnit.SECONDS);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                printTerminated();
            }
        }

        protected static synchronized int count() {
            return ++count;
        }
    }

    protected static class BlockingConsumerThread extends ConsumerThread<BlockingQueue<Object>> {

        public BlockingConsumerThread(BlockingQueue<Object> in) throws IOException {
            super(in);
        }

        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        print(in.poll(1, TimeUnit.MINUTES));
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                    Thread.yield();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                printTerminated();
            }
        }
    }

    protected static AbstractThreadManagerDecorator<BlockingQueue<Object>, BlockingQueue<Object>> threadManagerD =
            new AbstractThreadManagerDecorator<BlockingQueue<Object>, BlockingQueue<Object>>() {

                @Override
                protected Runnable newWriteThread(BlockingQueue<Object> OUT) throws IOException {
                    return new BlockingProducerThread(OUT);
                }

                @Override
                protected Runnable newReadThread(BlockingQueue<Object> IN) throws IOException {
                    return new BlockingConsumerThread(IN);
                }

            };

    protected static AbstractThreadComunicationDecorator<BlockingQueue<Object>, BlockingQueue<Object>> threadComunicationD =
            new AbstractThreadComunicationDecorator<BlockingQueue<Object>, BlockingQueue<Object>>(threadManagerD) {

                @Override
                public void main() throws IOException, InterruptedException {
                    BlockingQueue<Object> q = new LinkedBlockingQueue<Object>(5);
                    threadDecorator.writeRead(q, q);
                }

            };

    public static void main(String[] args) throws IOException, InterruptedException {
        threadComunicationD.main();
        System.out.println("PROGRAM TERMINATED");
    }

}
