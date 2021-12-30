package com.test.generics;

public class BadProgrammer implements HardSkills, SoftSkills {

  @Override
  public void doCodingStuff() {
    System.out.println("Write bad code");
  }

  @Override
  public void doRefactoringStuff() {
    System.out.println("Create new bug in legacy code");
  }

  @Override
  public void discussTicketDifficulty() {
    System.out.println("Skip weekly meeting");
  }
}
