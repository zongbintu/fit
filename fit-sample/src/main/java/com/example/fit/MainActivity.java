package com.example.fit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fit.model.Hobby;
import com.example.fit.model.Job;
import com.example.fit.model.User;
import com.example.fit.model.UserDonloadTsks;
import fit.Fit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

        UserDonloadTsks userDonloadTsks = new UserDonloadTsks();
        Map<Integer, String> downloadTaskList = new LinkedHashMap<>();
        downloadTaskList.put(1, "1s");
        userDonloadTsks.setDownloadTaskList(downloadTaskList);

        Fit.save(MainActivity.this, userDonloadTsks);

        Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_SHORT).show();
        break;
      case R.id.clear:
        Fit.clear(MainActivity.this, User.class, nameEditText.getText().toString());

        Fit.clear(MainActivity.this, UserDonloadTsks.class);

        Toast.makeText(MainActivity.this, "clear", Toast.LENGTH_SHORT).show();
        break;
      case R.id.get:
        contentTextView.setText(
            Fit.get(MainActivity.this, nameEditText.getText().toString(), User.class).toString()
                + "\n"
                + Fit.get(MainActivity.this, UserDonloadTsks.class).toString());
        Toast.makeText(MainActivity.this, "get", Toast.LENGTH_SHORT).show();
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

    List<Hobby> hobbies = new ArrayList<>();
    Hobby hobby1 = new Hobby();
    hobby1.setCode("1");
    hobby1.setDesc("1");
    hobby1.setId(1l);
    hobbies.add(hobby1);
    Hobby hobby2 = new Hobby();
    hobby2.setCode("2");
    hobby2.setDesc("2");
    hobby2.setId(2l);
    hobbies.add(hobby2);
    user.hobbies = hobbies;

    Job job = new Job();
    job.setSalary(10d);
    job.setTitle("public job");
    user.setJob(job);

    Job transientJob = new Job();
    transientJob.setSalary(1d);
    transientJob.setTitle("transient job");
    user.setTransientJob(job);

    return user;
  }
}
