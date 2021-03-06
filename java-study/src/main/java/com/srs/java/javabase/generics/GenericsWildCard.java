package com.srs.java.javabase.generics;

import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 * @author shaorensheng
 * @date 2021/9/22
 */
public class GenericsWildCard {

    public static void main(String[] args) {
        GenericsWildCard wildCard = new GenericsWildCard();
        List<Person> personList = new ArrayList<>();
        List<Father> fatherList = new ArrayList<>();
        List<Son> sonList = new ArrayList<>();
        List<Grandson> grandsonList = new ArrayList<>();
        wildCard.show(personList);
        wildCard.show(fatherList);
        wildCard.show(sonList);
        wildCard.show(grandsonList);
//        wildCard.show1(personList);
        wildCard.show1(fatherList);
        wildCard.show1(sonList);
        wildCard.show1(grandsonList);
        wildCard.show2(personList);
        wildCard.show2(fatherList);
        wildCard.show2(sonList);
//        wildCard.show2(grandsonList);

//        wildCard.say(new Person());
        wildCard.say(new Father());
        wildCard.say(new Son());
        wildCard.say(new Grandson());
    }

    /**
     * super通配符
     * @param list
     */
    public void show2(List<? super Son> list) {
        for (Object o : list) {

        }
    }

    /**
     * 无限定通配符
     * @param list
     */
    public void show(List<?> list) {
        for (Object o : list) {
        }
    }

    /**
     * extends通配符
     * @param list
     */
    public void show1(List<? extends Father> list) {
        for (Father father : list) {
        }
    }



    public <T extends Father> void say(T t) {

    }

    public <T> T say1(T t) {
        return t;
    }


}

class Person{}
class Father extends Person{}
class Son extends Father{}
class Grandson extends Son{}

