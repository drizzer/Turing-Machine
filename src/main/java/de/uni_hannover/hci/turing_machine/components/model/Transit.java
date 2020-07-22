package de.uni_hannover.hci.turing_machine.components.model;

import javafx.beans.property.SimpleStringProperty;

public class Transit {

  /*
   * private String one; private String two; private String three; private String
   * four; private String five;
   */

  public SimpleStringProperty one;
  public SimpleStringProperty two;
  public SimpleStringProperty three;
  public SimpleStringProperty four;
  public SimpleStringProperty five;

  public Transit(String one, String two, String three, String four, String five) {
    this.one = new SimpleStringProperty(one);
    this.two = new SimpleStringProperty(two);
    this.three = new SimpleStringProperty(three);
    this.four = new SimpleStringProperty(four);
    this.five = new SimpleStringProperty(five);
  }

  /*
   * public Transit(String one, String two, String three, String four, String
   * five) { this.one = one; this.two = two; this.three = three; this.four = four;
   * this.five = five;
   * 
   * }
   */

  // getter und settter

  public String getone() {
    // return one;
    return one.get();
  }

  public void setone(String one) {
    // this.one = one;
    this.one.set(one);
  }

  public String gettwo() {
    // return two;
    return two.get();
  }

  public void settwo(String two) {
    // this.two = two;
    this.two.set(two);
  }

  public String getthree() {
    // return three;
    return three.get();
  }

  public void setthree(String three) {
    // this.three = three;
    this.three.set(three);
  }

  public String getfour() {
    // return four;
    return four.get();
  }

  public void setfour(String four) {
    // this.four = four;
    this.four.set(four);
  }

  public String getfive() {
    // return five;
    return five.get();
  }

  public void setfive(String five) {
    // this.five = five;
    this.five.set(five);
  }

}
