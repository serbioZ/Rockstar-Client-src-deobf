// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import com.google.common.collect.Lists;
import net.minecraft.item.ItemBanner;
import javax.annotation.Nullable;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.nbt.NBTTagList;
import java.util.List;
import net.minecraft.world.IWorldNameable;

public class TileEntityBanner extends TileEntity implements IWorldNameable
{
    private /* synthetic */ List<BannerPattern> patternList;
    private /* synthetic */ boolean patternDataSet;
    private /* synthetic */ String patternResourceLocation;
    private /* synthetic */ NBTTagList patterns;
    private /* synthetic */ EnumDyeColor baseColor;
    private /* synthetic */ List<EnumDyeColor> colorList;
    private /* synthetic */ String field_190617_a;
    
    public List<BannerPattern> getPatternList() {
        this.initializeBannerData();
        return this.patternList;
    }
    
    public static void removeBannerData(final ItemStack llllllllllIlllIllIIllllllIlIllIl) {
        final NBTTagCompound llllllllllIlllIllIIllllllIlIllll = llllllllllIlllIllIIllllllIlIllIl.getSubCompound("BlockEntityTag");
        if (llllllllllIlllIllIIllllllIlIllll != null && llllllllllIlllIllIIllllllIlIllll.hasKey("Patterns", 9)) {
            final NBTTagList llllllllllIlllIllIIllllllIlIlllI = llllllllllIlllIllIIllllllIlIllll.getTagList("Patterns", 10);
            if (!llllllllllIlllIllIIllllllIlIlllI.hasNoTags()) {
                llllllllllIlllIllIIllllllIlIlllI.removeTag(llllllllllIlllIllIIllllllIlIlllI.tagCount() - 1);
                if (llllllllllIlllIllIIllllllIlIlllI.hasNoTags()) {
                    llllllllllIlllIllIIllllllIlIllIl.getTagCompound().removeTag("BlockEntityTag");
                    if (llllllllllIlllIllIIllllllIlIllIl.getTagCompound().hasNoTags()) {
                        llllllllllIlllIllIIllllllIlIllIl.setTagCompound(null);
                    }
                }
            }
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllIlllIllIIlllllllIllllI) {
        super.writeToNBT(llllllllllIlllIllIIlllllllIllllI);
        llllllllllIlllIllIIlllllllIllllI.setInteger("Base", this.baseColor.getDyeDamage());
        if (this.patterns != null) {
            llllllllllIlllIllIIlllllllIllllI.setTag("Patterns", this.patterns);
        }
        if (this.hasCustomName()) {
            llllllllllIlllIllIIlllllllIllllI.setString("CustomName", this.field_190617_a);
        }
        return llllllllllIlllIllIIlllllllIllllI;
    }
    
    public static int getPatterns(final ItemStack llllllllllIlllIllIIlllllllIIllIl) {
        final NBTTagCompound llllllllllIlllIllIIlllllllIIlllI = llllllllllIlllIllIIlllllllIIllIl.getSubCompound("BlockEntityTag");
        return (llllllllllIlllIllIIlllllllIIlllI != null && llllllllllIlllIllIIlllllllIIlllI.hasKey("Patterns")) ? llllllllllIlllIllIIlllllllIIlllI.getTagList("Patterns", 10).tagCount() : 0;
    }
    
    public List<EnumDyeColor> getColorList() {
        this.initializeBannerData();
        return this.colorList;
    }
    
    public TileEntityBanner() {
        this.baseColor = EnumDyeColor.BLACK;
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 6, this.getUpdateTag());
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_190617_a : "banner";
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllIlllIllIIlllllllIllIII) {
        super.readFromNBT(llllllllllIlllIllIIlllllllIllIII);
        if (llllllllllIlllIllIIlllllllIllIII.hasKey("CustomName", 8)) {
            this.field_190617_a = llllllllllIlllIllIIlllllllIllIII.getString("CustomName");
        }
        this.baseColor = EnumDyeColor.byDyeDamage(llllllllllIlllIllIIlllllllIllIII.getInteger("Base"));
        this.patterns = llllllllllIlllIllIIlllllllIllIII.getTagList("Patterns", 10);
        this.patternList = null;
        this.colorList = null;
        this.patternResourceLocation = null;
        this.patternDataSet = true;
    }
    
