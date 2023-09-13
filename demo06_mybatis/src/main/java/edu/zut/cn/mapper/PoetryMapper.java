package edu.zut.cn.mapper;

import edu.zut.cn.pojo.Poetry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PoetryMapper {
    List<Poetry> getAll(String[] names);
    /*Poetry getByName(String name);
    List<Poetry> getByAuthor(String author);*/
    int add(Poetry poetry);
    int addAll(List<Poetry> list);
    int removeByName(String name);
    int removeAll(String[] names);
    int updateByName(Poetry poetry);
    List<Poetry> getByAuthorOrDynasty(
            @Param("name")
            String name,
            @Param("value")
            String value);
    List<Poetry> selectByAll(Poetry poetry);
    int updateBySet(Poetry poetry);
}
