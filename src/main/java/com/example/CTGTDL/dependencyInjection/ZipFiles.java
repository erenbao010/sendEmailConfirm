package com.example.CTGTDL.dependencyInjection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFiles {
    public static void ZipMultipleFiles(String[] srcFileNames, String zipFileName) throws Exception {
        try (
            var fileOut = new FileOutputStream(zipFileName);
            var zipFile = new ZipOutputStream(fileOut);
        ) {
            for (String srcFileName :  srcFileNames) {
                var srcFile = new File(srcFileName);
                try (var fileIn = new FileInputStream(srcFile)) {
                    var zipEntry = new ZipEntry(srcFile.getName());
                }
            }
        }

    }
}
