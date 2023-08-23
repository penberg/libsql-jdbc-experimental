package org.libsql.internal;

import io.questdb.jar.jni.JarJniLoader;

public class Native {
    public static native long open(String url);

    static {
        JarJniLoader.loadLib(
                Native.class,
                "/org/libsql/bin/",
                "libsql_native");
    }
}
