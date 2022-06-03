// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements;

import java.lang.reflect.Type;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import com.google.common.collect.Lists;
import net.minecraft.network.play.server.SPacketSelectAdvancementsTab;
import java.util.stream.Stream;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;
import java.util.function.Function;
import java.util.Comparator;
import com.google.gson.JsonParseException;
import net.minecraft.util.JsonUtils;
import net.minecraft.network.Packet;
import java.util.Collection;
import net.minecraft.network.play.server.SPacketAdvancementInfo;
import com.google.common.collect.Sets;
import java.io.IOException;
import com.google.common.io.Files;
import java.nio.charset.StandardCharsets;
import com.google.common.collect.Maps;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import java.io.File;
import com.google.gson.Gson;
import javax.annotation.Nullable;
import org.apache.logging.log4j.Logger;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import java.util.Map;
import com.google.gson.reflect.TypeToken;
import net.minecraft.server.MinecraftServer;

public class PlayerAdvancements
{
    private final /* synthetic */ MinecraftServer field_192756_d;
    private static final /* synthetic */ TypeToken<Map<ResourceLocation, AdvancementProgress>> field_192755_c;
    private final /* synthetic */ Map<Advancement, AdvancementProgress> field_192758_f;
    private /* synthetic */ EntityPlayerMP field_192762_j;
    private final /* synthetic */ Set<Advancement> field_192759_g;
    private final /* synthetic */ Set<Advancement> field_192760_h;
    private static final /* synthetic */ Logger field_192753_a;
    private final /* synthetic */ Set<Advancement> field_192761_i;
    @Nullable
    private /* synthetic */ Advancement field_194221_k;
    private static final /* synthetic */ Gson field_192754_b;
    private final /* synthetic */ File field_192757_e;
    private /* synthetic */ boolean field_192763_k;
    
    public void func_192745_a() {
        for (final ICriterionTrigger<?> llllllllllIlllllllIlIIlIIlllIlll : CriteriaTriggers.func_192120_a()) {
            llllllllllIlllllllIlIIlIIlllIlll.func_192167_a(this);
        }
    }
    
    private void func_192743_a(final Advancement llllllllllIlllllllIlIIIllIllIlIl, final AdvancementProgress llllllllllIlllllllIlIIIllIllIlII) {
        llllllllllIlllllllIlIIIllIllIlII.func_192099_a(llllllllllIlllllllIlIIIllIllIlIl.func_192073_f(), llllllllllIlllllllIlIIIllIllIlIl.func_192074_h());
        this.field_192758_f.put(llllllllllIlllllllIlIIIllIllIlIl, llllllllllIlllllllIlIIIllIllIlII);
    }
    
    private void func_192748_e() {
        for (final Advancement llllllllllIlllllllIlIIlIIlIllIII : this.field_192756_d.func_191949_aK().func_192780_b()) {
            if (llllllllllIlllllllIlIIlIIlIllIII.func_192073_f().isEmpty()) {
                this.func_192750_a(llllllllllIlllllllIlIIlIIlIllIII, "");
                llllllllllIlllllllIlIIlIIlIllIII.func_192072_d().func_192113_a(this.field_192762_j);
            }
        }
    }
    
