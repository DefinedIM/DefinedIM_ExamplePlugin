package org.definedim.example;

import com.alibaba.fastjson2.JSON;
import org.definedim.DefinedIM;
import org.definedim.plugin.DefinedIMPlugin;
import org.definedim.plugin.PluginManager;

public class ExamplePlugin extends DefinedIMPlugin {
    @Override
    public void onRegister() {
        System.out.println("Test Plugin Loaded!");
        System.out.println(JSON.toJSONString(config));
        System.out.println(JSON.toJSONString(DefinedIM.pluginManager));
    }

    @Override
    public void onExit() {
        System.out.println("plugin exit now!");
    }
}
