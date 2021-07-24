package com.test.generics;

public class TestProgrammer {

  static <T extends HardSkills> void testHardSkills(T programmer) {
    programmer.doCodingStuff();
    programmer.doRefactoringStuff();
  }

  static <T extends SoftSkills> void testSoftSkills(T programmer) {
    programmer.discussTicketDifficulty();
  }

  public static void main(String[] args) {
    BadProgrammer programmer = new BadProgrammer();
    testHardSkills(programmer);
    testSoftSkills(programmer);
  }
}