    public boolean func_192750_a(final Advancement llllllllllIlllllllIlIIlIIIlIlIII, final String llllllllllIlllllllIlIIlIIIlIIIIl) {
        boolean llllllllllIlllllllIlIIlIIIlIIllI = false;
        final AdvancementProgress llllllllllIlllllllIlIIlIIIlIIlIl = this.func_192747_a(llllllllllIlllllllIlIIlIIIlIlIII);
        final boolean llllllllllIlllllllIlIIlIIIlIIlII = llllllllllIlllllllIlIIlIIIlIIlIl.func_192105_a();
        if (llllllllllIlllllllIlIIlIIIlIIlIl.func_192109_a(llllllllllIlllllllIlIIlIIIlIIIIl)) {
            this.func_193765_c(llllllllllIlllllllIlIIlIIIlIlIII);
            this.field_192761_i.add(llllllllllIlllllllIlIIlIIIlIlIII);
            llllllllllIlllllllIlIIlIIIlIIllI = true;
            if (!llllllllllIlllllllIlIIlIIIlIIlII && llllllllllIlllllllIlIIlIIIlIIlIl.func_192105_a()) {
                llllllllllIlllllllIlIIlIIIlIlIII.func_192072_d().func_192113_a(this.field_192762_j);
                if (llllllllllIlllllllIlIIlIIIlIlIII.func_192068_c() != null && llllllllllIlllllllIlIIlIIIlIlIII.func_192068_c().func_193220_i() && this.field_192762_j.world.getGameRules().getBoolean("announceAdvancements")) {
                    this.field_192756_d.getPlayerList().sendChatMsg(new TextComponentTranslation("chat.type.advancement." + llllllllllIlllllllIlIIlIIIlIlIII.func_192068_c().func_192291_d().func_192307_a(), new Object[] { this.field_192762_j.getDisplayName(), llllllllllIlllllllIlIIlIIIlIlIII.func_193123_j() }));
                }
            }
        }
        if (llllllllllIlllllllIlIIlIIIlIIlIl.func_192105_a()) {
            this.func_192742_b(llllllllllIlllllllIlIIlIIIlIlIII);
        }
        return llllllllllIlllllllIlIIlIIIlIIllI;
    }
    
    private boolean func_192738_c(Advancement llllllllllIlllllllIlIIIllIIlIllI) {
        for (int llllllllllIlllllllIlIIIllIIllIIl = 0; llllllllllIlllllllIlIIIllIIlIllI != null && llllllllllIlllllllIlIIIllIIllIIl <= 2; llllllllllIlllllllIlIIIllIIlIllI = ((Advancement)llllllllllIlllllllIlIIIllIIlIllI).func_192070_b(), ++llllllllllIlllllllIlIIIllIIllIIl) {
            if (llllllllllIlllllllIlIIIllIIllIIl == 0 && this.func_192746_d((Advancement)llllllllllIlllllllIlIIIllIIlIllI)) {
                return true;
            }
            if (((Advancement)llllllllllIlllllllIlIIIllIIlIllI).func_192068_c() == null) {
                return false;
            }
            final AdvancementProgress llllllllllIlllllllIlIIIllIIllIII = this.func_192747_a((Advancement)llllllllllIlllllllIlIIIllIIlIllI);
            if (llllllllllIlllllllIlIIIllIIllIII.func_192105_a()) {
                return true;
            }
            if (((Advancement)llllllllllIlllllllIlIIIllIIlIllI).func_192068_c().func_193224_j()) {
                return false;
            }
        }
        return false;
    }
    
    private void func_193764_b(final Advancement llllllllllIlllllllIlIIIllllllllI) {
        final AdvancementProgress llllllllllIlllllllIlIIlIIIIIIlII = this.func_192747_a(llllllllllIlllllllIlIIIllllllllI);
        if (!llllllllllIlllllllIlIIlIIIIIIlII.func_192105_a()) {
            for (final Map.Entry<String, Criterion> llllllllllIlllllllIlIIlIIIIIIIll : llllllllllIlllllllIlIIIllllllllI.func_192073_f().entrySet()) {
                final CriterionProgress llllllllllIlllllllIlIIlIIIIIIIlI = llllllllllIlllllllIlIIlIIIIIIlII.func_192106_c(llllllllllIlllllllIlIIlIIIIIIIll.getKey());
                if (llllllllllIlllllllIlIIlIIIIIIIlI != null && !llllllllllIlllllllIlIIlIIIIIIIlI.func_192151_a()) {
                    final ICriterionInstance llllllllllIlllllllIlIIlIIIIIIIIl = llllllllllIlllllllIlIIlIIIIIIIll.getValue().func_192143_a();
                    if (llllllllllIlllllllIlIIlIIIIIIIIl == null) {
                        continue;
                    }
                    final ICriterionTrigger<ICriterionInstance> llllllllllIlllllllIlIIlIIIIIIIII = CriteriaTriggers.func_192119_a(llllllllllIlllllllIlIIlIIIIIIIIl.func_192244_a());
                    if (llllllllllIlllllllIlIIlIIIIIIIII == null) {
                        continue;
                    }
                    llllllllllIlllllllIlIIlIIIIIIIII.func_192165_a(this, new ICriterionTrigger.Listener<ICriterionInstance>(llllllllllIlllllllIlIIlIIIIIIIIl, llllllllllIlllllllIlIIIllllllllI, llllllllllIlllllllIlIIlIIIIIIIll.getKey()));
                }
            }
        }
    }
    
