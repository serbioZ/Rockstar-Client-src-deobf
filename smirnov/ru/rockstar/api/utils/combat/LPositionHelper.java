// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.combat;

import net.minecraft.client.Minecraft;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

public class LPositionHelper
{
    private /* synthetic */ double x;
    private /* synthetic */ double z;
    private /* synthetic */ double y;
    private /* synthetic */ boolean ground;
    
    public LPositionHelper setOnGround(final boolean lllllllllllIlIIIIIllIIIllIlIllll) {
        this.ground = lllllllllllIlIIIIIllIIIllIlIllll;
        return this;
    }
    
    public LPositionHelper setY(final double lllllllllllIlIIIIIllIIIllIIllIll) {
        this.y = lllllllllllIlIIIIIllIIIllIIllIll;
        return this;
    }
    
    public LPositionHelper subtract(final double lllllllllllIlIIIIIllIIIllIlllIll, final double lllllllllllIlIIIIIllIIIllIlllllI, final double lllllllllllIlIIIIIllIIIllIlllIIl) {
        this.x -= lllllllllllIlIIIIIllIIIllIlllIll;
        this.y -= lllllllllllIlIIIIIllIIIllIlllllI;
        this.z -= lllllllllllIlIIIIIllIIIllIlllIIl;
        return this;
    }
    
    public BlockPos toBlockPos() {
        return new BlockPos(this.getX(), this.getY(), this.getZ());
    }
    
    public LPositionHelper add(final double lllllllllllIlIIIIIllIIIlllIlIIll, final double lllllllllllIlIIIIIllIIIlllIlIIlI, final double lllllllllllIlIIIIIllIIIlllIlIlIl) {
        this.x += lllllllllllIlIIIIIllIIIlllIlIIll;
        this.y += lllllllllllIlIIIIIllIIIlllIlIIlI;
        this.z += lllllllllllIlIIIIIllIIIlllIlIlIl;
        return this;
    }
    
    public LPositionHelper(final int lllllllllllIlIIIIIllIIIlllllIIlI, final int lllllllllllIlIIIIIllIIIllllIllIl, final int lllllllllllIlIIIIIllIIIlllllIIII) {
        this.x = lllllllllllIlIIIIIllIIIlllllIIlI;
        this.y = lllllllllllIlIIIIIllIIIllllIllIl;
        this.z = lllllllllllIlIIIIIllIIIlllllIIII;
        this.ground = true;
    }
    
    public double getY() {
        return this.y;
    }
    
    public boolean isOnGround() {
        return this.ground;
    }
    
    public LPositionHelper(final double lllllllllllIlIIIIIllIIlIIIIIIlll, final double lllllllllllIlIIIIIllIIlIIIIIIllI, final double lllllllllllIlIIIIIllIIlIIIIIIlIl, final boolean lllllllllllIlIIIIIllIIlIIIIIlIIl) {
        this.x = lllllllllllIlIIIIIllIIlIIIIIIlll;
        this.y = lllllllllllIlIIIIIllIIlIIIIIIllI;
        this.z = lllllllllllIlIIIIIllIIlIIIIIIlIl;
        this.ground = lllllllllllIlIIIIIllIIlIIIIIlIIl;
    }
    
    public LPositionHelper setZ(final double lllllllllllIlIIIIIllIIIllIIlIlII) {
        this.z = lllllllllllIlIIIIIllIIIllIIlIlII;
        return this;
    }
    
    public LPositionHelper(final double lllllllllllIlIIIIIllIIIllllllllI, final double lllllllllllIlIIIIIllIIIlllllllIl, final double lllllllllllIlIIIIIllIIIllllllIII) {
        this.x = lllllllllllIlIIIIIllIIIllllllllI;
        this.y = lllllllllllIlIIIIIllIIIlllllllIl;
        this.z = lllllllllllIlIIIIIllIIIllllllIII;
        this.ground = true;
    }
    
    public double getX() {
        return this.x;
    }
    
    public LPositionHelper add(final int lllllllllllIlIIIIIllIIIllllIIIll, final int lllllllllllIlIIIIIllIIIllllIIIlI, final int lllllllllllIlIIIIIllIIIllllIIIIl) {
        this.x += lllllllllllIlIIIIIllIIIllllIIIll;
        this.y += lllllllllllIlIIIIIllIIIllllIIIlI;
        this.z += lllllllllllIlIIIIIllIIIllllIIIIl;
        return this;
    }
    
    public LPositionHelper subtract(final int lllllllllllIlIIIIIllIIIlllIIIlll, final int lllllllllllIlIIIIIllIIIlllIIlIlI, final int lllllllllllIlIIIIIllIIIlllIIIlIl) {
        this.x -= lllllllllllIlIIIIIllIIIlllIIIlll;
        this.y -= lllllllllllIlIIIIIllIIIlllIIlIlI;
        this.z -= lllllllllllIlIIIIIllIIIlllIIIlIl;
        return this;
    }
    
    public static LPositionHelper fromBlockPos(final BlockPos lllllllllllIlIIIIIllIIIllllIlIIl) {
        return new LPositionHelper(lllllllllllIlIIIIIllIIIllllIlIIl.getX(), lllllllllllIlIIIIIllIIIllllIlIIl.getY(), lllllllllllIlIIIIIllIIIllllIlIIl.getZ());
    }
    
    public LPositionHelper setX(final double lllllllllllIlIIIIIllIIIllIlIIllI) {
        this.x = lllllllllllIlIIIIIllIIIllIlIIllI;
        return this;
    }
    
    public Block getBlock() {
        return Minecraft.getMinecraft().world.getBlockState(this.toBlockPos()).getBlock();
    }
    
    public double getZ() {
        return this.z;
    }
}
