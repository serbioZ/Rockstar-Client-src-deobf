// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import com.google.common.collect.Maps;
import java.util.Locale;
import net.minecraft.world.biome.Biome;
import net.minecraft.init.Biomes;
import java.util.Collection;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.Lists;
import java.util.Map;
import java.util.List;

public class FlatGeneratorInfo
{
    private final /* synthetic */ List<FlatLayerInfo> flatLayers;
    private final /* synthetic */ Map<String, Map<String, String>> worldFeatures;
    private /* synthetic */ int biomeToUse;
    
    private static List<FlatLayerInfo> getLayersFromString(final int llllllllllllllIllIIlIIlIllIlIlIl, final String llllllllllllllIllIIlIIlIllIllIll) {
        if (llllllllllllllIllIIlIIlIllIllIll != null && llllllllllllllIllIIlIIlIllIllIll.length() >= 1) {
            final List<FlatLayerInfo> llllllllllllllIllIIlIIlIllIllIlI = (List<FlatLayerInfo>)Lists.newArrayList();
            final String[] llllllllllllllIllIIlIIlIllIllIIl = llllllllllllllIllIIlIIlIllIllIll.split(",");
            int llllllllllllllIllIIlIIlIllIllIII = 0;
            final short llllllllllllllIllIIlIIlIllIIllIl;
            final char llllllllllllllIllIIlIIlIllIIlllI = (char)((String[])(Object)(llllllllllllllIllIIlIIlIllIIllIl = (short)(Object)llllllllllllllIllIIlIIlIllIllIIl)).length;
            for (short llllllllllllllIllIIlIIlIllIIllll = 0; llllllllllllllIllIIlIIlIllIIllll < llllllllllllllIllIIlIIlIllIIlllI; ++llllllllllllllIllIIlIIlIllIIllll) {
                final String llllllllllllllIllIIlIIlIllIlIlll = llllllllllllllIllIIlIIlIllIIllIl[llllllllllllllIllIIlIIlIllIIllll];
                final FlatLayerInfo llllllllllllllIllIIlIIlIllIlIllI = getLayerFromString(llllllllllllllIllIIlIIlIllIlIlIl, llllllllllllllIllIIlIIlIllIlIlll, llllllllllllllIllIIlIIlIllIllIII);
                if (llllllllllllllIllIIlIIlIllIlIllI == null) {
                    return null;
                }
                llllllllllllllIllIIlIIlIllIllIlI.add(llllllllllllllIllIIlIIlIllIlIllI);
                llllllllllllllIllIIlIIlIllIllIII += llllllllllllllIllIIlIIlIllIlIllI.getLayerCount();
            }
            return llllllllllllllIllIIlIIlIllIllIlI;
        }
        return null;
    }
    
