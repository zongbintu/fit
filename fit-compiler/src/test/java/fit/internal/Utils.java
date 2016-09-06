package fit.internal;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @auther Tu enum@foxmail.com
 * @date 9/1/16
 */
@SuppressWarnings({ "deprecation", "WeakerAccess" }) // Used by generated code.
public final class Utils {

  public static SharedPreferences.Editor getSharedPreferenceEditor(Context context, String name) {
    SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    return sharedPreferences.edit();
  }

  public static boolean checkNonNull(Object o) {
    return o != null;
  }
}
