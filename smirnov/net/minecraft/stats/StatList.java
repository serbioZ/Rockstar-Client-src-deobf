// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.stats;

import net.minecraft.init.Blocks;
import java.util.Set;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.CraftingManager;
import com.google.common.collect.Sets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.item.Item;
import java.util.Map;
import java.util.List;

public class StatList
{
    private static final /* synthetic */ StatBase[] OBJECT_USE_STATS;
    public static final /* synthetic */ List<StatCrafting> USE_ITEM_STATS;
    public static final /* synthetic */ List<StatBase> ALL_STATS;
    private static final /* synthetic */ StatBase[] OBJECT_BREAK_STATS;
    private static final /* synthetic */ StatBase[] OBJECTS_DROPPED_STATS;
    private static final /* synthetic */ StatBase[] OBJECTS_PICKED_UP_STATS;
    public static final /* synthetic */ List<StatBase> BASIC_STATS;
    private static final /* synthetic */ StatBase[] BLOCKS_STATS;
    public static final /* synthetic */ List<StatCrafting> MINE_BLOCK_STATS;
    private static final /* synthetic */ StatBase[] CRAFTS_STATS;
    protected static final /* synthetic */ Map<String, StatBase> ID_TO_STAT_MAP;
    
    @Nullable
    public static StatBase getObjectUseStats(final Item llllllllllllIIIIIIIlIllIlIllIIll) {
        return StatList.OBJECT_USE_STATS[Item.getIdFromItem(llllllllllllIIIIIIIlIllIlIllIIll)];
    }
    
    private static void initStats() {
        for (final Item llllllllllllIIIIIIIlIllIlIIIIlIl : Item.REGISTRY) {
            if (llllllllllllIIIIIIIlIllIlIIIIlIl != null) {
                final int llllllllllllIIIIIIIlIllIlIIIIlII = Item.getIdFromItem(llllllllllllIIIIIIIlIllIlIIIIlIl);
                final String llllllllllllIIIIIIIlIllIlIIIIIll = getItemName(llllllllllllIIIIIIIlIllIlIIIIlIl);
                if (llllllllllllIIIIIIIlIllIlIIIIIll == null) {
                    continue;
                }
                StatList.OBJECT_USE_STATS[llllllllllllIIIIIIIlIllIlIIIIlII] = new StatCrafting("stat.useItem.", llllllllllllIIIIIIIlIllIlIIIIIll, new TextComponentTranslation("stat.useItem", new Object[] { new ItemStack(llllllllllllIIIIIIIlIllIlIIIIlIl).getTextComponent() }), llllllllllllIIIIIIIlIllIlIIIIlIl).registerStat();
                if (llllllllllllIIIIIIIlIllIlIIIIlIl instanceof ItemBlock) {
                    continue;
                }
                StatList.USE_ITEM_STATS.add((StatCrafting)StatList.OBJECT_USE_STATS[llllllllllllIIIIIIIlIllIlIIIIlII]);
            }
        }
        replaceAllSimilarBlocks(StatList.OBJECT_USE_STATS);
    }
    
    @Nullable
    public static StatBase getObjectsPickedUpStats(final Item llllllllllllIIIIIIIlIllIlIlIllII) {
        return StatList.OBJECTS_PICKED_UP_STATS[Item.getIdFromItem(llllllllllllIIIIIIIlIllIlIlIllII)];
    }
    
    private static void initItemDepleteStats() {
        for (final Item llllllllllllIIIIIIIlIllIIllllIlI : Item.REGISTRY) {
            if (llllllllllllIIIIIIIlIllIIllllIlI != null) {
                final int llllllllllllIIIIIIIlIllIIllllIIl = Item.getIdFromItem(llllllllllllIIIIIIIlIllIIllllIlI);
                final String llllllllllllIIIIIIIlIllIIllllIII = getItemName(llllllllllllIIIIIIIlIllIIllllIlI);
                if (llllllllllllIIIIIIIlIllIIllllIII == null || !llllllllllllIIIIIIIlIllIIllllIlI.isDamageable()) {
                    continue;
                }
                StatList.OBJECT_BREAK_STATS[llllllllllllIIIIIIIlIllIIllllIIl] = new StatCrafting("stat.breakItem.", llllllllllllIIIIIIIlIllIIllllIII, new TextComponentTranslation("stat.breakItem", new Object[] { new ItemStack(llllllllllllIIIIIIIlIllIIllllIlI).getTextComponent() }), llllllllllllIIIIIIIlIllIIllllIlI).registerStat();
            }
        }
        replaceAllSimilarBlocks(StatList.OBJECT_BREAK_STATS);
    }
    
