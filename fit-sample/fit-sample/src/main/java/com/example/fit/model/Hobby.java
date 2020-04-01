package com.example.fit.model;

import java.io.Serializable;

/**
 * @author Tu enum@foxmail.com.
 */

public class Hobby implements Serializable {
  private static final long serialVersionUID = -22707733180789423L;
  private Long id;
  private String code;
  private String desc;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  @Override public String toString() {
    return "Hobby{" + "id=" + id + ", code='" + code + '\'' + ", desc='" + desc + '\'' + '}';
  }
}
