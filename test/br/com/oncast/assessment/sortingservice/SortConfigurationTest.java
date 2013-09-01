package br.com.oncast.assessment.sortingservice;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class SortConfigurationTest {

  @Test
  public void testIsIterable() {
    SortConfiguration sortConfiguration = new SortConfiguration();
    assertTrue(sortConfiguration instanceof Iterable<?>);
  }

  @Test
  public void testIteratesSortAttributes() {
    SortAttribute authorAsc = new SortAttribute();
    authorAsc.setAttribute(SortAttribute.Attribute.AUTHOR);
    authorAsc.setDirection(SortAttribute.Direction.ASC);

    SortAttribute editionDesc = new SortAttribute();
    editionDesc.setAttribute(SortAttribute.Attribute.EDITION);
    editionDesc.setDirection(SortAttribute.Direction.DESC);

    SortConfiguration sortConfiguration = new SortConfiguration();

    sortConfiguration.addSortAttribute(authorAsc);
    sortConfiguration.addSortAttribute(editionDesc);

    Iterator<SortAttribute> sortAttributeIterator = sortConfiguration.iterator();

    assertSame(authorAsc, sortAttributeIterator.next());
    assertSame(editionDesc, sortAttributeIterator.next());
    assertFalse(sortAttributeIterator.hasNext());
  }

}
