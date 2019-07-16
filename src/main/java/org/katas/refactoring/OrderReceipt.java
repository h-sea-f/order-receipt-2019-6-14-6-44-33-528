package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String createItemsString() {
        StringBuilder itemsString = new StringBuilder();
        itemsString.append(order.getCustomerName());
        itemsString.append(order.getCustomerAddress());
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            itemsString.append(String.format("%s\t%s\t%s\t%s\n",lineItem.getDescription(),lineItem.getPrice(),lineItem.getQuantity(),lineItem.totalAmount()));
            double salesTax = lineItem.getTax();
            totSalesTx += salesTax;
            tot += lineItem.totalAmount() + salesTax;
        }
        itemsString.append("Sales Tax").append('\t').append(totSalesTx);
        itemsString.append("Total Amount").append('\t').append(tot);
        return itemsString.toString();
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output.append("======Printing Orders======\n");
        output.append(createItemsString());
        return output.toString();
    }
}