    public void func_192749_b() {
        final Map<ResourceLocation, AdvancementProgress> llllllllllIlllllllIlIIlIIIlllIII = (Map<ResourceLocation, AdvancementProgress>)Maps.newHashMap();
        for (final Map.Entry<Advancement, AdvancementProgress> llllllllllIlllllllIlIIlIIIllIlll : this.field_192758_f.entrySet()) {
            final AdvancementProgress llllllllllIlllllllIlIIlIIIllIllI = llllllllllIlllllllIlIIlIIIllIlll.getValue();
            if (llllllllllIlllllllIlIIlIIIllIllI.func_192108_b()) {
                llllllllllIlllllllIlIIlIIIlllIII.put(llllllllllIlllllllIlIIlIIIllIlll.getKey().func_192067_g(), llllllllllIlllllllIlIIlIIIllIllI);
            }
        }
        if (this.field_192757_e.getParentFile() != null) {
            this.field_192757_e.getParentFile().mkdirs();
        }
        try {
            Files.write((CharSequence)PlayerAdvancements.field_192754_b.toJson((Object)llllllllllIlllllllIlIIlIIIlllIII), this.field_192757_e, StandardCharsets.UTF_8);
        }
        catch (IOException llllllllllIlllllllIlIIlIIIllIlIl) {
            PlayerAdvancements.field_192753_a.error("Couldn't save player advancements to " + this.field_192757_e, (Throwable)llllllllllIlllllllIlIIlIIIllIlIl);
        }
    }
    
    public void func_192741_b(final EntityPlayerMP llllllllllIlllllllIlIIIlllIlIIIl) {
        if (!this.field_192760_h.isEmpty() || !this.field_192761_i.isEmpty()) {
            final Map<ResourceLocation, AdvancementProgress> llllllllllIlllllllIlIIIlllIlIlll = (Map<ResourceLocation, AdvancementProgress>)Maps.newHashMap();
            final Set<Advancement> llllllllllIlllllllIlIIIlllIlIllI = (Set<Advancement>)Sets.newLinkedHashSet();
            final Set<ResourceLocation> llllllllllIlllllllIlIIIlllIlIlIl = (Set<ResourceLocation>)Sets.newLinkedHashSet();
            for (final Advancement llllllllllIlllllllIlIIIlllIlIlII : this.field_192761_i) {
                if (this.field_192759_g.contains(llllllllllIlllllllIlIIIlllIlIlII)) {
                    llllllllllIlllllllIlIIIlllIlIlll.put(llllllllllIlllllllIlIIIlllIlIlII.func_192067_g(), this.field_192758_f.get(llllllllllIlllllllIlIIIlllIlIlII));
                }
            }
            for (final Advancement llllllllllIlllllllIlIIIlllIlIIll : this.field_192760_h) {
                if (this.field_192759_g.contains(llllllllllIlllllllIlIIIlllIlIIll)) {
                    llllllllllIlllllllIlIIIlllIlIllI.add(llllllllllIlllllllIlIIIlllIlIIll);
                }
                else {
                    llllllllllIlllllllIlIIIlllIlIlIl.add(llllllllllIlllllllIlIIIlllIlIIll.func_192067_g());
                }
            }
            if (!llllllllllIlllllllIlIIIlllIlIlll.isEmpty() || !llllllllllIlllllllIlIIIlllIlIllI.isEmpty() || !llllllllllIlllllllIlIIIlllIlIlIl.isEmpty()) {
                llllllllllIlllllllIlIIIlllIlIIIl.connection.sendPacket(new SPacketAdvancementInfo(this.field_192763_k, llllllllllIlllllllIlIIIlllIlIllI, llllllllllIlllllllIlIIIlllIlIlIl, llllllllllIlllllllIlIIIlllIlIlll));
                this.field_192760_h.clear();
                this.field_192761_i.clear();
            }
        }
        this.field_192763_k = false;
    }
    
