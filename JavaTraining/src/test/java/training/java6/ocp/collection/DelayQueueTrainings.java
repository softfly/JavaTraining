package training.java6.ocp.collection;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;
import training.patterns.producer_consumer.ConsumerThread;
import training.patterns.producer_consumer.ProducerThread;

public class DelayQueueTrainings {

    protected static class SampleDelay implements Delayed {

        private static Integer id_num = 0;

        private int id;
        
        private long startTime;

        public SampleDelay(long delay, TimeUnit unit) {
            super();
            this.startTime = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(delay, unit);
            this.id = ++id_num;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(startTime, o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long diff = startTime - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public String toString() {
            return "SampleDelay [id=" + id + ", startTime=" + startTime + "]";
        }

    }

    protected static class DelayProducerThread extends ProducerThread<BlockingQueue<SampleDelay>> {

        public DelayProducerThread(BlockingQueue<SampleDelay> out) throws IOException {
            super(out);
        }

        protected static int count = 0;

        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    SampleDelay d = new SampleDelay(1, TimeUnit.SECONDS);
                    print(d);
                    out.offer(d, 10, TimeUnit.SECONDS);
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

    protected static class BlockingConsumerThread extends ConsumerThread<BlockingQueue<SampleDelay>> {

        public BlockingConsumerThread(BlockingQueue<SampleDelay> in) throws IOException {
            super(in);
        }

        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        print(in.poll(1, TimeUnit.MINUTES));
                        Thread.sleep(1000);
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

    protected static AbstractThreadManagerDecorator<BlockingQueue<SampleDelay>, BlockingQueue<SampleDelay>> threadManagerD =
            new AbstractThreadManagerDecorator<BlockingQueue<SampleDelay>, BlockingQueue<SampleDelay>>() {

                @Override
                protected Runnable newWriteThread(BlockingQueue<SampleDelay> OUT) throws IOException {
                    return new DelayProducerThread(OUT);
                }

                @Override
                protected Runnable newReadThread(BlockingQueue<SampleDelay> IN) throws IOException {
                    return new BlockingConsumerThread(IN);
                }

            };

    protected static AbstractThreadComunicationDecorator<BlockingQueue<SampleDelay>, BlockingQueue<SampleDelay>> threadComunicationD =
            new AbstractThreadComunicationDecorator<BlockingQueue<SampleDelay>, BlockingQueue<SampleDelay>>(
                    threadManagerD) {

                @Override
                public void main() throws IOException, InterruptedException {
                    BlockingQueue<SampleDelay> q = new DelayQueue<SampleDelay>();
                    threadDecorator.writeRead(q, q);
                }

            };

    public static void main(String[] args) throws IOException, InterruptedException {
        threadComunicationD.main();
        System.out.println("PROGRAM TERMINATED");
    }

}
