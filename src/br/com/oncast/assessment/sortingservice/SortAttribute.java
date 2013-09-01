package br.com.oncast.assessment.sortingservice;

public class SortAttribute {
  public enum Attribute { TITLE, AUTHOR, EDITION }
  public enum Direction { ASC, DESC }

  private Attribute attribute;
  private Direction direction;

  public Attribute getAttribute() {
    return attribute;
  }

  public void setAttribute(Attribute attribute) {
    this.attribute = attribute;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

}
