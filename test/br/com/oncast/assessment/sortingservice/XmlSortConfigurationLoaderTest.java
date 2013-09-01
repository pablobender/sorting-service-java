package br.com.oncast.assessment.sortingservice;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class XmlSortConfigurationLoaderTest {

  private XmlSortConfigurationLoader xmlSortConfigurationLoader;

  @Before
  public void setUp() throws Exception {
    xmlSortConfigurationLoader = new XmlSortConfigurationLoader();
  }

  @Test
  public void testLoadSortConfigurationTitleAsc() throws Exception {
    InputStream configFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/TitleAsc.xml");
    SortConfiguration sortConfiguration = xmlSortConfigurationLoader.loadSortConfiguration(configFile);

    Iterator<SortAttribute> sortAttributeIterator = sortConfiguration.iterator();
    SortAttribute titleAsc = sortAttributeIterator.next();
    assertEquals(SortAttribute.Attribute.TITLE, titleAsc.getAttribute());
    assertEquals(SortAttribute.Direction.ASC, titleAsc.getDirection());
    assertFalse(sortAttributeIterator.hasNext());
  }

  @Test
  public void testLoadSortConfigurationTitleDesc() throws Exception {
    InputStream configFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/TitleDesc.xml");
    SortConfiguration sortConfiguration = xmlSortConfigurationLoader.loadSortConfiguration(configFile);

    Iterator<SortAttribute> sortAttributeIterator = sortConfiguration.iterator();
    SortAttribute titleAsc = sortAttributeIterator.next();
    assertEquals(SortAttribute.Attribute.TITLE, titleAsc.getAttribute());
    assertEquals(SortAttribute.Direction.DESC, titleAsc.getDirection());
    assertFalse(sortAttributeIterator.hasNext());
  }

  @Test
  public void testLoadSortConfigurationAuthorAsc()
      throws LoadingSortConfigurationException {
    InputStream configFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/AuthorAsc.xml");
    SortConfiguration sortConfiguration = xmlSortConfigurationLoader.loadSortConfiguration(configFile);

    Iterator<SortAttribute> sortAttributeIterator = sortConfiguration.iterator();
    SortAttribute titleAsc = sortAttributeIterator.next();
    assertEquals(SortAttribute.Attribute.AUTHOR, titleAsc.getAttribute());
    assertEquals(SortAttribute.Direction.ASC, titleAsc.getDirection());
    assertFalse(sortAttributeIterator.hasNext());
  }

  @Test
  public void testLoadSortConfigurationEditionDesc() throws Exception {
    InputStream configFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/EditionDesc.xml");
    SortConfiguration sortConfiguration = xmlSortConfigurationLoader.loadSortConfiguration(configFile);

    Iterator<SortAttribute> sortAttributeIterator = sortConfiguration.iterator();
    SortAttribute titleAsc = sortAttributeIterator.next();
    assertEquals(SortAttribute.Attribute.EDITION, titleAsc.getAttribute());
    assertEquals(SortAttribute.Direction.DESC, titleAsc.getDirection());
    assertFalse(sortAttributeIterator.hasNext());
  }

  @Test
  public void testLoadSortConfigurationTitleAscAndEditionDesc()
      throws Exception {
    InputStream configFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/TitleAscAndEditionDesc.xml");
    SortConfiguration sortConfiguration = xmlSortConfigurationLoader.loadSortConfiguration(configFile);

    Iterator<SortAttribute> sortAttributeIterator = sortConfiguration.iterator();
    SortAttribute titleAsc = sortAttributeIterator.next();
    assertEquals(SortAttribute.Attribute.TITLE, titleAsc.getAttribute());
    assertEquals(SortAttribute.Direction.ASC, titleAsc.getDirection());
    
    SortAttribute editionDesc = sortAttributeIterator.next();
    assertEquals(SortAttribute.Attribute.EDITION, editionDesc.getAttribute());
    assertEquals(SortAttribute.Direction.DESC, editionDesc.getDirection());
    assertFalse(sortAttributeIterator.hasNext());
  }

}