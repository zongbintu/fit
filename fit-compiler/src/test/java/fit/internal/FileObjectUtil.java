package fit.internal;

import android.content.Context;
import android.util.Log;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Tu enum@foxmail.com.
 * @since 0.4.0
 */

public final class FileObjectUtil {
  /**
   * write object to file
   *
   * @param context {@link Context}
   * @param fileName file name
   * @param obj Type is String/Array/Serializable
   */
  public static void writeObject(Context context, String fileName, Object obj) {
    FileOutputStream fileOutputStream = null;
    ObjectOutputStream objectOutputStream = null;
    try {
      fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
      objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(obj);
    } catch (FileNotFoundException e) {
      Log.e("Fit", "FileOutputStream error", e);
    } catch (IOException e) {
      Log.e("Fit", "ObjectOutputStream error", e);
    } finally {
      Utils.closeQuietly(fileOutputStream);
      Utils.closeQuietly(objectOutputStream);
    }
  }

  public static Object readObject(Context context, String fileName) {
    ObjectInputStream objectInputStream = null;
    FileInputStream fileInputStream = null;
    try {
      fileInputStream = context.openFileInput(fileName);
      objectInputStream = new ObjectInputStream(fileInputStream);
      Object obj = objectInputStream.readObject();
      return obj;
    } catch (IOException e) {
      Log.e("Fit", "ObjectInputStream error", e);
    } catch (ClassNotFoundException e) {
      Log.e("Fit", "FileInputStream error", e);
    } finally {
      Utils.closeQuietly(objectInputStream);
      Utils.closeQuietly(fileInputStream);
    }
    return null;
  }

  public static <T> T readObject(Context context, String fileName, Class<T> clazz) {
    Object obj = readObject(context, fileName);
    if (null != obj) {
      return clazz.cast(obj);
    }
    return null;
  }
}
