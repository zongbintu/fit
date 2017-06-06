package fit.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/**
 * Created by tu on  9/1/16.
 */
@SuppressWarnings({ "deprecation", "WeakerAccess" }) // Used by generated code.
public final class Utils {

  public static SharedPreferences getSharedPreference(Context context, String name) {
    return context.getSharedPreferences(name, Context.MODE_PRIVATE);
  }

  public static SharedPreferences.Editor getSharedPreferenceEditor(Context context, String name) {
    return getSharedPreference(context, name).edit();
  }

  public static void apply(SharedPreferences.Editor editor) {
    SharedPreferencesCompat.apply(editor);
  }

  public static boolean checkNonNull(Object o) {
    return o != null;
  }

  public static SharedPreferences.Editor putStringSet(SharedPreferences.Editor editor, String key,
      Set<String> values) {
    return SharedPreferencesCompat.putStringSet(editor, key, values);
  }

  public static Set<String> getStringSet(SharedPreferences sharedPreferences, String key,
      Set<String> defaultValue) {
    return SharedPreferencesCompat.getStringSet(sharedPreferences, key, defaultValue);
  }
}
