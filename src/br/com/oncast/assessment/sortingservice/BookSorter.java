package br.com.oncast.assessment.sortingservice;

import java.util.Collections;
import java.util.List;

public class BookSorter {

  private BookComparator bookComparator;

  public void sort(List<Book> bookList) throws OrderingException {
    if (bookList == null) {
      throw new OrderingException();
    }
    Collections.sort(bookList, bookComparator);
  }

  public BookComparator getBookComparator() {
    return bookComparator;
  }

  public void setBookComparator(BookComparator bookComparator) {
    this.bookComparator = bookComparator;
  }

}