    public static FlatGeneratorInfo createFlatGeneratorFromString(final String llllllllllllllIllIIlIIlIlIlIlIIl) {
        if (llllllllllllllIllIIlIIlIlIlIlIIl == null) {
            return getDefaultFlatGenerator();
        }
        final String[] llllllllllllllIllIIlIIlIlIllIllI = llllllllllllllIllIIlIIlIlIlIlIIl.split(";", -1);
        final int llllllllllllllIllIIlIIlIlIllIlIl = (llllllllllllllIllIIlIIlIlIllIllI.length == 1) ? 0 : MathHelper.getInt(llllllllllllllIllIIlIIlIlIllIllI[0], 0);
        if (llllllllllllllIllIIlIIlIlIllIlIl < 0 || llllllllllllllIllIIlIIlIlIllIlIl > 3) {
            return getDefaultFlatGenerator();
        }
        final FlatGeneratorInfo llllllllllllllIllIIlIIlIlIllIlII = new FlatGeneratorInfo();
        int llllllllllllllIllIIlIIlIlIllIIll = (llllllllllllllIllIIlIIlIlIllIllI.length != 1) ? 1 : 0;
        final List<FlatLayerInfo> llllllllllllllIllIIlIIlIlIllIIlI = getLayersFromString(llllllllllllllIllIIlIIlIlIllIlIl, llllllllllllllIllIIlIIlIlIllIllI[llllllllllllllIllIIlIIlIlIllIIll++]);
        if (llllllllllllllIllIIlIIlIlIllIIlI != null && !llllllllllllllIllIIlIIlIlIllIIlI.isEmpty()) {
            llllllllllllllIllIIlIIlIlIllIlII.getFlatLayers().addAll(llllllllllllllIllIIlIIlIlIllIIlI);
            llllllllllllllIllIIlIIlIlIllIlII.updateLayers();
            int llllllllllllllIllIIlIIlIlIllIIIl = Biome.getIdForBiome(Biomes.PLAINS);
            if (llllllllllllllIllIIlIIlIlIllIlIl > 0 && llllllllllllllIllIIlIIlIlIllIllI.length > llllllllllllllIllIIlIIlIlIllIIll) {
                llllllllllllllIllIIlIIlIlIllIIIl = MathHelper.getInt(llllllllllllllIllIIlIIlIlIllIllI[llllllllllllllIllIIlIIlIlIllIIll++], llllllllllllllIllIIlIIlIlIllIIIl);
            }
            llllllllllllllIllIIlIIlIlIllIlII.setBiome(llllllllllllllIllIIlIIlIlIllIIIl);
            if (llllllllllllllIllIIlIIlIlIllIlIl > 0 && llllllllllllllIllIIlIIlIlIllIllI.length > llllllllllllllIllIIlIIlIlIllIIll) {
                final String[] llllllllllllllIllIIlIIlIlIllIIII = llllllllllllllIllIIlIIlIlIllIllI[llllllllllllllIllIIlIIlIlIllIIll++].toLowerCase(Locale.ROOT).split(",");
                final char llllllllllllllIllIIlIIlIlIIllllI;
                final long llllllllllllllIllIIlIIlIlIIlllll = ((String[])(Object)(llllllllllllllIllIIlIIlIlIIllllI = (char)(Object)llllllllllllllIllIIlIIlIlIllIIII)).length;
                for (byte llllllllllllllIllIIlIIlIlIlIIIII = 0; llllllllllllllIllIIlIIlIlIlIIIII < llllllllllllllIllIIlIIlIlIIlllll; ++llllllllllllllIllIIlIIlIlIlIIIII) {
                    final String llllllllllllllIllIIlIIlIlIlIllll = llllllllllllllIllIIlIIlIlIIllllI[llllllllllllllIllIIlIIlIlIlIIIII];
                    final String[] llllllllllllllIllIIlIIlIlIlIlllI = llllllllllllllIllIIlIIlIlIlIllll.split("\\(", 2);
                    final Map<String, String> llllllllllllllIllIIlIIlIlIlIllIl = (Map<String, String>)Maps.newHashMap();
                    if (!llllllllllllllIllIIlIIlIlIlIlllI[0].isEmpty()) {
                        llllllllllllllIllIIlIIlIlIllIlII.getWorldFeatures().put(llllllllllllllIllIIlIIlIlIlIlllI[0], llllllllllllllIllIIlIIlIlIlIllIl);
                        if (llllllllllllllIllIIlIIlIlIlIlllI.length > 1 && llllllllllllllIllIIlIIlIlIlIlllI[1].endsWith(")") && llllllllllllllIllIIlIIlIlIlIlllI[1].length() > 1) {
                            final String[] llllllllllllllIllIIlIIlIlIlIllII = llllllllllllllIllIIlIIlIlIlIlllI[1].substring(0, llllllllllllllIllIIlIIlIlIlIlllI[1].length() - 1).split(" ");
                            final char llllllllllllllIllIIlIIlIlIIlIlll;
                            final Exception llllllllllllllIllIIlIIlIlIIllIII = (Exception)((String[])(Object)(llllllllllllllIllIIlIIlIlIIlIlll = (char)(Object)llllllllllllllIllIIlIIlIlIlIllII)).length;
                            for (short llllllllllllllIllIIlIIlIlIIllIIl = 0; llllllllllllllIllIIlIIlIlIIllIIl < llllllllllllllIllIIlIIlIlIIllIII; ++llllllllllllllIllIIlIIlIlIIllIIl) {
                                final String llllllllllllllIllIIlIIlIlIlIlIll = llllllllllllllIllIIlIIlIlIIlIlll[llllllllllllllIllIIlIIlIlIIllIIl];
                                final String[] llllllllllllllIllIIlIIlIlIlIlIlI = llllllllllllllIllIIlIIlIlIlIlIll.split("=", 2);
                                if (llllllllllllllIllIIlIIlIlIlIlIlI.length == 2) {
                                    llllllllllllllIllIIlIIlIlIlIllIl.put(llllllllllllllIllIIlIIlIlIlIlIlI[0], llllllllllllllIllIIlIIlIlIlIlIlI[1]);
                                }
                            }
                        }
                    }
                }
            }
            else {
                llllllllllllllIllIIlIIlIlIllIlII.getWorldFeatures().put("village", Maps.newHashMap());
            }
            return llllllllllllllIllIIlIIlIlIllIlII;
        }
        return getDefaultFlatGenerator();
    }
    
