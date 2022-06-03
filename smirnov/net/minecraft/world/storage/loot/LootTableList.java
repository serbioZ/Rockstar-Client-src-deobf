// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot;

import java.util.Collections;
import com.google.common.collect.Sets;
import java.io.File;
import java.util.Set;
import net.minecraft.util.ResourceLocation;

public class LootTableList
{
    private static final /* synthetic */ Set<ResourceLocation> READ_ONLY_LOOT_TABLES;
    private static final /* synthetic */ Set<ResourceLocation> LOOT_TABLES;
    
    public static ResourceLocation register(final ResourceLocation lllllllllllIlIlIllIIIIIIIIIIlIII) {
        if (LootTableList.LOOT_TABLES.add(lllllllllllIlIlIllIIIIIIIIIIlIII)) {
            return lllllllllllIlIlIllIIIIIIIIIIlIII;
        }
        throw new IllegalArgumentException(lllllllllllIlIlIllIIIIIIIIIIlIII + " is already a registered built-in loot table");
    }
    
    public static Set<ResourceLocation> getAll() {
        return LootTableList.READ_ONLY_LOOT_TABLES;
    }
    
    private static ResourceLocation register(final String lllllllllllIlIlIllIIIIIIIIIIlIll) {
        return register(new ResourceLocation("minecraft", lllllllllllIlIlIllIIIIIIIIIIlIll));
    }
    
    public static boolean func_193579_b() {
        final LootTableManager lllllllllllIlIlIllIIIIIIIIIIIlII = new LootTableManager(null);
        for (final ResourceLocation lllllllllllIlIlIllIIIIIIIIIIIIll : LootTableList.READ_ONLY_LOOT_TABLES) {
            if (lllllllllllIlIlIllIIIIIIIIIIIlII.getLootTableFromLocation(lllllllllllIlIlIllIIIIIIIIIIIIll) == LootTable.EMPTY_LOOT_TABLE) {
                return false;
            }
        }
        return true;
    }
    
