package za.ac.cput.util;

import java.util.UUID;

public class Helper {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
    public static String generatedAdminManagerId() {
        return UUID.randomUUID().toString();
    }
    public static boolean isValidIdentificationNumber(long identificationNumber) {
        String idStr = String.valueOf(identificationNumber);
        return idStr.length() == 13;
    }

    public static boolean isValidEmail(String email) {
        if (isNullOrEmpty(email)) {
            return false;
        }
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailRegex);
    }
    public static boolean isValidCellPhone(long cellPhone) {
        String phone = String.valueOf(cellPhone);
        return phone.matches("^(27|0)[0-9]{8,9}$");
    }

    public static boolean isPriceDurationValid(double price){
        if(price <= 0){
            return false;
        }
        return  true;
    }

    public static boolean isValidBankAccount(long accountNumber) {
        return String.valueOf(accountNumber).length() >= 8;
    }

}
