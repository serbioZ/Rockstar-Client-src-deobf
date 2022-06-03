// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.multiplayer;

import org.apache.logging.log4j.LogManager;
import net.minecraft.client.gui.toasts.IToast;
import net.minecraft.client.gui.toasts.AdvancementToast;
import net.minecraft.util.ResourceLocation;
import net.minecraft.network.play.server.SPacketAdvancementInfo;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketSeenAdvancements;
import com.google.common.collect.Maps;
import net.minecraft.advancements.AdvancementList;
import org.apache.logging.log4j.Logger;
import net.minecraft.advancements.AdvancementProgress;
import java.util.Map;
import net.minecraft.advancements.Advancement;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;

public class ClientAdvancementManager
{
    private final /* synthetic */ Minecraft field_192801_b;
    @Nullable
    private /* synthetic */ IListener field_192804_e;
    @Nullable
    private /* synthetic */ Advancement field_194231_f;
    private final /* synthetic */ Map<Advancement, AdvancementProgress> field_192803_d;
    private static final /* synthetic */ Logger field_192800_a;
    private final /* synthetic */ AdvancementList field_192802_c;
    
    public ClientAdvancementManager(final Minecraft llllllllllIlllIlIIlllIlIlIlIIlll) {
        this.field_192802_c = new AdvancementList();
        this.field_192803_d = (Map<Advancement, AdvancementProgress>)Maps.newHashMap();
        this.field_192801_b = llllllllllIlllIlIIlllIlIlIlIIlll;
    }
    
    public void func_194230_a(@Nullable final Advancement llllllllllIlllIlIIlllIlIlIIIlIIl, final boolean llllllllllIlllIlIIlllIlIlIIIlIII) {
        final NetHandlerPlayClient llllllllllIlllIlIIlllIlIlIIIlIll = this.field_192801_b.getConnection();
        if (llllllllllIlllIlIIlllIlIlIIIlIll != null && llllllllllIlllIlIIlllIlIlIIIlIIl != null && llllllllllIlllIlIIlllIlIlIIIlIII) {
            llllllllllIlllIlIIlllIlIlIIIlIll.sendPacket(CPacketSeenAdvancements.func_194163_a(llllllllllIlllIlIIlllIlIlIIIlIIl));
        }
        if (this.field_194231_f != llllllllllIlllIlIIlllIlIlIIIlIIl) {
            this.field_194231_f = llllllllllIlllIlIIlllIlIlIIIlIIl;
            if (this.field_192804_e != null) {
                this.field_192804_e.func_193982_e(llllllllllIlllIlIIlllIlIlIIIlIIl);
            }
        }
    }
    
    public void func_192799_a(final SPacketAdvancementInfo llllllllllIlllIlIIlllIlIlIIllIlI) {
        if (llllllllllIlllIlIIlllIlIlIIllIlI.func_192602_d()) {
            this.field_192802_c.func_192087_a();
            this.field_192803_d.clear();
        }
        this.field_192802_c.func_192085_a(llllllllllIlllIlIIlllIlIlIIllIlI.func_192600_b());
        this.field_192802_c.func_192083_a(llllllllllIlllIlIIlllIlIlIIllIlI.func_192603_a());
        for (final Map.Entry<ResourceLocation, AdvancementProgress> llllllllllIlllIlIIlllIlIlIIllllI : llllllllllIlllIlIIlllIlIlIIllIlI.func_192604_c().entrySet()) {
            final Advancement llllllllllIlllIlIIlllIlIlIIlllIl = this.field_192802_c.func_192084_a(llllllllllIlllIlIIlllIlIlIIllllI.getKey());
            if (llllllllllIlllIlIIlllIlIlIIlllIl != null) {
                final AdvancementProgress llllllllllIlllIlIIlllIlIlIIlllII = llllllllllIlllIlIIlllIlIlIIllllI.getValue();
                llllllllllIlllIlIIlllIlIlIIlllII.func_192099_a(llllllllllIlllIlIIlllIlIlIIlllIl.func_192073_f(), llllllllllIlllIlIIlllIlIlIIlllIl.func_192074_h());
                this.field_192803_d.put(llllllllllIlllIlIIlllIlIlIIlllIl, llllllllllIlllIlIIlllIlIlIIlllII);
                if (this.field_192804_e != null) {
                    this.field_192804_e.func_191933_a(llllllllllIlllIlIIlllIlIlIIlllIl, llllllllllIlllIlIIlllIlIlIIlllII);
                }
                if (llllllllllIlllIlIIlllIlIlIIllIlI.func_192602_d() || !llllllllllIlllIlIIlllIlIlIIlllII.func_192105_a() || llllllllllIlllIlIIlllIlIlIIlllIl.func_192068_c() == null || !llllllllllIlllIlIIlllIlIlIIlllIl.func_192068_c().func_193223_h()) {
                    continue;
                }
                this.field_192801_b.func_193033_an().func_192988_a(new AdvancementToast(llllllllllIlllIlIIlllIlIlIIlllIl));
            }
            else {
                ClientAdvancementManager.field_192800_a.warn("Server informed client about progress for unknown advancement " + llllllllllIlllIlIIlllIlIlIIllllI.getKey());
            }
        }
    }
    
    public AdvancementList func_194229_a() {
        return this.field_192802_c;
    }
    
    public void func_192798_a(@Nullable final IListener llllllllllIlllIlIIlllIlIlIIIIIIl) {
        this.field_192804_e = llllllllllIlllIlIIlllIlIlIIIIIIl;
        this.field_192802_c.func_192086_a(llllllllllIlllIlIIlllIlIlIIIIIIl);
        if (llllllllllIlllIlIIlllIlIlIIIIIIl != null) {
            for (final Map.Entry<Advancement, AdvancementProgress> llllllllllIlllIlIIlllIlIlIIIIIII : this.field_192803_d.entrySet()) {
                llllllllllIlllIlIIlllIlIlIIIIIIl.func_191933_a(llllllllllIlllIlIIlllIlIlIIIIIII.getKey(), llllllllllIlllIlIIlllIlIlIIIIIII.getValue());
            }
            llllllllllIlllIlIIlllIlIlIIIIIIl.func_193982_e(this.field_194231_f);
        }
    }
    
    static {
        field_192800_a = LogManager.getLogger();
    }
    
    public interface IListener extends AdvancementList.Listener
    {
        void func_193982_e(final Advancement p0);
        
        void func_191933_a(final Advancement p0, final AdvancementProgress p1);
    }
}