    static {
        LOOT_TABLES = Sets.newHashSet();
        READ_ONLY_LOOT_TABLES = Collections.unmodifiableSet((Set<? extends ResourceLocation>)LootTableList.LOOT_TABLES);
        EMPTY = register("empty");
        CHESTS_SPAWN_BONUS_CHEST = register("chests/spawn_bonus_chest");
        CHESTS_END_CITY_TREASURE = register("chests/end_city_treasure");
        CHESTS_SIMPLE_DUNGEON = register("chests/simple_dungeon");
        CHESTS_VILLAGE_BLACKSMITH = register("chests/village_blacksmith");
        CHESTS_ABANDONED_MINESHAFT = register("chests/abandoned_mineshaft");
        CHESTS_NETHER_BRIDGE = register("chests/nether_bridge");
        CHESTS_STRONGHOLD_LIBRARY = register("chests/stronghold_library");
        CHESTS_STRONGHOLD_CROSSING = register("chests/stronghold_crossing");
        CHESTS_STRONGHOLD_CORRIDOR = register("chests/stronghold_corridor");
        CHESTS_DESERT_PYRAMID = register("chests/desert_pyramid");
        CHESTS_JUNGLE_TEMPLE = register("chests/jungle_temple");
        CHESTS_JUNGLE_TEMPLE_DISPENSER = register("chests/jungle_temple_dispenser");
        CHESTS_IGLOO_CHEST = register("chests/igloo_chest");
        field_191192_o = register("chests/woodland_mansion");
        ENTITIES_WITCH = register("entities/witch");
        ENTITIES_BLAZE = register("entities/blaze");
        ENTITIES_CREEPER = register("entities/creeper");
        ENTITIES_SPIDER = register("entities/spider");
        ENTITIES_CAVE_SPIDER = register("entities/cave_spider");
        ENTITIES_GIANT = register("entities/giant");
        ENTITIES_SILVERFISH = register("entities/silverfish");
        ENTITIES_ENDERMAN = register("entities/enderman");
        ENTITIES_GUARDIAN = register("entities/guardian");
        ENTITIES_ELDER_GUARDIAN = register("entities/elder_guardian");
        ENTITIES_SHULKER = register("entities/shulker");
        ENTITIES_IRON_GOLEM = register("entities/iron_golem");
        ENTITIES_SNOWMAN = register("entities/snowman");
        ENTITIES_RABBIT = register("entities/rabbit");
        ENTITIES_CHICKEN = register("entities/chicken");
        ENTITIES_PIG = register("entities/pig");
        ENTITIES_POLAR_BEAR = register("entities/polar_bear");
        ENTITIES_HORSE = register("entities/horse");
        field_191190_H = register("entities/donkey");
        field_191191_I = register("entities/mule");
        ENTITIES_ZOMBIE_HORSE = register("entities/zombie_horse");
        ENTITIES_SKELETON_HORSE = register("entities/skeleton_horse");
        ENTITIES_COW = register("entities/cow");
        ENTITIES_MUSHROOM_COW = register("entities/mushroom_cow");
        ENTITIES_WOLF = register("entities/wolf");
        ENTITIES_OCELOT = register("entities/ocelot");
        ENTITIES_SHEEP = register("entities/sheep");
        ENTITIES_SHEEP_WHITE = register("entities/sheep/white");
        ENTITIES_SHEEP_ORANGE = register("entities/sheep/orange");
        ENTITIES_SHEEP_MAGENTA = register("entities/sheep/magenta");
        ENTITIES_SHEEP_LIGHT_BLUE = register("entities/sheep/light_blue");
        ENTITIES_SHEEP_YELLOW = register("entities/sheep/yellow");
        ENTITIES_SHEEP_LIME = register("entities/sheep/lime");
        ENTITIES_SHEEP_PINK = register("entities/sheep/pink");
        ENTITIES_SHEEP_GRAY = register("entities/sheep/gray");
        ENTITIES_SHEEP_SILVER = register("entities/sheep/silver");
        ENTITIES_SHEEP_CYAN = register("entities/sheep/cyan");
        ENTITIES_SHEEP_PURPLE = register("entities/sheep/purple");
        ENTITIES_SHEEP_BLUE = register("entities/sheep/blue");
        ENTITIES_SHEEP_BROWN = register("entities/sheep/brown");
        ENTITIES_SHEEP_GREEN = register("entities/sheep/green");
        ENTITIES_SHEEP_RED = register("entities/sheep/red");
        ENTITIES_SHEEP_BLACK = register("entities/sheep/black");
        ENTITIES_BAT = register("entities/bat");
        ENTITIES_SLIME = register("entities/slime");
        ENTITIES_MAGMA_CUBE = register("entities/magma_cube");
        ENTITIES_GHAST = register("entities/ghast");
        ENTITIES_SQUID = register("entities/squid");
        ENTITIES_ENDERMITE = register("entities/endermite");
        ENTITIES_ZOMBIE = register("entities/zombie");
        ENTITIES_ZOMBIE_PIGMAN = register("entities/zombie_pigman");
        ENTITIES_SKELETON = register("entities/skeleton");
        ENTITIES_WITHER_SKELETON = register("entities/wither_skeleton");
        ENTITIES_STRAY = register("entities/stray");
        field_191182_ar = register("entities/husk");
        field_191183_as = register("entities/zombie_villager");
        field_191184_at = register("entities/villager");
        field_191185_au = register("entities/evocation_illager");
        field_191186_av = register("entities/vindication_illager");
        field_191187_aw = register("entities/llama");
        field_192561_ax = register("entities/parrot");
        field_191188_ax = register("entities/vex");
        field_191189_ay = register("entities/ender_dragon");
        GAMEPLAY_FISHING = register("gameplay/fishing");
        GAMEPLAY_FISHING_JUNK = register("gameplay/fishing/junk");
        GAMEPLAY_FISHING_TREASURE = register("gameplay/fishing/treasure");
        GAMEPLAY_FISHING_FISH = register("gameplay/fishing/fish");
    }
}
