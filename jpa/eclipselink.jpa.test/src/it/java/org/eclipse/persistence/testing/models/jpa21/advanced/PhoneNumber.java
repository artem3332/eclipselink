/*
 * Copyright (c) 2012, 2022 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     02/08/2012-2.4 Guy Pelletier
//       - 350487: JPA 2.1 Specification defined support for Stored Procedure Calls
package org.eclipse.persistence.testing.models.jpa21.advanced;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.io.StringWriter;

@Entity
@Table(name="JPA21_PHONENUMBER")
@IdClass(PhoneNumberPK.class)
public class PhoneNumber implements Serializable {
    private String number;
    private String type;
    private Employee owner;
    private Integer id;
    private String areaCode;

    public PhoneNumber() {
        this("", "###", "#######");
    }

    public PhoneNumber(String type, String theAreaCode, String number) {
        this.type = type;
        this.areaCode = theAreaCode;
        this.number = number;
        this.owner = null;
    }

    public PhoneNumberPK buildPK(){
        PhoneNumberPK pk = new PhoneNumberPK();
        pk.setId(this.getOwner().getId());
        pk.setType(this.getType());
        return pk;
    }

    @Column(name="AREA_CODE")
    public String getAreaCode() {
        return areaCode;
    }

    @Id
    @Column(name="OWNER_ID", insertable=false, updatable=false)
    public Integer getId() {
        return id;
    }

    @Column(name="NUMB")
    public String getNumber() {
        return number;
    }

    @ManyToOne
    @JoinColumn(name="OWNER_ID", referencedColumnName="emp_id") // <- this is testing case insensitivity
    public Employee getOwner() {
        return owner;
    }

    @Id
    @Column(name="TYPE")
    public String getType() {
        return type;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        StringWriter writer = new StringWriter();

        writer.write("PhoneNumber[");
        writer.write(getType());
        writer.write("]: (");
        writer.write(getAreaCode());
        writer.write(") ");

        int numberLength = this.getNumber().length();
        writer.write(getNumber().substring(0, Math.min(3, numberLength)));
        if (numberLength > 3) {
            writer.write("-");
            writer.write(getNumber().substring(3, Math.min(7, numberLength)));
        }

        return writer.toString();
    }
}
