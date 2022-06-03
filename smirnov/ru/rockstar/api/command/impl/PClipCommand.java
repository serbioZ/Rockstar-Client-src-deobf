// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command.impl;

import ru.rockstar.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import ru.rockstar.api.utils.world.InventoryHelper;
import net.minecraft.network.Packet;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.command.CommandAbstract;

public class PClipCommand extends CommandAbstract
{
    /* synthetic */ Minecraft mc;
    
    public PClipCommand() {
        super("eclip", "eclip", "§6.pclip + | - §3<value> | down", new String[] { "eclip" });
        this.mc = Minecraft.getMinecraft();
    }
    
    @Override
    public void execute(final String... lllllllllllIIlIIllIlllIlIllIllII) {
        boolean lllllllllllIIlIIllIlllIlIllIlIll = false;
        boolean lllllllllllIIlIIllIlllIlIllIlIlI = false;
        boolean lllllllllllIIlIIllIlllIlIllIlIIl = false;
        boolean lllllllllllIIlIIllIlllIlIllIlIII = false;
        boolean lllllllllllIIlIIllIlllIlIllIIlll = false;
        if (!this.mc.player.onGround && this.mc.player.fallDistance > 0.0f && lllllllllllIIlIIllIlllIlIllIlIlI) {
            this.mc.getConnection().sendPacket(new CPacketEntityAction(this.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
            this.mc.player.setPositionAndUpdate(this.mc.player.posX, this.mc.player.posY - this.mc.player.posY - 2.0, this.mc.player.posZ);
        }
        if (!this.mc.player.onGround && this.mc.player.fallDistance > 0.0f && lllllllllllIIlIIllIlllIlIllIlIIl) {
            this.mc.getConnection().sendPacket(new CPacketEntityAction(this.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
            this.mc.player.setPositionAndUpdate(this.mc.player.posX, this.mc.player.posY + Double.parseDouble(lllllllllllIIlIIllIlllIlIllIllII[2]), this.mc.player.posZ);
        }
        if (!this.mc.player.onGround && this.mc.player.fallDistance > 0.0f && lllllllllllIIlIIllIlllIlIllIlIII) {
            this.mc.getConnection().sendPacket(new CPacketEntityAction(this.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
            this.mc.player.setPositionAndUpdate(this.mc.player.posX, this.mc.player.posY - Double.parseDouble(lllllllllllIIlIIllIlllIlIllIllII[2]), this.mc.player.posZ);
        }
        if (lllllllllllIIlIIllIlllIlIllIllII.length > 1) {
            if (lllllllllllIIlIIllIlllIlIllIllII[0].equalsIgnoreCase("eclip")) {
                try {
                    if (lllllllllllIIlIIllIlllIlIllIllII[1].equals("down")) {
                        lllllllllllIIlIIllIlllIlIllIlIlI = true;
                        if (lllllllllllIIlIIllIlllIlIllIIlll) {
                            this.mc.playerController.windowClick(0, InventoryHelper.getElytraAtHotbar(), 1, ClickType.PICKUP, this.mc.player);
                        }
                        if (!this.mc.player.onGround) {
                            this.mc.playerController.windowClick(0, InventoryHelper.getElytraAtHotbar(), 1, ClickType.PICKUP, this.mc.player);
                            this.mc.playerController.windowClick(0, 6, 1, ClickType.PICKUP, this.mc.player);
                            lllllllllllIIlIIllIlllIlIllIIlll = true;
                        }
                        if (this.mc.player.onGround) {
                            this.mc.player.jump();
                            lllllllllllIIlIIllIlllIlIllIlIll = true;
                        }
                        if (!this.mc.player.onGround && this.mc.player.fallDistance > 0.0f) {
                            this.mc.getConnection().sendPacket(new CPacketEntityAction(this.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
                            this.mc.player.setPositionAndUpdate(this.mc.player.posX, this.mc.player.posY - this.mc.player.posY - 2.0, this.mc.player.posZ);
                        }
                    }
                    if (lllllllllllIIlIIllIlllIlIllIllII[1].equals("+")) {
                        lllllllllllIIlIIllIlllIlIllIlIIl = true;
                        if (lllllllllllIIlIIllIlllIlIllIIlll) {
                            this.mc.playerController.windowClick(0, InventoryHelper.getElytraAtHotbar(), 1, ClickType.PICKUP, this.mc.player);
                        }
                        if (!this.mc.player.onGround) {
                            this.mc.playerController.windowClick(0, InventoryHelper.getElytraAtHotbar(), 1, ClickType.PICKUP, this.mc.player);
                            this.mc.playerController.windowClick(0, 6, 1, ClickType.PICKUP, this.mc.player);
                            lllllllllllIIlIIllIlllIlIllIIlll = true;
                        }
                        if (this.mc.player.onGround) {
                            this.mc.player.jump();
                        }
                        if (!this.mc.player.onGround && this.mc.player.fallDistance > 0.0f) {
                            this.mc.getConnection().sendPacket(new CPacketEntityAction(this.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
                            this.mc.player.setPositionAndUpdate(this.mc.player.posX, this.mc.player.posY + Double.parseDouble(lllllllllllIIlIIllIlllIlIllIllII[2]), this.mc.player.posZ);
                        }
                    }
                    if (lllllllllllIIlIIllIlllIlIllIllII[1].equals("-")) {
                        lllllllllllIIlIIllIlllIlIllIlIII = true;
                        if (lllllllllllIIlIIllIlllIlIllIIlll) {
                            this.mc.playerController.windowClick(0, InventoryHelper.getElytraAtHotbar(), 1, ClickType.PICKUP, this.mc.player);
                        }
                        if (!this.mc.player.onGround) {
                            this.mc.playerController.windowClick(0, InventoryHelper.getElytraAtHotbar(), 1, ClickType.PICKUP, this.mc.player);
                            this.mc.playerController.windowClick(0, 6, 1, ClickType.PICKUP, this.mc.player);
                            lllllllllllIIlIIllIlllIlIllIIlll = true;
                        }
                        if (this.mc.player.onGround) {
                            this.mc.player.jump();
                        }
                        if (!this.mc.player.onGround && this.mc.player.fallDistance > 0.0f) {
                            this.mc.getConnection().sendPacket(new CPacketEntityAction(this.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
                            this.mc.player.setPositionAndUpdate(this.mc.player.posX, this.mc.player.posY - Double.parseDouble(lllllllllllIIlIIllIlllIlIllIllII[2]), this.mc.player.posZ);
                        }
                    }
                }
                catch (Exception lllllllllllIIlIIllIlllIlIlIlllll) {}
            }
        }
        else {
            lllllllllllIIlIIllIlllIlIllIlIll = false;
            lllllllllllIIlIIllIlllIlIllIlIlI = false;
            lllllllllllIIlIIllIlllIlIllIlIIl = false;
            lllllllllllIIlIIllIlllIlIllIlIII = false;
            Main.msg(this.getUsage(), true);
        }
    }
}
