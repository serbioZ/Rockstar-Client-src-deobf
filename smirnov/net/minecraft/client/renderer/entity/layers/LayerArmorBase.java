// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import shadersmod.client.ShadersRender;
import shadersmod.client.Shaders;
import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.GlStateManager;
import optifine.ReflectorForge;
import net.minecraft.entity.Entity;
import optifine.CustomItems;
import optifine.Config;
import optifine.Reflector;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemArmor;
import net.minecraft.inventory.EntityEquipmentSlot;
import ru.rockstar.client.features.Feature;
import ru.rockstar.api.utils.friend.FriendManager;
import ru.rockstar.Main;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.features.impl.visuals.CustomModel;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBase;

public abstract class LayerArmorBase<T extends ModelBase> implements LayerRenderer<EntityLivingBase>
{
    private final /* synthetic */ RenderLivingBase<?> renderer;
    private /* synthetic */ float colorG;
    protected /* synthetic */ T modelLeggings;
    protected static final /* synthetic */ ResourceLocation ENCHANTED_ITEM_GLINT_RES;
    protected /* synthetic */ T modelArmor;
    private /* synthetic */ float alpha;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial;
    private static final /* synthetic */ Map<String, ResourceLocation> ARMOR_TEXTURE_RES_MAP;
    private /* synthetic */ float colorB;
    private /* synthetic */ float colorR;
    private /* synthetic */ boolean skipRenderGlint;
    
    public LayerArmorBase(final RenderLivingBase<?> lllllllllllllIIIlIlIIIIlllIlIlll) {
        this.alpha = 1.0f;
        this.colorR = 1.0f;
        this.colorG = 1.0f;
        this.colorB = 1.0f;
        this.renderer = lllllllllllllIIIlIlIIIIlllIlIlll;
        this.initArmor();
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllllIIIlIlIIIIlllIIlIlI, final float lllllllllllllIIIlIlIIIIlllIIlIIl, final float lllllllllllllIIIlIlIIIIllIllllll, final float lllllllllllllIIIlIlIIIIllIlllllI, final float lllllllllllllIIIlIlIIIIllIllllIl, final float lllllllllllllIIIlIlIIIIlllIIIlIl, final float lllllllllllllIIIlIlIIIIllIlllIll, final float lllllllllllllIIIlIlIIIIlllIIIIll) {
        Label_0228: {
            if (CustomModel.onlyMe.getBoolValue() && lllllllllllllIIIlIlIIIIlllIIlIlI != Minecraft.getMinecraft().player) {
                final FriendManager friendManager = Main.instance.friendManager;
                if (!FriendManager.isFriend(lllllllllllllIIIlIlIIIIlllIIlIlI.getName()) || !CustomModel.friends.getBoolValue()) {
                    break Label_0228;
                }
            }
            if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && (CustomModel.modelMode.currentMode.equals("Crazy Rabbit") || CustomModel.modelMode.currentMode.equals("Sonic") || CustomModel.modelMode.currentMode.equals("CupHead") || CustomModel.modelMode.currentMode.equals("Freddy Bear") || CustomModel.modelMode.currentMode.equals("Chinchilla") || CustomModel.modelMode.currentMode.equals("Freddy Bear") || CustomModel.modelMode.currentMode.equals("Amogus") || CustomModel.modelMode.currentMode.equals("Red Panda") || CustomModel.modelMode.currentMode.equals("Demon") || CustomModel.modelMode.currentMode.equals("SirenHead") || CustomModel.modelMode.currentMode.equals("Jeff Killer") || CustomModel.modelMode.currentMode.equals("Crab"))) {
                return;
            }
        }
        this.renderArmorLayer(lllllllllllllIIIlIlIIIIlllIIlIlI, lllllllllllllIIIlIlIIIIlllIIlIIl, lllllllllllllIIIlIlIIIIllIllllll, lllllllllllllIIIlIlIIIIllIlllllI, lllllllllllllIIIlIlIIIIllIllllIl, lllllllllllllIIIlIlIIIIlllIIIlIl, lllllllllllllIIIlIlIIIIllIlllIll, lllllllllllllIIIlIlIIIIlllIIIIll, EntityEquipmentSlot.CHEST);
        this.renderArmorLayer(lllllllllllllIIIlIlIIIIlllIIlIlI, lllllllllllllIIIlIlIIIIlllIIlIIl, lllllllllllllIIIlIlIIIIllIllllll, lllllllllllllIIIlIlIIIIllIlllllI, lllllllllllllIIIlIlIIIIllIllllIl, lllllllllllllIIIlIlIIIIlllIIIlIl, lllllllllllllIIIlIlIIIIllIlllIll, lllllllllllllIIIlIlIIIIlllIIIIll, EntityEquipmentSlot.LEGS);
        this.renderArmorLayer(lllllllllllllIIIlIlIIIIlllIIlIlI, lllllllllllllIIIlIlIIIIlllIIlIIl, lllllllllllllIIIlIlIIIIllIllllll, lllllllllllllIIIlIlIIIIllIlllllI, lllllllllllllIIIlIlIIIIllIllllIl, lllllllllllllIIIlIlIIIIlllIIIlIl, lllllllllllllIIIlIlIIIIllIlllIll, lllllllllllllIIIlIlIIIIlllIIIIll, EntityEquipmentSlot.FEET);
        this.renderArmorLayer(lllllllllllllIIIlIlIIIIlllIIlIlI, lllllllllllllIIIlIlIIIIlllIIlIIl, lllllllllllllIIIlIlIIIIllIllllll, lllllllllllllIIIlIlIIIIllIlllllI, lllllllllllllIIIlIlIIIIllIllllIl, lllllllllllllIIIlIlIIIIlllIIIlIl, lllllllllllllIIIlIlIIIIllIlllIll, lllllllllllllIIIlIlIIIIlllIIIIll, EntityEquipmentSlot.HEAD);
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    private ResourceLocation getArmorResource(final ItemArmor lllllllllllllIIIlIlIIIIlIlIIIIll, final boolean lllllllllllllIIIlIlIIIIlIIllllll) {
        return this.getArmorResource(lllllllllllllIIIlIlIIIIlIlIIIIll, lllllllllllllIIIlIlIIIIlIIllllll, null);
    }
    
