// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLiquid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.util.glu.GLU;
import net.minecraft.entity.player.EntityPlayer;
import java.nio.IntBuffer;
import java.nio.FloatBuffer;
import net.minecraft.util.math.Vec3d;

public class ActiveRenderInfo
{
    private static /* synthetic */ Vec3d position;
    private static /* synthetic */ float rotationXY;
    private static final /* synthetic */ FloatBuffer OBJECTCOORDS;
    private static final /* synthetic */ FloatBuffer MODELVIEW;
    private static /* synthetic */ float rotationZ;
    private static /* synthetic */ float rotationYZ;
    private static final /* synthetic */ IntBuffer VIEWPORT;
    private static /* synthetic */ float rotationXZ;
    private static /* synthetic */ float rotationX;
    private static final /* synthetic */ FloatBuffer PROJECTION;
    
    public static void updateRenderInfo(final EntityPlayer llllllllllIllllIllIlIIlIlIlIlIlI, final boolean llllllllllIllllIllIlIIlIlIlIlIIl) {
        GlStateManager.getFloat(2982, ActiveRenderInfo.MODELVIEW);
        GlStateManager.getFloat(2983, ActiveRenderInfo.PROJECTION);
        GlStateManager.glGetInteger(2978, ActiveRenderInfo.VIEWPORT);
        final float llllllllllIllllIllIlIIlIlIlIlIII = (float)((ActiveRenderInfo.VIEWPORT.get(0) + ActiveRenderInfo.VIEWPORT.get(2)) / 2);
        final float llllllllllIllllIllIlIIlIlIlIIlll = (float)((ActiveRenderInfo.VIEWPORT.get(1) + ActiveRenderInfo.VIEWPORT.get(3)) / 2);
        GLU.gluUnProject(llllllllllIllllIllIlIIlIlIlIlIII, llllllllllIllllIllIlIIlIlIlIIlll, 0.0f, ActiveRenderInfo.MODELVIEW, ActiveRenderInfo.PROJECTION, ActiveRenderInfo.VIEWPORT, ActiveRenderInfo.OBJECTCOORDS);
        ActiveRenderInfo.position = new Vec3d(ActiveRenderInfo.OBJECTCOORDS.get(0), ActiveRenderInfo.OBJECTCOORDS.get(1), ActiveRenderInfo.OBJECTCOORDS.get(2));
        final int llllllllllIllllIllIlIIlIlIlIIllI = llllllllllIllllIllIlIIlIlIlIlIIl ? 1 : 0;
        final float llllllllllIllllIllIlIIlIlIlIIlIl = llllllllllIllllIllIlIIlIlIlIlIlI.rotationPitch;
        final float llllllllllIllllIllIlIIlIlIlIIlII = llllllllllIllllIllIlIIlIlIlIlIlI.rotationYaw;
        ActiveRenderInfo.rotationX = MathHelper.cos(llllllllllIllllIllIlIIlIlIlIIlII * 0.017453292f) * (1 - llllllllllIllllIllIlIIlIlIlIIllI * 2);
        ActiveRenderInfo.rotationZ = MathHelper.sin(llllllllllIllllIllIlIIlIlIlIIlII * 0.017453292f) * (1 - llllllllllIllllIllIlIIlIlIlIIllI * 2);
        ActiveRenderInfo.rotationYZ = -ActiveRenderInfo.rotationZ * MathHelper.sin(llllllllllIllllIllIlIIlIlIlIIlIl * 0.017453292f) * (1 - llllllllllIllllIllIlIIlIlIlIIllI * 2);
        ActiveRenderInfo.rotationXY = ActiveRenderInfo.rotationX * MathHelper.sin(llllllllllIllllIllIlIIlIlIlIIlIl * 0.017453292f) * (1 - llllllllllIllllIllIlIIlIlIlIIllI * 2);
        ActiveRenderInfo.rotationXZ = MathHelper.cos(llllllllllIllllIllIlIIlIlIlIIlIl * 0.017453292f);
    }
    
