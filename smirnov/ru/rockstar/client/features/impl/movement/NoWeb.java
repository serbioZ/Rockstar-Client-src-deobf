// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.api.event.event.MoveEvent;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.entity.EntityPlayerSP;
import ru.rockstar.api.utils.movement.MovementHelper;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class NoWeb extends Feature
{
    public /* synthetic */ NumberSetting webSpeed;
    public /* synthetic */ ListSetting noWebMode;
    public /* synthetic */ NumberSetting webJumpMotion;
    
    public NoWeb() {
        super("NoWeb", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0431\u044b\u0441\u0442\u0440\u043e \u0445\u043e\u0434\u0438\u0442\u044c \u0432 \u043f\u0430\u0443\u0442\u0438\u043d\u0435", 0, Category.PLAYER);
        this.noWebMode = new ListSetting("NoWeb Mode", "Matrix", () -> true, new String[] { "Matrix", "Matrix New", "NCP" });
        this.webSpeed = new NumberSetting("Web Speed", 0.8f, 0.1f, 2.0f, 0.1f, () -> this.noWebMode.currentMode.equals("Matrix New"));
        this.webJumpMotion = new NumberSetting("Jump Motion", 2.0f, 0.0f, 10.0f, 1.0f, () -> this.noWebMode.currentMode.equals("Matrix New"));
        this.addSettings(this.noWebMode, this.webJumpMotion, this.webSpeed);
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate lllllllllllIlIlIIIllllIIIIIIIllI) {
        final String lllllllllllIlIlIIIllllIIIIIIIlIl = this.noWebMode.getOptions();
        this.setSuffix(lllllllllllIlIlIIIllllIIIIIIIlIl, true);
        if (lllllllllllIlIlIIIllllIIIIIIIlIl.equalsIgnoreCase("Matrix New")) {
            final BlockPos lllllllllllIlIlIIIllllIIIIIIIlII = new BlockPos(NoWeb.mc.player.posX, NoWeb.mc.player.posY - 0.6, NoWeb.mc.player.posZ);
            final Block lllllllllllIlIlIIIllllIIIIIIIIll = NoWeb.mc.world.getBlockState(lllllllllllIlIlIIIllllIIIIIIIlII).getBlock();
            if (NoWeb.mc.player.isInWeb) {
                final EntityPlayerSP player = NoWeb.mc.player;
                player.motionY += 2.0;
            }
            else if (Block.getIdFromBlock(lllllllllllIlIlIIIllllIIIIIIIIll) == 30) {
                if (this.webJumpMotion.getNumberValue() > 0.0f) {
                    final EntityPlayerSP player2 = NoWeb.mc.player;
                    player2.motionY += this.webJumpMotion.getNumberValue();
                }
                else {
                    NoWeb.mc.player.motionY = 0.0;
                }
                MovementHelper.setSpeed(this.webSpeed.getNumberValue());
                NoWeb.mc.gameSettings.keyBindJump.pressed = false;
            }
        }
    }
    
    @EventTarget
    public void onMove(final MoveEvent lllllllllllIlIlIIIlllIllllllIlll) {
        final String lllllllllllIlIlIIIlllIlllllllIIl = this.noWebMode.getOptions();
        this.setSuffix(lllllllllllIlIlIIIlllIlllllllIIl, true);
        if (this.isToggled()) {
            if (lllllllllllIlIlIIIlllIlllllllIIl.equalsIgnoreCase("Matrix")) {
                if (NoWeb.mc.player.onGround && NoWeb.mc.player.isInWeb) {
                    NoWeb.mc.player.isInWeb = true;
                }
                else {
                    if (NoWeb.mc.gameSettings.keyBindJump.isKeyDown()) {
                        return;
                    }
                    NoWeb.mc.player.isInWeb = false;
                }
                if (NoWeb.mc.player.isInWeb && !NoWeb.mc.gameSettings.keyBindSneak.isKeyDown()) {
                    MovementHelper.setEventSpeed(lllllllllllIlIlIIIlllIllllllIlll, 0.483);
                }
            }
            else if (lllllllllllIlIlIIIlllIlllllllIIl.equalsIgnoreCase("NCP")) {
                if (NoWeb.mc.player.onGround && NoWeb.mc.player.isInWeb) {
                    NoWeb.mc.player.isInWeb = true;
                }
                else {
                    if (NoWeb.mc.gameSettings.keyBindJump.isKeyDown()) {
                        return;
                    }
                    NoWeb.mc.player.isInWeb = false;
                }
                if (NoWeb.mc.player.isInWeb && !NoWeb.mc.gameSettings.keyBindSneak.isKeyDown()) {
                    MovementHelper.setEventSpeed(lllllllllllIlIlIIIlllIllllllIlll, 0.403);
                }
            }
        }
    }
}
