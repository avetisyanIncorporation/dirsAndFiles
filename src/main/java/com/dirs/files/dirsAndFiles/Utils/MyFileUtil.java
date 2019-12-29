package com.dirs.files.dirsAndFiles.Utils;

public class MyFileUtil {
    private static final int BYTE_CONVERT_CONST = 1024;

    public static String getClearFileSize(long size) {
        if (size >= BYTE_CONVERT_CONST) {
            size /= BYTE_CONVERT_CONST;
            if (size >= BYTE_CONVERT_CONST) {
                size /= BYTE_CONVERT_CONST;
                if (size >= BYTE_CONVERT_CONST) {
                    size /= BYTE_CONVERT_CONST;
                    if (size >= BYTE_CONVERT_CONST) {
                        size /= BYTE_CONVERT_CONST;
                        return size + "tb";
                    }
                    return size + "gb";
                }
                return size + "mb";
            }
            return size + "kb";
        }
        return size + "b";
    }
}

