package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Customer extends User{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private Long customerId;
    private String carModel;
    private int carWashCount;
    private boolean freeWashActivated;
    private boolean freeBirthdayWash;
    private String bankName;
    private long bankAccountNumber;
    private Long ratingId;

    @ManyToOne
    @JoinColumn(name = "address_street_number")
    private Address address;

    public Customer() {

    }

    private Customer(Builder builder){
        this.ratingId = builder.ratingId;
        this.address = builder.address;
        this.carModel = builder.carModel;
        this.carWashCount = builder.carWashCount;
        this.freeWashActivated = builder.freeWashActivated;
        this.freeBirthdayWash = builder.freeBirthdayWash;
        this.bankName = builder.bankName;
        this.bankAccountNumber = builder.bankAccountNumber;
        this.cellPhone = builder.cellPhone;
        this.email = builder.email;
        this.password = builder.password;
        this.customerId = builder.customerId;
        this.notificationPreference = builder.notificationPreference;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.identificationNumber = builder.identificationNumber;


    }

    public String getCarModel() {
        return carModel;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public int getCarWashCount() {
        return carWashCount;
    }

    public boolean isFreeWashActivated() {
        return freeWashActivated;
    }

    public boolean isFreeBirthdayWash() {
        return freeBirthdayWash;
    }

    public String getBankName() {
        return bankName;
    }

    public long getBankAccountNumber() {
        return bankAccountNumber;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carWashCount=" + carWashCount +
                ", freeWashActivated=" + freeWashActivated +
                ", freewBirthdayWash=" + freeBirthdayWash +
                ", bankName='" + bankName + '\'' +
                ", bankAccountNumber=" + bankAccountNumber +
                ", ratingId='" + ratingId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", identificationNumber=" + identificationNumber +
                ", lastName='" + lastName + '\'' +
                ", cellPhone=" + cellPhone +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", notificationPreference='" + notificationPreference + '\'' +
                ", address=" + address + '\'' +
                '}';
    }

    public static class Builder{
        private Long ratingId;
        private String firstName;
        private String lastName;
        private int carWashCount;
        private boolean freeWashActivated;
        private boolean freeBirthdayWash;
        private String bankName;
        private long bankAccountNumber;
        private long identificationNumber;
        private long cellPhone;
        private String email;
        private String notificationPreference;
        private String password;
        private Long customerId;
        private String carModel;
        private Address address;

        public Builder setRatingId(Long ratingId) {
            this.ratingId = ratingId;
            return this;
        }


        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setCarWashCount(int carWashCount) {
            this.carWashCount = carWashCount;
            return this;
        }

        public Builder setFreeWashActivated(boolean freeWashActivated) {
            this.freeWashActivated = freeWashActivated;
            return this;
        }

        public Builder setFreeBirthdayWash(boolean freeBirthdayWash) {
            this.freeBirthdayWash = freeBirthdayWash;
            return this;
        }

        public Builder setBankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder setBankAccountNumber(long bankAccountNumber) {
            this.bankAccountNumber = bankAccountNumber;
            return this;
        }

        public Builder setIdentificationNumber(long identificationNumber) {
            this.identificationNumber = identificationNumber;
            return this;
        }

        public Builder setCellPhone(long cellPhone) {
            this.cellPhone = cellPhone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setNotificationPreference(String notificationPreference) {
            this.notificationPreference = notificationPreference;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setCustomerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setCarModel(String carModel) {
            this.carModel = carModel;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(Customer customer){
            this.ratingId = customer.ratingId;
            this.cellPhone = customer.cellPhone;
            this.email = customer.email;
            this.identificationNumber = customer.identificationNumber;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.carWashCount = customer.carWashCount;
            this.freeWashActivated = customer.freeWashActivated;
            this.freeBirthdayWash = customer.freeBirthdayWash;
            this.bankName = customer.bankName;
            this.bankAccountNumber = customer.bankAccountNumber;
            this.carModel = customer.carModel;
            this.customerId = customer.customerId;
            this.notificationPreference = customer.notificationPreference;
            this.password = customer.password;
            this.address = customer.address;
            return this;

        }

        public Customer build(){
            return new Customer(this);
        }
    }
}
