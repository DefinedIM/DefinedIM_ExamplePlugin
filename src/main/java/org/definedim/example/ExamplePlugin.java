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
//        URLClassLoader urlClassLoader = (URLClassLoader) Thread.currentThread().getContextClassLoader();
//        ClassLoader classLoader = urlClassLoader.getParent();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            Class<?> clazz = classLoader.loadClass("org.definedim.DefinedIMServer");
            Field clazzField = clazz.getDeclaredField("definedIMServer");
            clazzField.setAccessible(true);
            Object obj = clazzField.get(null);
            DefinedIMServer server = (DefinedIMServer) obj;
            System.out.println(JSON.toJSONString(server));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onExit() {
        System.out.println("plugin exit now!");
    }
}
