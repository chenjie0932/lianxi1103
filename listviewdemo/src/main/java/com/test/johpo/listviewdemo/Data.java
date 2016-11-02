package com.test.johpo.listviewdemo;

/**
 * Created by johpo on 2016/11/2 0002.
 */
public class Data {
  public boolean isCheck;
  private String name;
  private boolean isChecked;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public boolean isChecked() {
    return isChecked;
  }
  public void setChecked(boolean isChecked) {
    this.isChecked = isChecked;
  }
  public Data(String name, boolean isChecked) {
    super();
    this.name = name;
    this.isChecked = isChecked;
  }
}
