// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command.impl;

import ru.rockstar.Main;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.command.CommandAbstract;

public class NewClipCommand extends CommandAbstract
{
    /* synthetic */ Minecraft mc;
    
    public NewClipCommand() {
        super("newclip", "newclip | newhclip", "§6.newclip | (newhclip) + | - §3<value> | down", new String[] { "newclip", "newhclip" });
        this.mc = Minecraft.getMinecraft();
    }
    
    @Override
    public void execute(final String... llllllllllllIlIIlllllIlllllIIlll) {
        if (llllllllllllIlIIlllllIlllllIIlll.length > 1) {
            if (llllllllllllIlIIlllllIlllllIIlll[0].equalsIgnoreCase("newclip")) {
                try {
                    if (llllllllllllIlIIlllllIlllllIIlll[1].equals("down")) {
                        this.mc.player.onGround = true;
                        this.mc.player.setPositionAndUpdate(this.mc.player.posX, -2.0, this.mc.player.posZ);
                    }
                    if (llllllllllllIlIIlllllIlllllIIlll[1].equals("+")) {
                        this.mc.player.onGround = true;
                        this.mc.player.setPositionAndUpdate(this.mc.player.posX, this.mc.player.posY + Double.parseDouble(llllllllllllIlIIlllllIlllllIIlll[2]), this.mc.player.posZ);
                    }
                    if (llllllllllllIlIIlllllIlllllIIlll[1].equals("-")) {
                        this.mc.player.onGround = true;
                        this.mc.player.setPositionAndUpdate(this.mc.player.posX, this.mc.player.posY - Double.parseDouble(llllllllllllIlIIlllllIlllllIIlll[2]), this.mc.player.posZ);
                    }
                }
                catch (Exception ex) {}
            }
            if (llllllllllllIlIIlllllIlllllIIlll[0].equalsIgnoreCase("newhclip")) {
                final double llllllllllllIlIIlllllIlllllIllII = this.mc.player.posX;
                final double llllllllllllIlIIlllllIlllllIlIll = this.mc.player.posY;
                final double llllllllllllIlIIlllllIlllllIlIlI = this.mc.player.posZ;
                final double llllllllllllIlIIlllllIlllllIlIIl = this.mc.player.rotationYaw * 0.017453292;
                try {
                    if (llllllllllllIlIIlllllIlllllIIlll[1].equals("+")) {
                        this.mc.player.onGround = true;
                        this.mc.player.setPositionAndUpdate(llllllllllllIlIIlllllIlllllIllII - Math.sin(llllllllllllIlIIlllllIlllllIlIIl) * Double.parseDouble(llllllllllllIlIIlllllIlllllIIlll[2]), llllllllllllIlIIlllllIlllllIlIll, llllllllllllIlIIlllllIlllllIlIlI + Math.cos(llllllllllllIlIIlllllIlllllIlIIl) * Double.parseDouble(llllllllllllIlIIlllllIlllllIIlll[2]));
                    }
                    if (llllllllllllIlIIlllllIlllllIIlll[1].equals("-")) {
                        this.mc.player.onGround = true;
                        this.mc.player.setPositionAndUpdate(llllllllllllIlIIlllllIlllllIllII + Math.sin(llllllllllllIlIIlllllIlllllIlIIl) * Double.parseDouble(llllllllllllIlIIlllllIlllllIIlll[2]), llllllllllllIlIIlllllIlllllIlIll, llllllllllllIlIIlllllIlllllIlIlI - Math.cos(llllllllllllIlIIlllllIlllllIlIIl) * Double.parseDouble(llllllllllllIlIIlllllIlllllIIlll[2]));
                    }
                }
                catch (Exception llllllllllllIlIIlllllIlllllIIIlI) {}
            }
        }
        else {
            Main.msg(this.getUsage(), true);
        }
    }
}
