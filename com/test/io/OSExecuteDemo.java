package com.test.io;

import com.test.util.OSExecute;
import java.util.List;

public class OSExecuteDemo {

  public static void main(String[] args) {
    List<String> list = OSExecute.command(
        "javap -cp C:\\Users\\epopov\\IdeaProjects\\ThinkingInJava\\"
            + "out\\production\\ThinkingInJava com.test.io.OSExecuteDemo");

    for (String s : list) {
      System.out.println(s);
    }
  }
}
