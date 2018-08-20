package com.nexmo.interview.book;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class SorterBySection implements Sortable, Comparator<BookSection> {



    /**
     * Sorts given list of BookSection by a section
     *
     * Example
     *
     * <code>
     *  Input output
     *
     *  1.1   Sub title - H2
     *  1.2   Sub title - H2
     *  2     title - H1
     *  1.2.1 Sub Sub title - H3
     *  1.3   Sub title - H2
     *  2.1   Sub title - H2
     *  1     Title - H1
     *  2.10  Sub title - H2
     *  1.10  Sub title - H2
     *
     *  Expected output
     *
     *  1     Title - H1
     *  1.1   Sub title - H2
     *  1.10  Sub title - H2
     *  1.2   Sub title - H2
     *  1.2.1 Sub Sub title - H3
     *  1.3   Sub title - H2
     *  2     title - H1
     *  2.1   Sub title - H2
     *  2.10  Sub title - H2
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
        // TODO implement me
        return list.stream()
                .sorted(this)
                .collect(toList());

    }

    @Override
    public int compare(BookSection bs1, BookSection bs2) {
        CompareableSection section1 = new CompareableSection( bs1.getSection() );
        CompareableSection section2 = new CompareableSection( bs2.getSection() );
        return section1.compareTo(section2);
    }



    static class CompareableSection implements Comparable<CompareableSection>{

        private final int[] parts;

        CompareableSection(String section) {
            this.parts = Arrays.stream(section.split("\\."))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        @Override
        public int compareTo(CompareableSection o) {
            int minDepth = Math.min(o.parts.length, this.parts.length);

            for(int depth = 0; depth < minDepth; depth++){

                if (this.parts[depth] != o.parts[depth])
                    return  this.parts[depth] < o.parts[depth]? -1 : 1;

            }
            return this.parts.length - o.parts.length;
        }

        @Override
        public String toString() {
            return Arrays.toString(parts);
        }
    }

}