    public AdvancementProgress func_192747_a(final Advancement llllllllllIlllllllIlIIIllIlllIll) {
        AdvancementProgress llllllllllIlllllllIlIIIllIllllIl = this.field_192758_f.get(llllllllllIlllllllIlIIIllIlllIll);
        if (llllllllllIlllllllIlIIIllIllllIl == null) {
            llllllllllIlllllllIlIIIllIllllIl = new AdvancementProgress();
            this.func_192743_a(llllllllllIlllllllIlIIIllIlllIll, llllllllllIlllllllIlIIIllIllllIl);
        }
        return llllllllllIlllllllIlIIIllIllllIl;
    }
    
    private void func_193765_c(final Advancement llllllllllIlllllllIlIIIllllIlllI) {
        final AdvancementProgress llllllllllIlllllllIlIIIllllIllIl = this.func_192747_a(llllllllllIlllllllIlIIIllllIlllI);
        for (final Map.Entry<String, Criterion> llllllllllIlllllllIlIIIllllIllII : llllllllllIlllllllIlIIIllllIlllI.func_192073_f().entrySet()) {
            final CriterionProgress llllllllllIlllllllIlIIIllllIlIll = llllllllllIlllllllIlIIIllllIllIl.func_192106_c(llllllllllIlllllllIlIIIllllIllII.getKey());
            if (llllllllllIlllllllIlIIIllllIlIll != null && (llllllllllIlllllllIlIIIllllIlIll.func_192151_a() || llllllllllIlllllllIlIIIllllIllIl.func_192105_a())) {
                final ICriterionInstance llllllllllIlllllllIlIIIllllIlIlI = llllllllllIlllllllIlIIIllllIllII.getValue().func_192143_a();
                if (llllllllllIlllllllIlIIIllllIlIlI == null) {
                    continue;
                }
                final ICriterionTrigger<ICriterionInstance> llllllllllIlllllllIlIIIllllIlIIl = CriteriaTriggers.func_192119_a(llllllllllIlllllllIlIIIllllIlIlI.func_192244_a());
                if (llllllllllIlllllllIlIIIllllIlIIl == null) {
                    continue;
                }
                llllllllllIlllllllIlIIIllllIlIIl.func_192164_b(this, new ICriterionTrigger.Listener<ICriterionInstance>(llllllllllIlllllllIlIIIllllIlIlI, llllllllllIlllllllIlIIIllllIlllI, llllllllllIlllllllIlIIIllllIllII.getKey()));
            }
        }
    }
    
    private void func_192740_f() {
        if (this.field_192757_e.isFile()) {
            try {
                final String llllllllllIlllllllIlIIlIIlIIllII = Files.toString(this.field_192757_e, StandardCharsets.UTF_8);
                final Map<ResourceLocation, AdvancementProgress> llllllllllIlllllllIlIIlIIlIIlIll = JsonUtils.func_193840_a(PlayerAdvancements.field_192754_b, llllllllllIlllllllIlIIlIIlIIllII, PlayerAdvancements.field_192755_c.getType());
                if (llllllllllIlllllllIlIIlIIlIIlIll == null) {
                    throw new JsonParseException("Found null for advancements");
                }
                final Stream<Map.Entry<ResourceLocation, AdvancementProgress>> llllllllllIlllllllIlIIlIIlIIlIlI = llllllllllIlllllllIlIIlIIlIIlIll.entrySet().stream().sorted(Comparator.comparing((Function<? super Map.Entry<ResourceLocation, AdvancementProgress>, ? extends Comparable>)Map.Entry::getValue));
                for (final Map.Entry<ResourceLocation, AdvancementProgress> llllllllllIlllllllIlIIlIIlIIlIIl : llllllllllIlllllllIlIIlIIlIIlIlI.collect((Collector<? super Map.Entry<ResourceLocation, AdvancementProgress>, ?, List<? super Map.Entry<ResourceLocation, AdvancementProgress>>>)Collectors.toList())) {
                    final Advancement llllllllllIlllllllIlIIlIIlIIlIII = this.field_192756_d.func_191949_aK().func_192778_a(llllllllllIlllllllIlIIlIIlIIlIIl.getKey());
                    if (llllllllllIlllllllIlIIlIIlIIlIII == null) {
                        PlayerAdvancements.field_192753_a.warn("Ignored advancement '" + llllllllllIlllllllIlIIlIIlIIlIIl.getKey() + "' in progress file " + this.field_192757_e + " - it doesn't exist anymore?");
                    }
                    else {
                        this.func_192743_a(llllllllllIlllllllIlIIlIIlIIlIII, llllllllllIlllllllIlIIlIIlIIlIIl.getValue());
                    }
                }
            }
            catch (JsonParseException llllllllllIlllllllIlIIlIIlIIIlll) {
                PlayerAdvancements.field_192753_a.error("Couldn't parse player advancements in " + this.field_192757_e, (Throwable)llllllllllIlllllllIlIIlIIlIIIlll);
            }
            catch (IOException llllllllllIlllllllIlIIlIIlIIIllI) {
                PlayerAdvancements.field_192753_a.error("Couldn't access player advancements in " + this.field_192757_e, (Throwable)llllllllllIlllllllIlIIlIIlIIIllI);
            }
        }
        this.func_192748_e();
        this.func_192752_d();
        this.func_192751_c();
    }
    
