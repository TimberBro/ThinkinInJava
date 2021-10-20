package com.test.innerclasses.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GreenhouseControls extends Controller {

  @SuppressWarnings("unchecked")
  public void initialize(String configPath) {
    Map<String, Long> settingsMap = readConfig(configPath);
    Iterator<Entry<String, Long>> iterator = settingsMap.entrySet().iterator();
    while (iterator.hasNext()) {
      Entry<String, Long> currentSetting = iterator.next();
      String className = currentSetting.getKey();
      Class<Event> cls = null;
      Class<?> outer = GreenhouseControls.class;
      String type = outer.getName() + "$" + className;
      try {
        cls = (Class<Event>) Class
            .forName(type);
        Constructor<Event> ctor = cls.getConstructor(outer, long.class);
        addEvent(ctor.newInstance(GreenhouseControls.this, currentSetting.getValue()));
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
        e.printStackTrace();
      }
    }
  }

  private Map<String, Long> readConfig(String configPath) {
    Map<String, Long> settingsMap = new HashMap<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(configPath));
      String currentString;
      while ((currentString = reader.readLine()) != null) {
        settingsMap
            .put(currentString.split(":")[0], Long.valueOf(currentString.split(":")[1].trim()));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return settingsMap;
  }

  private boolean light = false;

  public class LightOn extends Event {

    public LightOn(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Put hardware control code here to
      // physically turn on the light,
      light = true;
    }

    public String toString() {
      return "Light is on";
    }
  }

  public class LightOff extends Event {

    public LightOff(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Put hardware control code here to
      // physically turn off the light,
      light = false;
    }

    public String toString() {
      return "Light is off";
    }
  }

  private boolean water = false;

  public class WaterOn extends Event {

    public WaterOn(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Put hardware control code here,
      water = true;
    }

    public String toString() {
      return "Greenhouse water is on";
    }
  }

  public class WaterOff extends Event {

    public WaterOff(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Put hardware control code here,
      water = false;
    }

    public String toString() {
      return "Greenhouse water is off";
    }
  }

  private String thermostat = "Day";

  public class ThermostatNight extends Event {

    public ThermostatNight(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Put hardware control code here.
      thermostat = "Night";
    }

    public String toString() {
      return "Thermostat on night setting";
    }
  }

  public class ThermostatDay extends Event {

    public ThermostatDay(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Put hardware control code here.
      thermostat = "Day";
    }

    public String toString() {
      return "Thermostat on day setting";
    }
  }

  private boolean fans = false;

  public class FansOn extends Event {

    @Override
    public void action() {
      fans = true;
    }

    @Override
    public String toString() {
      return "Fans are on";
    }

    public FansOn(long delayTime) {
      super(delayTime);
    }
  }

  public class FansOff extends Event {

    @Override
    public void action() {
      fans = false;
    }

    @Override
    public String toString() {
      return "Fans are off";
    }

    public FansOff(long delayTime) {
      super(delayTime);
    }
  }

  // An example of an action() that inserts a
  // new one of itself into the event list:
  public class Bell extends Event {

    public Bell(long delayTime) {
      super(delayTime);
    }

    public void action() {
      addEvent(new Bell(delayTime));
    }

    public String toString() {
      return "Bing!";
    }
  }

  public class Restart extends Event {

    private Event[] eventList;

    public Restart(long delayTime, Event[] eventList) {
      super(delayTime);
      this.eventList = eventList;
      for (Event e : eventList) {
        addEvent(e);
      }
    }

    public void action() {
      for (Event e : eventList) {
        e.start(); // Rerun each event
        addEvent(e);
      }
      start(); // Rerun this Event
      addEvent(this);
    }

    public String toString() {
      return "Restarting system";
    }
  }

  public static class Terminate extends Event {

    public Terminate(long delayTime) {
      super(delayTime);
    }

    public void action() {
      System.exit(0);
    }

    public String toString() {
      return "Terminating";
    }
  }
}

class GreenhouseControlsMistGenerator extends GreenhouseControls {

  private boolean mist = false;

  public class MistGeneratorOn extends Event {

    MistGeneratorOn(long delayTime) {
      super(delayTime);
    }

    @Override
    public void action() {
      mist = true;
    }

    @Override
    public String toString() {
      return "Mist generator is on";
    }
  }

  public class MistGeneratorOff extends Event {

    MistGeneratorOff(long delayTime) {
      super(delayTime);
    }

    @Override
    public void action() {
      mist = false;
    }

    @Override
    public String toString() {
      return "Mist generator is on";
    }
  }
}
