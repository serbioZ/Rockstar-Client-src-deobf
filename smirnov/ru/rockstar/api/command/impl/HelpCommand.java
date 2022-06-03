// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command.impl;

import ru.rockstar.Main;
import com.mojang.realmsclient.gui.ChatFormatting;
import ru.rockstar.api.command.CommandAbstract;

public class HelpCommand extends CommandAbstract
{
    @Override
    public void execute(final String... lllllllllllIIIlIlllllIlllIlllIll) {
        if (lllllllllllIIIlIlllllIlllIlllIll.length == 1) {
            if (lllllllllllIIIlIlllllIlllIlllIll[0].equals("help")) {
                Main.msg(ChatFormatting.RED + "All Commands:", true);
                Main.msg(ChatFormatting.GRAY + ".bind", true);
                Main.msg(ChatFormatting.GRAY + ".macro", true);
                Main.msg(ChatFormatting.GRAY + ".friend", true);
                Main.msg(ChatFormatting.GRAY + ".config", true);
                Main.msg(ChatFormatting.GRAY + ".clip", true);
            }
        }
        else {
            Main.msg(this.getUsage(), true);
        }
    }
    
    public HelpCommand() {
        super("help", "help", ".help", new String[] { "help" });
    }
}
