package com.test.io;

import com.test.util.TextFile;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

public class WordOccurrence {

  private String value;
  private int counter;

  WordOccurrence(String value, int counter) {
    this.value = value;
    this.counter = counter;
  }

  WordOccurrence(Element word) {
    value = word.getFirstChildElement("value").getValue();
    counter = Integer.parseInt(word.getFirstChildElement("totalcount").getValue());
  }

  public Element getXML() {
    Element word = new Element("word");
    Element value = new Element("value");
    value.appendChild(this.value);
    Element counter = new Element("totalcount");
    counter.appendChild(String.valueOf(this.counter));
    word.appendChild(value);
    word.appendChild(counter);
    return word;
  }

  public static void format(OutputStream os, Document doc) throws Exception {
    Serializer serializer = new Serializer(os, "ISO-8859-1");
    serializer.setIndent(4);
    serializer.setMaxLength(60);
    serializer.write(doc);
    serializer.flush();
  }

  static Map<String, Integer> countWords(String fileName) {
    Map<String, Integer> wordMap = new HashMap<>();
    LinkedList<String> list = new LinkedList<>(new TextFile(fileName, "\\W+"));
    for (String word : list) {
      if (wordMap.get(word) == null) {
        wordMap.put(word, 1);
      } else {
        int ref = wordMap.get(word);
        wordMap.put(word, ++ref);
      }
    }
    return wordMap;
  }

  public static void main(String[] args) throws Exception {
    Map<String, Integer> test = countWords("com\\test\\io\\WordOccurrence.java");
    Element root = new Element("words");
    for (String s : test.keySet()) {
      root.appendChild(new WordOccurrence(s, test.get(s)).getXML());
    }
    Document doc = new Document(root);
    format(System.out, doc);
    format(new BufferedOutputStream(new FileOutputStream("com\\test\\xml\\Words.xml")), doc);
  }
}

