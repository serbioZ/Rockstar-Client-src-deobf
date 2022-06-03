// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Team;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;
import com.google.common.collect.ComparisonChain;
import java.util.Comparator;
import net.minecraft.world.WorldServer;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import java.util.Collections;
import java.util.Iterator;
import com.google.common.collect.Maps;
import java.util.regex.Matcher;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.Vec3d;
import com.google.common.collect.Sets;
import java.util.Collection;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EntitySelectors;
import com.google.common.base.Predicates;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import javax.annotation.Nullable;
import net.minecraft.world.GameType;
import com.google.common.collect.Lists;
import net.minecraft.entity.Entity;
import java.util.List;
import java.util.Map;
import com.google.common.base.Predicate;
import java.util.regex.Pattern;
import com.google.common.base.Splitter;
import java.util.Set;

public class EntitySelector
{
    private static final /* synthetic */ Set<String> field_190830_d;
    private static final /* synthetic */ String field_190838_l;
    private static final /* synthetic */ Set<String> WORLD_BINDING_ARGS;
    private static final /* synthetic */ String field_190843_q;
    private static final /* synthetic */ String field_190831_e;
    private static final /* synthetic */ String field_190841_o;
    private static final /* synthetic */ String field_190842_p;
    private static final /* synthetic */ String field_190834_h;
    private static final /* synthetic */ String field_190835_i;
    private static final /* synthetic */ String field_190836_j;
    private static final /* synthetic */ String field_190832_f;
    private static final /* synthetic */ String field_190847_u;
    private static final /* synthetic */ String field_190833_g;
    private static final /* synthetic */ Splitter field_190828_b;
    private static final /* synthetic */ String field_190846_t;
    private static final /* synthetic */ String field_190839_m;
    private static final /* synthetic */ String field_190849_w;
    private static final /* synthetic */ Splitter field_190829_c;
    private static final /* synthetic */ String field_190845_s;
    private static final /* synthetic */ String field_190848_v;
    private static final /* synthetic */ String field_190850_x;
    private static final /* synthetic */ String field_190844_r;
    private static final /* synthetic */ String field_190837_k;
    private static final /* synthetic */ Pattern TOKEN_PATTERN;
    private static final /* synthetic */ Predicate<String> field_190851_y;
    private static final /* synthetic */ String field_190840_n;
    
