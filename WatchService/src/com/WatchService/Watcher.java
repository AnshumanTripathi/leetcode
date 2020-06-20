package com.WatchService;

import com.sun.nio.file.SensitivityWatchEventModifier;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Watcher implements Runnable {
  private final WatchService watchService;

  public Watcher() throws IOException{
    watchService = FileSystems.getDefault().newWatchService();
  }

  public void register(final String filePath) throws IOException{
      final Path path = Paths.get(filePath);
      WatchEvent.Kind[] events = {StandardWatchEventKinds.ENTRY_MODIFY};
      path.register(watchService, events, SensitivityWatchEventModifier.HIGH);
  }

  @Override
  public void run() {
    while(true) {
      try {
        WatchKey wk = watchService.take();
        for (WatchEvent<?> event : wk.pollEvents()) {
          System.out.println(event.kind().name());
          WatchEvent<Path> eventPath = (WatchEvent<Path>) event;
          Path file = eventPath.context();

          if (file.toString().equalsIgnoreCase("test.txt")) {
          }
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
