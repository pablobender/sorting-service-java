package br.com.oncast.assessment.sortingservice;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlSortConfigurationLoader implements SortConfigurationLoader {

  @Override
  public SortConfiguration loadSortConfiguration(InputStream inputStream)
      throws LoadingSortConfigurationException {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(false);
    try {
      DocumentBuilder docBuilder = dbf.newDocumentBuilder();
      Document doc = docBuilder.parse(inputStream);
      SortConfiguration sortConfiguration = new SortConfiguration();

      NodeList sortAttributeNodes = doc.getElementsByTagName("sortAttribute");

      for (int item = 0; item < sortAttributeNodes.getLength(); item++) {
        Element sortAttributeNode = (Element) sortAttributeNodes.item(item);
        SortAttribute sortAttribute = loadSortAttributeFromXml(
            sortConfiguration, sortAttributeNode);
        sortConfiguration.addSortAttribute(sortAttribute);
      }
      return sortConfiguration;
    } catch (Exception ex) {
      throw new LoadingSortConfigurationException(ex);
    }

  }

  private SortAttribute loadSortAttributeFromXml(
      SortConfiguration sortConfiguration, Element sortAttributeNode) {
    SortAttribute sortAttribute = new SortAttribute();

    Node attributeNode = sortAttributeNode.getElementsByTagName("attribute").item(0);
    String attributeValue = attributeNode.getTextContent();

    Node directionNode = sortAttributeNode.getElementsByTagName("direction").item(0);
    String directionNodeValue = directionNode.getTextContent();

    loadSortAttributeValues(sortAttribute, attributeValue, directionNodeValue);
    return sortAttribute;
  }

  private void loadSortAttributeValues(SortAttribute sortAttribute,
      String attributeValue, String directionNodeValue) {
    switch (attributeValue) {
    case "author":
      sortAttribute.setAttribute(SortAttribute.Attribute.AUTHOR);
      break;
    case "edition":
      sortAttribute.setAttribute(SortAttribute.Attribute.EDITION);
      break;
    default:
      sortAttribute.setAttribute(SortAttribute.Attribute.TITLE);
    }
    if (directionNodeValue.equals("desc")) {
      sortAttribute.setDirection(SortAttribute.Direction.DESC);
    } else {
      sortAttribute.setDirection(SortAttribute.Direction.ASC);
    }
  }
}
