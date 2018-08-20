package training.patterns.producer_consumer;

import java.io.IOException;

public abstract class AbstractThreadComunicationDecorator<IN, OUT> {

	protected AbstractThreadManagerDecorator<IN, OUT> threadDecorator;

	public AbstractThreadComunicationDecorator(AbstractThreadManagerDecorator<IN, OUT> threadDecorator) {
		this.threadDecorator = threadDecorator;
	}

	public abstract void main() throws IOException, InterruptedException;

}
