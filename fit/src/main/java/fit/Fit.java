package fit;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import fit.internal.FileObjectUtil;
import fit.internal.Utils;

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
    return Utils.getSharedPreferenceEditor(context, name).clear();
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
}