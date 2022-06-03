// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.SoundEvent;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.datafix.IDataWalker;
import net.minecraft.util.datafix.walkers.ItemStackData;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyBool;

public class BlockJukebox extends BlockContainer
{
    public static final /* synthetic */ PropertyBool HAS_RECORD;
    
    public void insertRecord(final World lllllllllllIIIlIllIIlIlIlIIlIIlI, final BlockPos lllllllllllIIIlIllIIlIlIlIIlIIIl, final IBlockState lllllllllllIIIlIllIIlIlIlIIlIIII, final ItemStack lllllllllllIIIlIllIIlIlIlIIIlIlI) {
        final TileEntity lllllllllllIIIlIllIIlIlIlIIIlllI = lllllllllllIIIlIllIIlIlIlIIlIIlI.getTileEntity(lllllllllllIIIlIllIIlIlIlIIlIIIl);
        if (lllllllllllIIIlIllIIlIlIlIIIlllI instanceof TileEntityJukebox) {
            ((TileEntityJukebox)lllllllllllIIIlIllIIlIlIlIIIlllI).setRecord(lllllllllllIIIlIllIIlIlIlIIIlIlI.copy());
            lllllllllllIIIlIllIIlIlIlIIlIIlI.setBlockState(lllllllllllIIIlIllIIlIlIlIIlIIIl, lllllllllllIIIlIllIIlIlIlIIlIIII.withProperty((IProperty<Comparable>)BlockJukebox.HAS_RECORD, true), 2);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIIlIllIIlIlIIIlIlIll) {
        return ((boolean)lllllllllllIIIlIllIIlIlIIIlIlIll.getValue((IProperty<Boolean>)BlockJukebox.HAS_RECORD)) ? 1 : 0;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllIIIlIllIIlIlIIlIIIlIl) {
        return true;
    }
    
    public static void registerFixesJukebox(final DataFixer lllllllllllIIIlIllIIlIlIlIlIllll) {
        lllllllllllIIIlIllIIlIlIlIlIllll.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackData(TileEntityJukebox.class, new String[] { "RecordItem" }));
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIIIlIllIIlIlIlIlIIlIl, final BlockPos lllllllllllIIIlIllIIlIlIlIlIIlII, IBlockState lllllllllllIIIlIllIIlIlIlIlIIIll, final EntityPlayer lllllllllllIIIlIllIIlIlIlIlIIIlI, final EnumHand lllllllllllIIIlIllIIlIlIlIlIIIIl, final EnumFacing lllllllllllIIIlIllIIlIlIlIlIIIII, final float lllllllllllIIIlIllIIlIlIlIIlllll, final float lllllllllllIIIlIllIIlIlIlIIllllI, final float lllllllllllIIIlIllIIlIlIlIIlllIl) {
        if (lllllllllllIIIlIllIIlIlIlIlIIIll.getValue((IProperty<Boolean>)BlockJukebox.HAS_RECORD)) {
            this.dropRecord(lllllllllllIIIlIllIIlIlIlIlIIlIl, lllllllllllIIIlIllIIlIlIlIlIIlII, lllllllllllIIIlIllIIlIlIlIlIIIll);
            lllllllllllIIIlIllIIlIlIlIlIIIll = lllllllllllIIIlIllIIlIlIlIlIIIll.withProperty((IProperty<Comparable>)BlockJukebox.HAS_RECORD, false);
            lllllllllllIIIlIllIIlIlIlIlIIlIl.setBlockState(lllllllllllIIIlIllIIlIlIlIlIIlII, lllllllllllIIIlIllIIlIlIlIlIIIll, 2);
            return true;
        }
        return false;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockJukebox.HAS_RECORD });
    }
    
    private void dropRecord(final World lllllllllllIIIlIllIIlIlIIlllllII, final BlockPos lllllllllllIIIlIllIIlIlIIllIllll, final IBlockState lllllllllllIIIlIllIIlIlIIllllIlI) {
        if (!lllllllllllIIIlIllIIlIlIIlllllII.isRemote) {
            final TileEntity lllllllllllIIIlIllIIlIlIIllllIIl = lllllllllllIIIlIllIIlIlIIlllllII.getTileEntity(lllllllllllIIIlIllIIlIlIIllIllll);
            if (lllllllllllIIIlIllIIlIlIIllllIIl instanceof TileEntityJukebox) {
                final TileEntityJukebox lllllllllllIIIlIllIIlIlIIllllIII = (TileEntityJukebox)lllllllllllIIIlIllIIlIlIIllllIIl;
                final ItemStack lllllllllllIIIlIllIIlIlIIlllIlll = lllllllllllIIIlIllIIlIlIIllllIII.getRecord();
                if (!lllllllllllIIIlIllIIlIlIIlllIlll.func_190926_b()) {
                    lllllllllllIIIlIllIIlIlIIlllllII.playEvent(1010, lllllllllllIIIlIllIIlIlIIllIllll, 0);
                    lllllllllllIIIlIllIIlIlIIlllllII.playRecord(lllllllllllIIIlIllIIlIlIIllIllll, null);
                    lllllllllllIIIlIllIIlIlIIllllIII.setRecord(ItemStack.field_190927_a);
                    final float lllllllllllIIIlIllIIlIlIIlllIllI = 0.7f;
                    final double lllllllllllIIIlIllIIlIlIIlllIlIl = lllllllllllIIIlIllIIlIlIIlllllII.rand.nextFloat() * 0.7f + 0.15000000596046448;
                    final double lllllllllllIIIlIllIIlIlIIlllIlII = lllllllllllIIIlIllIIlIlIIlllllII.rand.nextFloat() * 0.7f + 0.06000000238418579 + 0.6;
                    final double lllllllllllIIIlIllIIlIlIIlllIIll = lllllllllllIIIlIllIIlIlIIlllllII.rand.nextFloat() * 0.7f + 0.15000000596046448;
                    final ItemStack lllllllllllIIIlIllIIlIlIIlllIIlI = lllllllllllIIIlIllIIlIlIIlllIlll.copy();
                    final EntityItem lllllllllllIIIlIllIIlIlIIlllIIIl = new EntityItem(lllllllllllIIIlIllIIlIlIIlllllII, lllllllllllIIIlIllIIlIlIIllIllll.getX() + lllllllllllIIIlIllIIlIlIIlllIlIl, lllllllllllIIIlIllIIlIlIIllIllll.getY() + lllllllllllIIIlIllIIlIlIIlllIlII, lllllllllllIIIlIllIIlIlIIllIllll.getZ() + lllllllllllIIIlIllIIlIlIIlllIIll, lllllllllllIIIlIllIIlIlIIlllIIlI);
                    lllllllllllIIIlIllIIlIlIIlllIIIl.setDefaultPickupDelay();
                    lllllllllllIIIlIllIIlIlIIlllllII.spawnEntityInWorld(lllllllllllIIIlIllIIlIlIIlllIIIl);
                }
            }
        }
    }
    
    static {
        HAS_RECORD = PropertyBool.create("has_record");
    }
    
    protected BlockJukebox() {
        super(Material.WOOD, MapColor.DIRT);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockJukebox.HAS_RECORD, false));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public void breakBlock(final World lllllllllllIIIlIllIIlIlIIlIlllII, final BlockPos lllllllllllIIIlIllIIlIlIIlIllIll, final IBlockState lllllllllllIIIlIllIIlIlIIlIllllI) {
        this.dropRecord(lllllllllllIIIlIllIIlIlIIlIlllII, lllllllllllIIIlIllIIlIlIIlIllIll, lllllllllllIIIlIllIIlIlIIlIllllI);
        super.breakBlock(lllllllllllIIIlIllIIlIlIIlIlllII, lllllllllllIIIlIllIIlIlIIlIllIll, lllllllllllIIIlIllIIlIlIIlIllllI);
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllIIIlIllIIlIlIIlIIlIII, final int lllllllllllIIIlIllIIlIlIIlIIIlll) {
        return new TileEntityJukebox();
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllIIIlIllIIlIlIIIllIlIl) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIIlIllIIlIlIIIllIIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockJukebox.HAS_RECORD, lllllllllllIIIlIllIIlIlIIIllIIIl > 0);
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllIIIlIllIIlIlIIIllllll, final World lllllllllllIIIlIllIIlIlIIIlllIlI, final BlockPos lllllllllllIIIlIllIIlIlIIIlllIIl) {
        final TileEntity lllllllllllIIIlIllIIlIlIIIllllII = lllllllllllIIIlIllIIlIlIIIlllIlI.getTileEntity(lllllllllllIIIlIllIIlIlIIIlllIIl);
        if (lllllllllllIIIlIllIIlIlIIIllllII instanceof TileEntityJukebox) {
            final ItemStack lllllllllllIIIlIllIIlIlIIIlllIll = ((TileEntityJukebox)lllllllllllIIIlIllIIlIlIIIllllII).getRecord();
            if (!lllllllllllIIIlIllIIlIlIIIlllIll.func_190926_b()) {
                return Item.getIdFromItem(lllllllllllIIIlIllIIlIlIIIlllIll.getItem()) + 1 - Item.getIdFromItem(Items.RECORD_13);
            }
        }
        return 0;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllIIIlIllIIlIlIIlIlIIll, final BlockPos lllllllllllIIIlIllIIlIlIIlIlIIlI, final IBlockState lllllllllllIIIlIllIIlIlIIlIlIIIl, final float lllllllllllIIIlIllIIlIlIIlIIlIlI, final int lllllllllllIIIlIllIIlIlIIlIIllll) {
        if (!lllllllllllIIIlIllIIlIlIIlIlIIll.isRemote) {
            super.dropBlockAsItemWithChance(lllllllllllIIIlIllIIlIlIIlIlIIll, lllllllllllIIIlIllIIlIlIIlIlIIlI, lllllllllllIIIlIllIIlIlIIlIlIIIl, lllllllllllIIIlIllIIlIlIIlIIlIlI, 0);
        }
    }
    
    public static class TileEntityJukebox extends TileEntity
    {
        private /* synthetic */ ItemStack record;
        
        public ItemStack getRecord() {
            return this.record;
        }
        
        public void setRecord(final ItemStack lllllllllllIlIlIIIlIIIIIlIllIIIl) {
            this.record = lllllllllllIlIlIIIlIIIIIlIllIIIl;
            this.markDirty();
        }
        
        @Override
        public void readFromNBT(final NBTTagCompound lllllllllllIlIlIIIlIIIIIllIIIIlI) {
            super.readFromNBT(lllllllllllIlIlIIIlIIIIIllIIIIlI);
            if (lllllllllllIlIlIIIlIIIIIllIIIIlI.hasKey("RecordItem", 10)) {
                this.setRecord(new ItemStack(lllllllllllIlIlIIIlIIIIIllIIIIlI.getCompoundTag("RecordItem")));
            }
            else if (lllllllllllIlIlIIIlIIIIIllIIIIlI.getInteger("Record") > 0) {
                this.setRecord(new ItemStack(Item.getItemById(lllllllllllIlIlIIIlIIIIIllIIIIlI.getInteger("Record"))));
            }
        }
        
        public TileEntityJukebox() {
            this.record = ItemStack.field_190927_a;
        }
        
        @Override
        public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIlIlIIIlIIIIIlIlllIlI) {
            super.writeToNBT(lllllllllllIlIlIIIlIIIIIlIlllIlI);
            if (!this.getRecord().func_190926_b()) {
                lllllllllllIlIlIIIlIIIIIlIlllIlI.setTag("RecordItem", this.getRecord().writeToNBT(new NBTTagCompound()));
            }
            return lllllllllllIlIlIIIlIIIIIlIlllIlI;
        }
    }
}
