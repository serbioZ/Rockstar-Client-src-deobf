// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import java.util.Random;
import net.minecraft.world.World;

public class StructureMineshaftStart extends StructureStart
{
    private /* synthetic */ MapGenMineshaft.Type mineShaftType;
    
    public StructureMineshaftStart() {
    }
    
    public StructureMineshaftStart(final World llllllllllllIIIlIllIIIIIIIIIlllI, final Random llllllllllllIIIlIllIIIIIIIIlIlll, final int llllllllllllIIIlIllIIIIIIIIIllII, final int llllllllllllIIIlIllIIIIIIIIIlIll, final MapGenMineshaft.Type llllllllllllIIIlIllIIIIIIIIlIlII) {
        super(llllllllllllIIIlIllIIIIIIIIIllII, llllllllllllIIIlIllIIIIIIIIIlIll);
        this.mineShaftType = llllllllllllIIIlIllIIIIIIIIlIlII;
        final StructureMineshaftPieces.Room llllllllllllIIIlIllIIIIIIIIlIIll = new StructureMineshaftPieces.Room(0, llllllllllllIIIlIllIIIIIIIIlIlll, (llllllllllllIIIlIllIIIIIIIIIllII << 4) + 2, (llllllllllllIIIlIllIIIIIIIIIlIll << 4) + 2, this.mineShaftType);
        this.components.add(llllllllllllIIIlIllIIIIIIIIlIIll);
        llllllllllllIIIlIllIIIIIIIIlIIll.buildComponent(llllllllllllIIIlIllIIIIIIIIlIIll, this.components, llllllllllllIIIlIllIIIIIIIIlIlll);
        this.updateBoundingBox();
        if (llllllllllllIIIlIllIIIIIIIIlIlII == MapGenMineshaft.Type.MESA) {
            final int llllllllllllIIIlIllIIIIIIIIlIIlI = -5;
            final int llllllllllllIIIlIllIIIIIIIIlIIIl = llllllllllllIIIlIllIIIIIIIIIlllI.getSeaLevel() - this.boundingBox.maxY + this.boundingBox.getYSize() / 2 + 5;
            this.boundingBox.offset(0, llllllllllllIIIlIllIIIIIIIIlIIIl, 0);
            for (final StructureComponent llllllllllllIIIlIllIIIIIIIIlIIII : this.components) {
                llllllllllllIIIlIllIIIIIIIIlIIII.offset(0, llllllllllllIIIlIllIIIIIIIIlIIIl, 0);
            }
        }
        else {
            this.markAvailableHeight(llllllllllllIIIlIllIIIIIIIIIlllI, llllllllllllIIIlIllIIIIIIIIlIlll, 10);
        }
    }
}
