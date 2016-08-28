package com.example.fit.model;

import android.content.Context;
import android.content.SharedPreferences;
import fit.MM;

/**
 * @auther Tu enum@foxmail.com
 * @date 16/8/27
 */
public class User_Preference implements MM<User> {

  @Override public void save(Context context, User obj) {
    SharedPreferences sharedPreferences =
        context.getSharedPreferences("user", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("name", obj.name);
    editor.putInt("age", obj.age);
    editor.apply();
  }

  @Override public User get(Context context) {
    SharedPreferences sharedPreferences =
        context.getSharedPreferences("user", Context.MODE_PRIVATE);
    User user = new User();
    user.name = sharedPreferences.getString("name", null);
    user.age = sharedPreferences.getInt("age", 0);
    return user;
  }
}
