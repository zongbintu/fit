package com.example.fit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.fit.model.User;
import fit.Fit;
import java.util.HashSet;

public class MainActivity extends Activity implements View.OnClickListener {
  TextView contentTextView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    contentTextView = (TextView) findViewById(R.id.content_tv);

    findViewById(R.id.save).setOnClickListener(this);
    findViewById(R.id.clear).setOnClickListener(this);
  }

  @Override public void onClick(View view) {
    switch (view.getId()) {
      case R.id.save:
        Fit.save(MainActivity.this, initUser());
        break;
      case R.id.clear:
        Fit.clear(MainActivity.this, User.class);
        break;
      default:
        return;
    }
    contentTextView.setText(Fit.get(MainActivity.this, User.class).toString());
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
