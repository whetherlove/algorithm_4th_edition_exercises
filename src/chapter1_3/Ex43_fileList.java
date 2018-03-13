package chapter1_3;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 15:19
 * @UpdateDate: 2018/1/30/030 15:19
 */
@SuppressWarnings("ConstantConditions")
class Ex43_fileList {

    public static void main(String[] args) {
        String path = "E:\\code\\intelliJ\\algorithm_4th_edition_exercises";
        fileList(path);
    }

    private static void fileList(String filePath){
        File file = new File(filePath);
        fileList(file,0);
    }
    private static void fileList(File file, int depth){
        File[] fileList = file.listFiles();
        for (File f : fileList){
            for(int i=0;i<depth;i++) StdOut.print("\t");
            StdOut.println(f.getName());
            if (f.isDirectory())
                fileList(f,depth+1);

        }
    }
}
