// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

import java.util.Collections;
import com.google.common.collect.Lists;
import java.util.List;

public class ThreadedFileIOBase implements Runnable
{
    private final /* synthetic */ List<IThreadedFileIO> threadedIOQueue;
    private volatile /* synthetic */ boolean isThreadWaiting;
    private volatile /* synthetic */ long savedIOCounter;
    private volatile /* synthetic */ long writeQueuedCounter;
    private static final /* synthetic */ ThreadedFileIOBase INSTANCE;
    
    private void processQueue() {
        for (int llllllllllllllIllllIlIllIllIllII = 0; llllllllllllllIllllIlIllIllIllII < this.threadedIOQueue.size(); ++llllllllllllllIllllIlIllIllIllII) {
            final IThreadedFileIO llllllllllllllIllllIlIllIllIlIll = this.threadedIOQueue.get(llllllllllllllIllllIlIllIllIllII);
            final boolean llllllllllllllIllllIlIllIllIlIlI = llllllllllllllIllllIlIllIllIlIll.writeNextIO();
            if (!llllllllllllllIllllIlIllIllIlIlI) {
                this.threadedIOQueue.remove(llllllllllllllIllllIlIllIllIllII--);
                ++this.savedIOCounter;
            }
            try {
                Thread.sleep(this.isThreadWaiting ? 0L : 10L);
            }
            catch (InterruptedException llllllllllllllIllllIlIllIllIlIIl) {
                llllllllllllllIllllIlIllIllIlIIl.printStackTrace();
            }
        }
        if (this.threadedIOQueue.isEmpty()) {
            try {
                Thread.sleep(25L);
            }
            catch (InterruptedException llllllllllllllIllllIlIllIllIlIII) {
                llllllllllllllIllllIlIllIllIlIII.printStackTrace();
            }
        }
    }
    
    public void waitForFinish() throws InterruptedException {
        this.isThreadWaiting = true;
        while (this.writeQueuedCounter != this.savedIOCounter) {
            Thread.sleep(10L);
        }
        this.isThreadWaiting = false;
    }
    
    public static ThreadedFileIOBase getThreadedIOInstance() {
        return ThreadedFileIOBase.INSTANCE;
    }
    
    public void queueIO(final IThreadedFileIO llllllllllllllIllllIlIllIlIlllll) {
        if (!this.threadedIOQueue.contains(llllllllllllllIllllIlIllIlIlllll)) {
            ++this.writeQueuedCounter;
            this.threadedIOQueue.add(llllllllllllllIllllIlIllIlIlllll);
        }
    }
    
    static {
        INSTANCE = new ThreadedFileIOBase();
    }
    
    @Override
    public void run() {
        while (true) {
            this.processQueue();
        }
    }
    
    private ThreadedFileIOBase() {
        this.threadedIOQueue = Collections.synchronizedList((List<IThreadedFileIO>)Lists.newArrayList());
        final Thread llllllllllllllIllllIlIllIllllIII = new Thread(this, "File IO Thread");
        llllllllllllllIllllIlIllIllllIII.setPriority(1);
        llllllllllllllIllllIlIllIllllIII.start();
    }
}