    public void updateLayers() {
        int llllllllllllllIllIIlIIllIIlIIIll = 0;
        for (final FlatLayerInfo llllllllllllllIllIIlIIllIIlIIIlI : this.flatLayers) {
            llllllllllllllIllIIlIIllIIlIIIlI.setMinY(llllllllllllllIllIIlIIllIIlIIIll);
            llllllllllllllIllIIlIIllIIlIIIll += llllllllllllllIllIIlIIllIIlIIIlI.getLayerCount();
        }
    }
    
    private static FlatLayerInfo getLayerFromString(final int llllllllllllllIllIIlIIlIlllllIll, final String llllllllllllllIllIIlIIlIlllIllIl, final int llllllllllllllIllIIlIIlIlllllIIl) {
        String[] llllllllllllllIllIIlIIlIlllllIII = (llllllllllllllIllIIlIIlIlllllIll >= 3) ? llllllllllllllIllIIlIIlIlllIllIl.split("\\*", 2) : llllllllllllllIllIIlIIlIlllIllIl.split("x", 2);
        int llllllllllllllIllIIlIIlIllllIlll = 1;
        int llllllllllllllIllIIlIIlIllllIllI = 0;
        if (llllllllllllllIllIIlIIlIlllllIII.length == 2) {
            try {
                llllllllllllllIllIIlIIlIllllIlll = Integer.parseInt(llllllllllllllIllIIlIIlIlllllIII[0]);
                if (llllllllllllllIllIIlIIlIlllllIIl + llllllllllllllIllIIlIIlIllllIlll >= 256) {
                    llllllllllllllIllIIlIIlIllllIlll = 256 - llllllllllllllIllIIlIIlIlllllIIl;
                }
                if (llllllllllllllIllIIlIIlIllllIlll < 0) {
                    llllllllllllllIllIIlIIlIllllIlll = 0;
                }
            }
            catch (Throwable llllllllllllllIllIIlIIlIllllIlIl) {
                return null;
            }
        }
        try {
            final String llllllllllllllIllIIlIIlIllllIIIl = llllllllllllllIllIIlIIlIlllllIII[llllllllllllllIllIIlIIlIlllllIII.length - 1];
            Block llllllllllllllIllIIlIIlIllllIIll = null;
            if (llllllllllllllIllIIlIIlIlllllIll < 3) {
                llllllllllllllIllIIlIIlIlllllIII = llllllllllllllIllIIlIIlIllllIIIl.split(":", 2);
                if (llllllllllllllIllIIlIIlIlllllIII.length > 1) {
                    llllllllllllllIllIIlIIlIllllIllI = Integer.parseInt(llllllllllllllIllIIlIIlIlllllIII[1]);
                }
                final Block llllllllllllllIllIIlIIlIllllIlII = Block.getBlockById(Integer.parseInt(llllllllllllllIllIIlIIlIlllllIII[0]));
            }
            else {
                llllllllllllllIllIIlIIlIlllllIII = llllllllllllllIllIIlIIlIllllIIIl.split(":", 3);
                llllllllllllllIllIIlIIlIllllIIll = ((llllllllllllllIllIIlIIlIlllllIII.length > 1) ? Block.getBlockFromName(String.valueOf(llllllllllllllIllIIlIIlIlllllIII[0]) + ":" + llllllllllllllIllIIlIIlIlllllIII[1]) : null);
                if (llllllllllllllIllIIlIIlIllllIIll != null) {
                    llllllllllllllIllIIlIIlIllllIllI = ((llllllllllllllIllIIlIIlIlllllIII.length > 2) ? Integer.parseInt(llllllllllllllIllIIlIIlIlllllIII[2]) : 0);
                }
                else {
                    llllllllllllllIllIIlIIlIllllIIll = Block.getBlockFromName(llllllllllllllIllIIlIIlIlllllIII[0]);
                    if (llllllllllllllIllIIlIIlIllllIIll != null) {
                        llllllllllllllIllIIlIIlIllllIllI = ((llllllllllllllIllIIlIIlIlllllIII.length > 1) ? Integer.parseInt(llllllllllllllIllIIlIIlIlllllIII[1]) : 0);
                    }
                }
                if (llllllllllllllIllIIlIIlIllllIIll == null) {
                    return null;
                }
            }
            if (llllllllllllllIllIIlIIlIllllIIll == Blocks.AIR) {
                llllllllllllllIllIIlIIlIllllIllI = 0;
            }
            if (llllllllllllllIllIIlIIlIllllIllI < 0 || llllllllllllllIllIIlIIlIllllIllI > 15) {
                llllllllllllllIllIIlIIlIllllIllI = 0;
            }
        }
        catch (Throwable llllllllllllllIllIIlIIlIllllIIII) {
            return null;
        }
        final Block llllllllllllllIllIIlIIlIllllIIlI;
        final FlatLayerInfo llllllllllllllIllIIlIIlIlllIllll = new FlatLayerInfo(llllllllllllllIllIIlIIlIlllllIll, llllllllllllllIllIIlIIlIllllIlll, llllllllllllllIllIIlIIlIllllIIlI, llllllllllllllIllIIlIIlIllllIllI);
        llllllllllllllIllIIlIIlIlllIllll.setMinY(llllllllllllllIllIIlIIlIlllllIIl);
        return llllllllllllllIllIIlIIlIlllIllll;
    }
    
