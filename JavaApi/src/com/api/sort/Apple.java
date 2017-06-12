package com.api.sort;

/**
 * Created by NPOST on 2016-12-06.
 * 객체의 정렬에 사용할 POJO
 */
public class Apple {
    private final int weight;
    private final String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

}
