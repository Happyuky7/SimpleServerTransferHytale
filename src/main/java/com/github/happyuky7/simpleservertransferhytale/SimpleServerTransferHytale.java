package com.github.happyuky7.simpleservertransferhytale;

import com.github.happyuky7.simpleservertransferhytale.commands.ServerTransferCMD;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import javax.annotation.Nonnull;

public class SimpleServerTransferHytale extends JavaPlugin {

    private static SimpleServerTransferHytale instance;

    public static SimpleServerTransferHytale getInstance() {
        return instance;
    }

    public SimpleServerTransferHytale(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {

        instance = this;

        System.out.println("                                                  ");
        System.out.println(" SimpleServerTransferHytale - Version 1.0.0");
        System.out.println("                                                  ");
        System.out.println(" Github: https://github.com/Happyuky7/SimpleServerTransferHytale");
        System.out.println("                                                  ");

        this.getCommandRegistry().registerCommand(new ServerTransferCMD());

    }
}
