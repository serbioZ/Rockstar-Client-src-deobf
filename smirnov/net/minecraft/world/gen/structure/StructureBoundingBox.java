// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.nbt.NBTTagIntArray;
import com.google.common.base.MoreObjects;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.EnumFacing;

public class StructureBoundingBox
{
    public /* synthetic */ int minX;
    public /* synthetic */ int maxZ;
    public /* synthetic */ int maxX;
    public /* synthetic */ int minY;
    public /* synthetic */ int maxY;
    public /* synthetic */ int minZ;
    
    public int getXSize() {
        return this.maxX - this.minX + 1;
    }
    
    public boolean intersectsWith(final int lllllllllllIIlllIlllIIIlIllIlllI, final int lllllllllllIIlllIlllIIIlIllIllIl, final int lllllllllllIIlllIlllIIIlIllIllII, final int lllllllllllIIlllIlllIIIlIllIlIll) {
        return this.maxX >= lllllllllllIIlllIlllIIIlIllIlllI && this.minX <= lllllllllllIIlllIlllIIIlIllIllII && this.maxZ >= lllllllllllIIlllIlllIIIlIllIllIl && this.minZ <= lllllllllllIIlllIlllIIIlIllIlIll;
    }
    
    public StructureBoundingBox(final int lllllllllllIIlllIlllIIIlIllllllI, final int lllllllllllIIlllIlllIIIllIIIIIlI, final int lllllllllllIIlllIlllIIIlIlllllII, final int lllllllllllIIlllIlllIIIllIIIIIII) {
        this.minX = lllllllllllIIlllIlllIIIlIllllllI;
        this.minZ = lllllllllllIIlllIlllIIIllIIIIIlI;
        this.maxX = lllllllllllIIlllIlllIIIlIlllllII;
        this.maxZ = lllllllllllIIlllIlllIIIllIIIIIII;
        this.minY = 1;
        this.maxY = 512;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = StructureBoundingBox.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final long lllllllllllIIlllIlllIIIlIIlllIlI = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIIlllIlllIIIlIIlllIlI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIlllIlllIIIlIIlllIlI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIlllIlllIIIlIIlllIlI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIlllIlllIIIlIIlllIlI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIlllIlllIIIlIIlllIlI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIIlllIlllIIIlIIlllIlI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return StructureBoundingBox.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIIlllIlllIIIlIIlllIlI;
    }
    
    public static StructureBoundingBox createProper(final int lllllllllllIIlllIlllIIIllIllIIll, final int lllllllllllIIlllIlllIIIllIlllIII, final int lllllllllllIIlllIlllIIIllIllIIIl, final int lllllllllllIIlllIlllIIIllIllIllI, final int lllllllllllIIlllIlllIIIllIlIllll, final int lllllllllllIIlllIlllIIIllIlIlllI) {
        return new StructureBoundingBox(Math.min(lllllllllllIIlllIlllIIIllIllIIll, lllllllllllIIlllIlllIIIllIllIllI), Math.min(lllllllllllIIlllIlllIIIllIlllIII, lllllllllllIIlllIlllIIIllIlIllll), Math.min(lllllllllllIIlllIlllIIIllIllIIIl, lllllllllllIIlllIlllIIIllIlIlllI), Math.max(lllllllllllIIlllIlllIIIllIllIIll, lllllllllllIIlllIlllIIIllIllIllI), Math.max(lllllllllllIIlllIlllIIIllIlllIII, lllllllllllIIlllIlllIIIllIlIllll), Math.max(lllllllllllIIlllIlllIIIllIllIIIl, lllllllllllIIlllIlllIIIllIlIlllI));
    }
    
    public Vec3i getLength() {
        return new Vec3i(this.maxX - this.minX, this.maxY - this.minY, this.maxZ - this.minZ);
    }
    
