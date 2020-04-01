package fit;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * ignore field
 *
 * @author Tu enum@foxmail.com
 * @version 1.0 2019/5/28
 */
@Retention(CLASS) @Target(FIELD) public @interface PreferenceIgnore {
}
