// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.datafix.IDataWalker;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.DataFixer;

public class TileEntityDropper extends TileEntityDispenser
{
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_190577_o : "container.dropper";
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:dropper";
    }
    
    public static void registerFixesDropper(final DataFixer lllllllllllllIlIIIIIlIlIllIllIIl) {
        lllllllllllllIlIIIIIlIlIllIllIIl.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityDropper.class, new String[] { "Items" }));
    }
}
