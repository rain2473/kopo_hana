package com.java14;

public class StrongBox<T> implements Comparable<T>{
    private T item;
    private KeyType keytype;
    private int count;

    public enum KeyType {
        PADLOCK("PADLOCK"), BUTTON("BUTTON"), DIAL("DIAL"), FINGER("FINGER");

        private final String type;
        private int limit;

        KeyType(String type) {
            this.type = type;
            switch (type) {
                case "PADLOCK": {
                    this.limit = 1_024;
                    break;
                }
                case "BUTTON": {
                    this.limit = 10_000;
                    break;
                }
                case "DIAL": {
                    this.limit = 30_000;
                    break;
                }
                case "FINGER": {
                    this.limit = 1_000_000;
                    break;
                }
                default: {
                    System.out.println("종류를 올바르게 입력해주세요!!");
                }
            }
        }

        public int getLimit() {
            return this.limit;
        }
        
        public String getType() {
            return this.type;
        }
    }

    public StrongBox(KeyType keytype) {
        this.keytype = keytype;
    }

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        count++;
        if (count < keytype.getLimit()) {
            return null;
        }
        return this.item;
    }

    @Override
    public String toString() {
        return this.keytype.getType();
    }

    @Override
    public int compareTo(T o) {
        return this.toString().compareToIgnoreCase(o.toString());
    }
}
