package com.example.CTGTDL.dependencyInjection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFiles {
    public static void ZipMultipleFiles(String[] srcFileNames, String zipFileName) throws  IOException{
        try (
                var fileOut = new FileOutputStream(zipFileName);
                var zipOut = new ZipOutputStream(fileOut);
        ) {
            for (String srcFileName : srcFileNames) {
                var srcFile = new File(srcFileName);
                try (var fileIn = new FileInputStream(srcFile)) {
                    var zipEntry = new ZipEntry(srcFile.getName());
                    zipOut.putNextEntry(zipEntry);
                    final var newbyte = new byte[1024];
                    int length;
                    while ((length = fileIn.read(newbyte)) >= 0) {
                        zipOut.write(newbyte, 0, length);
                    }
                }
            }
        }
    }
}
