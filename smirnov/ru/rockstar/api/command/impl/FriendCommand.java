// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command.impl;

import ru.rockstar.api.utils.friend.Friend;
import com.mojang.realmsclient.gui.ChatFormatting;
import ru.rockstar.api.utils.friend.FriendManager;
import ru.rockstar.Main;
import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import ru.rockstar.api.command.CommandAbstract;

public class FriendCommand extends CommandAbstract
{
    @Override
    public void execute(final String... lllllllllllIIllllIIlllIllllIlIIl) {
        try {
            if (lllllllllllIIllllIIlllIllllIlIIl.length > 1) {
                if (lllllllllllIIllllIIlllIllllIlIIl[0].equalsIgnoreCase("friend")) {
                    if (lllllllllllIIllllIIlllIllllIlIIl[1].equalsIgnoreCase("add")) {
                        final String lllllllllllIIllllIIlllIllllIlIII = lllllllllllIIllllIIlllIllllIlIIl[2];
                        if (lllllllllllIIllllIIlllIllllIlIII.equals(FriendCommand.mc.player.getName())) {
                            NotificationPublisher.queue("Friend Manager", "You can't add yourself!", NotificationType.ERROR);
                            return;
                        }
                        final FriendManager friendManager = Main.instance.friendManager;
                        if (!FriendManager.isFriend(lllllllllllIIllllIIlllIllllIlIII)) {
                            Main.instance.friendManager.addFriend(lllllllllllIIllllIIlllIllllIlIII);
                            NotificationPublisher.queue("Friend Manager", "Friend " + ChatFormatting.RED + lllllllllllIIllllIIlllIllllIlIII + ChatFormatting.WHITE + " deleted from your friend list!", NotificationType.SUCCESS);
                        }
                    }
                    if (lllllllllllIIllllIIlllIllllIlIIl[1].equalsIgnoreCase("del")) {
                        final String lllllllllllIIllllIIlllIllllIIlll = lllllllllllIIllllIIlllIllllIlIIl[2];
                        final FriendManager friendManager2 = Main.instance.friendManager;
                        if (FriendManager.isFriend(lllllllllllIIllllIIlllIllllIIlll)) {
                            Main.instance.friendManager.removeFriend(lllllllllllIIllllIIlllIllllIIlll);
                            NotificationPublisher.queue("Friend Manager", "Friend " + ChatFormatting.RED + lllllllllllIIllllIIlllIllllIIlll + ChatFormatting.WHITE + " deleted from your friend list!", NotificationType.SUCCESS);
                        }
                    }
                    if (lllllllllllIIllllIIlllIllllIlIIl[1].equalsIgnoreCase("clear")) {
                        if (Main.instance.friendManager.getFriends().isEmpty()) {
                            Main.msg(ChatFormatting.RED + "Your friend list is empty!", true);
                            NotificationPublisher.queue("Friend Manager", "Your friend list is empty!", NotificationType.ERROR);
                            return;
                        }
                        Main.instance.friendManager.getFriends().clear();
                        Main.msg("Your " + ChatFormatting.GREEN + "friend list " + ChatFormatting.WHITE + "was cleared!", true);
                        NotificationPublisher.queue("Friend Manager", "Your " + ChatFormatting.GREEN + "friend list " + ChatFormatting.WHITE + "was cleared!", NotificationType.SUCCESS);
                    }
                    if (lllllllllllIIllllIIlllIllllIlIIl[1].equalsIgnoreCase("list")) {
                        if (Main.instance.friendManager.getFriends().isEmpty()) {
                            NotificationPublisher.queue("Friend Manager", "Your friend list is empty!", NotificationType.ERROR);
                            return;
                        }
                        Main.instance.friendManager.getFriends().forEach(lllllllllllIIllllIIlllIllllIIIII -> Main.msg(ChatFormatting.GREEN + "Friend list: " + ChatFormatting.RED + lllllllllllIIllllIIlllIllllIIIII.getName(), true));
                    }
                }
            }
            else {
                Main.msg(this.getUsage(), true);
            }
        }
        catch (Exception lllllllllllIIllllIIlllIllllIIllI) {
            Main.msg("§cNo, no, no. Usage: " + this.getUsage(), true);
        }
    }
    
    public FriendCommand() {
        super("friend", "friend list", "§6.friend" + ChatFormatting.RED + " add " + "§7<nickname> | §6.friend" + ChatFormatting.RED + " del " + "§7<nickname> | §6.friend" + ChatFormatting.RED + " list " + "| §6.friend" + ChatFormatting.RED + " clear", new String[] { "friend" });
    }
}
