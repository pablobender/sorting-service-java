package br.com.oncast.assessment.sortingservice;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

  private SortConfiguration sortConfiguration;

  @Override
  public int compare(Book book1, Book book2) {
    for (SortAttribute sortAttribute : sortConfiguration) {
      int result = compareBooksByAttribute(book1, book2, sortAttribute);
      if (result != 0) {
        return result;
      }
    }
    return 0;
  }

  private int compareBooksByAttribute(Book book1, Book book2,
      SortAttribute sortAttribute) {
    int result;
    switch (sortAttribute.getAttribute()) {
    case TITLE:
      result = book1.getTitle().compareTo(book2.getTitle());
      break;
    case AUTHOR:
      result = book1.getAuthor().compareTo(book2.getAuthor());
      break;
    case EDITION:
      result = book1.getEdition().compareTo(book2.getEdition());
      break;
    default:
      result = 0;
    }
    if (sortAttribute.getDirection() == SortAttribute.Direction.DESC) {
      result *= -1;
    }
    return result;
  }

  public SortConfiguration getSortConfiguration() {
    return sortConfiguration;
  }

  public void setSortConfiguration(SortConfiguration sortConfiguration) {
    this.sortConfiguration = sortConfiguration;
  }

}
