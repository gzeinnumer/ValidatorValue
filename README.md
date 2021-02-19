<h1 align="center">
    ValidatorValue
</h1>

<p align="center">
    <a><img src="https://img.shields.io/badge/Version-1.0.0-brightgreen.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/ID-gzeinnumer-blue.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/Java-Suport-green?logo=java&style=flat"></a>
    <a><img src="https://img.shields.io/badge/kotlin-Suport-green?logo=kotlin&style=flat"></a>
    <a href="https://github.com/gzeinnumer"><img src="https://img.shields.io/github/followers/gzeinnumer?label=follow&style=social"></a>
    <br>
    <p>Simple validate without IF.</p>
</p>

---
# Content List
* [Download](#download)
* [Feature List](#feature-list)
* [Usage](#usage)
* [Example Code/App](#example-codeapp)
* [Version](#version)
* [Contribution](#contribution)

---
# Download
Add maven `jitpack.io` and `dependencies` in `build.gradle (Project)` :
```gradle
// build.gradle project
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

// build.gradle app/module
dependencies {
  ...
  implementation 'com.github.gzeinnumer:ValidatorValue:version'

  //required for testing
  implementation 'com.github.gzeinnumer:DialogAndroid:3.0.0'
  implementation 'com.github.gzeinnumer:SimpleMaterialStyle:2.0.0'
}
```

---
# Feature List
- [x] [Validate](#validate)
- [x] [Customize](#customize)

---
# Usage

### **Validate**

- Type 1

Return Result and use Toast as message if validate fail
```java
btnValidate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String strUsername = edUsername.getText().toString();
        String strPassword = edPassword.getText().toString();

        ValidatorValue.with(getApplicationContext())
                .addValue(strUsername, "Minimal 5 Character", 5)
                .addValue(strPassword, "Minimal 8 Character", 8)
                .validateListener(new ValidatorValueResult() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        //do something
                    }
                });
    }
});
```

<p align="center">
  <img src="https://github.com/gzeinnumer/ValidatorValue/blob/master/preview/example1.gif" width="300"/>
</p>

- Type 2

Return Result and use Custom message if validate fail
```java
btnValidate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String strUsername = edUsername.getText().toString();
        String strPassword = edPassword.getText().toString();

        ValidatorValue.with(getApplicationContext())
                .addValue(strUsername)
                .addValue(strPassword, "Minimal 8 Character", 8)
                .validateListener(new ValidatorValueResult() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                }, new ValidatorValueMessage() {
                    @Override
                    public void onFailed(String msg) {
                        new InfoDialog(getSupportFragmentManager())
                                .setDialogType(DialogType.DialogError)
                                .setTitle("INFO!!!")
                                .setContent(msg).show();
                    }
                });
    }
});
```

<p align="center">
  <img src="https://github.com/gzeinnumer/ValidatorValue/blob/master/preview/example2.gif" width="300"/>
</p>

#
### Customize

You can customize `Length` and `Message` for validate and required length
```java
String value = "GZeinNumer";
String msg = "Username Can't Empty";
int minLength = 5;

ValidatorValue.with(getApplicationContext()).addValue(value);       // msg = "Required correct value" // minLenth = 1
ValidatorValue.with(getApplicationContext()).addValue(value, msg);  // minLenth = 1
ValidatorValue.with(getApplicationContext()).addValue(value, msg, minLength);
```

You can put `boolean` to
```java
String value = "GZeinNumer";
boolean isValid = value.length()>0;
String msg = "Username Can't Empty";

ValidatorValue.with(getApplicationContext()).addValue(isValid);       // msg = "Required correct value"
ValidatorValue.with(getApplicationContext()).addValue(isValid, msg);
```

---
# Example Code/App

[MainActivity.java](https://github.com/gzeinnumer/ValidatorValue/blob/master/app/src/main/java/com/gzeinnumer/validatorvalue/MainActivity.java) & [activity_main.xml](https://github.com/gzeinnumer/ValidatorValue/blob/master/app/src/main/res/layout/activity_main.xml)

[Sample Code And App](https://github.com/gzeinnumer/ValidatorValueExample)

---
# Version
- **1.0.0**
  - First Release

---
# Contribution
You can sent your constibution to `branch` `open-pull`.

### Fore More [All My Library](https://github.com/gzeinnumer#my-library-list)

---

```
Copyright 2021 M. Fadli Zein
```
