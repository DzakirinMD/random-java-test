package softwarepattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 🎯 TL;DR
 * CDC Outbox ensures data changes are reliably sent to external systems
 * Orders are saved in DB first, then events go to the outbox
 * A background job processes and publishes the events (e.g., Kafka)
 * If publishing fails, the event stays in the outbox until retried
 */
// 1️⃣ Order Model (Represents an order in the database)
class Order {
    private String orderId;
    private String item;
    private double price;

    public Order(String orderId, String item, double price) {
        this.orderId = orderId;
        this.item = item;
        this.price = price;
    }

    public String getOrderId() { return orderId; }
    public String getItem() { return item; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Order{" + "orderId='" + orderId + "', item='" + item + "', price=" + price + "}";
    }
}

// 2️⃣ Outbox Table (Simulating an Outbox Table)
class OutboxTable {
    private List<String> events = new ArrayList<>();

    public void addEvent(String event) {
        events.add(event);
    }

    public List<String> getPendingEvents() {
        return new ArrayList<>(events);
    }

    public void removeEvent(String event) {
        events.remove(event);
    }
}

// 3️⃣ Order Service (Simulating Order Creation and CDC Outbox)
class OrderService {
    private OutboxTable outboxTable = new OutboxTable();

    public void placeOrder(String orderId, String item, double price) {
        // Simulate saving order to the database
        Order order = new Order(orderId, item, price);
        System.out.println("✅ Order saved to DB: " + order);

        // Write event to Outbox Table
        String event = "OrderCreated: " + order;
        outboxTable.addEvent(event);
        System.out.println("📦 Event saved to Outbox: " + event);
    }

    public OutboxTable getOutboxTable() {
        return outboxTable;
    }
}

// 4️⃣ Outbox Processor (Background Job that Publishes Events)
class OutboxProcessor {
    private OutboxTable outboxTable;

    public OutboxProcessor(OutboxTable outboxTable) {
        this.outboxTable = outboxTable;
    }

    public void startProcessing() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                List<String> events = outboxTable.getPendingEvents();
                for (String event : events) {
                    // Simulating event publishing to Kafka
                    System.out.println("📢 Publishing event: " + event);

                    // Simulate successful publishing
                    outboxTable.removeEvent(event);
                    System.out.println("✅ Event removed from Outbox");
                }
            }
        }, 0, 5000); // Runs every 5 seconds
    }
}

// 5️⃣ Main Class (Simulating the System)
public class CDCOutboxPatternExample {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        OutboxProcessor outboxProcessor = new OutboxProcessor(orderService.getOutboxTable());

        // Start processing outbox events
        outboxProcessor.startProcessing();

        // Simulating new orders
        orderService.placeOrder("001", "Burger", 9.99);
        orderService.placeOrder("002", "Pizza", 14.99);
    }
}
