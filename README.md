# XPosedPlugin 
基于virtual Xposed实现用户隐私行为监听

插件开发流程：

1、新建android工程，并在app的build.gradle中添加依赖。
```
dependencies {
    compileOnly 'de.robv.android.xposed:api:82'
    compileOnly 'de.robv.android.xposed:api:82:sources'
}
```

2、在AndroidManifest.xml中添加声明
```
<meta-data
    android:name="xposedmodule"
    android:value="true" />

<meta-data
    android:name="xposedminversion"
    android:value="54" />

<meta-data
    android:name="xposeddescription"
    android:value="这是插件的描述，在添加的时候会在插件列表展示出来" />
```

3、新建java类，实现IXposedHookLoadPackage接口。并重写handleLoadPackage方法。

4、在assets目录下新建文件xposed_init，内容为IXposedHookLoadPackage实现类的路径。
