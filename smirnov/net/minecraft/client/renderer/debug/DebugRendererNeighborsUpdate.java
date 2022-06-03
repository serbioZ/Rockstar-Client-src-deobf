// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.debug;

import java.util.Comparator;
import com.google.common.collect.Ordering;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.math.AxisAlignedBB;
import com.google.common.collect.Sets;
import net.minecraft.client.renderer.GlStateManager;
import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import java.util.Map;

public class DebugRendererNeighborsUpdate implements DebugRenderer.IDebugRenderer
{
    private final /* synthetic */ Map<Long, Map<BlockPos, Integer>> field_191555_b;
    private final /* synthetic */ Minecraft field_191554_a;
    
    public void func_191553_a(final long llllllllllllIllIIlIIlIlIIIlIlIII, final BlockPos llllllllllllIllIIlIIlIlIIIlIIlll) {
        Map<BlockPos, Integer> llllllllllllIllIIlIIlIlIIIlIIllI = this.field_191555_b.get(llllllllllllIllIIlIIlIlIIIlIlIII);
        if (llllllllllllIllIIlIIlIlIIIlIIllI == null) {
            llllllllllllIllIIlIIlIlIIIlIIllI = (Map<BlockPos, Integer>)Maps.newHashMap();
            this.field_191555_b.put(llllllllllllIllIIlIIlIlIIIlIlIII, llllllllllllIllIIlIIlIlIIIlIIllI);
        }
        Integer llllllllllllIllIIlIIlIlIIIlIIlIl = llllllllllllIllIIlIIlIlIIIlIIllI.get(llllllllllllIllIIlIIlIlIIIlIIlll);
        if (llllllllllllIllIIlIIlIlIIIlIIlIl == null) {
            llllllllllllIllIIlIIlIlIIIlIIlIl = 0;
        }
        llllllllllllIllIIlIIlIlIIIlIIllI.put(llllllllllllIllIIlIIlIlIIIlIIlll, llllllllllllIllIIlIIlIlIIIlIIlIl + 1);
    }
    
