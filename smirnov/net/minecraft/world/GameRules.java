// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import java.util.Set;
import net.minecraft.nbt.NBTTagCompound;
import java.util.TreeMap;

public class GameRules
{
    private final /* synthetic */ TreeMap<String, Value> theGameRules;
    
    public void readFromNBT(final NBTTagCompound llllllllllllllIIllIlIlIlIllIIIll) {
        for (final String llllllllllllllIIllIlIlIlIllIIIlI : llllllllllllllIIllIlIlIlIllIIIll.getKeySet()) {
            this.setOrCreateGameRule(llllllllllllllIIllIlIlIlIllIIIlI, llllllllllllllIIllIlIlIlIllIIIll.getString(llllllllllllllIIllIlIlIlIllIIIlI));
        }
    }
    
    public String[] getRules() {
        final Set<String> llllllllllllllIIllIlIlIlIlIllIlI = this.theGameRules.keySet();
        return llllllllllllllIIllIlIlIlIlIllIlI.toArray(new String[llllllllllllllIIllIlIlIlIlIllIlI.size()]);
    }
    
    public boolean hasRule(final String llllllllllllllIIllIlIlIlIlIlIIlI) {
        return this.theGameRules.containsKey(llllllllllllllIIllIlIlIlIlIlIIlI);
    }
    
    public boolean getBoolean(final String llllllllllllllIIllIlIlIllIIIIIIl) {
        final Value llllllllllllllIIllIlIlIllIIIIIll = this.theGameRules.get(llllllllllllllIIllIlIlIllIIIIIIl);
        return llllllllllllllIIllIlIlIllIIIIIll != null && llllllllllllllIIllIlIlIllIIIIIll.getBoolean();
    }
    
    public boolean areSameType(final String llllllllllllllIIllIlIlIlIlIIlIII, final ValueType llllllllllllllIIllIlIlIlIlIIlIll) {
        final Value llllllllllllllIIllIlIlIlIlIIlIlI = this.theGameRules.get(llllllllllllllIIllIlIlIlIlIIlIII);
        return llllllllllllllIIllIlIlIlIlIIlIlI != null && (llllllllllllllIIllIlIlIlIlIIlIlI.getType() == llllllllllllllIIllIlIlIlIlIIlIll || llllllllllllllIIllIlIlIlIlIIlIll == ValueType.ANY_VALUE);
    }
    
    public void addGameRule(final String llllllllllllllIIllIlIlIllIlIIlII, final String llllllllllllllIIllIlIlIllIlIIIll, final ValueType llllllllllllllIIllIlIlIllIlIIIlI) {
        this.theGameRules.put(llllllllllllllIIllIlIlIllIlIIlII, new Value(llllllllllllllIIllIlIlIllIlIIIll, llllllllllllllIIllIlIlIllIlIIIlI));
    }
    
    public int getInt(final String llllllllllllllIIllIlIlIlIllllIII) {
        final Value llllllllllllllIIllIlIlIlIllllIlI = this.theGameRules.get(llllllllllllllIIllIlIlIlIllllIII);
        return (llllllllllllllIIllIlIlIlIllllIlI != null) ? llllllllllllllIIllIlIlIlIllllIlI.getInt() : 0;
    }
    
    public String getString(final String llllllllllllllIIllIlIlIllIIIllIl) {
        final Value llllllllllllllIIllIlIlIllIIIllII = this.theGameRules.get(llllllllllllllIIllIlIlIllIIIllIl);
        return (llllllllllllllIIllIlIlIllIIIllII != null) ? llllllllllllllIIllIlIlIllIIIllII.getString() : "";
    }
    
