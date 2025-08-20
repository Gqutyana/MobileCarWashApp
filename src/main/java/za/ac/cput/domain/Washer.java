package za.ac.cput.domain;

import jakarta.persistence.*;


/*Washer POJO class
Author: LJ Jojo (221030921)
Date: 10 May 2025 */

@Entity
@Table(name = "washers")
public class Washer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "washer_id", nullable = false, updatable = false)
    private String washerId;

    @Column(name = "availability_status", nullable = false)
    private boolean availabilityStatus;

    @Column(name = "rating", nullable = false)
    private int rating;

    // === Constructors ===
    protected Washer() {
        super(); // Required by JPA
    }

    private Washer(Builder builder) {
        super(); // Call User constructor
        this.washerId = builder.washerId;
        this.availabilityStatus = builder.availabilityStatus;
        this.rating = builder.rating;
    }

    // === Getters ===
    public String getWasherId() {
        return washerId;
    }

    public boolean isAvailable() {
        return availabilityStatus;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Washer{" +
                "washerId='" + washerId + '\'' +
                ", availabilityStatus=" + availabilityStatus +
                ", rating=" + rating +
                ", userId='" + getUserId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getCellPhone() + '\'' +
                '}';
    }

    // === Builder ===
    public static class Builder {
        // User attributes
        private String userId;
        private String firstName;
        private String lastName;
        private String email;
        private String cellPhone;

        // Washer attributes
        private String washerId;
        private boolean availabilityStatus = true;
        private int rating = 0;

        // === User setters ===
        public Builder setUserId(String userId) {
            this.userId = userId;
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

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.cellPhone = phoneNumber;
            return this;
        }

        // === Washer setters ===
        public Builder setWasherId(String washerId) {
            this.washerId = washerId;
            return this;
        }

        public Builder setAvailabilityStatus(boolean availabilityStatus) {
            this.availabilityStatus = availabilityStatus;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder copy(Washer washer) {
            this.userId = washer.getUserId();
            this.firstName = washer.getFirstName();
            this.lastName = washer.getLastName();
            this.email = washer.getEmail();
            this.cellPhone = String.valueOf(washer.getCellPhone());
            this.washerId = washer.washerId;
            this.availabilityStatus = washer.availabilityStatus;
            this.rating = washer.rating;
            return this;
        }

        public Washer build() {
            return new Washer(this);
        }
    }
}
