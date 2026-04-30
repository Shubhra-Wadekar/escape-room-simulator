package escape.entities;

public interface Unlockable {
    boolean isLocked();
    boolean tryUnlock(String idemID);
}

