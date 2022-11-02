
import lombok.Data;

@Data
public class Order {
    private String baloonColor;
    private String baloonSize;
    private String clientName;
    private String clientAdress;
    private Long orderId;

    public Order(String baloonColor, String baloonSize, String clientName, String clientAdress, Long orderId) {
        this.baloonColor = baloonColor;
        this.baloonSize = baloonSize;
        this.clientName = clientName;
        this.clientAdress = clientAdress;
        this.orderId = orderId;
    }

    public Order(String baloonColor, String clientName, String clientAdress) {
        this.baloonColor = baloonColor;
        this.clientName = clientName;
        this.clientAdress = clientAdress;
        this.orderId = orderId;
    }

    public Order(String baloonColor,Long orderId) {
        this.baloonColor = baloonColor;
        this.orderId=orderId;
        this.clientAdress="";
        this.clientName="";
        this.baloonSize="";

    }
    public Order(String balloonColor) {
        this.baloonColor=balloonColor;
    }

    public String getBaloonColor() {
        return baloonColor;
    }

    public void setBaloonColor(String baloonColor) {
        this.baloonColor = baloonColor;
    }

    public String getBaloonSize() {
        return baloonSize;
    }

    public void setBaloonSize(String baloonSize) {
        this.baloonSize = baloonSize;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAdress() {
        return clientAdress;
    }

    public void setClientAdress(String clientAdress) {
        this.clientAdress = clientAdress;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