    @Override
    public void render(final float llllllllllllIllIIlIIlIlIIIIIlIIl, final long llllllllllllIllIIlIIlIlIIIIIlIII) {
        final long llllllllllllIllIIlIIlIlIIIIIIlll = this.field_191554_a.world.getTotalWorldTime();
        final EntityPlayer llllllllllllIllIIlIIlIlIIIIIIllI = this.field_191554_a.player;
        final double llllllllllllIllIIlIIlIlIIIIIIlIl = llllllllllllIllIIlIIlIlIIIIIIllI.lastTickPosX + (llllllllllllIllIIlIIlIlIIIIIIllI.posX - llllllllllllIllIIlIIlIlIIIIIIllI.lastTickPosX) * llllllllllllIllIIlIIlIlIIIIIlIIl;
        final double llllllllllllIllIIlIIlIlIIIIIIlII = llllllllllllIllIIlIIlIlIIIIIIllI.lastTickPosY + (llllllllllllIllIIlIIlIlIIIIIIllI.posY - llllllllllllIllIIlIIlIlIIIIIIllI.lastTickPosY) * llllllllllllIllIIlIIlIlIIIIIlIIl;
        final double llllllllllllIllIIlIIlIlIIIIIIIll = llllllllllllIllIIlIIlIlIIIIIIllI.lastTickPosZ + (llllllllllllIllIIlIIlIlIIIIIIllI.posZ - llllllllllllIllIIlIIlIlIIIIIIllI.lastTickPosZ) * llllllllllllIllIIlIIlIlIIIIIlIIl;
        final World llllllllllllIllIIlIIlIlIIIIIIIlI = this.field_191554_a.player.world;
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth(2.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);
        final int llllllllllllIllIIlIIlIlIIIIIIIIl = 200;
        final double llllllllllllIllIIlIIlIlIIIIIIIII = 0.0025;
        final Set<BlockPos> llllllllllllIllIIlIIlIIlllllllll = (Set<BlockPos>)Sets.newHashSet();
        final Map<BlockPos, Integer> llllllllllllIllIIlIIlIIllllllllI = (Map<BlockPos, Integer>)Maps.newHashMap();
        final Iterator<Map.Entry<Long, Map<BlockPos, Integer>>> llllllllllllIllIIlIIlIIlllllllIl = this.field_191555_b.entrySet().iterator();
        while (llllllllllllIllIIlIIlIIlllllllIl.hasNext()) {
            final Map.Entry<Long, Map<BlockPos, Integer>> llllllllllllIllIIlIIlIIlllllllII = llllllllllllIllIIlIIlIIlllllllIl.next();
            final Long llllllllllllIllIIlIIlIIllllllIll = llllllllllllIllIIlIIlIIlllllllII.getKey();
            final Map<BlockPos, Integer> llllllllllllIllIIlIIlIIllllllIlI = llllllllllllIllIIlIIlIIlllllllII.getValue();
            final long llllllllllllIllIIlIIlIIllllllIIl = llllllllllllIllIIlIIlIlIIIIIIlll - llllllllllllIllIIlIIlIIllllllIll;
            if (llllllllllllIllIIlIIlIIllllllIIl > 200L) {
                llllllllllllIllIIlIIlIIlllllllIl.remove();
            }
            else {
                for (final Map.Entry<BlockPos, Integer> llllllllllllIllIIlIIlIIllllllIII : llllllllllllIllIIlIIlIIllllllIlI.entrySet()) {
                    final BlockPos llllllllllllIllIIlIIlIIlllllIlll = llllllllllllIllIIlIIlIIllllllIII.getKey();
                    final Integer llllllllllllIllIIlIIlIIlllllIllI = llllllllllllIllIIlIIlIIllllllIII.getValue();
                    if (llllllllllllIllIIlIIlIIlllllllll.add(llllllllllllIllIIlIIlIIlllllIlll)) {
                        RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(BlockPos.ORIGIN).expandXyz(0.002).contract(0.0025 * llllllllllllIllIIlIIlIIllllllIIl).offset(llllllllllllIllIIlIIlIIlllllIlll.getX(), llllllllllllIllIIlIIlIIlllllIlll.getY(), llllllllllllIllIIlIIlIIlllllIlll.getZ()).offset(-llllllllllllIllIIlIIlIlIIIIIIlIl, -llllllllllllIllIIlIIlIlIIIIIIlII, -llllllllllllIllIIlIIlIlIIIIIIIll), 1.0f, 1.0f, 1.0f, 1.0f);
                        llllllllllllIllIIlIIlIIllllllllI.put(llllllllllllIllIIlIIlIIlllllIlll, llllllllllllIllIIlIIlIIlllllIllI);
                    }
                }
            }
        }
        for (final Map.Entry<BlockPos, Integer> llllllllllllIllIIlIIlIIlllllIlIl : llllllllllllIllIIlIIlIIllllllllI.entrySet()) {
            final BlockPos llllllllllllIllIIlIIlIIlllllIlII = llllllllllllIllIIlIIlIIlllllIlIl.getKey();
            final Integer llllllllllllIllIIlIIlIIlllllIIll = llllllllllllIllIIlIIlIIlllllIlIl.getValue();
            DebugRenderer.func_191556_a(String.valueOf(llllllllllllIllIIlIIlIIlllllIIll), llllllllllllIllIIlIIlIIlllllIlII.getX(), llllllllllllIllIIlIIlIIlllllIlII.getY(), llllllllllllIllIIlIIlIIlllllIlII.getZ(), llllllllllllIllIIlIIlIlIIIIIlIIl, -1);
        }
        GlStateManager.depthMask(true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    DebugRendererNeighborsUpdate(final Minecraft llllllllllllIllIIlIIlIlIIIlIllll) {
        this.field_191555_b = (Map<Long, Map<BlockPos, Integer>>)Maps.newTreeMap((Comparator)Ordering.natural().reverse());
        this.field_191554_a = llllllllllllIllIIlIIlIlIIIlIllll;
    }
}
