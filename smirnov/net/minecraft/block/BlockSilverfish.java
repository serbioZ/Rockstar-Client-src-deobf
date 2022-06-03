// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.block.state.BlockStateContainer;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.util.NonNullList;
import net.minecraft.init.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;

public class BlockSilverfish extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockSilverfish$EnumType;
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIIIIIIllIlIllIIlllII) {
        return this.getDefaultState().withProperty(BlockSilverfish.VARIANT, EnumType.byMetadata(lllllllllllIIIIIIIllIlIllIIlllII));
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIIIIIIIllIlIllIllIlII, final BlockPos lllllllllllIIIIIIIllIlIllIllIIll, final IBlockState lllllllllllIIIIIIIllIlIllIllIIII) {
        return new ItemStack(this, 1, lllllllllllIIIIIIIllIlIllIllIIII.getBlock().getMetaFromState(lllllllllllIIIIIIIllIlIllIllIIII));
    }
    
    public BlockSilverfish() {
        super(Material.CLAY);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSilverfish.VARIANT, EnumType.STONE));
        this.setHardness(0.0f);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState lllllllllllIIIIIIIllIlIlllIIIlIl) {
        switch ($SWITCH_TABLE$net$minecraft$block$BlockSilverfish$EnumType()[lllllllllllIIIIIIIllIlIlllIIIlIl.getValue(BlockSilverfish.VARIANT).ordinal()]) {
            case 2: {
                return new ItemStack(Blocks.COBBLESTONE);
            }
            case 3: {
                return new ItemStack(Blocks.STONEBRICK);
            }
            case 4: {
                return new ItemStack(Blocks.STONEBRICK, 1, BlockStoneBrick.EnumType.MOSSY.getMetadata());
            }
            case 5: {
                return new ItemStack(Blocks.STONEBRICK, 1, BlockStoneBrick.EnumType.CRACKED.getMetadata());
            }
            case 6: {
                return new ItemStack(Blocks.STONEBRICK, 1, BlockStoneBrick.EnumType.CHISELED.getMetadata());
            }
            default: {
                return new ItemStack(Blocks.STONE);
            }
        }
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllIIIIIIIllIlIllIlIlIII, final NonNullList<ItemStack> lllllllllllIIIIIIIllIlIllIlIIlll) {
        final double lllllllllllIIIIIIIllIlIllIlIIIII;
        final boolean lllllllllllIIIIIIIllIlIllIlIIIIl = ((EnumType[])(Object)(lllllllllllIIIIIIIllIlIllIlIIIII = (double)(Object)EnumType.values())).length != 0;
        for (double lllllllllllIIIIIIIllIlIllIlIIIlI = 0; lllllllllllIIIIIIIllIlIllIlIIIlI < (lllllllllllIIIIIIIllIlIllIlIIIIl ? 1 : 0); ++lllllllllllIIIIIIIllIlIllIlIIIlI) {
            final EnumType lllllllllllIIIIIIIllIlIllIlIIllI = lllllllllllIIIIIIIllIlIllIlIIIII[lllllllllllIIIIIIIllIlIllIlIIIlI];
            lllllllllllIIIIIIIllIlIllIlIIlll.add(new ItemStack(this, 1, lllllllllllIIIIIIIllIlIllIlIIllI.getMetadata()));
        }
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllIIIIIIIllIlIlllIIIIII, final BlockPos lllllllllllIIIIIIIllIlIllIllllll, final IBlockState lllllllllllIIIIIIIllIlIllIlllllI, final float lllllllllllIIIIIIIllIlIllIllllIl, final int lllllllllllIIIIIIIllIlIllIllllII) {
        if (!lllllllllllIIIIIIIllIlIlllIIIIII.isRemote && lllllllllllIIIIIIIllIlIlllIIIIII.getGameRules().getBoolean("doTileDrops")) {
            final EntitySilverfish lllllllllllIIIIIIIllIlIllIlllIll = new EntitySilverfish(lllllllllllIIIIIIIllIlIlllIIIIII);
            lllllllllllIIIIIIIllIlIllIlllIll.setLocationAndAngles(lllllllllllIIIIIIIllIlIllIllllll.getX() + 0.5, lllllllllllIIIIIIIllIlIllIllllll.getY(), lllllllllllIIIIIIIllIlIllIllllll.getZ() + 0.5, 0.0f, 0.0f);
            lllllllllllIIIIIIIllIlIlllIIIIII.spawnEntityInWorld(lllllllllllIIIIIIIllIlIllIlllIll);
            lllllllllllIIIIIIIllIlIllIlllIll.spawnExplosionParticle();
        }
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIIIIIIllIlIllIIlIllI) {
        return lllllllllllIIIIIIIllIlIllIIlIllI.getValue(BlockSilverfish.VARIANT).getMetadata();
    }
    
    public static boolean canContainSilverfish(final IBlockState lllllllllllIIIIIIIllIlIlllIIlIlI) {
        final Block lllllllllllIIIIIIIllIlIlllIIlIll = lllllllllllIIIIIIIllIlIlllIIlIlI.getBlock();
        return lllllllllllIIIIIIIllIlIlllIIlIlI == Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE) || lllllllllllIIIIIIIllIlIlllIIlIll == Blocks.COBBLESTONE || lllllllllllIIIIIIIllIlIlllIIlIll == Blocks.STONEBRICK;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIIIIIIIllIlIlllIIllll) {
        return 0;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSilverfish.VARIANT });
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockSilverfish$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockSilverfish$EnumType = BlockSilverfish.$SWITCH_TABLE$net$minecraft$block$BlockSilverfish$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockSilverfish$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockSilverfish$EnumType;
        }
        final short lllllllllllIIIIIIIllIlIllIIlIIIl = (Object)new int[EnumType.values().length];
        try {
            lllllllllllIIIIIIIllIlIllIIlIIIl[EnumType.CHISELED_STONEBRICK.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIIIIIIllIlIllIIlIIIl[EnumType.COBBLESTONE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIIIIIIllIlIllIIlIIIl[EnumType.CRACKED_STONEBRICK.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIIIIIIllIlIllIIlIIIl[EnumType.MOSSY_STONEBRICK.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIIIIIIllIlIllIIlIIIl[EnumType.STONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIIIIIIIllIlIllIIlIIIl[EnumType.STONEBRICK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockSilverfish.$SWITCH_TABLE$net$minecraft$block$BlockSilverfish$EnumType = (int[])(Object)lllllllllllIIIIIIIllIlIllIIlIIIl;
    }
    
    public enum EnumType implements IStringSerializable
    {
        MOSSY_STONEBRICK(3, 3, "mossy_brick", "mossybrick") {
            @Override
            public IBlockState getModelBlock() {
                return Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.MOSSY);
            }
        };
        
        private final /* synthetic */ String name;
        
        COBBLESTONE(1, 1, "cobblestone", "cobble") {
            @Override
            public IBlockState getModelBlock() {
                return Blocks.COBBLESTONE.getDefaultState();
            }
        };
        
        private final /* synthetic */ int meta;
        
        CHISELED_STONEBRICK(5, 5, "chiseled_brick", "chiseledbrick") {
            @Override
            public IBlockState getModelBlock() {
                return Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CHISELED);
            }
        }, 
        CRACKED_STONEBRICK(4, 4, "cracked_brick", "crackedbrick") {
            @Override
            public IBlockState getModelBlock() {
                return Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CRACKED);
            }
        }, 
        STONE(0, 0, "stone") {
            @Override
            public IBlockState getModelBlock() {
                return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE);
            }
        }, 
        STONEBRICK(2, 2, "stone_brick", "brick") {
            @Override
            public IBlockState getModelBlock() {
                return Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.DEFAULT);
            }
        };
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ String unlocalizedName;
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        public static EnumType byMetadata(int llllllllllllIlIIIIIllIIIlllIlIll) {
            if (llllllllllllIlIIIIIllIIIlllIlIll < 0 || llllllllllllIlIIIIIllIIIlllIlIll >= EnumType.META_LOOKUP.length) {
                llllllllllllIlIIIIIllIIIlllIlIll = 0;
            }
            return EnumType.META_LOOKUP[llllllllllllIlIIIIIllIIIlllIlIll];
        }
        
        public static EnumType forModelBlock(final IBlockState llllllllllllIlIIIIIllIIIllIlllll) {
            float llllllllllllIlIIIIIllIIIllIllIIl;
            for (char llllllllllllIlIIIIIllIIIllIllIlI = (char)((EnumType[])(Object)(llllllllllllIlIIIIIllIIIllIllIIl = (float)(Object)values())).length, llllllllllllIlIIIIIllIIIllIllIll = '\0'; llllllllllllIlIIIIIllIIIllIllIll < llllllllllllIlIIIIIllIIIllIllIlI; ++llllllllllllIlIIIIIllIIIllIllIll) {
                final EnumType llllllllllllIlIIIIIllIIIllIllllI = llllllllllllIlIIIIIllIIIllIllIIl[llllllllllllIlIIIIIllIIIllIllIll];
                if (llllllllllllIlIIIIIllIIIllIlllll == llllllllllllIlIIIIIllIIIllIllllI.getModelBlock()) {
                    return llllllllllllIlIIIIIllIIIllIllllI;
                }
            }
            return EnumType.STONE;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public abstract IBlockState getModelBlock();
        
        private EnumType(final String llllllllllllIlIIIIIllIIlIIIIIlll, final int llllllllllllIlIIIIIllIIlIIIIIllI, final int llllllllllllIlIIIIIllIIlIIIIIlIl, final String llllllllllllIlIIIIIllIIlIIIIlIIl) {
            this(llllllllllllIlIIIIIllIIlIIIIIlll, llllllllllllIlIIIIIllIIlIIIIIllI, llllllllllllIlIIIIIllIIlIIIIIlIl, llllllllllllIlIIIIIllIIlIIIIlIIl, llllllllllllIlIIIIIllIIlIIIIlIIl);
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final long llllllllllllIlIIIIIllIIlIIIlIIIl;
            final byte llllllllllllIlIIIIIllIIlIIIlIIlI = (byte)((EnumType[])(Object)(llllllllllllIlIIIIIllIIlIIIlIIIl = (long)(Object)values())).length;
            for (Exception llllllllllllIlIIIIIllIIlIIIlIIll = (Exception)0; llllllllllllIlIIIIIllIIlIIIlIIll < llllllllllllIlIIIIIllIIlIIIlIIlI; ++llllllllllllIlIIIIIllIIlIIIlIIll) {
                final EnumType llllllllllllIlIIIIIllIIlIIIlIlIl = llllllllllllIlIIIIIllIIlIIIlIIIl[llllllllllllIlIIIIIllIIlIIIlIIll];
                EnumType.META_LOOKUP[llllllllllllIlIIIIIllIIlIIIlIlIl.getMetadata()] = llllllllllllIlIIIIIllIIlIIIlIlIl;
            }
        }
        
        private EnumType(final String llllllllllllIlIIIIIllIIIlllllIII, final int llllllllllllIlIIIIIllIIIllllIlll, final int llllllllllllIlIIIIIllIIIllllllII, final String llllllllllllIlIIIIIllIIIllllIlIl, final String llllllllllllIlIIIIIllIIIlllllIlI) {
            this.meta = llllllllllllIlIIIIIllIIIllllllII;
            this.name = llllllllllllIlIIIIIllIIIllllIlIl;
            this.unlocalizedName = llllllllllllIlIIIIIllIIIlllllIlI;
        }
    }
}
