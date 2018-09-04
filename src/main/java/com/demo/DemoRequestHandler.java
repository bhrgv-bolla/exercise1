package com.demo;

import java.util.*;

;

/**
 * Demo class for sorting person results
 *
 * @author bbolla on 9/3/18
 */
public class DemoRequestHandler {

    public static List<Person> sort(Iterable<Person> people, final String sortField,
                                    String ascending) throws NoSuchFieldException {
        boolean asc = new Boolean(ascending);

        final List<Person> peopleList = new ArrayList<>();
        people.forEach(p -> peopleList.add(p));

        Comparator<Person> customComparator = getPersonComparator(sortField, asc);

        Collections.sort(peopleList, customComparator);
        return peopleList;
    }

    private static Comparator<Person> getPersonComparator(String sortField, boolean asc) throws NoSuchFieldException {
        return asc? Person.getFieldComparator(sortField): Person.getFieldComparator(sortField).reversed();
    }



    public static void main(String[] args) throws NoSuchFieldException {
        Person p1 = new Person();
        p1.setLastName("a");
        p1.setDateOfBirth(new Date());
        Person p2 = new Person();
        p2.setDateOfBirth(new Date(128,9, 1));
        Person p3 = new Person();
        p3.setDateOfBirth(null);

        List<Person> people = Arrays.asList(p1, p2, p3);

        List<Person> sortedPeople = sort(people, "dateOfBirth", "true");

        System.out.println(sortedPeople);

        List<Person> sortedPeople2 = sort(people, "dateOfBirth", "False");

        System.out.println(sortedPeople2);

        sort(people, "A FIELD THAT iSn't there", "true");



    }
}
