/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fit.internal;

import android.content.SharedPreferences;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class SharedPreferencesCompat {
  private static final Method sApplyMethod = findApplyMethod();

  private static Method findApplyMethod() {
    try {
      Class cls = SharedPreferences.Editor.class;
      return cls.getMethod("apply");
    } catch (NoSuchMethodException unused) {
      // fall through
    }
    return null;
  }

  private static final Method sPutStringSetMethod = findPutStringSetMethod();

  private static Method findPutStringSetMethod() {
    try {
      Class cls = SharedPreferences.Editor.class;
      Class[] argsClass = new Class[] { String.class, Set.class };
      return cls.getMethod("putStringSet", argsClass);
    } catch (NoSuchMethodException unused) {
      // fall through
    }
    return null;
  }

  public static SharedPreferences.Editor putStringSet(SharedPreferences.Editor editor, String key,
      Set<String> values) {
    if (sPutStringSetMethod != null) {
      try {
        return (SharedPreferences.Editor) sPutStringSetMethod.invoke(editor, key, values);
      } catch (InvocationTargetException unused) {
        // fall through
      } catch (IllegalAccessException unused) {
        // fall through
      }
    }
    return editor;
  }

  public static Set<String> getStringSet(SharedPreferences sharedPreferences, String key,
      Set<String> defaultValue) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
      return sharedPreferences.getStringSet(key, defaultValue);
    }
    return defaultValue;
  }

  public static void apply(SharedPreferences.Editor editor) {
    if (sApplyMethod != null) {
      try {
        sApplyMethod.invoke(editor);
        return;
      } catch (InvocationTargetException unused) {
        // fall through
      } catch (IllegalAccessException unused) {
        // fall through
      }
    }
    editor.commit();
  }
}