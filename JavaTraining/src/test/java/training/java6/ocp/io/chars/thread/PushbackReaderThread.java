package training.java6.ocp.io.chars.thread;

import java.io.PushbackReader;
import java.io.Reader;

public class PushbackReaderThread implements Runnable {

    protected int id = ++NUM;

    protected static int NUM = 0;

    /**
     * Limit max chars in row line.
     */
    protected final static int LIMIT_MAX = String.valueOf(Long.MAX_VALUE).length();

    protected PushbackReader r;

    public PushbackReaderThread(Reader r) {
        this.r = new PushbackReader(r, 100);
    }

    @Override
    public void run() {
        try {
            while (r.ready()) {
                int c = r.read();
                if (c != -1) {
                    char[] cb = new char[LIMIT_MAX];
                    for (int i = 0; i < LIMIT_MAX; i++) {
                        if (c == -1) {
                            break;
                        } else if ((char) c == '\n') {
                            // cb[i] = '\n';
                            break;
                        } else {
                            cb[i] = (char) c;
                            c = r.read();
                        }
                        if (i > LIMIT_MAX) {
                            throw new RuntimeException(
                                    new StringBuilder("overflow max line=").append(LIMIT_MAX).toString());
                        }
                    }
                    System.out.println(new StringBuilder("Reader").append(id).append(": ").append(cb));
                    Integer a = Integer.parseInt(String.valueOf(cb).trim());
                    if (a > 0) {
                        String s = --a + String.valueOf('\n');
                        r.unread(s.toCharArray());
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
