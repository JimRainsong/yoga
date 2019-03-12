package cn.project.yoga.dao;

import cn.project.yoga.pojo.Transcation;

public interface TranscationMapper {
    int insert(Transcation record);

    int insertSelective(Transcation record);
}