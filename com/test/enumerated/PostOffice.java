package com.test.enumerated;

import com.test.util.Enums;
import java.util.EnumMap;
import java.util.Iterator;

class Mail {

  // The NO's lower the probability of random selection:
  enum GeneralDelivery {
    YES, NO1, NO2, NO3, NO4, NO5
  }

  enum Scannability {
    UNSCANNABLE, YES1, YES2, YES3, YES4
  }

  enum Readability {
    ILLEGIBLE, YES1, YES2, YES3, YES4
  }

  enum Address {
    INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6
  }

  enum ReturnAddress {
    MISSING, OK1, OK2, OK3, OK4, OK5
  }

  enum ForwardAddress {
    MISSING, OK1, OK2, OK3, OK4, OK5
  }

  GeneralDelivery generalDelivery;
  Scannability scannability;
  Readability readability;
  Address address;
  ReturnAddress returnAddress;
  ForwardAddress forwardAddress;
  static long counter = 0;
  long id = counter++;

  public String toString() {
    return "Mail " + id;
  }

  public String details() {
    return toString() + ", General Delivery: " + generalDelivery + ", Address Scanability: "
        + scannability + ", Address Readability: " + readability + ", Address Address: " + address
        + ", Forward address: " + forwardAddress + ", Return address: " + returnAddress;
  }

  // Generate test Mail:
  public static Mail randomMail() {
    Mail m = new Mail();
    m.generalDelivery = Enums.random(GeneralDelivery.class);
    m.scannability = Enums.random(Scannability.class);
    m.readability = Enums.random(Readability.class);
    m.address = Enums.random(Address.class);
    m.returnAddress = Enums.random(ReturnAddress.class);
    m.forwardAddress = Enums.random(ForwardAddress.class);
    return m;
  }

  public static Iterable<Mail> generator(final int count) {
    return new Iterable<Mail>() {
      int n = count;

      public Iterator<Mail> iterator() {
        return new Iterator<Mail>() {
          public boolean hasNext() {
            return n-- > 0;
          }

          public Mail next() {
            return randomMail();
          }

          public void remove() { // Not implemented
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }
}


public class PostOffice {
  static EnumMap<MailHandler, Command> handlerMap =
      new EnumMap<>(MailHandler.class);

  static {
    handlerMap.put(MailHandler.GENERAL_DELIVERY, new Command() {
      @Override
      public boolean handle(Mail m) {
        switch (m.generalDelivery) {
          case YES:
            System.out.println("Using general delivery for " + m);
            return true;
          default:
            return false;
        }
      }
    });
    handlerMap.put(MailHandler.MACHINE_SCAN, new Command() {
      @Override
      public boolean handle(Mail m) {
        switch (m.scannability) {
          case UNSCANNABLE:
            return false;
          default:
            switch (m.address) {
              case INCORRECT:
                return false;
              default:
                System.out.println("Delivering " + m + " automatically");
                return true;
            }
        }
      }
    });
    handlerMap.put(MailHandler.VISUAL_INSPECTION, new Command() {
      @Override
      public boolean handle(Mail m) {
        switch (m.readability) {
          case ILLEGIBLE:
            return false;
          default:
            switch (m.address) {
              case INCORRECT:
                return false;
              default:
                System.out.println("Delivering " + m + " normally");
                return true;
            }
        }
      }
    });
    handlerMap.put(MailHandler.FORWARD_TO_ADDRESS, new Command() {
      @Override
      public boolean handle(Mail m) {
        switch (m.forwardAddress) {
          case MISSING:
            return false;
          default:
            System.out.println(m + " was forwarded.");
            return true;
        }
      }
    });
    handlerMap.put(MailHandler.RETURN_TO_SENDER, new Command() {
      @Override
      public boolean handle(Mail m) {
        switch (m.returnAddress) {
          case MISSING:
            return false;
          default:
            System.out.println("Returning " + m + " to sender");
            return true;
        }
      }
    });
  }

  enum MailHandler {
     GENERAL_DELIVERY, MACHINE_SCAN, VISUAL_INSPECTION, FORWARD_TO_ADDRESS, RETURN_TO_SENDER
  }

  static void handle(Mail m) {
    for (Command command : handlerMap.values()) {
      if (command.handle(m)) {
        return;
      }
    }
    System.out.println(m + " is a dead letter");
  }

  public static void main(String[] args) {
    for (Mail mail : Mail.generator(10)) {
      System.out.println(mail.details());
      handle(mail);
      System.out.println("*****");
    }
  }
}
