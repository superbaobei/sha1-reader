package com.sxy.www.sha1.reader.dao;

import com.sxy.www.sha1.reader.model.Sha1SavedRecord;

public interface Sha1SavedRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sha1SavedRecord record);

    int insertSelective(Sha1SavedRecord record);

    Sha1SavedRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sha1SavedRecord record);

    int updateByPrimaryKey(Sha1SavedRecord record);
}