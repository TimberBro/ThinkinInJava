package com.test.concurrency;

public class SerialNumberGenerator {
  // We don't need to use volatile here, because nextSerialNumber is not synchronized
  private static int serialNumber = 0;

  public static synchronized int nextSerialNumber() {
    return serialNumber++; // Not thread-safe
  }
}
