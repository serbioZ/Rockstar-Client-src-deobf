// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntitySkull;
import java.util.UUID;
import com.mojang.authlib.GameProfile;
import org.apache.commons.lang3.StringUtils;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.init.Items;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLivingBase;

public class LayerCustomHead implements LayerRenderer<EntityLivingBase>
{
    private final /* synthetic */ ModelRenderer modelRenderer;
    
    public LayerCustomHead(final ModelRenderer lllllllllllIIlIlIlIlIIlIlllIllII) {
        this.modelRenderer = lllllllllllIIlIlIlIlIIlIlllIllII;
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllIIlIlIlIlIIlIllIIlIIl, final float lllllllllllIIlIlIlIlIIlIllIlllIl, final float lllllllllllIIlIlIlIlIIlIllIlllII, final float lllllllllllIIlIlIlIlIIlIllIllIll, final float lllllllllllIIlIlIlIlIIlIllIllIlI, final float lllllllllllIIlIlIlIlIIlIllIllIIl, final float lllllllllllIIlIlIlIlIIlIllIllIII, final float lllllllllllIIlIlIlIlIIlIllIIIlll) {
        final ItemStack lllllllllllIIlIlIlIlIIlIllIlIllI = lllllllllllIIlIlIlIlIIlIllIIlIIl.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        if (!lllllllllllIIlIlIlIlIIlIllIlIllI.func_190926_b()) {
            final Item lllllllllllIIlIlIlIlIIlIllIlIlIl = lllllllllllIIlIlIlIlIIlIllIlIllI.getItem();
            final Minecraft lllllllllllIIlIlIlIlIIlIllIlIlII = Minecraft.getMinecraft();
            GlStateManager.pushMatrix();
            if (lllllllllllIIlIlIlIlIIlIllIIlIIl.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            final boolean lllllllllllIIlIlIlIlIIlIllIlIIll = lllllllllllIIlIlIlIlIIlIllIIlIIl instanceof EntityVillager || lllllllllllIIlIlIlIlIIlIllIIlIIl instanceof EntityZombieVillager;
            if (lllllllllllIIlIlIlIlIIlIllIIlIIl.isChild() && !(lllllllllllIIlIlIlIlIIlIllIIlIIl instanceof EntityVillager)) {
                final float lllllllllllIIlIlIlIlIIlIllIlIIlI = 2.0f;
                final float lllllllllllIIlIlIlIlIIlIllIlIIIl = 1.4f;
                GlStateManager.translate(0.0f, 0.5f * lllllllllllIIlIlIlIlIIlIllIIIlll, 0.0f);
                GlStateManager.scale(0.7f, 0.7f, 0.7f);
                GlStateManager.translate(0.0f, 16.0f * lllllllllllIIlIlIlIlIIlIllIIIlll, 0.0f);
            }
            this.modelRenderer.postRender(0.0625f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            if (lllllllllllIIlIlIlIlIIlIllIlIlIl == Items.SKULL) {
                final float lllllllllllIIlIlIlIlIIlIllIlIIII = 1.1875f;
                GlStateManager.scale(1.1875f, -1.1875f, -1.1875f);
                if (lllllllllllIIlIlIlIlIIlIllIlIIll) {
                    GlStateManager.translate(0.0f, 0.0625f, 0.0f);
                }
                GameProfile lllllllllllIIlIlIlIlIIlIllIIllll = null;
                if (lllllllllllIIlIlIlIlIIlIllIlIllI.hasTagCompound()) {
                    final NBTTagCompound lllllllllllIIlIlIlIlIIlIllIIlllI = lllllllllllIIlIlIlIlIIlIllIlIllI.getTagCompound();
                    if (lllllllllllIIlIlIlIlIIlIllIIlllI.hasKey("SkullOwner", 10)) {
                        lllllllllllIIlIlIlIlIIlIllIIllll = NBTUtil.readGameProfileFromNBT(lllllllllllIIlIlIlIlIIlIllIIlllI.getCompoundTag("SkullOwner"));
                    }
                    else if (lllllllllllIIlIlIlIlIIlIllIIlllI.hasKey("SkullOwner", 8)) {
                        final String lllllllllllIIlIlIlIlIIlIllIIllIl = lllllllllllIIlIlIlIlIIlIllIIlllI.getString("SkullOwner");
                        if (!StringUtils.isBlank((CharSequence)lllllllllllIIlIlIlIlIIlIllIIllIl)) {
                            lllllllllllIIlIlIlIlIIlIllIIllll = TileEntitySkull.updateGameprofile(new GameProfile((UUID)null, lllllllllllIIlIlIlIlIIlIllIIllIl));
                            lllllllllllIIlIlIlIlIIlIllIIlllI.setTag("SkullOwner", NBTUtil.writeGameProfile(new NBTTagCompound(), lllllllllllIIlIlIlIlIIlIllIIllll));
                        }
                    }
                }
                TileEntitySkullRenderer.instance.renderSkull(-0.5f, 0.0f, -0.5f, EnumFacing.UP, 180.0f, lllllllllllIIlIlIlIlIIlIllIlIllI.getMetadata(), lllllllllllIIlIlIlIlIIlIllIIllll, -1, lllllllllllIIlIlIlIlIIlIllIlllIl);
            }
            else if (!(lllllllllllIIlIlIlIlIIlIllIlIlIl instanceof ItemArmor) || ((ItemArmor)lllllllllllIIlIlIlIlIIlIllIlIlIl).getEquipmentSlot() != EntityEquipmentSlot.HEAD) {
                final float lllllllllllIIlIlIlIlIIlIllIIllII = 0.625f;
                GlStateManager.translate(0.0f, -0.25f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.scale(0.625f, -0.625f, -0.625f);
                if (lllllllllllIIlIlIlIlIIlIllIlIIll) {
                    GlStateManager.translate(0.0f, 0.1875f, 0.0f);
                }
                lllllllllllIIlIlIlIlIIlIllIlIlII.getItemRenderer().renderItem(lllllllllllIIlIlIlIlIIlIllIIlIIl, lllllllllllIIlIlIlIlIIlIllIlIllI, ItemCameraTransforms.TransformType.HEAD);
            }
            GlStateManager.popMatrix();
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
