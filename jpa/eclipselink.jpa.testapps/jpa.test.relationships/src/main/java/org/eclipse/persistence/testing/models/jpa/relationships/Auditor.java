/*
 * Copyright (c) 1998, 2022 Oracle and/or its affiliates. All rights reserved.
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
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.testing.models.jpa.relationships;

import java.util.HashSet;
import java.util.Collection;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name="JPA_AUDITOR")
public class Auditor implements java.io.Serializable{
    private Integer id;
    private String name;
    private Collection<Order> orders = new HashSet<>();

    public Auditor() {}

    public void addOrder(Order anOrder) {
        getOrders().add(anOrder);
        anOrder.setAuditor(this);
    }

    @Id
    @GeneratedValue(strategy=TABLE, generator="AUDITOR_TABLE_GENERATOR")
    @TableGenerator(
        name="AUDITOR_TABLE_GENERATOR",
        table="JPA_AUDITOR_SEQ",
        pkColumnName="SEQ_NAME",
        valueColumnName="SEQ_COUNT",
        pkColumnValue="AUDITOR_SEQ"
    )
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @OneToMany(targetEntity=Order.class, mappedBy="auditor")
    public Collection<Order> getOrders() {
        return orders;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrders(Collection<Order> newValue) {
        this.orders = newValue;
    }

    public void removeOrder(Order anOrder) {
        getOrders().remove(anOrder);
    }
}


