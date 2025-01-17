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
//     09/23/2008-1.1 Guy Pelletier
//       - 241651: JPA 2.0 Access Type support
package org.eclipse.persistence.testing.models.jpa.xml.composite.advanced.member_3;

import java.util.*;
import java.io.Serializable;

import org.eclipse.persistence.testing.models.jpa.xml.composite.advanced.member_2.Employee;

/**
 * Bean class: ProjectBean
 * Remote interface: Project
 * Primary key class: ProjectPK
 * Home interface: ProjectHome
 *
 * {@literal >}Employees have a many-to-many relationship with Projects through the
 *  projects attribute.
 * {@literal >}Projects refer to Employees through the employees attribute.
 */
public class Project implements Serializable {
    public int pre_update_count = 0;
    public int post_update_count = 0;
    public int pre_remove_count = 0;
    public int post_remove_count = 0;
    public int pre_persist_count = 0;
    public int post_persist_count = 0;
    public int post_load_count = 0;

    private Integer id;
    private int version;
    private String name;
    private String description;
    private Employee teamLeader;
    private Collection<Employee> teamMembers;

    public Project () {
        this.teamMembers = new Vector<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(Employee teamLeader) {
        this.teamLeader = teamLeader;
    }

    public Collection<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Collection<Employee> employees) {
        this.teamMembers = employees;
    }

    public void addTeamMember(Employee employee) {
        getTeamMembers().add(employee);
    }

    public void removeTeamMember(Employee employee) {
        getTeamMembers().remove(employee);
    }

    public String displayString() {
        StringBuilder sbuff = new StringBuilder();
        sbuff.append("Project ").append(getId()).append(": ").append(getName()).append(", ").append(getDescription());

        return sbuff.toString();
    }

    public void prePersist() {
        ++pre_persist_count;
    }

    public void postPersist() {
        ++post_persist_count;
    }

    public void preRemove() {
        ++pre_remove_count;
    }

    public void postRemove() {
        ++post_remove_count;
    }

    public void preUpdate() {
        ++pre_update_count;
    }

    public void postUpdate() {
        ++post_update_count;
    }

    public void postLoad() {
        ++post_load_count;
    }
}
