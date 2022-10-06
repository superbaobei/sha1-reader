package com.example.sha1reader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class FileParser {

    public List<String> parse(String path) {

        List<File> existFiles = listExistFile(path);
        Map<File, String> fileAndDigestMap = filterParsedFile(calFileAndDigestMap(existFiles));

        fileAndDigestMap
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
     * @param fileDigest
     * @return
     */
    private boolean isParsed(String fileDigest) {
        return false;
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
