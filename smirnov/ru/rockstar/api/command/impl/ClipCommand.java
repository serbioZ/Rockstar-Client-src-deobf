// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command.impl;

import ru.rockstar.Main;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.command.CommandAbstract;

public class ClipCommand extends CommandAbstract
{
    /* synthetic */ Minecraft mc;
    
    @Override
    public void execute(final String... lllllllllllIIIlllIlIlIIlIIlIllIl) {
        if (lllllllllllIIIlllIlIlIIlIIlIllIl.length > 1) {
            if (lllllllllllIIIlllIlIlIIlIIlIllIl[0].equalsIgnoreCase("clip")) {
                try {
                    if (lllllllllllIIIlllIlIlIIlIIlIllIl[1].equals("down")) {
                        this.mc.player.setPositionAndUpdate(this.mc.player.posX, -2.0, this.mc.player.posZ);
                    }
                    if (lllllllllllIIIlllIlIlIIlIIlIllIl[1].equals("+")) {
                        this.mc.player.setPositionAndUpdate(this.mc.player.posX, this.mc.player.posY + Double.parseDouble(lllllllllllIIIlllIlIlIIlIIlIllIl[2]), this.mc.player.posZ);
                    }
                    if (lllllllllllIIIlllIlIlIIlIIlIllIl[1].equals("-")) {
                        this.mc.player.setPositionAndUpdate(this.mc.player.posX, this.mc.player.posY - Double.parseDouble(lllllllllllIIIlllIlIlIIlIIlIllIl[2]), this.mc.player.posZ);
                    }
                }
                catch (Exception ex) {}
            }
            if (lllllllllllIIIlllIlIlIIlIIlIllIl[0].equalsIgnoreCase("hclip")) {
                final double lllllllllllIIIlllIlIlIIlIIllIIlI = this.mc.player.posX;
                final double lllllllllllIIIlllIlIlIIlIIllIIIl = this.mc.player.posY;
                final double lllllllllllIIIlllIlIlIIlIIllIIII = this.mc.player.posZ;
                final double lllllllllllIIIlllIlIlIIlIIlIllll = this.mc.player.rotationYaw * 0.017453292;
                try {
                    if (lllllllllllIIIlllIlIlIIlIIlIllIl[1].equals("+")) {
                        this.mc.player.setPositionAndUpdate(lllllllllllIIIlllIlIlIIlIIllIIlI - Math.sin(lllllllllllIIIlllIlIlIIlIIlIllll) * Double.parseDouble(lllllllllllIIIlllIlIlIIlIIlIllIl[2]), lllllllllllIIIlllIlIlIIlIIllIIIl, lllllllllllIIIlllIlIlIIlIIllIIII + Math.cos(lllllllllllIIIlllIlIlIIlIIlIllll) * Double.parseDouble(lllllllllllIIIlllIlIlIIlIIlIllIl[2]));
                    }
                    if (lllllllllllIIIlllIlIlIIlIIlIllIl[1].equals("-")) {
                        this.mc.player.setPositionAndUpdate(lllllllllllIIIlllIlIlIIlIIllIIlI + Math.sin(lllllllllllIIIlllIlIlIIlIIlIllll) * Double.parseDouble(lllllllllllIIIlllIlIlIIlIIlIllIl[2]), lllllllllllIIIlllIlIlIIlIIllIIIl, lllllllllllIIIlllIlIlIIlIIllIIII - Math.cos(lllllllllllIIIlllIlIlIIlIIlIllll) * Double.parseDouble(lllllllllllIIIlllIlIlIIlIIlIllIl[2]));
                    }
                }
                catch (Exception lllllllllllIIIlllIlIlIIlIIlIlIII) {}
            }
        }
        else {
            Main.msg(this.getUsage(), true);
        }
    }
    
    public ClipCommand() {
        super("clip", "clip | hclip", "§6.clip | (hclip) + | - §3<value> | down", new String[] { "clip", "hclip" });
        this.mc = Minecraft.getMinecraft();
    }
}