    public void func_192739_a(final EntityPlayerMP llllllllllIlllllllIlIIlIIlllllII) {
        this.field_192762_j = llllllllllIlllllllIlIIlIIlllllII;
    }
    
    public PlayerAdvancements(final MinecraftServer llllllllllIlllllllIlIIlIlIIIIlII, final File llllllllllIlllllllIlIIlIlIIIIlll, final EntityPlayerMP llllllllllIlllllllIlIIlIlIIIIIlI) {
        this.field_192758_f = (Map<Advancement, AdvancementProgress>)Maps.newLinkedHashMap();
        this.field_192759_g = (Set<Advancement>)Sets.newLinkedHashSet();
        this.field_192760_h = (Set<Advancement>)Sets.newLinkedHashSet();
        this.field_192761_i = (Set<Advancement>)Sets.newLinkedHashSet();
        this.field_192763_k = true;
        this.field_192756_d = llllllllllIlllllllIlIIlIlIIIIlII;
        this.field_192757_e = llllllllllIlllllllIlIIlIlIIIIlll;
        this.field_192762_j = llllllllllIlllllllIlIIlIlIIIIIlI;
        this.func_192740_f();
    }
    
    private void func_192751_c() {
        for (final Advancement llllllllllIlllllllIlIIlIIllIllII : this.field_192756_d.func_191949_aK().func_192780_b()) {
            this.func_193764_b(llllllllllIlllllllIlIIlIIllIllII);
        }
    }
    
    private boolean func_192746_d(final Advancement llllllllllIlllllllIlIIIllIIIllIl) {
        final AdvancementProgress llllllllllIlllllllIlIIIllIIIllII = this.func_192747_a(llllllllllIlllllllIlIIIllIIIllIl);
        if (llllllllllIlllllllIlIIIllIIIllII.func_192105_a()) {
            return true;
        }
        for (final Advancement llllllllllIlllllllIlIIIllIIIlIll : llllllllllIlllllllIlIIIllIIIllIl.func_192069_e()) {
            if (this.func_192746_d(llllllllllIlllllllIlIIIllIIIlIll)) {
                return true;
            }
        }
        return false;
    }
    
    public void func_193766_b() {
        this.func_192745_a();
        this.field_192758_f.clear();
        this.field_192759_g.clear();
        this.field_192760_h.clear();
        this.field_192761_i.clear();
        this.field_192763_k = true;
        this.field_194221_k = null;
        this.func_192740_f();
    }
    
    public boolean func_192744_b(final Advancement llllllllllIlllllllIlIIlIIIIlIlll, final String llllllllllIlllllllIlIIlIIIIlIIIl) {
        boolean llllllllllIlllllllIlIIlIIIIlIlIl = false;
        final AdvancementProgress llllllllllIlllllllIlIIlIIIIlIlII = this.func_192747_a(llllllllllIlllllllIlIIlIIIIlIlll);
        if (llllllllllIlllllllIlIIlIIIIlIlII.func_192101_b(llllllllllIlllllllIlIIlIIIIlIIIl)) {
            this.func_193764_b(llllllllllIlllllllIlIIlIIIIlIlll);
            this.field_192761_i.add(llllllllllIlllllllIlIIlIIIIlIlll);
            llllllllllIlllllllIlIIlIIIIlIlIl = true;
        }
        if (!llllllllllIlllllllIlIIlIIIIlIlII.func_192108_b()) {
            this.func_192742_b(llllllllllIlllllllIlIIlIIIIlIlll);
        }
        return llllllllllIlllllllIlIIlIIIIlIlIl;
    }
    
