package com.example.CTGTDL.dependencyInjection;

public class Cart {
    private IDatabase iDatabase;
    private ILogger iLogger;
    private IEmailSender emailSender;

    public Cart(IDatabase iDatabase, ILogger iLogger, IEmailSender emailSender) {
        this.iDatabase = iDatabase;
        this.iLogger = iLogger;
        this.emailSender = emailSender;
    }
    public void Checkout (int orderId, String info, int userId) {
            iDatabase.Save(orderId );
            iLogger.LogInfo("Info order has been checkout");
            emailSender.SendEmail(userId);
    }
}
