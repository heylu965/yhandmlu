package com.yh.yhandmlu.util;

import com.yh.yhandmlu.bo.ExportDataBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.collections.CollectionUtils;

/**
 * 类FileUtil的实现描述: 文件工具类
 */
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    private static final Map<Long, MessageDigest> CACHE = new ConcurrentHashMap<>();
    private static final ThreadLocal<MessageDigest> MD5 = ThreadLocal.withInitial(() -> CACHE.computeIfAbsent(Thread.currentThread().getId(), id -> {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("MD5 Algorithm not found", e);
        }
    }));

    /**
     * 获取文件全路径
     *
     * @param path     存储路径
     * @param fileName 文件名
     * @param suffix   文件后缀
     * @return 文件全路径名  eg: /data/temp/1525849190.csv
     */
    public static String getFileFullPath(String path, String fileName, String suffix) {
        return path + fileName + "." + suffix;
    }


    /**
     * 写入磁盘
     *
     * @param fileName 文件全路径
     * @param objects  待写入对象
     * @param <T>      泛型类型
     * @return true 写入成功  false 写入失败
     */
    public static <T extends ExportDataBO> boolean writeFile(String fileName, String header, List<T> objects) {
        File file = new File(fileName);
        if (!file.getParentFile().exists()) {
            boolean mkdirs = file.getParentFile().mkdirs();
            if (!mkdirs) {
                logger.warn("文件路径创建失败 {}", fileName);
                return false;
            }
        }
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "GB18030"));
            bw.write(header);

            if (CollectionUtils.isNotEmpty(objects)) {
                for (T object : objects) {
                    bw.write(object.getContext());
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            logger.warn("写文件错误 {}", fileName);
            return false;
        }
        return true;
    }

    /**
     * 文件追加内容
     *
     * @param file
     * @param objects
     * @param <T>
     * @return
     */
    public static <T extends ExportDataBO> boolean appendFile(File file, List<T> objects) {
        logger.info("appending file {}...", file.getAbsoluteFile());
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "GB18030"));
            if (CollectionUtils.isNotEmpty(objects)) {
                for (T object : objects) {
                    bw.write(object.getContext());
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();

        } catch (IOException e) {
            logger.warn("写文件 {} 错误", file.getAbsoluteFile());
            return false;
        }
        return true;
    }


    /**
     * 删除本地文件
     *
     * @param fileName 文件全路径
     * @return true 成功  false 失败
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            return file.delete();
        }

        logger.warn("文件不存在 {}", fileName);
        return false;
    }


    public static String uploadFile(String fileName) {

        boolean success = UFileUploadUtil.uploadFile(fileName);
        if (!success) {
            logger.warn("上传失败 {}", fileName);
        }

        return fileName;
    }


    public static String getFileMd5(String file) {
        File f = new File(file);
        if (!f.exists()) {
            throw new IllegalArgumentException("file:" + file + " not found");
        }
        if (!f.canRead()) {
            throw new IllegalArgumentException("file:" + file + " cannot be read");
        }
        try {
            MessageDigest md5 = MD5.get();
            int len;
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                md5.update(buffer, 0, len);
            }
            BigInteger bigInt = new BigInteger(1, md5.digest());
            return bigInt.toString(16);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
