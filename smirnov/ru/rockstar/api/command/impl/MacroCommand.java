// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command.impl;

import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import ru.rockstar.Main;
import org.lwjgl.input.Keyboard;
import com.mojang.realmsclient.gui.ChatFormatting;
import ru.rockstar.api.command.macro.Macro;
import ru.rockstar.api.command.CommandAbstract;

public class MacroCommand extends CommandAbstract
{
    public MacroCommand() {
        super("macros", "macro", "§6.macro" + ChatFormatting.RED + " add " + "§7<key> /home_home / §6.macro" + ChatFormatting.RED + " remove " + "§7<key> / §6.macro" + ChatFormatting.RED + " clear " + "§7/ §6.macro" + ChatFormatting.RED + " list", new String[] { "§6.macro" + ChatFormatting.RED + " add " + "§7<key> </home_home> / §6.macro" + ChatFormatting.RED + " remove " + "§7<key> / §6.macro" + ChatFormatting.RED + " clear " + "/ §6.macro" + ChatFormatting.RED + " list", "macro" });
    }
    
    @Override
    public void execute(final String... lllllllllllIIlIIllIlIllIIIIllIIl) {
        try {
            if (lllllllllllIIlIIllIlIllIIIIllIIl.length > 1) {
                if (lllllllllllIIlIIllIlIllIIIIllIIl[0].equals("macro")) {
                    if (lllllllllllIIlIIllIlIllIIIIllIIl[1].equals("add")) {
                        final StringBuilder lllllllllllIIlIIllIlIllIIIIllIII = new StringBuilder();
                        for (int lllllllllllIIlIIllIlIllIIIIlIlll = 3; lllllllllllIIlIIllIlIllIIIIlIlll < lllllllllllIIlIIllIlIllIIIIllIIl.length; ++lllllllllllIIlIIllIlIllIIIIlIlll) {
                            lllllllllllIIlIIllIlIllIIIIllIII.append(lllllllllllIIlIIllIlIllIIIIllIIl[lllllllllllIIlIIllIlIllIIIIlIlll]).append(" ");
                        }
                        Main.instance.macroManager.addMacro(new Macro(Keyboard.getKeyIndex(lllllllllllIIlIIllIlIllIIIIllIIl[2].toUpperCase()), lllllllllllIIlIIllIlIllIIIIllIII.toString()));
                        Main.msg(ChatFormatting.GREEN + "Added" + " macros for key" + ChatFormatting.RED + " \"" + lllllllllllIIlIIllIlIllIIIIllIIl[2].toUpperCase() + ChatFormatting.RED + "\" " + ChatFormatting.WHITE + "with value " + ChatFormatting.RED + (Object)lllllllllllIIlIIllIlIllIIIIllIII, true);
                        NotificationPublisher.queue("Macro Manager", ChatFormatting.GREEN + "Added" + " macro for key" + ChatFormatting.RED + " \"" + lllllllllllIIlIIllIlIllIIIIllIIl[2].toUpperCase() + ChatFormatting.RED + "\" " + ChatFormatting.WHITE + "with value " + ChatFormatting.RED + (Object)lllllllllllIIlIIllIlIllIIIIllIII, NotificationType.SUCCESS);
                    }
                    if (lllllllllllIIlIIllIlIllIIIIllIIl[1].equals("clear")) {
                        if (Main.instance.macroManager.getMacros().isEmpty()) {
                            Main.msg(ChatFormatting.RED + "Your macros list is empty!", true);
                            NotificationPublisher.queue("Macro Manager", "Your macro list is empty!", NotificationType.ERROR);
                            return;
                        }
                        Main.instance.macroManager.getMacros().clear();
                        Main.msg(ChatFormatting.GREEN + "Your macros list " + ChatFormatting.WHITE + " successfully cleared!", true);
                        NotificationPublisher.queue("Macro Manager", ChatFormatting.GREEN + "Your macros list " + ChatFormatting.WHITE + " successfully cleared!", NotificationType.SUCCESS);
                    }
                    if (lllllllllllIIlIIllIlIllIIIIllIIl[1].equals("remove")) {
                        Main.instance.macroManager.deleteMacroByKey(Keyboard.getKeyIndex(lllllllllllIIlIIllIlIllIIIIllIIl[2].toUpperCase()));
                        Main.msg(ChatFormatting.GREEN + "Macro " + ChatFormatting.WHITE + "was deleted from key " + ChatFormatting.RED + "\"" + lllllllllllIIlIIllIlIllIIIIllIIl[2].toUpperCase() + "\"", true);
                        NotificationPublisher.queue("Macro Manager", ChatFormatting.GREEN + "Macro " + ChatFormatting.WHITE + "was deleted from key " + ChatFormatting.RED + "\"" + lllllllllllIIlIIllIlIllIIIIllIIl[2].toUpperCase() + "\"", NotificationType.SUCCESS);
                    }
                    if (lllllllllllIIlIIllIlIllIIIIllIIl[1].equals("list")) {
                        if (Main.instance.macroManager.getMacros().isEmpty()) {
                            Main.msg(ChatFormatting.RED + "Your macros list is empty!", true);
                            NotificationPublisher.queue("Macro Manager", "Your macros list is empty!", NotificationType.ERROR);
                            return;
                        }
                        Main.instance.macroManager.getMacros().forEach(lllllllllllIIlIIllIlIllIIIIlIIII -> Main.msg(ChatFormatting.GREEN + "Macros list: " + ChatFormatting.WHITE + "Macros Name: " + ChatFormatting.RED + lllllllllllIIlIIllIlIllIIIIlIIII.getValue() + ChatFormatting.WHITE + ", Macro Bind: " + ChatFormatting.RED + Keyboard.getKeyName(lllllllllllIIlIIllIlIllIIIIlIIII.getKey()), true));
                    }
                }
            }
            else {
                Main.msg(this.getUsage(), true);
            }
        }
        catch (Exception ex) {}
    }
}
