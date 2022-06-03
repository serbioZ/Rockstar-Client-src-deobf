// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.stats.StatList;
import net.minecraft.world.IInteractionObject;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWorkbench extends Block
{
    @Override
    public boolean onBlockActivated(final World lllllllllllIIIIlIllIIlIIIlIlIlII, final BlockPos lllllllllllIIIIlIllIIlIIIlIlIIll, final IBlockState lllllllllllIIIIlIllIIlIIIlIllIll, final EntityPlayer lllllllllllIIIIlIllIIlIIIlIlIIlI, final EnumHand lllllllllllIIIIlIllIIlIIIlIllIIl, final EnumFacing lllllllllllIIIIlIllIIlIIIlIllIII, final float lllllllllllIIIIlIllIIlIIIlIlIlll, final float lllllllllllIIIIlIllIIlIIIlIlIllI, final float lllllllllllIIIIlIllIIlIIIlIlIlIl) {
        if (lllllllllllIIIIlIllIIlIIIlIlIlII.isRemote) {
            return true;
        }
        lllllllllllIIIIlIllIIlIIIlIlIIlI.displayGui(new InterfaceCraftingTable(lllllllllllIIIIlIllIIlIIIlIlIlII, lllllllllllIIIIlIllIIlIIIlIlIIll));
        lllllllllllIIIIlIllIIlIIIlIlIIlI.addStat(StatList.CRAFTING_TABLE_INTERACTION);
        return true;
    }
    
    protected BlockWorkbench() {
        super(Material.WOOD);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    public static class InterfaceCraftingTable implements IInteractionObject
    {
        private final /* synthetic */ World world;
        private final /* synthetic */ BlockPos position;
        
        @Override
        public ITextComponent getDisplayName() {
            return new TextComponentTranslation(String.valueOf(Blocks.CRAFTING_TABLE.getUnlocalizedName()) + ".name", new Object[0]);
        }
        
        @Override
        public String getGuiID() {
            return "minecraft:crafting_table";
        }
        
        public InterfaceCraftingTable(final World lllllllllllIIIlIllIIIIIIIIlIIIIl, final BlockPos lllllllllllIIIlIllIIIIIIIIlIIIll) {
            this.world = lllllllllllIIIlIllIIIIIIIIlIIIIl;
            this.position = lllllllllllIIIlIllIIIIIIIIlIIIll;
        }
        
        @Override
        public Container createContainer(final InventoryPlayer lllllllllllIIIlIllIIIIIIIIIlIllI, final EntityPlayer lllllllllllIIIlIllIIIIIIIIIllIII) {
            return new ContainerWorkbench(lllllllllllIIIlIllIIIIIIIIIlIllI, this.world, this.position);
        }
        
        @Override
        public boolean hasCustomName() {
            return false;
        }
        
        @Override
        public String getName() {
            return "crafting_table";
        }
    }
}
