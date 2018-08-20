package com.nexmo.interview.book;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class SorterBySectionTest {

    private Sortable sorter = new SorterBySection();

    @Test
    public void testSort_depthLevelOne(){
        List<BookSection> input = asList(section("2",  "ANY TITLE"),
                                         section("1",  "ANY TITLE"));

        List<BookSection> output = sorter.sort(input);

        assertThat(output).extracting("section").containsExactly("1", "2");
    }

    @Test
    public void testSort_depthOfTwo(){
        List<BookSection> input = asList(section("2.1", "ANY TITLE"),
                                         section("1.1", "ANY TITLE"),
                                         section("1",   "ANY TITLE"),
                                         section("2",   "ANY TITLE"));

        List<BookSection> output = sorter.sort(input);

        assertThat(output).extracting("section").containsExactly("1", "1.1","2", "2.1");
    }

    @Test
    public void testSort_depthOfThree(){
        List<BookSection> input = asList(section("1.10.1", "ANY TITLE"),
                                         section("1.1",    "ANY TITLE"),
                                         section("1.1.1",  "ANY TITLE"),
                                         section("1",      "ANY TITLE"),
                                         section("1.1.10", "ANY TITLE"));

        List<BookSection> output = sorter.sort(input);

        assertThat(output).extracting("section").containsExactly("1", "1.1","1.1.1","1.1.10","1.10.1");
    }
    @Test
    public void testSort(){
        List<BookSection> input = asList(section("1.2.1",  "ANY TITLE"),
                                         section("1.2.2",  "ANY TITLE"),
                                         section("1.10",   "ANY TITLE"),
                                         section("1.1",    "ANY TITLE"),
                                         section("1.2.10", "ANY TITLE"),
                                         section("1.3",    "ANY TITLE"),
                                         section("2.1",    "ANY TITLE"),
                                         section("1.2",    "ANY TITLE"),
                                         section("1.11",   "ANY TITLE"),
                                         section("1",      "ANY TITLE"),
                                         section("10",     "ANY TITLE"));


        List<BookSection> output = sorter.sort(input);

        assertThat(output).extracting("section").containsExactly("1",
                                                                 "1.1",
                                                                 "1.2",
                                                                 "1.2.1",
                                                                 "1.2.2",
                                                                 "1.2.10",
                                                                 "1.3",
                                                                 "1.10",
                                                                 "1.11",
                                                                 "2.1",
                                                                 "10");
    }


    private static BookSection section(String section, String title){
        return new BookSection(section, title);
    }
}