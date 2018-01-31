package chapter1_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 15:19
 * @UpdateDate: 2018/1/30/030 15:19
 */
public class Ex43_fileList {

    public static void main(String[] args) throws FileNotFoundException {

    }

    public void fileList(String filePath){
        File file = new File(filePath);
        fileList(file,0);
    }
    public void fileList(File file, int depth){
        File[] fileList = file.listFiles();
        for (File f : fileList){

            if (f.isDirectory())
                fileList(f,0);

        }
    }
}
