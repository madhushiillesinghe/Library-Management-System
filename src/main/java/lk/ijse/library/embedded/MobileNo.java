package lk.ijse.library.embedded;

import javax.persistence.Embeddable;

@Embeddable
public class MobileNo {
    private String mobileNo;
    private String type;

    public MobileNo(String mobileNo, String type) {
        this.mobileNo = mobileNo;
        this.type = type;
    }

    public MobileNo() {
    }


    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MobileNo{" +
                "mobileNo=" + mobileNo +
                ", type='" + type + '\'' +
                '}';
    }
}
