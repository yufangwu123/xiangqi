package org.example;

/**
 * @author yufangwu
 */
public class QiZi extends Point {

  private String name;

  private String color;

  private String rule;

  public String getRule() {
    return rule;
  }

  public String setRule(String rule) {
    return this.rule = rule;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public boolean isAlive() {
    return isAlive;
  }

  public void setAlive(boolean alive) {
    isAlive = alive;
  }

  private boolean isAlive;

  public QiZi(String name, String color,String rule, int x, int y) {
    super(x, y);
    this.name = name;
    this.color = color;
    this.isAlive = true;
    this.rule = rule;
  }
}
