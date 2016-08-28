package com.example.fit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.fit.model.Account;
import com.example.fit.model.Address;
import com.example.fit.model.User;
import fit.Fit;

//@Test("haha")
public class MainActivity extends Activity {
  TextView contentTextView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    contentTextView = (TextView) findViewById(R.id.content_tv);

    User user = new User("Three.Tu", 1);
    Fit.save(this, user);

    Account account = new Account("un", "111111");
    Fit.save(this, account);

    Address address = new Address();
    address.address = "China";

    Fit.save(this, address);

    contentTextView.setText(
        Fit.get(this, User.class).name + "\n" + Fit.get(this, Account.class).userName);
  }
}
