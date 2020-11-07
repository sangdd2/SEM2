/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.utils;

import java.io.Serializable;
import java.text.Collator;
import java.util.Comparator;

/**
 *
 * @author ducsang
 */
public abstract class NamePair implements Comparator<Object>, Serializable, Comparable<Object> {

    protected NamePair(String name) {
        m_name = name;
        if (m_name == null) {
            m_name = "";
        }
    }   //  NamePair

    /**
     * The Name
     */
    private String m_name;

    /**
     * Returns display value
     *
     * @return name
     */
    public String getName() {
        return m_name;
    }   //  getName

    /**
     * Returns Key or Value as String
     *
     * @return String or null
     */
    public abstract String getID();

    /**
     * Comparator Interface (based on toString value)
     *
     * @param o1 Object 1
     * @param o2 Object 2
     * @return compareTo value
     */
    public int compare(Object o1, Object o2) {
        String s1 = o1 == null ? "" : o1.toString();
        String s2 = o2 == null ? "" : o2.toString();
        return s1.compareTo(s2);    //  sort order ??
    }	//	compare

    /**
     * Comparator Interface (based on toString value)
     *
     * @param o1 Object 1
     * @param o2 Object 2
     * @return compareTo value
     */
    public int compare(NamePair o1, NamePair o2) {
        String s1 = o1 == null ? "" : o1.toString();
        String s2 = o2 == null ? "" : o2.toString();
        Collator collator = Collator.getInstance();
        return collator.compare(s1, s2);
    }	//	compare

    /**
     * Comparable Interface (based on toString value)
     *
     * @param o the Object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is
     * less than, equal to, or greater than the specified object.
     */
    public int compareTo(Object o) {
        return compare(this, o);
    }	//	compareTo

    /**
     * Comparable Interface (based on toString value)
     *
     * @param o the Object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is
     * less than, equal to, or greater than the specified object.
     */
    public int compareTo(NamePair o) {
        return compare(this, o);
    }	//	compareTo

    /**
     * To String - returns name
     *
     * @return Name
     */
    public String toString() {
        return m_name;
    }	//	toString

    /**
     * To String - detail
     *
     * @return String in format ID=Name
     */
    public String toStringX() {
        StringBuilder sb = new StringBuilder(getID());
        sb.append("=").append(m_name);
        return sb.toString();
    }	//	toStringX
}
