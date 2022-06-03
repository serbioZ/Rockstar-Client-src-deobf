// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.color;

import net.minecraft.item.ItemMap;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.entity.EntityList;
import net.minecraft.potion.PotionUtils;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.item.ItemFireworkCharge;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.util.ObjectIntIdentityMap;

public class ItemColors
{
    private final /* synthetic */ ObjectIntIdentityMap<IItemColor> mapItemColors;
    
    public void registerItemColorHandler(final IItemColor llllllllllllIIIIlllllIlllIIlllII, final Item... llllllllllllIIIIlllllIlllIIlllll) {
        final long llllllllllllIIIIlllllIlllIIlIlll = (Object)llllllllllllIIIIlllllIlllIIlllll;
        final boolean llllllllllllIIIIlllllIlllIIllIII = llllllllllllIIIIlllllIlllIIlllll.length != 0;
        for (Exception llllllllllllIIIIlllllIlllIIllIIl = (Exception)0; llllllllllllIIIIlllllIlllIIllIIl < llllllllllllIIIIlllllIlllIIllIII; ++llllllllllllIIIIlllllIlllIIllIIl) {
            final Item llllllllllllIIIIlllllIlllIIllllI = llllllllllllIIIIlllllIlllIIlIlll[llllllllllllIIIIlllllIlllIIllIIl];
            this.mapItemColors.put(llllllllllllIIIIlllllIlllIIlllII, Item.getIdFromItem(llllllllllllIIIIlllllIlllIIllllI));
        }
    }
    
    public ItemColors() {
        this.mapItemColors = new ObjectIntIdentityMap<IItemColor>(32);
    }
    
