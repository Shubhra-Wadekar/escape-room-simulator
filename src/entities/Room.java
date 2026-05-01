package entities;

import items.Item;
import interactables.Unlockable;
import puzzles.Puzzle;
import java.util.ArrayList;
import java.util.List;
public class Room {
    private String name;
    private String description;
    private List<Item> items;
    private List<Unlockable> unlockables;
    private List<Puzzle> puzzles;
    private boolean doorVisible;
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.unlockables = new ArrayList<>();
        this.puzzles = new ArrayList<>();
        this.doorVisible = false;
    }
    public String getName() {
        return name;
    }
    public void addItem(Item item) {
        items.add(item);
    }
    public Item takeItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }
    public void addUnlockable(Unlockable u) {
        unlockables.add(u);
    }
    public Unlockable getUnlockable(String name) {
        for (Unlockable u : unlockables) {
            if (u.getUnlockableName().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }
    public void addPuzzle(Puzzle p) {
        puzzles.add(p);
    }
    public Puzzle getPuzzle(String name) {
        for (Puzzle p : puzzles) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
    public void setDoorVisible(boolean visible) {
        this.doorVisible = visible;
    }
    public boolean isDoorVisible() {
        return doorVisible;
    }
    public void describe() {
        System.out.println("\n=== " + name + " ===");
        System.out.println(description);
        if (!items.isEmpty()) {
            System.out.println("\nYou see:");
            for (Item item : items) {
                System.out.println(" - " + item.getName());
            }
        }
        for (Unlockable u : unlockables) {
            System.out.println(" - " + u.getUnlockableName() + (u.isLocked() ? " (locked)" : " (unlocked)"));
        }
        for (Puzzle p : puzzles) {
            if (!p.isSolved()) {
                System.out.println(" - " + p.getName() + " (unsolved)");
            }
        }
        if (doorVisible) {
            System.out.println(" - Exit Door");
        }
    }
}