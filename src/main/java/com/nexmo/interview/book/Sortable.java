package com.nexmo.interview.book;

import java.util.Collection;
import java.util.List;

@FunctionalInterface
public interface Sortable {

    List<BookSection> sort(List<BookSection> list);

}