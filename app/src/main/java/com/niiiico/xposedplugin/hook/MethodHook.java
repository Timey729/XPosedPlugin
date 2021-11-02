package com.niiiico.xposedplugin.hook;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * xposed关键类，实现IXposedHookLoadPackage，在handleLoadPackage中，
 * 通过XposedHelpers.findAndHookMethod来hook具体的方法。
 */
public class MethodHook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        if (loadPackageParam == null) return;
        initPrivacyHook(loadPackageParam);
    }

    private void initPrivacyHook(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(
                android.telephony.TelephonyManager.class.getName(),
                lpparam.classLoader,
                "getImei",
                new MethodSettle(lpparam.processName, lpparam.packageName));

        XposedHelpers.findAndHookMethod(
                android.telephony.TelephonyManager.class.getName(),
                lpparam.classLoader,
                "getImei",
                int.class,
                new MethodSettle(lpparam.processName, lpparam.packageName));

//        XposedHelpers.findAndHookMethod(
//                android.telephony.TelephonyManager.class.getName(),
//                lpparam.classLoader,
//                "getDeviceId",
//                new MethodSettle(lpparam.processName, lpparam.packageName));
//
//        XposedHelpers.findAndHookMethod(
//                android.telephony.TelephonyManager.class.getName(),
//                lpparam.classLoader,
//                "getDeviceId",
//                int.class,
//                new MethodSettle(lpparam.processName, lpparam.packageName));
//
//        XposedHelpers.findAndHookMethod(
//                android.telephony.TelephonyManager.class.getName(),
//                lpparam.classLoader,
//                "getSubscriberId",
//                int.class,
//                new MethodSettle(lpparam.processName, lpparam.packageName));
//
//        XposedHelpers.findAndHookMethod(
//                android.net.wifi.WifiInfo.class.getName(),
//                lpparam.classLoader,
//                "getMacAddress",
//                new MethodSettle(lpparam.processName, lpparam.packageName));
//
//        XposedHelpers.findAndHookMethod(
//                java.net.NetworkInterface.class.getName(),
//                lpparam.classLoader,
//                "getHardwareAddress",
//                new MethodSettle(lpparam.processName, lpparam.packageName));
//
//        XposedHelpers.findAndHookMethod(
//                android.provider.Settings.Secure.class.getName(),
//                lpparam.classLoader,
//                "getString",
//                android.content.ContentResolver.class,
//                String.class,
//                new MethodSettle(lpparam.processName, lpparam.packageName));
//
//        XposedHelpers.findAndHookMethod(
//                android.location.LocationManager.class.getName(),
//                lpparam.classLoader,
//                "getLastKnownLocation",
//                String.class,
//                new MethodSettle(lpparam.processName, lpparam.packageName));
//
//        XposedHelpers.findAndHookMethod(
//                android.location.LocationManager.class.getName(),
//                lpparam.classLoader,
//                "requestLocationUpdates",
//                String.class,
//                new MethodSettle(lpparam.processName, lpparam.packageName));
    }
}

