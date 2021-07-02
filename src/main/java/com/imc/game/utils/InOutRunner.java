package com.imc.game.utils;

import java.util.Scanner;

public class InOutRunner {
  private final Scanner inputScanner;

  public InOutRunner() {
    this.inputScanner = new Scanner(System.in);
  }

  public synchronized String getString() {
    return inputScanner.next();
  }

  public synchronized Integer getInt() {
    return inputScanner.nextInt();
  }

  public synchronized void printWithNewLine(String value) {
    System.out.println(value);
    System.out.flush();
  }

  public synchronized void print(String value) {
    System.out.print(value);
    System.out.flush();
  }
}
