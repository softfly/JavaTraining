package training.java6.ocp.io.bin;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleTraining {

    private static final String USERPROMT = "Enter username:";

    private static final String PASSPROMT = "Password:";

    private static final String VERIFYPROMT = "Verify password:";

    public static void main(String[] args) throws IOException {
        Console console = System.console();
        if (console == null) {
            throw new IOException("Console not available");
        }

        String username = console.readLine("%18s ", USERPROMT);
        char[] password = console.readPassword("%18s ", PASSPROMT);
        char[] verify = console.readPassword("%18s ", VERIFYPROMT);
        if (password == null || !Arrays.equals(password, verify)) {
            System.out.println("Passwords do not match");
            return;
        }
        if (!Arrays.equals(password, "qwerty123".toCharArray())) {
            System.out.println("Invalid login");
            return;
        }
        System.out.println("Login successful!");
    }

    public void test() {
        Console con = System.console();
        if (con != null) {
            Scanner sc = new Scanner(con.reader());

        }
    }

}
