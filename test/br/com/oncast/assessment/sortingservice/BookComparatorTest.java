package br.com.oncast.assessment.sortingservice;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class BookComparatorTest {

	private BookComparator bookComparator;
	private SortConfiguration sortConfiguration;
	private Book book1;
	private Book book2;

	@Before
	public void setUp() {
		bookComparator = new BookComparator();
		sortConfiguration = new SortConfiguration();
		bookComparator.setSortConfiguration(sortConfiguration);
		book1 = new Book();
		book2 = new Book();
	}
	
  @Test
  public void testImplementsComparator() {
    BookComparator bookComparator = new BookComparator();
    assertTrue(bookComparator instanceof Comparator<?>);
  }

  @Test
  public void testCompareByTitleAscSortedBooks() {
    SortAttribute titleAsc = new SortAttribute();
    titleAsc.setAttribute(SortAttribute.Attribute.TITLE);
    titleAsc.setDirection(SortAttribute.Direction.ASC);

    sortConfiguration.addSortAttribute(titleAsc);

    book1.setTitle("title A");
    book2.setTitle("title B");

    assertTrue(bookComparator.compare(book1, book2) < 0);
  }

  @Test
  public void testCompareByTitleAscUnsortedBooks() {
    SortAttribute titleAsc = new SortAttribute();
    titleAsc.setAttribute(SortAttribute.Attribute.TITLE);
    titleAsc.setDirection(SortAttribute.Direction.ASC);

    sortConfiguration.addSortAttribute(titleAsc);

    book1.setTitle("title A");
    book2.setTitle("title B");

    assertTrue(bookComparator.compare(book2, book1) > 0);
  }

  @Test
  public void testCompareByTitleAscEqualBooks() {
    SortAttribute titleAsc = new SortAttribute();
    titleAsc.setAttribute(SortAttribute.Attribute.TITLE);
    titleAsc.setDirection(SortAttribute.Direction.ASC);

    sortConfiguration.addSortAttribute(titleAsc);

    book1.setTitle("title A");
    book2.setTitle("title A");

    assertTrue(bookComparator.compare(book1, book2) == 0);
  }

  @Test
  public void testCompareByTitleDescSortedBooks() {
    SortAttribute titleDesc = new SortAttribute();
    titleDesc.setAttribute(SortAttribute.Attribute.TITLE);
    titleDesc.setDirection(SortAttribute.Direction.DESC);

    sortConfiguration.addSortAttribute(titleDesc);

    book1.setTitle("title B");
    book2.setTitle("title A");

    assertTrue(bookComparator.compare(book1, book2) < 0);
  }

  @Test
  public void testCompareByTitleDescUnsortedBooks() {
    SortAttribute titleDesc = new SortAttribute();
    titleDesc.setAttribute(SortAttribute.Attribute.TITLE);
    titleDesc.setDirection(SortAttribute.Direction.DESC);

    sortConfiguration.addSortAttribute(titleDesc);

    book1.setTitle("title B");
    book2.setTitle("title A");

    assertTrue(bookComparator.compare(book2, book1) > 0);
  }

  @Test
  public void testCompareByTitleDescEqualBooks() {
    SortAttribute titleDesc = new SortAttribute();
    titleDesc.setAttribute(SortAttribute.Attribute.TITLE);
    titleDesc.setDirection(SortAttribute.Direction.DESC);

    sortConfiguration.addSortAttribute(titleDesc);

    book1.setTitle("title A");
    book2.setTitle("title A");

    assertTrue(bookComparator.compare(book1, book2) == 0);
  }

  @Test
  public void testCompareByAuthorDescUnsortedBooks() {
    SortAttribute authorDesc = new SortAttribute();
    authorDesc.setAttribute(SortAttribute.Attribute.AUTHOR);
    authorDesc.setDirection(SortAttribute.Direction.DESC);

    sortConfiguration.addSortAttribute(authorDesc);

    book1.setAuthor("author A");
    book2.setAuthor("author B");

    assertTrue(bookComparator.compare(book1, book2) > 0);
  }

  @Test
  public void testCompareByEditionAscSortedBooks() {
    SortAttribute editionAsc = new SortAttribute();
    editionAsc.setAttribute(SortAttribute.Attribute.EDITION);
    editionAsc.setDirection(SortAttribute.Direction.ASC);

    sortConfiguration.addSortAttribute(editionAsc);

    book1.setEdition(2010);
    book2.setEdition(2011);

    assertTrue(bookComparator.compare(book1, book2) < 0);
  }

  @Test
  public void testCompareByTitleAscAuthorAscSortedBooks() {
    SortAttribute titleAsc = new SortAttribute();
		titleAsc.setAttribute(SortAttribute.Attribute.TITLE);
		titleAsc.setDirection(SortAttribute.Direction.ASC);
		SortAttribute authorAsc = new SortAttribute();
		authorAsc.setAttribute(SortAttribute.Attribute.AUTHOR);
		authorAsc.setDirection(SortAttribute.Direction.ASC);
		
		sortConfiguration.addSortAttribute(titleAsc);
		sortConfiguration.addSortAttribute(authorAsc);
		

		book1.setTitle("common title");
		book1.setAuthor("author A");
		book2.setTitle("common title");
		book2.setAuthor("author B");
		
		assertTrue(bookComparator.compare(book1, book2) < 0);
	}

	@Test
	public void testCompareByTitleDescAuthorAscSortedBooks() {
		SortAttribute titleDesc = new SortAttribute();
		titleDesc.setAttribute(SortAttribute.Attribute.TITLE);
		titleDesc.setDirection(SortAttribute.Direction.DESC);
		SortAttribute authorAsc = new SortAttribute();
		authorAsc.setAttribute(SortAttribute.Attribute.AUTHOR);
		authorAsc.setDirection(SortAttribute.Direction.ASC);
		sortConfiguration.addSortAttribute(titleDesc);
		sortConfiguration.addSortAttribute(authorAsc);
		

		book1.setTitle("common title");
		book1.setAuthor("author A");
		book2.setTitle("common title");
		book2.setAuthor("author B");
		
		assertTrue(bookComparator.compare(book1, book2) < 0);
	}
	
}