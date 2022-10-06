package com.sxy.www.sha1.reader.dao

.115.dao;

import com.sxy.www
import com.sxy.www.sha1.reader.model.FileParsedRecord;.115.model.FileParsedRecord;

public interface FileParsedRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FileParsedRecord record);

    int insertSelective(FileParsedRecord record);

    FileParsedRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FileParsedRecord record);

    int updateByPrimaryKey(FileParsedRecord record);
}