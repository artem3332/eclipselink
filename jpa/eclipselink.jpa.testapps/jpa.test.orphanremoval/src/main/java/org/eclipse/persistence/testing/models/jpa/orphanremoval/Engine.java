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
//     05/1/2009-2.0 Guy Pelletier/David Minsky
//       - 249033: JPA 2.0 Orphan removal
package org.eclipse.persistence.testing.models.jpa.orphanremoval;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REFRESH;
import static jakarta.persistence.GenerationType.TABLE;

@Entity(name="OR_Engine")
@Table(name="JPA_OR_ENGINE")
public class Engine {
    @Id
    @GeneratedValue(strategy=TABLE, generator="JPA_OR_ENGINE_TABLE_GENERATOR")
    @TableGenerator(
        name="JPA_OR_ENGINE_TABLE_GENERATOR",
        table="JPA_ORPHAN_REMOVAL_SEQUENCE",
        pkColumnName="SEQ_NAME",
        valueColumnName="SEQ_COUNT",
        pkColumnValue="ENGINE_SEQ"
    )
    protected int id;

    protected long serialNumber;

    @OneToMany(cascade={DETACH, MERGE, PERSIST, REFRESH}, mappedBy="engine", orphanRemoval=true)
    protected List<SparkPlug> sparkPlugs; // orphanRemoval 1:M

    public Engine() {
        super();
        this.sparkPlugs = new ArrayList<>();
    }

    public Engine(long serialNumber) {
        this();
        this.serialNumber = serialNumber;
    }

    public void addSparkPlug(SparkPlug sparkPlug) {
        getSparkPlugs().add(sparkPlug);
        sparkPlug.setEngine(this);
    }

    public int getId() {
        return id;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public List<SparkPlug> getSparkPlugs() {
        return sparkPlugs;
    }

    public void removeSparkPlug(SparkPlug sparkPlug) {
        getSparkPlugs().remove(sparkPlug);
        sparkPlug.setEngine(null);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setSparkPlugs(List<SparkPlug> sparkPlugs) {
        this.sparkPlugs = sparkPlugs;
    }

    public String toString() {
        return "Engine ["+ id +"]";
    }
}
