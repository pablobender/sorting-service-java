package br.com.oncast.assessment.sortingservice;

import java.util.ArrayList;
import java.util.Iterator;

public class SortConfiguration implements Iterable<SortAttribute> {

  private ArrayList<SortAttribute> sortAttributes;

  public SortConfiguration() {
    this.sortAttributes = new ArrayList<SortAttribute>();
  }

  @Override
  public Iterator<SortAttribute> iterator() {
    return this.sortAttributes.iterator();
  }

  public void addSortAttribute(SortAttribute sortAttribute) {
    this.sortAttributes.add(sortAttribute);
  }

}
