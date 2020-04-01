package fit;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import fit.internal.FileObjectUtil;
import fit.internal.Utils;
import java.util.Map;
import java.util.Set;

/**
 * Created by tu on 16/8/27.
 */
public final class Fit {

  public static final String TAG = "Fit";

  private static MM instanceMM(Class clazz) {
    try {
      Class<? extends MM> mmClass = findMMForClass(clazz);
      return mmClass.newInstance();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("Miss SharedPreferenceAble", e);
    } catch (InstantiationException e) {
      throw new RuntimeException(clazz.getName() + " can't instance ", e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(clazz.getName() + " can't instance ", e);
    }
  }

  private static Class<? extends MM> findMMForClass(Class clazz) throws ClassNotFoundException {
    return (Class<? extends MM>) Class.forName(clazz.getName() + "_Preference");
  }

  public static void save(@NonNull Context context, @NonNull Object o) {
    save(context, o.getClass().getName(), o);
  }

  public static void save(@NonNull Context context, String name, @NonNull Object o) {
    Utils.apply(saveEditor(context, name, o));
  }

  @NonNull
  public static SharedPreferences.Editor saveEditor(@NonNull Context context, @NonNull Object o) {
    return saveEditor(context, o.getClass().getName(), o);
  }

  @NonNull public static SharedPreferences.Editor saveEditor(@NonNull Context context, String name,
      @NonNull Object o) {
    Class clazz = o.getClass();
    return instanceMM(clazz).save(context, name, o);
  }

  public static <T> T get(@NonNull Context context, @NonNull Class<T> clazz) {
    return get(context, clazz.getName(), clazz);
  }

  public static <T> T get(@NonNull Context context, String name, @NonNull Class<T> clazz) {
    return (T) instanceMM(clazz).get(context, name);
  }

  public static void clear(@NonNull Context context, @NonNull Class clazz) {
    clear(context, clazz, clazz.getName());
  }

  public static void clear(@NonNull Context context, @NonNull Class clazz, String name) {
    Utils.apply(clearEditor(context, name));
    instanceMM(clazz).clearFields(context,name);
  }

  /**
   * @param context {@link Context}
   * @param clazz {@link Class}
   * @return {@link SharedPreferences.Editor}
   */
  @NonNull public static SharedPreferences.Editor clearEditor(@NonNull Context context,
      @NonNull Class clazz) {
    return clearEditor(context, clazz.getName());
  }

  /**
   * @param context {@link Context}
   * @param name SharedPreferences's name
   * @return {@link SharedPreferences.Editor}
   */
  @NonNull public static SharedPreferences.Editor clearEditor(@NonNull Context context,
      String name) {
    return edit(context, name).clear();
  }

  /**
   * clear Object filed
   *
   * @param context {@link Context}
   * @param name SharedPreferences's name
   * @param fieldName clazz's Object field name.
   * @return true if the Object field clear was successfully; else false.
   * @since 1.0.1
   */
  public static boolean clearObjectField(Context context, String name, String fieldName) {
    return FileObjectUtil.deleteFile(context, name + "." + fieldName);
  }

  /**
   * Set a String value in the preferences editor
   *
   * @param key The name of the preference to modify.
   * @param value The new value for the preference.
   * @return Returns a reference to the same Editor object, so you can
   * chain put calls together.
   */
  public static SharedPreferences.Editor putString(Context context, String key, String value) {
    return putString(context, context.getPackageName(), key, value);
  }

  public static SharedPreferences.Editor putString(Context context, String name, String key,
      String value) {
    return edit(context, name).putString(key, value);
  }

  public static SharedPreferences.Editor putStringSet(Context context, String key,
      Set<String> values) {
    return putStringSet(context, context.getPackageName(), key, values);
  }

  public static SharedPreferences.Editor putStringSet(Context context, String name, String key,
      Set<String> values) {
    return edit(context, name).putStringSet(key, values);
  }

  public static SharedPreferences.Editor putInt(Context context, String key, int value) {
    return putInt(context, context.getPackageName(), key, value);
  }

  public static SharedPreferences.Editor putInt(Context context, String name, String key,
      int value) {
    return edit(context, name).putInt(key, value);
  }

  public static SharedPreferences.Editor putLong(Context context, String key, long value) {
    return putLong(context, context.getPackageName(), key, value);
  }

  public static SharedPreferences.Editor putLong(Context context, String name, String key,
      long value) {
    return edit(context, name).putLong(key, value);
  }

  public static SharedPreferences.Editor putFloat(Context context, String key, float value) {
    return putFloat(context, context.getPackageName(), key, value);
  }

  public static SharedPreferences.Editor putFloat(Context context, String name, String key,
      float value) {
    return edit(context, name).putFloat(key, value);
  }

  public static SharedPreferences.Editor putBoolean(Context context, String key, boolean value) {
    return putBoolean(context, context.getPackageName(), key, value);
  }

  public static SharedPreferences.Editor putBoolean(Context context, String name, String key,
      boolean value) {
    return edit(context, name).putBoolean(key, value);
  }

  public static SharedPreferences.Editor remove(Context context, String key) {
    return remove(context, context.getPackageName(), key);
  }

  public static SharedPreferences.Editor remove(Context context, String name, String key) {
    return edit(context, name).remove(key);
  }

  public static SharedPreferences.Editor clear(Context context, String name) {
    return edit(context, name).clear();
  }

  public static SharedPreferences.Editor clear(Context context) {
    return clear(context, context.getPackageName());
  }

  // ----------------------get
  public static Map<String, ?> getAll(Context context, String name) {
    return Utils.getSharedPreference(context, name).getAll();
  }

  public static Map<String, ?> getAll(Context context) {
    return getAll(context, context.getPackageName());
  }

  public static String getString(Context context, String key, String defValue) {
    return getString(context, context.getPackageName(), key, defValue);
  }

  public static String getString(Context context, String name, String key, String defValue) {
    return Utils.getSharedPreference(context, name).getString(key, defValue);
  }

  public static Set<String> getStringSet(Context context, String key, Set<String> defValues) {
    return getStringSet(context, context.getPackageName(), key, defValues);
  }

  public static Set<String> getStringSet(Context context, String name, String key,
      Set<String> defValues) {
    return Utils.getSharedPreference(context, name).getStringSet(key, defValues);
  }

  public static int getInt(Context context, String key, int defValue) {
    return getInt(context, context.getPackageName(), key, defValue);
  }

  public static int getInt(Context context, String name, String key, int defValue) {
    return Utils.getSharedPreference(context, name).getInt(key, defValue);
  }

  public static long getLong(Context context, String key, long defValue) {
    return getLong(context, context.getPackageName(), key, defValue);
  }

  public static long getLong(Context context, String name, String key, long defValue) {
    return Utils.getSharedPreference(context, name).getLong(key, defValue);
  }

  public static float getFloat(Context context, String key, float defValue) {
    return getFloat(context, context.getPackageName(), key, defValue);
  }

  public static float getFloat(Context context, String name, String key, float defValue) {
    return Utils.getSharedPreference(context, name).getFloat(key, defValue);
  }

  public static boolean getBoolean(Context context, String key, boolean defValue) {
    return getBoolean(context, context.getPackageName(), key, defValue);
  }

  public static boolean getBoolean(Context context, String name, String key, boolean defValue) {
    return Utils.getSharedPreference(context, name).getBoolean(key, defValue);
  }

  public static boolean contains(Context context, String key) {
    return contains(context, context.getPackageName());
  }

  public static boolean contains(Context context, String name, String key) {
    return Utils.getSharedPreference(context, name).contains(key);
  }

  public static SharedPreferences.Editor edit(Context context) {
    return edit(context, context.getPackageName());
  }

  public static SharedPreferences.Editor edit(Context context, String name) {
    return Utils.getSharedPreferenceEditor(context, name);
  }
}