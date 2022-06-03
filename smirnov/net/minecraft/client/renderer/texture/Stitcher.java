// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.texture;

import net.minecraft.client.renderer.StitcherException;
import java.util.Arrays;
import optifine.MathUtils;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;

public class Stitcher
{
    private final /* synthetic */ Set<Holder> setStitchHolders;
    private final /* synthetic */ List<Slot> stitchSlots;
    private /* synthetic */ int currentHeight;
    private /* synthetic */ int currentWidth;
    private final /* synthetic */ int mipmapLevelStitcher;
    private final /* synthetic */ int maxHeight;
    private final /* synthetic */ int maxWidth;
    private final /* synthetic */ int maxTileDimension;
    
    public Stitcher(final int llllllllllIlllIllIIIIIIlIlIIIIll, final int llllllllllIlllIllIIIIIIlIlIIIlll, final int llllllllllIlllIllIIIIIIlIlIIIIIl, final int llllllllllIlllIllIIIIIIlIlIIIIII) {
        this.setStitchHolders = (Set<Holder>)Sets.newHashSetWithExpectedSize(256);
        this.stitchSlots = (List<Slot>)Lists.newArrayListWithCapacity(256);
        this.mipmapLevelStitcher = llllllllllIlllIllIIIIIIlIlIIIIII;
        this.maxWidth = llllllllllIlllIllIIIIIIlIlIIIIll;
        this.maxHeight = llllllllllIlllIllIIIIIIlIlIIIlll;
        this.maxTileDimension = llllllllllIlllIllIIIIIIlIlIIIIIl;
    }
    
    private boolean expandAndAllocateSlot(final Holder llllllllllIlllIllIIIIIIIlllIIllI) {
        final int llllllllllIlllIllIIIIIIIlllIIlIl = Math.min(llllllllllIlllIllIIIIIIIlllIIllI.getWidth(), llllllllllIlllIllIIIIIIIlllIIllI.getHeight());
        final int llllllllllIlllIllIIIIIIIlllIIlII = Math.max(llllllllllIlllIllIIIIIIIlllIIllI.getWidth(), llllllllllIlllIllIIIIIIIlllIIllI.getHeight());
        final int llllllllllIlllIllIIIIIIIlllIIIll = MathHelper.smallestEncompassingPowerOfTwo(this.currentWidth);
        final int llllllllllIlllIllIIIIIIIlllIIIlI = MathHelper.smallestEncompassingPowerOfTwo(this.currentHeight);
        final int llllllllllIlllIllIIIIIIIlllIIIIl = MathHelper.smallestEncompassingPowerOfTwo(this.currentWidth + llllllllllIlllIllIIIIIIIlllIIlIl);
        final int llllllllllIlllIllIIIIIIIlllIIIII = MathHelper.smallestEncompassingPowerOfTwo(this.currentHeight + llllllllllIlllIllIIIIIIIlllIIlIl);
        final boolean llllllllllIlllIllIIIIIIIllIlllll = llllllllllIlllIllIIIIIIIlllIIIIl <= this.maxWidth;
        final boolean llllllllllIlllIllIIIIIIIllIllllI = llllllllllIlllIllIIIIIIIlllIIIII <= this.maxHeight;
        if (!llllllllllIlllIllIIIIIIIllIlllll && !llllllllllIlllIllIIIIIIIllIllllI) {
            return false;
        }
        final int llllllllllIlllIllIIIIIIIllIlllIl = MathUtils.roundDownToPowerOfTwo(this.currentHeight);
        boolean llllllllllIlllIllIIIIIIIllIlllII = llllllllllIlllIllIIIIIIIllIlllll && llllllllllIlllIllIIIIIIIlllIIIIl <= 2 * llllllllllIlllIllIIIIIIIllIlllIl;
        if (this.currentWidth == 0 && this.currentHeight == 0) {
            llllllllllIlllIllIIIIIIIllIlllII = true;
        }
        Slot llllllllllIlllIllIIIIIIIllIllIlI = null;
        if (llllllllllIlllIllIIIIIIIllIlllII) {
            if (llllllllllIlllIllIIIIIIIlllIIllI.getWidth() > llllllllllIlllIllIIIIIIIlllIIllI.getHeight()) {
                llllllllllIlllIllIIIIIIIlllIIllI.rotate();
            }
            if (this.currentHeight == 0) {
                this.currentHeight = llllllllllIlllIllIIIIIIIlllIIllI.getHeight();
            }
            final Slot llllllllllIlllIllIIIIIIIllIllIll = new Slot(this.currentWidth, 0, llllllllllIlllIllIIIIIIIlllIIllI.getWidth(), this.currentHeight);
            this.currentWidth += llllllllllIlllIllIIIIIIIlllIIllI.getWidth();
        }
        else {
            llllllllllIlllIllIIIIIIIllIllIlI = new Slot(0, this.currentHeight, this.currentWidth, llllllllllIlllIllIIIIIIIlllIIllI.getHeight());
            this.currentHeight += llllllllllIlllIllIIIIIIIlllIIllI.getHeight();
        }
        llllllllllIlllIllIIIIIIIllIllIlI.addSlot(llllllllllIlllIllIIIIIIIlllIIllI);
        this.stitchSlots.add(llllllllllIlllIllIIIIIIIllIllIlI);
        return true;
    }
    
