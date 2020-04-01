package fit.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.Closeable;
import java.io.IOException;
import java.util.Set;

/**
 * Created by tu on  9/1/16.
 */
// Used by generated code.
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

  public static void closeQuietly(Closeable closeable) {
    try {
      if (closeable != null) {
        closeable.close();
      }
    } catch (IOException ioe) {
      // ignore
    }
  }
}
