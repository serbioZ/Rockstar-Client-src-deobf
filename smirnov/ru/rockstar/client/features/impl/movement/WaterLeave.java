// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.util.math.BlockPos;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class WaterLeave extends Feature
{
    private final /* synthetic */ NumberSetting leaveMotion;
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIllIlIIIIlIIlIllIIlII) {
        final BlockPos lllllllllllIllIlIIIIlIIlIllIIIll = new BlockPos(WaterLeave.mc.player.posX, WaterLeave.mc.player.posY - 0.1, WaterLeave.mc.player.posZ);
        final Block lllllllllllIllIlIIIIlIIlIllIIIlI = WaterLeave.mc.world.getBlockState(lllllllllllIllIlIIIIlIIlIllIIIll).getBlock();
        if (lllllllllllIllIlIIIIlIIlIllIIIlI instanceof BlockLiquid) {
            if (WaterLeave.mc.world.getBlockState(new BlockPos(WaterLeave.mc.player.posX, WaterLeave.mc.player.posY + 0.01, WaterLeave.mc.player.posZ)).getBlock() == Block.getBlockById(9) && WaterLeave.mc.player.isInsideOfMaterial(Material.AIR)) {
                WaterLeave.mc.player.motionY = 0.08;
            }
            if (!WaterLeave.mc.player.isInLiquid() && WaterLeave.mc.player.fallDistance > 0.0f && WaterLeave.mc.player.motionY < 0.08) {
                final EntityPlayerSP player = WaterLeave.mc.player;
                player.motionY += this.leaveMotion.getNumberValue();
            }
        }
    }
    
    public WaterLeave() {
        super("WaterLeave", "\u0418\u0433\u0440\u043e\u043a \u0432\u044b\u0441\u043e\u043a\u043e \u043f\u0440\u044b\u0433\u0430\u0435\u0442 \u043f\u0440\u0438 \u043f\u043e\u0433\u0440\u0443\u0436\u0435\u043d\u0438\u0438 \u0432 \u0432\u043e\u0434\u0443", 0, Category.MOVEMENT);
        this.leaveMotion = new NumberSetting("Motion Y", 10.0f, 0.5f, 10.0f, 0.5f, () -> true);
        this.addSettings(this.leaveMotion);
    }
}
