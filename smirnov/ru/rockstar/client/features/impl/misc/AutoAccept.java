// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.misc;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.friend.FriendManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.CPacketChatMessage;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class AutoAccept extends Feature
{
    public /* synthetic */ BooleanSetting onlyFriends;
    
    @EventTarget
    public void onReceiveChat(final CPacketChatMessage lllllllllllIIIIIlIlllIlllllllIlI) {
        for (final EntityPlayer lllllllllllIIIIIlIlllIllllllllII : AutoAccept.mc.world.playerEntities) {
            if (this.onlyFriends.getBoolValue()) {
                if ((!lllllllllllIIIIIlIlllIlllllllIlI.getMessage().contains("/tpyes") && (!lllllllllllIIIIIlIlllIlllllllIlI.getMessage().contains("/tpaccept") || !FriendManager.isFriend(lllllllllllIIIIIlIlllIllllllllII.getName()))) || !AutoAccept.timerHelper.check(500.0f)) {
                    continue;
                }
                AutoAccept.mc.player.sendChatMessage("/tpaccept");
                AutoAccept.timerHelper.resetwatermark();
            }
            else {
                if ((!lllllllllllIIIIIlIlllIlllllllIlI.getMessage().contains("/tpyes") && !lllllllllllIIIIIlIlllIlllllllIlI.getMessage().contains("/tpaccept")) || !AutoAccept.timerHelper.check(500.0f)) {
                    continue;
                }
                AutoAccept.mc.player.sendChatMessage("/tpaccept");
                AutoAccept.timerHelper.resetwatermark();
            }
        }
    }
    
    public AutoAccept() {
        super("AutoAccept", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u043f\u0440\u0438\u043d\u0438\u043c\u0430\u0435\u0442 \u0437\u0430\u043f\u0440\u043e\u0441\u044b \u043d\u0430 \u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0430\u0446\u0438\u044e", 0, Category.MISC);
        this.onlyFriends = new BooleanSetting("OnlyFriends", true, () -> true);
        this.addSettings(this.onlyFriends);
    }
}
