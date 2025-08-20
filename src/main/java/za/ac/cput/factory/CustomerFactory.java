
package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {

    public static Customer createCustomer(String firstName, String lastName, String carModel, int carWashCount, boolean freeWashActivated, boolean freeBirthdayWash,
            String bankName, long bankAccountNumber, long identificationNumber, long cellPhone, String email, String notificationPreference,
            String password, Address address) {

        if (Helper.isNullOrEmpty(firstName)||Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(carModel) || Helper.isNullOrEmpty(email) ) {
            return null;
        }

        if (!Helper.isValidBankAccount(bankAccountNumber)){
            return null;
        }

        if (!Helper.isValidEmail(email)){
            return null;
        }

        
        return new Customer.Builder()
                .setRatingId(Long.valueOf(System.currentTimeMillis()))
                .setFirstName(firstName)
                .setLastName(lastName)
                .setCarModel(carModel)
                .setCarWashCount(carWashCount)
                .setFreeWashActivated(freeWashActivated)
                .setFreeBirthdayWash(freeBirthdayWash)
                .setBankName(bankName)
                .setBankAccountNumber(bankAccountNumber)
                .setIdentificationNumber(identificationNumber)
                .setCellPhone(cellPhone)
                .setEmail(email)
                .setNotificationPreference(notificationPreference)
                .setPassword(password)
                .setAddress(address)
                .setCustomerId(System.currentTimeMillis())
                .build();
    }
}

