// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command.impl;

import ru.rockstar.client.ui.settings.config.Config;
import ru.rockstar.client.ui.settings.config.ConfigManager;
import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import ru.rockstar.Main;
import com.mojang.realmsclient.gui.ChatFormatting;
import ru.rockstar.api.command.CommandAbstract;

public class ConfigCommand extends CommandAbstract
{
    public ConfigCommand() {
        super("config", "configurations", "§6.config" + ChatFormatting.RED + " save | load | delete " + "§7<name>", new String[] { "config" });
    }
    
    @Override
    public void execute(final String... llllllllllllIIllIIlIlllIIIlIlllI) {
        try {
            if (llllllllllllIIllIIlIlllIIIlIlllI.length >= 2) {
                final String llllllllllllIIllIIlIlllIIIllIIlI = llllllllllllIIllIIlIlllIIIlIlllI[1].toUpperCase();
                if (llllllllllllIIllIIlIlllIIIlIlllI.length == 3) {
                    final double llllllllllllIIllIIlIlllIIIlIllII;
                    switch (((String)(llllllllllllIIllIIlIlllIIIlIllII = (double)llllllllllllIIllIIlIlllIIIllIIlI)).hashCode()) {
                        case 2342118: {
                            if (!((String)llllllllllllIIllIIlIlllIIIlIllII).equals("LOAD")) {
                                break;
                            }
                            if (Main.instance.configManager.loadConfig(llllllllllllIIllIIlIlllIIIlIlllI[2])) {
                                Main.msg(ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "loaded config: " + ChatFormatting.RED + "\"" + llllllllllllIIllIIlIlllIIIlIlllI[2] + "\"", true);
                                NotificationPublisher.queue("Config", ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "loaded config: " + ChatFormatting.RED + "\"" + llllllllllllIIllIIlIlllIIIlIlllI[2] + "\"", NotificationType.SUCCESS);
                                break;
                            }
                            Main.msg(ChatFormatting.RED + "Failed " + ChatFormatting.WHITE + "load config: " + ChatFormatting.RED + "\"" + llllllllllllIIllIIlIlllIIIlIlllI[2] + "\"", true);
                            NotificationPublisher.queue("Config", ChatFormatting.RED + "Failed " + ChatFormatting.WHITE + "load config: " + ChatFormatting.RED + "\"" + llllllllllllIIllIIlIlllIIIlIlllI[2] + "\"", NotificationType.ERROR);
                            break;
                        }
                        case 2537853: {
                            if (!((String)llllllllllllIIllIIlIlllIIIlIllII).equals("SAVE")) {
                                break;
                            }
                            if (Main.instance.configManager.saveConfig(llllllllllllIIllIIlIlllIIIlIlllI[2])) {
                                Main.msg(ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "saved config: " + ChatFormatting.RED + "\"" + llllllllllllIIllIIlIlllIIIlIlllI[2] + "\"", true);
                                NotificationPublisher.queue("Config", ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "saved config: " + ChatFormatting.RED + "\"" + llllllllllllIIllIIlIlllIIIlIlllI[2] + "\"", NotificationType.SUCCESS);
                                ConfigManager.getLoadedConfigs().clear();
                                Main.instance.configManager.load();
                                break;
                            }
                            Main.msg(ChatFormatting.RED + "Failed " + ChatFormatting.WHITE + "to save config: " + ChatFormatting.RED + "\"" + llllllllllllIIllIIlIlllIIIlIlllI[2] + "\"", true);
                            NotificationPublisher.queue("Config", ChatFormatting.RED + "Failed " + ChatFormatting.WHITE + "to save config: " + ChatFormatting.RED + "\"" + llllllllllllIIllIIlIlllIIIlIlllI[2] + "\"", NotificationType.ERROR);
                            break;
                        }
                        case 2012838315: {
                            if (!((String)llllllllllllIIllIIlIlllIIIlIllII).equals("DELETE")) {
                                break;
                            }
                            if (Main.instance.configManager.deleteConfig(llllllllllllIIllIIlIlllIIIlIlllI[2])) {
                                Main.msg(ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "deleted config: " + ChatFormatting.RED + "\"" + llllllllllllIIllIIlIlllIIIlIlllI[2] + "\"", true);
                                NotificationPublisher.queue("Config", ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "deleted config: " + ChatFormatting.RED + "\"" + llllllllllllIIllIIlIlllIIIlIlllI[2] + "\"", NotificationType.SUCCESS);
                                break;
                            }
                            Main.msg(ChatFormatting.RED + "Failed " + ChatFormatting.WHITE + "to delete config: " + ChatFormatting.RED + "\"" + llllllllllllIIllIIlIlllIIIlIlllI[2] + "\"", true);
                            NotificationPublisher.queue("Config", ChatFormatting.RED + "Failed " + ChatFormatting.WHITE + "to delete config: " + ChatFormatting.RED + "\"" + llllllllllllIIllIIlIlllIIIlIlllI[2] + "\"", NotificationType.ERROR);
                            break;
                        }
                    }
                }
                else if (llllllllllllIIllIIlIlllIIIlIlllI.length == 2 && llllllllllllIIllIIlIlllIIIllIIlI.equalsIgnoreCase("LIST")) {
                    Main.msg(ChatFormatting.GREEN + "Configs:", true);
                    for (final Config llllllllllllIIllIIlIlllIIIllIIIl : Main.instance.configManager.getContents()) {
                        Main.msg(ChatFormatting.RED + llllllllllllIIllIIlIlllIIIllIIIl.getName(), true);
                    }
                }
            }
            else {
                Main.msg(this.getUsage(), true);
            }
        }
        catch (Exception llllllllllllIIllIIlIlllIIIllIIII) {
            llllllllllllIIllIIlIlllIIIllIIII.printStackTrace();
        }
    }
}
