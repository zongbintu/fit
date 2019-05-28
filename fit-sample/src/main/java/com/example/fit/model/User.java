package com.example.fit.model;

import fit.PreferenceIgnore;
import fit.SharedPreferenceAble;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * @auther Tu enum@foxmail.com
 * @date 16/8/25
 */
@SharedPreferenceAble public class User {
  public String name;
  public HashSet<String> hobby;
  @PreferenceIgnore
  public String aa;

  @PreferenceIgnore
  private Object cc;

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

  public List<Hobby> hobbies;
  private Job job;
  private Date birthDay;

  private transient Job transientJob;

  public User() {

  }

  public Job getTransientJob() {
    return transientJob;
  }

  public void setTransientJob(Job transientJob) {
    this.transientJob = transientJob;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HashSet<String> getHobby() {
    return hobby;
  }

  public void setHobby(HashSet<String> hobby) {
    this.hobby = hobby;
  }

  public byte getTbyte() {
    return tbyte;
  }

  public void setTbyte(byte tbyte) {
    this.tbyte = tbyte;
  }

  public short getTshort() {
    return tshort;
  }

  public void setTshort(short tshort) {
    this.tshort = tshort;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public long getTlong() {
    return tlong;
  }

  public void setTlong(long tlong) {
    this.tlong = tlong;
  }

  public float getTfloat() {
    return tfloat;
  }

  public void setTfloat(float tfloat) {
    this.tfloat = tfloat;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public boolean isTboolean() {
    return tboolean;
  }

  public void setTboolean(boolean tboolean) {
    this.tboolean = tboolean;
  }

  public char getC() {
    return c;
  }

  public void setC(char c) {
    this.c = c;
  }

  public Byte getSex() {
    return sex;
  }

  public void setSex(Byte sex) {
    this.sex = sex;
  }

  public Short getS() {
    return s;
  }

  public void setS(Short s) {
    this.s = s;
  }

  public Integer getInteger() {
    return integer;
  }

  public void setInteger(Integer integer) {
    this.integer = integer;
  }

  public Long getaLong() {
    return aLong;
  }

  public void setaLong(Long aLong) {
    this.aLong = aLong;
  }

  public Float getaFloat() {
    return aFloat;
  }

  public void setaFloat(Float aFloat) {
    this.aFloat = aFloat;
  }

  public Double getaDouble() {
    return aDouble;
  }

  public void setaDouble(Double aDouble) {
    this.aDouble = aDouble;
  }

  public Boolean getaBoolean() {
    return aBoolean;
  }

  public void setaBoolean(Boolean aBoolean) {
    this.aBoolean = aBoolean;
  }

  public Character getCharacter() {
    return character;
  }

  public void setCharacter(Character character) {
    this.character = character;
  }

  public List<Hobby> getHobbies() {
    return hobbies;
  }

  public void setHobbies(List<Hobby> hobbies) {
    this.hobbies = hobbies;
  }

  public Job getJob() {
    return job;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  public Date getBirthDay() {
    return birthDay;
  }

  public Object getCc() {
    return cc;
  }

  public void setCc(Object cc) {
    this.cc = cc;
  }

  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }

  @Override public String toString() {
    return "User{"
        + "name='"
        + name
        + '\''
        + ", hobby="
        + hobby
        + ", tbyte="
        + tbyte
        + ", tshort="
        + tshort
        + ", age="
        + age
        + ", tlong="
        + tlong
        + ", tfloat="
        + tfloat
        + ", score="
        + score
        + ", tboolean="
        + tboolean
        + ", c="
        + c
        + ", sex="
        + sex
        + ", s="
        + s
        + ", integer="
        + integer
        + ", aLong="
        + aLong
        + ", aFloat="
        + aFloat
        + ", aDouble="
        + aDouble
        + ", aBoolean="
        + aBoolean
        + ", character="
        + character
        + ", hobbies="
        + hobbies
        + ", job="
        + job
        + ", birthDay="
        + birthDay
        + ", transientJob="
        + transientJob
        + '}';
  }
}
