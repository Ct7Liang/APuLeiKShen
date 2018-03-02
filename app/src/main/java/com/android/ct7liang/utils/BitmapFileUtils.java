package com.android.ct7liang.utils;

import android.graphics.Bitmap;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2018-02-08.
 */

public class BitmapFileUtils {

//    public static Bitmap File2Bitmap(File file){
//        String filePath = file.getPath();
//        Bitmap bitmap = BitmapFactory.decodeFile(filePath,getBitmapOption(2)); //将图片的长和宽缩小味原来的1/2
//        return bitmap;
//    }
//
//    private static BitmapFactory.Options getBitmapOption(int inSampleSize) {
//        System.gc();
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inPurgeable = true;
//        options.inSampleSize = inSampleSize;
//        return options;
//    }

    public static File Bitmap2File(Bitmap bitmap, File outFile){
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
            return outFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
