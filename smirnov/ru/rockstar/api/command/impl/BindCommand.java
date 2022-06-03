// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command.impl;

import net.minecraft.util.text.TextFormatting;
import ru.rockstar.client.features.Feature;
import org.lwjgl.input.Keyboard;
import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import com.mojang.realmsclient.gui.ChatFormatting;
import ru.rockstar.Main;
import ru.rockstar.api.command.CommandAbstract;

public class BindCommand extends CommandAbstract
{
    @Override
    public void execute(final String... lllllllllllllIlIIlIlllIlIIIlIIII) {
        try {
            if (lllllllllllllIlIIlIlllIlIIIlIIII.length == 4) {
                final String lllllllllllllIlIIlIlllIlIIIIllll = lllllllllllllIlIIlIlllIlIIIlIIII[2];
                final String lllllllllllllIlIIlIlllIlIIIIlllI = lllllllllllllIlIIlIlllIlIIIlIIII[3].toUpperCase();
                final Feature lllllllllllllIlIIlIlllIlIIIIllIl = Main.featureDirector.getFeatureByLabel(lllllllllllllIlIIlIlllIlIIIIllll);
                if (lllllllllllllIlIIlIlllIlIIIlIIII[0].equals("bind")) {
                    final byte lllllllllllllIlIIlIlllIlIIIIIlll;
                    switch (((String)(lllllllllllllIlIIlIlllIlIIIIIlll = (byte)lllllllllllllIlIIlIlllIlIIIlIIII[1])).hashCode()) {
                        case -934610812: {
                            if (!((String)lllllllllllllIlIIlIlllIlIIIIIlll).equals("remove")) {
                                break;
                            }
                            lllllllllllllIlIIlIlllIlIIIIllIl.setKey(0);
                            Main.msg(ChatFormatting.GREEN + lllllllllllllIlIIlIlllIlIIIIllIl.getLabel() + ChatFormatting.WHITE + " bind was deleted from key " + ChatFormatting.RED + "\"" + lllllllllllllIlIIlIlllIlIIIIlllI + "\"", true);
                            NotificationPublisher.queue("Bind Manager", ChatFormatting.GREEN + lllllllllllllIlIIlIlllIlIIIIllIl.getLabel() + ChatFormatting.WHITE + " bind was deleted from key " + ChatFormatting.RED + "\"" + lllllllllllllIlIIlIlllIlIIIIlllI + "\"", NotificationType.SUCCESS);
                            break;
                        }
                        case 96417: {
                            if (!((String)lllllllllllllIlIIlIlllIlIIIIIlll).equals("add")) {
                                break;
                            }
                            lllllllllllllIlIIlIlllIlIIIIllIl.setKey(Keyboard.getKeyIndex(lllllllllllllIlIIlIlllIlIIIIlllI));
                            Main.msg(ChatFormatting.GREEN + lllllllllllllIlIIlIlllIlIIIIllIl.getLabel() + ChatFormatting.WHITE + " was set on key " + ChatFormatting.RED + "\"" + lllllllllllllIlIIlIlllIlIIIIlllI + "\"", true);
                            NotificationPublisher.queue("Bind Manager", ChatFormatting.GREEN + lllllllllllllIlIIlIlllIlIIIIllIl.getLabel() + ChatFormatting.WHITE + " was set on key " + ChatFormatting.RED + "\"" + lllllllllllllIlIIlIlllIlIIIIlllI + "\"", NotificationType.SUCCESS);
                            break;
                        }
                        case 3322014: {
                            if (!((String)lllllllllllllIlIIlIlllIlIIIIIlll).equals("list")) {
                                break;
                            }
                            if (lllllllllllllIlIIlIlllIlIIIIllIl.getKey() == 0) {
                                Main.msg(ChatFormatting.RED + "Your macros list is empty!", true);
                                NotificationPublisher.queue("Macro Manager", "Your macros list is empty!", NotificationType.ERROR);
                                return;
                            }
                            Main.featureDirector.getFeatureList().forEach(lllllllllllllIlIIlIlllIlIIIIIlIl -> Main.msg(ChatFormatting.GREEN + "Binds list: " + ChatFormatting.WHITE + "Binds Name: " + ChatFormatting.RED + lllllllllllllIlIIlIlllIlIIIIIlIl.getKey() + ChatFormatting.WHITE + ", Macro Bind: " + ChatFormatting.RED + Keyboard.getKeyName(lllllllllllllIlIIlIlllIlIIIIIlIl.getKey()), true));
                            break;
                        }
                        case 94746189: {
                            if (!((String)lllllllllllllIlIIlIlllIlIIIIIlll).equals("clear")) {
                                break;
                            }
                            if (!lllllllllllllIlIIlIlllIlIIIIllIl.getLabel().equals("ClickGui")) {
                                lllllllllllllIlIIlIlllIlIIIIllIl.setKey(0);
                                break;
                            }
                            break;
                        }
                    }
                }
            }
            else {
                Main.msg(this.getUsage(), true);
            }
        }
        catch (Exception ex) {}
    }
    
    public BindCommand() {
        super("bind", "bind", "§6.bind" + ChatFormatting.RED + " add " + "§7<name> §7<key> " + TextFormatting.RED + "/" + " §6.bind " + ChatFormatting.RED + "remove " + "§7<name> §7<key>", new String[] { "§6.bind" + ChatFormatting.RED + " add " + "§7<name> §7<key> | §6.bind" + ChatFormatting.RED + "remove " + "§7<name> <key> | §6.bind" + ChatFormatting.RED + "clear", "bind" });
    }
}
