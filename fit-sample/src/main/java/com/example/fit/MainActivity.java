package com.example.fit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.fit.model.User;
import fit.Fit;
import java.util.HashSet;

public class MainActivity extends Activity implements View.OnClickListener {
  TextView contentTextView;
  EditText nameEditText;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    contentTextView = (TextView) findViewById(R.id.content_tv);
    nameEditText = (EditText) findViewById(R.id.name_edittext);
    nameEditText.setText(User.class.getName());

    findViewById(R.id.save).setOnClickListener(this);
    findViewById(R.id.clear).setOnClickListener(this);
    findViewById(R.id.get).setOnClickListener(this);
  }

  @Override public void onClick(View view) {
    switch (view.getId()) {
      case R.id.save:
        Fit.save(MainActivity.this, nameEditText.getText().toString(), initUser());
        break;
      case R.id.clear:
        Fit.clear(MainActivity.this, nameEditText.getText().toString(), User.class);
        break;
      case R.id.get:
        contentTextView.setText(
            Fit.get(MainActivity.this, nameEditText.getText().toString(), User.class).toString());
      default:
        return;
    }
  }

  private User initUser() {
    User user = new User();
    HashSet<String> hobby = new HashSet<>();
    hobby.add("swim");
    hobby.add("basketball");
    hobby.add("program");
    user.hobby = hobby;
    user.c = '︾';
    user.score = 12;
    user.integer = 28;
    return user;
  }
}