    public int getCurrentWidth() {
        return this.currentWidth;
    }
    
    public void doStitch() {
        final Holder[] llllllllllIlllIllIIIIIIlIIlIlIII = this.setStitchHolders.toArray(new Holder[this.setStitchHolders.size()]);
        Arrays.sort(llllllllllIlllIllIIIIIIlIIlIlIII);
        final byte llllllllllIlllIllIIIIIIlIIlIIIII;
        final String llllllllllIlllIllIIIIIIlIIlIIIIl = (String)((Holder[])(Object)(llllllllllIlllIllIIIIIIlIIlIIIII = (byte)(Object)llllllllllIlllIllIIIIIIlIIlIlIII)).length;
        for (short llllllllllIlllIllIIIIIIlIIlIIIlI = 0; llllllllllIlllIllIIIIIIlIIlIIIlI < llllllllllIlllIllIIIIIIlIIlIIIIl; ++llllllllllIlllIllIIIIIIlIIlIIIlI) {
            final Holder llllllllllIlllIllIIIIIIlIIlIIlll = llllllllllIlllIllIIIIIIlIIlIIIII[llllllllllIlllIllIIIIIIlIIlIIIlI];
            if (!this.allocateSlot(llllllllllIlllIllIIIIIIlIIlIIlll)) {
                final String llllllllllIlllIllIIIIIIlIIlIIllI = String.format("Unable to fit: %s, size: %dx%d, atlas: %dx%d, atlasMax: %dx%d - Maybe try a lower resolution resourcepack?", llllllllllIlllIllIIIIIIlIIlIIlll.getAtlasSprite().getIconName(), llllllllllIlllIllIIIIIIlIIlIIlll.getAtlasSprite().getIconWidth(), llllllllllIlllIllIIIIIIlIIlIIlll.getAtlasSprite().getIconHeight(), this.currentWidth, this.currentHeight, this.maxWidth, this.maxHeight);
                throw new StitcherException(llllllllllIlllIllIIIIIIlIIlIIlll, llllllllllIlllIllIIIIIIlIIlIIllI);
            }
        }
        this.currentWidth = MathHelper.smallestEncompassingPowerOfTwo(this.currentWidth);
        this.currentHeight = MathHelper.smallestEncompassingPowerOfTwo(this.currentHeight);
    }
    
    private static int getMipmapDimension(final int llllllllllIlllIllIIIIIIlIIIIIlll, final int llllllllllIlllIllIIIIIIlIIIIIlII) {
        return (llllllllllIlllIllIIIIIIlIIIIIlll >> llllllllllIlllIllIIIIIIlIIIIIlII) + (((llllllllllIlllIllIIIIIIlIIIIIlll & (1 << llllllllllIlllIllIIIIIIlIIIIIlII) - 1) != 0x0) ? 1 : 0) << llllllllllIlllIllIIIIIIlIIIIIlII;
    }
    
    public int getCurrentHeight() {
        return this.currentHeight;
    }
    
