package com.niiiico.xposedplugin.hook;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class EdjHook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        if (loadPackageParam == null) return;
        initPrivacyHook(loadPackageParam);
    }

    private void initPrivacyHook(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(
                android.telephony.TelephonyManager.class.getName(),
                lpparam.classLoader,
                "getDeviceId",
                new EdjStackHook(lpparam.processName, lpparam.packageName));

        XposedHelpers.findAndHookMethod(
                android.telephony.TelephonyManager.class.getName(),
                lpparam.classLoader,
                "getDeviceId",
                int.class,
                new EdjStackHook(lpparam.processName, lpparam.packageName));

        XposedHelpers.findAndHookMethod(
                android.telephony.TelephonyManager.class.getName(),
                lpparam.classLoader,
                "getSubscriberId",
                int.class,
                new EdjStackHook(lpparam.processName, lpparam.packageName));

        XposedHelpers.findAndHookMethod(
                android.telephony.TelephonyManager.class.getName(),
                lpparam.classLoader,
                "getImei",
                new EdjStackHook(lpparam.processName, lpparam.packageName));

        XposedHelpers.findAndHookMethod(
                android.telephony.TelephonyManager.class.getName(),
                lpparam.classLoader,
                "getImei",
                int.class,
                new EdjStackHook(lpparam.processName, lpparam.packageName));

        XposedHelpers.findAndHookMethod(
                android.net.wifi.WifiInfo.class.getName(),
                lpparam.classLoader,
                "getMacAddress",
                new EdjStackHook(lpparam.processName, lpparam.packageName));

        XposedHelpers.findAndHookMethod(
                java.net.NetworkInterface.class.getName(),
                lpparam.classLoader,
                "getHardwareAddress",
                new EdjStackHook(lpparam.processName, lpparam.packageName));

        XposedHelpers.findAndHookMethod(
                android.provider.Settings.Secure.class.getName(),
                lpparam.classLoader,
                "getString",
                android.content.ContentResolver.class,
                String.class,
                new EdjStackHook(lpparam.processName, lpparam.packageName));

        XposedHelpers.findAndHookMethod(
                android.location.LocationManager.class.getName(),
                lpparam.classLoader,
                "getLastKnownLocation",
                String.class,
                new EdjStackHook(lpparam.processName, lpparam.packageName));

        XposedHelpers.findAndHookMethod(
                android.location.LocationManager.class.getName(),
                lpparam.classLoader,
                "requestLocationUpdates",
                String.class,
                new EdjStackHook(lpparam.processName, lpparam.packageName));
    }
}

