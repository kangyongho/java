package com.api.sort;

import java.util.*;

/**
 * Created by NPOST on 2016-12-06.
 * 1. 배열 정렬.
 * 2. 리스트 정렬.
 * 3. apple 객체 정렬.
 * 
 * Arrays.sort는 배열을 정렬하는데 쓴다.
 * - object[], object[]+Comparator, 배열 (크게 3가지)을 파라미터로 받아서 정렬한다.
 *
 * Collections는 List를 정렬하는데 쓴다.
 * - List, List+Comparator를 인자로 받아서 정렬한다.
 *
 * Comparator는 인터페이스로 구현하여 쓴다.
 *
 * String은 compareTo 메소드를 구현하고 있어서 Comparator 객체를 구현할때 사용하도록 한다.
 *
 * Comparator와 달리 객체를 정의할 때 Comparable 인터페이스를 구현하여 사용할 수도 있다.
 * link: http://www.programcreek.com/2011/12/examples-to-demonstrate-comparable-vs-comparator-in-java/
 *
 * List.sort에 메서드레퍼런스를 넘겨줘서 정렬할 수 있다.
 * java 8 부터 추가
 */
public class AppleComparator {

    public static void main(String[] args) {
        /* 1. 프리미티브 타입 배열 정렬 (정수) */
        System.out.println("1-1. 프리미티브 타입 배열 정렬 (정수)");
        int[] intArrarys = {3, 1, 4, 2, 5};
        Arrays.sort(intArrarys);
        for (int array : intArrarys) {
            System.out.printf("%d ", array);
        }
        //Arrays.sort(intArrarys, Collections.reverseOrder()); //intArray2는 Object가 아니라고 에러난다.

        System.out.println("\n\n1-2. 프리미티브 타입 배열 내림차순 정렬 (정수)");
        // 배열의 내림차순 정렬은 직접 구현해서 써야한다.
        int[] descIntArrarys = sortDes(intArrarys);
        for (int array : descIntArrarys) {
            System.out.printf("%d ", array);
        }

        /* 2. 레퍼런스 타입 배열 정렬 (문자) */
        System.out.println("\n\n2-1. 레퍼런스 타입 배열 정렬 (String)");
        String[] strArrays = {"Broccoli", "Apple", "Durian", "Coffee"};
        Arrays.sort(strArrays);
        for (String array : strArrays) {
            System.out.printf("%s ", array);
        }

        System.out.println("\n\n2-2. 레퍼런스 타입 배열 내림차순 정렬 (String)");
        Arrays.sort(strArrays, Collections.reverseOrder()); // String은 Object다.
        for (String array : strArrays) {
            System.out.printf("%s ", array);
        }

        /* 3. 레퍼런스 타입 리스트 정렬 (정수) */
        System.out.println("\n\n3-1. 레퍼런스 타입 리스트 정렬 (정수)");
        List<Integer> intArrarys2 = Arrays.asList(3, 1, 4, 2, 5);
        Collections.sort(intArrarys2); //리스트 정렬에는 Collections 쓴다.
        for (int array : intArrarys2) {
            System.out.printf("%d ", array);
        }
        System.out.println("\n\n3-2. 레퍼런스 타입 리스트 내림차순 정렬 (정수)");
        Collections.sort(intArrarys2, Collections.reverseOrder());
        for (int array : intArrarys2) {
            System.out.printf("%d ", array);
        }
        //Arrays.sort(intArrarys2, Collections.reverseOrder()); //List는 Object가 아니라고 에러난다.

        /* 4. 레퍼런스 타입 배열 정렬 (문자) */
        System.out.println("\n\n4-1. 레퍼런스 타입 배열 정렬 (String)");
        String[] strArrays2 = new String[] {"Broccoli", "Apple", "Durian", "Coffee"};
        Arrays.sort(strArrays2);
        for (String array : strArrays2) {
            System.out.printf("%s ", array);
        }
        System.out.println("\n\n4-2. 레퍼런스 타입 배열 내림차순 정렬 (String)");
        Arrays.sort(strArrays2, Collections.reverseOrder());
        for (String array : strArrays2) {
            System.out.printf("%s ", array);
        }

        /* 5. Object 타입 (레퍼런스 객체) 배열 정렬 */
        System.out.println("\n\n5. Object 타입 (레퍼런스 객체) 배열 정렬");
        Apple[] apples = new Apple[3];
        apples[0] = new Apple(25, "yellow");
        apples[1] = new Apple(15, "red");
        apples[2] = new Apple(35, "green");
        //Arrays.sort(apples); //Cast 에러가 난다.

        /* 내부 static 클래스 사용, 일반 클래스로 정의시 new AppleComparator.new ColorComparator 형태로 써야한다. */
        System.out.println("\n5-1. String 정렬");
        Arrays.sort(apples, new ColorComparator());
        for (Apple apple : apples) {
            System.out.printf("%s ", apple.getColor());
        }
        System.out.println("\n\n5-1. String 내림차순 정렬");
        Arrays.sort(apples, new ColorComparatorDesc());
        for (Apple apple : apples) {
            System.out.printf("%s ", apple.getColor());
        }

        System.out.println("\n\n5-2. 정수 정렬");
        Arrays.sort(apples, new WeightComparator());
        for (Apple apple : apples) {
            System.out.printf("%d ", apple.getWeight());
        }
        System.out.println("\n\n5-2. 정수 내림차순 정렬");
        Arrays.sort(apples, new WeightComparatorDesc());
        for (Apple apple : apples) {
            System.out.printf("%d ", apple.getWeight());
        }

        /* Object 타입 (레퍼런스) 리스트 정렬 */
        System.out.println("\n\n6. Object 타입 (레퍼런스) 리스트 정렬");
        List<Apple> appleLists = new ArrayList<>();
        appleLists.add(new Apple(25, "yellow"));
        appleLists.add(new Apple(15, "red"));
        appleLists.add(new Apple(35, "green"));

        System.out.println("\n6-1. String 정렬");
        //Arrays.sort(appleLists, new ColorComparator()); // Arrays.sort 로는 Object 타입만 넣을 수 있고, List 타입은 넣을 수 없다.
        Collections.sort(appleLists, new ColorComparator());
        for (Apple appleList : appleLists) {
            System.out.printf("%s ", appleList.getColor());
        }
        System.out.println("\n\n6-1. String 내림차순 정렬");
        Collections.sort(appleLists, new ColorComparatorDesc());
        for (Apple appleList : appleLists) {
            System.out.printf("%s ", appleList.getColor());
        }

        System.out.println("\n\n6-1. 정수 정렬");
        Collections.sort(appleLists, new WeightComparator());
        for (Apple appleList : appleLists) {
            System.out.printf("%d ", appleList.getWeight());
        }
        System.out.println("\n\n6-1. 정수 내림차순 정렬");
        Collections.sort(appleLists, new WeightComparatorDesc());
        for (Apple appleList : appleLists) {
            System.out.printf("%d ", appleList.getWeight());
        }

        System.out.println("\n\n6-2. List에서 sort를 바로 호출 java8 - String 정렬");
        appleLists.sort(new ColorComparator());
        for (Apple appleList : appleLists) {
            System.out.printf("%s ", appleList.getColor());
        }
        System.out.println("\n\n6-2. List에서 sort를 바로 호출 java8 - String 내림차순 정렬");
        appleLists.sort(new ColorComparatorDesc());
        for (Apple appleList : appleLists) {
            System.out.printf("%s ", appleList.getColor());
        }

        /* 클래스 구현을 바꾸고 싶지 않을 때 Comparator를 구현해서 쓴다.*/
        /* 익명 클래스 사용 */
//        Arrays.sort(apples, new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                String color1 = o1.getColor();
//                String color2 = o2.getColor();
//                return color1.compareTo(color2);
//            }
//        });

        System.out.println("\n\n6-3. List에서 sort를 바로 호출 java8 - 메서드 레퍼런스 정렬");
        appleLists.sort(Comparator.comparing(Apple::getColor));
        for (Apple appleList : appleLists) {
            System.out.printf("%s ", appleList.getColor());
        }
        System.out.println("\n\n6-2. List에서 sort를 바로 호출 java8 - 메서드 레퍼런스 내림차순 정렬");
        appleLists.sort(Comparator.comparing(Apple::getColor).reversed());
        for (Apple appleList : appleLists) {
            System.out.printf("%s ", appleList.getColor());
        }
    }

    // 배열의 내림차순 정렬
    static int[] sortDes(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[(array.length-1)-i];
            array[(array.length-1)-i] = temp;
        }

        return array;
    }

    // Comparator 구현체 (비교할 필드마다 구현체를 만들어야 한다.)
    static class ColorComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            String color1 = o1.getColor();
            String color2 = o2.getColor();
            return color1.compareTo(color2); //String compareTo 메서드
        }
    }
    static class ColorComparatorDesc implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            String color1 = o1.getColor();
            String color2 = o2.getColor();
            return color2.compareTo(color1); //String compareTo 메서드
        }
    }
    static class WeightComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            int weight1 = o1.getWeight();
            int weight2 = o2.getWeight();

            if (weight1 > weight2) {
                return 1;
            }
            else if (weight1 < weight2) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }
    static class WeightComparatorDesc implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            int weight1 = o1.getWeight();
            int weight2 = o2.getWeight();

            if (weight1 > weight2) {
                return -1;
            }
            else if (weight1 < weight2) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
}
