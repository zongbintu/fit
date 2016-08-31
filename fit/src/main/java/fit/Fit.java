package fit;

import android.content.Context;
import android.util.Log;

/**
 * @auther Tu enum@foxmail.com
 * @date 16/8/27
 */
public final class Fit {
  private static final String TAG = Fit.class.getSimpleName();
  private static boolean debug = true;

  public static void save(Context context, Object o) {
    Class cls = o.getClass();

    String clsName = cls.getName();
    if (clsName.startsWith("android.") || clsName.startsWith("java.")) {
      if (debug) Log.d(TAG, "MISS: Reached framework class. Abandoning search.");
      return;
    }
    try {
      Class<? extends MM> mmClass = findMMForClass(cls);
      //noinspection unchecked
      mmClass.newInstance().save(context, o);
      if (debug) Log.d(TAG, "HIT: Loaded MM class and constructor.");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("Miss SharedPreferenceAble", e);
    } catch (InstantiationException e) {
      throw new RuntimeException(o.toString() + " can't instance ", e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(o.toString() + " can't instance ", e);
    }
  }

  public static <T> T get(Context context, Class<T> clazz) {
    try {
      Class<? extends MM> mmClass = findMMForClass(clazz);
      return (T) mmClass.newInstance().get(context);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("Miss SharedPreferenceAble", e);
    } catch (InstantiationException e) {
      throw new RuntimeException(clazz.getName() + " can't instance ", e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(clazz.getName() + " can't instance ", e);
    }
  }

  public static void clear(Context context, Object o) {
    Class cls = o.getClass();

    String clsName = cls.getName();
    if (clsName.startsWith("android.") || clsName.startsWith("java.")) {
      if (debug) Log.d(TAG, "MISS: Reached framework class. Abandoning search.");
      return;
    }
    try {
      Class<? extends MM> mmClass = findMMForClass(cls);
      //noinspection unchecked
      mmClass.newInstance().clear(context);
      if (debug) Log.d(TAG, "HIT: Loaded MM class and constructor.");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("Miss SharedPreferenceAble", e);
    } catch (InstantiationException e) {
      throw new RuntimeException(o.toString() + " can't instance ", e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(o.toString() + " can't instance ", e);
    }
  }

  private static Class<? extends MM> findMMForClass(Class clazz) throws ClassNotFoundException {
    return (Class<? extends MM>) Class.forName(clazz.getName() + "_Preference");
  }
}
