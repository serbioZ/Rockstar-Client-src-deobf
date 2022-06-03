// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;
import com.google.common.collect.Sets;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.WorldServer;
import net.minecraft.util.DamageSource;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.Set;

public class LootContext
{
    private final /* synthetic */ float luck;
    private final /* synthetic */ Set<LootTable> lootTables;
    @Nullable
    private final /* synthetic */ Entity lootedEntity;
    @Nullable
    private final /* synthetic */ DamageSource damageSource;
    private final /* synthetic */ LootTableManager lootTableManager;
    private final /* synthetic */ WorldServer worldObj;
    @Nullable
    private final /* synthetic */ EntityPlayer player;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget;
    
    @Nullable
    public Entity getEntity(final EntityTarget llllllllllllllIIlIllIIlllllIlIll) {
        switch ($SWITCH_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget()[llllllllllllllIIlIllIIlllllIlIll.ordinal()]) {
            case 1: {
                return this.getLootedEntity();
            }
            case 2: {
                return this.getKiller();
            }
            case 3: {
                return this.getKillerPlayer();
            }
            default: {
                return null;
            }
        }
    }
    
    public LootTableManager getLootTableManager() {
        return this.lootTableManager;
    }
    
    public LootContext(final float llllllllllllllIIlIllIlIIIIIlIIIl, final WorldServer llllllllllllllIIlIllIlIIIIIlIIII, final LootTableManager llllllllllllllIIlIllIlIIIIIlIllI, @Nullable final Entity llllllllllllllIIlIllIlIIIIIIlllI, @Nullable final EntityPlayer llllllllllllllIIlIllIlIIIIIIllIl, @Nullable final DamageSource llllllllllllllIIlIllIlIIIIIlIIll) {
        this.lootTables = (Set<LootTable>)Sets.newLinkedHashSet();
        this.luck = llllllllllllllIIlIllIlIIIIIlIIIl;
        this.worldObj = llllllllllllllIIlIllIlIIIIIlIIII;
        this.lootTableManager = llllllllllllllIIlIllIlIIIIIlIllI;
        this.lootedEntity = llllllllllllllIIlIllIlIIIIIIlllI;
        this.player = llllllllllllllIIlIllIlIIIIIIllIl;
        this.damageSource = llllllllllllllIIlIllIlIIIIIlIIll;
    }
    
    @Nullable
    public Entity getLootedEntity() {
        return this.lootedEntity;
    }
    
    public float getLuck() {
        return this.luck;
    }
    
    public void removeLootTable(final LootTable llllllllllllllIIlIllIIlllllllIIl) {
        this.lootTables.remove(llllllllllllllIIlIllIIlllllllIIl);
    }
    
    @Nullable
    public Entity getKillerPlayer() {
        return this.player;
    }
    
    @Nullable
    public Entity getKiller() {
        return (this.damageSource == null) ? null : this.damageSource.getEntity();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget() {
        final int[] $switch_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget = LootContext.$SWITCH_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget;
        if ($switch_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget != null) {
            return $switch_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget;
        }
        final int llllllllllllllIIlIllIIlllllIlIIl = (Object)new int[EntityTarget.values().length];
        try {
            llllllllllllllIIlIllIIlllllIlIIl[EntityTarget.KILLER.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIllIIlllllIlIIl[EntityTarget.KILLER_PLAYER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIlIllIIlllllIlIIl[EntityTarget.THIS.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return LootContext.$SWITCH_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget = (int[])(Object)llllllllllllllIIlIllIIlllllIlIIl;
    }
    
    public boolean addLootTable(final LootTable llllllllllllllIIlIllIIllllllllIl) {
        return this.lootTables.add(llllllllllllllIIlIllIIllllllllIl);
    }
    
    public static class Builder
    {
        private /* synthetic */ DamageSource damageSource;
        private /* synthetic */ Entity lootedEntity;
        private /* synthetic */ EntityPlayer player;
        private final /* synthetic */ WorldServer worldObj;
        private /* synthetic */ float luck;
        
        public Builder(final WorldServer lllllllllllIIIlIlIIlIIlIIIllIIll) {
            this.worldObj = lllllllllllIIIlIlIIlIIlIIIllIIll;
        }
        
        public LootContext build() {
            return new LootContext(this.luck, this.worldObj, this.worldObj.getLootTableManager(), this.lootedEntity, this.player, this.damageSource);
        }
        
        public Builder withLuck(final float lllllllllllIIIlIlIIlIIlIIIlIlIll) {
            this.luck = lllllllllllIIIlIlIIlIIlIIIlIlIll;
            return this;
        }
        
        public Builder withLootedEntity(final Entity lllllllllllIIIlIlIIlIIlIIIlIIlll) {
            this.lootedEntity = lllllllllllIIIlIlIIlIIlIIIlIIlll;
            return this;
        }
        
        public Builder withPlayer(final EntityPlayer lllllllllllIIIlIlIIlIIlIIIlIIIIl) {
            this.player = lllllllllllIIIlIlIIlIIlIIIlIIIIl;
            return this;
        }
        
        public Builder withDamageSource(final DamageSource lllllllllllIIIlIlIIlIIlIIIIllIll) {
            this.damageSource = lllllllllllIIIlIlIIlIIlIIIIllIll;
            return this;
        }
    }
    
    public enum EntityTarget
    {
        KILLER_PLAYER("KILLER_PLAYER", 2, "killer_player"), 
        KILLER("KILLER", 1, "killer");
        
        private final /* synthetic */ String targetType;
        
        THIS("THIS", 0, "this");
        
        private EntityTarget(final String lllllllllllIIllIlllIIllllllIlllI, final int lllllllllllIIllIlllIIllllllIllIl, final String lllllllllllIIllIlllIIlllllllIIII) {
            this.targetType = lllllllllllIIllIlllIIlllllllIIII;
        }
        
        public static EntityTarget fromString(final String lllllllllllIIllIlllIIllllllIIlII) {
            final float lllllllllllIIllIlllIIllllllIIIII;
            final float lllllllllllIIllIlllIIllllllIIIIl = ((EntityTarget[])(Object)(lllllllllllIIllIlllIIllllllIIIII = (float)(Object)values())).length;
            for (final EntityTarget lllllllllllIIllIlllIIllllllIIlIl : lllllllllllIIllIlllIIllllllIIIII) {
                if (lllllllllllIIllIlllIIllllllIIlIl.targetType.equals(lllllllllllIIllIlllIIllllllIIlII)) {
                    return lllllllllllIIllIlllIIllllllIIlIl;
                }
            }
            throw new IllegalArgumentException("Invalid entity target " + lllllllllllIIllIlllIIllllllIIlII);
        }
        
        public static class Serializer extends TypeAdapter<EntityTarget>
        {
            public void write(final JsonWriter lllllllllllIIIllIlIIIlIIlIllIlll, final EntityTarget lllllllllllIIIllIlIIIlIIlIllIllI) throws IOException {
                lllllllllllIIIllIlIIIlIIlIllIlll.value(lllllllllllIIIllIlIIIlIIlIllIllI.targetType);
            }
            
            public EntityTarget read(final JsonReader lllllllllllIIIllIlIIIlIIlIllIIll) throws IOException {
                return EntityTarget.fromString(lllllllllllIIIllIlIIIlIIlIllIIll.nextString());
            }
        }
    }
}
