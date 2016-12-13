package org.rbkpro.campus;

/**
 * Created by BOUNHH on 07-10-2016.
 */

public class Word {
    private String content;
    private int value;

    public Word() {
    }

    public Word(String content, int value) {
        this.content = content;
        this.value = value;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public int getValue() {

        return value;
    }

    public void setValue(int value) {

        this.value = value;
    }
}
