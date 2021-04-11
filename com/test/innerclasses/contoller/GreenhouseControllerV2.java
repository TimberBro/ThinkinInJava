package com.test.innerclasses.contoller;

public class GreenhouseControllerV2 {
  public static void main(String[] args) {
    GreenhouseControlsMistGenerator gc = new GreenhouseControlsMistGenerator();
    // Instead of hard - wiring , you could parse
    // configuration information from a text file here:
    gc.addEvent(gc.new Bell(900));
    Event[] eventList = {
      gc.new ThermostatNight(0),
      gc.new LightOn(200),
      gc.new LightOff(400),
      gc.new WaterOn(600),
      gc.new WaterOff(800),
      gc.new ThermostatDay(1400),
      gc.new MistGeneratorOn(1500),
      gc.new MistGeneratorOff(1800)
      };
    gc.addEvent(gc.new Restart(2000, eventList));
    if (args.length == 1) {
      gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
    }
    gc.run();
  }
}
