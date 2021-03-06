package lab.galaxy.yahfa.demoApp;

import android.app.Application;
import android.content.Context;

import dalvik.system.DexClassLoader;
import lab.galaxy.yahfa.HookMain;

/**
 * Created by liuruikai756 on 30/03/2017.
 */

public class MainApp extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        /*
        Build and put the demoPlugin apk in sdcard before running the demoApp
         */
        HookMain hookMain = new HookMain();
        ClassLoader classLoader = getClassLoader();

        DexClassLoader dexClassLoader = new DexClassLoader("/sdcard/demoPlugin-debug.apk",
                getCodeCacheDir().getAbsolutePath(), null, classLoader);
        hookMain.doHookDefault(dexClassLoader, classLoader);
    }
}
