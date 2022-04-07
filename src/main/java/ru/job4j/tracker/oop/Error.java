package ru.job4j.tracker.oop;

import java.sql.SQLOutput;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Error is active: " + active);
        System.out.println("Status error: " + status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error error1 = new Error(true, 1, "Overheat");
        error1.printInfo();
        Error error2 = new Error(false, 0, "No errors");
        error2.printInfo();
    }
}