    public StructureBoundingBox(final int lllllllllllIIlllIlllIIIllIIlllll, final int lllllllllllIIlllIlllIIIllIIlIlll, final int lllllllllllIIlllIlllIIIllIIlllIl, final int lllllllllllIIlllIlllIIIllIIlIlIl, final int lllllllllllIIlllIlllIIIllIIllIll, final int lllllllllllIIlllIlllIIIllIIllIlI) {
        this.minX = lllllllllllIIlllIlllIIIllIIlllll;
        this.minY = lllllllllllIIlllIlllIIIllIIlIlll;
        this.minZ = lllllllllllIIlllIlllIIIllIIlllIl;
        this.maxX = lllllllllllIIlllIlllIIIllIIlIlIl;
        this.maxY = lllllllllllIIlllIlllIIIllIIllIll;
        this.maxZ = lllllllllllIIlllIlllIIIllIIllIlI;
    }
    
    public StructureBoundingBox(final StructureBoundingBox lllllllllllIIlllIlllIIIllIlIlIII) {
        this.minX = lllllllllllIIlllIlllIIIllIlIlIII.minX;
        this.minY = lllllllllllIIlllIlllIIIllIlIlIII.minY;
        this.minZ = lllllllllllIIlllIlllIIIllIlIlIII.minZ;
        this.maxX = lllllllllllIIlllIlllIIIllIlIlIII.maxX;
        this.maxY = lllllllllllIIlllIlllIIIllIlIlIII.maxY;
        this.maxZ = lllllllllllIIlllIlllIIIllIlIlIII.maxZ;
    }
    
    public int getZSize() {
        return this.maxZ - this.minZ + 1;
    }
    
    public StructureBoundingBox(final Vec3i lllllllllllIIlllIlllIIIllIIIlIll, final Vec3i lllllllllllIIlllIlllIIIllIIIlIlI) {
        this.minX = Math.min(lllllllllllIIlllIlllIIIllIIIlIll.getX(), lllllllllllIIlllIlllIIIllIIIlIlI.getX());
        this.minY = Math.min(lllllllllllIIlllIlllIIIllIIIlIll.getY(), lllllllllllIIlllIlllIIIllIIIlIlI.getY());
        this.minZ = Math.min(lllllllllllIIlllIlllIIIllIIIlIll.getZ(), lllllllllllIIlllIlllIIIllIIIlIlI.getZ());
        this.maxX = Math.max(lllllllllllIIlllIlllIIIllIIIlIll.getX(), lllllllllllIIlllIlllIIIllIIIlIlI.getX());
        this.maxY = Math.max(lllllllllllIIlllIlllIIIllIIIlIll.getY(), lllllllllllIIlllIlllIIIllIIIlIlI.getY());
        this.maxZ = Math.max(lllllllllllIIlllIlllIIIllIIIlIll.getZ(), lllllllllllIIlllIlllIIIllIIIlIlI.getZ());
    }
    
    public int getYSize() {
        return this.maxY - this.minY + 1;
    }
    
    public StructureBoundingBox(final int[] lllllllllllIIlllIlllIIIllllIIIII) {
        if (lllllllllllIIlllIlllIIIllllIIIII.length == 6) {
            this.minX = lllllllllllIIlllIlllIIIllllIIIII[0];
            this.minY = lllllllllllIIlllIlllIIIllllIIIII[1];
            this.minZ = lllllllllllIIlllIlllIIIllllIIIII[2];
            this.maxX = lllllllllllIIlllIlllIIIllllIIIII[3];
            this.maxY = lllllllllllIIlllIlllIIIllllIIIII[4];
            this.maxZ = lllllllllllIIlllIlllIIIllllIIIII[5];
        }
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper((Object)this).add("x0", this.minX).add("y0", this.minY).add("z0", this.minZ).add("x1", this.maxX).add("y1", this.maxY).add("z1", this.maxZ).toString();
    }
    
    public StructureBoundingBox() {
    }
    
    public void offset(final int lllllllllllIIlllIlllIIIlIlIllIlI, final int lllllllllllIIlllIlllIIIlIlIllIIl, final int lllllllllllIIlllIlllIIIlIlIlIlII) {
        this.minX += lllllllllllIIlllIlllIIIlIlIllIlI;
        this.minY += lllllllllllIIlllIlllIIIlIlIllIIl;
        this.minZ += lllllllllllIIlllIlllIIIlIlIlIlII;
        this.maxX += lllllllllllIIlllIlllIIIlIlIllIlI;
        this.maxY += lllllllllllIIlllIlllIIIlIlIllIIl;
        this.maxZ += lllllllllllIIlllIlllIIIlIlIlIlII;
    }
    
