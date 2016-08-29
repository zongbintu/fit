package com.example.fit.model;

import fit.SharedPreferenceAble;
import java.util.Set;

/**
 * @auther Tu enum@foxmail.com
 * @date 16/8/25
 */
@SharedPreferenceAble public class User {
  public String name;
  public int age;
  public double score;
  public Set<String> hobby;
  public char c;
  public short s;
  public byte sex;
  public float f;

  public User() {
  }

  public User(String name, int age, double score, Set<String> hobby) {
    this.name = name;
    this.age = age;
    this.score = score;
    this.hobby = hobby;
  }
}
