package com.niiiico.xposedplugin.hook;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;

public class EdjStackHook extends XC_MethodHook {
    private final String processName;
    private final String packageName;

    public EdjStackHook(String processName, String packageName) {
        this.processName = processName;
        this.packageName = packageName;
    }

    @Override
    protected void beforeHookedMethod(MethodHookParam param) {
        XposedBridge.log("[" + packageName + "][" + processName + "]" + param.method.getName() + "()");
    }

    @Override
    protected void afterHookedMethod(MethodHookParam param) {
        StringBuilder stringBuilder = new StringBuilder("---------------start----------------\n");
        Throwable ex = new Throwable();
        StackTraceElement[] stackElements = ex.getStackTrace();
        for (int i = 0; i < stackElements.length; i++) {
            stringBuilder.append("[Dump Stack]")
                    .append("[").append(i).append("]").append(stackElements[i].getClassName())
                    .append("->").append(stackElements[i].getFileName())
                    .append("(").append(stackElements[i].getLineNumber()).append(")")
                    .append("->").append(stackElements[i].getMethodName())
                    .append("\n");
        }
        stringBuilder.append("---------------over----------------\n");
        XposedBridge.log(stringBuilder.toString());
    }
}