    public void func_194220_a(@Nullable final Advancement llllllllllIlllllllIlIIIlllIIIlll) {
        final Advancement llllllllllIlllllllIlIIIlllIIIllI = this.field_194221_k;
        if (llllllllllIlllllllIlIIIlllIIIlll != null && llllllllllIlllllllIlIIIlllIIIlll.func_192070_b() == null && llllllllllIlllllllIlIIIlllIIIlll.func_192068_c() != null) {
            this.field_194221_k = llllllllllIlllllllIlIIIlllIIIlll;
        }
        else {
            this.field_194221_k = null;
        }
        if (llllllllllIlllllllIlIIIlllIIIllI != this.field_194221_k) {
            this.field_192762_j.connection.sendPacket(new SPacketSelectAdvancementsTab((this.field_194221_k == null) ? null : this.field_194221_k.func_192067_g()));
        }
    }
    
    private void func_192752_d() {
        final List<Advancement> llllllllllIlllllllIlIIlIIllIIIll = (List<Advancement>)Lists.newArrayList();
        for (final Map.Entry<Advancement, AdvancementProgress> llllllllllIlllllllIlIIlIIllIIIlI : this.field_192758_f.entrySet()) {
            if (llllllllllIlllllllIlIIlIIllIIIlI.getValue().func_192105_a()) {
                llllllllllIlllllllIlIIlIIllIIIll.add(llllllllllIlllllllIlIIlIIllIIIlI.getKey());
                this.field_192761_i.add(llllllllllIlllllllIlIIlIIllIIIlI.getKey());
            }
        }
        for (final Advancement llllllllllIlllllllIlIIlIIllIIIIl : llllllllllIlllllllIlIIlIIllIIIll) {
            this.func_192742_b(llllllllllIlllllllIlIIlIIllIIIIl);
        }
    }
    
    static {
        field_192753_a = LogManager.getLogger();
        field_192754_b = new GsonBuilder().registerTypeAdapter((Type)AdvancementProgress.class, (Object)new AdvancementProgress.Serializer()).registerTypeAdapter((Type)ResourceLocation.class, (Object)new ResourceLocation.Serializer()).setPrettyPrinting().create();
        field_192755_c = new TypeToken<Map<ResourceLocation, AdvancementProgress>>() {};
    }
    
    private void func_192742_b(final Advancement llllllllllIlllllllIlIIIllIlIIlII) {
        final boolean llllllllllIlllllllIlIIIllIlIlIII = this.func_192738_c(llllllllllIlllllllIlIIIllIlIIlII);
        final boolean llllllllllIlllllllIlIIIllIlIIlll = this.field_192759_g.contains(llllllllllIlllllllIlIIIllIlIIlII);
        if (llllllllllIlllllllIlIIIllIlIlIII && !llllllllllIlllllllIlIIIllIlIIlll) {
            this.field_192759_g.add(llllllllllIlllllllIlIIIllIlIIlII);
            this.field_192760_h.add(llllllllllIlllllllIlIIIllIlIIlII);
            if (this.field_192758_f.containsKey(llllllllllIlllllllIlIIIllIlIIlII)) {
                this.field_192761_i.add(llllllllllIlllllllIlIIIllIlIIlII);
            }
        }
        else if (!llllllllllIlllllllIlIIIllIlIlIII && llllllllllIlllllllIlIIIllIlIIlll) {
            this.field_192759_g.remove(llllllllllIlllllllIlIIIllIlIIlII);
            this.field_192760_h.add(llllllllllIlllllllIlIIIllIlIIlII);
        }
        if (llllllllllIlllllllIlIIIllIlIlIII != llllllllllIlllllllIlIIIllIlIIlll && llllllllllIlllllllIlIIIllIlIIlII.func_192070_b() != null) {
            this.func_192742_b(llllllllllIlllllllIlIIIllIlIIlII.func_192070_b());
        }
        for (final Advancement llllllllllIlllllllIlIIIllIlIIllI : llllllllllIlllllllIlIIIllIlIIlII.func_192069_e()) {
            this.func_192742_b(llllllllllIlllllllIlIIIllIlIIllI);
        }
    }
}
