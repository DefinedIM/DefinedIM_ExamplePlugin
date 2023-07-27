package org.definedim.example;

import org.definedim.plugin.DefinedIMPlugin;

public class ExamplePlugin extends DefinedIMPlugin {
    @Override
    public void onRegister(){
        System.out.println("Test Plugin Loaded!");
    }

    @Override
    public void onExit(){
        System.out.println("plugin exit now!");
    }
}