    public static IBlockState getBlockStateAtEntityViewpoint(final World llllllllllIllllIllIlIIlIIlllIlII, final Entity llllllllllIllllIllIlIIlIIllllIll, final float llllllllllIllllIllIlIIlIIllllIlI) {
        final Vec3d llllllllllIllllIllIlIIlIIllllIIl = projectViewFromEntity(llllllllllIllllIllIlIIlIIllllIll, llllllllllIllllIllIlIIlIIllllIlI);
        final BlockPos llllllllllIllllIllIlIIlIIllllIII = new BlockPos(llllllllllIllllIllIlIIlIIllllIIl);
        IBlockState llllllllllIllllIllIlIIlIIlllIlll = llllllllllIllllIllIlIIlIIlllIlII.getBlockState(llllllllllIllllIllIlIIlIIllllIII);
        if (llllllllllIllllIllIlIIlIIlllIlll.getMaterial().isLiquid()) {
            float llllllllllIllllIllIlIIlIIlllIllI = 0.0f;
            if (llllllllllIllllIllIlIIlIIlllIlll.getBlock() instanceof BlockLiquid) {
                llllllllllIllllIllIlIIlIIlllIllI = BlockLiquid.getLiquidHeightPercent(llllllllllIllllIllIlIIlIIlllIlll.getValue((IProperty<Integer>)BlockLiquid.LEVEL)) - 0.11111111f;
            }
            final float llllllllllIllllIllIlIIlIIlllIlIl = llllllllllIllllIllIlIIlIIllllIII.getY() + 1 - llllllllllIllllIllIlIIlIIlllIllI;
            if (llllllllllIllllIllIlIIlIIllllIIl.yCoord >= llllllllllIllllIllIlIIlIIlllIlIl) {
                llllllllllIllllIllIlIIlIIlllIlll = llllllllllIllllIllIlIIlIIlllIlII.getBlockState(llllllllllIllllIllIlIIlIIllllIII.up());
            }
        }
        return llllllllllIllllIllIlIIlIIlllIlll;
    }
    
    public static float getRotationXY() {
        return ActiveRenderInfo.rotationXY;
    }
    
    static {
        VIEWPORT = GLAllocation.createDirectIntBuffer(16);
        MODELVIEW = GLAllocation.createDirectFloatBuffer(16);
        PROJECTION = GLAllocation.createDirectFloatBuffer(16);
        OBJECTCOORDS = GLAllocation.createDirectFloatBuffer(3);
        ActiveRenderInfo.position = new Vec3d(0.0, 0.0, 0.0);
    }
    
    public static Vec3d projectViewFromEntity(final Entity llllllllllIllllIllIlIIlIlIIlIlII, final double llllllllllIllllIllIlIIlIlIIIlIll) {
        final double llllllllllIllllIllIlIIlIlIIlIIlI = llllllllllIllllIllIlIIlIlIIlIlII.prevPosX + (llllllllllIllllIllIlIIlIlIIlIlII.posX - llllllllllIllllIllIlIIlIlIIlIlII.prevPosX) * llllllllllIllllIllIlIIlIlIIIlIll;
        final double llllllllllIllllIllIlIIlIlIIlIIIl = llllllllllIllllIllIlIIlIlIIlIlII.prevPosY + (llllllllllIllllIllIlIIlIlIIlIlII.posY - llllllllllIllllIllIlIIlIlIIlIlII.prevPosY) * llllllllllIllllIllIlIIlIlIIIlIll;
        final double llllllllllIllllIllIlIIlIlIIlIIII = llllllllllIllllIllIlIIlIlIIlIlII.prevPosZ + (llllllllllIllllIllIlIIlIlIIlIlII.posZ - llllllllllIllllIllIlIIlIlIIlIlII.prevPosZ) * llllllllllIllllIllIlIIlIlIIIlIll;
        final double llllllllllIllllIllIlIIlIlIIIllll = llllllllllIllllIllIlIIlIlIIlIIlI + ActiveRenderInfo.position.xCoord;
        final double llllllllllIllllIllIlIIlIlIIIlllI = llllllllllIllllIllIlIIlIlIIlIIIl + ActiveRenderInfo.position.yCoord;
        final double llllllllllIllllIllIlIIlIlIIIllIl = llllllllllIllllIllIlIIlIlIIlIIII + ActiveRenderInfo.position.zCoord;
        return new Vec3d(llllllllllIllllIllIlIIlIlIIIllll, llllllllllIllllIllIlIIlIlIIIlllI, llllllllllIllllIllIlIIlIlIIIllIl);
    }
    
    public static float getRotationXZ() {
        return ActiveRenderInfo.rotationXZ;
    }
    
    public static float getRotationX() {
        return ActiveRenderInfo.rotationX;
    }
    
    public static float getRotationZ() {
        return ActiveRenderInfo.rotationZ;
    }
    
    public static float getRotationYZ() {
        return ActiveRenderInfo.rotationYZ;
    }
}
