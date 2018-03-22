package chapter2_5;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 21/03/2018 7:10 PM
 */
public class FileSorter {

    public static class NameOrder implements Comparator<File>{

        @Override
        public int compare(File o1, File o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class DateOrder implements Comparator<File>{

        @Override
        public int compare(File o1, File o2) {
            return (int) (o1.lastModified() - o2.lastModified());
        }
    }

    public static class SizeOrder implements Comparator<File>{

        @Override
        public int compare(File o1, File o2) {
            return (int) (o1.length() - o2.length());
        }
    }

    public static void sort(File file){
        ArrayList<File> files = new ArrayList<>();
        addFile(files,file);
        files.sort(new NameOrder());
        for (File f : files)
            System.out.println(f.getName());
    }

    private static void addFile(ArrayList<File> a, File file){
        if (!file.isDirectory())
            a.add(file);
        else
            for (File f : file.listFiles())
                addFile(a,f);

    }

    public static void main(String[] args) {
        File file = new File("/Users/jacobzhang/Documents");
        sort(file);

    }
}
