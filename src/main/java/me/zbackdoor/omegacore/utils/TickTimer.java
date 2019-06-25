package me.zbackdoor.omegacore.utils;

public final class TickTimer {
    private long time;

    public TickTimer() {
        this.time = (System.currentTimeMillis() / 1000L);
    }

    public boolean hasTimeElapsed(long time, boolean reset) {
        if (getTime() >= time) {
            if (reset) {
                reset();
            }
            return true;
        }
        return false;
    }

    private long getTime() {
        return System.currentTimeMillis() / 1000L - this.time;
    }

    private void reset() {
        this.time = (System.currentTimeMillis() / 1000L);
    }
}