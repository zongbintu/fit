package com.example.fit.model;

import fit.SharedPreferenceAble;

/**
 * @auther Tu enum@foxmail.com
 * @date 9/5/16
 */
@SharedPreferenceAble public class FaithfulUser extends User {
  public FaithfulUser() {
  }

  public long joinTime;

  class Inner {
    public char cInner;
  }
}