    public NBTTagIntArray toNBTTagIntArray() {
        return new NBTTagIntArray(new int[] { this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ });
    }
    
    public boolean intersectsWith(final StructureBoundingBox lllllllllllIIlllIlllIIIlIlllIlll) {
        return this.maxX >= lllllllllllIIlllIlllIIIlIlllIlll.minX && this.minX <= lllllllllllIIlllIlllIIIlIlllIlll.maxX && this.maxZ >= lllllllllllIIlllIlllIIIlIlllIlll.minZ && this.minZ <= lllllllllllIIlllIlllIIIlIlllIlll.maxZ && this.maxY >= lllllllllllIIlllIlllIIIlIlllIlll.minY && this.minY <= lllllllllllIIlllIlllIIIlIlllIlll.maxY;
    }
    
    public void expandTo(final StructureBoundingBox lllllllllllIIlllIlllIIIlIllIIIII) {
        this.minX = Math.min(this.minX, lllllllllllIIlllIlllIIIlIllIIIII.minX);
        this.minY = Math.min(this.minY, lllllllllllIIlllIlllIIIlIllIIIII.minY);
        this.minZ = Math.min(this.minZ, lllllllllllIIlllIlllIIIlIllIIIII.minZ);
        this.maxX = Math.max(this.maxX, lllllllllllIIlllIlllIIIlIllIIIII.maxX);
        this.maxY = Math.max(this.maxY, lllllllllllIIlllIlllIIIlIllIIIII.maxY);
        this.maxZ = Math.max(this.maxZ, lllllllllllIIlllIlllIIIlIllIIIII.maxZ);
    }
    
