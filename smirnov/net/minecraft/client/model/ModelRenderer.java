// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GLAllocation;
import com.google.common.collect.Lists;
import optifine.Config;
import java.util.ArrayList;
import optifine.ModelSprite;
import net.minecraft.client.renderer.RenderGlobal;
import net.optifine.entity.model.anim.ModelUpdater;
import java.util.List;
import net.minecraft.util.ResourceLocation;

public class ModelRenderer
{
    private /* synthetic */ int displayList;
    private /* synthetic */ ResourceLocation textureLocation;
    public /* synthetic */ float rotationPointY;
    public /* synthetic */ float rotateAngleX;
    public /* synthetic */ boolean showModel;
    public /* synthetic */ List<ModelBox> cubeList;
    public /* synthetic */ float textureHeight;
    private /* synthetic */ int textureOffsetY;
    public /* synthetic */ float scaleZ;
    public /* synthetic */ List spriteList;
    public /* synthetic */ float scaleY;
    public /* synthetic */ float offsetZ;
    public /* synthetic */ boolean mirror;
    private /* synthetic */ String id;
    public final /* synthetic */ String boxName;
    public /* synthetic */ boolean mirrorV;
    private final /* synthetic */ ModelBase baseModel;
    public /* synthetic */ boolean isHidden;
    public /* synthetic */ float rotationPointZ;
    public /* synthetic */ float scaleX;
    public /* synthetic */ float offsetX;
    public /* synthetic */ float offsetY;
    public /* synthetic */ List<ModelRenderer> childModels;
    public /* synthetic */ float textureWidth;
    private /* synthetic */ ModelUpdater modelUpdater;
    private /* synthetic */ float savedScale;
    public /* synthetic */ float rotateAngleY;
    public /* synthetic */ float rotationPointX;
    private /* synthetic */ RenderGlobal renderGlobal;
    private /* synthetic */ int textureOffsetX;
    private /* synthetic */ boolean compiled;
    public /* synthetic */ float rotateAngleZ;
    
    public void addSprite(final float llllllllllIlllIlllllIIllIllIlIll, final float llllllllllIlllIlllllIIllIllIIIlI, final float llllllllllIlllIlllllIIllIllIlIIl, final int llllllllllIlllIlllllIIllIllIlIII, final int llllllllllIlllIlllllIIllIlIlllll, final int llllllllllIlllIlllllIIllIllIIllI, final float llllllllllIlllIlllllIIllIllIIlIl) {
        this.spriteList.add(new ModelSprite(this, this.textureOffsetX, this.textureOffsetY, llllllllllIlllIlllllIIllIllIlIll, llllllllllIlllIlllllIIllIllIIIlI, llllllllllIlllIlllllIIllIllIlIIl, llllllllllIlllIlllllIIllIllIlIII, llllllllllIlllIlllllIIllIlIlllll, llllllllllIlllIlllllIIllIllIIllI, llllllllllIlllIlllllIIllIllIIlIl));
    }
    
