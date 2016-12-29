package fit;

import com.google.testing.compile.JavaFileObjects;
import fit.compiler.FitProcessor;
import javax.tools.JavaFileObject;
import org.junit.Test;

import static com.google.common.truth.Truth.assertAbout;
import static com.google.testing.compile.JavaSourceSubjectFactory.javaSource;
import static com.google.testing.compile.JavaSourcesSubjectFactory.javaSources;
import static java.util.Arrays.asList;

/**
 * @auther Tu enum@foxmail.com
 * @date 9/5/16
 */
public class SharedPreferenceAbleTest {
  @Test public void sharedPreferenceAble() {
    JavaFileObject source = JavaFileObjects.forSourceString("test.Test", ""
        + "package test;\n"
        + "import fit.SharedPreferenceAble;\n"
        + "@SharedPreferenceAble public class Test {\n"
        + "    public String aT;\n"
        + "}");

    JavaFileObject sharedSource = JavaFileObjects.forSourceString("test/Test_Preference", ""
        + "package test;\n"
        + "import android.content.Context;\n"
        + "import android.content.SharedPreferences;\n"
        + "import fit.MM;\n"
        + "import fit.internal.Utils;\n"
        + "import java.lang.Override;\n"
        + "import java.lang.String;\n"
        + "public class Test_Preference implements MM<Test> {\n"
        + "  @Override public void save(Context context, String name, Test obj) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name);\n"
        + "    editor.putString(\"aT\", obj.aT);\n"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void save(Context context, Test obj) {\n"
        + "    save(context, Test.class.getName(),obj);\n"
        + "  }\n"
        + "  @Override public Test get(Context context, String name) {\n"
        + "    SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);\n"
        + "    Test obj = new Test();\n"
        + "    obj.aT = sharedPreferences.getString(\"aT\", null);\n"
        + "    return obj;\n"
        + "  }\n"
        + "  @Override public Test get(Context context) {\n"
        + "    return get(context, Test.class.getName());\n"
        + "  }\n"
        + "  @Override public void clear(Context context, String name) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name).clear();\n"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void clear(Context context) {\n"
        + "    clear(context, Test.class.getName());\n"
        + "  }\n"
        + "}");

    assertAbout(javaSource()).that(source)
        .withCompilerOptions("-Xlint:-processing")
        .processedWith(new FitProcessor())
        .compilesWithoutWarnings()
        .and()
        .generatesSources(sharedSource);
  }

  @Test public void sharedPreferenceAbleViewFinalClass() {
    JavaFileObject source = JavaFileObjects.forSourceString("test.Test", ""
        + "package test;\n"
        + "import fit.SharedPreferenceAble;\n"
        + "@SharedPreferenceAble public final class Test {\n"
        + "    public String aT;\n"
        + "}");

    JavaFileObject sharedSource = JavaFileObjects.forSourceString("test/Test_Preference", ""
        + "package test;\n"
        + "import android.content.Context;\n"
        + "import android.content.SharedPreferences;\n"
        + "import fit.MM;\n"
        + "import fit.internal.Utils;\n"
        + "import java.lang.Override;\n"
        + "import java.lang.String;\n"
        + "public final class Test_Preference implements MM<Test> {\n"
        + "  @Override public void save(Context context, String name, Test obj) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name);\n"
        + "    editor.putString(\"aT\", obj.aT);\n"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void save(Context context, Test obj) {\n"
        + "    save(context, Test.class.getName(),obj);\n"
        + "  }\n"
        + "  @Override public Test get(Context context, String name) {\n"
        + "    SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);\n"
        + "    Test obj = new Test();\n"
        + "    obj.aT = sharedPreferences.getString(\"aT\", null);\n"
        + "    return obj;\n"
        + "  }\n"
        + "  @Override public Test get(Context context) {\n"
        + "    return get(context, Test.class.getName());\n"
        + "  }\n"
        + "  @Override public void clear(Context context, String name) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name).clear();"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void clear(Context context) {\n"
        + "    clear(context, Test.class.getName());\n"
        + "  }\n"
        + "}");

    assertAbout(javaSource()).that(source)
        .withCompilerOptions("-Xlint:-processing")
        .processedWith(new FitProcessor())
        .compilesWithoutWarnings()
        .and()
        .generatesSources(sharedSource);
  }

  @Test public void sharedPreferenceUppercasePackageName() {
    JavaFileObject source = JavaFileObjects.forSourceString("com.Example.Test", ""
        + "package test.Example;\n"
        + "import fit.SharedPreferenceAble;\n"
        + "@SharedPreferenceAble public class Test {\n"
        + "    public String aT;\n"
        + "}");

    JavaFileObject sharedSource = JavaFileObjects.forSourceString("test/Test_Preference", ""
        + "package test.Example;\n"
        + "import android.content.Context;\n"
        + "import android.content.SharedPreferences;\n"
        + "import fit.MM;\n"
        + "import fit.internal.Utils;\n"
        + "import java.lang.Override;\n"
        + "import java.lang.String;\n"
        + "public class Test_Preference implements MM<Test> {\n"
        + "  @Override public void save(Context context, String name, Test obj) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name);\n"
        + "    editor.putString(\"aT\", obj.aT);\n"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void save(Context context, Test obj) {\n"
        + "    save(context, Test.class.getName(),obj);\n"
        + "  }\n"
        + "  @Override public Test get(Context context, String name) {\n"
        + "    SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);\n"
        + "    Test obj = new Test();\n"
        + "    obj.aT = sharedPreferences.getString(\"aT\", null);\n"
        + "    return obj;\n"
        + "  }\n"
        + "  @Override public Test get(Context context) {\n"
        + "    return get(context, Test.class.getName());\n"
        + "  }\n"
        + "  @Override public void clear(Context context, String name) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name).clear();"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void clear(Context context) {\n"
        + "    clear(context, Test.class.getName());\n"
        + "  }\n"
        + "}");

    assertAbout(javaSource()).that(source)
        .withCompilerOptions("-Xlint:-processing")
        .processedWith(new FitProcessor())
        .compilesWithoutWarnings()
        .and()
        .generatesSources(sharedSource);
  }

  @Test public void sharedPreferenceObject() throws Exception {
    JavaFileObject source = JavaFileObjects.forSourceString("com.Example.Test", ""
        + "package test.Example;\n"
        + "import fit.SharedPreferenceAble;\n"
        + "import java.util.Date;\n"
        + "@SharedPreferenceAble public class Test {\n"
        + "    public Date birthday;\n"
        + "    public String aT;\n"
        + "}");

    JavaFileObject sharedSource = JavaFileObjects.forSourceString("test/Test_Preference", ""
        + "package test.Example;\n"
        + "import android.content.Context;\n"
        + "import android.content.SharedPreferences;\n"
        + "import fit.MM;\n"
        + "import fit.internal.Utils;\n"
        + "import java.lang.Override;\n"
        + "import java.lang.String;\n"
        + "public class Test_Preference implements MM<Test> {\n"
        + "  @Override public void save(Context context, String name, Test obj) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name);\n"
        + "    editor.putString(\"aT\", obj.aT);\n"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void save(Context context, Test obj) {\n"
        + "    save(context, Test.class.getName(),obj);\n"
        + "  }\n"
        + "  @Override public Test get(Context context, String name) {\n"
        + "    SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);\n"
        + "    Test obj = new Test();\n"
        + "    obj.aT = sharedPreferences.getString(\"aT\", null);\n"
        + "    return obj;\n"
        + "  }\n"
        + "  @Override public Test get(Context context) {\n"
        + "    return get(context, Test.class.getName());\n"
        + "  }\n"
        + "  @Override public void clear(Context context, String name) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name).clear();\n"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void clear(Context context) {\n"
        + "    clear(context, Test.class.getName());\n"
        + "  }\n"
        + "}");

    assertAbout(javaSource()).that(source)
        .withCompilerOptions("-Xlint:-processing")
        .processedWith(new FitProcessor())
        .compilesWithoutWarnings()
        .and()
        .generatesSources(sharedSource);
  }

  @Test public void superclass() {
    JavaFileObject source1 = JavaFileObjects.forSourceString("test.Test", ""
        + "package test;\n"
        + "import fit.SharedPreferenceAble;\n"
        + "@SharedPreferenceAble public class Test {\n"
        + "    public String aT;\n"
        + "}");

    JavaFileObject source2 = JavaFileObjects.forSourceString("test.TestOne", ""
        + "package test;\n"
        + "import fit.SharedPreferenceAble;\n"
        + "@SharedPreferenceAble public class TestOne extends Test {\n"
        + "  public int thing;\n"
        + "}");

    JavaFileObject source3 = JavaFileObjects.forSourceString("test.TestTwo", ""
        + "package test;\n"
        + "import fit.SharedPreferenceAble;\n"
        + "@SharedPreferenceAble public class TestTwo extends Test {\n"
        + "}");

    JavaFileObject sharedSource1 = JavaFileObjects.forSourceString("test/Test_Preference", ""
        + "package test;\n"
        + "import android.content.Context;\n"
        + "import android.content.SharedPreferences;\n"
        + "import fit.MM;\n"
        + "import fit.internal.Utils;\n"
        + "import java.lang.Override;\n"
        + "import java.lang.String;\n"
        + "public class Test_Preference implements MM<Test> {\n"
        + "  @Override public void save(Context context, String name, Test obj) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name);\n"
        + "    editor.putString(\"aT\", obj.aT);\n"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void save(Context context, Test obj) {\n"
        + "    save(context, Test.class.getName(),obj);\n"
        + "  }\n"
        + "  @Override public Test get(Context context, String name) {\n"
        + "    SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);\n"
        + "    Test obj = new Test();\n"
        + "    obj.aT = sharedPreferences.getString(\"aT\", null);\n"
        + "    return obj;\n"
        + "  }\n"
        + "  @Override public Test get(Context context) {\n"
        + "    return get(context, Test.class.getName());\n"
        + "  }\n"
        + "  @Override public void clear(Context context, String name) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name).clear();"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void clear(Context context) {\n"
        + "    clear(context, Test.class.getName());\n"
        + "  }\n"
        + "}");

    JavaFileObject sharedSource2 = JavaFileObjects.forSourceString("test/TestOne_Preference", ""
        + "package test;\n"
        + "import android.content.Context;\n"
        + "import android.content.SharedPreferences;\n"
        + "import fit.MM;\n"
        + "import fit.internal.Utils;\n"
        + "import java.lang.Override;\n"
        + "import java.lang.String;\n"
        + "public class TestOne_Preference implements MM<TestOne> {\n"
        + "  @Override public void save(Context context, String name, TestOne obj) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name);\n"
        + "    editor.putString(\"aT\", obj.aT);\n"
        + "    editor.putInt(\"thing\", obj.thing);\n"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void save(Context context, TestOne obj) {\n"
        + "    save(context, TestOne.class.getName(), obj);\n"
        + "  }\n"
        + "  @Override public TestOne get(Context context, String name) {\n"
        + "    SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);\n"
        + "    TestOne obj = new TestOne();\n"
        + "    obj.aT = sharedPreferences.getString(\"aT\", null);\n"
        + "    obj.thing = sharedPreferences.getInt(\"thing\", 0);\n"
        + "    return obj;\n"
        + "  }\n"
        + "  @Override public TestOne get(Context context) {\n"
        + "    return get(context, TestOne.class.getName());\n"
        + "  }\n"
        + "  @Override public void clear(Context context, String name) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name).clear();"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void clear(Context context) {\n"
        + "    clear(context, TestOne.class.getName());\n"
        + "  }\n"
        + "}");

    JavaFileObject sharedSource3 = JavaFileObjects.forSourceString("test/TestTwo_Preference", ""
        + "package test;\n"
        + "import android.content.Context;\n"
        + "import android.content.SharedPreferences;\n"
        + "import fit.MM;\n"
        + "import fit.internal.Utils;\n"
        + "import java.lang.Override;\n"
        + "import java.lang.String;\n"
        + "public class TestTwo_Preference implements MM<TestTwo> {\n"
        + "  @Override public void save(Context context, String name, TestTwo obj) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name);\n"
        + "    editor.putString(\"aT\", obj.aT);\n"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void save(Context context, TestTwo obj) {\n"
        + "    save(context, TestTwo.class.getName(), obj);\n"
        + "  }\n"
        + "  @Override public TestTwo get(Context context, String name) {\n"
        + "    SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);\n"
        + "    TestTwo obj = new TestTwo();\n"
        + "    obj.aT = sharedPreferences.getString(\"aT\", null);\n"
        + "    return obj;\n"
        + "  }\n"
        + "  @Override public TestTwo get(Context context) {\n"
        + "    return get(context, TestTwo.class.getName());\n"
        + "  }\n"
        + "  @Override public void clear(Context context, String name) {\n"
        + "    SharedPreferences.Editor editor = Utils.getSharedPreferenceEditor(context, name).clear();"
        + "    Utils.apply(editor);\n"
        + "  }\n"
        + "  @Override public void clear(Context context) {\n"
        + "    clear(context, TestTwo.class.getName());\n"
        + "  }\n"
        + "}");

    assertAbout(javaSources()).that(asList(source1, source2, source3))
        .withCompilerOptions("-Xlint:-processing")
        .processedWith(new FitProcessor())
        .compilesWithoutWarnings()
        .and()
        .generatesSources(sharedSource1, sharedSource2, sharedSource3);
  }

  @Test public void failsInNonParameterConstructor() {
    JavaFileObject source = JavaFileObjects.forSourceString("test.Test", ""
        + "package test;\n"
        + "import fit.SharedPreferenceAble;\n"
        + "@SharedPreferenceAble public class Test {\n"
        + "    public String aT;\n"
        + "    public Test(String aT) {\n"
        + "        this.aT = aT;\n"
        + "}"
        + "}");

    assertAbout(javaSource()).that(source)
        .processedWith(new FitProcessor())
        .failsToCompile()
        .withErrorContaining("Fit can't use no non-parameter constructor")
        .in(source)
        .onLine(3);
  }
}
