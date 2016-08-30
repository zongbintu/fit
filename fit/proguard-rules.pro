
# Retain generated class which implement MM.
-keep public class * implements fit.MM

# Prevent obfuscation of types which use Fit annotations since the simple name
# is used to reflectively look up the generated Preference.
-keep class fit.*
-keepclasseswithmembernames class * { @fit.* <methods>; }
-keepclasseswithmembernames class * { @fit.* <fields>; }