    public ModelRenderer addBox(final float llllllllllIlllIlllllIlIIIIIllIIl, final float llllllllllIlllIlllllIlIIIIIllIII, final float llllllllllIlllIlllllIlIIIIIIllll, final int llllllllllIlllIlllllIlIIIIIlIllI, final int llllllllllIlllIlllllIlIIIIIlIlIl, final int llllllllllIlllIlllllIlIIIIIlIlII, final boolean llllllllllIlllIlllllIlIIIIIlIIll) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, llllllllllIlllIlllllIlIIIIIllIIl, llllllllllIlllIlllllIlIIIIIllIII, llllllllllIlllIlllllIlIIIIIIllll, llllllllllIlllIlllllIlIIIIIlIllI, llllllllllIlllIlllllIlIIIIIlIlIl, llllllllllIlllIlllllIlIIIIIlIlII, 0.0f, llllllllllIlllIlllllIlIIIIIlIIll));
        return this;
    }
    
    public ModelRenderer addBox(final float llllllllllIlllIlllllIlIIIIlIlIII, final float llllllllllIlllIlllllIlIIIIlIIlll, final float llllllllllIlllIlllllIlIIIIlIIllI, final int llllllllllIlllIlllllIlIIIIlIllII, final int llllllllllIlllIlllllIlIIIIlIlIll, final int llllllllllIlllIlllllIlIIIIlIlIlI) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, llllllllllIlllIlllllIlIIIIlIlIII, llllllllllIlllIlllllIlIIIIlIIlll, llllllllllIlllIlllllIlIIIIlIIllI, llllllllllIlllIlllllIlIIIIlIllII, llllllllllIlllIlllllIlIIIIlIlIll, llllllllllIlllIlllllIlIIIIlIlIlI, 0.0f));
        return this;
    }
    
    public ModelRenderer(final ModelBase llllllllllIlllIlllllIlIIIllllIII, final String llllllllllIlllIlllllIlIIIlllIlll) {
        this.spriteList = new ArrayList();
        this.mirrorV = false;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.scaleZ = 1.0f;
        this.textureLocation = null;
        this.id = null;
        this.renderGlobal = Config.getRenderGlobal();
        this.textureWidth = 64.0f;
        this.textureHeight = 32.0f;
        this.showModel = true;
        this.cubeList = (List<ModelBox>)Lists.newArrayList();
        this.baseModel = llllllllllIlllIlllllIlIIIllllIII;
        llllllllllIlllIlllllIlIIIllllIII.boxList.add(this);
        this.boxName = llllllllllIlllIlllllIlIIIlllIlll;
        this.setTextureSize(llllllllllIlllIlllllIlIIIllllIII.textureWidth, llllllllllIlllIlllllIlIIIllllIII.textureHeight);
    }
    
    public void resetDisplayList() {
        if (this.compiled) {
            this.compiled = false;
            this.compileDisplayList(this.savedScale);
        }
    }
    
    public String getId() {
        return this.id;
    }
    
    public ModelRenderer addCube(final float llllllllllIlllIlllllIIllllIllllI, final float llllllllllIlllIlllllIIllllIlllIl, final float llllllllllIlllIlllllIIllllIlllII, final float llllllllllIlllIlllllIIllllIllIll, final float llllllllllIlllIlllllIIllllIllIlI, final float llllllllllIlllIlllllIIlllllIIIIl, final float llllllllllIlllIlllllIIllllIllIII) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, llllllllllIlllIlllllIIllllIllllI, llllllllllIlllIlllllIIllllIlllIl, llllllllllIlllIlllllIIllllIlllII, (int)llllllllllIlllIlllllIIllllIllIll, (int)llllllllllIlllIlllllIIllllIllIlI, (int)llllllllllIlllIlllllIIlllllIIIIl, llllllllllIlllIlllllIIllllIllIII));
        return this;
    }
    
    private void compileDisplayList(final float llllllllllIlllIlllllIIlllIIIIlll) {
        if (this.displayList == 0) {
            this.savedScale = llllllllllIlllIlllllIIlllIIIIlll;
            this.displayList = GLAllocation.generateDisplayLists(1);
        }
        GlStateManager.glNewList(this.displayList, 4864);
        final BufferBuilder llllllllllIlllIlllllIIlllIIIIllI = Tessellator.getInstance().getBuffer();
        for (int llllllllllIlllIlllllIIlllIIIIlIl = 0; llllllllllIlllIlllllIIlllIIIIlIl < this.cubeList.size(); ++llllllllllIlllIlllllIIlllIIIIlIl) {
            this.cubeList.get(llllllllllIlllIlllllIIlllIIIIlIl).render(llllllllllIlllIlllllIIlllIIIIllI, llllllllllIlllIlllllIIlllIIIIlll);
        }
        for (int llllllllllIlllIlllllIIlllIIIIlII = 0; llllllllllIlllIlllllIIlllIIIIlII < this.spriteList.size(); ++llllllllllIlllIlllllIIlllIIIIlII) {
            final ModelSprite llllllllllIlllIlllllIIlllIIIIIll = this.spriteList.get(llllllllllIlllIlllllIIlllIIIIlII);
            llllllllllIlllIlllllIIlllIIIIIll.render(Tessellator.getInstance(), llllllllllIlllIlllllIIlllIIIIlll);
        }
        GlStateManager.glEndList();
        this.compiled = true;
    }
    
    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }
    
    public ModelRenderer getChildDeep(final String llllllllllIlllIlllllIIllIIIlIIll) {
        if (llllllllllIlllIlllllIIllIIIlIIll == null) {
            return null;
        }
        final ModelRenderer llllllllllIlllIlllllIIllIIIlIIlI = this.getChild(llllllllllIlllIlllllIIllIIIlIIll);
        if (llllllllllIlllIlllllIIllIIIlIIlI != null) {
            return llllllllllIlllIlllllIIllIIIlIIlI;
        }
        if (this.childModels != null) {
            for (int llllllllllIlllIlllllIIllIIIlIIIl = 0; llllllllllIlllIlllllIIllIIIlIIIl < this.childModels.size(); ++llllllllllIlllIlllllIIllIIIlIIIl) {
                final ModelRenderer llllllllllIlllIlllllIIllIIIlIIII = this.childModels.get(llllllllllIlllIlllllIIllIIIlIIIl);
                final ModelRenderer llllllllllIlllIlllllIIllIIIIllll = llllllllllIlllIlllllIIllIIIlIIII.getChildDeep(llllllllllIlllIlllllIIllIIIlIIll);
                if (llllllllllIlllIlllllIIllIIIIllll != null) {
                    return llllllllllIlllIlllllIIllIIIIllll;
                }
            }
        }
        return null;
    }
    
    public ModelRenderer getChild(final String llllllllllIlllIlllllIIllIIlIIIIl) {
        if (llllllllllIlllIlllllIIllIIlIIIIl == null) {
            return null;
        }
        if (this.childModels != null) {
            for (int llllllllllIlllIlllllIIllIIlIIIII = 0; llllllllllIlllIlllllIIllIIlIIIII < this.childModels.size(); ++llllllllllIlllIlllllIIllIIlIIIII) {
                final ModelRenderer llllllllllIlllIlllllIIllIIIlllll = this.childModels.get(llllllllllIlllIlllllIIllIIlIIIII);
                if (llllllllllIlllIlllllIIllIIlIIIIl.equals(llllllllllIlllIlllllIIllIIIlllll.getId())) {
                    return llllllllllIlllIlllllIIllIIIlllll;
                }
            }
        }
        return null;
    }
    
    public void postRender(final float llllllllllIlllIlllllIIlllIIIlllI) {
        if (!this.isHidden && this.showModel) {
            if (!this.compiled) {
                this.compileDisplayList(llllllllllIlllIlllllIIlllIIIlllI);
            }
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX != 0.0f || this.rotationPointY != 0.0f || this.rotationPointZ != 0.0f) {
                    GlStateManager.translate(this.rotationPointX * llllllllllIlllIlllllIIlllIIIlllI, this.rotationPointY * llllllllllIlllIlllllIIlllIIIlllI, this.rotationPointZ * llllllllllIlllIlllllIIlllIIIlllI);
                }
            }
            else {
                GlStateManager.translate(this.rotationPointX * llllllllllIlllIlllllIIlllIIIlllI, this.rotationPointY * llllllllllIlllIlllllIIlllIIIlllI, this.rotationPointZ * llllllllllIlllIlllllIIlllIIIlllI);
                if (this.rotateAngleZ != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
                }
                if (this.rotateAngleY != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
                }
                if (this.rotateAngleX != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
                }
            }
        }
    }
    
    public ModelRenderer setTextureSize(final int llllllllllIlllIlllllIIllIllllIIl, final int llllllllllIlllIlllllIIllIlllIlIl) {
        this.textureWidth = (float)llllllllllIlllIlllllIIllIllllIIl;
        this.textureHeight = (float)llllllllllIlllIlllllIIllIlllIlIl;
        return this;
    }
    
    public void setTextureLocation(final ResourceLocation llllllllllIlllIlllllIIllIlIIlIll) {
        this.textureLocation = llllllllllIlllIlllllIIllIlIIlIll;
    }
    
    @Override
    public String toString() {
        final StringBuffer llllllllllIlllIlllllIIlIllllllll = new StringBuffer();
        llllllllllIlllIlllllIIlIllllllll.append("id: " + this.id + ", boxes: " + ((this.cubeList != null) ? Integer.valueOf(this.cubeList.size()) : null) + ", submodels: " + ((this.childModels != null) ? Integer.valueOf(this.childModels.size()) : null));
        return llllllllllIlllIlllllIIlIllllllll.toString();
    }
    
    public int getDisplayList() {
        return this.displayList;
    }
    
    public ModelRenderer setTextureOffset(final int llllllllllIlllIlllllIlIIIlIlIlll, final int llllllllllIlllIlllllIlIIIlIlIIll) {
        this.textureOffsetX = llllllllllIlllIlllllIlIIIlIlIlll;
        this.textureOffsetY = llllllllllIlllIlllllIlIIIlIlIIll;
        return this;
    }
    
    public ModelRenderer addCube(final float llllllllllIlllIlllllIlIIIIIIIIII, final float llllllllllIlllIlllllIIllllllIllI, final float llllllllllIlllIlllllIIlllllllllI, final float llllllllllIlllIlllllIIllllllllIl, final float llllllllllIlllIlllllIIllllllIIll, final float llllllllllIlllIlllllIIllllllIIlI, final float llllllllllIlllIlllllIIllllllIIIl, final boolean llllllllllIlllIlllllIIllllllIIII) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, llllllllllIlllIlllllIlIIIIIIIIII, llllllllllIlllIlllllIIllllllIllI, llllllllllIlllIlllllIIlllllllllI, (int)llllllllllIlllIlllllIIllllllllIl, (int)llllllllllIlllIlllllIIllllllIIll, (int)llllllllllIlllIlllllIIllllllIIlI, llllllllllIlllIlllllIIllllllIIIl, llllllllllIlllIlllllIIllllllIIII));
        return this;
    }
    
    public void setModelUpdater(final ModelUpdater llllllllllIlllIlllllIIllIIIIIlIl) {
        this.modelUpdater = llllllllllIlllIlllllIIllIIIIIlIl;
    }
    
    public ModelRenderer(final ModelBase llllllllllIlllIlllllIlIIIllIlllI) {
        this(llllllllllIlllIlllllIlIIIllIlllI, null);
    }
    
    public void setId(final String llllllllllIlllIlllllIIllIlIIIlII) {
        this.id = llllllllllIlllIlllllIIllIlIIIlII;
    }
    
    public void addBox(final float llllllllllIlllIlllllIIllllIIlllI, final float llllllllllIlllIlllllIIllllIIIlIl, final float llllllllllIlllIlllllIIllllIIllII, final int llllllllllIlllIlllllIIllllIIlIll, final int llllllllllIlllIlllllIIllllIIIIlI, final int llllllllllIlllIlllllIIllllIIIIIl, final float llllllllllIlllIlllllIIllllIIIIII) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, llllllllllIlllIlllllIIllllIIlllI, llllllllllIlllIlllllIIllllIIIlIl, llllllllllIlllIlllllIIllllIIllII, llllllllllIlllIlllllIIllllIIlIll, llllllllllIlllIlllllIIllllIIIIlI, llllllllllIlllIlllllIIllllIIIIIl, llllllllllIlllIlllllIIllllIIIIII));
    }
    
    public void render(final float llllllllllIlllIlllllIIlllIlIIllI) {
        if (!this.isHidden && this.showModel) {
            if (!this.compiled) {
                this.compileDisplayList(llllllllllIlllIlllllIIlllIlIIllI);
            }
            int llllllllllIlllIlllllIIlllIlIllII = 0;
            if (this.textureLocation != null && !this.renderGlobal.renderOverlayDamaged) {
                if (this.renderGlobal.renderOverlayEyes) {
                    return;
                }
                llllllllllIlllIlllllIIlllIlIllII = GlStateManager.getBoundTexture();
                Config.getTextureManager().bindTexture(this.textureLocation);
            }
            if (this.modelUpdater != null) {
                this.modelUpdater.update();
            }
            final boolean llllllllllIlllIlllllIIlllIlIlIll = this.scaleX != 1.0f || this.scaleY != 1.0f || this.scaleZ != 1.0f;
            GlStateManager.translate(this.offsetX, this.offsetY, this.offsetZ);
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX == 0.0f && this.rotationPointY == 0.0f && this.rotationPointZ == 0.0f) {
                    if (llllllllllIlllIlllllIIlllIlIlIll) {
                        GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
                    }
                    GlStateManager.callList(this.displayList);
                    if (this.childModels != null) {
                        for (int llllllllllIlllIlllllIIlllIlIlIlI = 0; llllllllllIlllIlllllIIlllIlIlIlI < this.childModels.size(); ++llllllllllIlllIlllllIIlllIlIlIlI) {
                            this.childModels.get(llllllllllIlllIlllllIIlllIlIlIlI).render(llllllllllIlllIlllllIIlllIlIIllI);
                        }
                    }
                    if (llllllllllIlllIlllllIIlllIlIlIll) {
                        GlStateManager.scale(1.0f / this.scaleX, 1.0f / this.scaleY, 1.0f / this.scaleZ);
                    }
                }
                else {
                    GlStateManager.translate(this.rotationPointX * llllllllllIlllIlllllIIlllIlIIllI, this.rotationPointY * llllllllllIlllIlllllIIlllIlIIllI, this.rotationPointZ * llllllllllIlllIlllllIIlllIlIIllI);
                    if (llllllllllIlllIlllllIIlllIlIlIll) {
                        GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
                    }
                    GlStateManager.callList(this.displayList);
                    if (this.childModels != null) {
                        for (int llllllllllIlllIlllllIIlllIlIlIIl = 0; llllllllllIlllIlllllIIlllIlIlIIl < this.childModels.size(); ++llllllllllIlllIlllllIIlllIlIlIIl) {
                            this.childModels.get(llllllllllIlllIlllllIIlllIlIlIIl).render(llllllllllIlllIlllllIIlllIlIIllI);
                        }
                    }
                    if (llllllllllIlllIlllllIIlllIlIlIll) {
                        GlStateManager.scale(1.0f / this.scaleX, 1.0f / this.scaleY, 1.0f / this.scaleZ);
                    }
                    GlStateManager.translate(-this.rotationPointX * llllllllllIlllIlllllIIlllIlIIllI, -this.rotationPointY * llllllllllIlllIlllllIIlllIlIIllI, -this.rotationPointZ * llllllllllIlllIlllllIIlllIlIIllI);
                }
            }
            else {
                GlStateManager.pushMatrix();
                GlStateManager.translate(this.rotationPointX * llllllllllIlllIlllllIIlllIlIIllI, this.rotationPointY * llllllllllIlllIlllllIIlllIlIIllI, this.rotationPointZ * llllllllllIlllIlllllIIlllIlIIllI);
                if (this.rotateAngleZ != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
                }
                if (this.rotateAngleY != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
                }
                if (this.rotateAngleX != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
                }
                if (llllllllllIlllIlllllIIlllIlIlIll) {
                    GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
                }
                GlStateManager.callList(this.displayList);
                if (this.childModels != null) {
                    for (int llllllllllIlllIlllllIIlllIlIlIII = 0; llllllllllIlllIlllllIIlllIlIlIII < this.childModels.size(); ++llllllllllIlllIlllllIIlllIlIlIII) {
                        this.childModels.get(llllllllllIlllIlllllIIlllIlIlIII).render(llllllllllIlllIlllllIIlllIlIIllI);
                    }
                }
                GlStateManager.popMatrix();
            }
            GlStateManager.translate(-this.offsetX, -this.offsetY, -this.offsetZ);
            if (llllllllllIlllIlllllIIlllIlIllII != 0) {
                GlStateManager.bindTexture(llllllllllIlllIlllllIIlllIlIllII);
            }
        }
    }
    
    public void addChild(final ModelRenderer llllllllllIlllIlllllIlIIIlIllllI) {
        if (this.childModels == null) {
            this.childModels = (List<ModelRenderer>)Lists.newArrayList();
        }
        this.childModels.add(llllllllllIlllIlllllIlIIIlIllllI);
    }
    
    public void setRotationPoint(final float llllllllllIlllIlllllIIlllIlllIlI, final float llllllllllIlllIlllllIIlllIllIlIl, final float llllllllllIlllIlllllIIlllIlllIII) {
        this.rotationPointX = llllllllllIlllIlllllIIlllIlllIlI;
        this.rotationPointY = llllllllllIlllIlllllIIlllIllIlIl;
        this.rotationPointZ = llllllllllIlllIlllllIIlllIlllIII;
    }
    
    public ModelRenderer(final ModelBase llllllllllIlllIlllllIlIIIllIIlII, final int llllllllllIlllIlllllIlIIIllIIlll, final int llllllllllIlllIlllllIlIIIllIIllI) {
        this(llllllllllIlllIlllllIlIIIllIIlII);
        this.setTextureOffset(llllllllllIlllIlllllIlIIIllIIlll, llllllllllIlllIlllllIlIIIllIIllI);
    }
    
    public void addBox(final int[][] llllllllllIlllIlllllIIllIIllIlll, final float llllllllllIlllIlllllIIllIIlIllIl, final float llllllllllIlllIlllllIIllIIllIlIl, final float llllllllllIlllIlllllIIllIIlIlIll, final float llllllllllIlllIlllllIIllIIlIlIlI, final float llllllllllIlllIlllllIIllIIlIlIIl, final float llllllllllIlllIlllllIIllIIllIIIl, final float llllllllllIlllIlllllIIllIIllIIII) {
        this.cubeList.add(new ModelBox(this, llllllllllIlllIlllllIIllIIllIlll, llllllllllIlllIlllllIIllIIlIllIl, llllllllllIlllIlllllIIllIIllIlIl, llllllllllIlllIlllllIIllIIlIlIll, llllllllllIlllIlllllIIllIIlIlIlI, llllllllllIlllIlllllIIllIIlIlIIl, llllllllllIlllIlllllIIllIIllIIIl, llllllllllIlllIlllllIIllIIllIIII, this.mirror));
    }
    
    public void renderWithRotation(final float llllllllllIlllIlllllIIlllIIlllII) {
        if (!this.isHidden && this.showModel) {
            if (!this.compiled) {
                this.compileDisplayList(llllllllllIlllIlllllIIlllIIlllII);
            }
            int llllllllllIlllIlllllIIlllIIllIll = 0;
            if (this.textureLocation != null && !this.renderGlobal.renderOverlayDamaged) {
                if (this.renderGlobal.renderOverlayEyes) {
                    return;
                }
                llllllllllIlllIlllllIIlllIIllIll = GlStateManager.getBoundTexture();
                Config.getTextureManager().bindTexture(this.textureLocation);
            }
            if (this.modelUpdater != null) {
                this.modelUpdater.update();
            }
            final boolean llllllllllIlllIlllllIIlllIIllIlI = this.scaleX != 1.0f || this.scaleY != 1.0f || this.scaleZ != 1.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(this.rotationPointX * llllllllllIlllIlllllIIlllIIlllII, this.rotationPointY * llllllllllIlllIlllllIIlllIIlllII, this.rotationPointZ * llllllllllIlllIlllllIIlllIIlllII);
            if (this.rotateAngleY != 0.0f) {
                GlStateManager.rotate(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
            }
            if (this.rotateAngleX != 0.0f) {
                GlStateManager.rotate(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
            }
            if (this.rotateAngleZ != 0.0f) {
                GlStateManager.rotate(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
            }
            if (llllllllllIlllIlllllIIlllIIllIlI) {
                GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
            }
            GlStateManager.callList(this.displayList);
            if (this.childModels != null) {
                for (int llllllllllIlllIlllllIIlllIIllIIl = 0; llllllllllIlllIlllllIIlllIIllIIl < this.childModels.size(); ++llllllllllIlllIlllllIIlllIIllIIl) {
                    this.childModels.get(llllllllllIlllIlllllIIlllIIllIIl).render(llllllllllIlllIlllllIIlllIIlllII);
                }
            }
            GlStateManager.popMatrix();
            if (llllllllllIlllIlllllIIlllIIllIll != 0) {
                GlStateManager.bindTexture(llllllllllIlllIlllllIIlllIIllIll);
            }
        }
    }
    
    public ModelRenderer addBox(String llllllllllIlllIlllllIlIIIIllllll, final float llllllllllIlllIlllllIlIIIIlllllI, final float llllllllllIlllIlllllIlIIIIllllIl, final float llllllllllIlllIlllllIlIIIlIIIlIl, final int llllllllllIlllIlllllIlIIIlIIIlII, final int llllllllllIlllIlllllIlIIIlIIIIll, final int llllllllllIlllIlllllIlIIIIlllIIl) {
        llllllllllIlllIlllllIlIIIIllllll = String.valueOf(this.boxName) + "." + llllllllllIlllIlllllIlIIIIllllll;
        final TextureOffset llllllllllIlllIlllllIlIIIlIIIIIl = this.baseModel.getTextureOffset(llllllllllIlllIlllllIlIIIIllllll);
        this.setTextureOffset(llllllllllIlllIlllllIlIIIlIIIIIl.textureOffsetX, llllllllllIlllIlllllIlIIIlIIIIIl.textureOffsetY);
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, llllllllllIlllIlllllIlIIIIlllllI, llllllllllIlllIlllllIlIIIIllllIl, llllllllllIlllIlllllIlIIIlIIIlIl, llllllllllIlllIlllllIlIIIlIIIlII, llllllllllIlllIlllllIlIIIlIIIIll, llllllllllIlllIlllllIlIIIIlllIIl, 0.0f).setBoxName(llllllllllIlllIlllllIlIIIIllllll));
        return this;
    }
    
    public boolean getCompiled() {
        return this.compiled;
    }
}
