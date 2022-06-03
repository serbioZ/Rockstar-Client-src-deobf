// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command.impl;

import java.util.Iterator;
import net.minecraft.block.Block;
import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import com.mojang.realmsclient.gui.ChatFormatting;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.visuals.XRay;
import ru.rockstar.Main;
import java.util.ArrayList;
import ru.rockstar.api.command.CommandAbstract;

public class XrayCommand extends CommandAbstract
{
    public static /* synthetic */ ArrayList<Integer> blockIDS;
    
    static {
        XrayCommand.blockIDS = new ArrayList<Integer>();
    }
    
    @Override
    public void execute(final String... lllllllllllIIllllIlIIIIllIllIIlI) {
        if (lllllllllllIIllllIlIIIIllIllIIlI.length >= 2) {
            if (!Main.featureDirector.getFeatureByClass(XRay.class).isToggled()) {
                Main.msg(ChatFormatting.RED + "Error " + ChatFormatting.WHITE + "please enable XRay module!", true);
                NotificationPublisher.queue("XrayManager", ChatFormatting.RED + "Error " + ChatFormatting.WHITE + "please enable XRay module!", NotificationType.SUCCESS);
                return;
            }
            if (lllllllllllIIllllIlIIIIllIllIIlI[0].equalsIgnoreCase("xray")) {
                if (lllllllllllIIllllIlIIIIllIllIIlI[1].equalsIgnoreCase("add")) {
                    if (!lllllllllllIIllllIlIIIIllIllIIlI[2].isEmpty()) {
                        if (!XrayCommand.blockIDS.contains(Integer.parseInt(lllllllllllIIllllIlIIIIllIllIIlI[2]))) {
                            XrayCommand.blockIDS.add(Integer.parseInt(lllllllllllIIllllIlIIIIllIllIIlI[2]));
                            Main.msg(ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "added block: " + ChatFormatting.RED + "\"" + Block.getBlockById(Integer.parseInt(lllllllllllIIllllIlIIIIllIllIIlI[2])).getLocalizedName() + "\"", true);
                            NotificationPublisher.queue("XrayManager", ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "added block: " + ChatFormatting.RED + "\"" + Block.getBlockById(Integer.parseInt(lllllllllllIIllllIlIIIIllIllIIlI[2])).getLocalizedName() + "\"", NotificationType.SUCCESS);
                        }
                        else {
                            Main.msg(ChatFormatting.RED + "Error " + ChatFormatting.WHITE + "this block already have in list!", true);
                            NotificationPublisher.queue("XrayManager", ChatFormatting.RED + "Error " + ChatFormatting.WHITE + "this block already have in list!", NotificationType.SUCCESS);
                        }
                    }
                }
                else if (lllllllllllIIllllIlIIIIllIllIIlI[1].equalsIgnoreCase("remove")) {
                    if (XrayCommand.blockIDS.contains(new Integer(lllllllllllIIllllIlIIIIllIllIIlI[2]))) {
                        XrayCommand.blockIDS.remove(new Integer(lllllllllllIIllllIlIIIIllIllIIlI[2]));
                        Main.msg(ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "removed block by id " + Integer.parseInt(lllllllllllIIllllIlIIIIllIllIIlI[2]), true);
                        NotificationPublisher.queue("XrayManager", ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "removed block by id " + Integer.parseInt(lllllllllllIIllllIlIIIIllIllIIlI[2]), NotificationType.SUCCESS);
                    }
                    else {
                        Main.msg(ChatFormatting.RED + "Error " + ChatFormatting.WHITE + "this block doesn't contains in your list!", true);
                        NotificationPublisher.queue("XrayManager", ChatFormatting.RED + "Error " + ChatFormatting.WHITE + "this block doesn't contains in your list!", NotificationType.SUCCESS);
                    }
                }
                else if (lllllllllllIIllllIlIIIIllIllIIlI[1].equalsIgnoreCase("list")) {
                    if (!XrayCommand.blockIDS.isEmpty()) {
                        for (final Integer lllllllllllIIllllIlIIIIllIllIIll : XrayCommand.blockIDS) {
                            Main.msg(ChatFormatting.RED + Block.getBlockById(lllllllllllIIllllIlIIIIllIllIIll).getLocalizedName() + ChatFormatting.LIGHT_PURPLE + " ID: " + lllllllllllIIllllIlIIIIllIllIIll, true);
                        }
                    }
                    else {
                        Main.msg(ChatFormatting.RED + "Error " + ChatFormatting.WHITE + "your block list is empty!", true);
                        NotificationPublisher.queue("XrayManager", ChatFormatting.RED + "Error " + ChatFormatting.WHITE + "your block list is empty!", NotificationType.SUCCESS);
                    }
                }
                else if (lllllllllllIIllllIlIIIIllIllIIlI[1].equalsIgnoreCase("clear")) {
                    if (XrayCommand.blockIDS.isEmpty()) {
                        Main.msg(ChatFormatting.RED + "Error " + ChatFormatting.WHITE + "your block list is empty!", true);
                        NotificationPublisher.queue("XrayManager", ChatFormatting.RED + "Error " + ChatFormatting.WHITE + "your block list is empty!", NotificationType.SUCCESS);
                    }
                    else {
                        XrayCommand.blockIDS.clear();
                        Main.msg(ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "clear block list!", true);
                        NotificationPublisher.queue("XrayManager", ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "clear block list!", NotificationType.SUCCESS);
                    }
                }
            }
        }
    }
    
    public XrayCommand() {
        super("xray", "xray", "\u0412§6.xray add \u0412§3<blockId> | \u0412§6.xray remove \u0412§3<blockId> | \u0412§6.xray list | \u0412§6.xray clear", new String[] { "xray" });
    }
}
