package com.example.fit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.fit.model.User;
import fit.Fit;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends Activity {
  TextView contentTextView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    contentTextView = (TextView) findViewById(R.id.content_tv);

    Set<String> hobby = new HashSet<>();
    hobby.add("swim");
    hobby.add("basketball");
    hobby.add("program");

    User user = new User("Three.Tu", 1, 100.99, hobby, "007", 999999L);
    user.c = '︾';
    Fit.save(this, user);

    contentTextView.setText(Fit.get(this, User.class).toString());

    //throw RuntimeException
    //Fit.get(this, Address.class);
  }
}
