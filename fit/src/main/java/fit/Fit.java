package fit;

import android.content.Context;

/**
 * @auther Tu enum@foxmail.com
 * @date 16/8/27
 */
public final class Fit {
  private static final String TAG = Fit.class.getSimpleName();
  private static boolean debug = true;

  public static void save(Context context, Object o) {
    Class clazz = o.getClass();
    instanceMM(clazz).save(context, o);
  }

  public static void save(Context context, String name, Object o) {
    Class clazz = o.getClass();
    instanceMM(clazz).save(context, name, o);
  }

  public static <T> T get(Context context, Class<T> clazz) {
    return (T) instanceMM(clazz).get(context);
  }

  public static <T> T get(Context context, String name, Class<T> clazz) {
    return (T) instanceMM(clazz).get(context, name);
  }

  public static void clear(Context context, Class clazz) {
    instanceMM(clazz).clear(context);
  }

  public static void clear(Context context, String name, Class clazz) {
    instanceMM(clazz).clear(context, name);
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