    public static StructureBoundingBox getNewBoundingBox() {
        return new StructureBoundingBox(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    
    public static StructureBoundingBox getComponentToAddBoundingBox(final int lllllllllllIIlllIlllIIIlllIlIIll, final int lllllllllllIIlllIlllIIIlllIlIIlI, final int lllllllllllIIlllIlllIIIlllIIIlll, final int lllllllllllIIlllIlllIIIlllIlIIII, final int lllllllllllIIlllIlllIIIlllIIllll, final int lllllllllllIIlllIlllIIIlllIIIlII, final int lllllllllllIIlllIlllIIIlllIIIIll, final int lllllllllllIIlllIlllIIIlllIIllII, final int lllllllllllIIlllIlllIIIlllIIlIll, final EnumFacing lllllllllllIIlllIlllIIIlllIIlIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIIlllIlllIIIlllIIlIlI.ordinal()]) {
            case 3: {
                return new StructureBoundingBox(lllllllllllIIlllIlllIIIlllIlIIll + lllllllllllIIlllIlllIIIlllIlIIII, lllllllllllIIlllIlllIIIlllIlIIlI + lllllllllllIIlllIlllIIIlllIIllll, lllllllllllIIlllIlllIIIlllIIIlll - lllllllllllIIlllIlllIIIlllIIlIll + 1 + lllllllllllIIlllIlllIIIlllIIIlII, lllllllllllIIlllIlllIIIlllIlIIll + lllllllllllIIlllIlllIIIlllIIIIll - 1 + lllllllllllIIlllIlllIIIlllIlIIII, lllllllllllIIlllIlllIIIlllIlIIlI + lllllllllllIIlllIlllIIIlllIIllII - 1 + lllllllllllIIlllIlllIIIlllIIllll, lllllllllllIIlllIlllIIIlllIIIlll + lllllllllllIIlllIlllIIIlllIIIlII);
            }
            case 4: {
                return new StructureBoundingBox(lllllllllllIIlllIlllIIIlllIlIIll + lllllllllllIIlllIlllIIIlllIlIIII, lllllllllllIIlllIlllIIIlllIlIIlI + lllllllllllIIlllIlllIIIlllIIllll, lllllllllllIIlllIlllIIIlllIIIlll + lllllllllllIIlllIlllIIIlllIIIlII, lllllllllllIIlllIlllIIIlllIlIIll + lllllllllllIIlllIlllIIIlllIIIIll - 1 + lllllllllllIIlllIlllIIIlllIlIIII, lllllllllllIIlllIlllIIIlllIlIIlI + lllllllllllIIlllIlllIIIlllIIllII - 1 + lllllllllllIIlllIlllIIIlllIIllll, lllllllllllIIlllIlllIIIlllIIIlll + lllllllllllIIlllIlllIIIlllIIlIll - 1 + lllllllllllIIlllIlllIIIlllIIIlII);
            }
            case 5: {
                return new StructureBoundingBox(lllllllllllIIlllIlllIIIlllIlIIll - lllllllllllIIlllIlllIIIlllIIlIll + 1 + lllllllllllIIlllIlllIIIlllIIIlII, lllllllllllIIlllIlllIIIlllIlIIlI + lllllllllllIIlllIlllIIIlllIIllll, lllllllllllIIlllIlllIIIlllIIIlll + lllllllllllIIlllIlllIIIlllIlIIII, lllllllllllIIlllIlllIIIlllIlIIll + lllllllllllIIlllIlllIIIlllIIIlII, lllllllllllIIlllIlllIIIlllIlIIlI + lllllllllllIIlllIlllIIIlllIIllII - 1 + lllllllllllIIlllIlllIIIlllIIllll, lllllllllllIIlllIlllIIIlllIIIlll + lllllllllllIIlllIlllIIIlllIIIIll - 1 + lllllllllllIIlllIlllIIIlllIlIIII);
            }
            case 6: {
                return new StructureBoundingBox(lllllllllllIIlllIlllIIIlllIlIIll + lllllllllllIIlllIlllIIIlllIIIlII, lllllllllllIIlllIlllIIIlllIlIIlI + lllllllllllIIlllIlllIIIlllIIllll, lllllllllllIIlllIlllIIIlllIIIlll + lllllllllllIIlllIlllIIIlllIlIIII, lllllllllllIIlllIlllIIIlllIlIIll + lllllllllllIIlllIlllIIIlllIIlIll - 1 + lllllllllllIIlllIlllIIIlllIIIlII, lllllllllllIIlllIlllIIIlllIlIIlI + lllllllllllIIlllIlllIIIlllIIllII - 1 + lllllllllllIIlllIlllIIIlllIIllll, lllllllllllIIlllIlllIIIlllIIIlll + lllllllllllIIlllIlllIIIlllIIIIll - 1 + lllllllllllIIlllIlllIIIlllIlIIII);
            }
            default: {
                return new StructureBoundingBox(lllllllllllIIlllIlllIIIlllIlIIll + lllllllllllIIlllIlllIIIlllIlIIII, lllllllllllIIlllIlllIIIlllIlIIlI + lllllllllllIIlllIlllIIIlllIIllll, lllllllllllIIlllIlllIIIlllIIIlll + lllllllllllIIlllIlllIIIlllIIIlII, lllllllllllIIlllIlllIIIlllIlIIll + lllllllllllIIlllIlllIIIlllIIIIll - 1 + lllllllllllIIlllIlllIIIlllIlIIII, lllllllllllIIlllIlllIIIlllIlIIlI + lllllllllllIIlllIlllIIIlllIIllII - 1 + lllllllllllIIlllIlllIIIlllIIllll, lllllllllllIIlllIlllIIIlllIIIlll + lllllllllllIIlllIlllIIIlllIIlIll - 1 + lllllllllllIIlllIlllIIIlllIIIlII);
            }
        }
    }
    
    public boolean isVecInside(final Vec3i lllllllllllIIlllIlllIIIlIlIlIIII) {
        return lllllllllllIIlllIlllIIIlIlIlIIII.getX() >= this.minX && lllllllllllIIlllIlllIIIlIlIlIIII.getX() <= this.maxX && lllllllllllIIlllIlllIIIlIlIlIIII.getZ() >= this.minZ && lllllllllllIIlllIlllIIIlIlIlIIII.getZ() <= this.maxZ && lllllllllllIIlllIlllIIIlIlIlIIII.getY() >= this.minY && lllllllllllIIlllIlllIIIlIlIlIIII.getY() <= this.maxY;
    }
}
