# Fit

[![Release](https://jitpack.io/v/2tu/fit.svg)](https://jitpack.io/#2tu/fit)   

Fit storage bean for SharedPreferences which uses annotation processing to generate boilerplate code for you.

## Installation
Add it in your root build.gradle at the end of repositories:

```
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```
Add the following dependency to your `build.gradle` file:

```
dependencies {
    compile 'com.github.2tu.fit:fit:0.3.3'
    annotationProcessor 'com.github.2tu.fit:fit-compiler:0.3.3'
    //use apt
    //apt 'com.github.2tu.fit:fit-compiler:0.3.3'
}
```

## Usage
annotation model class.
```java
@SharedPreferenceAble
```

save object
```java
User user = new User();
Fit.save(context, user);
Fit.save(context, "user", user);
```
get
```java
User user = Fit.get(context, User.class);
User user = Fit.get(context, "user", User.class);
```
clear
```java
Fit.clear(context, User.class);
Fit.clear(context, "user");
```
other
```java
Fit.get(context, "name").getBoolean("isFirst", false);
SharedPreferences.Editor editor = Fit.edit(context, "name");
editor.putBoolean("isFirst", true);
editor.apply();
```
  
##  Q&A
[apt or annotationProcessor](https://github.com/2tu/fit/wiki/apt-or-annotationProcessor)

License
-------

    Copyright 2016 Tu

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



 [1]: http://2tu.github.com/fit/
