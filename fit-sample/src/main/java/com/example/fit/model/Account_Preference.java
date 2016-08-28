package com.example.fit.model;

import android.content.Context;
import android.content.SharedPreferences;
import fit.MM;

/**
 * @auther Tu enum@foxmail.com
 * @date 16/8/27
 */
public class Account_Preference implements MM<Account> {

  @Override public void save(Context context, Account obj) {
    SharedPreferences sharedPreferences =
        context.getSharedPreferences("account", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("user_name", obj.userName);
    editor.putString("pwd", obj.pwd);
    editor.apply();
  }

  @Override public Account get(Context context) {
    SharedPreferences sharedPreferences =
        context.getSharedPreferences("account", Context.MODE_PRIVATE);
    Account account = new Account();
    account.userName = sharedPreferences.getString("user_name", null);
    account.pwd = sharedPreferences.getString("pwd", null);
    return account;
  }
}