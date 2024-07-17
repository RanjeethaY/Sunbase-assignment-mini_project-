package com.dao.model;

public class Sorting implements Comparable<Sorting> {
@Override
public int compareTo(Sorting s2) {
	Sorting s1=this;
	return s1.compareTo(s2);
}
}