    public static FlatGeneratorInfo getDefaultFlatGenerator() {
        final FlatGeneratorInfo llllllllllllllIllIIlIIlIlIIlIlII = new FlatGeneratorInfo();
        llllllllllllllIllIIlIIlIlIIlIlII.setBiome(Biome.getIdForBiome(Biomes.PLAINS));
        llllllllllllllIllIIlIIlIlIIlIlII.getFlatLayers().add(new FlatLayerInfo(1, Blocks.BEDROCK));
        llllllllllllllIllIIlIIlIlIIlIlII.getFlatLayers().add(new FlatLayerInfo(2, Blocks.DIRT));
        llllllllllllllIllIIlIIlIlIIlIlII.getFlatLayers().add(new FlatLayerInfo(1, Blocks.GRASS));
        llllllllllllllIllIIlIIlIlIIlIlII.updateLayers();
        llllllllllllllIllIIlIIlIlIIlIlII.getWorldFeatures().put("village", Maps.newHashMap());
        return llllllllllllllIllIIlIIlIlIIlIlII;
    }
    
    public int getBiome() {
        return this.biomeToUse;
    }
    
    public FlatGeneratorInfo() {
        this.flatLayers = (List<FlatLayerInfo>)Lists.newArrayList();
        this.worldFeatures = (Map<String, Map<String, String>>)Maps.newHashMap();
    }
    
