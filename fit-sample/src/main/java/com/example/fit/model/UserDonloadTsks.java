package com.example.fit.model;

import fit.SharedPreferenceAble;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Tu enum@foxmail.com.
 */
@SharedPreferenceAble
public class UserDonloadTsks {
  public Map<Integer,String> downloadTaskList = new LinkedHashMap<>();

  public Map<Integer, String> getDownloadTaskList() {
    return downloadTaskList;
  }

  public void setDownloadTaskList(Map<Integer, String> downloadTaskList) {
    this.downloadTaskList = downloadTaskList;
  }

  @Override public String toString() {
    return "UserDonloadTsks{" + "downloadTaskList=" + downloadTaskList + '}';
  }
}
