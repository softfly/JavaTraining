package training.java6.ocp.collection;

import java.io.IOException;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

import training.patterns.producer_consumer.AbstractThreadComunicationDecorator;
import training.patterns.producer_consumer.AbstractThreadManagerDecorator;
import training.patterns.producer_consumer.ConsumerThread;
import training.patterns.producer_consumer.ProducerThread;

public class TransferQueueTraining {

    protected static class TransferProducerThread extends ProducerThread<TransferQueue<Object>> {

        public TransferProducerThread(TransferQueue<Object> out) throws IOException {
            super(out);
        }

        protected static int count = 0;

        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    print("is waiting to transfer...");
                    int count = count();
                    try {
                        out.tryTransfer(count, 20, TimeUnit.SECONDS);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                    print(count);
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

    protected static class TransferConsumerThread extends ConsumerThread<TransferQueue<Object>> {

        public TransferConsumerThread(TransferQueue<Object> in) throws IOException {
            super(in);
        }

        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    print("is waiting to take element...");
                    print(in.poll(1, TimeUnit.MINUTES));
                    try {
                        Thread.sleep(4000);
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
    }

    protected static AbstractThreadManagerDecorator<TransferQueue<Object>, TransferQueue<Object>> threadManagerD =
            new AbstractThreadManagerDecorator<TransferQueue<Object>, TransferQueue<Object>>() {

                @Override
                protected Runnable newWriteThread(TransferQueue<Object> OUT) throws IOException {
                    return new TransferProducerThread(OUT);
                }

                @Override
                protected Runnable newReadThread(TransferQueue<Object> IN) throws IOException {
                    return new TransferConsumerThread(IN);
                }

            };

    protected static AbstractThreadComunicationDecorator<TransferQueue<Object>, TransferQueue<Object>> threadComunicationD =
            new AbstractThreadComunicationDecorator<TransferQueue<Object>, TransferQueue<Object>>(threadManagerD) {

                @Override
                public void main() throws IOException, InterruptedException {
                    TransferQueue<Object> q = new LinkedTransferQueue<Object>();
                    threadDecorator.writeRead(q, q);
                }

            };

    public static void main(String[] args) throws IOException, InterruptedException {
        threadComunicationD.main();
        System.out.println("PROGRAM TERMINATED");
    }

}