    @Override
    public String toString() {
        final StringBuilder llllllllllllllIllIIlIIllIIIlIIll = new StringBuilder();
        llllllllllllllIllIIlIIllIIIlIIll.append(3);
        llllllllllllllIllIIlIIllIIIlIIll.append(";");
        for (int llllllllllllllIllIIlIIllIIIlIIlI = 0; llllllllllllllIllIIlIIllIIIlIIlI < this.flatLayers.size(); ++llllllllllllllIllIIlIIllIIIlIIlI) {
            if (llllllllllllllIllIIlIIllIIIlIIlI > 0) {
                llllllllllllllIllIIlIIllIIIlIIll.append(",");
            }
            llllllllllllllIllIIlIIllIIIlIIll.append(this.flatLayers.get(llllllllllllllIllIIlIIllIIIlIIlI));
        }
        llllllllllllllIllIIlIIllIIIlIIll.append(";");
        llllllllllllllIllIIlIIllIIIlIIll.append(this.biomeToUse);
        if (this.worldFeatures.isEmpty()) {
            llllllllllllllIllIIlIIllIIIlIIll.append(";");
        }
        else {
            llllllllllllllIllIIlIIllIIIlIIll.append(";");
            int llllllllllllllIllIIlIIllIIIlIIIl = 0;
            for (final Map.Entry<String, Map<String, String>> llllllllllllllIllIIlIIllIIIlIIII : this.worldFeatures.entrySet()) {
                if (llllllllllllllIllIIlIIllIIIlIIIl++ > 0) {
                    llllllllllllllIllIIlIIllIIIlIIll.append(",");
                }
                llllllllllllllIllIIlIIllIIIlIIll.append(llllllllllllllIllIIlIIllIIIlIIII.getKey().toLowerCase(Locale.ROOT));
                final Map<String, String> llllllllllllllIllIIlIIllIIIIllll = llllllllllllllIllIIlIIllIIIlIIII.getValue();
                if (!llllllllllllllIllIIlIIllIIIIllll.isEmpty()) {
                    llllllllllllllIllIIlIIllIIIlIIll.append("(");
                    int llllllllllllllIllIIlIIllIIIIlllI = 0;
                    for (final Map.Entry<String, String> llllllllllllllIllIIlIIllIIIIllIl : llllllllllllllIllIIlIIllIIIIllll.entrySet()) {
                        if (llllllllllllllIllIIlIIllIIIIlllI++ > 0) {
                            llllllllllllllIllIIlIIllIIIlIIll.append(" ");
                        }
                        llllllllllllllIllIIlIIllIIIlIIll.append(llllllllllllllIllIIlIIllIIIIllIl.getKey());
                        llllllllllllllIllIIlIIllIIIlIIll.append("=");
                        llllllllllllllIllIIlIIllIIIlIIll.append(llllllllllllllIllIIlIIllIIIIllIl.getValue());
                    }
                    llllllllllllllIllIIlIIllIIIlIIll.append(")");
                }
            }
        }
        return llllllllllllllIllIIlIIllIIIlIIll.toString();
    }
    
    public List<FlatLayerInfo> getFlatLayers() {
        return this.flatLayers;
    }
    
    public void setBiome(final int llllllllllllllIllIIlIIllIIlIllll) {
        this.biomeToUse = llllllllllllllIllIIlIIllIIlIllll;
    }
    
    public Map<String, Map<String, String>> getWorldFeatures() {
        return this.worldFeatures;
    }
}
