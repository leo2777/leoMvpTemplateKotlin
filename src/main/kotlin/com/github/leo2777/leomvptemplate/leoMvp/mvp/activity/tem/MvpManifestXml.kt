package com.github.leo2777.leomvptemplate.leoMvp.mvp.activity.tem


fun mvpManifest(
    pathName:String,
    packageName:String,
    activityClass:String) = """


<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    <application>
	    <activity android:name="${packageName}.${pathName}.${activityClass}"
                  android:exported="false"/>
    </application>
</manifest>
        """