    public static void init() {
        initMiningStats();
        initStats();
        initItemDepleteStats();
        initCraftableStats();
        initPickedUpAndDroppedStats();
    }
    
    @Nullable
    public static StatBase getDroppedObjectStats(final Item llllllllllllIIIIIIIlIllIlIlIlIIl) {
        return StatList.OBJECTS_DROPPED_STATS[Item.getIdFromItem(llllllllllllIIIIIIIlIllIlIlIlIIl)];
    }
    
    public static StatBase getStatKillEntity(final EntityList.EntityEggInfo llllllllllllIIIIIIIlIllIIlIIllII) {
        final String llllllllllllIIIIIIIlIllIIlIIllIl = EntityList.func_191302_a(llllllllllllIIIIIIIlIllIIlIIllII.spawnedID);
        return (llllllllllllIIIIIIIlIllIIlIIllIl == null) ? null : new StatBase("stat.killEntity." + llllllllllllIIIIIIIlIllIIlIIllIl, new TextComponentTranslation("stat.entityKill", new Object[] { new TextComponentTranslation("entity." + llllllllllllIIIIIIIlIllIIlIIllIl + ".name", new Object[0]) })).registerStat();
    }
    
    private static void mergeStatBases(final StatBase[] llllllllllllIIIIIIIlIllIIlIllIlI, final Block llllllllllllIIIIIIIlIllIIlIlIlII, final Block llllllllllllIIIIIIIlIllIIlIlIIll) {
        final int llllllllllllIIIIIIIlIllIIlIlIlll = Block.getIdFromBlock(llllllllllllIIIIIIIlIllIIlIlIlII);
        final int llllllllllllIIIIIIIlIllIIlIlIllI = Block.getIdFromBlock(llllllllllllIIIIIIIlIllIIlIlIIll);
        if (llllllllllllIIIIIIIlIllIIlIllIlI[llllllllllllIIIIIIIlIllIIlIlIlll] != null && llllllllllllIIIIIIIlIllIIlIllIlI[llllllllllllIIIIIIIlIllIIlIlIllI] == null) {
            llllllllllllIIIIIIIlIllIIlIllIlI[llllllllllllIIIIIIIlIllIIlIlIllI] = llllllllllllIIIIIIIlIllIIlIllIlI[llllllllllllIIIIIIIlIllIIlIlIlll];
        }
        else {
            StatList.ALL_STATS.remove(llllllllllllIIIIIIIlIllIIlIllIlI[llllllllllllIIIIIIIlIllIIlIlIlll]);
            StatList.MINE_BLOCK_STATS.remove(llllllllllllIIIIIIIlIllIIlIllIlI[llllllllllllIIIIIIIlIllIIlIlIlll]);
            StatList.BASIC_STATS.remove(llllllllllllIIIIIIIlIllIIlIllIlI[llllllllllllIIIIIIIlIllIIlIlIlll]);
            llllllllllllIIIIIIIlIllIIlIllIlI[llllllllllllIIIIIIIlIllIIlIlIlll] = llllllllllllIIIIIIIlIllIIlIllIlI[llllllllllllIIIIIIIlIllIIlIlIllI];
        }
    }
    
    private static String getItemName(final Item llllllllllllIIIIIIIlIllIIllIIlII) {
        final ResourceLocation llllllllllllIIIIIIIlIllIIllIIlIl = Item.REGISTRY.getNameForObject(llllllllllllIIIIIIIlIllIIllIIlII);
        return (llllllllllllIIIIIIIlIllIIllIIlIl != null) ? llllllllllllIIIIIIIlIllIIllIIlIl.toString().replace(':', '.') : null;
    }
    
    @Nullable
    public static StatBase getBlockStats(final Block llllllllllllIIIIIIIlIllIlIlllIIl) {
        return StatList.BLOCKS_STATS[Block.getIdFromBlock(llllllllllllIIIIIIIlIllIlIlllIIl)];
    }
    
