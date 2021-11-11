package com.test.annotations.database;

@DBTable(name = "MEMBER")
public class Member {

  @SQLString(30)
  String firstName;
  @SQLString(50)
  String lastName;
  @SQLInteger
  Integer age;
  @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
  String handle;
  @SQLDate(name = "CREATE_DATE")
  Long createDate;
  static int memberCount;

  public Member() {
    createDate = System.currentTimeMillis();
  }

  public String getHandle() {
    return handle;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String toString() {
    return handle;
  }

  public Integer getAge() {
    return age;
  }
}