    public T getModelFromSlot(final EntityEquipmentSlot lllllllllllllIIIlIlIIIIlIllllIll) {
        return this.isLegSlot(lllllllllllllIIIlIlIIIIlIllllIll) ? this.modelLeggings : this.modelArmor;
    }
    
    private void renderArmorLayer(final EntityLivingBase lllllllllllllIIIlIlIIIIllIIIllll, final float lllllllllllllIIIlIlIIIIllIlIIlII, final float lllllllllllllIIIlIlIIIIllIlIIIll, final float lllllllllllllIIIlIlIIIIllIlIIIlI, final float lllllllllllllIIIlIlIIIIllIlIIIIl, final float lllllllllllllIIIlIlIIIIllIIIlIlI, final float lllllllllllllIIIlIlIIIIllIIIlIIl, final float lllllllllllllIIIlIlIIIIllIIllllI, final EntityEquipmentSlot lllllllllllllIIIlIlIIIIllIIlllIl) {
        if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && lllllllllllllIIIlIlIIIIllIIIllll instanceof EntityPlayerSP) {
            return;
        }
        final ItemStack lllllllllllllIIIlIlIIIIllIIlllII = lllllllllllllIIIlIlIIIIllIIIllll.getItemStackFromSlot(lllllllllllllIIIlIlIIIIllIIlllIl);
        if (lllllllllllllIIIlIlIIIIllIIlllII.getItem() instanceof ItemArmor) {
            final ItemArmor lllllllllllllIIIlIlIIIIllIIllIll = (ItemArmor)lllllllllllllIIIlIlIIIIllIIlllII.getItem();
            if (lllllllllllllIIIlIlIIIIllIIllIll.getEquipmentSlot() == lllllllllllllIIIlIlIIIIllIIlllIl) {
                T lllllllllllllIIIlIlIIIIllIIllIlI = this.getModelFromSlot(lllllllllllllIIIlIlIIIIllIIlllIl);
                if (Reflector.ForgeHooksClient.exists()) {
                    lllllllllllllIIIlIlIIIIllIIllIlI = this.getArmorModelHook(lllllllllllllIIIlIlIIIIllIIIllll, lllllllllllllIIIlIlIIIIllIIlllII, lllllllllllllIIIlIlIIIIllIIlllIl, lllllllllllllIIIlIlIIIIllIIllIlI);
                }
                lllllllllllllIIIlIlIIIIllIIllIlI.setModelAttributes(this.renderer.getMainModel());
                lllllllllllllIIIlIlIIIIllIIllIlI.setLivingAnimations(lllllllllllllIIIlIlIIIIllIIIllll, lllllllllllllIIIlIlIIIIllIlIIlII, lllllllllllllIIIlIlIIIIllIlIIIll, lllllllllllllIIIlIlIIIIllIlIIIlI);
                this.setModelSlotVisible(lllllllllllllIIIlIlIIIIllIIllIlI, lllllllllllllIIIlIlIIIIllIIlllIl);
                final boolean lllllllllllllIIIlIlIIIIllIIllIIl = this.isLegSlot(lllllllllllllIIIlIlIIIIllIIlllIl);
                if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(lllllllllllllIIIlIlIIIIllIIlllII, lllllllllllllIIIlIlIIIIllIIlllIl, (String)null)) {
                    if (Reflector.ForgeHooksClient_getArmorTexture.exists()) {
                        this.renderer.bindTexture(this.getArmorResource(lllllllllllllIIIlIlIIIIllIIIllll, lllllllllllllIIIlIlIIIIllIIlllII, lllllllllllllIIIlIlIIIIllIIlllIl, null));
                    }
                    else {
                        this.renderer.bindTexture(this.getArmorResource(lllllllllllllIIIlIlIIIIllIIllIll, lllllllllllllIIIlIlIIIIllIIllIIl));
                    }
                }
                if (Reflector.ForgeHooksClient_getArmorTexture.exists()) {
                    if (ReflectorForge.armorHasOverlay(lllllllllllllIIIlIlIIIIllIIllIll, lllllllllllllIIIlIlIIIIllIIlllII)) {
                        final int lllllllllllllIIIlIlIIIIllIIllIII = lllllllllllllIIIlIlIIIIllIIllIll.getColor(lllllllllllllIIIlIlIIIIllIIlllII);
                        final float lllllllllllllIIIlIlIIIIllIIlIlll = (lllllllllllllIIIlIlIIIIllIIllIII >> 16 & 0xFF) / 255.0f;
                        final float lllllllllllllIIIlIlIIIIllIIlIllI = (lllllllllllllIIIlIlIIIIllIIllIII >> 8 & 0xFF) / 255.0f;
                        final float lllllllllllllIIIlIlIIIIllIIlIlIl = (lllllllllllllIIIlIlIIIIllIIllIII & 0xFF) / 255.0f;
                        GlStateManager.color(this.colorR * lllllllllllllIIIlIlIIIIllIIlIlll, this.colorG * lllllllllllllIIIlIlIIIIllIIlIllI, this.colorB * lllllllllllllIIIlIlIIIIllIIlIlIl, this.alpha);
                        lllllllllllllIIIlIlIIIIllIIllIlI.render(lllllllllllllIIIlIlIIIIllIIIllll, lllllllllllllIIIlIlIIIIllIlIIlII, lllllllllllllIIIlIlIIIIllIlIIIll, lllllllllllllIIIlIlIIIIllIlIIIIl, lllllllllllllIIIlIlIIIIllIIIlIlI, lllllllllllllIIIlIlIIIIllIIIlIIl, lllllllllllllIIIlIlIIIIllIIllllI);
                        if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(lllllllllllllIIIlIlIIIIllIIlllII, lllllllllllllIIIlIlIIIIllIIlllIl, "overlay")) {
                            this.renderer.bindTexture(this.getArmorResource(lllllllllllllIIIlIlIIIIllIIIllll, lllllllllllllIIIlIlIIIIllIIlllII, lllllllllllllIIIlIlIIIIllIIlllIl, "overlay"));
                        }
                    }
                    GlStateManager.color(this.colorR, this.colorG, this.colorB, this.alpha);
                    lllllllllllllIIIlIlIIIIllIIllIlI.render(lllllllllllllIIIlIlIIIIllIIIllll, lllllllllllllIIIlIlIIIIllIlIIlII, lllllllllllllIIIlIlIIIIllIlIIIll, lllllllllllllIIIlIlIIIIllIlIIIIl, lllllllllllllIIIlIlIIIIllIIIlIlI, lllllllllllllIIIlIlIIIIllIIIlIIl, lllllllllllllIIIlIlIIIIllIIllllI);
                    if (!this.skipRenderGlint && lllllllllllllIIIlIlIIIIllIIlllII.hasEffect() && (!Config.isCustomItems() || !CustomItems.renderCustomArmorEffect(lllllllllllllIIIlIlIIIIllIIIllll, lllllllllllllIIIlIlIIIIllIIlllII, (ModelBase)lllllllllllllIIIlIlIIIIllIIllIlI, lllllllllllllIIIlIlIIIIllIlIIlII, lllllllllllllIIIlIlIIIIllIlIIIll, lllllllllllllIIIlIlIIIIllIlIIIlI, lllllllllllllIIIlIlIIIIllIlIIIIl, lllllllllllllIIIlIlIIIIllIIIlIlI, lllllllllllllIIIlIlIIIIllIIIlIIl, lllllllllllllIIIlIlIIIIllIIllllI))) {
                        renderEnchantedGlint(this.renderer, lllllllllllllIIIlIlIIIIllIIIllll, lllllllllllllIIIlIlIIIIllIIllIlI, lllllllllllllIIIlIlIIIIllIlIIlII, lllllllllllllIIIlIlIIIIllIlIIIll, lllllllllllllIIIlIlIIIIllIlIIIlI, lllllllllllllIIIlIlIIIIllIlIIIIl, lllllllllllllIIIlIlIIIIllIIIlIlI, lllllllllllllIIIlIlIIIIllIIIlIIl, lllllllllllllIIIlIlIIIIllIIllllI);
                    }
                    return;
                }
                switch ($SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial()[lllllllllllllIIIlIlIIIIllIIllIll.getArmorMaterial().ordinal()]) {
                    case 1: {
                        final int lllllllllllllIIIlIlIIIIllIIlIlII = lllllllllllllIIIlIlIIIIllIIllIll.getColor(lllllllllllllIIIlIlIIIIllIIlllII);
                        final float lllllllllllllIIIlIlIIIIllIIlIIll = (lllllllllllllIIIlIlIIIIllIIlIlII >> 16 & 0xFF) / 255.0f;
                        final float lllllllllllllIIIlIlIIIIllIIlIIlI = (lllllllllllllIIIlIlIIIIllIIlIlII >> 8 & 0xFF) / 255.0f;
                        final float lllllllllllllIIIlIlIIIIllIIlIIIl = (lllllllllllllIIIlIlIIIIllIIlIlII & 0xFF) / 255.0f;
                        GlStateManager.color(this.colorR * lllllllllllllIIIlIlIIIIllIIlIIll, this.colorG * lllllllllllllIIIlIlIIIIllIIlIIlI, this.colorB * lllllllllllllIIIlIlIIIIllIIlIIIl, this.alpha);
                        lllllllllllllIIIlIlIIIIllIIllIlI.render(lllllllllllllIIIlIlIIIIllIIIllll, lllllllllllllIIIlIlIIIIllIlIIlII, lllllllllllllIIIlIlIIIIllIlIIIll, lllllllllllllIIIlIlIIIIllIlIIIIl, lllllllllllllIIIlIlIIIIllIIIlIlI, lllllllllllllIIIlIlIIIIllIIIlIIl, lllllllllllllIIIlIlIIIIllIIllllI);
                        if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(lllllllllllllIIIlIlIIIIllIIlllII, lllllllllllllIIIlIlIIIIllIIlllIl, "overlay")) {
                            this.renderer.bindTexture(this.getArmorResource(lllllllllllllIIIlIlIIIIllIIllIll, lllllllllllllIIIlIlIIIIllIIllIIl, "overlay"));
                        }
                    }
                    case 2:
                    case 3:
                    case 4:
                    case 5: {
                        GlStateManager.color(this.colorR, this.colorG, this.colorB, this.alpha);
                        lllllllllllllIIIlIlIIIIllIIllIlI.render(lllllllllllllIIIlIlIIIIllIIIllll, lllllllllllllIIIlIlIIIIllIlIIlII, lllllllllllllIIIlIlIIIIllIlIIIll, lllllllllllllIIIlIlIIIIllIlIIIIl, lllllllllllllIIIlIlIIIIllIIIlIlI, lllllllllllllIIIlIlIIIIllIIIlIIl, lllllllllllllIIIlIlIIIIllIIllllI);
                        break;
                    }
                }
                if (!this.skipRenderGlint && lllllllllllllIIIlIlIIIIllIIlllII.isItemEnchanted() && (!Config.isCustomItems() || !CustomItems.renderCustomArmorEffect(lllllllllllllIIIlIlIIIIllIIIllll, lllllllllllllIIIlIlIIIIllIIlllII, (ModelBase)lllllllllllllIIIlIlIIIIllIIllIlI, lllllllllllllIIIlIlIIIIllIlIIlII, lllllllllllllIIIlIlIIIIllIlIIIll, lllllllllllllIIIlIlIIIIllIlIIIlI, lllllllllllllIIIlIlIIIIllIlIIIIl, lllllllllllllIIIlIlIIIIllIIIlIlI, lllllllllllllIIIlIlIIIIllIIIlIIl, lllllllllllllIIIlIlIIIIllIIllllI))) {
                    renderEnchantedGlint(this.renderer, lllllllllllllIIIlIlIIIIllIIIllll, lllllllllllllIIIlIlIIIIllIIllIlI, lllllllllllllIIIlIlIIIIllIlIIlII, lllllllllllllIIIlIlIIIIllIlIIIll, lllllllllllllIIIlIlIIIIllIlIIIlI, lllllllllllllIIIlIlIIIIllIlIIIIl, lllllllllllllIIIlIlIIIIllIIIlIlI, lllllllllllllIIIlIlIIIIllIIIlIIl, lllllllllllllIIIlIlIIIIllIIllllI);
                }
            }
        }
    }
    
    protected T getArmorModelHook(final EntityLivingBase lllllllllllllIIIlIlIIIIlIIlIllII, final ItemStack lllllllllllllIIIlIlIIIIlIIlIlIll, final EntityEquipmentSlot lllllllllllllIIIlIlIIIIlIIlIlIlI, final T lllllllllllllIIIlIlIIIIlIIlIlIII) {
        return lllllllllllllIIIlIlIIIIlIIlIlIII;
    }
    
    protected abstract void initArmor();
    
    private ResourceLocation getArmorResource(final ItemArmor lllllllllllllIIIlIlIIIIlIIllIIll, final boolean lllllllllllllIIIlIlIIIIlIIllIIlI, final String lllllllllllllIIIlIlIIIIlIIllIIIl) {
        final String lllllllllllllIIIlIlIIIIlIIllIlIl = String.format("textures/models/armor/%s_layer_%d%s.png", lllllllllllllIIIlIlIIIIlIIllIIll.getArmorMaterial().getName(), lllllllllllllIIIlIlIIIIlIIllIIlI ? 2 : 1, (lllllllllllllIIIlIlIIIIlIIllIIIl == null) ? "" : String.format("_%s", lllllllllllllIIIlIlIIIIlIIllIIIl));
        ResourceLocation lllllllllllllIIIlIlIIIIlIIllIlII = LayerArmorBase.ARMOR_TEXTURE_RES_MAP.get(lllllllllllllIIIlIlIIIIlIIllIlIl);
        if (lllllllllllllIIIlIlIIIIlIIllIlII == null) {
            lllllllllllllIIIlIlIIIIlIIllIlII = new ResourceLocation(lllllllllllllIIIlIlIIIIlIIllIlIl);
            LayerArmorBase.ARMOR_TEXTURE_RES_MAP.put(lllllllllllllIIIlIlIIIIlIIllIlIl, lllllllllllllIIIlIlIIIIlIIllIlII);
        }
        return lllllllllllllIIIlIlIIIIlIIllIlII;
    }
    
    public ResourceLocation getArmorResource(final Entity lllllllllllllIIIlIlIIIIlIIIlIIII, final ItemStack lllllllllllllIIIlIlIIIIlIIIIllll, final EntityEquipmentSlot lllllllllllllIIIlIlIIIIlIIIllIIl, final String lllllllllllllIIIlIlIIIIlIIIllIII) {
        final ItemArmor lllllllllllllIIIlIlIIIIlIIIlIlll = (ItemArmor)lllllllllllllIIIlIlIIIIlIIIIllll.getItem();
        String lllllllllllllIIIlIlIIIIlIIIlIllI = lllllllllllllIIIlIlIIIIlIIIlIlll.getArmorMaterial().getName();
        String lllllllllllllIIIlIlIIIIlIIIlIlIl = "minecraft";
        final int lllllllllllllIIIlIlIIIIlIIIlIlII = lllllllllllllIIIlIlIIIIlIIIlIllI.indexOf(58);
        if (lllllllllllllIIIlIlIIIIlIIIlIlII != -1) {
            lllllllllllllIIIlIlIIIIlIIIlIlIl = lllllllllllllIIIlIlIIIIlIIIlIllI.substring(0, lllllllllllllIIIlIlIIIIlIIIlIlII);
            lllllllllllllIIIlIlIIIIlIIIlIllI = lllllllllllllIIIlIlIIIIlIIIlIllI.substring(lllllllllllllIIIlIlIIIIlIIIlIlII + 1);
        }
        String lllllllllllllIIIlIlIIIIlIIIlIIll = String.format("%s:textures/models/armor/%s_layer_%d%s.png", lllllllllllllIIIlIlIIIIlIIIlIlIl, lllllllllllllIIIlIlIIIIlIIIlIllI, this.isLegSlot(lllllllllllllIIIlIlIIIIlIIIllIIl) ? 2 : 1, (lllllllllllllIIIlIlIIIIlIIIllIII == null) ? "" : String.format("_%s", lllllllllllllIIIlIlIIIIlIIIllIII));
        lllllllllllllIIIlIlIIIIlIIIlIIll = Reflector.callString(Reflector.ForgeHooksClient_getArmorTexture, new Object[] { lllllllllllllIIIlIlIIIIlIIIlIIII, lllllllllllllIIIlIlIIIIlIIIIllll, lllllllllllllIIIlIlIIIIlIIIlIIll, lllllllllllllIIIlIlIIIIlIIIllIIl, lllllllllllllIIIlIlIIIIlIIIllIII });
        ResourceLocation lllllllllllllIIIlIlIIIIlIIIlIIlI = LayerArmorBase.ARMOR_TEXTURE_RES_MAP.get(lllllllllllllIIIlIlIIIIlIIIlIIll);
        if (lllllllllllllIIIlIlIIIIlIIIlIIlI == null) {
            lllllllllllllIIIlIlIIIIlIIIlIIlI = new ResourceLocation(lllllllllllllIIIlIlIIIIlIIIlIIll);
            LayerArmorBase.ARMOR_TEXTURE_RES_MAP.put(lllllllllllllIIIlIlIIIIlIIIlIIll, lllllllllllllIIIlIlIIIIlIIIlIIlI);
        }
        return lllllllllllllIIIlIlIIIIlIIIlIIlI;
    }
    
    protected abstract void setModelSlotVisible(final T p0, final EntityEquipmentSlot p1);
    
    static {
        ENCHANTED_ITEM_GLINT_RES = new ResourceLocation("textures/misc/enchanted_item_glint.png");
        ARMOR_TEXTURE_RES_MAP = Maps.newHashMap();
    }
    
    private boolean isLegSlot(final EntityEquipmentSlot lllllllllllllIIIlIlIIIIlIlllIllI) {
        return lllllllllllllIIIlIlIIIIlIlllIllI == EntityEquipmentSlot.LEGS;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial() {
        final int[] $switch_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial = LayerArmorBase.$SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial;
        if ($switch_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial != null) {
            return $switch_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial;
        }
        final Exception lllllllllllllIIIlIlIIIIlIIIIIlIl = (Object)new int[ItemArmor.ArmorMaterial.values().length];
        try {
            lllllllllllllIIIlIlIIIIlIIIIIlIl[ItemArmor.ArmorMaterial.CHAIN.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIlIlIIIIlIIIIIlIl[ItemArmor.ArmorMaterial.DIAMOND.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIlIlIIIIlIIIIIlIl[ItemArmor.ArmorMaterial.GOLD.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIlIlIIIIlIIIIIlIl[ItemArmor.ArmorMaterial.IRON.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIIlIlIIIIlIIIIIlIl[ItemArmor.ArmorMaterial.LEATHER.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return LayerArmorBase.$SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial = (int[])(Object)lllllllllllllIIIlIlIIIIlIIIIIlIl;
    }
    
    public static void renderEnchantedGlint(final RenderLivingBase<?> lllllllllllllIIIlIlIIIIlIllIIlIl, final EntityLivingBase lllllllllllllIIIlIlIIIIlIlIlIlIl, final ModelBase lllllllllllllIIIlIlIIIIlIllIIIll, final float lllllllllllllIIIlIlIIIIlIlIlIIll, final float lllllllllllllIIIlIlIIIIlIlIlIIlI, final float lllllllllllllIIIlIlIIIIlIlIlIIIl, final float lllllllllllllIIIlIlIIIIlIlIlIIII, final float lllllllllllllIIIlIlIIIIlIlIllllI, final float lllllllllllllIIIlIlIIIIlIlIIlllI, final float lllllllllllllIIIlIlIIIIlIlIlllII) {
        if (!Config.isShaders() || !Shaders.isShadowPass) {
            final float lllllllllllllIIIlIlIIIIlIlIllIll = lllllllllllllIIIlIlIIIIlIlIlIlIl.ticksExisted + lllllllllllllIIIlIlIIIIlIlIlIIIl;
            lllllllllllllIIIlIlIIIIlIllIIlIl.bindTexture(LayerArmorBase.ENCHANTED_ITEM_GLINT_RES);
            if (Config.isShaders()) {
                ShadersRender.renderEnchantedGlintBegin();
            }
            Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
            GlStateManager.enableBlend();
            GlStateManager.depthFunc(514);
            GlStateManager.depthMask(false);
            final float lllllllllllllIIIlIlIIIIlIlIllIlI = 0.5f;
            GlStateManager.color(0.5f, 0.5f, 0.5f, 1.0f);
            for (int lllllllllllllIIIlIlIIIIlIlIllIIl = 0; lllllllllllllIIIlIlIIIIlIlIllIIl < 2; ++lllllllllllllIIIlIlIIIIlIlIllIIl) {
                GlStateManager.disableLighting();
                GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_COLOR, GlStateManager.DestFactor.ONE);
                final float lllllllllllllIIIlIlIIIIlIlIllIII = 0.76f;
                GlStateManager.color(0.38f, 0.19f, 0.608f, 1.0f);
                GlStateManager.matrixMode(5890);
                GlStateManager.loadIdentity();
                final float lllllllllllllIIIlIlIIIIlIlIlIlll = 0.33333334f;
                GlStateManager.scale(0.33333334f, 0.33333334f, 0.33333334f);
                GlStateManager.rotate(30.0f - lllllllllllllIIIlIlIIIIlIlIllIIl * 60.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.translate(0.0f, lllllllllllllIIIlIlIIIIlIlIllIll * (0.001f + lllllllllllllIIIlIlIIIIlIlIllIIl * 0.003f) * 20.0f, 0.0f);
                GlStateManager.matrixMode(5888);
                lllllllllllllIIIlIlIIIIlIllIIIll.render(lllllllllllllIIIlIlIIIIlIlIlIlIl, lllllllllllllIIIlIlIIIIlIlIlIIll, lllllllllllllIIIlIlIIIIlIlIlIIlI, lllllllllllllIIIlIlIIIIlIlIlIIII, lllllllllllllIIIlIlIIIIlIlIllllI, lllllllllllllIIIlIlIIIIlIlIIlllI, lllllllllllllIIIlIlIIIIlIlIlllII);
                GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            }
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.depthMask(true);
            GlStateManager.depthFunc(515);
            GlStateManager.disableBlend();
            Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
            if (Config.isShaders()) {
                ShadersRender.renderEnchantedGlintEnd();
            }
        }
    }
}
