package com.cheer.mybatis.model;

import java.util.StringJoiner;

public class Blog {
   private Integer id;
   private String title;
   private String state;
   private String author_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Blog.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .add("state='" + state + "'")
                .add("author_id='" + author_id + "'")
                .toString();
    }
}