    private boolean allocateSlot(final Holder llllllllllIlllIllIIIIIIIllllllIl) {
        final TextureAtlasSprite llllllllllIlllIllIIIIIIIllllllII = llllllllllIlllIllIIIIIIIllllllIl.getAtlasSprite();
        final boolean llllllllllIlllIllIIIIIIIlllllIll = llllllllllIlllIllIIIIIIIllllllII.getIconWidth() != llllllllllIlllIllIIIIIIIllllllII.getIconHeight();
        for (int llllllllllIlllIllIIIIIIIlllllIlI = 0; llllllllllIlllIllIIIIIIIlllllIlI < this.stitchSlots.size(); ++llllllllllIlllIllIIIIIIIlllllIlI) {
            if (this.stitchSlots.get(llllllllllIlllIllIIIIIIIlllllIlI).addSlot(llllllllllIlllIllIIIIIIIllllllIl)) {
                return true;
            }
            if (llllllllllIlllIllIIIIIIIlllllIll) {
                llllllllllIlllIllIIIIIIIllllllIl.rotate();
                if (this.stitchSlots.get(llllllllllIlllIllIIIIIIIlllllIlI).addSlot(llllllllllIlllIllIIIIIIIllllllIl)) {
                    return true;
                }
                llllllllllIlllIllIIIIIIIllllllIl.rotate();
            }
        }
        return this.expandAndAllocateSlot(llllllllllIlllIllIIIIIIIllllllIl);
    }
    
    public List<TextureAtlasSprite> getStichSlots() {
        final List<Slot> llllllllllIlllIllIIIIIIlIIIlIllI = (List<Slot>)Lists.newArrayList();
        for (final Slot llllllllllIlllIllIIIIIIlIIIlIlIl : this.stitchSlots) {
            llllllllllIlllIllIIIIIIlIIIlIlIl.getAllStitchSlots(llllllllllIlllIllIIIIIIlIIIlIllI);
        }
        final List<TextureAtlasSprite> llllllllllIlllIllIIIIIIlIIIlIlII = (List<TextureAtlasSprite>)Lists.newArrayList();
        for (final Slot llllllllllIlllIllIIIIIIlIIIlIIll : llllllllllIlllIllIIIIIIlIIIlIllI) {
            final Holder llllllllllIlllIllIIIIIIlIIIlIIlI = llllllllllIlllIllIIIIIIlIIIlIIll.getStitchHolder();
            final TextureAtlasSprite llllllllllIlllIllIIIIIIlIIIlIIIl = llllllllllIlllIllIIIIIIlIIIlIIlI.getAtlasSprite();
            llllllllllIlllIllIIIIIIlIIIlIIIl.initSprite(this.currentWidth, this.currentHeight, llllllllllIlllIllIIIIIIlIIIlIIll.getOriginX(), llllllllllIlllIllIIIIIIlIIIlIIll.getOriginY(), llllllllllIlllIllIIIIIIlIIIlIIlI.isRotated());
            llllllllllIlllIllIIIIIIlIIIlIlII.add(llllllllllIlllIllIIIIIIlIIIlIIIl);
        }
        return llllllllllIlllIllIIIIIIlIIIlIlII;
    }
    
    public void addSprite(final TextureAtlasSprite llllllllllIlllIllIIIIIIlIIllIlIl) {
        final Holder llllllllllIlllIllIIIIIIlIIllIlII = new Holder(llllllllllIlllIllIIIIIIlIIllIlIl, this.mipmapLevelStitcher);
        if (this.maxTileDimension > 0) {
            llllllllllIlllIllIIIIIIlIIllIlII.setNewDimension(this.maxTileDimension);
        }
        this.setStitchHolders.add(llllllllllIlllIllIIIIIIlIIllIlII);
    }
    
    public static class Slot
    {
        private final /* synthetic */ int originY;
        private final /* synthetic */ int originX;
        private final /* synthetic */ int height;
        private /* synthetic */ Holder holder;
        private final /* synthetic */ int width;
        private /* synthetic */ List<Slot> subSlots;
        
        public int getOriginX() {
            return this.originX;
        }
        
        public void getAllStitchSlots(final List<Slot> llllllllllllIlllIIlllIIIlIlIIIll) {
            if (this.holder != null) {
                llllllllllllIlllIIlllIIIlIlIIIll.add(this);
            }
            else if (this.subSlots != null) {
                for (final Slot llllllllllllIlllIIlllIIIlIlIIlIl : this.subSlots) {
                    llllllllllllIlllIIlllIIIlIlIIlIl.getAllStitchSlots(llllllllllllIlllIIlllIIIlIlIIIll);
                }
            }
        }
        