    private static List<Predicate<Entity>> getGamemodePredicates(final Map<String, String> lllllllllllIllIIllllIIIIlIlllIll) {
        final List<Predicate<Entity>> lllllllllllIllIIllllIIIIlIlllIlI = (List<Predicate<Entity>>)Lists.newArrayList();
        String lllllllllllIllIIllllIIIIlIlllIIl = getArgument(lllllllllllIllIIllllIIIIlIlllIll, EntitySelector.field_190846_t);
        if (lllllllllllIllIIllllIIIIlIlllIIl == null) {
            return lllllllllllIllIIllllIIIIlIlllIlI;
        }
        final boolean lllllllllllIllIIllllIIIIlIlllIII = lllllllllllIllIIllllIIIIlIlllIIl.startsWith("!");
        if (lllllllllllIllIIllllIIIIlIlllIII) {
            lllllllllllIllIIllllIIIIlIlllIIl = lllllllllllIllIIllllIIIIlIlllIIl.substring(1);
        }
        GameType lllllllllllIllIIllllIIIIlIllIllI = null;
        try {
            final int lllllllllllIllIIllllIIIIlIllIlIl = Integer.parseInt(lllllllllllIllIIllllIIIIlIlllIIl);
            final GameType lllllllllllIllIIllllIIIIlIllIlll = GameType.parseGameTypeWithDefault(lllllllllllIllIIllllIIIIlIllIlIl, GameType.NOT_SET);
        }
        catch (Throwable lllllllllllIllIIllllIIIIlIllIlII) {
            lllllllllllIllIIllllIIIIlIllIllI = GameType.parseGameTypeWithDefault(lllllllllllIllIIllllIIIIlIlllIIl, GameType.NOT_SET);
        }
        final GameType lllllllllllIllIIllllIIIIlIllIIll = lllllllllllIllIIllllIIIIlIllIllI;
        lllllllllllIllIIllllIIIIlIlllIlI.add((Predicate<Entity>)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllIIlllIIIlIIllIllIIllI) {
                if (!(lllllllllllIIlllIIIlIIllIllIIllI instanceof EntityPlayerMP)) {
                    return false;
                }
                final EntityPlayerMP lllllllllllIIlllIIIlIIllIllIlIIl = (EntityPlayerMP)lllllllllllIIlllIIIlIIllIllIIllI;
                final GameType lllllllllllIIlllIIIlIIllIllIlIII = lllllllllllIIlllIIIlIIllIllIlIIl.interactionManager.getGameType();
                return lllllllllllIllIIllllIIIIlIlllIII ? (lllllllllllIIlllIIIlIIllIllIlIII != lllllllllllIllIIllllIIIIlIllIIll) : (lllllllllllIIlllIIIlIIllIllIlIII == lllllllllllIllIIllllIIIIlIllIIll);
            }
        });
        return lllllllllllIllIIllllIIIIlIlllIlI;
    }
    
    private static double getCoordinate(final Map<String, String> lllllllllllIllIIlllIllllllIIIIII, final String lllllllllllIllIIlllIlllllIllllll, final double lllllllllllIllIIlllIllllllIIIIlI, final boolean lllllllllllIllIIlllIllllllIIIIIl) {
        return lllllllllllIllIIlllIllllllIIIIII.containsKey(lllllllllllIllIIlllIlllllIllllll) ? (MathHelper.getInt(lllllllllllIllIIlllIllllllIIIIII.get(lllllllllllIllIIlllIlllllIllllll), MathHelper.floor(lllllllllllIllIIlllIllllllIIIIlI)) + (lllllllllllIllIIlllIllllllIIIIIl ? 0.5 : 0.0)) : lllllllllllIllIIlllIllllllIIIIlI;
    }
    
    private static List<Predicate<Entity>> getRotationsPredicates(final Map<String, String> lllllllllllIllIIllllIIIIIlIlIlII) {
        final List<Predicate<Entity>> lllllllllllIllIIllllIIIIIlIlIIll = (List<Predicate<Entity>>)Lists.newArrayList();
        if (lllllllllllIllIIllllIIIIIlIlIlII.containsKey(EntitySelector.field_190844_r) || lllllllllllIllIIllllIIIIIlIlIlII.containsKey(EntitySelector.field_190843_q)) {
            final int lllllllllllIllIIllllIIIIIlIlIIlI = MathHelper.clampAngle(getInt(lllllllllllIllIIllllIIIIIlIlIlII, EntitySelector.field_190844_r, 0));
            final int lllllllllllIllIIllllIIIIIlIlIIIl = MathHelper.clampAngle(getInt(lllllllllllIllIIllllIIIIIlIlIlII, EntitySelector.field_190843_q, 359));
            lllllllllllIllIIllllIIIIIlIlIIll.add((Predicate<Entity>)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity lllllllllllllllIlIIIlllIIllllllI) {
                    if (lllllllllllllllIlIIIlllIIllllllI == null) {
                        return false;
                    }
                    final int lllllllllllllllIlIIIlllIlIIIIIII = MathHelper.clampAngle(MathHelper.floor(lllllllllllllllIlIIIlllIIllllllI.rotationYaw));
                    if (lllllllllllIllIIllllIIIIIlIlIIlI > lllllllllllIllIIllllIIIIIlIlIIIl) {
                        return lllllllllllllllIlIIIlllIlIIIIIII >= lllllllllllIllIIllllIIIIIlIlIIlI || lllllllllllllllIlIIIlllIlIIIIIII <= lllllllllllIllIIllllIIIIIlIlIIIl;
                    }
                    return lllllllllllllllIlIIIlllIlIIIIIII >= lllllllllllIllIIllllIIIIIlIlIIlI && lllllllllllllllIlIIIlllIlIIIIIII <= lllllllllllIllIIllllIIIIIlIlIIIl;
                }
            });
        }
        if (lllllllllllIllIIllllIIIIIlIlIlII.containsKey(EntitySelector.field_190842_p) || lllllllllllIllIIllllIIIIIlIlIlII.containsKey(EntitySelector.field_190841_o)) {
            final int lllllllllllIllIIllllIIIIIlIlIIII = MathHelper.clampAngle(getInt(lllllllllllIllIIllllIIIIIlIlIlII, EntitySelector.field_190842_p, 0));
            final int lllllllllllIllIIllllIIIIIlIIllll = MathHelper.clampAngle(getInt(lllllllllllIllIIllllIIIIIlIlIlII, EntitySelector.field_190841_o, 359));
            lllllllllllIllIIllllIIIIIlIlIIll.add((Predicate<Entity>)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity lllllllllllllIIlIlIlIllllllIIIlI) {
                    if (lllllllllllllIIlIlIlIllllllIIIlI == null) {
                        return false;
                    }
                    final int lllllllllllllIIlIlIlIllllllIIlII = MathHelper.clampAngle(MathHelper.floor(lllllllllllllIIlIlIlIllllllIIIlI.rotationPitch));
                    if (lllllllllllIllIIllllIIIIIlIlIIII > lllllllllllIllIIllllIIIIIlIIllll) {
                        return lllllllllllllIIlIlIlIllllllIIlII >= lllllllllllIllIIllllIIIIIlIlIIII || lllllllllllllIIlIlIlIllllllIIlII <= lllllllllllIllIIllllIIIIIlIIllll;
                    }
                    return lllllllllllllIIlIlIlIllllllIIlII >= lllllllllllIllIIllllIIIIIlIlIIII && lllllllllllllIIlIlIlIllllllIIlII <= lllllllllllIllIIllllIIIIIlIIllll;
                }
            });
        }
        return lllllllllllIllIIllllIIIIIlIlIIll;
    }
    
    private static boolean hasArgument(final Map<String, String> lllllllllllIllIIlllIlllllIlllIIl) {
        for (final String lllllllllllIllIIlllIlllllIlllIII : EntitySelector.WORLD_BINDING_ARGS) {
            if (lllllllllllIllIIlllIlllllIlllIIl.containsKey(lllllllllllIllIIlllIlllllIlllIII)) {
                return true;
            }
        }
        return false;
    }
    
    private static <T extends Entity> List<T> filterResults(final Map<String, String> lllllllllllIllIIllllIIIIIIlIIlIl, final Class<? extends T> lllllllllllIllIIllllIIIIIIllIlll, final List<Predicate<Entity>> lllllllllllIllIIllllIIIIIIllIllI, final String lllllllllllIllIIllllIIIIIIlIIIlI, final World lllllllllllIllIIllllIIIIIIlIIIIl, final BlockPos lllllllllllIllIIllllIIIIIIlIIIII) {
        final List<T> lllllllllllIllIIllllIIIIIIllIIlI = (List<T>)Lists.newArrayList();
        String lllllllllllIllIIllllIIIIIIllIIIl = getArgument(lllllllllllIllIIllllIIIIIIlIIlIl, EntitySelector.field_190849_w);
        lllllllllllIllIIllllIIIIIIllIIIl = ((lllllllllllIllIIllllIIIIIIllIIIl != null && lllllllllllIllIIllllIIIIIIllIIIl.startsWith("!")) ? lllllllllllIllIIllllIIIIIIllIIIl.substring(1) : lllllllllllIllIIllllIIIIIIllIIIl);
        final boolean lllllllllllIllIIllllIIIIIIllIIII = !lllllllllllIllIIllllIIIIIIlIIIlI.equals("e");
        final boolean lllllllllllIllIIllllIIIIIIlIllll = lllllllllllIllIIllllIIIIIIlIIIlI.equals("r") && lllllllllllIllIIllllIIIIIIllIIIl != null;
        final int lllllllllllIllIIllllIIIIIIlIlllI = getInt(lllllllllllIllIIllllIIIIIIlIIlIl, EntitySelector.field_190838_l, 0);
        final int lllllllllllIllIIllllIIIIIIlIllIl = getInt(lllllllllllIllIIllllIIIIIIlIIlIl, EntitySelector.field_190839_m, 0);
        final int lllllllllllIllIIllllIIIIIIlIllII = getInt(lllllllllllIllIIllllIIIIIIlIIlIl, EntitySelector.field_190840_n, 0);
        final int lllllllllllIllIIllllIIIIIIlIlIll = getInt(lllllllllllIllIIllllIIIIIIlIIlIl, EntitySelector.field_190831_e, -1);
        final Predicate<Entity> lllllllllllIllIIllllIIIIIIlIlIlI = (Predicate<Entity>)Predicates.and((Iterable)lllllllllllIllIIllllIIIIIIllIllI);
        final Predicate<Entity> lllllllllllIllIIllllIIIIIIlIlIIl = (Predicate<Entity>)Predicates.and((Predicate)EntitySelectors.IS_ALIVE, (Predicate)lllllllllllIllIIllllIIIIIIlIlIlI);
        if (!lllllllllllIllIIllllIIIIIIlIIlIl.containsKey(EntitySelector.field_190838_l) && !lllllllllllIllIIllllIIIIIIlIIlIl.containsKey(EntitySelector.field_190839_m) && !lllllllllllIllIIllllIIIIIIlIIlIl.containsKey(EntitySelector.field_190840_n)) {
            if (lllllllllllIllIIllllIIIIIIlIlIll >= 0) {
                final AxisAlignedBB lllllllllllIllIIllllIIIIIIlIlIII = new AxisAlignedBB(lllllllllllIllIIllllIIIIIIlIIIII.getX() - lllllllllllIllIIllllIIIIIIlIlIll, lllllllllllIllIIllllIIIIIIlIIIII.getY() - lllllllllllIllIIllllIIIIIIlIlIll, lllllllllllIllIIllllIIIIIIlIIIII.getZ() - lllllllllllIllIIllllIIIIIIlIlIll, lllllllllllIllIIllllIIIIIIlIIIII.getX() + lllllllllllIllIIllllIIIIIIlIlIll + 1, lllllllllllIllIIllllIIIIIIlIIIII.getY() + lllllllllllIllIIllllIIIIIIlIlIll + 1, lllllllllllIllIIllllIIIIIIlIIIII.getZ() + lllllllllllIllIIllllIIIIIIlIlIll + 1);
                if (lllllllllllIllIIllllIIIIIIllIIII && !lllllllllllIllIIllllIIIIIIlIllll) {
                    lllllllllllIllIIllllIIIIIIllIIlI.addAll((Collection<? extends T>)lllllllllllIllIIllllIIIIIIlIIIIl.getPlayers((Class<? extends Entity>)lllllllllllIllIIllllIIIIIIllIlll, (com.google.common.base.Predicate<? super Entity>)lllllllllllIllIIllllIIIIIIlIlIIl));
                }
                else {
                    lllllllllllIllIIllllIIIIIIllIIlI.addAll((Collection<? extends T>)lllllllllllIllIIllllIIIIIIlIIIIl.getEntitiesWithinAABB((Class<? extends Entity>)lllllllllllIllIIllllIIIIIIllIlll, lllllllllllIllIIllllIIIIIIlIlIII, (com.google.common.base.Predicate<? super Entity>)lllllllllllIllIIllllIIIIIIlIlIIl));
                }
            }
            else if (lllllllllllIllIIllllIIIIIIlIIIlI.equals("a")) {
                lllllllllllIllIIllllIIIIIIllIIlI.addAll((Collection<? extends T>)lllllllllllIllIIllllIIIIIIlIIIIl.getPlayers((Class<? extends Entity>)lllllllllllIllIIllllIIIIIIllIlll, (com.google.common.base.Predicate<? super Entity>)lllllllllllIllIIllllIIIIIIlIlIlI));
            }
            else if (!lllllllllllIllIIllllIIIIIIlIIIlI.equals("p") && (!lllllllllllIllIIllllIIIIIIlIIIlI.equals("r") || lllllllllllIllIIllllIIIIIIlIllll)) {
                lllllllllllIllIIllllIIIIIIllIIlI.addAll((Collection<? extends T>)lllllllllllIllIIllllIIIIIIlIIIIl.getEntities((Class<? extends Entity>)lllllllllllIllIIllllIIIIIIllIlll, (com.google.common.base.Predicate<? super Entity>)lllllllllllIllIIllllIIIIIIlIlIIl));
            }
            else {
                lllllllllllIllIIllllIIIIIIllIIlI.addAll((Collection<? extends T>)lllllllllllIllIIllllIIIIIIlIIIIl.getPlayers((Class<? extends Entity>)lllllllllllIllIIllllIIIIIIllIlll, (com.google.common.base.Predicate<? super Entity>)lllllllllllIllIIllllIIIIIIlIlIIl));
            }
        }
        else {
            final AxisAlignedBB lllllllllllIllIIllllIIIIIIlIIlll = getAABB(lllllllllllIllIIllllIIIIIIlIIIII, lllllllllllIllIIllllIIIIIIlIlllI, lllllllllllIllIIllllIIIIIIlIllIl, lllllllllllIllIIllllIIIIIIlIllII);
            if (lllllllllllIllIIllllIIIIIIllIIII && !lllllllllllIllIIllllIIIIIIlIllll) {
                final Predicate<Entity> lllllllllllIllIIllllIIIIIIlIIllI = (Predicate<Entity>)new Predicate<Entity>() {
                    public boolean apply(@Nullable final Entity lllllllllllllIlIllIlIlllIlIIllIl) {
                        return lllllllllllllIlIllIlIlllIlIIllIl != null && lllllllllllIllIIllllIIIIIIlIIlll.intersectsWith(lllllllllllllIlIllIlIlllIlIIllIl.getEntityBoundingBox());
                    }
                };
                lllllllllllIllIIllllIIIIIIllIIlI.addAll((Collection<? extends T>)lllllllllllIllIIllllIIIIIIlIIIIl.getPlayers((Class<? extends Entity>)lllllllllllIllIIllllIIIIIIllIlll, (com.google.common.base.Predicate<? super Entity>)Predicates.and((Predicate)lllllllllllIllIIllllIIIIIIlIlIIl, (Predicate)lllllllllllIllIIllllIIIIIIlIIllI)));
            }
            else {
                lllllllllllIllIIllllIIIIIIllIIlI.addAll((Collection<? extends T>)lllllllllllIllIIllllIIIIIIlIIIIl.getEntitiesWithinAABB((Class<? extends Entity>)lllllllllllIllIIllllIIIIIIllIlll, lllllllllllIllIIllllIIIIIIlIIlll, (com.google.common.base.Predicate<? super Entity>)lllllllllllIllIIllllIIIIIIlIlIIl));
            }
        }
        return lllllllllllIllIIllllIIIIIIllIIlI;
    }
    
    private static int getInt(final Map<String, String> lllllllllllIllIIlllIlllllIllIIIl, final String lllllllllllIllIIlllIlllllIlIllIl, final int lllllllllllIllIIlllIlllllIlIllll) {
        return lllllllllllIllIIlllIlllllIllIIIl.containsKey(lllllllllllIllIIlllIlllllIlIllIl) ? MathHelper.getInt(lllllllllllIllIIlllIlllllIllIIIl.get(lllllllllllIllIIlllIlllllIlIllIl), lllllllllllIllIIlllIlllllIlIllll) : lllllllllllIllIIlllIlllllIlIllll;
    }
    
    static {
        TOKEN_PATTERN = Pattern.compile("^@([pares])(?:\\[([^ ]*)\\])?$");
        field_190828_b = Splitter.on(',').omitEmptyStrings();
        field_190829_c = Splitter.on('=').limit(2);
        field_190830_d = Sets.newHashSet();
        field_190831_e = func_190826_c("r");
        field_190832_f = func_190826_c("rm");
        field_190833_g = func_190826_c("l");
        field_190834_h = func_190826_c("lm");
        field_190835_i = func_190826_c("x");
        field_190836_j = func_190826_c("y");
        field_190837_k = func_190826_c("z");
        field_190838_l = func_190826_c("dx");
        field_190839_m = func_190826_c("dy");
        field_190840_n = func_190826_c("dz");
        field_190841_o = func_190826_c("rx");
        field_190842_p = func_190826_c("rxm");
        field_190843_q = func_190826_c("ry");
        field_190844_r = func_190826_c("rym");
        field_190845_s = func_190826_c("c");
        field_190846_t = func_190826_c("m");
        field_190847_u = func_190826_c("team");
        field_190848_v = func_190826_c("name");
        field_190849_w = func_190826_c("type");
        field_190850_x = func_190826_c("tag");
        field_190851_y = (Predicate)new Predicate<String>() {
            public boolean apply(@Nullable final String lllllllllllIIIlIllllllIlIllllllI) {
                return lllllllllllIIIlIllllllIlIllllllI != null && (EntitySelector.field_190830_d.contains(lllllllllllIIIlIllllllIlIllllllI) || (lllllllllllIIIlIllllllIlIllllllI.length() > "score_".length() && lllllllllllIIIlIllllllIlIllllllI.startsWith("score_")));
            }
        };
        WORLD_BINDING_ARGS = Sets.newHashSet((Object[])new String[] { EntitySelector.field_190835_i, EntitySelector.field_190836_j, EntitySelector.field_190837_k, EntitySelector.field_190838_l, EntitySelector.field_190839_m, EntitySelector.field_190840_n, EntitySelector.field_190832_f, EntitySelector.field_190831_e });
    }
    
    @Nullable
    public static EntityPlayerMP matchOnePlayer(final ICommandSender lllllllllllIllIIllllIIIlIlIIllll, final String lllllllllllIllIIllllIIIlIlIIlllI) throws CommandException {
        return matchOneEntity(lllllllllllIllIIllllIIIlIlIIllll, lllllllllllIllIIllllIIIlIlIIlllI, (Class<? extends EntityPlayerMP>)EntityPlayerMP.class);
    }
    
    private static Vec3d getPosFromArguments(final Map<String, String> lllllllllllIllIIlllIllllllIIlIlI, final Vec3d lllllllllllIllIIlllIllllllIIlIll) {
        return new Vec3d(getCoordinate(lllllllllllIllIIlllIllllllIIlIlI, EntitySelector.field_190835_i, lllllllllllIllIIlllIllllllIIlIll.xCoord, true), getCoordinate(lllllllllllIllIIlllIllllllIIlIlI, EntitySelector.field_190836_j, lllllllllllIllIIlllIllllllIIlIll.yCoord, false), getCoordinate(lllllllllllIllIIlllIllllllIIlIlI, EntitySelector.field_190837_k, lllllllllllIllIIlllIllllllIIlIll.zCoord, true));
    }
    
    @Nullable
    public static <T extends Entity> T matchOneEntity(final ICommandSender lllllllllllIllIIllllIIIlIlIIIIll, final String lllllllllllIllIIllllIIIlIIlllllI, final Class<? extends T> lllllllllllIllIIllllIIIlIlIIIIIl) throws CommandException {
        final List<T> lllllllllllIllIIllllIIIlIlIIIIII = matchEntities(lllllllllllIllIIllllIIIlIlIIIIll, lllllllllllIllIIllllIIIlIIlllllI, lllllllllllIllIIllllIIIlIlIIIIIl);
        return (T)((lllllllllllIllIIllllIIIlIlIIIIII.size() == 1) ? ((T)lllllllllllIllIIllllIIIlIlIIIIII.get(0)) : null);
    }
    
    @Nullable
    public static ITextComponent matchEntitiesToTextComponent(final ICommandSender lllllllllllIllIIllllIIIlIIllIIII, final String lllllllllllIllIIllllIIIlIIlIllll) throws CommandException {
        final List<Entity> lllllllllllIllIIllllIIIlIIllIIll = matchEntities(lllllllllllIllIIllllIIIlIIllIIII, lllllllllllIllIIllllIIIlIIlIllll, (Class<? extends Entity>)Entity.class);
        if (lllllllllllIllIIllllIIIlIIllIIll.isEmpty()) {
            return null;
        }
        final List<ITextComponent> lllllllllllIllIIllllIIIlIIllIIlI = (List<ITextComponent>)Lists.newArrayList();
        for (final Entity lllllllllllIllIIllllIIIlIIllIIIl : lllllllllllIllIIllllIIIlIIllIIll) {
            lllllllllllIllIIllllIIIlIIllIIlI.add(lllllllllllIllIIllllIIIlIIllIIIl.getDisplayName());
        }
        return CommandBase.join(lllllllllllIllIIllllIIIlIIllIIlI);
    }
    
    public static boolean matchesMultiplePlayers(final String lllllllllllIllIIlllIlllllIIlIlIl) throws CommandException {
        final Matcher lllllllllllIllIIlllIlllllIIlIlII = EntitySelector.TOKEN_PATTERN.matcher(lllllllllllIllIIlllIlllllIIlIlIl);
        if (!lllllllllllIllIIlllIlllllIIlIlII.matches()) {
            return false;
        }
        final Map<String, String> lllllllllllIllIIlllIlllllIIlIIll = getArgumentMap(lllllllllllIllIIlllIlllllIIlIlII.group(2));
        final String lllllllllllIllIIlllIlllllIIlIIlI = lllllllllllIllIIlllIlllllIIlIlII.group(1);
        final int lllllllllllIllIIlllIlllllIIlIIIl = (!"a".equals(lllllllllllIllIIlllIlllllIIlIIlI) && !"e".equals(lllllllllllIllIIlllIlllllIIlIIlI)) ? 1 : 0;
        return getInt(lllllllllllIllIIlllIlllllIIlIIll, EntitySelector.field_190845_s, lllllllllllIllIIlllIlllllIIlIIIl) != 1;
    }
    
    private static BlockPos getBlockPosFromArguments(final Map<String, String> lllllllllllIllIIlllIllllllIlIIII, final BlockPos lllllllllllIllIIlllIllllllIlIIIl) {
        return new BlockPos(getInt(lllllllllllIllIIlllIllllllIlIIII, EntitySelector.field_190835_i, lllllllllllIllIIlllIllllllIlIIIl.getX()), getInt(lllllllllllIllIIlllIllllllIlIIII, EntitySelector.field_190836_j, lllllllllllIllIIlllIllllllIlIIIl.getY()), getInt(lllllllllllIllIIlllIllllllIlIIII, EntitySelector.field_190837_k, lllllllllllIllIIlllIllllllIlIIIl.getZ()));
    }
    
    private static Map<String, String> getArgumentMap(@Nullable final String lllllllllllIllIIlllIlllllIIIIIlI) throws CommandException {
        final Map<String, String> lllllllllllIllIIlllIlllllIIIIIIl = (Map<String, String>)Maps.newHashMap();
        if (lllllllllllIllIIlllIlllllIIIIIlI == null) {
            return lllllllllllIllIIlllIlllllIIIIIIl;
        }
        for (final String lllllllllllIllIIlllIlllllIIIIIII : EntitySelector.field_190828_b.split((CharSequence)lllllllllllIllIIlllIlllllIIIIIlI)) {
            final Iterator<String> lllllllllllIllIIlllIllllIlllllll = EntitySelector.field_190829_c.split((CharSequence)lllllllllllIllIIlllIlllllIIIIIII).iterator();
            final String lllllllllllIllIIlllIllllIllllllI = lllllllllllIllIIlllIllllIlllllll.next();
            if (!EntitySelector.field_190851_y.apply((Object)lllllllllllIllIIlllIllllIllllllI)) {
                throw new CommandException("commands.generic.selector_argument", new Object[] { lllllllllllIllIIlllIlllllIIIIIII });
            }
            lllllllllllIllIIlllIlllllIIIIIIl.put(lllllllllllIllIIlllIllllIllllllI, lllllllllllIllIIlllIllllIlllllll.hasNext() ? lllllllllllIllIIlllIllllIlllllll.next() : "");
        }
        return lllllllllllIllIIlllIlllllIIIIIIl;
    }
    
    private static List<Predicate<Entity>> getScorePredicates(final ICommandSender lllllllllllIllIIllllIIIIlIIllIlI, final Map<String, String> lllllllllllIllIIllllIIIIlIIllIIl) {
        final Map<String, Integer> lllllllllllIllIIllllIIIIlIIllIII = getScoreMap(lllllllllllIllIIllllIIIIlIIllIIl);
        return lllllllllllIllIIllllIIIIlIIllIII.isEmpty() ? Collections.emptyList() : Lists.newArrayList((Object[])new Predicate[] { (Predicate)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity llllllllllllIIIlIIIIIlllIlIIlIll) {
                    if (llllllllllllIIIlIIIIIlllIlIIlIll == null) {
                        return false;
                    }
                    final Scoreboard llllllllllllIIIlIIIIIlllIlIlIlII = lllllllllllIllIIllllIIIIlIIllIlI.getServer().worldServerForDimension(0).getScoreboard();
                    for (final Map.Entry<String, Integer> llllllllllllIIIlIIIIIlllIlIlIIll : lllllllllllIllIIllllIIIIlIIllIII.entrySet()) {
                        String llllllllllllIIIlIIIIIlllIlIlIIlI = llllllllllllIIIlIIIIIlllIlIlIIll.getKey();
                        boolean llllllllllllIIIlIIIIIlllIlIlIIIl = false;
                        if (llllllllllllIIIlIIIIIlllIlIlIIlI.endsWith("_min") && llllllllllllIIIlIIIIIlllIlIlIIlI.length() > 4) {
                            llllllllllllIIIlIIIIIlllIlIlIIIl = true;
                            llllllllllllIIIlIIIIIlllIlIlIIlI = llllllllllllIIIlIIIIIlllIlIlIIlI.substring(0, llllllllllllIIIlIIIIIlllIlIlIIlI.length() - 4);
                        }
                        final ScoreObjective llllllllllllIIIlIIIIIlllIlIlIIII = llllllllllllIIIlIIIIIlllIlIlIlII.getObjective(llllllllllllIIIlIIIIIlllIlIlIIlI);
                        if (llllllllllllIIIlIIIIIlllIlIlIIII == null) {
                            return false;
                        }
                        final String llllllllllllIIIlIIIIIlllIlIIllll = (llllllllllllIIIlIIIIIlllIlIIlIll instanceof EntityPlayerMP) ? llllllllllllIIIlIIIIIlllIlIIlIll.getName() : llllllllllllIIIlIIIIIlllIlIIlIll.getCachedUniqueIdString();
                        if (!llllllllllllIIIlIIIIIlllIlIlIlII.entityHasObjective(llllllllllllIIIlIIIIIlllIlIIllll, llllllllllllIIIlIIIIIlllIlIlIIII)) {
                            return false;
                        }
                        final Score llllllllllllIIIlIIIIIlllIlIIlllI = llllllllllllIIIlIIIIIlllIlIlIlII.getOrCreateScore(llllllllllllIIIlIIIIIlllIlIIllll, llllllllllllIIIlIIIIIlllIlIlIIII);
                        final int llllllllllllIIIlIIIIIlllIlIIllIl = llllllllllllIIIlIIIIIlllIlIIlllI.getScorePoints();
                        if (llllllllllllIIIlIIIIIlllIlIIllIl < llllllllllllIIIlIIIIIlllIlIlIIll.getValue() && llllllllllllIIIlIIIIIlllIlIlIIIl) {
                            return false;
                        }
                        if (llllllllllllIIIlIIIIIlllIlIIllIl > llllllllllllIIIlIIIIIlllIlIlIIll.getValue() && !llllllllllllIIIlIIIIIlllIlIlIIIl) {
                            return false;
                        }
                    }
                    return true;
                }
            } });
    }
    
    private static List<World> getWorlds(final ICommandSender lllllllllllIllIIllllIIIIllllIIIl, final Map<String, String> lllllllllllIllIIllllIIIIlllIllIl) {
        final List<World> lllllllllllIllIIllllIIIIlllIllll = (List<World>)Lists.newArrayList();
        if (hasArgument(lllllllllllIllIIllllIIIIlllIllIl)) {
            lllllllllllIllIIllllIIIIlllIllll.add(lllllllllllIllIIllllIIIIllllIIIl.getEntityWorld());
        }
        else {
            Collections.addAll(lllllllllllIllIIllllIIIIlllIllll, lllllllllllIllIIllllIIIIllllIIIl.getServer().worldServers);
        }
        return lllllllllllIllIIllllIIIIlllIllll;
    }
    
    private static <T extends Entity> List<T> getEntitiesFromPredicates(List<T> lllllllllllIllIIllllIIIIIIIIlIll, final Map<String, String> lllllllllllIllIIllllIIIIIIIIlIlI, final ICommandSender lllllllllllIllIIllllIIIIIIIIIIIl, final Class<? extends T> lllllllllllIllIIllllIIIIIIIIIIII, final String lllllllllllIllIIllllIIIIIIIIIlll, final Vec3d lllllllllllIllIIllllIIIIIIIIIllI) {
        final int lllllllllllIllIIllllIIIIIIIIIlIl = getInt(lllllllllllIllIIllllIIIIIIIIlIlI, EntitySelector.field_190845_s, (!lllllllllllIllIIllllIIIIIIIIIlll.equals("a") && !lllllllllllIllIIllllIIIIIIIIIlll.equals("e")) ? 1 : 0);
        if (!lllllllllllIllIIllllIIIIIIIIIlll.equals("p") && !lllllllllllIllIIllllIIIIIIIIIlll.equals("a") && !lllllllllllIllIIllllIIIIIIIIIlll.equals("e")) {
            if (lllllllllllIllIIllllIIIIIIIIIlll.equals("r")) {
                Collections.shuffle(lllllllllllIllIIllllIIIIIIIIlIll);
            }
        }
        else {
            Collections.sort(lllllllllllIllIIllllIIIIIIIIlIll, new Comparator<Entity>() {
                @Override
                public int compare(final Entity llllllllllllIIlIlIIllIIlIlIIIIll, final Entity llllllllllllIIlIlIIllIIlIIllllll) {
                    return ComparisonChain.start().compare(llllllllllllIIlIlIIllIIlIlIIIIll.getDistanceSq(lllllllllllIllIIllllIIIIIIIIIllI.xCoord, lllllllllllIllIIllllIIIIIIIIIllI.yCoord, lllllllllllIllIIllllIIIIIIIIIllI.zCoord), llllllllllllIIlIlIIllIIlIIllllll.getDistanceSq(lllllllllllIllIIllllIIIIIIIIIllI.xCoord, lllllllllllIllIIllllIIIIIIIIIllI.yCoord, lllllllllllIllIIllllIIIIIIIIIllI.zCoord)).result();
                }
            });
        }
        final Entity lllllllllllIllIIllllIIIIIIIIIlII = lllllllllllIllIIllllIIIIIIIIIIIl.getCommandSenderEntity();
        if (lllllllllllIllIIllllIIIIIIIIIlII != null && lllllllllllIllIIllllIIIIIIIIIIII.isAssignableFrom(lllllllllllIllIIllllIIIIIIIIIlII.getClass()) && lllllllllllIllIIllllIIIIIIIIIlIl == 1 && lllllllllllIllIIllllIIIIIIIIlIll.contains(lllllllllllIllIIllllIIIIIIIIIlII) && !"r".equals(lllllllllllIllIIllllIIIIIIIIIlll)) {
            lllllllllllIllIIllllIIIIIIIIlIll = (List<T>)Lists.newArrayList((Object[])new Entity[] { lllllllllllIllIIllllIIIIIIIIIlII });
        }
        if (lllllllllllIllIIllllIIIIIIIIIlIl != 0) {
            if (lllllllllllIllIIllllIIIIIIIIIlIl < 0) {
                Collections.reverse(lllllllllllIllIIllllIIIIIIIIlIll);
            }
            lllllllllllIllIIllllIIIIIIIIlIll = lllllllllllIllIIllllIIIIIIIIlIll.subList(0, Math.min(Math.abs(lllllllllllIllIIllllIIIIIIIIIlIl), lllllllllllIllIIllllIIIIIIIIlIll.size()));
        }
        return lllllllllllIllIIllllIIIIIIIIlIll;
    }
    
    private static <T extends Entity> boolean isEntityTypeValid(final ICommandSender lllllllllllIllIIllllIIIIlllIIllI, final Map<String, String> lllllllllllIllIIllllIIIIlllIIlIl) {
        final String lllllllllllIllIIllllIIIIlllIIlII = getArgument(lllllllllllIllIIllllIIIIlllIIlIl, EntitySelector.field_190849_w);
        if (lllllllllllIllIIllllIIIIlllIIlII == null) {
            return true;
        }
        final ResourceLocation lllllllllllIllIIllllIIIIlllIIIll = new ResourceLocation(lllllllllllIllIIllllIIIIlllIIlII.startsWith("!") ? lllllllllllIllIIllllIIIIlllIIlII.substring(1) : lllllllllllIllIIllllIIIIlllIIlII);
        if (EntityList.isStringValidEntityName(lllllllllllIllIIllllIIIIlllIIIll)) {
            return true;
        }
        final TextComponentTranslation lllllllllllIllIIllllIIIIlllIIIlI = new TextComponentTranslation("commands.generic.entity.invalidType", new Object[] { lllllllllllIllIIllllIIIIlllIIIll });
        lllllllllllIllIIllllIIIIlllIIIlI.getStyle().setColor(TextFormatting.RED);
        lllllllllllIllIIllllIIIIlllIIllI.addChatMessage(lllllllllllIllIIllllIIIIlllIIIlI);
        return false;
    }
    
    public static Map<String, Integer> getScoreMap(final Map<String, String> lllllllllllIllIIlllIlllllIlIIIIl) {
        final Map<String, Integer> lllllllllllIllIIlllIlllllIlIIIII = (Map<String, Integer>)Maps.newHashMap();
        for (final String lllllllllllIllIIlllIlllllIIlllll : lllllllllllIllIIlllIlllllIlIIIIl.keySet()) {
            if (lllllllllllIllIIlllIlllllIIlllll.startsWith("score_") && lllllllllllIllIIlllIlllllIIlllll.length() > "score_".length()) {
                lllllllllllIllIIlllIlllllIlIIIII.put(lllllllllllIllIIlllIlllllIIlllll.substring("score_".length()), MathHelper.getInt(lllllllllllIllIIlllIlllllIlIIIIl.get(lllllllllllIllIIlllIlllllIIlllll), 1));
            }
        }
        return lllllllllllIllIIlllIlllllIlIIIII;
    }
    
    private static List<Predicate<Entity>> getTeamPredicates(final Map<String, String> lllllllllllIllIIllllIIIIlIlIIIlI) {
        final List<Predicate<Entity>> lllllllllllIllIIllllIIIIlIlIIllI = (List<Predicate<Entity>>)Lists.newArrayList();
        String lllllllllllIllIIllllIIIIlIlIIlIl = getArgument(lllllllllllIllIIllllIIIIlIlIIIlI, EntitySelector.field_190847_u);
        final boolean lllllllllllIllIIllllIIIIlIlIIlII = lllllllllllIllIIllllIIIIlIlIIlIl != null && lllllllllllIllIIllllIIIIlIlIIlIl.startsWith("!");
        if (lllllllllllIllIIllllIIIIlIlIIlII) {
            lllllllllllIllIIllllIIIIlIlIIlIl = lllllllllllIllIIllllIIIIlIlIIlIl.substring(1);
        }
        if (lllllllllllIllIIllllIIIIlIlIIlIl != null) {
            final String lllllllllllIllIIllllIIIIlIlIIIll = lllllllllllIllIIllllIIIIlIlIIlIl;
            lllllllllllIllIIllllIIIIlIlIIllI.add((Predicate<Entity>)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity lllllllllllIIIIlIIIlIlllIllIlIII) {
                    if (!(lllllllllllIIIIlIIIlIlllIllIlIII instanceof EntityLivingBase)) {
                        return false;
                    }
                    final EntityLivingBase lllllllllllIIIIlIIIlIlllIllIllII = (EntityLivingBase)lllllllllllIIIIlIIIlIlllIllIlIII;
                    final Team lllllllllllIIIIlIIIlIlllIllIlIll = lllllllllllIIIIlIIIlIlllIllIllII.getTeam();
                    final String lllllllllllIIIIlIIIlIlllIllIlIlI = (lllllllllllIIIIlIIIlIlllIllIlIll == null) ? "" : lllllllllllIIIIlIIIlIlllIllIlIll.getRegisteredName();
                    return lllllllllllIIIIlIIIlIlllIllIlIlI.equals(lllllllllllIllIIllllIIIIlIlIIIll) ^ lllllllllllIllIIllllIIIIlIlIIlII;
                }
            });
        }
        return lllllllllllIllIIllllIIIIlIlIIllI;
    }
    
    private static AxisAlignedBB getAABB(final BlockPos lllllllllllIllIIlllIlllllllIIIIl, final int lllllllllllIllIIlllIlllllllIIIII, final int lllllllllllIllIIlllIllllllIlllll, final int lllllllllllIllIIlllIlllllllIlIll) {
        final boolean lllllllllllIllIIlllIlllllllIlIlI = lllllllllllIllIIlllIlllllllIIIII < 0;
        final boolean lllllllllllIllIIlllIlllllllIlIIl = lllllllllllIllIIlllIllllllIlllll < 0;
        final boolean lllllllllllIllIIlllIlllllllIlIII = lllllllllllIllIIlllIlllllllIlIll < 0;
        final int lllllllllllIllIIlllIlllllllIIlll = lllllllllllIllIIlllIlllllllIIIIl.getX() + (lllllllllllIllIIlllIlllllllIlIlI ? lllllllllllIllIIlllIlllllllIIIII : 0);
        final int lllllllllllIllIIlllIlllllllIIllI = lllllllllllIllIIlllIlllllllIIIIl.getY() + (lllllllllllIllIIlllIlllllllIlIIl ? lllllllllllIllIIlllIllllllIlllll : 0);
        final int lllllllllllIllIIlllIlllllllIIlIl = lllllllllllIllIIlllIlllllllIIIIl.getZ() + (lllllllllllIllIIlllIlllllllIlIII ? lllllllllllIllIIlllIlllllllIlIll : 0);
        final int lllllllllllIllIIlllIlllllllIIlII = lllllllllllIllIIlllIlllllllIIIIl.getX() + (lllllllllllIllIIlllIlllllllIlIlI ? 0 : lllllllllllIllIIlllIlllllllIIIII) + 1;
        final int lllllllllllIllIIlllIlllllllIIIll = lllllllllllIllIIlllIlllllllIIIIl.getY() + (lllllllllllIllIIlllIlllllllIlIIl ? 0 : lllllllllllIllIIlllIllllllIlllll) + 1;
        final int lllllllllllIllIIlllIlllllllIIIlI = lllllllllllIllIIlllIlllllllIIIIl.getZ() + (lllllllllllIllIIlllIlllllllIlIII ? 0 : lllllllllllIllIIlllIlllllllIlIll) + 1;
        return new AxisAlignedBB(lllllllllllIllIIlllIlllllllIIlll, lllllllllllIllIIlllIlllllllIIllI, lllllllllllIllIIlllIlllllllIIlIl, lllllllllllIllIIlllIlllllllIIlII, lllllllllllIllIIlllIlllllllIIIll, lllllllllllIllIIlllIlllllllIIIlI);
    }
    
    private static List<Predicate<Entity>> getRadiusPredicates(final Map<String, String> lllllllllllIllIIllllIIIIIllIIIlI, final Vec3d lllllllllllIllIIllllIIIIIllIlIll) {
        final double lllllllllllIllIIllllIIIIIllIlIlI = getInt(lllllllllllIllIIllllIIIIIllIIIlI, EntitySelector.field_190832_f, -1);
        final double lllllllllllIllIIllllIIIIIllIlIIl = getInt(lllllllllllIllIIllllIIIIIllIIIlI, EntitySelector.field_190831_e, -1);
        final boolean lllllllllllIllIIllllIIIIIllIlIII = lllllllllllIllIIllllIIIIIllIlIlI < -0.5;
        final boolean lllllllllllIllIIllllIIIIIllIIlll = lllllllllllIllIIllllIIIIIllIlIIl < -0.5;
        if (lllllllllllIllIIllllIIIIIllIlIII && lllllllllllIllIIllllIIIIIllIIlll) {
            return Collections.emptyList();
        }
        final double lllllllllllIllIIllllIIIIIllIIllI = Math.max(lllllllllllIllIIllllIIIIIllIlIlI, 1.0E-4);
        final double lllllllllllIllIIllllIIIIIllIIlIl = lllllllllllIllIIllllIIIIIllIIllI * lllllllllllIllIIllllIIIIIllIIllI;
        final double lllllllllllIllIIllllIIIIIllIIlII = Math.max(lllllllllllIllIIllllIIIIIllIlIIl, 1.0E-4);
        final double lllllllllllIllIIllllIIIIIllIIIll = lllllllllllIllIIllllIIIIIllIIlII * lllllllllllIllIIllllIIIIIllIIlII;
        return (List<Predicate<Entity>>)Lists.newArrayList((Object[])new Predicate[] { (Predicate)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity llllllllllllllIIIlIlIIIIllIIllIl) {
                    if (llllllllllllllIIIlIlIIIIllIIllIl == null) {
                        return false;
                    }
                    final double llllllllllllllIIIlIlIIIIllIIllII = lllllllllllIllIIllllIIIIIllIlIll.squareDistanceTo(llllllllllllllIIIlIlIIIIllIIllIl.posX, llllllllllllllIIIlIlIIIIllIIllIl.posY, llllllllllllllIIIlIlIIIIllIIllIl.posZ);
                    return (lllllllllllIllIIllllIIIIIllIlIII || llllllllllllllIIIlIlIIIIllIIllII >= lllllllllllIllIIllllIIIIIllIIlIl) && (lllllllllllIllIIllllIIIIIllIIlll || llllllllllllllIIIlIlIIIIllIIllII <= lllllllllllIllIIllllIIIIIllIIIll);
                }
            } });
    }
    
    private static List<Predicate<Entity>> getTagPredicates(final Map<String, String> lllllllllllIllIIllllIIIIlIIIIIII) {
        final List<Predicate<Entity>> lllllllllllIllIIllllIIIIIlllllll = (List<Predicate<Entity>>)Lists.newArrayList();
        String lllllllllllIllIIllllIIIIIllllllI = getArgument(lllllllllllIllIIllllIIIIlIIIIIII, EntitySelector.field_190850_x);
        final boolean lllllllllllIllIIllllIIIIIlllllIl = lllllllllllIllIIllllIIIIIllllllI != null && lllllllllllIllIIllllIIIIIllllllI.startsWith("!");
        if (lllllllllllIllIIllllIIIIIlllllIl) {
            lllllllllllIllIIllllIIIIIllllllI = lllllllllllIllIIllllIIIIIllllllI.substring(1);
        }
        if (lllllllllllIllIIllllIIIIIllllllI != null) {
            final String lllllllllllIllIIllllIIIIIlllllII = lllllllllllIllIIllllIIIIIllllllI;
            lllllllllllIllIIllllIIIIIlllllll.add((Predicate<Entity>)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity llllllllllllIIIlIlllIlllIllIllll) {
                    if (llllllllllllIIIlIlllIlllIllIllll == null) {
                        return false;
                    }
                    if ("".equals(lllllllllllIllIIllllIIIIIlllllII)) {
                        return llllllllllllIIIlIlllIlllIllIllll.getTags().isEmpty() ^ lllllllllllIllIIllllIIIIIlllllIl;
                    }
                    return llllllllllllIIIlIlllIlllIllIllll.getTags().contains(lllllllllllIllIIllllIIIIIlllllII) ^ lllllllllllIllIIllllIIIIIlllllIl;
                }
            });
        }
        return lllllllllllIllIIllllIIIIIlllllll;
    }
    
    private static List<Predicate<Entity>> getTypePredicates(final Map<String, String> lllllllllllIllIIllllIIIIllIlIlll, final String lllllllllllIllIIllllIIIIllIlIIIl) {
        final String lllllllllllIllIIllllIIIIllIlIlIl = getArgument(lllllllllllIllIIllllIIIIllIlIlll, EntitySelector.field_190849_w);
        if (lllllllllllIllIIllllIIIIllIlIlIl == null || (!lllllllllllIllIIllllIIIIllIlIIIl.equals("e") && !lllllllllllIllIIllllIIIIllIlIIIl.equals("r") && !lllllllllllIllIIllllIIIIllIlIIIl.equals("s"))) {
            return (List<Predicate<Entity>>)((lllllllllllIllIIllllIIIIllIlIIIl.equals("e") || lllllllllllIllIIllllIIIIllIlIIIl.equals("s")) ? Collections.emptyList() : Collections.singletonList(new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity llllllllllllIIllIIlllIlIlllIIIll) {
                    return llllllllllllIIllIIlllIlIlllIIIll instanceof EntityPlayer;
                }
            }));
        }
        final boolean lllllllllllIllIIllllIIIIllIlIlII = lllllllllllIllIIllllIIIIllIlIlIl.startsWith("!");
        final ResourceLocation lllllllllllIllIIllllIIIIllIlIIll = new ResourceLocation(lllllllllllIllIIllllIIIIllIlIlII ? lllllllllllIllIIllllIIIIllIlIlIl.substring(1) : lllllllllllIllIIllllIIIIllIlIlIl);
        return Collections.singletonList((Predicate<Entity>)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllIIIllIIIIlIlIlIIIlIIl) {
                return EntityList.isStringEntityName(lllllllllllIIIllIIIIlIlIlIIIlIIl, lllllllllllIllIIllllIIIIllIlIIll) ^ lllllllllllIllIIllllIIIIllIlIlII;
            }
        });
    }
    
    @Nullable
    private static String getArgument(final Map<String, String> lllllllllllIllIIlllIlllllIlIIlll, final String lllllllllllIllIIlllIlllllIlIlIII) {
        return lllllllllllIllIIlllIlllllIlIIlll.get(lllllllllllIllIIlllIlllllIlIlIII);
    }
    
    public static boolean hasArguments(final String lllllllllllIllIIlllIlllllIIIlIlI) {
        return EntitySelector.TOKEN_PATTERN.matcher(lllllllllllIllIIlllIlllllIIIlIlI).matches();
    }
    
    public static List<EntityPlayerMP> func_193531_b(final ICommandSender lllllllllllIllIIllllIIIlIlIIlIIl, final String lllllllllllIllIIllllIIIlIlIIlIlI) throws CommandException {
        return matchEntities(lllllllllllIllIIllllIIIlIlIIlIIl, lllllllllllIllIIllllIIIlIlIIlIlI, (Class<? extends EntityPlayerMP>)EntityPlayerMP.class);
    }
    
    private static List<Predicate<Entity>> getNamePredicates(final Map<String, String> lllllllllllIllIIllllIIIIlIIIlIlI) {
        final List<Predicate<Entity>> lllllllllllIllIIllllIIIIlIIIlllI = (List<Predicate<Entity>>)Lists.newArrayList();
        String lllllllllllIllIIllllIIIIlIIIllIl = getArgument(lllllllllllIllIIllllIIIIlIIIlIlI, EntitySelector.field_190848_v);
        final boolean lllllllllllIllIIllllIIIIlIIIllII = lllllllllllIllIIllllIIIIlIIIllIl != null && lllllllllllIllIIllllIIIIlIIIllIl.startsWith("!");
        if (lllllllllllIllIIllllIIIIlIIIllII) {
            lllllllllllIllIIllllIIIIlIIIllIl = lllllllllllIllIIllllIIIIlIIIllIl.substring(1);
        }
        if (lllllllllllIllIIllllIIIIlIIIllIl != null) {
            final String lllllllllllIllIIllllIIIIlIIIlIll = lllllllllllIllIIllllIIIIlIIIllIl;
            lllllllllllIllIIllllIIIIlIIIlllI.add((Predicate<Entity>)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity llllllllllIllllllllllllIIIIIIlll) {
                    return llllllllllIllllllllllllIIIIIIlll != null && llllllllllIllllllllllllIIIIIIlll.getName().equals(lllllllllllIllIIllllIIIIlIIIlIll) != lllllllllllIllIIllllIIIIlIIIllII;
                }
            });
        }
        return lllllllllllIllIIllllIIIIlIIIlllI;
    }
    
    private static List<Predicate<Entity>> getXpLevelPredicates(final Map<String, String> lllllllllllIllIIllllIIIIllIIlIIl) {
        final List<Predicate<Entity>> lllllllllllIllIIllllIIIIllIIlIII = (List<Predicate<Entity>>)Lists.newArrayList();
        final int lllllllllllIllIIllllIIIIllIIIlll = getInt(lllllllllllIllIIllllIIIIllIIlIIl, EntitySelector.field_190834_h, -1);
        final int lllllllllllIllIIllllIIIIllIIIllI = getInt(lllllllllllIllIIllllIIIIllIIlIIl, EntitySelector.field_190833_g, -1);
        if (lllllllllllIllIIllllIIIIllIIIlll > -1 || lllllllllllIllIIllllIIIIllIIIllI > -1) {
            lllllllllllIllIIllllIIIIllIIlIII.add((Predicate<Entity>)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity lllllllllllIIllIIIIlIIllIlllIIll) {
                    if (!(lllllllllllIIllIIIIlIIllIlllIIll instanceof EntityPlayerMP)) {
                        return false;
                    }
                    final EntityPlayerMP lllllllllllIIllIIIIlIIllIlllIlIl = (EntityPlayerMP)lllllllllllIIllIIIIlIIllIlllIIll;
                    return (lllllllllllIllIIllllIIIIllIIIlll <= -1 || lllllllllllIIllIIIIlIIllIlllIlIl.experienceLevel >= lllllllllllIllIIllllIIIIllIIIlll) && (lllllllllllIllIIllllIIIIllIIIllI <= -1 || lllllllllllIIllIIIIlIIllIlllIlIl.experienceLevel <= lllllllllllIllIIllllIIIIllIIIllI);
                }
            });
        }
        return lllllllllllIllIIllllIIIIllIIlIII;
    }
    
    public static <T extends Entity> List<T> matchEntities(final ICommandSender lllllllllllIllIIllllIIIlIIIIIllI, final String lllllllllllIllIIllllIIIlIIIlIlll, final Class<? extends T> lllllllllllIllIIllllIIIlIIIIIlII) throws CommandException {
        final Matcher lllllllllllIllIIllllIIIlIIIlIlIl = EntitySelector.TOKEN_PATTERN.matcher(lllllllllllIllIIllllIIIlIIIlIlll);
        if (!lllllllllllIllIIllllIIIlIIIlIlIl.matches() || !lllllllllllIllIIllllIIIlIIIIIllI.canCommandSenderUseCommand(1, "@")) {
            return Collections.emptyList();
        }
        final Map<String, String> lllllllllllIllIIllllIIIlIIIlIlII = getArgumentMap(lllllllllllIllIIllllIIIlIIIlIlIl.group(2));
        if (!isEntityTypeValid(lllllllllllIllIIllllIIIlIIIIIllI, lllllllllllIllIIllllIIIlIIIlIlII)) {
            return Collections.emptyList();
        }
        final String lllllllllllIllIIllllIIIlIIIlIIll = lllllllllllIllIIllllIIIlIIIlIlIl.group(1);
        final BlockPos lllllllllllIllIIllllIIIlIIIlIIlI = getBlockPosFromArguments(lllllllllllIllIIllllIIIlIIIlIlII, lllllllllllIllIIllllIIIlIIIIIllI.getPosition());
        final Vec3d lllllllllllIllIIllllIIIlIIIlIIIl = getPosFromArguments(lllllllllllIllIIllllIIIlIIIlIlII, lllllllllllIllIIllllIIIlIIIIIllI.getPositionVector());
        final List<World> lllllllllllIllIIllllIIIlIIIlIIII = getWorlds(lllllllllllIllIIllllIIIlIIIIIllI, lllllllllllIllIIllllIIIlIIIlIlII);
        final List<T> lllllllllllIllIIllllIIIlIIIIllll = (List<T>)Lists.newArrayList();
        for (final World lllllllllllIllIIllllIIIlIIIIlllI : lllllllllllIllIIllllIIIlIIIlIIII) {
            if (lllllllllllIllIIllllIIIlIIIIlllI != null) {
                final List<Predicate<Entity>> lllllllllllIllIIllllIIIlIIIIllIl = (List<Predicate<Entity>>)Lists.newArrayList();
                lllllllllllIllIIllllIIIlIIIIllIl.addAll(getTypePredicates(lllllllllllIllIIllllIIIlIIIlIlII, lllllllllllIllIIllllIIIlIIIlIIll));
                lllllllllllIllIIllllIIIlIIIIllIl.addAll(getXpLevelPredicates(lllllllllllIllIIllllIIIlIIIlIlII));
                lllllllllllIllIIllllIIIlIIIIllIl.addAll(getGamemodePredicates(lllllllllllIllIIllllIIIlIIIlIlII));
                lllllllllllIllIIllllIIIlIIIIllIl.addAll(getTeamPredicates(lllllllllllIllIIllllIIIlIIIlIlII));
                lllllllllllIllIIllllIIIlIIIIllIl.addAll(getScorePredicates(lllllllllllIllIIllllIIIlIIIIIllI, lllllllllllIllIIllllIIIlIIIlIlII));
                lllllllllllIllIIllllIIIlIIIIllIl.addAll(getNamePredicates(lllllllllllIllIIllllIIIlIIIlIlII));
                lllllllllllIllIIllllIIIlIIIIllIl.addAll(getTagPredicates(lllllllllllIllIIllllIIIlIIIlIlII));
                lllllllllllIllIIllllIIIlIIIIllIl.addAll(getRadiusPredicates(lllllllllllIllIIllllIIIlIIIlIlII, lllllllllllIllIIllllIIIlIIIlIIIl));
                lllllllllllIllIIllllIIIlIIIIllIl.addAll(getRotationsPredicates(lllllllllllIllIIllllIIIlIIIlIlII));
                if ("s".equalsIgnoreCase(lllllllllllIllIIllllIIIlIIIlIIll)) {
                    final Entity lllllllllllIllIIllllIIIlIIIIllII = lllllllllllIllIIllllIIIlIIIIIllI.getCommandSenderEntity();
                    if (lllllllllllIllIIllllIIIlIIIIllII != null && lllllllllllIllIIllllIIIlIIIIIlII.isAssignableFrom(lllllllllllIllIIllllIIIlIIIIllII.getClass())) {
                        if (lllllllllllIllIIllllIIIlIIIlIlII.containsKey(EntitySelector.field_190838_l) || lllllllllllIllIIllllIIIlIIIlIlII.containsKey(EntitySelector.field_190839_m) || lllllllllllIllIIllllIIIlIIIlIlII.containsKey(EntitySelector.field_190840_n)) {
                            final int lllllllllllIllIIllllIIIlIIIIlIll = getInt(lllllllllllIllIIllllIIIlIIIlIlII, EntitySelector.field_190838_l, 0);
                            final int lllllllllllIllIIllllIIIlIIIIlIlI = getInt(lllllllllllIllIIllllIIIlIIIlIlII, EntitySelector.field_190839_m, 0);
                            final int lllllllllllIllIIllllIIIlIIIIlIIl = getInt(lllllllllllIllIIllllIIIlIIIlIlII, EntitySelector.field_190840_n, 0);
                            final AxisAlignedBB lllllllllllIllIIllllIIIlIIIIlIII = getAABB(lllllllllllIllIIllllIIIlIIIlIIlI, lllllllllllIllIIllllIIIlIIIIlIll, lllllllllllIllIIllllIIIlIIIIlIlI, lllllllllllIllIIllllIIIlIIIIlIIl);
                            if (!lllllllllllIllIIllllIIIlIIIIlIII.intersectsWith(lllllllllllIllIIllllIIIlIIIIllII.getEntityBoundingBox())) {
                                return Collections.emptyList();
                            }
                        }
                        for (final Predicate<Entity> lllllllllllIllIIllllIIIlIIIIIlll : lllllllllllIllIIllllIIIlIIIIllIl) {
                            if (!lllllllllllIllIIllllIIIlIIIIIlll.apply((Object)lllllllllllIllIIllllIIIlIIIIllII)) {
                                return Collections.emptyList();
                            }
                        }
                        return (List<T>)Lists.newArrayList((Object[])new Entity[] { lllllllllllIllIIllllIIIlIIIIllII });
                    }
                    return Collections.emptyList();
                }
                else {
                    lllllllllllIllIIllllIIIlIIIIllll.addAll((Collection<? extends T>)filterResults(lllllllllllIllIIllllIIIlIIIlIlII, (Class<? extends Entity>)lllllllllllIllIIllllIIIlIIIIIlII, lllllllllllIllIIllllIIIlIIIIllIl, lllllllllllIllIIllllIIIlIIIlIIll, lllllllllllIllIIllllIIIlIIIIlllI, lllllllllllIllIIllllIIIlIIIlIIlI));
                }
            }
        }
        return getEntitiesFromPredicates(lllllllllllIllIIllllIIIlIIIIllll, lllllllllllIllIIllllIIIlIIIlIlII, lllllllllllIllIIllllIIIlIIIIIllI, lllllllllllIllIIllllIIIlIIIIIlII, lllllllllllIllIIllllIIIlIIIlIIll, lllllllllllIllIIllllIIIlIIIlIIIl);
    }
    
    private static String func_190826_c(final String lllllllllllIllIIllllIIIlIlIlIlIl) {
        EntitySelector.field_190830_d.add(lllllllllllIllIIllllIIIlIlIlIlIl);
        return lllllllllllIllIIllllIIIlIlIlIlIl;
    }
}
