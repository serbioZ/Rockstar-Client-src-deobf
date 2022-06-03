// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.Blocks;
import java.util.Collection;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import javax.annotation.Nullable;
import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.PropertyEnum;

public abstract class BlockFlower extends BlockBush
{
    protected /* synthetic */ PropertyEnum<EnumFlowerType> type;
    
    public abstract EnumFlowerColor getBlockType();
    
    @Override
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.XZ;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { this.getTypeProperty() });
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlIlllIIlllIllllIIlll) {
        return lllllllllllIlIlllIIlllIllllIIlll.getValue(this.getTypeProperty()).getMeta();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIlIlllIIlllIlllllIIlI) {
        return this.getDefaultState().withProperty(this.getTypeProperty(), EnumFlowerType.getType(this.getBlockType(), lllllllllllIlIlllIIlllIlllllIIlI));
    }
    
    protected BlockFlower() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getTypeProperty(), (this.getBlockType() == EnumFlowerColor.RED) ? EnumFlowerType.POPPY : EnumFlowerType.DANDELION));
    }
    
    public IProperty<EnumFlowerType> getTypeProperty() {
        if (this.type == null) {
            this.type = PropertyEnum.create("type", EnumFlowerType.class, (com.google.common.base.Predicate<EnumFlowerType>)new Predicate<EnumFlowerType>() {
                public boolean apply(@Nullable final EnumFlowerType llllllllllllllIlIIllllIlIlIlIlIl) {
                    return llllllllllllllIlIIllllIlIlIlIlIl.getBlockType() == BlockFlower.this.getBlockType();
                }
            });
        }
        return this.type;
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllIlIlllIIlllIllllllllI, final NonNullList<ItemStack> lllllllllllIlIlllIIlllIllllllIlI) {
        final byte lllllllllllIlIlllIIlllIlllllIllI;
        final char lllllllllllIlIlllIIlllIlllllIlll = (char)((EnumFlowerType[])(Object)(lllllllllllIlIlllIIlllIlllllIllI = (byte)(Object)EnumFlowerType.getTypes(this.getBlockType()))).length;
        for (float lllllllllllIlIlllIIlllIllllllIII = 0; lllllllllllIlIlllIIlllIllllllIII < lllllllllllIlIlllIIlllIlllllIlll; ++lllllllllllIlIlllIIlllIllllllIII) {
            final EnumFlowerType lllllllllllIlIlllIIlllIlllllllII = lllllllllllIlIlllIIlllIlllllIllI[lllllllllllIlIlllIIlllIllllllIII];
            lllllllllllIlIlllIIlllIllllllIlI.add(new ItemStack(this, 1, lllllllllllIlIlllIIlllIlllllllII.getMeta()));
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlIlllIIllllIIIIlIIlI, final IBlockAccess lllllllllllIlIlllIIllllIIIIlIIIl, final BlockPos lllllllllllIlIlllIIllllIIIIIllII) {
        return super.getBoundingBox(lllllllllllIlIlllIIllllIIIIlIIlI, lllllllllllIlIlllIIllllIIIIlIIIl, lllllllllllIlIlllIIllllIIIIIllII).func_191194_a(lllllllllllIlIlllIIllllIIIIlIIlI.func_191059_e(lllllllllllIlIlllIIllllIIIIlIIIl, lllllllllllIlIlllIIllllIIIIIllII));
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllIlIlllIIllllIIIIIlIII) {
        return lllllllllllIlIlllIIllllIIIIIlIII.getValue(this.getTypeProperty()).getMeta();
    }
    
    public enum EnumFlowerType implements IStringSerializable
    {
        OXEYE_DAISY("OXEYE_DAISY", 9, EnumFlowerColor.RED, 8, "oxeye_daisy", "oxeyeDaisy");
        
        private static final /* synthetic */ EnumFlowerType[][] TYPES_FOR_BLOCK;
        private final /* synthetic */ String name;
        
        PINK_TULIP("PINK_TULIP", 8, EnumFlowerColor.RED, 7, "pink_tulip", "tulipPink"), 
        DANDELION("DANDELION", 0, EnumFlowerColor.YELLOW, 0, "dandelion"), 
        ORANGE_TULIP("ORANGE_TULIP", 6, EnumFlowerColor.RED, 5, "orange_tulip", "tulipOrange"), 
        WHITE_TULIP("WHITE_TULIP", 7, EnumFlowerColor.RED, 6, "white_tulip", "tulipWhite"), 
        RED_TULIP("RED_TULIP", 5, EnumFlowerColor.RED, 4, "red_tulip", "tulipRed");
        
        private final /* synthetic */ String unlocalizedName;
        private final /* synthetic */ EnumFlowerColor blockType;
        
        ALLIUM("ALLIUM", 3, EnumFlowerColor.RED, 2, "allium"), 
        POPPY("POPPY", 1, EnumFlowerColor.RED, 0, "poppy"), 
        BLUE_ORCHID("BLUE_ORCHID", 2, EnumFlowerColor.RED, 1, "blue_orchid", "blueOrchid"), 
        HOUSTONIA("HOUSTONIA", 4, EnumFlowerColor.RED, 3, "houstonia");
        
        private final /* synthetic */ int meta;
        
        private EnumFlowerType(final String llllllllllllIlIlIlllIIllllIlIIII, final int llllllllllllIlIlIlllIIllllIIllll, final EnumFlowerColor llllllllllllIlIlIlllIIllllIlIlII, final int llllllllllllIlIlIlllIIllllIlIIll, final String llllllllllllIlIlIlllIIllllIlIIlI) {
            this(llllllllllllIlIlIlllIIllllIlIIII, llllllllllllIlIlIlllIIllllIIllll, llllllllllllIlIlIlllIIllllIlIlII, llllllllllllIlIlIlllIIllllIlIIll, llllllllllllIlIlIlllIIllllIlIIlI, llllllllllllIlIlIlllIIllllIlIIlI);
        }
        
        static {
            TYPES_FOR_BLOCK = new EnumFlowerType[EnumFlowerColor.values().length][];
            final int llllllllllllIlIlIlllIIllllIlllIl;
            final Exception llllllllllllIlIlIlllIIllllIllllI = (Exception)((EnumFlowerColor[])(Object)(llllllllllllIlIlIlllIIllllIlllIl = (int)(Object)EnumFlowerColor.values())).length;
            for (byte llllllllllllIlIlIlllIIllllIlllll = 0; llllllllllllIlIlIlllIIllllIlllll < llllllllllllIlIlIlllIIllllIllllI; ++llllllllllllIlIlIlllIIllllIlllll) {
                final EnumFlowerColor llllllllllllIlIlIlllIIlllllIIIlI = llllllllllllIlIlIlllIIllllIlllIl[llllllllllllIlIlIlllIIllllIlllll];
                final Collection<EnumFlowerType> llllllllllllIlIlIlllIIlllllIIIIl = (Collection<EnumFlowerType>)Collections2.filter((Collection)Lists.newArrayList((Object[])values()), (Predicate)new Predicate<EnumFlowerType>() {
                    private final /* synthetic */ EnumFlowerColor val$blockflower$enumflowercolor;
                    
                    public boolean apply(@Nullable final EnumFlowerType llllllllllIlllllIIIlIIlllllIIIll) {
                        return llllllllllIlllllIIIlIIlllllIIIll.getBlockType() == this.val$blockflower$enumflowercolor;
                    }
                });
                EnumFlowerType.TYPES_FOR_BLOCK[llllllllllllIlIlIlllIIlllllIIIlI.ordinal()] = llllllllllllIlIlIlllIIlllllIIIIl.toArray(new EnumFlowerType[llllllllllllIlIlIlllIIlllllIIIIl.size()]);
            }
        }
        
        public EnumFlowerColor getBlockType() {
            return this.blockType;
        }
        
        public static EnumFlowerType[] getTypes(final EnumFlowerColor llllllllllllIlIlIlllIIlllIlIIlll) {
            return EnumFlowerType.TYPES_FOR_BLOCK[llllllllllllIlIlIlllIIlllIlIIlll.ordinal()];
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        private EnumFlowerType(final String llllllllllllIlIlIlllIIlllIlllllI, final int llllllllllllIlIlIlllIIlllIllllIl, final EnumFlowerColor llllllllllllIlIlIlllIIllllIIIIll, final int llllllllllllIlIlIlllIIllllIIIIlI, final String llllllllllllIlIlIlllIIllllIIIIIl, final String llllllllllllIlIlIlllIIlllIlllIIl) {
            this.blockType = llllllllllllIlIlIlllIIllllIIIIll;
            this.meta = llllllllllllIlIlIlllIIllllIIIIlI;
            this.name = llllllllllllIlIlIlllIIllllIIIIIl;
            this.unlocalizedName = llllllllllllIlIlIlllIIlllIlllIIl;
        }
        
        public static EnumFlowerType getType(final EnumFlowerColor llllllllllllIlIlIlllIIlllIlIllll, int llllllllllllIlIlIlllIIlllIlIlIll) {
            final EnumFlowerType[] llllllllllllIlIlIlllIIlllIlIllIl = EnumFlowerType.TYPES_FOR_BLOCK[llllllllllllIlIlIlllIIlllIlIllll.ordinal()];
            if (llllllllllllIlIlIlllIIlllIlIlIll < 0 || llllllllllllIlIlIlllIIlllIlIlIll >= llllllllllllIlIlIlllIIlllIlIllIl.length) {
                llllllllllllIlIlIlllIIlllIlIlIll = 0;
            }
            return llllllllllllIlIlIlllIIlllIlIllIl[llllllllllllIlIlIlllIIlllIlIlIll];
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public int getMeta() {
            return this.meta;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
    
    public enum EnumFlowerColor
    {
        YELLOW("YELLOW", 0), 
        RED("RED", 1);
        
        private EnumFlowerColor(final String lllllllllllIIIIlIlIIlIlIlIIlllII, final int lllllllllllIIIIlIlIIlIlIlIIllIll) {
        }
        
        public BlockFlower getBlock() {
            return (this == EnumFlowerColor.YELLOW) ? Blocks.YELLOW_FLOWER : Blocks.RED_FLOWER;
        }
    }
}
