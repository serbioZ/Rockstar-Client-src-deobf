// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import java.util.UUID;
import com.mojang.authlib.GameProfile;
import org.apache.commons.lang3.StringUtils;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.BannerTextures;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.init.Items;
import net.minecraft.block.BlockChest;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.client.model.ModelShield;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.tileentity.TileEntityBanner;

public class TileEntityItemStackRenderer
{
    private final /* synthetic */ TileEntityBanner banner;
    private final /* synthetic */ TileEntityBed field_193843_g;
    private final /* synthetic */ TileEntityEnderChest enderChest;
    private final /* synthetic */ TileEntityChest chestBasic;
    private final /* synthetic */ TileEntitySkull skull;
    private final /* synthetic */ ModelShield modelShield;
    public static /* synthetic */ TileEntityItemStackRenderer instance;
    private final /* synthetic */ TileEntityChest chestTrap;
    private static final /* synthetic */ TileEntityShulkerBox[] field_191274_b;
    
    public void renderByItem(final ItemStack lllllllllllIIlIIllllllIlIIllIIll) {
        this.func_192838_a(lllllllllllIIlIIllllllIlIIllIIll, 1.0f);
    }
    
    public TileEntityItemStackRenderer() {
        this.chestBasic = new TileEntityChest(BlockChest.Type.BASIC);
        this.chestTrap = new TileEntityChest(BlockChest.Type.TRAP);
        this.enderChest = new TileEntityEnderChest();
        this.banner = new TileEntityBanner();
        this.field_193843_g = new TileEntityBed();
        this.skull = new TileEntitySkull();
        this.modelShield = new ModelShield();
    }
    
