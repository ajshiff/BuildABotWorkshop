package com.jakefoundation.buildabotworkshop.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<BotItem> ITEMS = new ArrayList<BotItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, BotItem> ITEM_MAP = new HashMap<String, BotItem>();

    private static final int COUNT = 4;

    static {
        // Add some sample items.
        addItem(createDummyItem(1, "Aaron Bot"));
        addItem(createDummyItem(2, "Daniel Bot"));
        addItem(createDummyItem(3, "Mike Bot"));
        addItem(createDummyItem(4, "Pam Bot"));
    }

    private static void addItem(BotItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static BotItem createDummyItem(int position, String name) {
        return new BotItem(String.valueOf(position), name, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class BotItem {
        public final String id;
        public final String content;
        public final String details;

        public BotItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}