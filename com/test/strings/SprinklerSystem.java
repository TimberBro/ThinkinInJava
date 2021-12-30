package com.test.strings;

class WaterSource {
  private String s;

  WaterSource() {
    System.out.println("WaterSource()");
    s = "Constructed";
  }

  public String toString() {
    return s;
  }
}

public class SprinklerSystem {
  private String valve1, valve2, valve3, valve4;
  private WaterSource source = new WaterSource();
  private int i;
  private float f;

  public String toString() {
    return "valve1 = "
        + valve1
        + " "
        + "valve2 = "
        + valve2
        + " "
        + "valve3 = "
        + valve3
        + " "
        + "valve4 = "
        + valve4
        + "\n"
        + "i = "
        + i
        + " "
        + "f = "
        + f
        + " "
        + "source = "
        + source;
  }

  public static void main(String[] args) {
    SprinklerSystem sprinklers = new SprinklerSystem();
    System.out.println(sprinklers);
  }
}

/*
  I used "javap -c SprinklerSystem.class" in cmd. Get the following output:
  public java.lang.String toString();
    Code:
       0: new           #5                  // class java/lang/StringBuilder
       3: dup
       4: invokespecial #6                  // Method java/lang/StringBuilder."<init>":()V
       7: ldc           #7                  // String valve1 =
       9: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      12: aload_0
      13: getfield      #9                  // Field valve1:Ljava/lang/String;
      16: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      19: ldc           #10                 // String  valve2 =
      21: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      24: aload_0
      25: getfield      #11                 // Field valve2:Ljava/lang/String;
      28: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      31: ldc           #12                 // String  valve3 =
      33: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      36: aload_0
      37: getfield      #13                 // Field valve3:Ljava/lang/String;
      40: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      43: ldc           #14                 // String  valve4 =
      45: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      48: aload_0
      49: getfield      #15                 // Field valve4:Ljava/lang/String;
      52: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      55: ldc           #16                 // String \ni =
      57: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      60: aload_0
      61: getfield      #17                 // Field i:I
      64: invokevirtual #18                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      67: ldc           #19                 // String  f =
      69: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      72: aload_0
      73: getfield      #20                 // Field f:F
      76: invokevirtual #21                 // Method java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
      79: ldc           #22                 // String  source =
      81: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      84: aload_0
      85: getfield      #4                  // Field source:Lcom/test/strings/WaterSource;
      88: invokevirtual #23                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      91: invokevirtual #24                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      94: areturn

    As I can see generated code is not very complicated: there is only one StringBuilder object,
    so I don't see any reason to explicitly use StringBuilder.
 */