    public static EnumDyeColor func_190616_d(final ItemStack llllllllllIlllIllIIllllllIlIIIII) {
        final NBTTagCompound llllllllllIlllIllIIllllllIlIIIIl = llllllllllIlllIllIIllllllIlIIIII.getSubCompound("BlockEntityTag");
        return (llllllllllIlllIllIIllllllIlIIIIl != null && llllllllllIlllIllIIllllllIlIIIIl.hasKey("Base")) ? EnumDyeColor.byDyeDamage(llllllllllIlllIllIIllllllIlIIIIl.getInteger("Base")) : EnumDyeColor.BLACK;
    }
    
    public void setItemValues(final ItemStack llllllllllIlllIllIIlllllllllIIll, final boolean llllllllllIlllIllIIllllllllIlllI) {
        this.patterns = null;
        final NBTTagCompound llllllllllIlllIllIIlllllllllIIIl = llllllllllIlllIllIIlllllllllIIll.getSubCompound("BlockEntityTag");
        if (llllllllllIlllIllIIlllllllllIIIl != null && llllllllllIlllIllIIlllllllllIIIl.hasKey("Patterns", 9)) {
            this.patterns = llllllllllIlllIllIIlllllllllIIIl.getTagList("Patterns", 10).copy();
        }
        this.baseColor = (llllllllllIlllIllIIllllllllIlllI ? func_190616_d(llllllllllIlllIllIIlllllllllIIll) : ItemBanner.getBaseColor(llllllllllIlllIllIIlllllllllIIll));
        this.patternList = null;
        this.colorList = null;
        this.patternResourceLocation = "";
        this.patternDataSet = true;
        this.field_190617_a = (llllllllllIlllIllIIlllllllllIIll.hasDisplayName() ? llllllllllIlllIllIIlllllllllIIll.getDisplayName() : null);
    }
    
    public ItemStack func_190615_l() {
        final ItemStack llllllllllIlllIllIIllllllIlIIlll = ItemBanner.func_190910_a(this.baseColor, this.patterns);
        if (this.hasCustomName()) {
            llllllllllIlllIllIIllllllIlIIlll.setStackDisplayName(this.getName());
        }
        return llllllllllIlllIllIIllllllIlIIlll;
    }
    
    private void initializeBannerData() {
        if (this.patternList == null || this.colorList == null || this.patternResourceLocation == null) {
            if (!this.patternDataSet) {
                this.patternResourceLocation = "";
            }
            else {
                this.patternList = (List<BannerPattern>)Lists.newArrayList();
                this.colorList = (List<EnumDyeColor>)Lists.newArrayList();
                this.patternList.add(BannerPattern.BASE);
                this.colorList.add(this.baseColor);
                this.patternResourceLocation = "b" + this.baseColor.getDyeDamage();
                if (this.patterns != null) {
                    for (int llllllllllIlllIllIIllllllIllllII = 0; llllllllllIlllIllIIllllllIllllII < this.patterns.tagCount(); ++llllllllllIlllIllIIllllllIllllII) {
                        final NBTTagCompound llllllllllIlllIllIIllllllIlllIll = this.patterns.getCompoundTagAt(llllllllllIlllIllIIllllllIllllII);
                        final BannerPattern llllllllllIlllIllIIllllllIlllIlI = BannerPattern.func_190994_a(llllllllllIlllIllIIllllllIlllIll.getString("Pattern"));
                        if (llllllllllIlllIllIIllllllIlllIlI != null) {
                            this.patternList.add(llllllllllIlllIllIIllllllIlllIlI);
                            final int llllllllllIlllIllIIllllllIlllIIl = llllllllllIlllIllIIllllllIlllIll.getInteger("Color");
                            this.colorList.add(EnumDyeColor.byDyeDamage(llllllllllIlllIllIIllllllIlllIIl));
                            this.patternResourceLocation = String.valueOf(this.patternResourceLocation) + llllllllllIlllIllIIllllllIlllIlI.func_190993_b() + llllllllllIlllIllIIllllllIlllIIl;
                        }
                    }
                }
            }
        }
    }
    
    public String getPatternResourceLocation() {
        this.initializeBannerData();
        return this.patternResourceLocation;
    }
    
    @Override
    public boolean hasCustomName() {
        return this.field_190617_a != null && !this.field_190617_a.isEmpty();
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
}
