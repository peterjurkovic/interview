package com.nexmo.interview.book;

import static java.util.Objects.requireNonNull;

public class BookSection {

    private final String section;
    private final String title;

    public BookSection(String section, String title) {
        this.section = requireNonNull(section);
        this.title = requireNonNull(title);
    }

    public String getSection() {
        return section;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "BookSection{" +
                "section='" + section + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
