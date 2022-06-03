// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import net.minecraft.entity.Entity;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.MoveEvent;
import net.minecraft.client.renderer.Vector3d;
import ru.rockstar.client.features.Feature;

public class SafeWalk extends Feature
{
    private /* synthetic */ Vector3d vec;
    
    @EventTarget
    public void event(final MoveEvent llllllllllIlllIIIlIlIlIIIIIlllII) {
        double llllllllllIlllIIIlIlIlIIIIlIIIII = llllllllllIlllIIIlIlIlIIIIIlllII.getX();
        double llllllllllIlllIIIlIlIlIIIIIlllll = llllllllllIlllIIIlIlIlIIIIIlllII.getZ();
        if (SafeWalk.mc.player.onGround) {
            final double llllllllllIlllIIIlIlIlIIIIIllllI = 0.05;
            while (llllllllllIlllIIIlIlIlIIIIlIIIII != 0.0) {
                if (!this.isOffsetBBEmpty(llllllllllIlllIIIlIlIlIIIIlIIIII, -1.0, 0.0)) {
                    break;
                }
                if (llllllllllIlllIIIlIlIlIIIIlIIIII < llllllllllIlllIIIlIlIlIIIIIllllI && llllllllllIlllIIIlIlIlIIIIlIIIII >= -llllllllllIlllIIIlIlIlIIIIIllllI) {
                    llllllllllIlllIIIlIlIlIIIIlIIIII = 0.0;
                }
                else if (llllllllllIlllIIIlIlIlIIIIlIIIII > 0.0) {
                    llllllllllIlllIIIlIlIlIIIIlIIIII -= llllllllllIlllIIIlIlIlIIIIIllllI;
                }
                else {
                    llllllllllIlllIIIlIlIlIIIIlIIIII += llllllllllIlllIIIlIlIlIIIIIllllI;
                }
            }
            while (llllllllllIlllIIIlIlIlIIIIIlllll != 0.0) {
                if (!this.isOffsetBBEmpty(0.0, -1.0, llllllllllIlllIIIlIlIlIIIIIlllll)) {
                    break;
                }
                if (llllllllllIlllIIIlIlIlIIIIIlllll < llllllllllIlllIIIlIlIlIIIIIllllI && llllllllllIlllIIIlIlIlIIIIIlllll >= -llllllllllIlllIIIlIlIlIIIIIllllI) {
                    llllllllllIlllIIIlIlIlIIIIIlllll = 0.0;
                }
                else if (llllllllllIlllIIIlIlIlIIIIIlllll > 0.0) {
                    llllllllllIlllIIIlIlIlIIIIIlllll -= llllllllllIlllIIIlIlIlIIIIIllllI;
                }
                else {
                    llllllllllIlllIIIlIlIlIIIIIlllll += llllllllllIlllIIIlIlIlIIIIIllllI;
                }
            }
            while (llllllllllIlllIIIlIlIlIIIIlIIIII != 0.0 && llllllllllIlllIIIlIlIlIIIIIlllll != 0.0 && this.isOffsetBBEmpty(llllllllllIlllIIIlIlIlIIIIlIIIII, -1.0, llllllllllIlllIIIlIlIlIIIIIlllll)) {
                if (llllllllllIlllIIIlIlIlIIIIlIIIII < llllllllllIlllIIIlIlIlIIIIIllllI && llllllllllIlllIIIlIlIlIIIIlIIIII >= -llllllllllIlllIIIlIlIlIIIIIllllI) {
                    llllllllllIlllIIIlIlIlIIIIlIIIII = 0.0;
                }
                else if (llllllllllIlllIIIlIlIlIIIIlIIIII > 0.0) {
                    llllllllllIlllIIIlIlIlIIIIlIIIII -= llllllllllIlllIIIlIlIlIIIIIllllI;
                }
                else {
                    llllllllllIlllIIIlIlIlIIIIlIIIII += llllllllllIlllIIIlIlIlIIIIIllllI;
                }
                if (llllllllllIlllIIIlIlIlIIIIIlllll < llllllllllIlllIIIlIlIlIIIIIllllI && llllllllllIlllIIIlIlIlIIIIIlllll >= -llllllllllIlllIIIlIlIlIIIIIllllI) {
                    llllllllllIlllIIIlIlIlIIIIIlllll = 0.0;
                }
                else if (llllllllllIlllIIIlIlIlIIIIIlllll > 0.0) {
                    llllllllllIlllIIIlIlIlIIIIIlllll -= llllllllllIlllIIIlIlIlIIIIIllllI;
                }
                else {
                    llllllllllIlllIIIlIlIlIIIIIlllll += llllllllllIlllIIIlIlIlIIIIIllllI;
                }
            }
        }
    }
    
    public SafeWalk() {
        super("SafeWalk", "\u041d\u0435 \u0434\u0430\u0451\u0442 \u0432\u0430\u043c \u0443\u043f\u0430\u0441\u0442\u044c \u0441 \u043a\u0440\u0430\u044f \u0431\u043b\u043e\u043a\u0430", 0, Category.PLAYER);
        this.vec = new Vector3d();
    }
    
    public boolean isOffsetBBEmpty(final double llllllllllIlllIIIlIlIlIIIIIlIIll, final double llllllllllIlllIIIlIlIlIIIIIIlllI, final double llllllllllIlllIIIlIlIlIIIIIlIIIl) {
        this.vec.x = llllllllllIlllIIIlIlIlIIIIIlIIll;
        this.vec.y = llllllllllIlllIIIlIlIlIIIIIIlllI;
        this.vec.z = llllllllllIlllIIIlIlIlIIIIIlIIIl;
        return SafeWalk.mc.world.getCollisionBoxes(SafeWalk.mc.player, SafeWalk.mc.player.getEntityBoundingBox().offset(this.vec.x, this.vec.y, this.vec.z)).isEmpty();
    }
}
