package org.example;

public class Converter {
    private int sisaPoint;
    private String message;
    private String RVoucher;
    public Converter(){
    }

    public Converter(int sisaPoint,String message,String RVoucher){
        this.sisaPoint =sisaPoint;
        this.message = message;
        this.RVoucher = RVoucher;
    }

    public String getRedeemVoucher() {
        return RVoucher;
    }

    public void setRedeemVoucher(String RVoucher) {
        this.RVoucher = RVoucher;
    }

    public int getsisaPoint() {
        return sisaPoint;
    }

    public void setsisaPoint(int sisaPoint) {
        this.sisaPoint = sisaPoint;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Converter convert(int points){
        if(points >= 800){
            message = "Your points : "+points+"Your points can be redeem up-to voucher 100.000!";
            sisaPoint = points - 800;
            RVoucher = "100000";
        } else if (points >= 400) {
            message = "Your points : "+points+"Your points can be redeem up-to voucher 50.000!";
            sisaPoint = points - 400;
            RVoucher = "50000";
        } else if (points >= 200) {
            message = "Your points : "+points+"Your points can be redeem up-to voucher 25.000!";
            sisaPoint = points - 200;
            RVoucher = "25000";
        } else if (points >= 100) {
            message = "Your points : "+points+"Your points can be redeem up-to voucher 10.000!";
            sisaPoint = points - 100;
            RVoucher = "10000";
        } else {
            message = "Your point : "+points+"you cant redeem your voucher, because your points empty !";
            sisaPoint = points;
            RVoucher = "";
        }

        return new Converter(sisaPoint,message,RVoucher);
    }

}
