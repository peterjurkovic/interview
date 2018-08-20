package com.nexmo.interview.book;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class SorterBySection implements Sortable {



    /**
     * Sorts given list of BookSection by a section
     *
     * Example
     *
     * <code>
     * 	Input output
     *
     * 	1.1   Sub title - H2
     * 	1.2   Sub title - H2
     * 	2     title - H1
     * 	1.2.1 Sub Sub title - H3
     * 	1.3   Sub title - H2
     * 	2.1   Sub title - H2
     * 	1     Title - H1
     * 	2.10  Sub title - H2
     * 	1.10  Sub title - H2
     *
     * 	Expected output
     *
     * 	1     Title - H1
     * 	1.1   Sub title - H2
     * 	1.10  Sub title - H2
     * 	1.2   Sub title - H2
     * 	1.2.1 Sub Sub title - H3
     * 	1.3   Sub title - H2
     * 	2     title - H1
     * 	2.1   Sub title - H2
     * 	2.10  Sub title - H2
     </code>
     *
     * - Max book section depth is 3
     * - Min section depth is 1
     *
     * @param list - unsorted list
     * @return sorted list by sections
     */
    @Override
    public List<BookSection> sort(List<BookSection> list) {
        // TODO implement
        return list;
    }


}
