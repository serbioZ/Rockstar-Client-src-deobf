// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.common.model.IModelPart;
import java.util.Optional;
import com.google.common.collect.Maps;
import optifine.Reflector;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.util.vector.Vector3f;
import net.minecraft.util.EnumFacing;
import java.util.Map;
import org.lwjgl.util.vector.Matrix4f;
import net.minecraftforge.common.model.ITransformation;
import net.minecraftforge.common.model.IModelState;

public enum ModelRotation implements IModelState, ITransformation
{
    private final /* synthetic */ Matrix4f matrix4d;
    private final /* synthetic */ int quartersY;
    
    X270_Y270("X270_Y270", 15, 270, 270), 
    X180_Y270("X180_Y270", 11, 180, 270), 
    X90_Y270("X90_Y270", 7, 90, 270);
    
    private final /* synthetic */ int quartersX;
    
    X90_Y0("X90_Y0", 4, 90, 0), 
    X90_Y180("X90_Y180", 6, 90, 180), 
    X0_Y180("X0_Y180", 2, 0, 180), 
    X180_Y180("X180_Y180", 10, 180, 180), 
    X180_Y0("X180_Y0", 8, 180, 0), 
    X270_Y180("X270_Y180", 14, 270, 180), 
    X90_Y90("X90_Y90", 5, 90, 90), 
    X180_Y90("X180_Y90", 9, 180, 90), 
    X0_Y0("X0_Y0", 0, 0, 0), 
    X270_Y90("X270_Y90", 13, 270, 90), 
    X0_Y90("X0_Y90", 1, 0, 90);
    
    private final /* synthetic */ int combinedXY;
    
    X0_Y270("X0_Y270", 3, 0, 270);
    
    private static final /* synthetic */ Map<Integer, ModelRotation> MAP_ROTATIONS;
    
    X270_Y0("X270_Y0", 12, 270, 0);
    
    private static int combineXY(final int llllllllllllIlIIIIlIlIllIIlIIIll, final int llllllllllllIlIIIIlIlIllIIlIIIlI) {
        return llllllllllllIlIIIIlIlIllIIlIIIll * 360 + llllllllllllIlIIIIlIlIllIIlIIIlI;
    }
    
    @Override
    public EnumFacing rotate(final EnumFacing llllllllllllIlIIIIlIlIlIllIllIlI) {
        return this.rotateFace(llllllllllllIlIIIIlIlIlIllIllIlI);
    }
    
    @Override
    public int rotate(final EnumFacing llllllllllllIlIIIIlIlIlIllIlIIll, final int llllllllllllIlIIIIlIlIlIllIIllll) {
        return this.rotateVertex(llllllllllllIlIIIIlIlIlIllIlIIll, llllllllllllIlIIIIlIlIlIllIIllll);
    }
    
    public Matrix4f getMatrix4d() {
        return this.matrix4d;
    }
    
    public EnumFacing rotateFace(final EnumFacing llllllllllllIlIIIIlIlIllIIIIIllI) {
        EnumFacing llllllllllllIlIIIIlIlIllIIIIIlIl = llllllllllllIlIIIIlIlIllIIIIIllI;
        for (int llllllllllllIlIIIIlIlIllIIIIIlII = 0; llllllllllllIlIIIIlIlIllIIIIIlII < this.quartersX; ++llllllllllllIlIIIIlIlIllIIIIIlII) {
            llllllllllllIlIIIIlIlIllIIIIIlIl = llllllllllllIlIIIIlIlIllIIIIIlIl.rotateAround(EnumFacing.Axis.X);
        }
        if (llllllllllllIlIIIIlIlIllIIIIIlIl.getAxis() != EnumFacing.Axis.Y) {
            for (int llllllllllllIlIIIIlIlIllIIIIIIll = 0; llllllllllllIlIIIIlIlIllIIIIIIll < this.quartersY; ++llllllllllllIlIIIIlIlIllIIIIIIll) {
                llllllllllllIlIIIIlIlIllIIIIIlIl = llllllllllllIlIIIIlIlIllIIIIIlIl.rotateAround(EnumFacing.Axis.Y);
            }
        }
        return llllllllllllIlIIIIlIlIllIIIIIlIl;
    }
    
    public int rotateVertex(final EnumFacing llllllllllllIlIIIIlIlIlIllllIlll, final int llllllllllllIlIIIIlIlIlIllllIllI) {
        int llllllllllllIlIIIIlIlIlIllllIlIl = llllllllllllIlIIIIlIlIlIllllIllI;
        if (llllllllllllIlIIIIlIlIlIllllIlll.getAxis() == EnumFacing.Axis.X) {
            llllllllllllIlIIIIlIlIlIllllIlIl = (llllllllllllIlIIIIlIlIlIllllIllI + this.quartersX) % 4;
        }
        EnumFacing llllllllllllIlIIIIlIlIlIllllIlII = llllllllllllIlIIIIlIlIlIllllIlll;
        for (int llllllllllllIlIIIIlIlIlIllllIIll = 0; llllllllllllIlIIIIlIlIlIllllIIll < this.quartersX; ++llllllllllllIlIIIIlIlIlIllllIIll) {
            llllllllllllIlIIIIlIlIlIllllIlII = llllllllllllIlIIIIlIlIlIllllIlII.rotateAround(EnumFacing.Axis.X);
        }
        if (llllllllllllIlIIIIlIlIlIllllIlII.getAxis() == EnumFacing.Axis.Y) {
            llllllllllllIlIIIIlIlIlIllllIlIl = (llllllllllllIlIIIIlIlIlIllllIlIl + this.quartersY) % 4;
        }
        return llllllllllllIlIIIIlIlIlIllllIlIl;
    }
    
