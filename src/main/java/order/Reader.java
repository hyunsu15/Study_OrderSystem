package main.java.order;

import java.util.Scanner;

public class Reader {
    private final Scanner scanner = new Scanner(System.in);

    public int readInt() {
        return scanner.nextInt();
    }

    public String readLine(){
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
