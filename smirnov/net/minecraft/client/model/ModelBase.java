// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.EntityLivingBase;
import java.util.Random;
import net.minecraft.entity.Entity;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import java.util.Map;
import java.util.List;

public abstract class ModelBase
{
    public /* synthetic */ int textureHeight;
    public /* synthetic */ boolean isRiding;
    public /* synthetic */ boolean isChild;
    public /* synthetic */ List<ModelRenderer> boxList;
    public /* synthetic */ float swingProgress;
    private final /* synthetic */ Map<String, TextureOffset> modelTextureMap;
    public /* synthetic */ int textureWidth;
    
    public static void copyModelAngles(final ModelRenderer llllllllllllllIlllIIIIIIIllIlIlI, final ModelRenderer llllllllllllllIlllIIIIIIIllIlIIl) {
        llllllllllllllIlllIIIIIIIllIlIIl.rotateAngleX = llllllllllllllIlllIIIIIIIllIlIlI.rotateAngleX;
        llllllllllllllIlllIIIIIIIllIlIIl.rotateAngleY = llllllllllllllIlllIIIIIIIllIlIlI.rotateAngleY;
        llllllllllllllIlllIIIIIIIllIlIIl.rotateAngleZ = llllllllllllllIlllIIIIIIIllIlIlI.rotateAngleZ;
        llllllllllllllIlllIIIIIIIllIlIIl.rotationPointX = llllllllllllllIlllIIIIIIIllIlIlI.rotationPointX;
        llllllllllllllIlllIIIIIIIllIlIIl.rotationPointY = llllllllllllllIlllIIIIIIIllIlIlI.rotationPointY;
        llllllllllllllIlllIIIIIIIllIlIIl.rotationPointZ = llllllllllllllIlllIIIIIIIllIlIlI.rotationPointZ;
    }
    
    public ModelBase() {
        this.isChild = true;
        this.boxList = (List<ModelRenderer>)Lists.newArrayList();
        this.modelTextureMap = (Map<String, TextureOffset>)Maps.newHashMap();
        this.textureWidth = 64;
        this.textureHeight = 32;
    }
    
    public void setRotationAngles(final float llllllllllllllIlllIIIIIIlIIlIIlI, final float llllllllllllllIlllIIIIIIlIIlIIIl, final float llllllllllllllIlllIIIIIIlIIlIIII, final float llllllllllllllIlllIIIIIIlIIIllll, final float llllllllllllllIlllIIIIIIlIIIlllI, final float llllllllllllllIlllIIIIIIlIIIllIl, final Entity llllllllllllllIlllIIIIIIlIIIllII) {
    }
    
    public void render(final Entity llllllllllllllIlllIIIIIIlIIllIlI, final float llllllllllllllIlllIIIIIIlIIllIIl, final float llllllllllllllIlllIIIIIIlIIllIII, final float llllllllllllllIlllIIIIIIlIIlIlll, final float llllllllllllllIlllIIIIIIlIIlIllI, final float llllllllllllllIlllIIIIIIlIIlIlIl, final float llllllllllllllIlllIIIIIIlIIlIlII) {
    }
    
    protected void setTextureOffset(final String llllllllllllllIlllIIIIIIIlllIlll, final int llllllllllllllIlllIIIIIIIlllIllI, final int llllllllllllllIlllIIIIIIIllllIIl) {
        this.modelTextureMap.put(llllllllllllllIlllIIIIIIIlllIlll, new TextureOffset(llllllllllllllIlllIIIIIIIlllIllI, llllllllllllllIlllIIIIIIIllllIIl));
    }
    
    public ModelRenderer getRandomModelBox(final Random llllllllllllllIlllIIIIIIlIIIIIll) {
        return this.boxList.get(llllllllllllllIlllIIIIIIlIIIIIll.nextInt(this.boxList.size()));
    }
    
    public void setLivingAnimations(final EntityLivingBase llllllllllllllIlllIIIIIIlIIIlIlI, final float llllllllllllllIlllIIIIIIlIIIlIIl, final float llllllllllllllIlllIIIIIIlIIIlIII, final float llllllllllllllIlllIIIIIIlIIIIlll) {
    }
    
    public TextureOffset getTextureOffset(final String llllllllllllllIlllIIIIIIIllIllll) {
        return this.modelTextureMap.get(llllllllllllllIlllIIIIIIIllIllll);
    }
    
    public void setModelAttributes(final ModelBase llllllllllllllIlllIIIIIIIllIIlIl) {
        this.swingProgress = llllllllllllllIlllIIIIIIIllIIlIl.swingProgress;
        this.isRiding = llllllllllllllIlllIIIIIIIllIIlIl.isRiding;
        this.isChild = llllllllllllllIlllIIIIIIIllIIlIl.isChild;
    }
}