    private ModelRotation(final String llllllllllllIlIIIIlIlIllIIIlIlII, final int llllllllllllIlIIIIlIlIllIIIlIIll, final int llllllllllllIlIIIIlIlIllIIIlIIlI, final int llllllllllllIlIIIIlIlIllIIIlIIIl) {
        this.combinedXY = combineXY(llllllllllllIlIIIIlIlIllIIIlIIlI, llllllllllllIlIIIIlIlIllIIIlIIIl);
        this.matrix4d = new Matrix4f();
        final Matrix4f llllllllllllIlIIIIlIlIllIIIlIlll = new Matrix4f();
        llllllllllllIlIIIIlIlIllIIIlIlll.setIdentity();
        Matrix4f.rotate(-llllllllllllIlIIIIlIlIllIIIlIIlI * 0.017453292f, new Vector3f(1.0f, 0.0f, 0.0f), llllllllllllIlIIIIlIlIllIIIlIlll, llllllllllllIlIIIIlIlIllIIIlIlll);
        this.quartersX = MathHelper.abs(llllllllllllIlIIIIlIlIllIIIlIIlI / 90);
        final Matrix4f llllllllllllIlIIIIlIlIllIIIlIllI = new Matrix4f();
        llllllllllllIlIIIIlIlIllIIIlIllI.setIdentity();
        Matrix4f.rotate(-llllllllllllIlIIIIlIlIllIIIlIIIl * 0.017453292f, new Vector3f(0.0f, 1.0f, 0.0f), llllllllllllIlIIIIlIlIllIIIlIllI, llllllllllllIlIIIIlIlIllIIIlIllI);
        this.quartersY = MathHelper.abs(llllllllllllIlIIIIlIlIllIIIlIIIl / 90);
        Matrix4f.mul(llllllllllllIlIIIIlIlIllIIIlIllI, llllllllllllIlIIIIlIlIllIIIlIlll, this.matrix4d);
    }
    
    @Override
    public javax.vecmath.Matrix4f getMatrix() {
        return (javax.vecmath.Matrix4f)(Reflector.ForgeHooksClient_getMatrix.exists() ? Reflector.call(Reflector.ForgeHooksClient_getMatrix, new Object[] { this }) : new javax.vecmath.Matrix4f());
    }
    
    public static ModelRotation getModelRotation(final int llllllllllllIlIIIIlIlIlIlllIlIlI, final int llllllllllllIlIIIIlIlIlIlllIIlll) {
        return ModelRotation.MAP_ROTATIONS.get(combineXY(MathHelper.normalizeAngle(llllllllllllIlIIIIlIlIlIlllIlIlI, 360), MathHelper.normalizeAngle(llllllllllllIlIIIIlIlIlIlllIIlll, 360)));
    }
    
    static {
        MAP_ROTATIONS = Maps.newHashMap();
        final char llllllllllllIlIIIIlIlIllIIlIlIII;
        final byte llllllllllllIlIIIIlIlIllIIlIlIIl = (byte)((ModelRotation[])(Object)(llllllllllllIlIIIIlIlIllIIlIlIII = (char)(Object)values())).length;
        for (short llllllllllllIlIIIIlIlIllIIlIlIlI = 0; llllllllllllIlIIIIlIlIllIIlIlIlI < llllllllllllIlIIIIlIlIllIIlIlIIl; ++llllllllllllIlIIIIlIlIllIIlIlIlI) {
            final ModelRotation llllllllllllIlIIIIlIlIllIIlIllII = llllllllllllIlIIIIlIlIllIIlIlIII[llllllllllllIlIIIIlIlIllIIlIlIlI];
            ModelRotation.MAP_ROTATIONS.put(llllllllllllIlIIIIlIlIllIIlIllII.combinedXY, llllllllllllIlIIIIlIlIllIIlIllII);
        }
    }
    
    @Override
    public Optional<TRSRTransformation> apply(final Optional<? extends IModelPart> llllllllllllIlIIIIlIlIlIlllIIIll) {
        return (Optional<TRSRTransformation>)Reflector.call(Reflector.ForgeHooksClient_applyTransform, new Object[] { this.getMatrix(), llllllllllllIlIIIIlIlIlIlllIIIll });
    }
}
