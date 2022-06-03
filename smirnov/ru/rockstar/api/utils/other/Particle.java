// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.other;

import java.util.Random;
import net.minecraft.client.gui.ScaledResolution;

public class Particle
{
    public /* synthetic */ float radius;
    public /* synthetic */ float ticks;
    public /* synthetic */ float y;
    public /* synthetic */ float x;
    public /* synthetic */ float speed;
    
    public Particle(final ScaledResolution lllllllllllllIllIIIIIIIIlllllllI, final float lllllllllllllIllIIIIIIIIllllllIl, final float lllllllllllllIllIIIIIIIIllllllII) {
        this.x = new Random().nextFloat() * lllllllllllllIllIIIIIIIIlllllllI.getScaledWidth();
        this.y = new Random().nextFloat() * lllllllllllllIllIIIIIIIIlllllllI.getScaledHeight();
        this.ticks = new Random().nextFloat() * lllllllllllllIllIIIIIIIIlllllllI.getScaledHeight() / 2.0f;
        this.radius = lllllllllllllIllIIIIIIIIllllllIl;
        this.speed = lllllllllllllIllIIIIIIIIllllllII;
    }
}
