# Fit

[![Release](https://jitpack.io/v/2tu/fit.svg)](https://jitpack.io/#2tu/fit) [![Build Status](https://travis-ci.org/2tu/fit.svg?branch=master)](https://travis-ci.org/2tu/fit) [![Apache License](http://img.shields.io/hexpm/l/plug.svg?style=flat)](https://github.com/kentarosasaki/raspberrypi/blob/master/LICENSE)

Fit is a library use apt by SharedPreferences store primitive field as Object.

## Installation
Add it in your root build.gradle at the end of repositories:

```
dependencies {
   classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
}

allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```
Add the following dependency to your `build.gradle` file:

```
apply plugin: 'com.neenbedankt.android-apt'

dependencies {
    compile 'com.github.2tu.fit:fit:0.1.1'
    apt 'com.github.2tu.fit:fit-compiler:0.1.1'
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


## What's new (0.1.1) - [Changelog](https://github.com/2tu/fit/blob/master/CHANGELOG.md)
* Save model as SharedPreferences(private static complex field not support)
