package fit;

import android.content.Context;
import android.content.SharedPreferences;
import fit.internal.Utils;

/**
 * @auther Tu enum@foxmail.com
 * @date 16/8/27
 */
public final class Fit {

  public static void save(Context context, Object o) {
    save(context, o.getClass().getName(), o);
  }

  public static void save(Context context, String name, Object o) {
    Utils.apply(saveEditor(context, name, o));
  }

  public static SharedPreferences.Editor saveEditor(Context context, Object o) {
    return saveEditor(context, o.getClass().getName(), o);
  }

  public static SharedPreferences.Editor saveEditor(Context context, String name, Object o) {
    Class clazz = o.getClass();
    return instanceMM(clazz).save(context, name, o);
  }

  public static <T> T get(Context context, Class<T> clazz) {
    return get(context, clazz.getName(), clazz);
  }

  public static <T> T get(Context context, String name, Class<T> clazz) {
    return (T) instanceMM(clazz).get(context, name);
  }

  public static void clear(Context context, Class clazz) {
    clear(context, clazz.getName(), clazz);
  }

  public static void clear(Context context, String name, Class clazz) {
    Utils.apply(clearEditor(context, name, clazz));
  }

  public static SharedPreferences.Editor clearEditor(Context context, Class clazz) {
    return clearEditor(context, clazz.getName(), clazz);
  }

  public static SharedPreferences.Editor clearEditor(Context context, String name, Class clazz) {
    return instanceMM(clazz).clear(context, name);
  }

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
}
