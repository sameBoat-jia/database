package com.itheima.service;

import com.itheima.domain.Book;

import java.util.List;

public interface BookService {
    /**
     * 保存
     * @param book
     * @return
     */
    public boolean save(Book book);

    /**
     * 修改
     * @param book
     * @return
     */
    public boolean update(Book book);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 根据id查询
     * @param id
     */
    public Book getById(Integer id);
    /**
     * 查询全部
     *
     */
    public List<Book> getAll();
}
