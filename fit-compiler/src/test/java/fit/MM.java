package fit;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @auther Tu enum@foxmail.com
 * @date 16/8/27
 */
public interface MM<T> {

  SharedPreferences.Editor save(Context context, String name, T obj);

  T get(Context context, String name);
}