    public static StatBase getStatEntityKilledBy(final EntityList.EntityEggInfo llllllllllllIIIIIIIlIllIIlIIlIII) {
        final String llllllllllllIIIIIIIlIllIIlIIIlll = EntityList.func_191302_a(llllllllllllIIIIIIIlIllIIlIIlIII.spawnedID);
        return (llllllllllllIIIIIIIlIllIIlIIIlll == null) ? null : new StatBase("stat.entityKilledBy." + llllllllllllIIIIIIIlIllIIlIIIlll, new TextComponentTranslation("stat.entityKilledBy", new Object[] { new TextComponentTranslation("entity." + llllllllllllIIIIIIIlIllIIlIIIlll + ".name", new Object[0]) })).registerStat();
    }
    
    @Nullable
    public static StatBase getCraftStats(final Item llllllllllllIIIIIIIlIllIlIllIlIl) {
        return StatList.CRAFTS_STATS[Item.getIdFromItem(llllllllllllIIIIIIIlIllIlIllIlIl)];
    }
    
    private static void initMiningStats() {
        for (final Block llllllllllllIIIIIIIlIllIlIIlIIlI : Block.REGISTRY) {
            final Item llllllllllllIIIIIIIlIllIlIIlIIIl = Item.getItemFromBlock(llllllllllllIIIIIIIlIllIlIIlIIlI);
            if (llllllllllllIIIIIIIlIllIlIIlIIIl != Items.field_190931_a) {
                final int llllllllllllIIIIIIIlIllIlIIlIIII = Block.getIdFromBlock(llllllllllllIIIIIIIlIllIlIIlIIlI);
                final String llllllllllllIIIIIIIlIllIlIIIllll = getItemName(llllllllllllIIIIIIIlIllIlIIlIIIl);
                if (llllllllllllIIIIIIIlIllIlIIIllll == null || !llllllllllllIIIIIIIlIllIlIIlIIlI.getEnableStats()) {
                    continue;
                }
                StatList.BLOCKS_STATS[llllllllllllIIIIIIIlIllIlIIlIIII] = new StatCrafting("stat.mineBlock.", llllllllllllIIIIIIIlIllIlIIIllll, new TextComponentTranslation("stat.mineBlock", new Object[] { new ItemStack(llllllllllllIIIIIIIlIllIlIIlIIlI).getTextComponent() }), llllllllllllIIIIIIIlIllIlIIlIIIl).registerStat();
                StatList.MINE_BLOCK_STATS.add((StatCrafting)StatList.BLOCKS_STATS[llllllllllllIIIIIIIlIllIlIIlIIII]);
            }
        }
        replaceAllSimilarBlocks(StatList.BLOCKS_STATS);
    }
    
    private static void initPickedUpAndDroppedStats() {
        for (final Item llllllllllllIIIIIIIlIllIIllIllll : Item.REGISTRY) {
            if (llllllllllllIIIIIIIlIllIIllIllll != null) {
                final int llllllllllllIIIIIIIlIllIIllIlllI = Item.getIdFromItem(llllllllllllIIIIIIIlIllIIllIllll);
                final String llllllllllllIIIIIIIlIllIIllIllIl = getItemName(llllllllllllIIIIIIIlIllIIllIllll);
                if (llllllllllllIIIIIIIlIllIIllIllIl == null) {
                    continue;
                }
                StatList.OBJECTS_PICKED_UP_STATS[llllllllllllIIIIIIIlIllIIllIlllI] = new StatCrafting("stat.pickup.", llllllllllllIIIIIIIlIllIIllIllIl, new TextComponentTranslation("stat.pickup", new Object[] { new ItemStack(llllllllllllIIIIIIIlIllIIllIllll).getTextComponent() }), llllllllllllIIIIIIIlIllIIllIllll).registerStat();
                StatList.OBJECTS_DROPPED_STATS[llllllllllllIIIIIIIlIllIIllIlllI] = new StatCrafting("stat.drop.", llllllllllllIIIIIIIlIllIIllIllIl, new TextComponentTranslation("stat.drop", new Object[] { new ItemStack(llllllllllllIIIIIIIlIllIIllIllll).getTextComponent() }), llllllllllllIIIIIIIlIllIIllIllll).registerStat();
            }
        }
        replaceAllSimilarBlocks(StatList.OBJECT_BREAK_STATS);
    }
    
