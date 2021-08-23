package jeet.code.design;

import java.util.ArrayList;
import java.util.List;

public class LHashMap {

    private List<Integer> key = new ArrayList<>();
    private List<Integer> value = new ArrayList<>();

    public LHashMap() {};

    /** value will always be non-negative. */
    public void put(int key, int value) {
        for(int i=0;i<this.key.size();i++) {
            if (key == this.key.get(i)) {
                this.value.set(i, value);
                return;
            }
        }
        this.key.add(key);
        this.value.add(value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for(int i=0;i<this.key.size();i++) {
            if (key == this.key.get(i)) {
                return this.value.get(i);
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        for(int i=0;i<this.key.size();i++) {
            if (key == this.key.get(i)) {
                this.value.set(i, -1);
            }
        }
    }
}
