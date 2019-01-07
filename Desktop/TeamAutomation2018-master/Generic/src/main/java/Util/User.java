package Util;

public class User {
    String item_name;
//    String stID;
//    String stDOB;

    public User(){}
    public User(String item_name){
        this.item_name = item_name;
       // this.stID = stID;
    }
//    public User(String stName, String stID, String stDOB){
//        this.stName = stName;
//        this.stID = stID;
//        this.stDOB = stDOB;
//
//    }
    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

//    public String getStID() {
//        return stID;
//    }
//
//    public void setStID(String stID) {
//        this.stID = stID;
//    }
//
//    public String getStDOB() {
//        return stDOB;
//    }
//
//    public void setStDOB(String stDOB) {
//        this.stDOB = stDOB;
//    }
}
