// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.entity.Entity;
import net.minecraft.client.entity.EntityPlayerSP;
import java.util.Objects;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.client.CPacketPlayer;
import ru.rockstar.api.utils.movement.MovementHelper;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.init.MobEffects;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import ru.rockstar.api.event.event.EventReceivePacket;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class Velocity extends Feature
{
    public static /* synthetic */ NumberSetting verticalPer;
    public static /* synthetic */ NumberSetting horizontalPer;
    public static /* synthetic */ BooleanSetting cancelOtherDamage;
    public static /* synthetic */ ListSetting velocityMode;
    
    @EventTarget
    public void onReceivePacket(final EventReceivePacket llllllllllllIIIlIlIlllIlIllIIIlI) {
        final String llllllllllllIIIlIlIlllIlIllIIIIl = Velocity.velocityMode.getOptions();
        if (Velocity.cancelOtherDamage.getBoolValue() && Velocity.mc.player.hurtTime > 0 && llllllllllllIIIlIlIlllIlIllIIIlI.getPacket() instanceof SPacketEntityVelocity && !Velocity.mc.player.isPotionActive(MobEffects.FIRE_RESISTANCE) && (Velocity.mc.player.isPotionActive(MobEffects.POISON) || Velocity.mc.player.isPotionActive(MobEffects.WITHER) || Velocity.mc.player.isBurning())) {
            llllllllllllIIIlIlIlllIlIllIIIlI.setCancelled(true);
        }
        if (llllllllllllIIIlIlIlllIlIllIIIIl.equalsIgnoreCase("Packet")) {
            if (llllllllllllIIIlIlIlllIlIllIIIlI.getPacket() instanceof SPacketEntityVelocity || llllllllllllIIIlIlIlllIlIllIIIlI.getPacket() instanceof SPacketExplosion) {
                final SPacketEntityVelocity llllllllllllIIIlIlIlllIlIllIIIII = (SPacketEntityVelocity)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket();
                if (llllllllllllIIIlIlIlllIlIllIIIII.getEntityID() == Velocity.mc.player.getEntityId()) {
                    llllllllllllIIIlIlIlllIlIllIIIlI.setCancelled(true);
                }
            }
        }
        else if (llllllllllllIIIlIlIlllIlIllIIIIl.equalsIgnoreCase("Strafe Cancel")) {
            if (llllllllllllIIIlIlIlllIlIllIIIlI.getPacket() instanceof SPacketEntityVelocity || llllllllllllIIIlIlIlllIlIllIIIlI.getPacket() instanceof SPacketExplosion) {
                if (((SPacketEntityVelocity)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).getEntityID() == Velocity.mc.player.getEntityId()) {
                    llllllllllllIIIlIlIlllIlIllIIIlI.setCancelled(true);
                }
                if (Velocity.mc.player.hurtTime > 0) {
                    MovementHelper.strafe(0.2f);
                }
            }
        }
        else if (llllllllllllIIIlIlIlllIlIllIIIIl.equalsIgnoreCase("AAC4+")) {
            if (Velocity.mc.player.hurtTime > 0 && Velocity.mc.player.hurtTime <= 5) {
                final CPacketPlayer llllllllllllIIIlIlIlllIlIlIlllll = (CPacketPlayer)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket();
                llllllllllllIIIlIlIlllIlIlIlllll.isOnGround();
                final EntityPlayerSP player;
                final EntityPlayerSP llllllllllllIIIlIlIlllIlIlIllllI = player = Velocity.mc.player;
                player.motionX *= 0.2;
                final EntityPlayerSP player2;
                final EntityPlayerSP llllllllllllIIIlIlIlllIlIlIlllIl = player2 = Velocity.mc.player;
                player2.motionZ *= 0.2;
            }
        }
        else if (llllllllllllIIIlIlIlllIlIllIIIIl.equalsIgnoreCase("Custom Motion")) {
            final double llllllllllllIIIlIlIlllIlIlIlllII = Velocity.horizontalPer.getNumberValue();
            final double llllllllllllIIIlIlIlllIlIlIllIll = Velocity.verticalPer.getNumberValue();
            if (((SPacketEntityVelocity)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).getEntityID() == Velocity.mc.player.getEntityId()) {
                if (llllllllllllIIIlIlIlllIlIllIIIlI.getPacket() instanceof SPacketEntityVelocity) {
                    final Entity llllllllllllIIIlIlIlllIlIlIllIlI = Objects.requireNonNull(Velocity.mc.getConnection()).clientWorldController.getEntityByID(((SPacketEntityVelocity)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).getEntityID());
                    if (llllllllllllIIIlIlIlllIlIlIllIlI instanceof EntityPlayerSP) {
                        if (llllllllllllIIIlIlIlllIlIlIlllII == 0.0 && llllllllllllIIIlIlIlllIlIlIllIll == 0.0) {
                            llllllllllllIIIlIlIlllIlIllIIIlI.setCancelled(true);
                            return;
                        }
                        if (llllllllllllIIIlIlIlllIlIlIlllII != 100.0) {
                            ((SPacketEntityVelocity)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).motionX = (int)(((SPacketEntityVelocity)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).motionX / 100 * llllllllllllIIIlIlIlllIlIlIlllII);
                            ((SPacketEntityVelocity)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).motionZ = (int)(((SPacketEntityVelocity)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).motionZ / 100 * llllllllllllIIIlIlIlllIlIlIlllII);
                        }
                        if (llllllllllllIIIlIlIlllIlIlIllIll != 100.0) {
                            ((SPacketEntityVelocity)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).motionY = (int)(((SPacketEntityVelocity)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).motionY / 100 * llllllllllllIIIlIlIlllIlIlIllIll);
                        }
                    }
                }
                if (llllllllllllIIIlIlIlllIlIllIIIlI.getPacket() instanceof SPacketExplosion) {
                    if (llllllllllllIIIlIlIlllIlIlIlllII == 0.0 && llllllllllllIIIlIlIlllIlIlIllIll == 0.0) {
                        llllllllllllIIIlIlIlllIlIllIIIlI.setCancelled(true);
                        return;
                    }
                    if (llllllllllllIIIlIlIlllIlIlIlllII != 100.0) {
                        ((SPacketExplosion)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).motionX = (float)(int)(((SPacketExplosion)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).motionX / 100.0f * llllllllllllIIIlIlIlllIlIlIlllII);
                        ((SPacketExplosion)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).motionZ = (float)(int)(((SPacketExplosion)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).motionZ / 100.0f * llllllllllllIIIlIlIlllIlIlIlllII);
                    }
                    if (llllllllllllIIIlIlIlllIlIlIllIll != 100.0) {
                        ((SPacketExplosion)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).motionY = (float)(int)(((SPacketExplosion)llllllllllllIIIlIlIlllIlIllIIIlI.getPacket()).motionY / 100.0f * llllllllllllIIIlIlIlllIlIlIllIll);
                    }
                }
            }
        }
    }
    
    public Velocity() {
        super("Velocity", "\u0423\u043c\u0435\u043d\u044c\u0448\u0430\u0435\u0442 \u043a\u043d\u043e\u043a\u0431\u044d\u043a \u043f\u0440\u0438 \u0443\u0434\u0430\u0440\u0435", 0, Category.COMBAT);
        Velocity.velocityMode = new ListSetting("Velocity Mode", "Packet", () -> true, new String[] { "Packet", "Custom Motion", "Matrix", "AAC4+", "Strafe Cancel" });
        Velocity.cancelOtherDamage = new BooleanSetting("Cancel Other Damage", true, () -> true);
        Velocity.verticalPer = new NumberSetting("Vertical Percentage", 0.0f, 0.0f, 100.0f, 1.0f, () -> Velocity.velocityMode.currentMode.equals("Custom Motion"));
        Velocity.horizontalPer = new NumberSetting("Horizontal Percentage", 0.0f, 0.0f, 100.0f, 1.0f, () -> Velocity.velocityMode.currentMode.equals("Custom Motion"));
        this.addSettings(Velocity.velocityMode, Velocity.cancelOtherDamage, Velocity.verticalPer, Velocity.horizontalPer);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllIIIlIlIlllIlIllIllll) {
        if (Velocity.velocityMode.currentMode.equals("Custom Motion")) {
            final double llllllllllllIIIlIlIlllIlIllIlllI = Velocity.horizontalPer.getNumberValue();
            final double llllllllllllIIIlIlIlllIlIllIllIl = Velocity.verticalPer.getNumberValue();
            this.setSuffix("H: " + llllllllllllIIIlIlIlllIlIllIlllI + "% V: " + llllllllllllIIIlIlIlllIlIllIllIl + "%", true);
        }
        else {
            this.setSuffix(Velocity.velocityMode.currentMode, true);
        }
    }
}
