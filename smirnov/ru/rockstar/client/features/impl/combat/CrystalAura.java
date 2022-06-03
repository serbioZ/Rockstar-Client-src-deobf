// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.api.event.EventTarget;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.EnumHand;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketUseEntity;
import ru.rockstar.api.utils.combat.RotationHelper;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.Entity;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.features.Feature;

public class CrystalAura extends Feature
{
    public CrystalAura() {
        super("CrystalAura", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0431\u044c\u0451\u0442 \u043f\u043e \u043a\u0440\u0438\u0441\u0442\u0430\u043b\u043b\u0443", 0, Category.COMBAT);
    }
    
    @EventTarget
    public void onUpdate(final EventPreMotionUpdate llllllllllllIIlllllIlIlIlIlllIll) {
        for (final Entity llllllllllllIIlllllIlIlIlIlllIlI : CrystalAura.mc.world.loadedEntityList) {
            if (llllllllllllIIlllllIlIlIlIlllIlI instanceof EntityEnderCrystal && KillAura.target == null) {
                llllllllllllIIlllllIlIlIlIlllIll.setPitch(RotationHelper.getRotations(llllllllllllIIlllllIlIlIlIlllIlI)[1]);
                llllllllllllIIlllllIlIlIlIlllIll.setYaw(RotationHelper.getRotations(llllllllllllIIlllllIlIlIlIlllIlI)[0]);
                CrystalAura.mc.player.rotationYawHead = llllllllllllIIlllllIlIlIlIlllIll.getYaw();
                CrystalAura.mc.player.renderYawOffset = llllllllllllIIlllllIlIlIlIlllIll.getYaw();
                CrystalAura.mc.player.rotationPitchHead = llllllllllllIIlllllIlIlIlIlllIll.getPitch();
                CrystalAura.mc.getConnection().sendPacket(new CPacketUseEntity(llllllllllllIIlllllIlIlIlIlllIlI));
                CrystalAura.mc.getConnection().sendPacket(new CPacketAnimation(EnumHand.MAIN_HAND));
            }
        }
    }
}
