// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.movement;

import net.minecraft.client.Minecraft;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

public class Location
{
    private /* synthetic */ double y;
    private /* synthetic */ float yaw;
    private /* synthetic */ double x;
    private /* synthetic */ double z;
    private /* synthetic */ float pitch;
    
    public Location setPitch(final float lllllllllllIlIIlIIIlIlllIlIlllIl) {
        this.pitch = lllllllllllIlIIlIIIlIlllIlIlllIl;
        return this;
    }
    
    public Location(final double lllllllllllIlIIlIIIlIlllllIlllIl, final double lllllllllllIlIIlIIIlIlllllIlllII, final double lllllllllllIlIIlIIIlIlllllIlIlIl, final float lllllllllllIlIIlIIIlIlllllIlIlII, final float lllllllllllIlIIlIIIlIlllllIllIIl) {
        this.x = lllllllllllIlIIlIIIlIlllllIlllIl;
        this.y = lllllllllllIlIIlIIIlIlllllIlllII;
        this.z = lllllllllllIlIIlIIIlIlllllIlIlIl;
        this.yaw = lllllllllllIlIIlIIIlIlllllIlIlII;
        this.pitch = lllllllllllIlIIlIIIlIlllllIllIIl;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public Location setY(final double lllllllllllIlIIlIIIlIlllIlllIllI) {
        this.y = lllllllllllIlIIlIIIlIlllIlllIllI;
        return this;
    }
    
    public double distanceToY(final Location lllllllllllIlIIlIIIlIlllIIlllllI) {
        final double lllllllllllIlIIlIIIlIlllIlIIIIII = lllllllllllIlIIlIIIlIlllIIlllllI.y - this.y;
        return Math.sqrt(lllllllllllIlIIlIIIlIlllIlIIIIII * lllllllllllIlIIlIIIlIlllIlIIIIII);
    }
    
    public Location setZ(final double lllllllllllIlIIlIIIlIlllIllIllIl) {
        this.z = lllllllllllIlIIlIIIlIlllIllIllIl;
        return this;
    }
    
    public Location setYaw(final float lllllllllllIlIIlIIIlIlllIllIIllI) {
        this.yaw = lllllllllllIlIIlIIIlIlllIllIIllI;
        return this;
    }
    
    public double distanceTo(final Location lllllllllllIlIIlIIIlIlllIlIIlllI) {
        final double lllllllllllIlIIlIIIlIlllIlIIllIl = lllllllllllIlIIlIIIlIlllIlIIlllI.x - this.x;
        final double lllllllllllIlIIlIIIlIlllIlIIllII = lllllllllllIlIIlIIIlIlllIlIIlllI.z - this.z;
        final double lllllllllllIlIIlIIIlIlllIlIIlIll = lllllllllllIlIIlIIIlIlllIlIIlllI.y - this.y;
        return Math.sqrt(lllllllllllIlIIlIIIlIlllIlIIllIl * lllllllllllIlIIlIIIlIlllIlIIllIl + lllllllllllIlIIlIIIlIlllIlIIlIll * lllllllllllIlIIlIIIlIlllIlIIlIll + lllllllllllIlIIlIIIlIlllIlIIllII * lllllllllllIlIIlIIIlIlllIlIIllII);
    }
    
    public Location subtract(final double lllllllllllIlIIlIIIlIllllIIIllIl, final double lllllllllllIlIIlIIIlIllllIIlIIII, final double lllllllllllIlIIlIIIlIllllIIIlIll) {
        this.x -= lllllllllllIlIIlIIIlIllllIIIllIl;
        this.y -= lllllllllllIlIIlIIIlIllllIIlIIII;
        this.z -= lllllllllllIlIIlIIIlIllllIIIlIll;
        return this;
    }
    
    public static Location fromBlockPos(final BlockPos lllllllllllIlIIlIIIlIlllIlIllIIl) {
        return new Location(lllllllllllIlIIlIIIlIlllIlIllIIl.getX(), lllllllllllIlIIlIIIlIlllIlIllIIl.getY(), lllllllllllIlIIlIIIlIlllIlIllIIl.getZ());
    }
    
    public Location add(final int lllllllllllIlIIlIIIlIllllIllIIIl, final int lllllllllllIlIIlIIIlIllllIllIlII, final int lllllllllllIlIIlIIIlIllllIlIllll) {
        this.x += lllllllllllIlIIlIIIlIllllIllIIIl;
        this.y += lllllllllllIlIIlIIIlIllllIllIlII;
        this.z += lllllllllllIlIIlIIIlIllllIlIllll;
        return this;
    }
    
    public BlockPos toBlockPos() {
        return new BlockPos(this.getX(), this.getY(), this.getZ());
    }
    
    public double getZ() {
        return this.z;
    }
    
    public Location add(final double lllllllllllIlIIlIIIlIllllIlIIlIl, final double lllllllllllIlIIlIIIlIllllIlIIlII, final double lllllllllllIlIIlIIIlIllllIlIIlll) {
        this.x += lllllllllllIlIIlIIIlIllllIlIIlIl;
        this.y += lllllllllllIlIIlIIIlIllllIlIIlII;
        this.z += lllllllllllIlIIlIIIlIllllIlIIlll;
        return this;
    }
    
    public double getX() {
        return this.x;
    }
    
    public Location(final double lllllllllllIlIIlIIIlIlllllIIllIl, final double lllllllllllIlIIlIIIlIlllllIIlIII, final double lllllllllllIlIIlIIIlIlllllIIlIll) {
        this.x = lllllllllllIlIIlIIIlIlllllIIllIl;
        this.y = lllllllllllIlIIlIIIlIlllllIIlIII;
        this.z = lllllllllllIlIIlIIIlIlllllIIlIll;
        this.yaw = 0.0f;
        this.pitch = 0.0f;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public Block getBlock() {
        return Minecraft.getMinecraft().world.getBlockState(this.toBlockPos()).getBlock();
    }
    
    public double getY() {
        return this.y;
    }
    
    public Location setX(final double lllllllllllIlIIlIIIlIlllIlllllll) {
        this.x = lllllllllllIlIIlIIIlIlllIlllllll;
        return this;
    }
    
    public Location(final int lllllllllllIlIIlIIIlIlllllIIIIIl, final int lllllllllllIlIIlIIIlIllllIllllII, final int lllllllllllIlIIlIIIlIllllIllllll) {
        this.x = lllllllllllIlIIlIIIlIlllllIIIIIl;
        this.y = lllllllllllIlIIlIIIlIllllIllllII;
        this.z = lllllllllllIlIIlIIIlIllllIllllll;
        this.yaw = 0.0f;
        this.pitch = 0.0f;
    }
    
    public Location subtract(final int lllllllllllIlIIlIIIlIllllIIllIIl, final int lllllllllllIlIIlIIIlIllllIIllIII, final int lllllllllllIlIIlIIIlIllllIIllIll) {
        this.x -= lllllllllllIlIIlIIIlIllllIIllIIl;
        this.y -= lllllllllllIlIIlIIIlIllllIIllIII;
        this.z -= lllllllllllIlIIlIIIlIllllIIllIll;
        return this;
    }
}
