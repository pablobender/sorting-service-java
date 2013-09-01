package br.com.oncast.assessment.sortingservice;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BookSorterTest {

  private BookSorter bookSorter;
  private Book book1;
  private Book book2;
  private Book book3;
  private Book book4;
  private List<Book> bookList;
  private SortConfiguration sortConfiguration;
  private BookComparator bookComparator;

  @Before
  public void setUp() throws Exception {
    sortConfiguration = new SortConfiguration();

    bookComparator = new BookComparator();
    bookComparator.setSortConfiguration(sortConfiguration);

    bookSorter = new BookSorter();
    bookSorter.setBookComparator(bookComparator);

    book1 = new Book();
    book1.setTitle("Java How to Program");
    book1.setAuthor("Deitel & Deitel");
    book1.setEdition(2007);

    book2 = new Book();
    book2.setTitle("Patterns of Enterprise Application Architecture");
    book2.setAuthor("Martin Fowler");
    book2.setEdition(2002);

    book3 = new Book();
    book3.setTitle("Head First Design Patterns");
    book3.setAuthor("Elisabeth Freeman");
    book3.setEdition(2004);

    book4 = new Book();
    book4.setTitle("Internet & World Wide Web: How to Program");
    book4.setAuthor("Deitel & Deitel");
    book4.setEdition(2007);

    bookList = new ArrayList<Book>();
    bookList.add(book1);
    bookList.add(book2);
    bookList.add(book3);
    bookList.add(book4);
  }

  @Test
  public void testSortThrowsAnExceptionWhenNullBookList() {
    try {
      bookSorter.sort(null);
    } catch (OrderingException e) {
      assertTrue(true);
      return;
    }
    fail("OrderingException was not throwed");
  }

  @Test
  public void testSortBookListByTitleAsc() throws OrderingException {
    SortAttribute titleAsc = new SortAttribute();
    titleAsc.setAttribute(SortAttribute.Attribute.TITLE);
    titleAsc.setDirection(SortAttribute.Direction.ASC);

    sortConfiguration.addSortAttribute(titleAsc);

    bookSorter.sort(bookList);
    assertSame(book3, bookList.get(0));
    assertSame(book4, bookList.get(1));
    assertSame(book1, bookList.get(2));
    assertSame(book2, bookList.get(3));
  }

  @Test
  public void testSortBookListByAuthorAscAndTitleDesc()
      throws OrderingException {
    SortAttribute authorAsc = new SortAttribute();
    authorAsc.setAttribute(SortAttribute.Attribute.AUTHOR);
    authorAsc.setDirection(SortAttribute.Direction.ASC);

    sortConfiguration.addSortAttribute(authorAsc);

    SortAttribute titleDesc = new SortAttribute();
    titleDesc.setAttribute(SortAttribute.Attribute.TITLE);
    titleDesc.setDirection(SortAttribute.Direction.DESC);

    sortConfiguration.addSortAttribute(titleDesc);

    bookSorter.sort(bookList);
    assertSame(book1, bookList.get(0));
    assertSame(book4, bookList.get(1));
    assertSame(book3, bookList.get(2));
    assertSame(book2, bookList.get(3));
  }

  @Test
  public void testSortBookListByAuthorAscAndTitleAsc() throws OrderingException {
    SortAttribute authorAsc = new SortAttribute();
    authorAsc.setAttribute(SortAttribute.Attribute.AUTHOR);
    authorAsc.setDirection(SortAttribute.Direction.ASC);

    sortConfiguration.addSortAttribute(authorAsc);

    SortAttribute titleDesc = new SortAttribute();
    titleDesc.setAttribute(SortAttribute.Attribute.TITLE);
    titleDesc.setDirection(SortAttribute.Direction.ASC);

    sortConfiguration.addSortAttribute(titleDesc);

    bookSorter.sort(bookList);
    assertSame(book4, bookList.get(0));
    assertSame(book1, bookList.get(1));
    assertSame(book3, bookList.get(2));
    assertSame(book2, bookList.get(3));
  }

  @Test
  public void testSortBookListByEditionDescAndAuthorDescAndTitleAsc()
      throws OrderingException {
    SortAttribute editionDesc = new SortAttribute();
    editionDesc.setAttribute(SortAttribute.Attribute.EDITION);
    editionDesc.setDirection(SortAttribute.Direction.DESC);

    sortConfiguration.addSortAttribute(editionDesc);

    SortAttribute authorDesc = new SortAttribute();
    authorDesc.setAttribute(SortAttribute.Attribute.AUTHOR);
    authorDesc.setDirection(SortAttribute.Direction.DESC);

    sortConfiguration.addSortAttribute(authorDesc);

    SortAttribute titleDesc = new SortAttribute();
    titleDesc.setAttribute(SortAttribute.Attribute.TITLE);
    titleDesc.setDirection(SortAttribute.Direction.ASC);

    sortConfiguration.addSortAttribute(titleDesc);

    bookSorter.sort(bookList);
    assertSame(book4, bookList.get(0));
    assertSame(book1, bookList.get(1));
    assertSame(book3, bookList.get(2));
    assertSame(book2, bookList.get(3));
  }

}
