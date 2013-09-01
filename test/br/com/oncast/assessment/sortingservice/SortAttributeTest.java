package br.com.oncast.assessment.sortingservice;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortAttributeTest {

  @Test
  public void testConstructor() {
    assertNotNull(new SortAttribute());
  }

  @Test
  public void testGetAttributeTitle() {
    SortAttribute sortAttribute = new SortAttribute();
    sortAttribute.setAttribute(SortAttribute.Attribute.TITLE);
    assertEquals(SortAttribute.Attribute.TITLE, sortAttribute.getAttribute());
  }

  @Test
  public void testGetAttributeAuthor() {
    SortAttribute sortAttribute = new SortAttribute();
    sortAttribute.setAttribute(SortAttribute.Attribute.AUTHOR);
    assertEquals(SortAttribute.Attribute.AUTHOR, sortAttribute.getAttribute());
  }

  @Test
  public void testGetDirectionAsc() {
    SortAttribute sortAttribute = new SortAttribute();
    sortAttribute.setDirection(SortAttribute.Direction.ASC);
    assertEquals(SortAttribute.Direction.ASC, sortAttribute.getDirection());
  }

  @Test
  public void testGetDirectionDesc() {
    SortAttribute sortAttribute = new SortAttribute();
    sortAttribute.setDirection(SortAttribute.Direction.DESC);
    assertEquals(SortAttribute.Direction.DESC, sortAttribute.getDirection());
  }

}
