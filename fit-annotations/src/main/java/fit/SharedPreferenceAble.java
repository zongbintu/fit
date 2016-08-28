package fit;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * @auther Tu enum@foxmail.com
 * @date 16/8/27
 */
@Retention(CLASS) @Target(TYPE) public @interface SharedPreferenceAble {
}
