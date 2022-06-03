// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.utils.friend.FriendManager;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.visuals.CustomModel;
import ru.rockstar.Main;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.EnumHandSide;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;

public class LayerHeldItem implements LayerRenderer<EntityLivingBase>
{
    protected final /* synthetic */ RenderLivingBase<?> livingEntityRenderer;
    public static /* synthetic */ boolean jeffRender;
    
    protected void func_191361_a(final EnumHandSide llllllllllllIIlIIIlIllIlllllIllI) {
        ((ModelBiped)this.livingEntityRenderer.getMainModel()).postRenderArm(0.0625f, llllllllllllIIlIIIlIllIlllllIllI);
    }
    
    public LayerHeldItem(final RenderLivingBase<?> llllllllllllIIlIIIlIlllIIIllIlIl) {
        this.livingEntityRenderer = llllllllllllIIlIIIlIlllIIIllIlIl;
    }
    
    static {
        LayerHeldItem.jeffRender = true;
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllIIlIIIlIlllIIIlIlIll, final float llllllllllllIIlIIIlIlllIIIlIlIlI, final float llllllllllllIIlIIIlIlllIIIlIlIIl, final float llllllllllllIIlIIIlIlllIIIlIlIII, final float llllllllllllIIlIIIlIlllIIIlIIlll, final float llllllllllllIIlIIIlIlllIIIlIIllI, final float llllllllllllIIlIIIlIlllIIIlIIlIl, final float llllllllllllIIlIIIlIlllIIIlIIlII) {
        if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("Jeff Killer")) {
            if (CustomModel.onlyMe.getBoolValue() && llllllllllllIIlIIIlIlllIIIlIlIll != Minecraft.getMinecraft().player) {
                final FriendManager friendManager = Main.instance.friendManager;
                if (!FriendManager.isFriend(llllllllllllIIlIIIlIlllIIIlIlIll.getName()) || !CustomModel.friends.getBoolValue()) {
                    final boolean llllllllllllIIlIIIlIlllIIIlIIIll = llllllllllllIIlIIIlIlllIIIlIlIll.getPrimaryHand() == EnumHandSide.RIGHT;
                    final ItemStack llllllllllllIIlIIIlIlllIIIlIIIlI = llllllllllllIIlIIIlIlllIIIlIIIll ? llllllllllllIIlIIIlIlllIIIlIlIll.getHeldItemOffhand() : llllllllllllIIlIIIlIlllIIIlIlIll.getHeldItemMainhand();
                    final ItemStack llllllllllllIIlIIIlIlllIIIlIIIIl = llllllllllllIIlIIIlIlllIIIlIIIll ? llllllllllllIIlIIIlIlllIIIlIlIll.getHeldItemMainhand() : llllllllllllIIlIIIlIlllIIIlIlIll.getHeldItemOffhand();
                    if (!llllllllllllIIlIIIlIlllIIIlIIIlI.isEmpty() || !llllllllllllIIlIIIlIlllIIIlIIIIl.isEmpty()) {
                        GlStateManager.pushMatrix();
                        if (this.livingEntityRenderer.getMainModel().isChild) {
                            final float llllllllllllIIlIIIlIlllIIIlIIIII = 0.5f;
                            GlStateManager.translate(0.0f, 0.75f, 0.0f);
                            GlStateManager.scale(0.5f, 0.5f, 0.5f);
                        }
                        this.renderHeldItem(llllllllllllIIlIIIlIlllIIIlIlIll, llllllllllllIIlIIIlIlllIIIlIIIIl, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
                        this.renderHeldItem(llllllllllllIIlIIIlIlllIIIlIlIll, llllllllllllIIlIIIlIlllIIIlIIIlI, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
                        GlStateManager.popMatrix();
                    }
                    return;
                }
            }
            final boolean llllllllllllIIlIIIlIlllIIIIlllll = llllllllllllIIlIIIlIlllIIIlIlIll.getPrimaryHand() == EnumHandSide.LEFT;
            final ItemStack llllllllllllIIlIIIlIlllIIIIllllI = llllllllllllIIlIIIlIlllIIIIlllll ? llllllllllllIIlIIIlIlllIIIlIlIll.getHeldItemOffhand() : llllllllllllIIlIIIlIlllIIIlIlIll.getHeldItemMainhand();
            if (!llllllllllllIIlIIIlIlllIIIIllllI.isEmpty()) {
                GlStateManager.pushMatrix();
                if (this.livingEntityRenderer.getMainModel().isChild) {
                    final float llllllllllllIIlIIIlIlllIIIIlllIl = 0.5f;
                    GlStateManager.translate(0.0f, 0.75f, 0.0f);
                    GlStateManager.scale(0.5f, 0.5f, 0.5f);
                }
                this.renderHeldItem(llllllllllllIIlIIIlIlllIIIlIlIll, llllllllllllIIlIIIlIlllIIIIllllI, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
                GlStateManager.popMatrix();
            }
        }
        else {
            final boolean llllllllllllIIlIIIlIlllIIIIlllII = llllllllllllIIlIIIlIlllIIIlIlIll.getPrimaryHand() == EnumHandSide.RIGHT;
            final ItemStack llllllllllllIIlIIIlIlllIIIIllIll = llllllllllllIIlIIIlIlllIIIIlllII ? llllllllllllIIlIIIlIlllIIIlIlIll.getHeldItemOffhand() : llllllllllllIIlIIIlIlllIIIlIlIll.getHeldItemMainhand();
            final ItemStack llllllllllllIIlIIIlIlllIIIIllIlI = llllllllllllIIlIIIlIlllIIIIlllII ? llllllllllllIIlIIIlIlllIIIlIlIll.getHeldItemMainhand() : llllllllllllIIlIIIlIlllIIIlIlIll.getHeldItemOffhand();
            if (!llllllllllllIIlIIIlIlllIIIIllIll.isEmpty() || !llllllllllllIIlIIIlIlllIIIIllIlI.isEmpty()) {
                GlStateManager.pushMatrix();
                if (this.livingEntityRenderer.getMainModel().isChild) {
                    final float llllllllllllIIlIIIlIlllIIIIllIIl = 0.5f;
                    GlStateManager.translate(0.0f, 0.75f, 0.0f);
                    GlStateManager.scale(0.5f, 0.5f, 0.5f);
                }
                this.renderHeldItem(llllllllllllIIlIIIlIlllIIIlIlIll, llllllllllllIIlIIIlIlllIIIIllIlI, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
                this.renderHeldItem(llllllllllllIIlIIIlIlllIIIlIlIll, llllllllllllIIlIIIlIlllIIIIllIll, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
                GlStateManager.popMatrix();
            }
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    private void renderHeldItem(final EntityLivingBase llllllllllllIIlIIIlIlllIIIIIlIll, final ItemStack llllllllllllIIlIIIlIlllIIIIIlIlI, final ItemCameraTransforms.TransformType llllllllllllIIlIIIlIllIllllllllI, final EnumHandSide llllllllllllIIlIIIlIllIlllllllIl) {
        if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && (CustomModel.modelMode.currentMode.equals("Crab") || CustomModel.modelMode.currentMode.equals("Chinchilla"))) {
            if (!llllllllllllIIlIIIlIlllIIIIIlIlI.isEmpty()) {
                GlStateManager.pushMatrix();
                this.func_191361_a(llllllllllllIIlIIIlIllIlllllllIl);
                if (llllllllllllIIlIIIlIlllIIIIIlIll.isSneaking()) {
                    GlStateManager.translate(0.0f, 0.2f, 0.0f);
                }
                GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                final boolean llllllllllllIIlIIIlIlllIIIIIIlll = llllllllllllIIlIIIlIllIlllllllIl == EnumHandSide.LEFT;
                Label_0196: {
                    if (CustomModel.onlyMe.getBoolValue() && llllllllllllIIlIIIlIlllIIIIIlIll != Minecraft.getMinecraft().player) {
                        final FriendManager friendManager = Main.instance.friendManager;
                        if (!FriendManager.isFriend(llllllllllllIIlIIIlIlllIIIIIlIll.getName()) || !CustomModel.friends.getBoolValue()) {
                            GlStateManager.translate((llllllllllllIIlIIIlIlllIIIIIIlll ? -1 : 1) / 16.0f, 0.125f, -0.625f);
                            break Label_0196;
                        }
                    }
                    GlStateManager.translate((llllllllllllIIlIIIlIlllIIIIIIlll ? -1 : 1) / 16.0f, 0.5249999761581421, -1.05);
                }
                Minecraft.getMinecraft().getItemRenderer().renderItemSide(llllllllllllIIlIIIlIlllIIIIIlIll, llllllllllllIIlIIIlIlllIIIIIlIlI, llllllllllllIIlIIIlIllIllllllllI, llllllllllllIIlIIIlIlllIIIIIIlll);
                GlStateManager.popMatrix();
            }
        }
        else if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("Freddy Bear")) {
            if (!llllllllllllIIlIIIlIlllIIIIIlIlI.isEmpty()) {
                GlStateManager.pushMatrix();
                this.func_191361_a(llllllllllllIIlIIIlIllIlllllllIl);
                if (llllllllllllIIlIIIlIlllIIIIIlIll.isSneaking()) {
                    GlStateManager.translate(0.0f, 0.2f, 0.0f);
                }
                GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                final boolean llllllllllllIIlIIIlIlllIIIIIIllI = llllllllllllIIlIIIlIllIlllllllIl == EnumHandSide.LEFT;
                Label_0433: {
                    if (CustomModel.onlyMe.getBoolValue() && llllllllllllIIlIIIlIlllIIIIIlIll != Minecraft.getMinecraft().player) {
                        final FriendManager friendManager2 = Main.instance.friendManager;
                        if (!FriendManager.isFriend(llllllllllllIIlIIIlIlllIIIIIlIll.getName()) || !CustomModel.friends.getBoolValue()) {
                            GlStateManager.translate((llllllllllllIIlIIIlIlllIIIIIIllI ? -1 : 1) / 16.0f, 0.125f, -0.625f);
                            break Label_0433;
                        }
                    }
                    if (llllllllllllIIlIIIlIlllIIIIIlIll.isSneaking()) {
                        GlStateManager.translate((llllllllllllIIlIIIlIlllIIIIIIllI ? -1 : 1) / 16.0f, 0.20000000298023224, -0.3);
                    }
                    else {
                        GlStateManager.translate((llllllllllllIIlIIIlIlllIIIIIIllI ? -1 : 1) / 16.0f, 0.30000001192092896, -0.5);
                    }
                }
                Minecraft.getMinecraft().getItemRenderer().renderItemSide(llllllllllllIIlIIIlIlllIIIIIlIll, llllllllllllIIlIIIlIlllIIIIIlIlI, llllllllllllIIlIIIlIllIllllllllI, llllllllllllIIlIIIlIlllIIIIIIllI);
                GlStateManager.popMatrix();
            }
        }
        else if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("Sonic")) {
            if (!llllllllllllIIlIIIlIlllIIIIIlIlI.isEmpty()) {
                GlStateManager.pushMatrix();
                this.func_191361_a(llllllllllllIIlIIIlIllIlllllllIl);
                if (llllllllllllIIlIIIlIlllIIIIIlIll.isSneaking()) {
                    GlStateManager.translate(0.0f, 0.2f, 0.0f);
                }
                GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                final boolean llllllllllllIIlIIIlIlllIIIIIIlIl = llllllllllllIIlIIIlIllIlllllllIl == EnumHandSide.LEFT;
                Label_0639: {
                    if (CustomModel.onlyMe.getBoolValue() && llllllllllllIIlIIIlIlllIIIIIlIll != Minecraft.getMinecraft().player) {
                        final FriendManager friendManager3 = Main.instance.friendManager;
                        if (!FriendManager.isFriend(llllllllllllIIlIIIlIlllIIIIIlIll.getName()) || !CustomModel.friends.getBoolValue()) {
                            GlStateManager.translate((llllllllllllIIlIIIlIlllIIIIIIlIl ? -1 : 1) / 16.0f, 0.125f, -0.625f);
                            break Label_0639;
                        }
                    }
                    GlStateManager.translate((llllllllllllIIlIIIlIlllIIIIIIlIl ? -1 : 1) / 16.0f + 0.05f, 0.05f, -0.925f);
                }
                Minecraft.getMinecraft().getItemRenderer().renderItemSide(llllllllllllIIlIIIlIlllIIIIIlIll, llllllllllllIIlIIIlIlllIIIIIlIlI, llllllllllllIIlIIIlIllIllllllllI, llllllllllllIIlIIIlIlllIIIIIIlIl);
                GlStateManager.popMatrix();
            }
        }
        else if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("CupHead")) {
            if (!llllllllllllIIlIIIlIlllIIIIIlIlI.isEmpty()) {
                GlStateManager.pushMatrix();
                this.func_191361_a(llllllllllllIIlIIIlIllIlllllllIl);
                if (llllllllllllIIlIIIlIlllIIIIIlIll.isSneaking()) {
                    GlStateManager.translate(0.0f, 0.2f, 0.0f);
                }
                GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                final boolean llllllllllllIIlIIIlIlllIIIIIIlII = llllllllllllIIlIIIlIllIlllllllIl == EnumHandSide.LEFT;
                Label_0840: {
                    if (CustomModel.onlyMe.getBoolValue() && llllllllllllIIlIIIlIlllIIIIIlIll != Minecraft.getMinecraft().player) {
                        final FriendManager friendManager4 = Main.instance.friendManager;
                        if (!FriendManager.isFriend(llllllllllllIIlIIIlIlllIIIIIlIll.getName()) || !CustomModel.friends.getBoolValue()) {
                            GlStateManager.translate((llllllllllllIIlIIIlIlllIIIIIIlII ? -1 : 1) / 16.0f, 0.125f, -0.625f);
                            break Label_0840;
                        }
                    }
                    GlStateManager.translate((llllllllllllIIlIIIlIlllIIIIIIlII ? -1 : 1) / 16.0f, -0.325f, -0.625f);
                }
                Minecraft.getMinecraft().getItemRenderer().renderItemSide(llllllllllllIIlIIIlIlllIIIIIlIll, llllllllllllIIlIIIlIlllIIIIIlIlI, llllllllllllIIlIIIlIllIllllllllI, llllllllllllIIlIIIlIlllIIIIIIlII);
                GlStateManager.popMatrix();
            }
        }
        else if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("Crazy Rabbit")) {
            if (!llllllllllllIIlIIIlIlllIIIIIlIlI.isEmpty()) {
                GlStateManager.pushMatrix();
                this.func_191361_a(llllllllllllIIlIIIlIllIlllllllIl);
                if (llllllllllllIIlIIIlIlllIIIIIlIll.isSneaking()) {
                    GlStateManager.translate(0.0f, 0.2f, 0.0f);
                }
                GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                final boolean llllllllllllIIlIIIlIlllIIIIIIIll = llllllllllllIIlIIIlIllIlllllllIl == EnumHandSide.LEFT;
                Label_1043: {
                    if (CustomModel.onlyMe.getBoolValue() && llllllllllllIIlIIIlIlllIIIIIlIll != Minecraft.getMinecraft().player) {
                        final FriendManager friendManager5 = Main.instance.friendManager;
                        if (!FriendManager.isFriend(llllllllllllIIlIIIlIlllIIIIIlIll.getName()) || !CustomModel.friends.getBoolValue()) {
                            GlStateManager.translate((llllllllllllIIlIIIlIlllIIIIIIIll ? -1 : 1) / 16.0f, 0.125f, -0.625f);
                            break Label_1043;
                        }
                    }
                    GlStateManager.translate((llllllllllllIIlIIIlIlllIIIIIIIll ? -2 : 2) / 16.0f, 0.15f, -1.0f);
                }
                Minecraft.getMinecraft().getItemRenderer().renderItemSide(llllllllllllIIlIIIlIlllIIIIIlIll, llllllllllllIIlIIIlIlllIIIIIlIlI, llllllllllllIIlIIIlIllIllllllllI, llllllllllllIIlIIIlIlllIIIIIIIll);
                GlStateManager.popMatrix();
            }
        }
        else if (!llllllllllllIIlIIIlIlllIIIIIlIlI.isEmpty()) {
            GlStateManager.pushMatrix();
            this.func_191361_a(llllllllllllIIlIIIlIllIlllllllIl);
            if (llllllllllllIIlIIIlIlllIIIIIlIll.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
            final boolean llllllllllllIIlIIIlIlllIIIIIIIlI = llllllllllllIIlIIIlIllIlllllllIl == EnumHandSide.LEFT;
            GlStateManager.translate((llllllllllllIIlIIIlIlllIIIIIIIlI ? -1 : 1) / 16.0f, 0.125f, -0.625f);
            Minecraft.getMinecraft().getItemRenderer().renderItemSide(llllllllllllIIlIIIlIlllIIIIIlIll, llllllllllllIIlIIIlIlllIIIIIlIlI, llllllllllllIIlIIIlIllIllllllllI, llllllllllllIIlIIIlIlllIIIIIIIlI);
            GlStateManager.popMatrix();
        }
    }
}