        public Holder getStitchHolder() {
            return this.holder;
        }
        
        public int getOriginY() {
            return this.originY;
        }
        
        public Slot(final int llllllllllllIlllIIlllIIIllIlIllI, final int llllllllllllIlllIIlllIIIllIlIIII, final int llllllllllllIlllIIlllIIIllIIllll, final int llllllllllllIlllIIlllIIIllIlIIll) {
            this.originX = llllllllllllIlllIIlllIIIllIlIllI;
            this.originY = llllllllllllIlllIIlllIIIllIlIIII;
            this.width = llllllllllllIlllIIlllIIIllIIllll;
            this.height = llllllllllllIlllIIlllIIIllIlIIll;
        }
        
        @Override
        public String toString() {
            return "Slot{originX=" + this.originX + ", originY=" + this.originY + ", width=" + this.width + ", height=" + this.height + ", texture=" + this.holder + ", subSlots=" + this.subSlots + '}';
        }
        
        public boolean addSlot(final Holder llllllllllllIlllIIlllIIIlIlllIll) {
            if (this.holder != null) {
                return false;
            }
            final int llllllllllllIlllIIlllIIIlIlllIlI = llllllllllllIlllIIlllIIIlIlllIll.getWidth();
            final int llllllllllllIlllIIlllIIIlIlllIIl = llllllllllllIlllIIlllIIIlIlllIll.getHeight();
            if (llllllllllllIlllIIlllIIIlIlllIlI > this.width || llllllllllllIlllIIlllIIIlIlllIIl > this.height) {
                return false;
            }
            if (llllllllllllIlllIIlllIIIlIlllIlI == this.width && llllllllllllIlllIIlllIIIlIlllIIl == this.height) {
                this.holder = llllllllllllIlllIIlllIIIlIlllIll;
                return true;
            }
            if (this.subSlots == null) {
                this.subSlots = (List<Slot>)Lists.newArrayListWithCapacity(1);
                this.subSlots.add(new Slot(this.originX, this.originY, llllllllllllIlllIIlllIIIlIlllIlI, llllllllllllIlllIIlllIIIlIlllIIl));
                final int llllllllllllIlllIIlllIIIlIlllIII = this.width - llllllllllllIlllIIlllIIIlIlllIlI;
                final int llllllllllllIlllIIlllIIIlIllIlll = this.height - llllllllllllIlllIIlllIIIlIlllIIl;
                if (llllllllllllIlllIIlllIIIlIllIlll > 0 && llllllllllllIlllIIlllIIIlIlllIII > 0) {
                    final int llllllllllllIlllIIlllIIIlIllIllI = Math.max(this.height, llllllllllllIlllIIlllIIIlIlllIII);
                    final int llllllllllllIlllIIlllIIIlIllIlIl = Math.max(this.width, llllllllllllIlllIIlllIIIlIllIlll);
                    if (llllllllllllIlllIIlllIIIlIllIllI >= llllllllllllIlllIIlllIIIlIllIlIl) {
                        this.subSlots.add(new Slot(this.originX, this.originY + llllllllllllIlllIIlllIIIlIlllIIl, llllllllllllIlllIIlllIIIlIlllIlI, llllllllllllIlllIIlllIIIlIllIlll));
                        this.subSlots.add(new Slot(this.originX + llllllllllllIlllIIlllIIIlIlllIlI, this.originY, llllllllllllIlllIIlllIIIlIlllIII, this.height));
                    }
                    else {
                        this.subSlots.add(new Slot(this.originX + llllllllllllIlllIIlllIIIlIlllIlI, this.originY, llllllllllllIlllIIlllIIIlIlllIII, llllllllllllIlllIIlllIIIlIlllIIl));
                        this.subSlots.add(new Slot(this.originX, this.originY + llllllllllllIlllIIlllIIIlIlllIIl, this.width, llllllllllllIlllIIlllIIIlIllIlll));
                    }
                }
                else if (llllllllllllIlllIIlllIIIlIlllIII == 0) {
                    this.subSlots.add(new Slot(this.originX, this.originY + llllllllllllIlllIIlllIIIlIlllIIl, llllllllllllIlllIIlllIIIlIlllIlI, llllllllllllIlllIIlllIIIlIllIlll));
                }
                else if (llllllllllllIlllIIlllIIIlIllIlll == 0) {
                    this.subSlots.add(new Slot(this.originX + llllllllllllIlllIIlllIIIlIlllIlI, this.originY, llllllllllllIlllIIlllIIIlIlllIII, llllllllllllIlllIIlllIIIlIlllIIl));
                }
            }
            for (final Slot llllllllllllIlllIIlllIIIlIllIlII : this.subSlots) {
                if (llllllllllllIlllIIlllIIIlIllIlII.addSlot(llllllllllllIlllIIlllIIIlIlllIll)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public static class Holder implements Comparable<Holder>
    {
        private final /* synthetic */ int mipmapLevelHolder;
        private /* synthetic */ float scaleFactor;
        private final /* synthetic */ int height;
        private /* synthetic */ boolean rotated;
        private final /* synthetic */ TextureAtlasSprite theTexture;
        private final /* synthetic */ int width;
        
        public boolean isRotated() {
            return this.rotated;
        }
        
        @Override
        public int compareTo(final Holder lllllllllllIIlIIllIlIllllIlIIllI) {
            int lllllllllllIIlIIllIlIllllIlIlIII = 0;
            if (this.getHeight() == lllllllllllIIlIIllIlIllllIlIIllI.getHeight()) {
                if (this.getWidth() == lllllllllllIIlIIllIlIllllIlIIllI.getWidth()) {
                    if (this.theTexture.getIconName() == null) {
                        return (lllllllllllIIlIIllIlIllllIlIIllI.theTexture.getIconName() == null) ? 0 : -1;
                    }
                    return this.theTexture.getIconName().compareTo(lllllllllllIIlIIllIlIllllIlIIllI.theTexture.getIconName());
                }
                else {
                    final int lllllllllllIIlIIllIlIllllIlIlIIl = (this.getWidth() < lllllllllllIIlIIllIlIllllIlIIllI.getWidth()) ? 1 : -1;
                }
            }
            else {
                lllllllllllIIlIIllIlIllllIlIlIII = ((this.getHeight() < lllllllllllIIlIIllIlIllllIlIIllI.getHeight()) ? 1 : -1);
            }
            return lllllllllllIIlIIllIlIllllIlIlIII;
        }
        
        public int getHeight() {
            final int lllllllllllIIlIIllIlIlllllIIIIII = this.rotated ? this.width : this.height;
            return getMipmapDimension((int)(lllllllllllIIlIIllIlIlllllIIIIII * this.scaleFactor), this.mipmapLevelHolder);
        }
        
        @Override
        public String toString() {
            return "Holder{width=" + this.width + ", height=" + this.height + ", name=" + this.theTexture.getIconName() + '}';
        }
        
        public TextureAtlasSprite getAtlasSprite() {
            return this.theTexture;
        }
        
        public void setNewDimension(final int lllllllllllIIlIIllIlIllllIllIIlI) {
            if (this.width > lllllllllllIIlIIllIlIllllIllIIlI && this.height > lllllllllllIIlIIllIlIllllIllIIlI) {
                this.scaleFactor = lllllllllllIIlIIllIlIllllIllIIlI / (float)Math.min(this.width, this.height);
            }
        }
        
        public Holder(final TextureAtlasSprite lllllllllllIIlIIllIlIlllllIIlllI, final int lllllllllllIIlIIllIlIlllllIlIIII) {
            this.scaleFactor = 1.0f;
            this.theTexture = lllllllllllIIlIIllIlIlllllIIlllI;
            this.width = lllllllllllIIlIIllIlIlllllIIlllI.getIconWidth();
            this.height = lllllllllllIIlIIllIlIlllllIIlllI.getIconHeight();
            this.mipmapLevelHolder = lllllllllllIIlIIllIlIlllllIlIIII;
            this.rotated = (getMipmapDimension(this.height, lllllllllllIIlIIllIlIlllllIlIIII) > getMipmapDimension(this.width, lllllllllllIIlIIllIlIlllllIlIIII));
        }
        
        public int getWidth() {
            final int lllllllllllIIlIIllIlIlllllIIIllI = this.rotated ? this.height : this.width;
            return getMipmapDimension((int)(lllllllllllIIlIIllIlIlllllIIIllI * this.scaleFactor), this.mipmapLevelHolder);
        }
        
        public void rotate() {
            this.rotated = !this.rotated;
        }
    }
}
