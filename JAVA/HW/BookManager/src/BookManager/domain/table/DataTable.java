package BookManager.domain.table;

import java.util.*;

public interface DataTable<T> {
    public void addToList(T obj);
    public void loadFromBackup(List<String> obj);
    public List<T> listUp();
    public List<String> searchByKeyword(String keyword);
    public T findById(String Id);
    public void deleteFromList(String Id);
    public int length();
    public void sort();
}