    public void func_192838_a(final ItemStack lllllllllllIIlIIllllllIlIIlIlIII, final float lllllllllllIIlIIllllllIlIIlIIlll) {
        final Item lllllllllllIIlIIllllllIlIIlIIllI = lllllllllllIIlIIllllllIlIIlIlIII.getItem();
        if (lllllllllllIIlIIllllllIlIIlIIllI == Items.BANNER) {
            this.banner.setItemValues(lllllllllllIIlIIllllllIlIIlIlIII, false);
            TileEntityRendererDispatcher.instance.func_192855_a(this.banner, 0.0, 0.0, 0.0, 0.0f, lllllllllllIIlIIllllllIlIIlIIlll);
        }
        else if (lllllllllllIIlIIllllllIlIIlIIllI == Items.BED) {
            this.field_193843_g.func_193051_a(lllllllllllIIlIIllllllIlIIlIlIII);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.field_193843_g, 0.0, 0.0, 0.0, 0.0f);
        }
        else if (lllllllllllIIlIIllllllIlIIlIIllI == Items.SHIELD) {
            if (lllllllllllIIlIIllllllIlIIlIlIII.getSubCompound("BlockEntityTag") != null) {
                this.banner.setItemValues(lllllllllllIIlIIllllllIlIIlIlIII, true);
                Minecraft.getMinecraft().getTextureManager().bindTexture(BannerTextures.SHIELD_DESIGNS.getResourceLocation(this.banner.getPatternResourceLocation(), this.banner.getPatternList(), this.banner.getColorList()));
            }
            else {
                Minecraft.getMinecraft().getTextureManager().bindTexture(BannerTextures.SHIELD_BASE_TEXTURE);
            }
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0f, -1.0f, -1.0f);
            this.modelShield.render();
            GlStateManager.popMatrix();
        }
        else if (lllllllllllIIlIIllllllIlIIlIIllI == Items.SKULL) {
            GameProfile lllllllllllIIlIIllllllIlIIlIIlIl = null;
            if (lllllllllllIIlIIllllllIlIIlIlIII.hasTagCompound()) {
                final NBTTagCompound lllllllllllIIlIIllllllIlIIlIIlII = lllllllllllIIlIIllllllIlIIlIlIII.getTagCompound();
                if (lllllllllllIIlIIllllllIlIIlIIlII.hasKey("SkullOwner", 10)) {
                    lllllllllllIIlIIllllllIlIIlIIlIl = NBTUtil.readGameProfileFromNBT(lllllllllllIIlIIllllllIlIIlIIlII.getCompoundTag("SkullOwner"));
                }
                else if (lllllllllllIIlIIllllllIlIIlIIlII.hasKey("SkullOwner", 8) && !StringUtils.isBlank((CharSequence)lllllllllllIIlIIllllllIlIIlIIlII.getString("SkullOwner"))) {
                    final GameProfile lllllllllllIIlIIllllllIlIIlIIIll = new GameProfile((UUID)null, lllllllllllIIlIIllllllIlIIlIIlII.getString("SkullOwner"));
                    lllllllllllIIlIIllllllIlIIlIIlIl = TileEntitySkull.updateGameprofile(lllllllllllIIlIIllllllIlIIlIIIll);
                    lllllllllllIIlIIllllllIlIIlIIlII.removeTag("SkullOwner");
                    lllllllllllIIlIIllllllIlIIlIIlII.setTag("SkullOwner", NBTUtil.writeGameProfile(new NBTTagCompound(), lllllllllllIIlIIllllllIlIIlIIlIl));
                }
            }
            if (TileEntitySkullRenderer.instance != null) {
                GlStateManager.pushMatrix();
                GlStateManager.disableCull();
                TileEntitySkullRenderer.instance.renderSkull(0.0f, 0.0f, 0.0f, EnumFacing.UP, 180.0f, lllllllllllIIlIIllllllIlIIlIlIII.getMetadata(), lllllllllllIIlIIllllllIlIIlIIlIl, -1, 0.0f);
                GlStateManager.enableCull();
                GlStateManager.popMatrix();
            }
        }
        else if (lllllllllllIIlIIllllllIlIIlIIllI == Item.getItemFromBlock(Blocks.ENDER_CHEST)) {
            TileEntityRendererDispatcher.instance.func_192855_a(this.enderChest, 0.0, 0.0, 0.0, 0.0f, lllllllllllIIlIIllllllIlIIlIIlll);
        }
        else if (lllllllllllIIlIIllllllIlIIlIIllI == Item.getItemFromBlock(Blocks.TRAPPED_CHEST)) {
            TileEntityRendererDispatcher.instance.func_192855_a(this.chestTrap, 0.0, 0.0, 0.0, 0.0f, lllllllllllIIlIIllllllIlIIlIIlll);
        }
        else if (Block.getBlockFromItem(lllllllllllIIlIIllllllIlIIlIIllI) instanceof BlockShulkerBox) {
            TileEntityRendererDispatcher.instance.func_192855_a(TileEntityItemStackRenderer.field_191274_b[BlockShulkerBox.func_190955_b(lllllllllllIIlIIllllllIlIIlIIllI).getMetadata()], 0.0, 0.0, 0.0, 0.0f, lllllllllllIIlIIllllllIlIIlIIlll);
        }
        else {
            TileEntityRendererDispatcher.instance.func_192855_a(this.chestBasic, 0.0, 0.0, 0.0, 0.0f, lllllllllllIIlIIllllllIlIIlIIlll);
        }
    }
    
    static {
        field_191274_b = new TileEntityShulkerBox[16];
        final float lllllllllllIIlIIllllllIlIIlllIlI;
        final Exception lllllllllllIIlIIllllllIlIIlllIll = (Exception)((EnumDyeColor[])(Object)(lllllllllllIIlIIllllllIlIIlllIlI = (float)(Object)EnumDyeColor.values())).length;
        for (String lllllllllllIIlIIllllllIlIIllllII = (String)0; lllllllllllIIlIIllllllIlIIllllII < lllllllllllIIlIIllllllIlIIlllIll; ++lllllllllllIIlIIllllllIlIIllllII) {
            final EnumDyeColor lllllllllllIIlIIllllllIlIIlllllI = lllllllllllIIlIIllllllIlIIlllIlI[lllllllllllIIlIIllllllIlIIllllII];
            TileEntityItemStackRenderer.field_191274_b[lllllllllllIIlIIllllllIlIIlllllI.getMetadata()] = new TileEntityShulkerBox(lllllllllllIIlIIllllllIlIIlllllI);
        }
        TileEntityItemStackRenderer.instance = new TileEntityItemStackRenderer();
    }
}
