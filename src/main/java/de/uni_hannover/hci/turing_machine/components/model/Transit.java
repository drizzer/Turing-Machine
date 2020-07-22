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

  // getter und setter

  public String getOne() {
    // return one;
    return one.get();
  }

  public void setOne(String one) {
    // this.one = one;
    this.one.set(one);
  }

  public String getTwo() {
    // return two;
    return two.get();
  }

  public void setTwo(String two) {
    // this.two = two;
    this.two.set(two);
  }

  public String getThree() {
    // return three;
    return three.get();
  }

  public void setThree(String three) {
    // this.three = three;
    this.three.set(three);
  }

  public String getFour() {
    // return four;
    return four.get();
  }

  public void setFour(String four) {
    // this.four = four;
    this.four.set(four);
  }

  public String getFive() {
    // return five;
    return five.get();
  }

  public void setFive(String five) {
    // this.five = five;
    this.five.set(five);
  }

}
