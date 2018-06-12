package Interfaces;

import java.util.List;

public interface Dictionary<T> {
    void add(T word);

    List<T> allSubwords(T word);

    List<T> allSubwords(T word, int length);
}