    public static ItemColors init(final BlockColors llllllllllllIIIIlllllIllllIIlIlI) {
        final ItemColors llllllllllllIIIIlllllIllllIIlIIl = new ItemColors();
        llllllllllllIIIIlllllIllllIIlIIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack lllllllllllllIIIlllIIIIllIIlllll, final int lllllllllllllIIIlllIIIIllIIlllII) {
                return (lllllllllllllIIIlllIIIIllIIlllII > 0) ? -1 : ((ItemArmor)lllllllllllllIIIlllIIIIllIIlllll.getItem()).getColor(lllllllllllllIIIlllIIIIllIIlllll);
            }
        }, Items.LEATHER_HELMET, Items.LEATHER_CHESTPLATE, Items.LEATHER_LEGGINGS, Items.LEATHER_BOOTS);
        llllllllllllIIIIlllllIllllIIlIIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack llllllllllllIllIIlllIllIIlIIIIII, final int llllllllllllIllIIlllIllIIIllllll) {
                final BlockDoublePlant.EnumPlantType llllllllllllIllIIlllIllIIIlllllI = BlockDoublePlant.EnumPlantType.byMetadata(llllllllllllIllIIlllIllIIlIIIIII.getMetadata());
                return (llllllllllllIllIIlllIllIIIlllllI != BlockDoublePlant.EnumPlantType.GRASS && llllllllllllIllIIlllIllIIIlllllI != BlockDoublePlant.EnumPlantType.FERN) ? -1 : ColorizerGrass.getGrassColor(0.5, 1.0);
            }
        }, Blocks.DOUBLE_PLANT);
        llllllllllllIIIIlllllIllllIIlIIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack lllllllllllIIlIlIIlIlIlllIIllIII, final int lllllllllllIIlIlIIlIlIlllIIlllll) {
                if (lllllllllllIIlIlIIlIlIlllIIlllll != 1) {
                    return -1;
                }
                final NBTBase lllllllllllIIlIlIIlIlIlllIIllllI = ItemFireworkCharge.getExplosionTag(lllllllllllIIlIlIIlIlIlllIIllIII, "Colors");
                if (!(lllllllllllIIlIlIIlIlIlllIIllllI instanceof NBTTagIntArray)) {
                    return 9079434;
                }
                final int[] lllllllllllIIlIlIIlIlIlllIIlllIl = ((NBTTagIntArray)lllllllllllIIlIlIIlIlIlllIIllllI).getIntArray();
                if (lllllllllllIIlIlIIlIlIlllIIlllIl.length == 1) {
                    return lllllllllllIIlIlIIlIlIlllIIlllIl[0];
                }
                int lllllllllllIIlIlIIlIlIlllIIlllII = 0;
                int lllllllllllIIlIlIIlIlIlllIIllIll = 0;
                int lllllllllllIIlIlIIlIlIlllIIllIlI = 0;
                int lllllllllllIIlIlIIlIlIlllIIIlllI;
                for (String lllllllllllIIlIlIIlIlIlllIIIllll = (String)((int[])(Object)(lllllllllllIIlIlIIlIlIlllIIIlllI = (int)(Object)lllllllllllIIlIlIIlIlIlllIIlllIl)).length, lllllllllllIIlIlIIlIlIlllIIlIIII = (String)0; lllllllllllIIlIlIIlIlIlllIIlIIII < lllllllllllIIlIlIIlIlIlllIIIllll; ++lllllllllllIIlIlIIlIlIlllIIlIIII) {
                    final int lllllllllllIIlIlIIlIlIlllIIllIIl = lllllllllllIIlIlIIlIlIlllIIIlllI[lllllllllllIIlIlIIlIlIlllIIlIIII];
                    lllllllllllIIlIlIIlIlIlllIIlllII += (lllllllllllIIlIlIIlIlIlllIIllIIl & 0xFF0000) >> 16;
                    lllllllllllIIlIlIIlIlIlllIIllIll += (lllllllllllIIlIlIIlIlIlllIIllIIl & 0xFF00) >> 8;
                    lllllllllllIIlIlIIlIlIlllIIllIlI += (lllllllllllIIlIlIIlIlIlllIIllIIl & 0xFF) >> 0;
                }
                lllllllllllIIlIlIIlIlIlllIIlllII /= lllllllllllIIlIlIIlIlIlllIIlllIl.length;
                lllllllllllIIlIlIIlIlIlllIIllIll /= lllllllllllIIlIlIIlIlIlllIIlllIl.length;
                lllllllllllIIlIlIIlIlIlllIIllIlI /= lllllllllllIIlIlIIlIlIlllIIlllIl.length;
                return lllllllllllIIlIlIIlIlIlllIIlllII << 16 | lllllllllllIIlIlIIlIlIlllIIllIll << 8 | lllllllllllIIlIlIIlIlIlllIIllIlI;
            }
        }, Items.FIREWORK_CHARGE);
        llllllllllllIIIIlllllIllllIIlIIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack llllllllllllIllIIlllIlIllIIIIIIl, final int llllllllllllIllIIlllIlIlIllllllI) {
                return (llllllllllllIllIIlllIlIlIllllllI > 0) ? -1 : PotionUtils.func_190932_c(llllllllllllIllIIlllIlIllIIIIIIl);
            }
        }, Items.POTIONITEM, Items.SPLASH_POTION, Items.LINGERING_POTION);
        llllllllllllIIIIlllllIllllIIlIIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack llllllllllIlllIllIlIIlIIIIIlIlll, final int llllllllllIlllIllIlIIlIIIIIlIllI) {
                final EntityList.EntityEggInfo llllllllllIlllIllIlIIlIIIIIllIII = EntityList.ENTITY_EGGS.get(ItemMonsterPlacer.func_190908_h(llllllllllIlllIllIlIIlIIIIIlIlll));
                if (llllllllllIlllIllIlIIlIIIIIllIII == null) {
                    return -1;
                }
                return (llllllllllIlllIllIlIIlIIIIIlIllI == 0) ? llllllllllIlllIllIlIIlIIIIIllIII.primaryColor : llllllllllIlllIllIlIIlIIIIIllIII.secondaryColor;
            }
        }, Items.SPAWN_EGG);
        llllllllllllIIIIlllllIllllIIlIIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack lllllllllllIllllllIlIllIIllIllIl, final int lllllllllllIllllllIlIllIIlllIIII) {
                final IBlockState lllllllllllIllllllIlIllIIllIllll = ((ItemBlock)lllllllllllIllllllIlIllIIllIllIl.getItem()).getBlock().getStateFromMeta(lllllllllllIllllllIlIllIIllIllIl.getMetadata());
                return llllllllllllIIIIlllllIllllIIlIlI.colorMultiplier(lllllllllllIllllllIlIllIIllIllll, null, null, lllllllllllIllllllIlIllIIlllIIII);
            }
        }, Blocks.GRASS, Blocks.TALLGRASS, Blocks.VINE, Blocks.LEAVES, Blocks.LEAVES2, Blocks.WATERLILY);
        llllllllllllIIIIlllllIllllIIlIIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack llllllllllIlllllIllllIlIIlllIIII, final int llllllllllIlllllIllllIlIIllIllll) {
                return (llllllllllIlllllIllllIlIIllIllll == 0) ? PotionUtils.func_190932_c(llllllllllIlllllIllllIlIIlllIIII) : -1;
            }
        }, Items.TIPPED_ARROW);
        llllllllllllIIIIlllllIllllIIlIIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack lllllllllllIlIIlIllllIIlIlIllllI, final int lllllllllllIlIIlIllllIIlIlIlllIl) {
                return (lllllllllllIlIIlIllllIIlIlIlllIl == 0) ? -1 : ItemMap.func_190907_h(lllllllllllIlIIlIllllIIlIlIllllI);
            }
        }, Items.FILLED_MAP);
        return llllllllllllIIIIlllllIllllIIlIIl;
    }
    
    public int getColorFromItemstack(final ItemStack llllllllllllIIIIlllllIllllIIIIIl, final int llllllllllllIIIIlllllIllllIIIIII) {
        final IItemColor llllllllllllIIIIlllllIlllIllllll = this.mapItemColors.getByValue(Item.REGISTRY.getIDForObject(llllllllllllIIIIlllllIllllIIIIIl.getItem()));
        return (llllllllllllIIIIlllllIlllIllllll == null) ? -1 : llllllllllllIIIIlllllIlllIllllll.getColorFromItemstack(llllllllllllIIIIlllllIllllIIIIIl, llllllllllllIIIIlllllIllllIIIIII);
    }
    
    public void registerItemColorHandler(final IItemColor llllllllllllIIIIlllllIlllIllIIlI, final Block... llllllllllllIIIIlllllIlllIllIIIl) {
        final double llllllllllllIIIIlllllIlllIlIlIIl = (Object)llllllllllllIIIIlllllIlllIllIIIl;
        for (short llllllllllllIIIIlllllIlllIlIlIlI = (short)llllllllllllIIIIlllllIlllIllIIIl.length, llllllllllllIIIIlllllIlllIlIlIll = 0; llllllllllllIIIIlllllIlllIlIlIll < llllllllllllIIIIlllllIlllIlIlIlI; ++llllllllllllIIIIlllllIlllIlIlIll) {
            final Block llllllllllllIIIIlllllIlllIllIIII = llllllllllllIIIIlllllIlllIlIlIIl[llllllllllllIIIIlllllIlllIlIlIll];
            this.mapItemColors.put(llllllllllllIIIIlllllIlllIllIIlI, Item.getIdFromItem(Item.getItemFromBlock(llllllllllllIIIIlllllIlllIllIIII)));
        }
    }
}
