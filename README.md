# Fit

[![](https://jitpack.io/v/2tu/fit.svg)](https://jitpack.io/#2tu/fit)

Fit is a library use apt by SharedPreferences store primitive field as Object.

## Installation
Add the following dependency to your `build.gradle` file:

```
dependencies {
    compile 'com.github.2tu:fit:0.1.0'
    apt 'com.github.2tu:fit-compiler:0.1.0'
}
```

## Usage
annotation model class.
```java
@SharedPreferenceAble
```

save
```java
User user = new User("Three.Tu");
Fit.save(this, user);
```
get
```java
User user = Fit.get(this, User.class);
```



## License
Please see [LICENSE](/LICENSE)
