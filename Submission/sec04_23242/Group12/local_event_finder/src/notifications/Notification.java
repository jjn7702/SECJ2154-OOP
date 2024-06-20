package notifications;

public class Notification {
    private String notificationId;
    private String userId;
    private String message;
    private String date;

    public Notification(String notificationId, String userId, String message, String date) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
        this.date = date;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }
}
