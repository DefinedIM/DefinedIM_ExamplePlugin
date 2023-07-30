package org.definedim.example;

import com.alibaba.fastjson2.JSON;
import org.definedim.DefinedIM;
import org.definedim.DefinedIMServer;
import org.definedim.plugin.DefinedIMPlugin;
import org.definedim.plugin.PluginManager;

import java.lang.reflect.Field;
import java.net.URLClassLoader;

public class ExamplePlugin extends DefinedIMPlugin {
    @Override
    public void onLoad() {
        System.out.println("Test Plugin Loaded!");
        System.out.println(JSON.toJSONString(getDefinedIMServer()));
        new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        System.out.println("json: " + JSON.toJSONString(getDefinedIMServer()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public void onExit() {
        System.out.println("plugin exit now!");
    }
}
