package com.example.fit.model;

import fit.SharedPreferenceAble;
import java.util.Set;

/**
 * @auther Tu enum@foxmail.com
 * @date 16/8/25
 */
@SharedPreferenceAble public class User {
  public static final String TAG = User.class.getSimpleName();
  public String name;
  public int age;
  public double score;
  public Set<String> hobby;
  public char c;
  public short s;
  public byte sex;
  public float f;
  private String idcard;
  Long bankcard;

  public User() {

  }

  public User(String name, int age, double score, Set<String> hobby, String idcard, Long bankcard) {
    this.name = name;
    this.age = age;
    this.score = score;
    this.hobby = hobby;
    this.idcard = idcard;
    this.bankcard = bankcard;
  }

  @Override public String toString() {
    return "User{" +
        "TAG='" + TAG + '\'' +
        ",name='" + name + '\'' +
        ", age=" + age +
        ", score=" + score +
        ", hobby=" + hobby +
        ", c=" + c +
        ", s=" + s +
        ", sex=" + sex +
        ", f=" + f +
        ", idcard='" + idcard + '\'' +
        ", bankcard=" + bankcard +
        '}';
  }
}
