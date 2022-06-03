// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.stats;

import com.google.gson.JsonParseException;
import com.google.common.collect.Sets;
import net.minecraft.entity.player.EntityPlayer;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import java.lang.reflect.Constructor;
import com.google.gson.JsonObject;
import net.minecraft.util.IJsonSerializable;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.minecraft.util.TupleIntJsonSerializable;
import org.apache.logging.log4j.LogManager;
import java.util.Map;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketStatistics;
import com.google.common.collect.Maps;
import net.minecraft.entity.player.EntityPlayerMP;
import java.util.Collection;
import java.util.Set;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.Logger;
import java.io.File;

public class StatisticsManagerServer extends StatisticsManager
{
    private final /* synthetic */ File statsFile;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ MinecraftServer mcServer;
    private final /* synthetic */ Set<StatBase> dirty;
    private /* synthetic */ int lastStatRequest;
    
    public void markAllDirty() {
        this.dirty.addAll(this.statsData.keySet());
    }
    
    public void sendStats(final EntityPlayerMP llllllllllIlllllllllIllllIlIIlll) {
        final int llllllllllIlllllllllIllllIlIIllI = this.mcServer.getTickCounter();
        final Map<StatBase, Integer> llllllllllIlllllllllIllllIlIIlIl = (Map<StatBase, Integer>)Maps.newHashMap();
        if (llllllllllIlllllllllIllllIlIIllI - this.lastStatRequest > 300) {
            this.lastStatRequest = llllllllllIlllllllllIllllIlIIllI;
            for (final StatBase llllllllllIlllllllllIllllIlIIlII : this.getDirty()) {
                llllllllllIlllllllllIllllIlIIlIl.put(llllllllllIlllllllllIllllIlIIlII, this.readStat(llllllllllIlllllllllIllllIlIIlII));
            }
        }
        llllllllllIlllllllllIllllIlIIlll.connection.sendPacket(new SPacketStatistics(llllllllllIlllllllllIllllIlIIlIl));
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public Map<StatBase, TupleIntJsonSerializable> parseJson(final String llllllllllIlllllllllIlllllIllIIl) {
        final JsonElement llllllllllIlllllllllIlllllIllIII = new JsonParser().parse(llllllllllIlllllllllIlllllIllIIl);
        if (!llllllllllIlllllllllIlllllIllIII.isJsonObject()) {
            return (Map<StatBase, TupleIntJsonSerializable>)Maps.newHashMap();
        }
        final JsonObject llllllllllIlllllllllIlllllIlIlll = llllllllllIlllllllllIlllllIllIII.getAsJsonObject();
        final Map<StatBase, TupleIntJsonSerializable> llllllllllIlllllllllIlllllIlIllI = (Map<StatBase, TupleIntJsonSerializable>)Maps.newHashMap();
        for (final Map.Entry<String, JsonElement> llllllllllIlllllllllIlllllIlIlIl : llllllllllIlllllllllIlllllIlIlll.entrySet()) {
            final StatBase llllllllllIlllllllllIlllllIlIlII = StatList.getOneShotStat(llllllllllIlllllllllIlllllIlIlIl.getKey());
            if (llllllllllIlllllllllIlllllIlIlII != null) {
                final TupleIntJsonSerializable llllllllllIlllllllllIlllllIlIIll = new TupleIntJsonSerializable();
                if (llllllllllIlllllllllIlllllIlIlIl.getValue().isJsonPrimitive() && llllllllllIlllllllllIlllllIlIlIl.getValue().getAsJsonPrimitive().isNumber()) {
                    llllllllllIlllllllllIlllllIlIIll.setIntegerValue(llllllllllIlllllllllIlllllIlIlIl.getValue().getAsInt());
                }
                else if (llllllllllIlllllllllIlllllIlIlIl.getValue().isJsonObject()) {
                    final JsonObject llllllllllIlllllllllIlllllIlIIlI = llllllllllIlllllllllIlllllIlIlIl.getValue().getAsJsonObject();
                    if (llllllllllIlllllllllIlllllIlIIlI.has("value") && llllllllllIlllllllllIlllllIlIIlI.get("value").isJsonPrimitive() && llllllllllIlllllllllIlllllIlIIlI.get("value").getAsJsonPrimitive().isNumber()) {
                        llllllllllIlllllllllIlllllIlIIll.setIntegerValue(llllllllllIlllllllllIlllllIlIIlI.getAsJsonPrimitive("value").getAsInt());
                    }
                    if (llllllllllIlllllllllIlllllIlIIlI.has("progress") && llllllllllIlllllllllIlllllIlIlII.getSerializableClazz() != null) {
                        try {
                            final Constructor<? extends IJsonSerializable> llllllllllIlllllllllIlllllIlIIIl = llllllllllIlllllllllIlllllIlIlII.getSerializableClazz().getConstructor((Class<?>[])new Class[0]);
                            final IJsonSerializable llllllllllIlllllllllIlllllIlIIII = (IJsonSerializable)llllllllllIlllllllllIlllllIlIIIl.newInstance(new Object[0]);
                            llllllllllIlllllllllIlllllIlIIII.fromJson(llllllllllIlllllllllIlllllIlIIlI.get("progress"));
                            llllllllllIlllllllllIlllllIlIIll.setJsonSerializableValue(llllllllllIlllllllllIlllllIlIIII);
                        }
                        catch (Throwable llllllllllIlllllllllIlllllIIllll) {
                            StatisticsManagerServer.LOGGER.warn("Invalid statistic progress in {}", (Object)this.statsFile, (Object)llllllllllIlllllllllIlllllIIllll);
                        }
                    }
                }
                llllllllllIlllllllllIlllllIlIllI.put(llllllllllIlllllllllIlllllIlIlII, llllllllllIlllllllllIlllllIlIIll);
            }
            else {
                StatisticsManagerServer.LOGGER.warn("Invalid statistic in {}: Don't know what {} is", (Object)this.statsFile, (Object)llllllllllIlllllllllIlllllIlIlIl.getKey());
            }
        }
        return llllllllllIlllllllllIlllllIlIllI;
    }
    
    public static String dumpJson(final Map<StatBase, TupleIntJsonSerializable> llllllllllIlllllllllIllllIllllII) {
        final JsonObject llllllllllIlllllllllIllllIlllIll = new JsonObject();
        for (final Map.Entry<StatBase, TupleIntJsonSerializable> llllllllllIlllllllllIllllIlllIlI : llllllllllIlllllllllIllllIllllII.entrySet()) {
            if (llllllllllIlllllllllIllllIlllIlI.getValue().getJsonSerializableValue() != null) {
                final JsonObject llllllllllIlllllllllIllllIlllIIl = new JsonObject();
                llllllllllIlllllllllIllllIlllIIl.addProperty("value", (Number)llllllllllIlllllllllIllllIlllIlI.getValue().getIntegerValue());
                try {
                    llllllllllIlllllllllIllllIlllIIl.add("progress", llllllllllIlllllllllIllllIlllIlI.getValue().getJsonSerializableValue().getSerializableElement());
                }
                catch (Throwable llllllllllIlllllllllIllllIlllIII) {
                    StatisticsManagerServer.LOGGER.warn("Couldn't save statistic {}: error serializing progress", (Object)llllllllllIlllllllllIllllIlllIlI.getKey().getStatName(), (Object)llllllllllIlllllllllIllllIlllIII);
                }
                llllllllllIlllllllllIllllIlllIll.add(llllllllllIlllllllllIllllIlllIlI.getKey().statId, (JsonElement)llllllllllIlllllllllIllllIlllIIl);
            }
            else {
                llllllllllIlllllllllIllllIlllIll.addProperty(llllllllllIlllllllllIllllIlllIlI.getKey().statId, (Number)llllllllllIlllllllllIllllIlllIlI.getValue().getIntegerValue());
            }
        }
        return llllllllllIlllllllllIllllIlllIll.toString();
    }
    
    public void saveStatFile() {
        try {
            FileUtils.writeStringToFile(this.statsFile, dumpJson(this.statsData));
        }
        catch (IOException llllllllllIlllllllllIllllllllIll) {
            StatisticsManagerServer.LOGGER.error("Couldn't save stats", (Throwable)llllllllllIlllllllllIllllllllIll);
        }
    }
    
    @Override
    public void unlockAchievement(final EntityPlayer llllllllllIlllllllllIllllllIllll, final StatBase llllllllllIlllllllllIllllllIlllI, final int llllllllllIlllllllllIlllllllIIIl) {
        super.unlockAchievement(llllllllllIlllllllllIllllllIllll, llllllllllIlllllllllIllllllIlllI, llllllllllIlllllllllIlllllllIIIl);
        this.dirty.add(llllllllllIlllllllllIllllllIlllI);
    }
    
    public StatisticsManagerServer(final MinecraftServer llllllllllIllllllllllIIIIIIIIlll, final File llllllllllIllllllllllIIIIIIIlIIl) {
        this.dirty = (Set<StatBase>)Sets.newHashSet();
        this.lastStatRequest = -300;
        this.mcServer = llllllllllIllllllllllIIIIIIIIlll;
        this.statsFile = llllllllllIllllllllllIIIIIIIlIIl;
    }
    
    public void readStatFile() {
        if (this.statsFile.isFile()) {
            try {
                this.statsData.clear();
                this.statsData.putAll(this.parseJson(FileUtils.readFileToString(this.statsFile)));
            }
            catch (IOException llllllllllIllllllllllIIIIIIIIIlI) {
                StatisticsManagerServer.LOGGER.error("Couldn't read statistics file {}", (Object)this.statsFile, (Object)llllllllllIllllllllllIIIIIIIIIlI);
            }
            catch (JsonParseException llllllllllIllllllllllIIIIIIIIIIl) {
                StatisticsManagerServer.LOGGER.error("Couldn't parse statistics file {}", (Object)this.statsFile, (Object)llllllllllIllllllllllIIIIIIIIIIl);
            }
        }
    }
    
    private Set<StatBase> getDirty() {
        final Set<StatBase> llllllllllIlllllllllIllllllIlIIl = (Set<StatBase>)Sets.newHashSet((Iterable)this.dirty);
        this.dirty.clear();
        return llllllllllIlllllllllIllllllIlIIl;
    }
}