    public GameRules() {
        this.theGameRules = new TreeMap<String, Value>();
        this.addGameRule("doFireTick", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("mobGriefing", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("keepInventory", "false", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doMobSpawning", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doMobLoot", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doTileDrops", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doEntityDrops", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("commandBlockOutput", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("naturalRegeneration", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doDaylightCycle", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("logAdminCommands", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("showDeathMessages", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("randomTickSpeed", "3", ValueType.NUMERICAL_VALUE);
        this.addGameRule("sendCommandFeedback", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("reducedDebugInfo", "false", ValueType.BOOLEAN_VALUE);
        this.addGameRule("spectatorsGenerateChunks", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("spawnRadius", "10", ValueType.NUMERICAL_VALUE);
        this.addGameRule("disableElytraMovementCheck", "false", ValueType.BOOLEAN_VALUE);
        this.addGameRule("maxEntityCramming", "24", ValueType.NUMERICAL_VALUE);
        this.addGameRule("doWeatherCycle", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doLimitedCrafting", "false", ValueType.BOOLEAN_VALUE);
        this.addGameRule("maxCommandChainLength", "65536", ValueType.NUMERICAL_VALUE);
        this.addGameRule("announceAdvancements", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("gameLoopFunction", "-", ValueType.FUNCTION);
    }
    
    public void setOrCreateGameRule(final String llllllllllllllIIllIlIlIllIIlIlII, final String llllllllllllllIIllIlIlIllIIlIIll) {
        final Value llllllllllllllIIllIlIlIllIIlIllI = this.theGameRules.get(llllllllllllllIIllIlIlIllIIlIlII);
        if (llllllllllllllIIllIlIlIllIIlIllI != null) {
            llllllllllllllIIllIlIlIllIIlIllI.setValue(llllllllllllllIIllIlIlIllIIlIIll);
        }
        else {
            this.addGameRule(llllllllllllllIIllIlIlIllIIlIlII, llllllllllllllIIllIlIlIllIIlIIll, ValueType.ANY_VALUE);
        }
    }
    
    public NBTTagCompound writeToNBT() {
        final NBTTagCompound llllllllllllllIIllIlIlIlIlllIIII = new NBTTagCompound();
        for (final String llllllllllllllIIllIlIlIlIllIllll : this.theGameRules.keySet()) {
            final Value llllllllllllllIIllIlIlIlIllIlllI = this.theGameRules.get(llllllllllllllIIllIlIlIlIllIllll);
            llllllllllllllIIllIlIlIlIlllIIII.setString(llllllllllllllIIllIlIlIlIllIllll, llllllllllllllIIllIlIlIlIllIlllI.getString());
        }
        return llllllllllllllIIllIlIlIlIlllIIII;
    }
    
    public enum ValueType
    {
        FUNCTION("FUNCTION", 3), 
        BOOLEAN_VALUE("BOOLEAN_VALUE", 1), 
        ANY_VALUE("ANY_VALUE", 0), 
        NUMERICAL_VALUE("NUMERICAL_VALUE", 2);
        
        private ValueType(final String lllllllllllIlIlllIlIlIllIllllIll, final int lllllllllllIlIlllIlIlIllIllllIlI) {
        }
    }
    
    static class Value
    {
        private /* synthetic */ String valueString;
        private final /* synthetic */ ValueType type;
        private /* synthetic */ double valueDouble;
        private /* synthetic */ int valueInteger;
        private /* synthetic */ boolean valueBoolean;
        
        public void setValue(final String llllllllllllIllIIIIIIllllIllIIIl) {
            this.valueString = llllllllllllIllIIIIIIllllIllIIIl;
            if (llllllllllllIllIIIIIIllllIllIIIl != null) {
                if (llllllllllllIllIIIIIIllllIllIIIl.equals("false")) {
                    this.valueBoolean = false;
                    return;
                }
                if (llllllllllllIllIIIIIIllllIllIIIl.equals("true")) {
                    this.valueBoolean = true;
                    return;
                }
            }
            this.valueBoolean = Boolean.parseBoolean(llllllllllllIllIIIIIIllllIllIIIl);
            this.valueInteger = (this.valueBoolean ? 1 : 0);
            try {
                this.valueInteger = Integer.parseInt(llllllllllllIllIIIIIIllllIllIIIl);
            }
            catch (NumberFormatException ex) {}
            try {
                this.valueDouble = Double.parseDouble(llllllllllllIllIIIIIIllllIllIIIl);
            }
            catch (NumberFormatException ex2) {}
        }
        
        public Value(final String llllllllllllIllIIIIIIllllIllllII, final ValueType llllllllllllIllIIIIIIllllIlllIll) {
            this.type = llllllllllllIllIIIIIIllllIlllIll;
            this.setValue(llllllllllllIllIIIIIIllllIllllII);
        }
        
        public int getInt() {
            return this.valueInteger;
        }
        
        public String getString() {
            return this.valueString;
        }
        
        public ValueType getType() {
            return this.type;
        }
        
        public boolean getBoolean() {
            return this.valueBoolean;
        }
    }
}
