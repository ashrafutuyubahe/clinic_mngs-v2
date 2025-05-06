
package com.Clinic.clinic_management.classes;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
class Address {

    private String district;
    private String sector;
    private String village;

}
