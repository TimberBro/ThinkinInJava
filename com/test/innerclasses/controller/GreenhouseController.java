package com.test.innerclasses.controller;

public class GreenhouseController {
  public static void main(String[] args) {
    GreenhouseControls gc = new GreenhouseControls();
    // Instead of hard - wiring , you could parse
    // configuration information from a text file here:
    gc.initialize("com\\test\\innerclasses\\controller\\Greenhouse.cfg");
    if (args.length == 1) {
      gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
    }
    gc.run();
  }
}
