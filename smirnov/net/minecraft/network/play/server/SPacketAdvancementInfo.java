// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.util.Collection;
import java.io.IOException;
import com.google.common.collect.Sets;
import com.google.common.collect.Maps;
import net.minecraft.network.PacketBuffer;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import java.util.Set;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketAdvancementInfo implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ Set<ResourceLocation> field_192607_c;
    private /* synthetic */ Map<ResourceLocation, Advancement.Builder> field_192606_b;
    private /* synthetic */ boolean field_192605_a;
    private /* synthetic */ Map<ResourceLocation, AdvancementProgress> field_192608_d;
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIlIlIIlIIlIIIIIIlIIIl) {
        lllllllllllIlIlIIlIIlIIIIIIlIIIl.func_191981_a(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlIlIIlIIlIIIIIIIIlll) throws IOException {
        this.field_192605_a = lllllllllllIlIlIIlIIlIIIIIIIIlll.readBoolean();
        this.field_192606_b = (Map<ResourceLocation, Advancement.Builder>)Maps.newHashMap();
        this.field_192607_c = (Set<ResourceLocation>)Sets.newLinkedHashSet();
        this.field_192608_d = (Map<ResourceLocation, AdvancementProgress>)Maps.newHashMap();
        for (int lllllllllllIlIlIIlIIlIIIIIIIIllI = lllllllllllIlIlIIlIIlIIIIIIIIlll.readVarIntFromBuffer(), lllllllllllIlIlIIlIIlIIIIIIIIlIl = 0; lllllllllllIlIlIIlIIlIIIIIIIIlIl < lllllllllllIlIlIIlIIlIIIIIIIIllI; ++lllllllllllIlIlIIlIIlIIIIIIIIlIl) {
            final ResourceLocation lllllllllllIlIlIIlIIlIIIIIIIIlII = lllllllllllIlIlIIlIIlIIIIIIIIlll.func_192575_l();
            final Advancement.Builder lllllllllllIlIlIIlIIlIIIIIIIIIll = Advancement.Builder.func_192060_b(lllllllllllIlIlIIlIIlIIIIIIIIlll);
            this.field_192606_b.put(lllllllllllIlIlIIlIIlIIIIIIIIlII, lllllllllllIlIlIIlIIlIIIIIIIIIll);
        }
        for (int lllllllllllIlIlIIlIIlIIIIIIIIllI = lllllllllllIlIlIIlIIlIIIIIIIIlll.readVarIntFromBuffer(), lllllllllllIlIlIIlIIlIIIIIIIIIlI = 0; lllllllllllIlIlIIlIIlIIIIIIIIIlI < lllllllllllIlIlIIlIIlIIIIIIIIllI; ++lllllllllllIlIlIIlIIlIIIIIIIIIlI) {
            final ResourceLocation lllllllllllIlIlIIlIIlIIIIIIIIIIl = lllllllllllIlIlIIlIIlIIIIIIIIlll.func_192575_l();
            this.field_192607_c.add(lllllllllllIlIlIIlIIlIIIIIIIIIIl);
        }
        for (int lllllllllllIlIlIIlIIlIIIIIIIIllI = lllllllllllIlIlIIlIIlIIIIIIIIlll.readVarIntFromBuffer(), lllllllllllIlIlIIlIIlIIIIIIIIIII = 0; lllllllllllIlIlIIlIIlIIIIIIIIIII < lllllllllllIlIlIIlIIlIIIIIIIIllI; ++lllllllllllIlIlIIlIIlIIIIIIIIIII) {
            final ResourceLocation lllllllllllIlIlIIlIIIlllllllllll = lllllllllllIlIlIIlIIlIIIIIIIIlll.func_192575_l();
            this.field_192608_d.put(lllllllllllIlIlIIlIIIlllllllllll, AdvancementProgress.func_192100_b(lllllllllllIlIlIIlIIlIIIIIIIIlll));
        }
    }
    
    public SPacketAdvancementInfo(final boolean lllllllllllIlIlIIlIIlIIIIIlIIIII, final Collection<Advancement> lllllllllllIlIlIIlIIlIIIIIIllIIl, final Set<ResourceLocation> lllllllllllIlIlIIlIIlIIIIIIllIII, final Map<ResourceLocation, AdvancementProgress> lllllllllllIlIlIIlIIlIIIIIIlllIl) {
        this.field_192605_a = lllllllllllIlIlIIlIIlIIIIIlIIIII;
        this.field_192606_b = (Map<ResourceLocation, Advancement.Builder>)Maps.newHashMap();
        for (final Advancement lllllllllllIlIlIIlIIlIIIIIIlllII : lllllllllllIlIlIIlIIlIIIIIIllIIl) {
            this.field_192606_b.put(lllllllllllIlIlIIlIIlIIIIIIlllII.func_192067_g(), lllllllllllIlIlIIlIIlIIIIIIlllII.func_192075_a());
        }
        this.field_192607_c = lllllllllllIlIlIIlIIlIIIIIIllIII;
        this.field_192608_d = (Map<ResourceLocation, AdvancementProgress>)Maps.newHashMap((Map)lllllllllllIlIlIIlIIlIIIIIIlllIl);
    }
    
    public SPacketAdvancementInfo() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlIlIIlIIIlllllllIIIl) throws IOException {
        lllllllllllIlIlIIlIIIlllllllIIIl.writeBoolean(this.field_192605_a);
        lllllllllllIlIlIIlIIIlllllllIIIl.writeVarIntToBuffer(this.field_192606_b.size());
        for (final Map.Entry<ResourceLocation, Advancement.Builder> lllllllllllIlIlIIlIIIlllllllIIII : this.field_192606_b.entrySet()) {
            final ResourceLocation lllllllllllIlIlIIlIIIllllllIllll = lllllllllllIlIlIIlIIIlllllllIIII.getKey();
            final Advancement.Builder lllllllllllIlIlIIlIIIllllllIlllI = lllllllllllIlIlIIlIIIlllllllIIII.getValue();
            lllllllllllIlIlIIlIIIlllllllIIIl.func_192572_a(lllllllllllIlIlIIlIIIllllllIllll);
            lllllllllllIlIlIIlIIIllllllIlllI.func_192057_a(lllllllllllIlIlIIlIIIlllllllIIIl);
        }
        lllllllllllIlIlIIlIIIlllllllIIIl.writeVarIntToBuffer(this.field_192607_c.size());
        for (final ResourceLocation lllllllllllIlIlIIlIIIllllllIllIl : this.field_192607_c) {
            lllllllllllIlIlIIlIIIlllllllIIIl.func_192572_a(lllllllllllIlIlIIlIIIllllllIllIl);
        }
        lllllllllllIlIlIIlIIIlllllllIIIl.writeVarIntToBuffer(this.field_192608_d.size());
        for (final Map.Entry<ResourceLocation, AdvancementProgress> lllllllllllIlIlIIlIIIllllllIllII : this.field_192608_d.entrySet()) {
            lllllllllllIlIlIIlIIIlllllllIIIl.func_192572_a(lllllllllllIlIlIIlIIIllllllIllII.getKey());
            lllllllllllIlIlIIlIIIllllllIllII.getValue().func_192104_a(lllllllllllIlIlIIlIIIlllllllIIIl);
        }
    }
    
    public Set<ResourceLocation> func_192600_b() {
        return this.field_192607_c;
    }
    
    public boolean func_192602_d() {
        return this.field_192605_a;
    }
    
    public Map<ResourceLocation, AdvancementProgress> func_192604_c() {
        return this.field_192608_d;
    }
    
    public Map<ResourceLocation, Advancement.Builder> func_192603_a() {
        return this.field_192606_b;
    }
}
