package com.cheer.mybatis.dao;

import com.cheer.mybatis.model.Author;

import java.util.List;

public interface AuthorMapper {
    List<Author> FindAuthorIng(List<Integer> list);
}
