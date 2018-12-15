package cn.dovahkiin.common;
import java.util.*;
import java.util.concurrent.*;

/*
 * @desc ArrayList遍历方式和效率的测试程序。
 *
 * @author skywang
 */
public class ArrayListRandomAccessTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i=0; i<100000; i++)
            list.add(i);
        //isRandomAccessSupported(list);
        iteratorThroughRandomAccess(list) ;
        iteratorThroughIterator(list) ;
        iteratorThroughFor2(list) ;

    }

    private static void isRandomAccessSupported(List list) {
        if (list instanceof RandomAccess) {
            System.out.println("RandomAccess implemented!");
        } else {
            System.out.println("RandomAccess not implemented!");
        }

    }

    public static void iteratorThroughRandomAccess(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (int i=0; i<list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughRandomAccess：" + interval+" ms");
    }

    public static void iteratorThroughIterator(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Iterator iter = list.iterator(); iter.hasNext(); ) {
            iter.next();
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughIterator：" + interval+" ms");
    }


    public static void iteratorThroughFor2(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Object obj:list)
            ;
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughFor2：" + interval+" ms");
    }

    // toArray(T[] contents)调用方式一
    public static Integer[] vectorToArray1(ArrayList<Integer> v) {
        Integer[] newText = new Integer[v.size()];
        v.toArray(newText);
        return newText;
    }

    // toArray(T[] contents)调用方式二。最常用！
    public static Integer[] vectorToArray2(ArrayList<Integer> v) {
        Integer[] newText = (Integer[])v.toArray(new Integer[0]);
        return newText;
    }

    // toArray(T[] contents)调用方式三
    public static Integer[] vectorToArray3(ArrayList<Integer> v) {
        Integer[] newText = new Integer[v.size()];
        Integer[] newStrings = (Integer[])v.toArray(newText);
        return newStrings;
    }

}