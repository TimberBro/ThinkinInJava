package com.test.generics;

import com.test.generics.storycharacters.StoryCharacter;
import com.test.generics.storycharacters.StoryCharacterGenerator;
import com.test.util.New;
import java.util.List;
import java.util.Set;

public class NewTest {
  public static void main(String[] args) {
    List<StoryCharacter> storyCharactersList = New.list();
    for (StoryCharacter character : new StoryCharacterGenerator(5)) {
      storyCharactersList.add(character);
    }
    System.out.println(storyCharactersList);
    Set<Fibonacci> fibonacciSet = New.set();
    fibonacciSet.add(new Fibonacci());
    System.out.println(fibonacciSet);
  }
}
