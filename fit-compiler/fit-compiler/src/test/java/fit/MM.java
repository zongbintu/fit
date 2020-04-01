package fit;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by tu on 16/8/27.
 */
public interface MM<T> {

  SharedPreferences.Editor save(Context context, String name, T obj);

  T get(Context context, String name);

  /**
   * clear Object fields
   *
   * @param context {@link Context}
   * @param name SharedPreference's name
   * @since 1.0.1
   */
  void clearFields(Context context, String name);
}
