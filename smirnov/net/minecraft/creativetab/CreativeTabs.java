// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.creativetab;

import net.minecraft.util.NonNullList;
import net.minecraft.potion.PotionUtils;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.Items;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import javax.annotation.Nullable;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;

public abstract class CreativeTabs
{
    public static final /* synthetic */ CreativeTabs MISC;
    private final /* synthetic */ String tabLabel;
    private /* synthetic */ boolean hasScrollbar;
    private final /* synthetic */ int tabIndex;
    private /* synthetic */ String theTexture;
    private /* synthetic */ ItemStack iconItemStack;
    private /* synthetic */ boolean drawTitle;
    public static final /* synthetic */ CreativeTabs[] CREATIVE_TAB_ARRAY;
    private /* synthetic */ EnumEnchantmentType[] enchantmentTypes;
    
    public boolean drawInForegroundOfTab() {
        return this.drawTitle;
    }
    
    public CreativeTabs setRelevantEnchantmentTypes(final EnumEnchantmentType... llllllllllllIlIIlIllIlIIlIlIIllI) {
        this.enchantmentTypes = llllllllllllIlIIlIllIlIIlIlIIllI;
        return this;
    }
    
    public boolean isTabInFirstRow() {
        return this.tabIndex < 6;
    }
    
    public boolean shouldHidePlayerInventory() {
        return this.hasScrollbar;
    }
    
    public abstract ItemStack getTabIconItem();
    
    public int getTabColumn() {
        return this.tabIndex % 6;
    }
    
    public int getTabIndex() {
        return this.tabIndex;
    }
    
    public CreativeTabs setBackgroundImageName(final String llllllllllllIlIIlIllIlIIllIIIIlI) {
        this.theTexture = llllllllllllIlIIlIllIlIIllIIIIlI;
        return this;
    }
    
    public CreativeTabs(final int llllllllllllIlIIlIllIlIIllIllIll, final String llllllllllllIlIIlIllIlIIllIllIlI) {
        this.theTexture = "items.png";
        this.hasScrollbar = true;
        this.drawTitle = true;
        this.enchantmentTypes = new EnumEnchantmentType[0];
        this.tabIndex = llllllllllllIlIIlIllIlIIllIllIll;
        this.tabLabel = llllllllllllIlIIlIllIlIIllIllIlI;
        this.iconItemStack = ItemStack.field_190927_a;
        CreativeTabs.CREATIVE_TAB_ARRAY[llllllllllllIlIIlIllIlIIllIllIll] = this;
    }
    
    public EnumEnchantmentType[] getRelevantEnchantmentTypes() {
        return this.enchantmentTypes;
    }
    
    public boolean hasRelevantEnchantmentType(@Nullable final EnumEnchantmentType llllllllllllIlIIlIllIlIIlIIllIIl) {
        if (llllllllllllIlIIlIllIlIIlIIllIIl != null) {
            final byte llllllllllllIlIIlIllIlIIlIIlIlIl;
            final String llllllllllllIlIIlIllIlIIlIIlIllI = (String)((EnumEnchantmentType[])(Object)(llllllllllllIlIIlIllIlIIlIIlIlIl = (byte)(Object)this.enchantmentTypes)).length;
            for (Exception llllllllllllIlIIlIllIlIIlIIlIlll = (Exception)0; llllllllllllIlIIlIllIlIIlIIlIlll < llllllllllllIlIIlIllIlIIlIIlIllI; ++llllllllllllIlIIlIllIlIIlIIlIlll) {
                final EnumEnchantmentType llllllllllllIlIIlIllIlIIlIIllIll = llllllllllllIlIIlIllIlIIlIIlIlIl[llllllllllllIlIIlIllIlIIlIIlIlll];
                if (llllllllllllIlIIlIllIlIIlIIllIll == llllllllllllIlIIlIllIlIIlIIllIIl) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public CreativeTabs setNoTitle() {
        this.drawTitle = false;
        return this;
    }
    
    public CreativeTabs setNoScrollbar() {
        this.hasScrollbar = false;
        return this;
    }
    
    public String getTranslatedTabLabel() {
        return "itemGroup." + this.getTabLabel();
    }
    
    static {
        CREATIVE_TAB_ARRAY = new CreativeTabs[12];
        BUILDING_BLOCKS = new CreativeTabs("buildingBlocks") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Item.getItemFromBlock(Blocks.BRICK_BLOCK));
            }
        };
        DECORATIONS = new CreativeTabs("decorations") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 1, BlockDoublePlant.EnumPlantType.PAEONIA.getMeta());
            }
        };
        REDSTONE = new CreativeTabs("redstone") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.REDSTONE);
            }
        };
        TRANSPORTATION = new CreativeTabs("transportation") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Item.getItemFromBlock(Blocks.GOLDEN_RAIL));
            }
        };
        MISC = new CreativeTabs("misc") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.LAVA_BUCKET);
            }
        };
        SEARCH = new CreativeTabs("search") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.COMPASS);
            }
        }.setBackgroundImageName("item_search.png");
        FOOD = new CreativeTabs("food") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.APPLE);
            }
        };
        TOOLS = new CreativeTabs("tools") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.IRON_AXE);
            }
        }.setRelevantEnchantmentTypes(EnumEnchantmentType.ALL, EnumEnchantmentType.DIGGER, EnumEnchantmentType.FISHING_ROD, EnumEnchantmentType.BREAKABLE);
        COMBAT = new CreativeTabs("combat") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.GOLDEN_SWORD);
            }
        }.setRelevantEnchantmentTypes(EnumEnchantmentType.ALL, EnumEnchantmentType.ARMOR, EnumEnchantmentType.ARMOR_FEET, EnumEnchantmentType.ARMOR_HEAD, EnumEnchantmentType.ARMOR_LEGS, EnumEnchantmentType.ARMOR_CHEST, EnumEnchantmentType.BOW, EnumEnchantmentType.WEAPON, EnumEnchantmentType.WEARABLE, EnumEnchantmentType.BREAKABLE);
        BREWING = new CreativeTabs("brewing") {
            @Override
            public ItemStack getTabIconItem() {
                return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
            }
        };
        MATERIALS = CreativeTabs.MISC;
        field_192395_m = new CreativeTabs("hotbar") {
            @Override
            public void displayAllRelevantItems(final NonNullList<ItemStack> lllllllllllIIlIlIIIIllllIIlIIIIl) {
                throw new RuntimeException("Implement exception client-side.");
            }
            
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Blocks.BOOKSHELF);
            }
            
            @Override
            public boolean func_192394_m() {
                return true;
            }
        };
        INVENTORY = new CreativeTabs("inventory") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Item.getItemFromBlock(Blocks.CHEST));
            }
        }.setBackgroundImageName("inventory.png").setNoScrollbar().setNoTitle();
    }
    
    public void displayAllRelevantItems(final NonNullList<ItemStack> llllllllllllIlIIlIllIlIIlIIIllII) {
        for (final Item llllllllllllIlIIlIllIlIIlIIIlllI : Item.REGISTRY) {
            llllllllllllIlIIlIllIlIIlIIIlllI.getSubItems(this, llllllllllllIlIIlIllIlIIlIIIllII);
        }
    }
    
    public boolean func_192394_m() {
        return this.getTabColumn() == 5;
    }
    
    public String getTabLabel() {
        return this.tabLabel;
    }
    
    public ItemStack getIconItemStack() {
        if (this.iconItemStack.func_190926_b()) {
            this.iconItemStack = this.getTabIconItem();
        }
        return this.iconItemStack;
    }
    
    public String getBackgroundImageName() {
        return this.theTexture;
    }
}
