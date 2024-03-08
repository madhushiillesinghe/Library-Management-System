package lk.ijse.library.embedded;

import javax.persistence.Embeddable;

@Embeddable
public class MobileNo {
    private int mobileNo;
    private int homeMobile;

    public MobileNo(int mobileNo, int homeMobile) {
        this.mobileNo = mobileNo;
        this.homeMobile = homeMobile;
    }

    public MobileNo() {
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getHomeMobile() {
        return homeMobile;
    }

    public void setHomeMobile(int homeMobile) {
        this.homeMobile = homeMobile;
    }

    @Override
    public String toString() {
        return "MobileNo{" +
                "mobileNo=" + mobileNo +
                ", homeMobile=" + homeMobile +
                '}';
    }
}
