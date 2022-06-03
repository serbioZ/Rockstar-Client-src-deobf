// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources.data;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.List;

public class AnimationMetadataSection implements IMetadataSection
{
    private final /* synthetic */ List<AnimationFrame> animationFrames;
    private final /* synthetic */ boolean interpolate;
    private final /* synthetic */ int frameWidth;
    private final /* synthetic */ int frameTime;
    private final /* synthetic */ int frameHeight;
    
    public boolean isInterpolate() {
        return this.interpolate;
    }
    
    public int getFrameTime() {
        return this.frameTime;
    }
    
    public int getFrameTimeSingle(final int lllllllllllIIIlIIIIlIllllIllIIII) {
        final AnimationFrame lllllllllllIIIlIIIIlIllllIllIIlI = this.getAnimationFrame(lllllllllllIIIlIIIIlIllllIllIIII);
        return lllllllllllIIIlIIIIlIllllIllIIlI.hasNoTime() ? this.frameTime : lllllllllllIIIlIIIIlIllllIllIIlI.getFrameTime();
    }
    
    public int getFrameHeight() {
        return this.frameHeight;
    }
    
    private AnimationFrame getAnimationFrame(final int lllllllllllIIIlIIIIlIllllIlllIII) {
        return this.animationFrames.get(lllllllllllIIIlIIIIlIllllIlllIII);
    }
    
    public AnimationMetadataSection(final List<AnimationFrame> lllllllllllIIIlIIIIlIlllllIlIIIl, final int lllllllllllIIIlIIIIlIlllllIlIIII, final int lllllllllllIIIlIIIIlIlllllIIllll, final int lllllllllllIIIlIIIIlIlllllIIlllI, final boolean lllllllllllIIIlIIIIlIlllllIlIIll) {
        this.animationFrames = lllllllllllIIIlIIIIlIlllllIlIIIl;
        this.frameWidth = lllllllllllIIIlIIIIlIlllllIlIIII;
        this.frameHeight = lllllllllllIIIlIIIIlIlllllIIllll;
        this.frameTime = lllllllllllIIIlIIIIlIlllllIIlllI;
        this.interpolate = lllllllllllIIIlIIIIlIlllllIlIIll;
    }
    
    public int getFrameWidth() {
        return this.frameWidth;
    }
    
    public int getFrameIndex(final int lllllllllllIIIlIIIIlIllllIlIIIll) {
        return this.animationFrames.get(lllllllllllIIIlIIIIlIllllIlIIIll).getFrameIndex();
    }
    
    public Set<Integer> getFrameIndexSet() {
        final Set<Integer> lllllllllllIIIlIIIIlIllllIIlllIl = (Set<Integer>)Sets.newHashSet();
        for (final AnimationFrame lllllllllllIIIlIIIIlIllllIIlllII : this.animationFrames) {
            lllllllllllIIIlIIIIlIllllIIlllIl.add(lllllllllllIIIlIIIIlIllllIIlllII.getFrameIndex());
        }
        return lllllllllllIIIlIIIIlIllllIIlllIl;
    }
    
    public boolean frameHasTime(final int lllllllllllIIIlIIIIlIllllIlIlIIl) {
        return !this.animationFrames.get(lllllllllllIIIlIIIIlIllllIlIlIIl).hasNoTime();
    }
    
    public int getFrameCount() {
        return this.animationFrames.size();
    }
}
