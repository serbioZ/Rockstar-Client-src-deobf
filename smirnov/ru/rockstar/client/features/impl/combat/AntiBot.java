// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.movement.MovementHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import java.util.ArrayList;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import net.minecraft.entity.Entity;
import java.util.List;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class AntiBot extends Feature
{
    public /* synthetic */ ListSetting antiBotMode;
    public static /* synthetic */ List<Entity> isBotPlayer;
    public /* synthetic */ BooleanSetting invisIgnore;
    
    private boolean checkPosition(final double lllllllllllIIIllIlIIlIIlIIlIIllI, final double lllllllllllIIIllIlIIlIIlIIlIIlIl, final double lllllllllllIIIllIlIIlIIlIIlIIIIl) {
        return lllllllllllIIIllIlIIlIIlIIlIIllI <= lllllllllllIIIllIlIIlIIlIIlIIIIl && lllllllllllIIIllIlIIlIIlIIlIIllI >= lllllllllllIIIllIlIIlIIlIIlIIlIl;
    }
    
    static {
        AntiBot.isBotPlayer = new ArrayList<Entity>();
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate lllllllllllIIIllIlIIlIIlIIIllIII) {
        final String lllllllllllIIIllIlIIlIIlIIIlIlll = this.antiBotMode.getOptions();
        for (final Entity lllllllllllIIIllIlIIlIIlIIIlIllI : AntiBot.mc.world.loadedEntityList) {
            final float lllllllllllIIIllIlIIlIIlIIIlIIII;
            switch (((String)(lllllllllllIIIllIlIIlIIlIIIlIIII = (float)lllllllllllIIIllIlIIlIIlIIIlIlll)).hashCode()) {
                case -1997372447: {
                    if (!((String)lllllllllllIIIllIlIIlIIlIIIlIIII).equals("Matrix")) {
                        continue;
                    }
                    if (lllllllllllIIIllIlIIlIIlIIIlIllI != AntiBot.mc.player && lllllllllllIIIllIlIIlIIlIIIlIllI.ticksExisted < 5 && lllllllllllIIIllIlIIlIIlIIIlIllI instanceof EntityOtherPlayerMP && ((EntityOtherPlayerMP)lllllllllllIIIllIlIIlIIlIIIlIllI).hurtTime > 0 && AntiBot.mc.player.getDistanceToEntity(lllllllllllIIIllIlIIlIIlIIIlIllI) <= 25.0f && AntiBot.mc.player.connection.getPlayerInfo(lllllllllllIIIllIlIIlIIlIIIlIllI.getUniqueID()).getResponseTime() != 0) {
                        AntiBot.isBotPlayer.add(lllllllllllIIIllIlIIlIIlIIIlIllI);
                        continue;
                    }
                    continue;
                }
                case -1850955572: {
                    if (!((String)lllllllllllIIIllIlIIlIIlIIIlIIII).equals("Reflex")) {
                        continue;
                    }
                    if (lllllllllllIIIllIlIIlIIlIIIlIllI.getDisplayName().getUnformattedText().length() == 8 && AntiBot.mc.player.posY < lllllllllllIIIllIlIIlIIlIIIlIllI.posY && lllllllllllIIIllIlIIlIIlIIIlIllI.ticksExisted == 1 && !lllllllllllIIIllIlIIlIIlIIIlIllI.isCollidedVertically && !lllllllllllIIIllIlIIlIIlIIIlIllI.isEntityInsideOpaqueBlock() && lllllllllllIIIllIlIIlIIlIIIlIllI.fallDistance == 0.0f && lllllllllllIIIllIlIIlIIlIIIlIllI.posX != 0.0 && lllllllllllIIIllIlIIlIIlIIIlIllI.posZ != 0.0) {
                        AntiBot.isBotPlayer.add(lllllllllllIIIllIlIIlIIlIIIlIllI);
                        continue;
                    }
                    if (this.invisIgnore.getBoolValue() && lllllllllllIIIllIlIIlIIlIIIlIllI.isInvisible() && lllllllllllIIIllIlIIlIIlIIIlIllI != AntiBot.mc.player) {
                        AntiBot.isBotPlayer.add(lllllllllllIIIllIlIIlIIlIIIlIllI);
                        continue;
                    }
                    continue;
                }
                case 40593601: {
                    if (!((String)lllllllllllIIIllIlIIlIIlIIIlIIII).equals("Matrix New")) {
                        continue;
                    }
                    for (final Entity lllllllllllIIIllIlIIlIIlIIIlIlIl : AntiBot.mc.world.loadedEntityList) {
                        if (lllllllllllIIIllIlIIlIIlIIIlIlIl.ticksExisted < 20 && lllllllllllIIIllIlIIlIIlIIIlIlIl instanceof EntityOtherPlayerMP && ((EntityOtherPlayerMP)lllllllllllIIIllIlIIlIIlIIIlIlIl).getHealth() < 20.0f && MovementHelper.getEntityDirection((EntityLivingBase)lllllllllllIIIllIlIIlIIlIIIlIlIl) != MovementHelper.getPlayerDirection() && !lllllllllllIIIllIlIIlIIlIIIlIlIl.isDead && ((EntityOtherPlayerMP)lllllllllllIIIllIlIIlIIlIIIlIlIl).hurtTime > 0 && this.checkPosition(lllllllllllIIIllIlIIlIIlIIIlIlIl.posY, AntiBot.mc.player.posY - 3.0, AntiBot.mc.player.posY + 3.0) && ((EntityOtherPlayerMP)lllllllllllIIIllIlIIlIIlIIIlIlIl).getTotalArmorValue() == 0 && AntiBot.mc.player.getDistanceToEntity(lllllllllllIIIllIlIIlIIlIIIlIlIl) <= 25.0f && AntiBot.mc.player.connection.getPlayerInfo(lllllllllllIIIllIlIIlIIlIIIlIlIl.getUniqueID()).getResponseTime() != 0 && AntiBot.mc.player.connection.getPlayerInfo(lllllllllllIIIllIlIIlIIlIIIlIlIl.getUniqueID()).getResponseTime() <= 40) {
                            if (((EntityOtherPlayerMP)lllllllllllIIIllIlIIlIIlIIIlIlIl).getLastDamageSource() != null) {
                                continue;
                            }
                            AntiBot.isBotPlayer.add(lllllllllllIIIllIlIIlIIlIIIlIlIl);
                        }
                    }
                    continue;
                }
                default: {
                    continue;
                }
            }
        }
    }
    
    public AntiBot() {
        super("AntiBot", "\u0414\u043e\u0431\u0430\u0432\u043b\u044f\u0435\u0442 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439 \u0437\u0430\u0441\u043f\u0430\u0432\u043d\u0435\u043d\u044b\u0445 \u0430\u043d\u0442\u0438\u0447\u0438\u0442\u043e\u043c \u0432 \u0431\u043b\u044d\u043a-\u043b\u0438\u0441\u0442", 0, Category.COMBAT);
        this.antiBotMode = new ListSetting("AntiBot Mode", "Matrix", () -> true, new String[] { "Matrix", "Matrix New", "Reflex" });
        this.invisIgnore = new BooleanSetting("Remove Invisible", "\u0418\u0433\u043d\u043e\u0440\u0438\u0440\u0443\u0435\u0442 \u043d\u0435\u0432\u0438\u0434\u0438\u043c\u044b\u0445 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439", false, () -> true);
        this.addSettings(this.antiBotMode, this.invisIgnore);
    }
}
