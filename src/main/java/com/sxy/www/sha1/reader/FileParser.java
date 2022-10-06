package com.sxy.www.sha1.reader;

import com.sxy.www.sha1.reader.dao.FileParsedRecordMapper;
import com.sxy.www.sha1.reader.dao.Sha1SavedRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FileParser {

    @Resource
    private FileParsedRecordMapper fileParsedRecordMapper;

    @Resource
    private Sha1SavedRecordMapper sha1SavedRecordMapper;

    /**
     * 解析指定路径下的文件，获取sha1
     *
     * @param path
     * @return sha1的集合
     */
    public List<String> parseFileGetSha1(String path) {

        List<File> existFiles = listExistFile(path);
        Map<File, String> fileAndDigestMap = filterParsedFile(calFileAndDigestMap(existFiles));

//        fileAndDigestMap
        return Collections.emptyList();

    }

    private Map<File, String> filterParsedFile(Map<File, String> fileAndDigestMap) {
        Map<File, String> map = new HashMap<>();
        for (Map.Entry<File, String> entry : fileAndDigestMap.entrySet()) {
            if (!isParsed(entry.getValue())) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }

    /**
     * 判断是否已经解析过这个文件
     *
     * @param fileDigest
     * @return
     */
    private boolean isParsed(String fileDigest) {
        return Objects.nonNull(fileParsedRecordMapper.selectByFileDigest(fileDigest));
    }

    private Map<File, String> calFileAndDigestMap(List<File> existFiles) {
        return existFiles.stream().collect(Collectors.toMap(file -> file, file -> {

            try {
                return new String(DigestUtils.md5Digest(Files.newInputStream(file.toPath())));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    private List<File> listExistFile(String path) {
        File file = new File(path);
        if (!file.isDirectory()) {
            throw new RuntimeException("传入路径不是文件夹");
        }
        return Arrays.asList(Objects.requireNonNull(file.listFiles()));
    }
}
