package com.example.fit.model;

import fit.SharedPreferenceAble;
import java.util.HashSet;

/**
 * @auther Tu enum@foxmail.com
 * @date 16/8/25
 */
@SharedPreferenceAble public class User {
  public String name;
  public HashSet<String> hobby;

  public byte tbyte;
  public short tshort;
  public int age;
  public long tlong;

  public float tfloat;
  public double score;

  public boolean tboolean;

  public char c;

  public Byte sex;
  public Short s;
  public Integer integer;
  public Long aLong;

  public Float aFloat;
  public Double aDouble;

  public Boolean aBoolean;
  public Character character;

  public User() {

  }

  @Override public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", hobby=" + hobby +
        ", tbyte=" + tbyte +
        ", tshort=" + tshort +
        ", age=" + age +
        ", tlong=" + tlong +
        ", tfloat=" + tfloat +
        ", score=" + score +
        ", tboolean=" + tboolean +
        ", c=" + c +
        ", sex=" + sex +
        ", s=" + s +
        ", integer=" + integer +
        ", aLong=" + aLong +
        ", aFloat=" + aFloat +
        ", aDouble=" + aDouble +
        ", aBoolean=" + aBoolean +
        ", character=" + character +
        '}';
  }
}