    static {
        ID_TO_STAT_MAP = Maps.newHashMap();
        ALL_STATS = Lists.newArrayList();
        BASIC_STATS = Lists.newArrayList();
        USE_ITEM_STATS = Lists.newArrayList();
        MINE_BLOCK_STATS = Lists.newArrayList();
        LEAVE_GAME = new StatBasic("stat.leaveGame", new TextComponentTranslation("stat.leaveGame", new Object[0])).initIndependentStat().registerStat();
        PLAY_ONE_MINUTE = new StatBasic("stat.playOneMinute", new TextComponentTranslation("stat.playOneMinute", new Object[0]), StatBase.timeStatType).initIndependentStat().registerStat();
        TIME_SINCE_DEATH = new StatBasic("stat.timeSinceDeath", new TextComponentTranslation("stat.timeSinceDeath", new Object[0]), StatBase.timeStatType).initIndependentStat().registerStat();
        SNEAK_TIME = new StatBasic("stat.sneakTime", new TextComponentTranslation("stat.sneakTime", new Object[0]), StatBase.timeStatType).initIndependentStat().registerStat();
        WALK_ONE_CM = new StatBasic("stat.walkOneCm", new TextComponentTranslation("stat.walkOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        CROUCH_ONE_CM = new StatBasic("stat.crouchOneCm", new TextComponentTranslation("stat.crouchOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        SPRINT_ONE_CM = new StatBasic("stat.sprintOneCm", new TextComponentTranslation("stat.sprintOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        SWIM_ONE_CM = new StatBasic("stat.swimOneCm", new TextComponentTranslation("stat.swimOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        FALL_ONE_CM = new StatBasic("stat.fallOneCm", new TextComponentTranslation("stat.fallOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        CLIMB_ONE_CM = new StatBasic("stat.climbOneCm", new TextComponentTranslation("stat.climbOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        FLY_ONE_CM = new StatBasic("stat.flyOneCm", new TextComponentTranslation("stat.flyOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        DIVE_ONE_CM = new StatBasic("stat.diveOneCm", new TextComponentTranslation("stat.diveOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        MINECART_ONE_CM = new StatBasic("stat.minecartOneCm", new TextComponentTranslation("stat.minecartOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        BOAT_ONE_CM = new StatBasic("stat.boatOneCm", new TextComponentTranslation("stat.boatOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        PIG_ONE_CM = new StatBasic("stat.pigOneCm", new TextComponentTranslation("stat.pigOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        HORSE_ONE_CM = new StatBasic("stat.horseOneCm", new TextComponentTranslation("stat.horseOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        AVIATE_ONE_CM = new StatBasic("stat.aviateOneCm", new TextComponentTranslation("stat.aviateOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        JUMP = new StatBasic("stat.jump", new TextComponentTranslation("stat.jump", new Object[0])).initIndependentStat().registerStat();
        DROP = new StatBasic("stat.drop", new TextComponentTranslation("stat.drop", new Object[0])).initIndependentStat().registerStat();
        DAMAGE_DEALT = new StatBasic("stat.damageDealt", new TextComponentTranslation("stat.damageDealt", new Object[0]), StatBase.divideByTen).registerStat();
        DAMAGE_TAKEN = new StatBasic("stat.damageTaken", new TextComponentTranslation("stat.damageTaken", new Object[0]), StatBase.divideByTen).registerStat();
        DEATHS = new StatBasic("stat.deaths", new TextComponentTranslation("stat.deaths", new Object[0])).registerStat();
        MOB_KILLS = new StatBasic("stat.mobKills", new TextComponentTranslation("stat.mobKills", new Object[0])).registerStat();
        ANIMALS_BRED = new StatBasic("stat.animalsBred", new TextComponentTranslation("stat.animalsBred", new Object[0])).registerStat();
        PLAYER_KILLS = new StatBasic("stat.playerKills", new TextComponentTranslation("stat.playerKills", new Object[0])).registerStat();
        FISH_CAUGHT = new StatBasic("stat.fishCaught", new TextComponentTranslation("stat.fishCaught", new Object[0])).registerStat();
        TALKED_TO_VILLAGER = new StatBasic("stat.talkedToVillager", new TextComponentTranslation("stat.talkedToVillager", new Object[0])).registerStat();
        TRADED_WITH_VILLAGER = new StatBasic("stat.tradedWithVillager", new TextComponentTranslation("stat.tradedWithVillager", new Object[0])).registerStat();
        CAKE_SLICES_EATEN = new StatBasic("stat.cakeSlicesEaten", new TextComponentTranslation("stat.cakeSlicesEaten", new Object[0])).registerStat();
        CAULDRON_FILLED = new StatBasic("stat.cauldronFilled", new TextComponentTranslation("stat.cauldronFilled", new Object[0])).registerStat();
        CAULDRON_USED = new StatBasic("stat.cauldronUsed", new TextComponentTranslation("stat.cauldronUsed", new Object[0])).registerStat();
        ARMOR_CLEANED = new StatBasic("stat.armorCleaned", new TextComponentTranslation("stat.armorCleaned", new Object[0])).registerStat();
        BANNER_CLEANED = new StatBasic("stat.bannerCleaned", new TextComponentTranslation("stat.bannerCleaned", new Object[0])).registerStat();
        BREWINGSTAND_INTERACTION = new StatBasic("stat.brewingstandInteraction", new TextComponentTranslation("stat.brewingstandInteraction", new Object[0])).registerStat();
        BEACON_INTERACTION = new StatBasic("stat.beaconInteraction", new TextComponentTranslation("stat.beaconInteraction", new Object[0])).registerStat();
        DROPPER_INSPECTED = new StatBasic("stat.dropperInspected", new TextComponentTranslation("stat.dropperInspected", new Object[0])).registerStat();
        HOPPER_INSPECTED = new StatBasic("stat.hopperInspected", new TextComponentTranslation("stat.hopperInspected", new Object[0])).registerStat();
        DISPENSER_INSPECTED = new StatBasic("stat.dispenserInspected", new TextComponentTranslation("stat.dispenserInspected", new Object[0])).registerStat();
        NOTEBLOCK_PLAYED = new StatBasic("stat.noteblockPlayed", new TextComponentTranslation("stat.noteblockPlayed", new Object[0])).registerStat();
        NOTEBLOCK_TUNED = new StatBasic("stat.noteblockTuned", new TextComponentTranslation("stat.noteblockTuned", new Object[0])).registerStat();
        FLOWER_POTTED = new StatBasic("stat.flowerPotted", new TextComponentTranslation("stat.flowerPotted", new Object[0])).registerStat();
        TRAPPED_CHEST_TRIGGERED = new StatBasic("stat.trappedChestTriggered", new TextComponentTranslation("stat.trappedChestTriggered", new Object[0])).registerStat();
        ENDERCHEST_OPENED = new StatBasic("stat.enderchestOpened", new TextComponentTranslation("stat.enderchestOpened", new Object[0])).registerStat();
        ITEM_ENCHANTED = new StatBasic("stat.itemEnchanted", new TextComponentTranslation("stat.itemEnchanted", new Object[0])).registerStat();
        RECORD_PLAYED = new StatBasic("stat.recordPlayed", new TextComponentTranslation("stat.recordPlayed", new Object[0])).registerStat();
        FURNACE_INTERACTION = new StatBasic("stat.furnaceInteraction", new TextComponentTranslation("stat.furnaceInteraction", new Object[0])).registerStat();
        CRAFTING_TABLE_INTERACTION = new StatBasic("stat.craftingTableInteraction", new TextComponentTranslation("stat.workbenchInteraction", new Object[0])).registerStat();
        CHEST_OPENED = new StatBasic("stat.chestOpened", new TextComponentTranslation("stat.chestOpened", new Object[0])).registerStat();
        SLEEP_IN_BED = new StatBasic("stat.sleepInBed", new TextComponentTranslation("stat.sleepInBed", new Object[0])).registerStat();
        field_191272_ae = new StatBasic("stat.shulkerBoxOpened", new TextComponentTranslation("stat.shulkerBoxOpened", new Object[0])).registerStat();
        BLOCKS_STATS = new StatBase[4096];
        CRAFTS_STATS = new StatBase[32000];
        OBJECT_USE_STATS = new StatBase[32000];
        OBJECT_BREAK_STATS = new StatBase[32000];
        OBJECTS_PICKED_UP_STATS = new StatBase[32000];
        OBJECTS_DROPPED_STATS = new StatBase[32000];
    }
    
    @Nullable
    public static StatBase getOneShotStat(final String llllllllllllIIIIIIIlIllIIlIIIIlI) {
        return StatList.ID_TO_STAT_MAP.get(llllllllllllIIIIIIIlIllIIlIIIIlI);
    }
    
    private static void initCraftableStats() {
        final Set<Item> llllllllllllIIIIIIIlIllIlIlIIIll = (Set<Item>)Sets.newHashSet();
        for (final IRecipe llllllllllllIIIIIIIlIllIlIlIIIlI : CraftingManager.field_193380_a) {
            final ItemStack llllllllllllIIIIIIIlIllIlIlIIIIl = llllllllllllIIIIIIIlIllIlIlIIIlI.getRecipeOutput();
            if (!llllllllllllIIIIIIIlIllIlIlIIIIl.func_190926_b()) {
                llllllllllllIIIIIIIlIllIlIlIIIll.add(llllllllllllIIIIIIIlIllIlIlIIIlI.getRecipeOutput().getItem());
            }
        }
        for (final ItemStack llllllllllllIIIIIIIlIllIlIlIIIII : FurnaceRecipes.instance().getSmeltingList().values()) {
            llllllllllllIIIIIIIlIllIlIlIIIll.add(llllllllllllIIIIIIIlIllIlIlIIIII.getItem());
        }
        for (final Item llllllllllllIIIIIIIlIllIlIIlllll : llllllllllllIIIIIIIlIllIlIlIIIll) {
            if (llllllllllllIIIIIIIlIllIlIIlllll != null) {
                final int llllllllllllIIIIIIIlIllIlIIllllI = Item.getIdFromItem(llllllllllllIIIIIIIlIllIlIIlllll);
                final String llllllllllllIIIIIIIlIllIlIIlllIl = getItemName(llllllllllllIIIIIIIlIllIlIIlllll);
                if (llllllllllllIIIIIIIlIllIlIIlllIl == null) {
                    continue;
                }
                StatList.CRAFTS_STATS[llllllllllllIIIIIIIlIllIlIIllllI] = new StatCrafting("stat.craftItem.", llllllllllllIIIIIIIlIllIlIIlllIl, new TextComponentTranslation("stat.craftItem", new Object[] { new ItemStack(llllllllllllIIIIIIIlIllIlIIlllll).getTextComponent() }), llllllllllllIIIIIIIlIllIlIIlllll).registerStat();
            }
        }
        replaceAllSimilarBlocks(StatList.CRAFTS_STATS);
    }
    
    private static void replaceAllSimilarBlocks(final StatBase[] llllllllllllIIIIIIIlIllIIllIIIII) {
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.WATER, Blocks.FLOWING_WATER);
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.LAVA, Blocks.FLOWING_LAVA);
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.LIT_PUMPKIN, Blocks.PUMPKIN);
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.LIT_FURNACE, Blocks.FURNACE);
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.LIT_REDSTONE_ORE, Blocks.REDSTONE_ORE);
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.POWERED_REPEATER, Blocks.UNPOWERED_REPEATER);
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.POWERED_COMPARATOR, Blocks.UNPOWERED_COMPARATOR);
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.REDSTONE_TORCH, Blocks.UNLIT_REDSTONE_TORCH);
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.LIT_REDSTONE_LAMP, Blocks.REDSTONE_LAMP);
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.DOUBLE_STONE_SLAB, Blocks.STONE_SLAB);
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.DOUBLE_WOODEN_SLAB, Blocks.WOODEN_SLAB);
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.DOUBLE_STONE_SLAB2, Blocks.STONE_SLAB2);
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.GRASS, Blocks.DIRT);
        mergeStatBases(llllllllllllIIIIIIIlIllIIllIIIII, Blocks.FARMLAND, Blocks.DIRT);
    }
    
    @Nullable
    public static StatBase getObjectBreakStats(final Item llllllllllllIIIIIIIlIllIlIllIIII) {
        return StatList.OBJECT_BREAK_STATS[Item.getIdFromItem(llllllllllllIIIIIIIlIllIlIllIIII)];
    }
}
