package com.sensiblemetrics.api.alpenidos.pattern.iterator3.model;

import com.sensiblemetrics.api.alpenidos.pattern.iterator3.iface.MyCollection;
import com.sensiblemetrics.api.alpenidos.pattern.iterator3.iface.MyIterator;

public class NewCollection implements MyCollection {
    private Object[] obj = {"dog", "pig", "cat", "monkey", "pig"};

    public MyIterator createIterator() {
        return new NewIterator();
    }

    private class NewIterator implements MyIterator {
        private int currentIndex = 0;

        public void first() {
            this.currentIndex = 0;
        }

        public void next() {
            if (this.currentIndex < obj.length) {
                this.currentIndex++;
            }
        }

        public void previous() {
            if (this.currentIndex > 0) {
                this.currentIndex--;
            }
        }

        public boolean isLast() {
            return this.currentIndex == obj.length;
        }

        public boolean isFirst() {
            return this.currentIndex == 0;
        }

        public Object currentItem() {
            return obj[this.currentIndex];
        }
    }
}
