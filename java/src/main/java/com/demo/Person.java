package com.demo;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Date;

/**
 * Person pojo
 * @author bbolla on 9/3/18
 */
public class Person{


    String ssn;
    Date dateOfBirth;
    String firstName;
    String lastName;
    Double heightIn;
    Double weightLb;


    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getHeightIn() {
        return heightIn;
    }

    public void setHeightIn(Double heightIn) {
        this.heightIn = heightIn;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ssn='" + ssn + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", heightIn=" + heightIn +
                ", weightLb=" + weightLb +
                '}';
    }

    public Double getWeightLb() {
        return weightLb;
    }

    public void setWeightLb(Double weightLb) {
        this.weightLb = weightLb;
    }

    public static Comparator<Person> getFieldComparator(String fieldName) throws NoSuchFieldException {

        Field field = Person.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                try {
                    Comparable p1 = (Comparable) field.get(o1);
                    Comparable p2 = (Comparable) field.get(o2);
                    if(p1 == null && p2 == null) return 0;
                    else if(p1 == null || p2 == null) return 1;
                    else return p1.compareTo(p2);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Failed to access field; check field access level", e);
                }
            }
        };
    }

}
