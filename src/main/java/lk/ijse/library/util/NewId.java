package lk.ijse.library.util;

import java.util.ArrayList;

public class NewId {
    public static String newId(ArrayList<String> list, GetType getType) {
        String lastId = null;
        for (int i = 0; i < list.size(); i++) {
            lastId = list.get(i);
        }

        switch (getType) {
            case CUSTOMER:
                try {
                    System.out.println(lastId+" last id");
                    String[] split = lastId.split("C-0");
                    int idNum = Integer.parseInt(split[1]);
                    idNum++;
                    System.out.println(idNum +"  id num");
                    return "C-0" + idNum;
                } catch (Exception e) {
                    return "C-01";
                }

            case SUPPLIER:
                try {
                    String[] split = lastId.split("S-0");
                    int idNum = Integer.parseInt(split[1]);
                    idNum++;
                    return "S-0" + idNum;
                } catch (Exception e) {
                    return "S-01";
                }

            case EMPLOYEE:
                try {
                    String[] split = lastId.split("E-0");
                    int idNum = Integer.parseInt(split[1]);
                    idNum++;
                    return "E-0" + idNum;
                } catch (Exception e) {
                    return "E-01";
                }

            case PRODUCT:
                try {
                    String[] split = lastId.split("P-0");
                    int idNum = Integer.parseInt(split[1]);
                    idNum++;
                    return "P-0" + idNum;
                } catch (Exception e) {
                    return "P-01";
                }

            case MACHINE:
                try {
                    String[] split = lastId.split("M-0");
                    int idNum = Integer.parseInt(split[1]);
                    idNum++;
                    return "M-0" + idNum;
                } catch (Exception e) {
                    return "M-01";
                }

            case SUPPLYORDERID:
                try {
                    String[] split = lastId.split("SO-0");
                    int idNum = Integer.parseInt(split[1]);
                    idNum++;
                    return "SO-0" + idNum;
                } catch (Exception e) {
                    return "SO-01";
                }
            case CUSTOMERORDERID:
                try {
                    String[] split = lastId.split("CO-0");
                    int idNum = Integer.parseInt(split[1]);
                    idNum++;
                    return "CO-0" + idNum;
                } catch (Exception e) {
                    return "CO-01";
                }

            case CUSTOMERRENTID:
                try {
                    String[] split = lastId.split("R-0");
                    int idNum = Integer.parseInt(split[1]);
                    idNum++;
                    return "R-0" + idNum;
                } catch (Exception e) {
                    return "R-01";
                }


            default:
                return null;
        }


    }

    public enum GetType {
        EMPLOYEE, SUPPLIER, CUSTOMER, PRODUCT,MACHINE,SUPPLYORDERID,CUSTOMERORDERID,CUSTOMERRENTID
    }
}
