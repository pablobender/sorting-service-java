package br.com.oncast.assessment.sortingservice;

import java.io.InputStream;

public interface SortConfigurationLoader {
  public SortConfiguration loadSortConfiguration(InputStream inputStream)
      throws LoadingSortConfigurationException;

}
