package br.com.oncast.assessment.sortingservice;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

  @Test
  public void testConstructor() {
    Book book = new Book();
    assertNotNull(book);
  }
}
