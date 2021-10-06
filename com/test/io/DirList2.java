package com.test.io;

import com.test.util.TextFile;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.Collections;

public class DirList2 {

  public static FilenameFilter filter(final String[] args) {
    // Creation of anonymous inner class:

    return new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return !Collections
            .disjoint(new TextFile((dir + FileSystems.getDefault().getSeparator() + name), "\\W+"),
                Arrays.asList(args));
      }
    }; // End of anonymous inner class
  }

  public static void main(String[] args) {
    // Path changed to search in specific directory
    File path = new File("com//test//io");
    String[] list;
    if (args.length == 0) {
      list = path.list();
    } else {
      list = path.list(filter(args));
    }
    Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
    for (String dirItem : list) {
      System.out.println(dirItem);
    }
  }
}
