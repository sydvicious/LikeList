package com.sydpolk.likelist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static java.lang.System.exit;

@SpringBootApplication
public class LikeList implements CommandLineRunner {

    public static final Scanner scanner = new Scanner(System.in);

    private final ComparisonQueue queue;

    public LikeList(final ComparisonQueue queue) {
        this.queue = queue;
    }

    public static void main(final String[] args) {
        SpringApplication.run(LikeList.class, args);
        exit(0);
    }

    @Override
    public void run(String... args) throws Exception {
        String item = "";
        while (true) {
            System.out.println("Please type an item to add: ");
            item = scanner.nextLine();
            if (item.equals("done")) {
                break;
            }
            queue.add(item);
        }
        queue.output();
    }
}
