// Generated code from Fit. Do not modify!
package test;

import android.content.Context;
import android.content.SharedPreferences;
import fit.MM;
import fit.internal.Utils;

public class Test_Preference1 implements MM<Test> {
  @Override public void save(Context context, Test obj) {
    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, "test.Test");
    editor.putString("aT", obj.aT);
    editor.commit();
  }

  @Override public Test get(Context context) {
    SharedPreferences sharedPreferences = context.getSharedPreferences("test.Test", Context.MODE_PRIVATE);
    Test obj = new Test();
    obj.aT = sharedPreferences.getString("aT", null);
    return obj;
  }

  @Override public void clear(Context context) {
    Utils.getSharedPreferenceEditor(context, "test.Test").clear().commit();
  }
}
