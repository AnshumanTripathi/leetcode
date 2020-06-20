package com.WatchService;

import java.io.IOException;


public class MyWatchService {
  public static void main(String[] args) {
    try {
      final Watcher watcher = new Watcher();
      watcher.register("/Users/anshuman.tripat/playground/WatchService/src/com/WatchService");
      final Thread watcherThread = new Thread(watcher);
      watcherThread.start();
      System.out.println("Apni main thread chal hi rhi h");
      watcherThread.join();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
