package com.example.fit.model;

import java.io.Serializable;

/**
 * @author Tu enum@foxmail.com.
 */

public class Job implements Serializable {
  private static final long serialVersionUID = 850978305104122108L;
  private String title;
  private Double salary;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  @Override public String toString() {
    return "Job{" + "title='" + title + '\'' + ", salary=" + salary + '}';
  }
}
