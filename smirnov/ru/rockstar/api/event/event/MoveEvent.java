// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.potion.Potion;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.event.Event;

public class MoveEvent extends Event
{
    private /* synthetic */ double y;
    private /* synthetic */ double x;
    private /* synthetic */ double z;
    
    public MoveEvent(final double lllllllllllIlIlIIlIllIIIIIIIllII, final double lllllllllllIlIlIIlIllIIIIIIIIlll, final double lllllllllllIlIlIIlIllIIIIIIIIllI) {
        this.x = lllllllllllIlIlIIlIllIIIIIIIllII;
        this.y = lllllllllllIlIlIIlIllIIIIIIIIlll;
        this.z = lllllllllllIlIlIIlIllIIIIIIIIllI;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getMotionY(double lllllllllllIlIlIIlIlIlllllIlIlIl) {
        Minecraft.getMinecraft();
        if (Minecraft.getMinecraft().player.isPotionActive(Potion.getPotionById(8))) {
            Minecraft.getMinecraft();
            lllllllllllIlIlIIlIlIlllllIlIlIl += (Minecraft.getMinecraft().player.getActivePotionEffect(Potion.getPotionById(8)).getAmplifier() + 1) * 0.1;
        }
        return (double)lllllllllllIlIlIIlIlIlllllIlIlIl;
    }
    
    public double getLegitMotion() {
        return 0.41999998688697815;
    }
    
    public double getMovementSpeed(final double lllllllllllIlIlIIlIlIllllllIIlIl) {
        double lllllllllllIlIlIIlIlIllllllIIlII = lllllllllllIlIlIIlIlIllllllIIlIl;
        Minecraft.getMinecraft();
        if (Minecraft.getMinecraft().player.isPotionActive(Potion.getPotionById(1))) {
            Minecraft.getMinecraft();
            final int lllllllllllIlIlIIlIlIllllllIIIll = Minecraft.getMinecraft().player.getActivePotionEffect(Potion.getPotionById(1)).getAmplifier();
            return lllllllllllIlIlIIlIlIllllllIIlII *= 1.0 + 0.2 * (lllllllllllIlIlIIlIlIllllllIIIll + 1);
        }
        return lllllllllllIlIlIIlIlIllllllIIlII;
    }
    
    public double getMovementSpeed() {
        double lllllllllllIlIlIIlIlIllllllIllIl = 0.2873;
        Minecraft.getMinecraft();
        if (Minecraft.getMinecraft().player.isPotionActive(Potion.getPotionById(1))) {
            Minecraft.getMinecraft();
            final int lllllllllllIlIlIIlIlIllllllIllII = Minecraft.getMinecraft().player.getActivePotionEffect(Potion.getPotionById(1)).getAmplifier();
            lllllllllllIlIlIIlIlIllllllIllIl *= 1.0 + 0.2 * (lllllllllllIlIlIIlIlIllllllIllII + 1);
        }
        return lllllllllllIlIlIIlIlIllllllIllIl;
    }
    
    public void setX(final double lllllllllllIlIlIIlIlIlllllllIlll) {
        this.x = lllllllllllIlIlIIlIlIlllllllIlll;
    }
    
    public double getX() {
        return this.x;
    }
    
    public void setY(final double lllllllllllIlIlIIlIlIlllllllIIll) {
        this.y = lllllllllllIlIlIIlIlIlllllllIIll;
    }
    
    public void setZ(final double lllllllllllIlIlIIlIlIlllllIllIlI) {
        this.z = lllllllllllIlIlIIlIlIlllllIllIlI;
    }
}
